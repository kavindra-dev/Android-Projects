package com.company.friendzmeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {

    EditText nametxt, emailtxt, passtxt, confPasstxt;
    Button signup;
    TextView login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // firebase connection
        mAuth = FirebaseAuth.getInstance();

        nametxt = findViewById(R.id.personname);
        emailtxt = findViewById(R.id.email);
        passtxt = findViewById(R.id.password);
        confPasstxt = findViewById(R.id.confirmpsw);
        signup = findViewById(R.id.signUpBtn);
        login = findViewById(R.id.loginBtn);

        // Set on Click Listener on Registration button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(CreateAccount.this,
                        Login.class);
                startActivity(intent);
            }
        });
    }

    private void registerNewUser() {

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailtxt.getText().toString();
        password = passtxt.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "Registration successful!",
                                    Toast.LENGTH_LONG)
                                    .show();


                            // if the user created intent to login activity
                            Intent intent
                                    = new Intent(CreateAccount.this,
                                    HomeScreen.class);
                            startActivity(intent);
                        } else {

                            // Registration failed
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Registration failed!!"
                                            + " Please try again later",
                                    Toast.LENGTH_LONG)
                                    .show();


                        }
                    }
                });
    }

}