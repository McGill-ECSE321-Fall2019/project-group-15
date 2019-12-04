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
 * This class is the container for storing and retrieving Rooms
 */
public class Rooms_Activity extends AppCompatActivity  {
    private String error = null;
    private static final String TAG = "Rooms_Activity";

   // private ArrayList<String> roomName = new ArrayList<>();
    private ArrayList<String> room = new ArrayList<>();

    private  ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        // INSERT TO END OF THE METHOD AFTER AUTO-GENERATED CODE
        // initialize error message text view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);

        initRooms();

        ListView listView = (ListView) findViewById(R.id.tutorList);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, room);

        listView.setAdapter(arrayAdapter);

    }

    /**
     * Retrieve all rooms in the database upon initialization
     */
    private void initRooms() {
        Log.d(TAG, "initTutorNames: preparing tutor names.");

        // Restfull call: all rooms
        HttpUtils.get("getAllRooms/", new RequestParams(), new JsonHttpResponseHandler() {

            //           @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                // Clear lists
              //roomName.clear();
              //roomSize.clear();
                room.clear();

                for( int i = 0; i < response.length(); i++){
                    try {

                        Log.d(TAG, "Restful GET call succesfull (" + i + ").");

                        room.add(response.getJSONObject(i).getString("roomName") + "  " +response.getJSONObject(i).getString("roomType"));

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
