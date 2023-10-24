package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class Home extends AppCompatActivity {
    protected Button logoutButton, disconnectButton;
    protected TextView userEmailText, userNameText; //the email and name of logged in user in navbar
    protected String userEmail;
    protected static final String TAG = "HomeActivity";
    protected DrawerLayout drawerLayout;
    protected FirebaseFirestore db;
    protected NavigationView navigationView;
    protected SharedPreferences sharedPreferences; //storage mechanism used for auth/login purposes
    protected ImageView imageView;
    TextView name, email;
    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setStatusBarColor(getResources().getColor(R.color.yellow));  // Set the status bar color to orange
        db = FirebaseFirestore.getInstance(); //initialize firestore
        sharedPreferences = getSharedPreferences("auth_data", Context.MODE_PRIVATE);

        imageView = findViewById(R.id.avatar); //image view avatar
        name = findViewById(R.id.name); //name text
        email = findViewById(R.id.email); // email text
        logout = findViewById(R.id.logoutButton); //logout button

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Home.this, MainActivity.class));
                //finish();

            }
        });

        }

        //navigationView = findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);

        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

         */

        /*
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // Get the ID of the selected item
                if (itemId == R.id.nav_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
                } else if (itemId == R.id.nav_settings) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SecondFragment()).commit();
                } else if (itemId == R.id.nav_share) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThirdFragment()).commit();
                } else if (itemId == R.id.nav_about) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FourthFragment()).commit();
                } else if (itemId == R.id.nav_logout) {
                    saveAuthenticationState(false);  // Clear the authentication state in shared preferences
                    redirectLoginActivity();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

         */

    protected void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    protected void saveAuthenticationState(boolean isAuthenticated) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("is_authenticated", isAuthenticated);
        editor.apply();
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // Get the ID of the selected item
        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
        } else if (itemId == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SecondFragment()).commit();
        } else if (itemId == R.id.nav_share) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThirdFragment()).commit();
        } else if (itemId == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FourthFragment()).commit();
        } else if (itemId == R.id.nav_logout) {
            redirectLoginActivity();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    **/
}