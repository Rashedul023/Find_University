package com.example.find_university;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class Filter_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    EditText country,rank,cgpa,fee;
    Button buttonCountry,buttonRank,buttonFee, buttonCgpa;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));
        getWindow().setStatusBarColor(ContextCompat.getColor(Filter_Activity.this,R.color.mainColor2));

        cgpa = (EditText) findViewById(R.id.cgpaFilter);
        fee = (EditText) findViewById(R.id.feeFilter);
        country =(EditText) findViewById(R.id.countryFilter);
        rank = (EditText) findViewById(R.id.rankFilter);

        buttonCgpa =(Button) findViewById(R.id.buttonCgpa);
        buttonFee = (Button) findViewById(R.id.buttonFee);
        buttonRank=(Button) findViewById(R.id.buttonRank);
        buttonCountry= (Button)findViewById(R.id.buttonCountry);

        recyclerView = (RecyclerView) findViewById(R.id.rvl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                ,MainModel.class)
                        .build();
        mainAdapter = new MainAdapter(options);


        buttonCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cf = country.getText().toString();


                if(cf.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please input a Country", Toast.LENGTH_SHORT).show();
                }
                FirebaseRecyclerOptions<MainModel> options =
                        new FirebaseRecyclerOptions.Builder<MainModel>()
                                .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                .orderByChild("country").equalTo(cf)
                                        ,MainModel.class)
                                .build();
                mainAdapter = new MainAdapter(options);
                recyclerView.setAdapter(mainAdapter);
                mainAdapter.startListening();
            }
        });

        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rf = rank.getText().toString();


                if(rf.isEmpty()){
                    Toast.makeText(getApplicationContext(), rf+"Please input Ranking", Toast.LENGTH_SHORT).show();
                }
                else {
                    double rankFilter = Double.parseDouble(rank.getText().toString().trim());

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("rank").endAt(rankFilter)
                                            , MainModel.class)
                                    .build();
                    mainAdapter = new MainAdapter(options);
                    recyclerView.setAdapter(mainAdapter);
                    mainAdapter.startListening();
                }
            }
        });

        buttonFee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ff = fee.getText().toString();

                if(ff.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please input Tuition Fee", Toast.LENGTH_SHORT).show();
                }

                else {
                    double feeFilter = Double.parseDouble(fee.getText().toString().trim());
                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("fee").endAt(feeFilter)
                                            , MainModel.class)
                                    .build();
                    mainAdapter = new MainAdapter(options);
                    recyclerView.setAdapter(mainAdapter);
                    mainAdapter.startListening();
                }
            }
        });

        buttonCgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cgf = cgpa.getText().toString();

                if(cgf.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please input CGPA", Toast.LENGTH_SHORT).show();
                }

                else {
                    double cgpaFilter = Double.parseDouble(cgpa.getText().toString().trim());
                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("cgpa").endAt(cgpaFilter)
                                            , MainModel.class)
                                    .build();
                    mainAdapter = new MainAdapter(options);
                    recyclerView.setAdapter(mainAdapter);
                    mainAdapter.startListening();
                }
            }
        });




        
    }



    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }



}