package com.example.findcompany;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "FindCompanyDB.db";
    private static final int SCHEMA = 1; // версия базы данных

    public DBHelper(Context context) {
        super(context, DBNAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Users ("
                + "id_user integer primary key autoincrement not null,"
                + "firstname text not null,                           "
                + "secondname text not null,                          "
                + "login text unique,                                 "
                + "password text not null                           );"
        );
        db.execSQL("create table Events ("
                + "id_event integer primary key autoincrement not null,"
                + "id_user integer not null,                           "
                + "name_event text not null,                           "
                + "place_event text not null,                          "
                + "dataAndtime_event Date not null,                    "
                + "maxParticipants_event integer not null,             "
                + " foreign key(id_user) references Users(id_user)     "
                + " on delete cascade on update cascade              );"
        );
        db.execSQL("create table ParticipationInEvents ("
                + "id_event integer primary key autoincrement not null,           "
                + "id_user integer not null,                                      "
                + "name_event text not null,                                      "
                + "place_event text not null,                                     "
                + "dataAndtime_event Date not null,                               "
                + "maxParticipants_event integer not null,                        "
                + "IsConfirm boolean not null,                                    "
                + " foreign key(id_user) references Users(id_user)                "
                + " on delete cascade on update cascade              );           "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists Users");
        onCreate(MyDB);
    }

    public Boolean insertData(String login, String password, String firstame, String secondname){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", login);
        contentValues.put("password", password);
        contentValues.put("firstname", firstame);
        contentValues.put("secondname", secondname);
        long result = MyDB.insert("Users",null, contentValues);
        if (result == 1) return  false;
        else return true;
    }

    public Boolean CheckUser(String login){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Users where login = ?", new String[] {login});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
    }

    public Boolean CheckPassword(String login, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Users where login = ? and password = ?",new String[]{login,password});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
    }
}
