package com.example.homework7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Contact> contacts;
    private ClickListener onClickItemListener;

    public ContactAdapter(Context context, ArrayList<Contact> contacts){
        this.inflater = LayoutInflater.from(context);
        this.contacts = contacts;
    }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contact_item_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, final int position) {
        Contact contact = contacts.get(position);
        holder.letterName.setText(String.valueOf(contact.getName().charAt(0)));
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
        if(onClickItemListener != null)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemListener.onItemClick(position, v);
                }
            });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setOnClickItemListener(ClickListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView letterName, name, phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            letterName = itemView.findViewById(R.id.letterContact);
            name = itemView.findViewById(R.id.nameContact);
            phone = itemView.findViewById(R.id.phoneContact);
        }
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
