package com.example.findcompany.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.findcompany.Database.DBHelper;
import com.example.findcompany.Event;
import com.example.findcompany.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Integer id;
    private ListView listViewEvents;

    private SQLiteDatabase db;
    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //getSupportActionBar().hide();

        Bundle arguments = getIntent().getExtras();
        id = ((Integer) arguments.get("id"));
        Log.d("myTag", String.valueOf(id));

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
            intent.putExtra("id", id);
            startActivity(intent);
        }
        else if (id == R.id.action_item1) {
            Intent intent = new Intent(getApplicationContext(), СreateActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
        else if (id == R.id.action_item2) {
            Intent intent = new Intent(getApplicationContext(), ConfirmActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
        else if (id == R.id.action_item3) {
            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
        else if (id == R.id.action_item4) {
            Intent intent = new Intent(getApplicationContext(), ToDoListActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
        else if (id == R.id.action_item5) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("id", id);
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