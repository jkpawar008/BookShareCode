package com.example.simpleloginapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.sql.BatchUpdateException;
import java.util.Objects;

public class FirstUpload extends AppCompatActivity {
    private Button upload;
    private Button next;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference bookCollection = db.collection("bookCollection");
    private EditText nameEditText;
    private EditText authorEditText;
    private EditText genreEditText;
    private EditText isbnEditText;
    private EditText reviewEditText;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String userEmail;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_upload);

    }

    public void onClickUpload(View view) {
        upload = (Button) findViewById(R.id.uploadbutt);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText = findViewById(R.id.editText3);
                authorEditText = findViewById(R.id.editText4);
                isbnEditText = findViewById(R.id.editText5);
                genreEditText = findViewById(R.id.editText6);
                reviewEditText = findViewById(R.id.editText7);
                name = nameEditText.getText().toString();
                String author = authorEditText.getText().toString();
                String isbn = isbnEditText.getText().toString();
                String genre = genreEditText.getText().toString();
                String review = reviewEditText.getText().toString();
                userEmail = Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();
                Log.d("useremail", userEmail);
                bookModel book = new bookModel(name, genre, isbn, author, review, userEmail);
                bookCollection.add(book);
                Intent intent = new Intent(FirstUpload.this,bookImageActivity.class);
                intent.putExtra("bookname",name);
                startActivity(intent);
            }
        });
    }

    public void onClickNext(View view) {
        next = (Button) findViewById(R.id.nextbutt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".Main3Activity");
                startActivity(intent);

            }
        });
    }
}