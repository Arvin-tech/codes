package com.example.fileupload;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType; //for password eye icon
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button; //signup button
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton; //eye icon toggle

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth; //authentication
import com.google.firebase.firestore.FirebaseFirestore; //save data like names


public class Register extends AppCompatActivity {

    EditText fullNameTxt, emailTxt, passwordTxt;
    Button signUp;
    TextView loginTxt;
    ImageButton passwordToggleBtn;
    TextInputEditText passwordEditTxt;
    FirebaseFirestore database;
    FirebaseAuth mAuth;
    ImageView eyeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(); //reference to ui elements
        database = FirebaseFirestore.getInstance(); //initialize firebase
        mAuth = FirebaseAuth.getInstance(); //initialize firebase authentication
        setEyeIcon(); //show n hide eye icon

        //click eye icon
        eyeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordTxt.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    //hide password when visible
                    passwordTxt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    eyeIcon.setImageResource(R.drawable.eye_close);
                }
                else{
                    passwordTxt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    eyeIcon.setImageResource(R.drawable.eye_open);
                }
            }
        });

        //click button
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtedEmail = emailTxt.getText().toString();
                String inputtedPassword = passwordTxt.getText().toString();
                //validations
                if(!inputtedEmail.isEmpty() || !inputtedPassword.isEmpty()){
                    createUser(inputtedEmail, inputtedPassword); //invoke method, pass declared variables
                }
                else if(inputtedEmail.isEmpty()){
                    emailTxt.requestFocus();
                    emailTxt.setError("Email required!"); //prompt
                }
                else if(inputtedPassword.isEmpty()){
                    passwordTxt.requestFocus();
                    passwordTxt.setError("Password required!"); //prompt
                }
            }
        });

    }

    protected void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Successfully Created!", Toast.LENGTH_SHORT).show();
                    redirectLoginActivity(); //proceed to login
                    finish(); //close registration activity
                }
                else{
                    // If sign in fails, display a message to the user.
                    Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void findViewById(){
        fullNameTxt = findViewById(R.id.fullNameEditTxt);
        emailTxt = findViewById(R.id.emailEditTxt);
        passwordTxt = findViewById(R.id.passwordEditTxt);
        signUp = findViewById(R.id.buttonSignup);
        loginTxt = findViewById(R.id.textViewLogin);
        passwordEditTxt = findViewById(R.id.passwordEditTxt);
    }

    protected void setEyeIcon(){
        eyeIcon = findViewById(R.id.eyeIconImageView); //set
        eyeIcon.setImageResource(R.drawable.eye_close);
    }

    protected void redirectLoginActivity(){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent); //redirect to login activity after successful signup
    }
}