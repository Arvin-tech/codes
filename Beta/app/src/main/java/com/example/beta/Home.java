package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Home extends AppCompatActivity{
    protected Button logoutButton, disconnectButton;
    protected TextView userEmailText, userNameText; //the email and name of logged in user in navbar
    protected String userEmail, userEmailTxt;
    protected GoogleSignInClient mGoogleSignInClient;
    protected static final String TAG = "HomeActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set the status bar color to orange
        setStatusBarColor(getResources().getColor(R.color.dark_orange));
    }

    protected void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    protected  void revokeAccess(){
        mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        //updateUI(null);
                        // [END_EXCLUDE]
                    }
                });
    }

    protected void redirectLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void getUserDetails(){
        // Get the email from the Intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userEmail = extras.getString("email"); //email address from forgot pass activity stored in userEmail
        }
    }

    protected void signOutGoogle(){
        // Sign out from Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .build();

        GoogleSignIn.getClient(this, gso).signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Handle sign-out completion
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User signed out successfully.");
                        } else {
                            Log.w(TAG, "Error signing out.", task.getException());
                        }
                    }
                });
    }


}