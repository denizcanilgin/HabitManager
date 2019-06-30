package habitmanager.com.habitmanager.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import taskmanager.com.taskmanager.R;
import taskmanager.com.taskmanager.TaskListAdapter;
import taskmanager.com.taskmanager.Tasks;


public class AddTask extends Fragment implements View.OnClickListener {


    EditText et_taskname;
    EditText et_taskdesc;

    Button bt_createtask;

    private ListView lvTask;
    public List<Tasks> mTaskList;
    private TaskListAdapter adapter;
    GlobalClass globalClass;
    Activity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addtask, container, false);


        et_taskname = view.findViewById(R.id.et_taskname);
        et_taskdesc = view.findViewById(R.id.et_taskdesc);
        bt_createtask = view.findViewById(R.id.bt_createtask);
        bt_createtask.setOnClickListener(this);


        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        globalClass = new GlobalClass();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bt_createtask:
                mTaskList = new ArrayList<Tasks>();
                Tasks new_task = new Tasks("" + et_taskname.getText(), Boolean.FALSE,et_taskdesc.getText().toString());
                Toast.makeText(activity, "added", 0).show();
                globalClass.addTask(activity,new_task);
                break;

        }
    }
}
