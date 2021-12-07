package com.example.findcompany;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

    public final int id_event;
    public final int id_user;
    public String name_event;
    public String place_event;
    public String dataAndtime_event;
    public int maxParticipants_event;

    public Event(int id_event,int id_user, String name_event, String place_event, String dataAndtime_event, int maxParticipants_event) {
        this.id_event = id_event;
        this.id_user = id_user;
        this.place_event = place_event;
        this.name_event = name_event;
        this.dataAndtime_event = dataAndtime_event;
        this.maxParticipants_event = maxParticipants_event;
    }
}

// db.execSQL("create table Events ("
//         + "id_event integer primary key autoincrement not null,"
//         + "id_user integer not null,                           "
//         + "name_event text not null,                           "
//         + "place_event text not null,                          "
//         + "dataAndtime_event Date not null,                    "
//         + "maxParticipants_event integer not null,             "
//         + " foreign key(id_user) references Users(id_user)     "
//         + " on delete cascade on update cascade              );"
