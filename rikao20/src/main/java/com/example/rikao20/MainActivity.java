package com.example.rikao20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyLayout.MyCallBack {
    MyLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout =findViewById(R.id.mylayout);
        myLayout.setMyCallBack(this);

    }

    @Override
    public void fan() {
        myLayout.text_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"返回",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void ti() {
    myLayout.text_ti.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"提交",Toast.LENGTH_SHORT).show();

        }
    });
    }
}
