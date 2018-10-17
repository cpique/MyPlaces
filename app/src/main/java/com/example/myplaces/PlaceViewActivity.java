package com.example.myplaces;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;

public class PlaceViewActivity extends AppCompatActivity {

    private long id;
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_view);

        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id", -1);

        //region validation of id
        if(id >= MainActivity.places.size())
        {
            Toast.makeText(this, "No se ha encontrado el lugar asociado al ID ingresado. Prueba con otro identificador", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        //endregion
        else {
            place = MainActivity.places.get((int) id);

            //region setData
            TextView name = (TextView) findViewById(R.id.namePlace);
            name.setText(place.getName());

            ImageView logo = (ImageView) findViewById(R.id.logoType);
            logo.setImageResource(place.getType().getResource());

            TextView type = (TextView) findViewById(R.id.type);
            type.setText(place.getType().getText());

            if (place.getAddress().isEmpty()) {
                findViewById(R.id.address).setVisibility(View.GONE);
                findViewById(R.id.logoAddress).setVisibility(View.GONE);
            } else {
                TextView address = (TextView) findViewById(R.id.address);
                address.setText(place.getAddress());
            }

            if (place.getPhone() == 0) {
                findViewById(R.id.phone).setVisibility(View.GONE);
                findViewById(R.id.phoneType).setVisibility(View.GONE);
            } else {
                TextView phone = (TextView) findViewById(R.id.phone);
                phone.setText(Long.toString(place.getPhone()));
            }

            if (place.getUrl().isEmpty()) {
                findViewById(R.id.url).setVisibility(View.GONE);
                findViewById(R.id.urlType).setVisibility(View.GONE);
            } else {
                TextView url = (TextView) findViewById(R.id.url);
                url.setText(place.getUrl());
            }

            if (place.getComment().isEmpty()) {
                findViewById(R.id.comment).setVisibility(View.GONE);
                findViewById(R.id.commentType).setVisibility(View.GONE);
            } else {
                TextView comment = (TextView) findViewById(R.id.comment);
                comment.setText(place.getComment());
            }

            TextView date = (TextView) findViewById(R.id.date);
            date.setText(DateFormat.getInstance().format(new Date(place.getDate())));

            TextView hour = (TextView) findViewById(R.id.hour);
            hour.setText(DateFormat.getInstance().format(new Date(place.getDate())));
            //endregion

            //region RatingBar
            RatingBar ranking = (RatingBar) findViewById(R.id.ranking);
            ranking.setRating(place.getRanking());
            ranking.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    place.setRanking(rating);
                }
            });
        }
        //endregion

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.place_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_share:
                return true;
            case R.id.action_go:
                return true;
            case R.id.action_edit:
                editPlace(id);
                return true;
            case R.id.action_delete:
                deletePlace(id);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void killActivity()
    {
        finish();
    }

    public void deletePlace(final long id)
    {
        new AlertDialog.Builder(this)
                .setTitle("Delete place")
                .setMessage("Are you sure you want to delete this place?")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.places.delete((int)id);
                        finish();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();

    }

    public void editPlace(final long id)
    {
        Intent i = new Intent(PlaceViewActivity.this, PlaceEditActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }
}
