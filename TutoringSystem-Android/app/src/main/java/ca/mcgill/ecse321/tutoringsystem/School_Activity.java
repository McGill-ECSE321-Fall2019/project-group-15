package ca.mcgill.ecse321.tutoringsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

/**
 * This class is the container for storing and retrieving Schools
 */
public class School_Activity extends AppCompatActivity {

    private String error = null;
    private static final String TAG = "School_Activity";

    // private ArrayList<String> roomName = new ArrayList<>();
    private ArrayList<String> school = new ArrayList<>();

    private  ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        // INSERT TO END OF THE METHOD AFTER AUTO-GENERATED CODE
        // initialize error message text view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);

        initCourses();

        ListView listView = (ListView) findViewById(R.id.tutorList);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, school);

        listView.setAdapter(arrayAdapter);

    }

    /**
     * Retrieve all schools in the database upon initialization
     */
    private void initCourses() {
        Log.d(TAG, "initSchool: preparing school names.");

        // Restfull call: all schools
        HttpUtils.get("allSchools/", new RequestParams(), new JsonHttpResponseHandler() {

            //           @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                // Clear lists
                //roomName.clear();
                //roomSize.clear();
                school.clear();

                for( int i = 0; i < response.length(); i++){
                    try {

                        Log.d(TAG, "Restful GET call succesfull (" + i + ").");

                        school.add(response.getJSONObject(i).getString("schoolName") + "  " +response.getJSONObject(i).getString("schoolType"));

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
