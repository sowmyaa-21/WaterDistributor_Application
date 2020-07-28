package com.example.waterdistributorapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recview;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent newuser=getIntent();
        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(
                this));
        FirebaseRecyclerOptions<DealerDetails> options =
                new FirebaseRecyclerOptions.Builder<DealerDetails>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("dealerregistration"), DealerDetails.class)
                        .build();
        adapter=new MyAdapter(options);
        recview.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchmenu, menu);
        MenuItem item=menu.findItem(R.id.searchm);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processearch(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void processearch(String s){
        FirebaseRecyclerOptions<DealerDetails> options =
                new FirebaseRecyclerOptions.Builder<DealerDetails>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("dealerregistration").orderByChild("dealerlocation").startAt(s).endAt(s+"\uf8ff"), DealerDetails.class)
                        .build();
        adapter=new MyAdapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);


    }
    }


