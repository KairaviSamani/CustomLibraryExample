package com.example.customlibrarydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customlibrarydemo.R;
import com.example.customviewlibrary.CustomButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        CustomButton btnFullTimeEmployee = findViewById(R.id.btnFullTimeEmployee);
        CustomButton btnPartTimeEmployee = findViewById(R.id.btnPartTimeEmployee);

        btnFullTimeEmployee.setOnClickListener(this);
        btnPartTimeEmployee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFullTimeEmployee:
                Intent intent = new Intent(MainActivity.this, FullTimeEmployeeListActivity.class);
                startActivity(intent);
                break;
            case R.id.btnPartTimeEmployee:
                Intent intent1 = new Intent(MainActivity.this, PartTimeEmployeeListActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
