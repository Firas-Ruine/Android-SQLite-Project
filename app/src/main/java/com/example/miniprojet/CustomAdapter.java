package com.example.miniprojet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList user_id, user_firstname, user_lastname, user_age;

    CustomAdapter(Activity activity, Context context, ArrayList user_id, ArrayList user_firstname, ArrayList user_lastname,
                  ArrayList user_age){
        this.activity = activity;
        this.context = context;
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_age = user_age;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView")final int position) {
        holder.user_id_txt.setText(String.valueOf(user_id.get(position)));
        holder.user_firstname_txt.setText(String.valueOf(user_firstname.get(position)));
        holder.user_lastname_txt.setText(String.valueOf(user_lastname.get(position)));
        holder.user_age_txt.setText(String.valueOf(user_age.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(user_id.get(position)));
                intent.putExtra("firstname", String.valueOf(user_firstname.get(position)));
                intent.putExtra("lastname", String.valueOf(user_lastname.get(position)));
                intent.putExtra("age", String.valueOf(user_age.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_id_txt, user_firstname_txt, user_lastname_txt,user_age_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id_txt = itemView.findViewById(R.id.user_id_txt);
            user_firstname_txt = itemView.findViewById(R.id.user_firstname_txt);
            user_lastname_txt = itemView.findViewById(R.id.user_lastname_txt);
            user_age_txt = itemView.findViewById(R.id.user_age_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}