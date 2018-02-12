package com.example.kid_d_000.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xw.repo.BubbleSeekBar;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    BubbleSeekBar barra;
    String valores[];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listView);
        barra = (BubbleSeekBar) findViewById(R.id.seekBar);
        valores = new String[30];
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores);

        barra.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                for (int i = 0; i < 30; i++) {
                    int n = barra.getProgress();
                    valores[i] = n + "X" + (i + 1) + "=" + (n * (i + 1));
                }
                lista.setAdapter(adapter);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });
    }
}
