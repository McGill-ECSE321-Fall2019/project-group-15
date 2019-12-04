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

/**
 * This class is the container for storing and retrieving Tutors
 */
public class Tutors_Activity extends AppCompatActivity {

    private static final String TAG = "Tutors_Activity";

    // variables
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mIDs = new ArrayList<>();
    private ArrayList<String> mUsernames = new ArrayList<>();
    private ArrayList<String> mHourlyRate = new ArrayList<>();
    private ArrayList<String> mIsVerified = new ArrayList<>();
    private ArrayList<String> mTutors = new ArrayList<>();

    private String error=null;

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);

        initTutorNames();

        ListView listView = (ListView) findViewById(R.id.tutorList);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mTutors);

        listView.setAdapter(arrayAdapter);

        
    }

    /**
     * Retrieve all tutors in the database upon initialization
     */
    private void initTutorNames() {
        Log.d(TAG, "initTutorNames: preparing tutor names.");

        // Restfull call: all tutors
        HttpUtils.get("allTutors/", new RequestParams(), new JsonHttpResponseHandler() {

 //           @Override
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
                            // Add Tutor Names
                            JSONObject obj1 = response.getJSONObject(i);
                            JSONObject person1 = obj1.getJSONObject("person");
                            mNames.add(person1.getString("firstName") + " " + person1.getString("lastName"));


                            // Add Tutor IDs
                            mIDs.add(response.getJSONObject(i).getString("tutorID"));

                            // add Tutor username
                          JSONObject obj = response.getJSONObject(i);
                          JSONObject person = obj.getJSONObject("person");
                          mUsernames.add(person.getString("userName"));


                            // Add Tutor hourlyRate
                            mHourlyRate.add(response.getJSONObject(i).getString("hourlyRate"));

                            // Add Tutor verified
                            mIsVerified.add(response.getJSONObject(i).getString("isVerified"));

                            mTutors.add("ID: " + mIDs.get(i) + "\nName: " + mNames.get(i) + "\nUsername: " + mUsernames.get(i) + "\nHourly Rate: " + mHourlyRate.get(i) + "\nIs Verified: " + mIsVerified.get(i));

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
