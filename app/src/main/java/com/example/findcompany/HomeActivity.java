package com.example.findcompany;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView listViewEvents;

    private SQLiteDatabase db;
    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        getSupportActionBar().hide();

//        binging()

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        db.close();
    }

    private void binding() {
        listViewEvents = findViewById(R.id.listViewEvents);

        db = new DBHelper(getApplicationContext()).getReadableDatabase();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_item) {
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_item1) {
            Intent intent = new Intent(getApplicationContext(), СreateActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_item2) {
            Intent intent = new Intent(getApplicationContext(), ConfirmActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_item3) {
            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_item4) {
            Intent intent = new Intent(getApplicationContext(), ActualNewsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

//    public class CustomListAdapter extends BaseAdapter {
//
//        private ArrayList<Event> events;
//        private Context context;
//
//        public CustomListAdapter(Context context, ArrayList<Event> students) {
//            this.context = context;
//            this.events = events;
//        }
//
//        @Override
//        public int getCount() {return events.size();}
//
//        @Override
//        public Object getItem(int i) {return null;}
//
//        @Override
//        public long getItemId(int i) {return 0;}
//
//        public void updateEventsList(ArrayList<Event> events) {
//            this.events.clear();
//            this.events.addAll(events);
//            this.notifyDataSetChanged();
//        }
//
////        @Override
////        public View getView(int pos, View vw, ViewGroup viewGroup) {
////            View view = getLayoutInflater().inflate(R.layout.activity_event_item, null);
////
////            TextView itemName = (TextView) view.findViewById(R.id.itemName);
////            TextView itemBirthday = (TextView) view.findViewById(R.id.itemBirthday);
////            TextView itemAddress = (TextView) view.findViewById(R.id.itemAddress);
////
////            itemName.setText(students.get(pos).getId() + " - " + students.get(pos).getName());
////            itemBirthday.setText(students.get(pos).getBirthday().toString());
////            itemAddress.setText(students.get(pos).getAddress());
////
////            view.setOnClickListener(v -> {
////                Intent intent = new Intent(StudentsActivity.this, SelectedStudentActivity.class);
////                intent.putExtra("Student", students.get(pos));
////                startActivity(intent);
////            });
////
////            return view;
////        }
//    }
//    @Override
//    public void onBackPressed() {
//        startActivity(new Intent(this, HomeActivity.class));
//    }
}