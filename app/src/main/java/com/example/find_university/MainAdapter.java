package com.example.find_university;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {
    private List<MainModel> filteredList;
    private FirebaseRecyclerOptions<MainModel> options;


    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
        filteredList = new ArrayList<>();
    }

    public void setFilteredList(List<MainModel> filteredList) {
        this.filteredList = filteredList;
        notifyDataSetChanged();
    }



    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        MainModel item;
        if (filteredList.size() > 0) {
            item = filteredList.get(position);
        } else {
            item = model;
        }

        // Bind data to views
        // ...
        holder.name.setText(item.getName());
        holder.country.setText("Country: " + item.getCountry());
        holder.cgpa.setText("Minimum CGPA: " + item.getCgpa());
        holder.area.setText("Total area: " + item.getArea() + " acres");
        holder.ielts.setText("IELTS score: " + item.getIelts());
        holder.student.setText("Total Student: " + item.getStudent());
        holder.fee.setText("Tuition fee per year: " + item.getFee() + " $");
        holder.rank.setText("Ranking: " + item.getRank());

        Glide.with(holder.img.getContext())
                .load(item.getUrl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_text_disabled)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView name, country, cgpa, area, ielts, student, fee, rank;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.nameText);
            country = itemView.findViewById(R.id.countryText);
            cgpa = itemView.findViewById(R.id.cgpaText);
            area = itemView.findViewById(R.id.areaText);
            ielts = itemView.findViewById(R.id.ieltsText);
            student = itemView.findViewById(R.id.studentText);
            fee = itemView.findViewById(R.id.feeText);
            rank = itemView.findViewById(R.id.rankText);
        }
    }
}
