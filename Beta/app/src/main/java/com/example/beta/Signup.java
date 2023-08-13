package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    protected static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^"+
                    "(?=.*[0-9])" + //at least 1-digit
                    "(?=.*[a-z])" + //at least 1 lower case letter
                    "(?=.*[A-Z])" + //at least 1 upper case letter
                    "(?=.*[@#$%^&+=])" + //at least 1 special character
                    "(?=\\S+$)" + //no whitespaces
                    ".{8,}" + //at least 8 characters
                    "$");

    protected static final Pattern PHONE_PATTERN = Pattern.compile("09[0-9]{9}"); //philippine format? 09 prefix yarn

    protected final String TAG = "FIRESTORELOG"; //logs related to firebase
    protected FirebaseFirestore db; //cloud fire store
    protected EditText fullNameTxt, emailTxt, phoneTxt, passwordTxt, confirmPassTxt; //variables for edit texts
    protected AppCompatButton signUp;
    protected TextView login; //already have an account? click me
    protected TextInputLayout nameInputLayout, emailInputLayout, phoneInputLayout, passwordInputLayout, confirmInputLayout; //to output the error and set input limits
    protected String inputtedName, inputtedPhone, inputtedEmail, inputtedPassword, inputtedConfirmPass; //variable for inputted values
    protected Map<String, Object> user; //used to save user details
    protected Calendar calendar = Calendar.getInstance();
    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //year month date -- hour minute seconds
    protected String currentDate = simpleDateFormat.format(calendar.getTime()); //or currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    protected int accountNumber = generateAccountNumber();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setStatusBarColor(getResources().getColor(R.color.dark_orange));

        db = FirebaseFirestore.getInstance(); //initialize firebase fire store
        findViewById(); //reference to ui elements
        textWatchers(); //input text watchers
        inputListeners(); //input listeners

        //click signup button
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtedName = fullNameTxt.getText().toString().trim();
                String inputtedPhone = phoneTxt.getText().toString().trim();
                String inputtedEmail = emailTxt.getText().toString().trim();
                String inputtedPassword = passwordTxt.getText().toString().trim();
                String inputtedConfirmPassword = confirmPassTxt.getText().toString().trim();

                if(validateName(inputtedName) && validatePhone(inputtedPhone) && validateEmail(inputtedEmail)
                                              && validatePassword(inputtedPassword)
                                              && validateConfirmPass(inputtedPassword, inputtedConfirmPassword)){
                    createUser(inputtedName, inputtedPhone, inputtedEmail, inputtedConfirmPassword);
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //already have an account? click me
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectLoginActivity();
            } //proceeds to login activity
        });

    }

    protected int generateAccountNumber(){
        final int minCode = 10000000; // 8-digit numbers start from 100000
        final int maxCode = 99999999; // 8-digit numbers end at 999999
        Random random = new Random();
        return random.nextInt(maxCode - minCode + 1) + minCode;
    }

    protected void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    //create users collection
    protected void createUser(final String name, final String phone, final String email, final String password) {
        // Check if the email already exists in the collection
        db.collection("Users")
                .document(email) // Use the email as the document ID
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            Toast.makeText(Signup.this, "Email already taken", Toast.LENGTH_SHORT).show(); //duplicate input
                            emailTxt.setText(null); //clear duplicate input
                        } else {
                            // Email doesn't exist, create the user document
                            user = new HashMap<>();
                            user.put("accountNumber", accountNumber);
                            user.put("fullName", name);
                            user.put("phone", phone);
                            user.put("email", email);
                            user.put("password", password);
                            user.put("dateRegistered", currentDate);
                            user.put("lastLogin", "not logged in");

                            // Set the document ID as the inputted email
                            db.collection("Users")
                                    .document(email)
                                    .set(user)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "DocumentSnapshot added with ID: " + email);
                                            redirectLoginActivity();
                                            Toast.makeText(Signup.this, "Successfully Added " + name, Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Signup.this, "Error adding user " + e, Toast.LENGTH_SHORT).show();
                                            Log.d(TAG, "Error adding document", e);
                                        }
                                    });
                        }
                    }
                });
    }

    //reference to ui elements
    protected void findViewById(){
        //inputs
        fullNameTxt = (EditText) findViewById(R.id.fullNameEditTxt);
        emailTxt = (EditText) findViewById(R.id.emailEditTxt);
        phoneTxt = (EditText) findViewById(R.id.phoneEditTxt);
        passwordTxt = (EditText) findViewById(R.id.passwordEditTxt);
        confirmPassTxt = (EditText) findViewById(R.id.passwordConfirmEditTxt);
        signUp = (AppCompatButton) findViewById(R.id.buttonSignup); //actually it's not login, error in naming
        login = (TextView) findViewById(R.id.textViewLogin);
    }

    //text watchers
    protected void textWatchers(){
        fullNameTxt.addTextChangedListener(new NameTextWatcher());
        phoneTxt.addTextChangedListener(new PhoneTextWatcher());
        emailTxt.addTextChangedListener(new EmailTextWatcher());
        passwordTxt.addTextChangedListener(new PasswordTextWatcher());
        confirmPassTxt.addTextChangedListener(new ConfirmPasswordTextWatcher());
    }

    protected void inputListeners(){
        nameInputListener();
        phoneInputListener();
        emailInputListener();
        passwordInputListener();
        confirmPassInputListener();
    }

    //redirect to login
    protected void redirectLoginActivity(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class); //redirect to home after signup
        startActivity(intent);
        finish(); //close signup activity
    }

    //boolean validations
    protected Boolean validateName(String name){
        nameInputLayout = findViewById(R.id.fullNameLayout);
        fullNameTxt = nameInputLayout.getEditText();

        if (name.isEmpty()){
            fullNameTxt.requestFocus(); //cursor here
            nameInputLayout.setError("Name Required!"); //red
            return false;
        }
        else{
            nameInputLayout.setError(null); //no more red
            return true;
        }
    }

    protected Boolean validatePhone(String phone){
        phoneInputLayout = findViewById(R.id.phoneNumberLayout);
        phoneTxt = phoneInputLayout.getEditText();
        if(phone.isEmpty()){
            phoneTxt.requestFocus(); //cursor here
            phoneInputLayout.setError("Phone number required!"); //red
            return false;
        }
        else if (phone.length() != 11){
            phoneTxt.requestFocus(); //cursor here
            phoneInputLayout.setError("Phone number must be 11 digits"); //red gihapon
            return false;
        }
        else if (!PHONE_PATTERN.matcher(phone).matches()){
            phoneInputLayout.setError("Invalid Phone number"); //red gihapon
            return false;
        }
        else{
            phoneInputLayout.setError(null); //no more red
            return true;
        }
    }

    protected Boolean validateEmail(String email){
        emailInputLayout = findViewById(R.id.emailLayout);
        emailTxt = emailInputLayout.getEditText();

        if(email.isEmpty()){
            emailTxt.requestFocus(); //cursor here
            emailInputLayout.setError("Email Required!"); //red
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailTxt.requestFocus();
            emailInputLayout.setError("Invalid email!"); //red gihapon
            return false;
        }
        else if(email.length() > 50){
            emailTxt.requestFocus();
            emailInputLayout.setError("Email address cannot exceed 50 characters!"); //red gihapon
            return false;
        }
        else{
            emailInputLayout.setError(null); //no more red
            return true;
        }
    }

    protected Boolean validatePassword(String password){
        passwordInputLayout = findViewById(R.id.passwordLayout);
        passwordTxt = passwordInputLayout.getEditText();

        if(password.isEmpty()){
            passwordTxt.requestFocus(); //cursor here
            passwordInputLayout.setError("Password Required!"); //red
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(password).matches()){
            passwordInputLayout.setError("Password too weak"); //red gihapon
            return false;
        }
        else if (password.length() < 8 || password.length() > 15) {
            passwordTxt.requestFocus();
            passwordInputLayout.setError("Password must be between 8 and 15 characters!"); //red gihapon
            return false;
        }
        else {
            passwordInputLayout.setError(null); //no more red
            return true;
        }
    }

    protected Boolean validateConfirmPass(String password, String confirm){
        confirmInputLayout = findViewById(R.id.confirmPasswordLayout);
        confirmPassTxt = confirmInputLayout.getEditText();

        if(confirm.isEmpty()){
            confirmPassTxt.requestFocus(); //cursor here
            confirmInputLayout.setError("Confirm your password"); //red
            return false;
        } else if(!password.equals(confirm)){
            confirmPassTxt.requestFocus();
            confirmInputLayout.setError("Passwords do not match!"); //red gihapon
            return false;
        }
        else{
            confirmInputLayout.setError(null); //no more red
            return true;
        }
    }

    protected void nameInputListener(){
        nameInputLayout = findViewById(R.id.fullNameLayout);
        fullNameTxt = nameInputLayout.getEditText();
        assert fullNameTxt != null;
        fullNameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputtedName = fullNameTxt.getText().toString().trim();
                if (!inputtedName.isEmpty()){
                    nameInputLayout.setError(null); //triggers when name edit text input not empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    protected void phoneInputListener(){
        phoneInputLayout = findViewById(R.id.phoneNumberLayout);
        phoneTxt = phoneInputLayout.getEditText();
        assert phoneTxt != null;
        phoneTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputtedPhone = phoneTxt.getText().toString().trim();
                if (!inputtedPhone.isEmpty()){
                    phoneInputLayout.setError(null); //triggers when name edit text input not empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
                    emailInputLayout.setError(null); //triggers when name edit text input not empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
                    passwordInputLayout.setError(null); //triggers when name edit text input not empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    protected void confirmPassInputListener(){
        confirmInputLayout = findViewById(R.id.confirmPasswordLayout);
        confirmPassTxt = confirmInputLayout.getEditText();
        assert confirmPassTxt != null;
        confirmPassTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputtedConfirmPass = confirmPassTxt.getText().toString().trim();
                if (!inputtedConfirmPass.isEmpty()){
                    confirmInputLayout.setError(null); //triggers when name edit text input not empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //inner classes: text watchers used especially to limit input
    private class NameTextWatcher implements TextWatcher {
        private static final int MAX_NAME_LENGTH = 20;

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String name = editable.toString().trim();
            if (name.length() > MAX_NAME_LENGTH) {
                editable.replace(0, editable.length(), name.substring(0, MAX_NAME_LENGTH));
            }
        }
    }

    private class PhoneTextWatcher implements TextWatcher {
        private static final int MAX_PHONE_LENGTH = 11;

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String phone = editable.toString().trim();
            if (phone.length() > MAX_PHONE_LENGTH) {
                editable.replace(0, editable.length(), phone.substring(0, MAX_PHONE_LENGTH));
            }
        }
    }

    private class EmailTextWatcher implements TextWatcher{
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

    private class ConfirmPasswordTextWatcher implements TextWatcher {
        private static final int MAX_CONFIRM_PASSWORD_LENGTH = 15;

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String confirmPass = editable.toString().trim();
            if (confirmPass.length() > MAX_CONFIRM_PASSWORD_LENGTH) {
                editable.replace(0, editable.length(), confirmPass.substring(0, MAX_CONFIRM_PASSWORD_LENGTH));
            }
        }
    }

}