package com.example.myplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class PlaceEditActivity extends AppCompatActivity {

    private long id;
    private Place place;
    private EditText name;
    private Spinner type;
    private EditText address;
    private EditText phone;
    private EditText url;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_edition);

        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id", -1);

        //region validation of id
        place = MainActivity.places.get((int) id);

        //region setData
        name = (EditText) findViewById(R.id.txtName);
        name.setText(place.getName());

        type = (Spinner) findViewById(R.id.spinnerType);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                                 android.R.layout.simple_spinner_item,
                                                                 TypePlace.getNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
        type.setSelection(place.getType().ordinal());

        address = (EditText) findViewById(R.id.txtAddress);
        address.setText(place.getAddress());

        phone = (EditText) findViewById(R.id.txtPhone);
        phone.setText(Long.toString(place.getPhone()));

        url = (EditText) findViewById(R.id.txtUri);
        url.setText(place.getUrl());

        comment = (EditText) findViewById(R.id.txtComment);
        comment.setText(place.getComment());

        //endregion
    }
}



