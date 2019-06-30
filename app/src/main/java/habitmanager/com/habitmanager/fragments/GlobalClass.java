package habitmanager.com.habitmanager.fragments;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import taskmanager.com.taskmanager.Tasks;

class GlobalClass extends Application {

    public static final String PREFS_NAME = "TASK_APP";
    public static final String TASKSAVED = "Task_Saved";

    public GlobalClass() {
        super();
    }

    private List<Tasks> tasksList;

    public void saveTasks(Context context, List<Tasks> TasksList) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson(); //create a json
        String jsonTaskList = gson.toJson(TasksList); //convert list to json
        editor.putString(TASKSAVED, jsonTaskList); // store as json in shared pref
        editor.commit(); // commit

    }

    public void addTask (Context context, Tasks task) {
        List<Tasks> tasksList = getSavedTasks(context);
        if (tasksList == null)
            tasksList = new ArrayList<Tasks>();
        tasksList.add(task);
        saveTasks(context, tasksList);
    }


    public void removeTask(Context context, Tasks task) {
        ArrayList<Tasks> tasksList = getSavedTasks(context);
        if (tasksList != null) {
            tasksList.remove(task);
            saveTasks(context, tasksList);
        }
    }



    public ArrayList<Tasks> getSavedTasks(Context context) {
        SharedPreferences settings;
        List<Tasks> tasksList;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(TASKSAVED)) {
            String jsonTasks = settings.getString(TASKSAVED, null);
            Gson gson = new Gson();
            Tasks[] taskItems = gson.fromJson(jsonTasks,
                    Tasks[].class);

            tasksList = Arrays.asList(taskItems);
            tasksList = new ArrayList<Tasks>(tasksList);
        } else
            return null;

        return (ArrayList<Tasks>) tasksList;
    }




    public List<Tasks> getGlobalList() {
        return tasksList;
    }

    public void setGlobalList(List<Tasks> value) {
        tasksList = value;
    }
}
