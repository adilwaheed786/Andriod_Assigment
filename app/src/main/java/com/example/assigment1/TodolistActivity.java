package com.example.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TodolistActivity extends AppCompatActivity {
    EditText taskTxt;
    String dayName;
    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        dayName = getIntent().getStringExtra("day");
        label=findViewById(R.id.listofday);
        label.setText("Add A Task Of "+dayName);
        taskTxt = (EditText) findViewById(R.id.addTaskTxt);
    }
    public void onAdd(View view) {
        Todos.addTodo(dayName, taskTxt.getText().toString());
        Toast.makeText(getApplicationContext(),"Task Added Successfully !!!",Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
