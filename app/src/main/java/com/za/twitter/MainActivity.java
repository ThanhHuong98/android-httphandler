package com.za.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    HttpHandler handler;

    ListView lv;
    CustomAdapter adapter;

    ArrayList<User> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.list);

        new GetUsers().execute();

    }




    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    private  class GetUsers extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute(){
            //Code to run before executing the task

        }

        @Override
        protected Void doInBackground(Void... voids) {
            //Code that you want to run in a background thread
            handler = new HttpHandler();
            String jsonStr = handler.makeServiceUsers(Constant.USER_API);
            Log.e(TAG, "JSON String: " + jsonStr);

            String json = "{'_id': 1001,"
                    + "'first_name': 'Lokesh',"
                    + "'last_name': 'Gupta',"
                    + "'email': 'howtodoinjava@gmail.com'}";

         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         UserWrapper userWrapper = gson.fromJson(jsonStr, UserWrapper.class);
           // User userWrapper = gson.fromJson(json, User.class);

            Log.e(TAG, "userWrapper: " + userWrapper.getUsers());

           userList = userWrapper.getUsers();
           // userList.addAll(Arrays.asList(users));
            return null;
        }

        protected void onProgressUpdate(Void... value){
            //Code that you want to run to publish the progress of your task
        }

        protected void onPostExecute(Void result) {
            //Code that you wan to run when the task is complete
            super.onPostExecute(result);

            adapter = new CustomAdapter(userList, MainActivity.this);
            lv.setAdapter(adapter);
        }

    }
}
