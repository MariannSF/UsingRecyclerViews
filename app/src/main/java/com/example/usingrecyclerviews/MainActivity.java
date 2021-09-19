package com.example.usingrecyclerviews;
/*
https://web.archive.org/web/20200924101148/https://developer.android.com/guide/topics/ui/layout/recyclerview
 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> users = new ArrayList<>();
    RecyclerView recyclerView ;
    LinearLayoutManager layoutManager;
    //Create an instance of the adapter
    UserRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("Bob Smith", 20));
        users.add(new User("Anna Brown", 28));
        users.add(new User("Ellis Yellow", 2));
        users.add(new User("Mariann Hello", 22));
        users.add(new User("Jerry Red" , 20));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        /*Recycle view needs a layout manager
        The layoutManager dictates how the items will be layedout in the screen
        grid layout or linear ect., horizontally

         */
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //we also need to ad adapter

        adapter = new UserRecyclerViewAdapter(users);
        recyclerView.setAdapter(adapter);



    }
}