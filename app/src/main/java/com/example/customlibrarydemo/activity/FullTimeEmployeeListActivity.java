package com.example.customlibrarydemo.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customlibrarydemo.R;
import com.example.customlibrarydemo.adapter.FullTimeEmployeeAdapter;
import com.example.customlibrarydemo.model.FullTimeEmployee;
import com.example.customviewlibrary.CustomEditText;
import com.example.customviewlibrary.CustomTextView;

import java.util.ArrayList;
import java.util.List;

public class FullTimeEmployeeListActivity extends AppCompatActivity {
    private List<FullTimeEmployee> fullTimeEmployeeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        initView();
    }

    private void initView() {
        CustomTextView txvTitle = findViewById(R.id.txvTitle);
        txvTitle.setText(getText(R.string.full_time_employee));
        final CustomEditText edtSearch = findViewById(R.id.edtSearch);
        ImageView imvSearch = findViewById(R.id.imvSearch);
        final ListView lsvEmployee = findViewById(R.id.lsvEmployee);

        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee();
        fullTimeEmployee1.setName("Angela");
        fullTimeEmployee1.setDepartment("Development");
        fullTimeEmployee1.setJobTitle("Junior Developer");
        fullTimeEmployee1.setSalary(20000);

        fullTimeEmployeeList.add(fullTimeEmployee1);

        FullTimeEmployee fullTimeEmployee2 = new FullTimeEmployee();
        fullTimeEmployee2.setName("Frank");
        fullTimeEmployee2.setDepartment("Development");
        fullTimeEmployee2.setJobTitle("Senior Developer");
        fullTimeEmployee2.setSalary(40000);

        fullTimeEmployeeList.add(fullTimeEmployee2);

        FullTimeEmployee fullTimeEmployee3 = new FullTimeEmployee();
        fullTimeEmployee3.setName("Paterick");
        fullTimeEmployee3.setDepartment("Development");
        fullTimeEmployee3.setJobTitle("Tech Lead");
        fullTimeEmployee3.setSalary(70000);

        fullTimeEmployeeList.add(fullTimeEmployee3);

        FullTimeEmployee fullTimeEmployee4 = new FullTimeEmployee();
        fullTimeEmployee4.setName("Lisa");
        fullTimeEmployee4.setDepartment("Support");
        fullTimeEmployee4.setJobTitle("Technical Operations Engineer");
        fullTimeEmployee4.setSalary(40000);

        fullTimeEmployeeList.add(fullTimeEmployee4);

        FullTimeEmployee fullTimeEmployee5 = new FullTimeEmployee();
        fullTimeEmployee5.setName("Todd");
        fullTimeEmployee5.setDepartment("Management");
        fullTimeEmployee5.setJobTitle("CEO");
        fullTimeEmployee5.setSalary(600000);

        fullTimeEmployeeList.add(fullTimeEmployee5);

        final FullTimeEmployeeAdapter fullTimeEmployeeAdapter = new FullTimeEmployeeAdapter(this, fullTimeEmployeeList);
        lsvEmployee.setAdapter(fullTimeEmployeeAdapter);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fullTimeEmployeeAdapter.searchEmployee(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSearch.getText() != null)
                    fullTimeEmployeeAdapter.searchEmployee(edtSearch.getText().toString().trim());
            }
        });
    }

}
