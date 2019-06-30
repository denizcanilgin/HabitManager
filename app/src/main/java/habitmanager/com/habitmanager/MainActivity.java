package habitmanager.com.habitmanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

import habitmanager.com.habitmanager.fragments.AddTask;
import habitmanager.com.habitmanager.fragments.TaskList;
import habitmanager.com.habitmanager.fragments.fragment_other;
import taskmanager.com.taskmanager.fragments.AddTask;
import taskmanager.com.taskmanager.fragments.TaskList;
import taskmanager.com.taskmanager.fragments.fragment_other;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AddTask F1 = new AddTask();
    TaskList F2 = new TaskList();
    fragment_other F3 = new fragment_other();

    private TextView tv_date;
    Calendar calendar;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(F1,R.anim.fade_in,R.anim.fade_out);
                    return true;
                case R.id.navigation_dashboard:
                    changeFragment(F2,R.anim.fade_in,R.anim.fade_out);
                    return true;
                case R.id.navigation_notifications:
                    changeFragment(F3,R.anim.fade_in,R.anim.fade_out);
                    return true;
            }
            return false;
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_date = findViewById(R.id.tv_todaysdate);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        tv_date.setText(currentDate);

    }


    @Override
    public void onClick(View v){


    }




    public void changeFragment(Fragment fragment, int Anim1, int Anim2){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(Anim1, Anim2);
        transaction.replace(R.id.Fragment_Container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
