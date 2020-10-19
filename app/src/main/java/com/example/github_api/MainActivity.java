package com.example.github_api;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.github_api.models.Repozitorij;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    String s1[], s2[];
    int images[] = {R.drawable.c_plus_plus, R.drawable.c_sharp, R.drawable.Java, R.drawable.JavaScript, R.drawable.Kotlin, R.drawable.python};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Repozitorij repos[];

        recyclerView=findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.repository);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter  = new MyAdapter(this,s1,s2,images);
    }

}