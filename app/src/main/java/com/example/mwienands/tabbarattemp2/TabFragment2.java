package com.example.mwienands.tabbarattemp2;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.CalendarView;
        import android.os.Bundle;
        import android.widget.CalendarView;
        import android.widget.CalendarView.OnDateChangeListener;
        import android.widget.Toast;
        import android.app.Activity;



public class TabFragment2 extends Fragment {
    CalendarView calendar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.tab_fragment2, container, false);
        initializeCalendar();


        return rootView;
    }
    public void initializeCalendar() {
        calendar = (CalendarView) getActivity().findViewById(R.id.calendar);

//        calendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //when clicked open a new fragment for the day to show activities you are going to attend.
//                System.out.print("why the fuck does this not work?");
//            }
//
//});
    }
}
