package com.example.aplikasimenumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.ViewHolder> {
    Context context;

    public KulinerAdapter(ArrayList<Kuliner> listkuliner) {
        this.listkuliner = listkuliner;
    }
    private ArrayList<Kuliner> listkuliner;

    @NonNull
    @Override
    public KulinerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_kuliner,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KulinerAdapter.ViewHolder holder, int position) {
        Kuliner kuliner = listkuliner.get(position);

        holder.txtNama.setText(kuliner.getNama());
        holder.txtharga.setText(kuliner.getHarga());
        holder.imgFoto.setImageResource(kuliner.getId_gambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailMakanan.class);


                intent.putExtra("Gambar",kuliner.getId_gambar());
                intent.putExtra("Nama",kuliner.getNama());
                intent.putExtra("Deskripsi",kuliner.getDeskripsi());
                intent.putExtra("Harga",kuliner.getHarga());

                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return listkuliner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama,txtharga;
        public ImageView imgFoto;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama =(TextView) itemView.findViewById(R.id.namamakan);
            txtharga =(TextView) itemView.findViewById(R.id.harga);
            imgFoto =(ImageView) itemView.findViewById(R.id.imgmakan);
            this.itemView = (ConstraintLayout) itemView.findViewById(R.id.conslayout);
        }
    }
}
