package habitmanager.com.habitmanager;

import android.content.Context;
import android.widget.Toast;

import java.util.Stack;

public class Tasks {

    public String TaskName;
    public String TaskDesc;
    public Boolean Completed;

    public Tasks(String taskName, Boolean completed, String taskdesc) {
        TaskName = taskName;
        Completed = completed;
        TaskDesc = taskdesc;
    }

    public String getTaskDesc() {
        return TaskDesc; }

    public void setTaskDesc(String taskDesc) {
        TaskDesc = taskDesc; }

    public String getTaskName() {
        return TaskName;
    }

    public Boolean getCompleted() {
        return Completed;
    }

    public void setCompleted(Boolean completed) {
        Completed = completed;
    }
}
