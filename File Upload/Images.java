package com.example.fileupload;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import kotlin.collections.ArrayDeque;

public class Images extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private ProgressBar progressBarCircle;
    private DatabaseReference databaseReference;
    private List<Upload> uploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images2);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBarCircle = findViewById(R.id.progress_bar);

        uploads = new ArrayDeque<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for(DataSnapshot postSnapshot : snapshot.getChildren()){
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploads.add(upload);
                }
                adapter = new ImageAdapter(Images.this, uploads);
                recyclerView.setAdapter(adapter);
                progressBarCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(Images.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressBarCircle.setVisibility(View.INVISIBLE);
            }
        });
    }
}