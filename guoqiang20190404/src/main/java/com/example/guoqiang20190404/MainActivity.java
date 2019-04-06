package com.example.guoqiang20190404;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jiekou.contraInterface;
import ptesenter.MyPresenter;
import view.ShowActivity;

public class MainActivity extends AppCompatActivity implements contraInterface.LoginInterface {
    contraInterface.Presenterface presenterface;
    EditText edit_phone,edit_pwd;
    Button but_login,but_regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_phone =findViewById(R.id.edit_phone);
        edit_pwd =findViewById(R.id.edit_pwd);
        but_login =findViewById(R.id.but_login);
        but_regist =findViewById(R.id.but_regist);
        presenterface = new MyPresenter<>(this);
        init();


    }

    private void init() {

        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edit_phone.getText().toString();
                String pwd = edit_pwd.getText().toString();
                presenterface.requsetLogin(phone,pwd);
            }
        });

        but_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edit_phone.getText().toString();
                String pwd = edit_pwd.getText().toString();
                presenterface.requsetRegist(phone,pwd);
            }
        });

    }

    @Override
    public void showLogin(String string) {
        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(MainActivity.this, ShowActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void showRegist(String string) {
        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();

    }
}
