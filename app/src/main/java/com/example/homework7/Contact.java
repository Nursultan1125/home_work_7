package com.example.homework7;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    private String name;
    private String phone;
    private String email;
    private String website;

    public Contact(String name, String phone, String email, String website){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.website = website;

    }

    public Contact(String name, String phone, String email){
        this(name, phone, email, "");
    }

    public Contact(String name, String phone){
        this(name, phone, "", "");
    }


    protected Contact(Parcel in) {
        name = in.readString();
        phone = in.readString();
        email = in.readString();
        website = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(website);
    }
}
