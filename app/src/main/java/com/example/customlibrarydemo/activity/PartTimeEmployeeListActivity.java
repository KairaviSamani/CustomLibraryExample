package com.example.customlibrarydemo.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customlibrarydemo.R;
import com.example.customlibrarydemo.adapter.PartTimeEmployeeAdapter;
import com.example.customlibrarydemo.model.PartTimeEmployee;
import com.example.customviewlibrary.CustomTextView;

import java.util.ArrayList;
import java.util.List;

public class PartTimeEmployeeListActivity extends AppCompatActivity {
    private List<PartTimeEmployee> partTimeEmployeeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        initView();
    }

    private void initView() {
        CustomTextView txvTitle = findViewById(R.id.txvTitle);
        txvTitle.setText(getText(R.string.part_time_employee));
        ListView lsvEmployee = findViewById(R.id.lsvEmployee);

        PartTimeEmployee partTimeEmployee1 = new PartTimeEmployee();
        partTimeEmployee1.setName("John");
        partTimeEmployee1.setDepartment("Development");
        partTimeEmployee1.setJobTitle("Junior Developer");
        partTimeEmployee1.setHourlyPay(300);
        partTimeEmployee1.setHoursWorked(50);

        partTimeEmployeeList.add(partTimeEmployee1);

        PartTimeEmployee partTimeEmployee2 = new PartTimeEmployee();
        partTimeEmployee2.setName("Stephan");
        partTimeEmployee2.setDepartment("Development");
        partTimeEmployee2.setJobTitle("Senior Developer");
        partTimeEmployee2.setHourlyPay(500);
        partTimeEmployee2.setHoursWorked(35);

        partTimeEmployeeList.add(partTimeEmployee2);

        PartTimeEmployee partTimeEmployee3 = new PartTimeEmployee();
        partTimeEmployee3.setName("Steve");
        partTimeEmployee3.setDepartment("Development");
        partTimeEmployee3.setJobTitle("Tech Lead");
        partTimeEmployee3.setHourlyPay(600);
        partTimeEmployee3.setHoursWorked(30);

        partTimeEmployeeList.add(partTimeEmployee3);

        PartTimeEmployee partTimeEmployee4 = new PartTimeEmployee();
        partTimeEmployee4.setName("Ryann");
        partTimeEmployee4.setDepartment("Support");
        partTimeEmployee4.setJobTitle("Technical Operations Engineer");
        partTimeEmployee4.setHourlyPay(400);
        partTimeEmployee4.setHoursWorked(45);

        partTimeEmployeeList.add(partTimeEmployee4);

        PartTimeEmployee partTimeEmployee5 = new PartTimeEmployee();
        partTimeEmployee5.setName("Smith");
        partTimeEmployee5.setDepartment("Management");
        partTimeEmployee5.setJobTitle("CEO");
        partTimeEmployee5.setHourlyPay(5000);
        partTimeEmployee5.setHoursWorked(20);

        partTimeEmployeeList.add(partTimeEmployee5);

        PartTimeEmployeeAdapter partTimeEmployeeAdapter = new PartTimeEmployeeAdapter(this, partTimeEmployeeList);
        lsvEmployee.setAdapter(partTimeEmployeeAdapter);
    }

}
