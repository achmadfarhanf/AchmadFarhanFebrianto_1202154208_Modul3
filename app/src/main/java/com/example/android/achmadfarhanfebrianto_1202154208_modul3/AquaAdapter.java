package com.example.android.achmadfarhanfebrianto_1202154208_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class AquaAdapter extends RecyclerView.Adapter<AquaAdapter.MyViewHolder>{
    private LayoutInflater mInflater;
    private List<menu> detailmenu;
    CardView cv;


    public AquaAdapter(Context context, List<menu> detailmenu) {
        mInflater = LayoutInflater.from(context); //inisiasi inflater
        this.detailmenu = detailmenu;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.activity_aqua_adapter, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        menu menu = detailmenu.get(position);
        //Melakukan Get Value Pada Text
        holder.details.setText(menu.getHarga());
        holder.nama.setText(menu.getNama());
        holder.layout.setBackgroundResource(menu.getGambar());
    }
    @Override
    public int getItemCount() {
        return detailmenu.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //Merupakan Class ViewHolder
        public TextView nama, details;
        ImageView gambar;
        ConstraintLayout layout;


        public MyViewHolder(View view) {
            //untuk menginisiasikan variable atribut yang ada
            super(view);
            nama = (TextView) view.findViewById(R.id.nama);
            details = (TextView) view.findViewById(R.id.details);
            layout = (ConstraintLayout) view.findViewById(R.id.layout_background);

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {   //Method untuk memilih salah satu menu
            int mPosition = getLayoutPosition();

            String element = detailmenu.get(mPosition).toString();
            Toast.makeText(view.getContext(), nama.getText(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), AquaDetail.class);
            int gambar = detailmenu.get(mPosition).getGambar();
            String komposisi = detailmenu.get(mPosition).getKomposisi();
            i.putExtra("gambar", gambar);      // put extra ke intent berikutnya
            i.putExtra("nama", nama.getText());
            i.putExtra("details", details.getText());
            i.putExtra("komposisi", komposisi);
            view.getContext().startActivity(i);//Untuk melanjutkan ke activity berikutnya

        }
    }


}
