package com.example.otptmove;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class therapistList extends ArrayAdapter<profile> {

    private Activity context;
    private List<profile> TherapistList;

    public therapistList(Activity context, List<profile> TherapistList){
        super(context, R.layout.list_layout, TherapistList);
        this.context = context;
        this.TherapistList = TherapistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewType = listViewItem.findViewById(R.id.textViewType);

        profile Profile = TherapistList.get(position);

        textViewName.setText(Profile.getTherapistName());
        textViewType.setText(Profile.getTherapistType());
        return listViewItem;
    }
}
