package com.example.assignment;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Crew.class},version = 2)
public abstract class CrewDatabase extends RoomDatabase {
    private static final String TAG = "CrewDatabase";
    //private static CrewDatabase instance;
    //private static Context Activity;

    public abstract CrewDao crewDao();

    public static volatile CrewDatabase INSTANCE;

    public static synchronized CrewDatabase getInstance(Context context) {
        //Activity = context.getApplicationContext();
        if (INSTANCE == null) {

            synchronized (CrewDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, CrewDatabase.class, "crew_Database")
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

   static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE);
        }
    };

//    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDbAsyncTask(instance).execute();
//        }
//    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CrewDao crewDao;
        private PopulateDbAsyncTask(CrewDatabase db) {
            crewDao = db.crewDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

           crewDao.deletefull();
            return null;
        }
    }
}

//        private static void hh(Context context)
//        {
//            CrewDao dao=getInstance(context).crewDao();
//
//            JSONArray crew=loadJSONArray(context);
//
//            try{
//                for(int i=0;i<crew.length();i++)
//                {
//                    JSONObject c=crew.getJSONObject(i);
//
//                    String name=c.getString("name");
//                    String agency=c.getString("agency");
//                    String image=c.getString("image");
//                    String wiki=c.getString("wikipedia");
//                    String status=c.getString("status");
//
//                    dao.insert(new Crew(name,agency,image,wiki,status));
//
//                }
//
//            }catch (JSONException e)
//            {
//
//            }
//        }
//        private static JSONArray loadJSONArray(Context context)
//        {
//            StringBuilder builder=new StringBuilder();
//            InputStream in=context.getResources().openRawResource(R.raw.crewlist);
//            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
//
//            String line;
//
//            try
//            {
//                while((line=reader.readLine()) !=null)
//                {
//                    builder.append(line);
//                }
//                JSONObject json=new JSONObject(builder.toString());
//                return  json.getJSONArray("crewlist");
//            }
//            catch (IOException| JSONException exception)
//            {
//                exception.printStackTrace();
//            }
//            return null;
//        }
//    }


