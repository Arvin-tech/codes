package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SignInActivity";
    protected FirebaseFirestore db; //cloud fire store
    private static final int RC_SIGN_IN = 40; //constant
    protected AppCompatButton loginButton, createButton;
    protected TextInputLayout emailInputLayout, passwordInputLayout;
    protected EditText emailTxt, passwordTxt; //email and password input
    protected TextView forgotPass; //don't have an account yet? && reset password
    protected GoogleSignInClient mGoogleSignInClient; //google sign-in
    protected String inputtedEmail, inputtedPassword;
    protected Calendar calendar = Calendar.getInstance();
    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected String currentDate = simpleDateFormat.format(calendar.getTime()); //or currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    protected String userEmail; //used for updating last login activity
    protected int redColor = Color.parseColor("#FF0000"); // Set the error text color to red

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set the status bar color to orange
        setStatusBarColor(getResources().getColor(R.color.dark_orange));

        db = FirebaseFirestore.getInstance(); //initialize firebase fire store
        findViewById(); //reference to ui elements
        textWatchers(); //text watchers
        emailInputListener();
        passwordInputListener();

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //click google sign-in button
        /*
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { signIn(); }
        });
        */

        //click login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtedEmail = emailTxt.getText().toString().trim();
                inputtedPassword = passwordTxt.getText().toString().trim();
                if(validEmail(inputtedEmail) && validPassword(inputtedPassword)){
                    loginUser();
                }
            }
        });

        //forgot password?
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
                finish(); //so they wont have to use back button instead they will use the back button provided in forgot pass activity
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });

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
        //signInButton = findViewById(R.id.googleSignInButton);
        loginButton = findViewById(R.id.buttonLogin);
        createButton = findViewById(R.id.buttonCreate);
        emailTxt = findViewById(R.id.emailEditTxt);
        passwordTxt = findViewById(R.id.passwordEditTxt);
        forgotPass = findViewById(R.id.forgotPasswordTxt);
    }

    protected void redirectHomeActivity(){
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        finish(); //Finish the current activity (main activity) so that the user can't go back to the sign-in screen with the back button
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
                                redirectHomeActivity();
                                finish();
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            } else {
                                // Password doesn't match
                                Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // User with the provided email not found
                            Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
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

    protected void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
            }
            catch (ApiException e){
                throw new RuntimeException(e);
            }
        }
    }

    protected void firebaseAuth(String idToken) {

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
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

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