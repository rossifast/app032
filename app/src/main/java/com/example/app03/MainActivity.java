package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ImageView showImage;
    Button change;
    int[] imageIndex = {R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05, R.drawable.item06,
            R.drawable.item07, R.drawable.item08, R.drawable.item09, R.drawable.item10, R.drawable.item11, R.drawable.item12,};
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showImage = findViewById(R.id.showImage);
        change = findViewById(R.id.changeButton);

        CustomGrid adapter = new CustomGrid(MainActivity.this, imageIndex);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showImage.setImageResource(imageIndex[i]);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = (index + 1) % 3;
                if (index == 0) {
                    gridView.setNumColumns(2);
                } else if (index == 1){
                    gridView.setNumColumns(3);
                } else {
                    gridView.setNumColumns(4);
                }

            }
        });
    }
}