package com.example.android.achmadfarhanfebrianto_1202154208_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AquaDetail extends AppCompatActivity {
    ImageView isiBotol;
    TextView liter;
    int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqua_detail);
        //Melakukan get pada atribtu sebelumnya
        Intent i = getIntent();
        int gambar = i.getExtras().getInt("gambar");
        String nama = i.getStringExtra("nama");
        String harga = i.getStringExtra("harga");
        String komposisis = i.getStringExtra("komposisi");
        ImageView gambarDetail = (ImageView) findViewById(R.id.detailGambar);
        TextView namaMenu = (TextView) findViewById(R.id.detailNama);
        //TextView hargaMenu = (TextView) findViewById(R.id.hargaMenu);
        TextView komposisi = (TextView) findViewById(R.id.detailDeskripsi);

        //Set atribut ke dalam TextView
        gambarDetail.setImageResource(gambar);
        namaMenu.setText(nama);
        komposisi.setText(komposisis);

        isiBotol = (ImageView) findViewById(R.id.isiBotol);
        liter = (TextView) findViewById(R.id.liter);
        liter();//Method untuk level yang ada pada drawable
    }

    public void liter(){
        switch (level){//Text View saat nantinya method sudah sesuai dengan level dan casenya
            case 0:liter.setText("1L");break;
            case 1:liter.setText("2L");break;
            case 2:liter.setText("3L");break;
            case 3:liter.setText("4L");break;
            case 4:liter.setText("5L");break;
            case 5:liter.setText("6L");break;
            case 6:liter.setText("Full");break;
        }

    }
    public void plus(View view) {//Method Plus
        if (level <= 5) {//Jika Level dia kurang maka akan melanjutkan kelevel selanjutnya
            level++;
            isiBotol.setImageLevel(level);
        } else {//ketika level sudah mencapai batas maksimal
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Air yang anda isi sudah penuh", Toast.LENGTH_SHORT);
            toast.show();
        }
        liter();//memanggil method level
    }

    public void minuse(View view) {//method onclick minuse
        if (level > 0) {//Jika level dia kurang maka akan melanjutkan keevel selanjutnya
            level--;
            isiBotol.setImageLevel(level);
        } else  {//jika level air sudah paling rendah
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Batas minimum air", Toast.LENGTH_SHORT);
            toast.show();
        }
        liter();//memanggil method level
    }
}
