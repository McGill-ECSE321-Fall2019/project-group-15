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

import cz.msebera.android.httpclient.entity.mime.Header;

public class Tutors_Activity extends AppCompatActivity {

    private static final String TAG = "Tutors_Activity";

    // variables
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mIDs = new ArrayList<>();
    private ArrayList<String> mUsernames = new ArrayList<>();
    private ArrayList<String> mHourlyRate = new ArrayList<>();
    private ArrayList<String> mIsVerified = new ArrayList<>();

    private String error=null;

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initTutorNames();

        ListView listView = (ListView) findViewById(R.id.listview);
//        mNames.add("marwan");
//        mNames.add("osman");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mUsernames);

        listView.setAdapter(arrayAdapter);
        
    }

    private void initTutorNames() {
        Log.d(TAG, "initTutorNames: preparing tutor names.");

        // Restfull call: all students
        HttpUtils.get("allTutors/", new RequestParams(), new JsonHttpResponseHandler() {

//            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                // Clear lists
                mNames.clear();
                mIDs.clear();
                mUsernames.clear();
                mHourlyRate.clear();
                mIsVerified.clear();

                for( int i = 0; i < response.length(); i++){
                        try {

                            Log.d(TAG, "Restful GET call succesfull (" + i + ").");
                            // Add Student Names
                            mNames.add(response.getJSONObject(i).getString("firstName") + " "
                                    + response.getJSONObject(i).getString("lastName"));

                            arrayAdapter.notifyDataSetChanged();

                            // Add Student IDs
                            mIDs.add(response.getJSONObject(i).getString("tutorID"));

                            // Add Student Majors & Years
                            mUsernames.add(response.getJSONObject(i).getString("userName"));

                            // Add Student email
                            mHourlyRate.add(response.getJSONObject(i).getString("hourlyRate"));

                            // Add Student phone number
                            mIsVerified.add(response.getJSONObject(i).getString("isVerified"));

                        }catch (JSONException e) {
                            Log.d(TAG, e.getMessage());
                        }


                }
                arrayAdapter.notifyDataSetChanged();
            }

//            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

                try {

                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
            }
        });

    }
}
