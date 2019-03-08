package dk.kugelberg.hoek_helper.view.database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM data_row ORDER BY id")
    LiveData<List<DataRow>> loadAllTasks();

    @Insert
    void insertTask(DataRow taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(DataRow taskEntry);

    @Delete
    void deleteTask(DataRow taskEntry);

    @Query("SELECT * FROM data_row WHERE id = :id")
    LiveData<DataRow> loadTaskById(int id);


    // Test
    @Query("SELECT * FROM data_row ORDER BY id")
    List<DataRow> loadAll();
}