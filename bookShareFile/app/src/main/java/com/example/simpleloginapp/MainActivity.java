package com.example.simpleloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static EditText user;
    private static EditText pass;
    private static Button login;
    private static Button signup;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private EditText emailEditText;
    private EditText passwordEditText;
    private String email;
    private String password;
    private Context mContext;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mContext=this;
        if (user != null) {

          /*  name = user.getDisplayName();
            email = user.getEmail();

            Uri photoUrl = user.getPhotoUrl();

             Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

             The user's ID, unique to the Firebase project. Do NOT use this value to
             authenticate with your backend server, if you have one. Use
             FirebaseUser.getIdToken() instead.
            String uid = user.getUid();*/
            Toast.makeText(mContext, "User Already Logged In", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            finish();
        }

            emailEditText = findViewById(R.id.editText);
            passwordEditText = findViewById(R.id.editText2);




    }
    public void onSignUpClicked(View view)
    {

                Intent intent=new Intent(".SignUpPage");
                startActivity(intent);



    }
    public  void onLoginClicked(View view) {
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(".Main2Activity");
                            startActivity(intent);
                            finish();

                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code";
                            }
                            Toast.makeText(mContext,"Invalid Credentials", Toast.LENGTH_SHORT).show();

                            // If sign in fails, display a message to the user.

                        }

                        // ...
                    }
                });


    }

}
