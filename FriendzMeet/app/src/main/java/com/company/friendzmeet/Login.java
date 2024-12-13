package com.company.friendzmeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText emailtxt, passwordtxt;
    Button login;
    TextView register, forgotpassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailtxt = findViewById(R.id.emailET);
        passwordtxt = findViewById(R.id.passwordET);
        login = findViewById(R.id.loginBtn);
        register = findViewById(R.id.signUpTv);
        forgotpassword = findViewById(R.id.forgotTv);

        // taking instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Login.this,
                        CreateAccount.class);
                startActivity(intent);
            }
        });
    }


    private void loginUserAccount()
    {

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailtxt.getText().toString();
        password = passwordtxt.getText().toString();

        // validations for input email and password
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

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Login successful!!",
                                            Toast.LENGTH_LONG)
                                            .show();



                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent
                                            = new Intent(Login.this,
                                            HomeScreen.class);
                                    startActivity(intent);
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                            "Login failed!!",
                                            Toast.LENGTH_LONG)
                                            .show();

                                }
                            }
                        });
    }


}