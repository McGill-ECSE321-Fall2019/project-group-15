package ca.mcgill.ecse321.tutoringsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

//    private String error = null;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        listView = (ListView) findViewById(R.id.listview);
        final String[] values = new String[]{"Tutors", "Students", "Courses", "Rooms", "School", "Evaluations"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent myIntent = new Intent(view.getContext(), Tutors_Activity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==3) {
                    Intent myIntent = new Intent(view.getContext(), Rooms_Activity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==2) {
                    Intent myIntent = new Intent(view.getContext(), Courses_Activity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==4) {
                    Intent myIntent = new Intent(view.getContext(), School_Activity.class);
                }
                if(position==1){
                    Intent myIntent = new Intent(view.getContext(), Students_Activity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==5){
                    Intent myIntent = new Intent(view.getContext(), Evaluations_Activity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

//        refreshErrorMessage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private void refreshErrorMessage() {
//        // set the error message
//        TextView tvError = (TextView) findViewById(R.id.error);
//        tvError.setText(error);
//
//        if (error == null || error.length() == 0) {
//            tvError.setVisibility(View.GONE);
//        } else {
//            tvError.setVisibility(View.VISIBLE);
//        }
//    }
}
