package com.example.aplikasimenumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recKuliner;
    private ArrayList<Kuliner> listKuliner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recKuliner = findViewById(R.id.rec_kuliner);
        initData();

        recKuliner.setAdapter(new KulinerAdapter(listKuliner));
        recKuliner.setLayoutManager(new LinearLayoutManager(this));


    }

    private void initData(){
        this.listKuliner = new ArrayList<>();
        listKuliner.add(new Kuliner("Sate Ayam",
                "Rp. 20.000",
                "Sate Ayam 10 Tusuk",
                R.drawable.ayam));

        listKuliner.add(new Kuliner("Sate Kambing",
                "Rp. 20.000",
                "Sate Kambing 10 Tusuk",
                R.drawable.kambing));

        listKuliner.add(new Kuliner("Es Teh",
                "Rp. 20.000",
                "Es Teh",
                R.drawable.teh));
    }
}