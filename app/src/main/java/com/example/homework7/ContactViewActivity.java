package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class ContactViewActivity extends AppCompatActivity {

    TextView nameTextView, phoneTextView, emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        nameTextView = findViewById(R.id.contactNameTextView);
        phoneTextView = findViewById(R.id.contactPhoneTextView);
        emailTextView = findViewById(R.id.contactEmailTextView);

        Contact contact = getIntent().getParcelableExtra(
                Contact.class.getSimpleName());

        if(contact != null){
            nameTextView.setText(contact.getName());
            phoneTextView.setText(contact.getPhone());
            emailTextView.setText(contact.getEmail());
        }

    }
}