package com.example.mwienands.tabbarattemp2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mwienands on 12/14/16.
 */

public class FetchData extends Application {
    public void getData() {
        //init the connection to the parse server

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("DBPoKTgalzSK4aNDQGSx9GDgdCKjwW4ohnj0uNTj")
                .clientKey("LcCBx9dDkE4rxkqecTadWMMSKtuvAaClqoLhrbSN")
                .server("https://parseapi.back4app.com/").build()
        );
        // que data.


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                   processData(objects);
                } else {

                }
            }
        });
    }

    public FetchData() {
    }

    public void processData(List<ParseObject> objects){
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        ArrayList<String> events = new ArrayList<>();
        ArrayList<String> Categories = new ArrayList<>();
        ArrayList<String> Descriptions = new ArrayList<>();
        for(int i =0; i<objects.size(); i++){
            events.add(objects.get(i).get("Event").toString());
            if(!Categories.contains(objects.get(i).get("TypeOfEvent").toString())){
                Categories.add(objects.get(i).get("TypeOfEvent").toString());
            }
            Descriptions.add(objects.get(i).get("Description").toString());
        }
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Set<String> eventSet = new HashSet<>(events);
        editor.putStringSet("Events",eventSet);
        Set<String> CategoriesSet = new HashSet<>(Categories);
        editor.putStringSet("Categories",CategoriesSet);
        Set<String> DescriptionSet = new HashSet<>(Descriptions);
        editor.putStringSet("Descriptions",DescriptionSet);
        editor.commit();

    }

}
