package com.example.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.log_user);
        password = findViewById(R.id.log_pass);
        login=findViewById(R.id.log_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("")  || password.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(),"Fill your Credentials first !!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                User u = UserData.login(username.getText().toString(),  password.getText().toString());
                if (u == null) {Toast.makeText(getApplicationContext(),"Invaid Credentials !!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Login Successful !!!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, UserprofileActivity.class);
                intent.putExtra("user",u);
                startActivity(intent);
                username.getText().clear();
                password.getText().clear();
            }
        });
    }
}