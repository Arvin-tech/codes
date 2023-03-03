package com.example.registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class UpdateFragment extends Fragment {
    final String TAG = "UPDATE";
    View view;
    EditText emailTxt, passWordTxt;
    Button searchButton, updateButton;
    FirebaseUser user;
    String updatedEmail, updatedPassword;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        user = FirebaseAuth.getInstance().getCurrentUser();
        view = inflater.inflate(R.layout.fragment_update, container, false);
        emailTxt = view.findViewById(R.id.editTextTextEmailAddress3);
        passWordTxt = view.findViewById(R.id.editTextTextPassword);
        searchButton = view.findViewById(R.id.buttonSearch);
        updateButton = view.findViewById(R.id.buttonUpdate);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameValue = emailTxt.getText().toString(); //value from username edit text
                //validation
                if(!userNameValue.isEmpty()){

                }
                else{
                    showToast("Please make sure there are no empty fields!");
                }
            }
        });

        //UPDATE BUTTON CLICK
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedEmail = emailTxt.getText().toString();
                updatedPassword = passWordTxt.getText().toString();
                AuthCredential credential = EmailAuthProvider.getCredential(updatedEmail, updatedPassword);
                //validation
                if(!updatedEmail.isEmpty() && !updatedPassword.isEmpty()){
                    reAuth(credential); //re-authenticate method has the update method
                }
                else{
                    showToast("Please make sure there are no empty fields!");
                }

            }
        });
        return view;
    }

    //re-authenticate
    private void reAuth(AuthCredential credential){
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User re-authenticated.");
                            update(updatedEmail,updatedPassword);
                        } else {
                            Log.d(TAG, "User re-authentication failed.");
                        }
                    }
                });
    }

    //update method
    private void update(String email, String password){
        //update the email
        user.updateEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG,"Email Successfully Updated");
                        }
                        else{
                            showToast("Failed to update!");
                        }
                    }
                });
        //update the password
        user.updatePassword(password)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "Password updated.");
                        }
                        else{
                            showToast("Failed to update!");
                        }
                    }
                });
        //records are updated
        showToast("Record Successfully Updated!");
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
    public void search(String username){
        //search user
        database.collection("users").document(username)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        String queriedPassword = documentSnapshot.getString("password");

                        Log.d("Firestore", "Data read from Firestore: " + documentSnapshot.getData());
                        if(queriedPassword == null){
                                showToast("User does not exist!");
                        }else{
                            passWordTxt.setText(queriedPassword);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Firestore", "Error reading data from Firestore: " + e.getMessage());
                    }
                });
    }**/

    /**
    public void update(String username, String passwordInput){
        //update code
        database.collection("UserData").document(username).update("password", passwordInput)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        showToast("Update Successful!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        showToast("Failed to Update");
                    }
                });
    }**/



}