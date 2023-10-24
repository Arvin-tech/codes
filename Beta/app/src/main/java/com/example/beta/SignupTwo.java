package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class SignupTwo extends AppCompatActivity {
    protected final String TAG = "FIRESTORELOG"; //logs related to firebase
    protected static final Pattern PHONE_PATTERN = Pattern.compile("09[0-9]{9}"); //philippine format? 09 prefix yarn
    protected EditText firstNameTxt, lastNameTxt, phoneTxt;
    protected TextInputLayout firstNameLayout, lastNameLayout, phoneLayout;
    protected AppCompatButton signUp;
    protected String inputtedFirstName, inputtedLastName, inputtedPhone; //input variables for this activity/page
    protected String userEmail, userPassword, userConfirmPassword; //variables for user data sent from step 1
    protected FirebaseFirestore db; //cloud fire store
    protected Map<String, Object> user; //used to save user details
    protected int accountNumber = generateAccountNumber();
    protected int verificationCode = generateVerificationCode(); //used for signup process
    protected Calendar calendar = Calendar.getInstance();
    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //year month date -- hour minute seconds
    protected String currentDate = simpleDateFormat.format(calendar.getTime()); //or currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    protected int redColor = Color.parseColor("#FF0000");
    protected DatePickerDialog datePickerDialog; //for date of birth
    protected Button dateButton; //dob button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_two);

        setStatusBarColor(getResources().getColor(R.color.light_gray));

        db = FirebaseFirestore.getInstance();
        findViewById(); //method that creates reference to ui elements
        inputListeners();
        initDatePicker();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtedFirstName = firstNameTxt.getText().toString();
                inputtedLastName = lastNameTxt.getText().toString();
                inputtedPhone = phoneTxt.getText().toString();
                saveToFirebase(); //method call
            }
        });
    }

    protected void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    private void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "January";
        if(month == 2)
            return "February";
        if(month == 3)
            return "March";
        if(month == 4)
            return "April";
        if(month == 5)
            return "May";
        if(month == 6)
            return "June";
        if(month == 7)
            return "July";
        if(month == 8)
            return "August";
        if(month == 9)
            return "September";
        if(month == 10)
            return "October";
        if(month == 11)
            return "November";
        if(month == 12)
            return "December";
        //default should never happen
        return "January";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }

    protected  void findViewById(){
        firstNameTxt = (EditText) findViewById(R.id.firstNameEditTxt);
        lastNameTxt = (EditText) findViewById(R.id.lastNameEditTxt);
        phoneTxt = (EditText) findViewById(R.id.phoneEditTxt);
        signUp = (AppCompatButton) findViewById(R.id.buttonSignup);
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
    }

    protected void inputListeners(){
        firstNameInputListener();
        lastNameInputListener();
        phoneInputListener();
    }

    protected void getSignupPageData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            userEmail = extras.getString("email");
            userPassword = extras.getString("password");
            userConfirmPassword = extras.getString("confirm");
        }
    }

    //this method creates a user account and save details to firebase
    protected void saveToFirebase(){
        user = new HashMap<>();
        user.put("accountNumber", accountNumber); //generated account number
        user.put("dateRegistered", currentDate);

        //data from Step1
        user.put("email", userEmail);
        user.put("password", userConfirmPassword);

        //data from step 2
        user.put("firstname", inputtedFirstName);
        user.put("lastname", inputtedLastName);
        user.put("phone", inputtedPhone);

        // Set the document ID as the inputted email
        db.collection("Users")
                .document(userEmail)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + userEmail);
                        redirectLoginActivity();
                        //Toast.makeText(Signup.this, "Successfully Added " + name, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignupTwo.this, "Error adding user " + e, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Error adding document", e);
                    }
                });
    }

    protected void redirectLoginActivity(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish(); //close signup two (step 2) activity
    }

    protected int generateAccountNumber() {
        final int minCode = 10000000; // 8-digit numbers start from 100000
        final int maxCode = 99999999; // 8-digit numbers end at 999999
        Random random = new Random();
        return random.nextInt(maxCode - minCode + 1) + minCode;
    }

    protected int generateVerificationCode(){
        final int minCode = 10000000; // 8-digit numbers start from 100000
        final int maxCode = 99999999; // 8-digit numbers end at 999999
        Random random = new Random();
        return random.nextInt(maxCode - minCode + 1) + minCode;
    }

    //boolean validations : firstname, lastname, contact number
    protected Boolean validateFirstName(String name){
        firstNameLayout = findViewById(R.id.firstNameLayout);
        firstNameTxt = firstNameLayout.getEditText();
        if(name.isEmpty()){
            firstNameTxt.requestFocus(); //cursor here
            firstNameLayout.setError("First Name Required!");
            return false;
        }
        else{
            firstNameLayout.setError(null);
            return true;
        }
    }

    protected Boolean validateLastName(String name){
        lastNameLayout = findViewById(R.id.lastNameLayout);
        lastNameTxt = lastNameLayout.getEditText();
        if (name.isEmpty()){
            lastNameTxt.requestFocus(); //cursor here
            lastNameLayout.setError("Last Name Required!"); //red
            return false;
        }
        else{
            lastNameLayout.setError(null); //no more red
            return true;
        }
    }

    protected Boolean validatePhone(String phone){
        phoneLayout = findViewById(R.id.phoneNumberLayout);
        phoneTxt = phoneLayout.getEditText();
        if(phone.isEmpty()){
            phoneTxt.requestFocus(); //cursor here
            phoneLayout.setError("Phone number required!"); //red
            return false;
        }
        else if (phone.length() != 11){
            phoneTxt.requestFocus(); //cursor here
            phoneLayout.setError("Phone number must be 11 digits"); //red gihapon
            return false;
        }
        else if (!PHONE_PATTERN.matcher(phone).matches()){
            phoneLayout.setError("Invalid Phone number"); //red gihapon
            return false;
        }
        else{
            phoneLayout.setError(null); //no more red
            return true;
        }
    }

    //Input listeners
    protected void firstNameInputListener(){
        firstNameLayout = findViewById(R.id.firstNameLayout);
        firstNameTxt = firstNameLayout.getEditText();
        assert firstNameTxt != null;
        firstNameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputtedFirstName = firstNameTxt.getText().toString().trim();
                if (!inputtedFirstName.isEmpty()){
                    firstNameLayout.setError(null); //triggers when name edit text input not empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        firstNameLayout.setErrorTextColor(ColorStateList.valueOf(redColor));
    }

    private void lastNameInputListener() {
        lastNameLayout = findViewById(R.id.lastNameLayout);
        lastNameTxt = lastNameLayout.getEditText();

    }

    protected void phoneInputListener(){
        phoneLayout = findViewById(R.id.phoneNumberLayout);
        phoneTxt = phoneLayout.getEditText();
        assert phoneTxt != null;
        phoneTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputtedPhone = phoneTxt.getText().toString().trim();
                if (!inputtedPhone.isEmpty()){
                    phoneLayout.setError(null); //triggers when name edit text input not empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        phoneLayout.setErrorTextColor(ColorStateList.valueOf(redColor));
    }
}