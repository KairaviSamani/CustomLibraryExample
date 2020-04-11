package com.example.customlibrarydemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.customlibrarydemo.R;
import com.example.customlibrarydemo.model.PartTimeEmployee;
import com.example.customviewlibrary.CustomTextView;

import java.util.List;

public class PartTimeEmployeeAdapter extends BaseAdapter {
    private Context context;
    private List<PartTimeEmployee> partTimeEmployeeList;

    public PartTimeEmployeeAdapter(Context context, List<PartTimeEmployee> partTimeEmployeeList) {
        this.context = context;
        this.partTimeEmployeeList = partTimeEmployeeList;
    }
    @Override
    public int getCount() {
        return partTimeEmployeeList.size();
    }
    @Override
    public Object getItem(int position) {
        return partTimeEmployeeList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.row_employee, parent, false);
        CustomTextView txvEmployeeName = convertView.findViewById(R.id.txvEmployeeName);
        CustomTextView txvJobTitle = convertView.findViewById(R.id.txvJobTitle);
        CustomTextView txvDepartment = convertView.findViewById(R.id.txvDepartment);
        CustomTextView txvSalary = convertView.findViewById(R.id.txvSalary);
        CustomTextView txvHours = convertView.findViewById(R.id.txvHours);

        txvEmployeeName.setText(partTimeEmployee.getName());
        txvJobTitle.setText(partTimeEmployee.getJobTitle());
        txvDepartment.setText(partTimeEmployee.getDepartment());
        txvSalary.setText(String.format("%s/H",String.valueOf(partTimeEmployee.getHourlyPay())));
        txvHours.setText(String.format("%sH",String.valueOf(partTimeEmployee.getHoursWorked())));

        return convertView;
    }
}
