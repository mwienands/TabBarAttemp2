package com.example.mwienands.tabbarattemp2;



import android.graphics.Color;
import android.icu.util.RangeValueIterator;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.PushService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    TableLayout event_Table;
    ArrayList catagories = new ArrayList();
    private boolean parseActive = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final RelativeLayout rl = (RelativeLayout) findViewById(R.id.Header);
          rl.setVisibility(View.GONE);

        if(!parseActive) {
            getData();
        }

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

                    rl.setVisibility(View.VISIBLE);

                }else{

                    rl.setVisibility(View.GONE);

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
//                     processData(objects);
        }else{

                }
            }
        });



    }

//    private void processData(List<ParseObject> objects) {
//        TableRow row;
//        TextView t1;
//        int dip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                (float) 1, getResources().getDisplayMetrics());
//        for(int i= 0; i<objects.size();i++){
//
//            row = new TableRow(this);
//
//            t1 = new TextView(this);
//            t1.setTextColor(Color.parseColor("#9b9b9b"));
//            t1.setText(objects.get(i).getString("TypeOfEvent"));
//            // t1.setTextColor();
//            t1.setTypeface(null, 1);
//            t1.setTextSize(28);
//            t1.setWidth(dip);
//            t1.setPadding(dip, 0, 0, 0);
//            row.addView(t1);
//            t1.setGravity(1);
//            t1.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    TextView t = (TextView) view;
//                    String holder = (String)t.getText();
//                    System.out.print("tapped a number");
//
//                }
//            });
//            event_Table.addView(row, new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        }
//
//
//    }

//    void populateTable() {
//        TableRow row;
//        TextView t1;
//
//        int dip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                (float) 1, getResources().getDisplayMetrics());
//
//
//        for (int i = 0; i <catagories.size(); i++) {
//            row = new TableRow(this);
//
//            t1 = new TextView(this);
//            t1.setTextColor(Color.parseColor("#9b9b9b"));
//            t1.setText(catagories.get(i).toString());
//            // t1.setTextColor();
//            t1.setTypeface(null, 1);
//            t1.setTextSize(28);
//            t1.setWidth(dip);
//            t1.setPadding(dip, 0, 0, 0);
//            row.addView(t1);
//            t1.setGravity(1);
//            t1.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    TextView t = (TextView) view;
//                    String holder = (String)t.getText();
//                    System.out.print("tapped a number");
//
//                }
//            });
//
//
//            event_Table.addView(row, new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//
//        }
//
//
//
//    }
}

