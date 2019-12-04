package ca.mcgill.ecse321.tutoringsystem;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Students_Activity extends AppCompatActivity {
    private static final String TAG = "Students_Activity";

    // variables
    /*private ArrayList<String> studentNames = new ArrayList<>();
    private ArrayList<String> studentIDs = new ArrayList<>();
    private ArrayList<String> studentUserNames = new ArrayList<>();
*/
    private ArrayList<String> students = new ArrayList<>();
    private String error=null;

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);

        initstudentNames();


        ListView listView = (ListView) findViewById(R.id.tutorList);

//        mNames.add("marwan");
//        mNames.add("osman");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, students);

        listView.setAdapter(arrayAdapter);

    }

    private void initstudentNames() {
        Log.d(TAG, "initStudentNames: preparing tutor names.");

        // Restfull call: all students
        HttpUtils.get("allStudents/", new RequestParams(), new JsonHttpResponseHandler() {

            //           @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                // Clear lists
                /*studentNames.clear();
                studentIDs.clear();
                studentUserNames.clear();
*/
                students.clear();
                for( int i = 0; i < response.length(); i++){
                    try {

                        Log.d(TAG, "Restful GET call succesfull (" + i + ").");
                        // Add Student Names
//                            mNames.add(response.getJSONObject(i).getString("firstName") + " "
//                                    + response.getJSONObject(i).getString("lastName"));


                        // Add Student IDs
                        //studentIDs.add(response.getJSONObject(i).getString("id"));

//                            // Add Student Majors & Years

                        // Get current json object

                        // add all items
                        JSONObject student = response.getJSONObject(i);
                        JSONObject person = student.getJSONObject("person");
                        students.add(student.getString("id") + " " + person.getString("firstName") + " " + person.getString("lastName") + " " + person.getString("userName"));

                    }catch (JSONException e) {
                        Log.d(TAG, e.getMessage());
                    }


                }
                arrayAdapter.notifyDataSetChanged();
            }

            //            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d(TAG, "Restful GET call failure");
                try {

                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
            }
        });

    }
}
