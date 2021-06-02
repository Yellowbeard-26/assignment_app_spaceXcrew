package com.example.assignment;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CrewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Crew> crewList);


    @Query("SELECT * FROM crew_table ORDER BY name ASC")
    LiveData<List<Crew>> getAllcrew();

    @Query("DELETE FROM crew_table")
    void deletefull();


}
