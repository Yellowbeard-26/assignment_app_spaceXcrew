package com.example.assignment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    private CrewViewModel crewViewModel;
    CrewDatabase crewDatabase;
    List<CrewData> crewDataList;
    private CrewAdapter crewAdapter;
    private List<Crew> crewList;
    private CrewRepository crewRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button del = (Button) findViewById(R.id.delete);
        Button ref = (Button) findViewById(R.id.refresh);

        RecyclerView recyclerView = findViewById(R.id.recy_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        crewRepository = new CrewRepository(getApplication());
        crewList = new ArrayList<>();
        CrewAdapter adapter = new CrewAdapter(this, crewList);

        crewViewModel = new ViewModelProvider(this).get(CrewViewModel.class);
        crewViewModel.getAllCrew().observe(this, new Observer<List<Crew>>() {
            @Override
            public void onChanged(List<Crew> crews) {
                adapter.getAllcrew(crews);
                recyclerView.setAdapter(adapter);
                Log.e("main", "onChanged: "+crews);

                ;
            }
        });

        networkrequest();
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CrewRepository crewRepository=new CrewRepository(getApplication());
                crewRepository.deleteall();


            }
        });
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                networkrequest();
            }
        });
    }

    private void networkrequest() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.spacexdata.com/v4/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<Crew>> call = api.getdata();

        call.enqueue(new Callback<List<Crew>>() {
            @Override
            public void onResponse(Call<List<Crew>> call, Response<List<Crew>> response) {
                if (response.isSuccessful()) {
                    crewRepository.insert(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Crew>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"You are Offline",Toast.LENGTH_SHORT).show();


            }
        });

    }
}


