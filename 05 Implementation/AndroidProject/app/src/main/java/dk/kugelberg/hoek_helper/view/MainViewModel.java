package dk.kugelberg.hoek_helper.view;

import android.app.Application;
import android.util.Log;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import dk.kugelberg.hoek_helper.view.database.AppDatabase;
import dk.kugelberg.hoek_helper.view.database.DataRow;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<DataRow>> tasks;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<DataRow>> getTasks() {
        return tasks;
    }
}
