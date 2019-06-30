package habitmanager.com.habitmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Tasks> {

    TextView taskName;
    TextView completed;
    TextView taskDesc;


    private Context mContext;
    private List<Tasks> mTaskList;
    private LayoutInflater layoutInflater;


    public TaskListAdapter(Context mContext, List<Tasks> mTaskList) {
        super(mContext,R.layout.item_task_list,mTaskList);
        this.mContext = mContext;
        this.mTaskList = mTaskList;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mTaskList.size();
    }

    @Override
    public Tasks getItem(int position) {
        return mTaskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(mContext, R.layout.item_task_list, null);
        taskName = (TextView) convertView.findViewById(R.id.task_name);
        completed = (TextView) convertView.findViewById(R.id.completed);
        taskDesc = (TextView) convertView.findViewById(R.id.task_description);

        taskName.setText(mTaskList.get(position).getTaskName());
        completed.setText(mTaskList.get(position).getCompleted().toString());
        taskDesc.setText(mTaskList.get(position).getTaskDesc());

        convertView.setTag(mTaskList.get(position).getTaskName());

        return convertView;
    }




    @Override
    public void add(Tasks task) {
        super.add(task);
        mTaskList.add(task);
        notifyDataSetChanged();
    }


    @Override
    public void remove(Tasks task) {
        super.remove(task);
        mTaskList.remove(task);
        notifyDataSetChanged();
    }



}
