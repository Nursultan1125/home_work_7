package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView contactListView;
    ContactAdapter contactAdapter;
    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactListView = findViewById(R.id.contactList);

        contacts.add(new Contact("Nurs", "+(996) 777555 555"));
        contacts.add(new Contact("Alex", "+(996) 777555 555"));
        contacts.add(new Contact("Galia", "+(996) 777555 555"));
        contacts.add(new Contact("Batmen", "+(996) 777555 555"));
        contacts.add(new Contact("Nurs", "+(996) 777555 555"));
        contacts.add(new Contact("Nurs", "+(996) 777555 555"));
        contacts.add(new Contact("Nurs", "+(996) 777555 555"));
        contactAdapter = new ContactAdapter(this, contacts);
        contactAdapter.setOnClickItemListener(new ContactAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(MainActivity.this, ContactViewActivity.class);
                intent.putExtra(Contact.class.getSimpleName(), contacts.get(position));
                startActivity(intent);
            }
        });
        contactListView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        contactListView.setAdapter(contactAdapter);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        Contact contact = data.getParcelableExtra(Contact.class.getSimpleName());
        contacts.add(contact);
        contactAdapter.notifyDataSetChanged();
    }


    public void onCLickFAB(View view) {
        Intent intent = new Intent(this, CreateContactActivity.class);
        startActivityForResult(intent, 2);
    }
}