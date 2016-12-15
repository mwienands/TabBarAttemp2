package com.example.mwienands.eventago;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.example.mwienands.eventago.Event.EventContent;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements EventFragment.OnListFragmentInteractionListener {
    TableLayout event_Table;
    ArrayList catagories = new ArrayList();
    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.mwienands.eventago.R.layout.activity_main);

        FetchData fd = new FetchData();




        TabLayout tabLayout = (TabLayout) findViewById(com.example.mwienands.eventago.R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Events"));
        tabLayout.addTab(tabLayout.newTab().setText("Calendar"));
        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(com.example.mwienands.eventago.R.id.pager);
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



    @Override
    public void OnListFragmentInteractionListener(EventContent.EventItem dummyContent) {

    }

//
}

