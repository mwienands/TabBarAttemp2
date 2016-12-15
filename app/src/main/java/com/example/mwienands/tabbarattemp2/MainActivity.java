package com.example.mwienands.tabbarattemp2;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.example.mwienands.tabbarattemp2.Event.EventContent;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements EventFragment.OnListFragmentInteractionListener {
    TableLayout event_Table;
    ArrayList catagories = new ArrayList();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





            getData();


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Events"));
        tabLayout.addTab(tabLayout.newTab().setText("Calendar"));
        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()!=0){



                }else{



                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }

    private void getData(){
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
//
        }else{

                }
            }
        });



    }

    @Override
    public void OnListFragmentInteractionListener(EventContent.EventItem dummyContent) {

    }

//
}

