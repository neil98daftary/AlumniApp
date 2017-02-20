package com.example.tejas.alumniapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.net.URI;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    EditText emailid;
    EditText epassword;
    Button submit_button;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sp = getSharedPreferences("log_data", Context.MODE_PRIVATE);
        editor = sp.edit();



        emailid=(EditText)findViewById(R.id.editTextEmail);
        epassword=(EditText)findViewById(R.id.password);
        submit_button= (Button) findViewById(R.id.submit_button);
        progressDialog = new ProgressDialog(this);
        submit_button.setOnClickListener(this);
        firebaseAuth= FirebaseAuth.getInstance();

    }


    private void validateUser(){

        //getting email and password from edit texts
        String email = emailid.getText().toString();
        String password  = epassword.getText().toString();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Logging in Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(SignUp.this,"Successfully Logged in",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignUp.this, HomeScreen.class);
                            startActivity(intent);
                            finish();
                        }else{
                            //display some message here
                            Toast.makeText(SignUp.this,"Login Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

        editor.putInt("log", 1);
        editor.commit();

    }
    @Override
    public void onClick(View view) {
        //calling register method on click
        validateUser();
    }


}
