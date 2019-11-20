package com.example.navigationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import androidx.annotation.NonNull;

public class LoginActivity extends Activity {
    EditText emailId, password;
    Button btnSignIn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignIn = findViewById(R.id.Login);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,HomePage.class);
                    startActivity(i);

                    String stg = "You are logged in";
                    if(stg.equals("You are logged in")) {readFile();}

                } else {
                    Toast.makeText(LoginActivity.this, "Please log in", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = password.getText().toString();
                String email = emailId.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter email");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();

                            } else {
                                Intent intHome = new Intent(LoginActivity.this, HomePage.class);
                                startActivity(intHome);
                                readFile();
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    public void readFile() {
        Intent i = new Intent(LoginActivity.this, HomePage.class);
        startActivity(i);
        try {
            FileInputStream fileInputStream = openFileInput("Tutorial File.txt");
            FileInputStream fileInputStream2 = openFileInput("Tutorial File2.txt");
            FileInputStream fileInputStream3 = openFileInput("Tutorial File3.txt");
            FileInputStream fileInputStream4 = openFileInput("Tutorial File4.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            InputStreamReader inputStreamReader2 = new InputStreamReader(fileInputStream2);
            InputStreamReader inputStreamReader3 = new InputStreamReader(fileInputStream3);
            InputStreamReader inputStreamReader4 = new InputStreamReader(fileInputStream4);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader3);
            BufferedReader bufferedReader4 = new BufferedReader(inputStreamReader4);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = new StringBuffer();
            String lines;
            lines = bufferedReader.readLine();
            stringBuffer.append(lines + "\n");
            lines = bufferedReader2.readLine();
            stringBuffer2.append(lines + "\n");
            lines = bufferedReader3.readLine();
            stringBuffer3.append(lines + "\n");
            lines = bufferedReader4.readLine();
            stringBuffer4.append(lines + "\n");

            String textToSave = stringBuffer.toString();
            String textToSave2 = stringBuffer2.toString();
            String textToSave3 = stringBuffer3.toString();
            String textToSave4 = stringBuffer4.toString();
            i.putExtra("house1", textToSave);
            i.putExtra("house2", textToSave2);
            i.putExtra("house3", textToSave3);
            i.putExtra("house4", textToSave4);
            startActivity(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
