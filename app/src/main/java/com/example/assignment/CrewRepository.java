package com.example.assignment;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CrewRepository {

    private CrewDatabase database;
    //private CrewDao crewDao;
    private LiveData<List<Crew>> allCrew;

    public CrewRepository(Application application)
    {
        database=CrewDatabase.getInstance(application);
        allCrew=database.crewDao().getAllcrew();
    }

    public void insert(List<Crew> crewList)
    {
        new InsertCrewAsyncTask(database).execute(crewList);
    }
    public void deleteall()
    {
        new DeleteCrewAsyncTask(database).execute();
    }
    public LiveData<List<Crew>> getAllCrew()
    {
        return allCrew;

    }

    private static class InsertCrewAsyncTask extends AsyncTask<List<Crew>,Void,Void>
    {
        private CrewDao crewDao;

         InsertCrewAsyncTask(CrewDatabase database) {
            crewDao = database.crewDao();
        }
        @Override
        protected Void doInBackground(List<Crew>... lists) {
             crewDao.insert(lists[0]);
            return null;
        }
    }
    private static class DeleteCrewAsyncTask extends AsyncTask<List<Crew>,Void,Void>
    {
        private CrewDao crewDao;

        private DeleteCrewAsyncTask(CrewDatabase database)
        {
            crewDao=database.crewDao();
        }


        @Override
        protected Void doInBackground(List<Crew>... lists) {
            crewDao.deletefull();
            return null;
        }
    }
}
