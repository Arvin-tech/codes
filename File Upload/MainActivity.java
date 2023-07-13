package com.example.fileupload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button chooseButton, uploadButton;
    private TextView showUploads;
    private EditText fileName;
    private ImageView imageView;
    private ProgressBar progressBar;
    private Uri imageUri;

    private StorageReference storageRef; //cloud storage reference
    private DatabaseReference databaseReference;
    private StorageTask uploadTask; //for anti duplication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        storageRef = FirebaseStorage.getInstance().getReference("uploads");
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");

        //choose file
        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
                //String inputtedFileName = fileName.getText().toString();
            }
        });

        //upload file
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This suggests that only one upload task should be active at a time.
                if(uploadTask != null && uploadTask.isInProgress()){
                    Toast.makeText(MainActivity.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                }else{
                    uploadFile();
                }
            }
        });

        //display uploads
        showUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUploads(); //invoke
            }
        });
    }

    protected void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*"); //to only see images in file chooser
        intent.setAction(Intent.ACTION_GET_CONTENT); //Access intent class and take consent of it
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    //get image file extension
    protected String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
    }
    protected void uploadFile(){
        if(imageUri != null){
            /*
            file in the storage should have a unique name, otherwise we will over write files with the same name
            the easiest way to get a unique name is to take current time in milliseconds, because it's increasing fast that
            we will never get the same number twice
            */
         StorageReference fileReference = storageRef.child(System.currentTimeMillis() + "." + getFileExtension(imageUri)); //load uri
            uploadTask= fileReference.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0); //set to zero
                                }
                            }, 500); //delay the reset of progress bar for 5 seconds

                            Toast.makeText(MainActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
                            Upload upload = new Upload(fileName.getText().toString().trim(), taskSnapshot.getMetadata().getReference().getDownloadUrl().toString()); //constructor
                            String uploadId = databaseReference.push().getKey(); //new id
                            databaseReference.child(uploadId).setValue(upload);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            //update progress bar in ui
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressBar.setProgress((int) progress);
                        }
                    });
        }else{
            Toast.makeText(this,"No file selected", Toast.LENGTH_SHORT).show();
        }
    }

    protected void showUploads(){
        Intent intent = new Intent(this, Images.class);
        startActivity(intent);
    }

    //control + O
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();
            //load image to image view
            Picasso.get().load(imageUri).into(imageView);
        }
    }

    protected void findViewById(){
        chooseButton = findViewById(R.id.button_choose_image);
        uploadButton = findViewById(R.id.button_upload);
        showUploads = findViewById(R.id.text_view_show_uploads);
        fileName = findViewById(R.id.edit_text_file_name);
        imageView = findViewById(R.id.image_view);
        progressBar = findViewById(R.id.progress_bar);
    }
}