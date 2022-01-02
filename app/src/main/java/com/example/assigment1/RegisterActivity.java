package com.example.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText first,last,age,pass,confirmpass,email;
    Button registerSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        first=findViewById(R.id.et_firstname);
        last=findViewById(R.id.et_lastname);
        age=findViewById(R.id.et_age);
        pass=findViewById(R.id.et_password);
        confirmpass=findViewById(R.id.et_confirmpassword);
        email=findViewById(R.id.et_mail);
        registerSignup=findViewById(R.id.btn_register2nd);
        registerSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first.getText().toString().equals("") || last.getText().toString().equals("")  || age.getText().toString().equals("")  || email.getText().toString().equals("")  || pass.getText().toString().equals("")  || confirmpass.getText().toString().equals("") ) {
                    Toast.makeText(getApplicationContext(),"Fill the data first !!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!(pass.getText().toString().equals(confirmpass.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"Password is not same at Confirm Password !!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                UserData.addUsers(first.getText().toString(),last.getText().toString(),age.getText().toString(),email.getText().toString(),pass.getText().toString());
                Toast.makeText(getApplicationContext(),"Account Created SuccessFully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                first.getText().clear();
                last.getText().clear();
                age.getText().clear();
                pass.getText().clear();
                confirmpass.getText().clear();
                email.getText().clear();
            }
        });
    }



}