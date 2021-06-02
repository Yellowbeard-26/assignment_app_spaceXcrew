package com.example.assignment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CrewViewModel extends AndroidViewModel {
    private CrewRepository repository;
    private LiveData<List<Crew>> allCrew;

    public CrewViewModel(@NonNull Application application)
    {
        super(application);
        repository=new CrewRepository(application);
        allCrew=repository.getAllCrew();
    }
    public void insert(List<Crew> crewList)
    {
        repository.insert(crewList);
    }
    public LiveData<List<Crew>> getAllCrew()
    {
        return allCrew;
    }
}
