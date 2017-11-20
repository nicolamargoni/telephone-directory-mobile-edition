package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.R;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.ContactClickListener;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private ArrayList<Contact> contacts;
    private ContactClickListener clickListener;


    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        private ContactClickListener clickListener;
        @BindView(R.id.textView_name_surname)
        public TextView textView_name_surname;

        @BindView(R.id.textView_telephoneNumber)
        public TextView textView_telephoneNumber;

        @OnClick(R.id.button_edit)
        public void onClickButtonEdit() {
            clickListener.onClickEdit(getAdapterPosition());
        }

        public ContactViewHolder(View v, ContactClickListener clickListener) {
            super(v);
            ButterKnife.bind(this, v);
            this.clickListener = clickListener;
        }
    }

    public ContactAdapter(ArrayList<Contact> contacts, ContactClickListener clickListener) {
        this.contacts = contacts;
        this.clickListener = clickListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,
                parent, false);

        ContactViewHolder vh = new ContactViewHolder(view, clickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.textView_name_surname.setText(contacts.get(position).firstName + " " + contacts.get(position).lastName);
        holder.textView_telephoneNumber.setText(contacts.get(position).telephoneNumber);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
