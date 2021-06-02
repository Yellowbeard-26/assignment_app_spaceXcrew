package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewHolder> {

    private List<Crew> crewList;
    private Context context;


    public CrewAdapter(Context context,List<Crew> crews)
    {

        this.crewList=crews;
        this.context=context;
    }
    @NonNull
    @Override
    public CrewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CrewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CrewHolder holder, int position) {
        Crew currCrew=crewList.get(position);
        holder.name.setText(currCrew.getName());
        holder.Agency.setText(currCrew.getAgency());
        holder.Status.setText(currCrew.getStatus());
        holder.wiki.setClickable(true);
        holder.wiki.setText(currCrew.getWikipedia());
       // holder.photo.setImageResource(R.drawable.ic_launcher_background);
        String img=currCrew.getImage();
        Glide.with(context).load(img).into(holder.photo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,ImageViewer.class);
                i.putExtra("url",img);
                context.startActivity(i);
            }
        });

    }
    public void getAllcrew(List<Crew> crewList)
    {
        this.crewList=crewList;
    }

    @Override
    public int getItemCount() {
        return crewList.size();
    }

    public void setCrews(List<Crew> crews)
    {
        this.crewList=crews;
        notifyDataSetChanged();
    }

    class CrewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        private TextView Status;
        private TextView Agency;
        private TextView wiki;
        private ImageView photo;

        public CrewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            Status=itemView.findViewById(R.id.Status);
            Agency=itemView.findViewById(R.id.agency);
            wiki=itemView.findViewById(R.id.wikipedia);
            photo=itemView.findViewById(R.id.imageView);
        }
    }
}
