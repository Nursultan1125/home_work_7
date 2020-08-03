package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CreateContactActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText, phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creact_contact);
        nameEditText = findViewById(R.id.contactNameEditText);
        emailEditText = findViewById(R.id.contactEmailEditText);
        phoneEditText = findViewById(R.id.contactPhoneEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_contact_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String email = emailEditText.getText().toString();

        Contact contact = new Contact(name, phone, email);

        switch (item.getItemId()) {
            case R.id.saveContactMenuItem:

                Intent intent = new Intent();
                intent.putExtra(Contact.class.getSimpleName(), contact);
                setResult(RESULT_OK, intent);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}