package com.example.android_agenda.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_agenda.R;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contato> {

    public ContactAdapter(Context context, ArrayList<Contato> contacts) {
        super(context, 0, contacts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contato contact = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }
        TextView nomeTextView = convertView.findViewById(R.id.nomeTextView);
        TextView emailTextView = convertView.findViewById(R.id.emailTextView);
        TextView telefoneTextView = convertView.findViewById(R.id.telefoneTextView);

        nomeTextView.setText(contact.getNome());
        emailTextView.setText(contact.getEmail());
        telefoneTextView.setText(contact.getFone());

        return convertView;
    }
}

