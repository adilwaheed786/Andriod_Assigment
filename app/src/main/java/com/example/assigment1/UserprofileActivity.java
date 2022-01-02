package com.example.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class UserprofileActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView name,email,age;
    static User u;
    ListView TodoList;
    String dayName;
    String[] days= {"Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday","Sunday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        TodoList = findViewById(R.id.li_of_week);
        name=findViewById(R.id.et_userprofilename);
        email=findViewById(R.id.et_userprofileemail);
        age=findViewById(R.id.et_userprofileage);
        u = (User) getIntent().getSerializableExtra("user");
        name.setText(name.getText()+(u.first+u.last).toUpperCase());
        email.setText(email.getText()+u.email);
        age.setText(age.getText()+u.age);
//         days=new DateFormatSymbols().getWeekdays();
        ArrayAdapter<String> dayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,days);
        TodoList.setAdapter(dayAdapter);
        TodoList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String day=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(),day+"Selected",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(UserprofileActivity.this, TodolistActivity.class);
        intent.putExtra("day",day);
        startActivity(intent);
    }
}