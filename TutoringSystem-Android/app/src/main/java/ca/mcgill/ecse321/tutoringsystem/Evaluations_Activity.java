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

public class Evaluations_Activity extends AppCompatActivity {
    private static final String TAG = "Evaluations_Activity";
    private String error=null;

    // variables
    private ArrayList<String> mIDs = new ArrayList<>();
    private ArrayList<String> mComments = new ArrayList<>();
    private ArrayList<String> mTypes = new ArrayList<>();
    private ArrayList<String> mRatings = new ArrayList<>();
    private ArrayList<String> mIsFlagged = new ArrayList<>();
    private ArrayList<String> mStudentNames = new ArrayList<>();
    private ArrayList<String> mTutorNames = new ArrayList<>();

    private ArrayList<String> mEvaluations = new ArrayList<>();

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEvaluationNames();

        ListView listView = (ListView) findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mEvaluations);

        listView.setAdapter(arrayAdapter);

    }

    private void initEvaluationNames() {
        Log.d(TAG, "initEvaluations: preparing evaluations.");

        // Restfull call: all students
        HttpUtils.get("allEvaluations/", new RequestParams(), new JsonHttpResponseHandler() {

//            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                // Clear lists
                mIDs.clear();
                mRatings.clear();
                mTypes.clear();
                mStudentNames.clear();
                mTutorNames.clear();
                mIsFlagged.clear();
                mComments.clear();

                for( int i = 0; i < response.length(); i++){
                    try {
                        Log.d(TAG, "Evaluation Restful GET call successful (" + i + ").");

                        JSONObject obj1 = response.getJSONObject(i);

                        mIDs.add(obj1.getString("id"));
                        mComments.add(response.getJSONObject(i).getString("comment"));
                        mRatings.add(obj1.getString("rating"));
                        mTypes.add(obj1.getString("type"));
                        mIsFlagged.add(obj1.getString("flagged"));

                        JSONObject student1 = obj1.getJSONObject("student");
                        JSONObject tutor1 = obj1.getJSONObject("tutor");

                        JSONObject personStudent = student1.getJSONObject("person");
                        JSONObject personTutor = tutor1.getJSONObject("person");

                        mStudentNames.add(personStudent.getString("firstName") + " " + personStudent.getString("lastName"));
                        mTutorNames.add(personTutor.getString("firstName") + " " + personTutor.getString("lastName"));

                        mEvaluations.add("id: " + mIDs.get(i) + ", comment: " + mComments.get(i) + ", rating: " + mRatings.get(i) + ", student: " + mStudentNames.get(i) + ", tutor: " + mTutorNames.get(i) + ", type: " + mTypes.get(i) + ", flagged: " + mIsFlagged.get(i));

                    }catch (JSONException e) {
                        Log.d(TAG, e.getMessage());
                    }


                }
                arrayAdapter.notifyDataSetChanged();
            }

//            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d(TAG, "Evaluation Restful GET call failure");
                try {

                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
            }
        });

    }
}

