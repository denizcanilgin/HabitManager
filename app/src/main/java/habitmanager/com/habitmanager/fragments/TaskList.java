package habitmanager.com.habitmanager.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import habitmanager.com.habitmanager.R;
import habitmanager.com.habitmanager.TaskListAdapter;
import habitmanager.com.habitmanager.Tasks;
import taskmanager.com.taskmanager.R;
import taskmanager.com.taskmanager.TaskListAdapter;
import taskmanager.com.taskmanager.Tasks;


public class TaskList extends Fragment implements View.OnClickListener {

    public static final String ARG_ITEM_ID = "favorite_list";

    private ListView lvTask;
    public  List<Tasks> mTaskList;
    private TaskListAdapter adapter;
    private GlobalClass globalClass;
    private ArrayList<Tasks> taskLists;
    Activity activity;
    Calendar calendar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        globalClass = new GlobalClass();
        calendar = Calendar.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasklist, container, false);


        taskLists = globalClass.getSavedTasks(activity);

        lvTask = (ListView) view.findViewById(R.id.listview_task);



        if (taskLists != null) {
            adapter = new TaskListAdapter(activity, taskLists);
            lvTask.setAdapter(adapter);
            lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View arg1,
                                        int position, long arg3) {


                    //single short click
                    taskLists = globalClass.getSavedTasks(activity);

                    if(taskLists.get(position).Completed == Boolean.FALSE)
                        taskLists.get(position).setCompleted(Boolean.TRUE);
                    else
                        taskLists.get(position).setCompleted(Boolean.FALSE);

                    globalClass.saveTasks(activity,taskLists);
                    adapter = new TaskListAdapter(activity, taskLists);
                    lvTask.setAdapter(adapter);
                    adapter.notifyDataSetChanged();



                }
            });

            lvTask.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                        @Override
                        public boolean onItemLongClick(
                                AdapterView<?> parent, View view,
                                int position, long id) {


                               taskLists.remove(taskLists.get(position));
                               globalClass.saveTasks(activity,taskLists);
                               lvTask.setAdapter(adapter);

                            Toast.makeText(getContext(),"deleted",0).show();
                            return true;
                        }
                    });

        }


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();



    }



    public void addTask(String taskName, Boolean copleteness){


}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.Create_Task:
//                method_create_task();
//                break;

        }
    }
}
