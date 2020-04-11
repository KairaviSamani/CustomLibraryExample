package com.example.customlibrarydemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.customlibrarydemo.R;
import com.example.customlibrarydemo.model.FullTimeEmployee;
import com.example.customviewlibrary.CustomTextView;

import java.util.ArrayList;
import java.util.List;

public class FullTimeEmployeeAdapter extends BaseAdapter {
    private Context context;
    private List<FullTimeEmployee> fullTimeEmployeeList;
    private List<FullTimeEmployee> copyFullTimeEmployeeList;

    public FullTimeEmployeeAdapter(Context context, List<FullTimeEmployee> fullTimeEmployeeList) {
        this.context = context;
        this.fullTimeEmployeeList = fullTimeEmployeeList;
        this.copyFullTimeEmployeeList = fullTimeEmployeeList;
    }
    @Override
    public int getCount() {
        return fullTimeEmployeeList.size();
    }
    @Override
    public Object getItem(int position) {
        return fullTimeEmployeeList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.row_employee, parent, false);
        CustomTextView txvEmployeeName = convertView.findViewById(R.id.txvEmployeeName);
        CustomTextView txvJobTitle = convertView.findViewById(R.id.txvJobTitle);
        CustomTextView txvDepartment = convertView.findViewById(R.id.txvDepartment);
        CustomTextView txvSalary = convertView.findViewById(R.id.txvSalary);
        CustomTextView txvHours = convertView.findViewById(R.id.txvHours);
        txvHours.setVisibility(View.GONE);

        txvEmployeeName.setText(fullTimeEmployee.getName());
        txvJobTitle.setText(fullTimeEmployee.getJobTitle());
        txvDepartment.setText(fullTimeEmployee.getDepartment());
        txvSalary.setText(String.valueOf(fullTimeEmployee.getSalary()));

        return convertView;
    }

    public void searchEmployee(String searchText){
        fullTimeEmployeeList = new ArrayList<>();
        for (FullTimeEmployee fullTimeEmployee : copyFullTimeEmployeeList){
            if (fullTimeEmployee.getName().toLowerCase().contains(searchText.toLowerCase()) ||
                    fullTimeEmployee.getJobTitle().toLowerCase().contains(searchText.toLowerCase()) ||
                    fullTimeEmployee.getDepartment().toLowerCase().contains(searchText.toLowerCase())){
                fullTimeEmployeeList.add(fullTimeEmployee);
            }
        }
        notifyDataSetChanged();
    }
}
