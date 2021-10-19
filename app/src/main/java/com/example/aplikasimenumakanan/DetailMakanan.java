package com.example.aplikasimenumakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMakanan extends AppCompatActivity {

    ImageView FotoMakananDet;
    TextView JudulMakanan,Deskripsi,HargaDet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);


        FotoMakananDet = findViewById(R.id.FotoMakananDet);
        JudulMakanan = findViewById(R.id.JudulMakanan);
        Deskripsi = findViewById(R.id.Deskripsi);
        HargaDet = findViewById(R.id.HargaDet);

        getIncomingExtra();
    }

    private void getIncomingExtra(){

        if(getIntent().hasExtra("Gambar") && getIntent().hasExtra("Nama") && getIntent().hasExtra("Deskripsi") && getIntent().hasExtra("Harga"));

            Integer fotomakanan = getIntent().getIntExtra("Gambar",0);
            String namamakanan = getIntent().getStringExtra("Nama");
            String deskripsi = getIntent().getStringExtra("Deskripsi");
            String harga = getIntent().getStringExtra("Harga");

            setDataActivity(fotomakanan,namamakanan,deskripsi,harga);
    }

    private void setDataActivity(Integer fotomakanan, String namamakanan, String deskripsi, String harga){

        FotoMakananDet.setImageResource(Integer.parseInt(String.valueOf(fotomakanan)));
        JudulMakanan.setText(namamakanan);
        Deskripsi.setText(deskripsi);
        HargaDet.setText(harga);

    }
}