package com.example.android.achmadfarhanfebrianto_1202154208_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<menu> detailmenu = new ArrayList<>();
    private RecyclerView recyclerView;
    private AquaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new AquaAdapter(this, detailmenu);
        //menginisiasi adapter untuk recycleView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        //Menghubungkan antara adapter dan layout
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMenuData();

       //Untuk mengimplementasikan grid pada layout
       int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
       recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

    }

    private void prepareMenuData() {//Memasukan menu pada Array
        String[] merk_title = getResources().getStringArray(R.array.merk_tittle);
        String[] merk_deskripsi = getResources().getStringArray(R.array.merk_deskripsi);
        String[] details = getResources().getStringArray(R.array.details);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        detailmenu.clear();


        //Membuat Arraylist pada sports object
        //Informasi dan gambar tentang sport yang akan ditampilkan
        for(int i=0; i<merk_title.length; i++){
            detailmenu.add(new menu(sportsImageResources.getResourceId(i,0),merk_title[i], merk_deskripsi[i]
                    , details[i]));
        }
        //Untuk melakukan recycle pada sportimageresource
        sportsImageResources.recycle();
        mAdapter.notifyDataSetChanged();

    }

}
