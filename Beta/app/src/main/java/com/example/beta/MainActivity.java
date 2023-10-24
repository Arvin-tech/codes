package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SignInActivity";
    protected FirebaseFirestore db; //cloud fire store
    private static final int RC_SIGN_IN = 1000; //constant
    protected AppCompatButton loginButton, createButton;
    protected TextInputLayout emailInputLayout, passwordInputLayout;
    protected EditText emailTxt, passwordTxt; //email and password input
    protected TextView forgotPass; //don't have an account yet? && reset password
    protected String inputtedEmail, inputtedPassword;
    protected Calendar calendar = Calendar.getInstance();
    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected String currentDate = simpleDateFormat.format(calendar.getTime()); //or currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    protected String userEmail; //used for updating last login activity
    protected int redColor = Color.parseColor("#FF0000"); // Set the error text color to red
    protected SharedPreferences sharedPreferences; //storage mechanism used for auth/login purposes
    protected SharedPreferences.Editor editor;
    protected TextView signupTxt;
    TextView text;
    View errorLayout;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = getLayoutInflater();
        errorLayout = inflater.inflate(R.layout.error_message, null); //error_message xml
        text = errorLayout.findViewById(R.id.errorMessage);


        setStatusBarColor(getResources().getColor(R.color.light_gray)); // Set the status bar color to orange
        db = FirebaseFirestore.getInstance(); //initialize firebase fire store
        //sharedPreferences = getSharedPreferences("auth_data", Context.MODE_PRIVATE);
        //editor = sharedPreferences.edit();

        findViewById(); //reference to ui elements
        textWatchers(); //text watchers
        emailInputListener();
        passwordInputListener();

        /*
        // Check if the user is already authenticated
        if (isUserAuthenticated()) {
            redirectHomeActivity();
            return;
        }

        if(sharedPreferences.contains("logged_email")) {
            redirectHomeActivity();
        }
        */

        //forgot password?
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
                //finish(); //so they wont have to use back button instead they will use the back button provided in forgot pass activity
            }
        });


        //click login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtedEmail = emailTxt.getText().toString().trim();
                inputtedPassword = passwordTxt.getText().toString().trim();
                /*
                editor.putString("logged_email", inputtedEmail);
                editor.putString("logged_password", inputtedPassword);
                editor.commit();
                 */
                if(validEmail(inputtedEmail) && validPassword(inputtedPassword)){
                    loginUser();
                }
            }
        });

        //don't have an account? Signup
        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });

    }

    protected boolean isUserAuthenticated() {
        // Check your stored data (SharedPreferences) for authentication status
        return sharedPreferences.getBoolean("is_authenticated", false);
    }

    protected void saveAuthenticationState(boolean isAuthenticated) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("is_authenticated", isAuthenticated);
        editor.apply();
    }

    protected void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    protected void findViewById(){
        //reference to ui elements (login and google sign-in button)
        loginButton = findViewById(R.id.buttonLogin);
        emailTxt = findViewById(R.id.emailEditTxt);
        passwordTxt = findViewById(R.id.passwordEditTxt);
        forgotPass = findViewById(R.id.forgotPasswordTxt);
        signupTxt = findViewById(R.id.textViewSignup);
    }

    protected void redirectHomeActivity(){
        finish(); //Finish the current activity (main activity) so that the user can't go back to the sign-in screen with the back button
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }

    protected void loginUser() {

        db.collection("Users")
                .whereEqualTo("email", inputtedEmail)
                .limit(1)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // User with the provided email found
                            DocumentSnapshot documentSnapshot = queryDocumentSnapshots.getDocuments().get(0);
                            String storedPassword = documentSnapshot.getString("password"); //get the string value of password field

                            if (inputtedPassword.equals(storedPassword)) {
                                updateLastLogin(inputtedEmail); //last login on date today
                                //saveAuthenticationState(true); //set to true now
                                redirectHomeActivity();
                                finish();
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            } else {
                                // Password doesn't match
                                //Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                                text.setText("Incorrect email or password!");
                                showError();
                            }
                        } else {
                            // User with the provided email not found
                            //Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                            text.setText("Incorrect email or password!");
                            showError();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error logging in " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showError() {
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, 5, 0); // Adjust the Y offset as needed
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(errorLayout);
        toast.show();
    }

    protected void updateLastLogin(String email){
        db.collection("Users")
                .whereEqualTo("email", userEmail)
                .limit(1)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()){
                            DocumentSnapshot documentSnapshot = queryDocumentSnapshots.getDocuments().get(0);
                            String documentId = documentSnapshot.getId();
                            db.collection("Users").document(documentId)
                                    .update("lastLogin", currentDate)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "Last login updated today: "+currentDate);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d(TAG, "Error updating last login date!");
                                        }
                                    });
                        } else {
                            Log.d(TAG, "This user doesn't exist");
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error checking user existence: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    protected void textWatchers(){
        emailTxt.addTextChangedListener(new MainActivity.EmailTextWatcher());
        passwordTxt.addTextChangedListener(new MainActivity.PasswordTextWatcher());
    }

    protected Boolean validEmail(String email){
        emailInputLayout = findViewById(R.id.emailLayout);
        emailTxt = findViewById(R.id.emailEditTxt);

        if(email.isEmpty()){
            emailTxt.requestFocus();
            emailInputLayout.setError("Email Required!");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailTxt.requestFocus();
            emailInputLayout.setError("Invalid email!");
            return false;
        }
        else{
            emailInputLayout.setError(null);
            return true;
        }
    }

    protected Boolean validPassword(String password){
        passwordInputLayout = findViewById(R.id.passwordLayout);
        passwordTxt = findViewById(R.id.passwordEditTxt);

        if(password.isEmpty()){
            passwordTxt.requestFocus();
            passwordInputLayout.setError("Password Required!");
            return false;
        }
        else {
            passwordInputLayout.setError(null);
            return true;
        }
    }

    protected void emailInputListener(){
        emailInputLayout = findViewById(R.id.emailLayout);
        emailTxt = emailInputLayout.getEditText();
        assert emailTxt != null;
        emailTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputtedEmail = emailTxt.getText().toString().trim();
                if(!inputtedEmail.isEmpty()){
                    emailInputLayout.setError(null); //tri
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        emailInputLayout.setErrorTextColor(ColorStateList.valueOf(redColor));
    }

    protected void passwordInputListener() {
        passwordInputLayout = findViewById(R.id.passwordLayout);
        passwordTxt = passwordInputLayout.getEditText();
        assert passwordTxt != null;
        passwordTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputtedPassword = passwordTxt.getText().toString().trim();
                if(!inputtedPassword.isEmpty()){
                    passwordInputLayout.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordInputLayout.setErrorTextColor(ColorStateList.valueOf(redColor));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class EmailTextWatcher implements TextWatcher {
        private static final int MAX_EMAIL_LENGTH = 30;
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String email = editable.toString().trim();
            if (email.length() > MAX_EMAIL_LENGTH) {
                editable.replace(0, editable.length(), email.substring(0, MAX_EMAIL_LENGTH));
            }
        }
    }

    private class PasswordTextWatcher implements TextWatcher {
        private static final int MAX_PASSWORD_LENGTH = 15;

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String password = editable.toString().trim();
            if (password.length() > MAX_PASSWORD_LENGTH) {
                editable.replace(0, editable.length(), password.substring(0, MAX_PASSWORD_LENGTH));
            }
        }
    }


}