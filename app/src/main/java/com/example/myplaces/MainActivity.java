package com.example.myplaces;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnExit;
    public static PlacesCollection places = new PlacesCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnExit = (Button)findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitActivity(null);
            }
        });
    }

    public void launchAbout(View view) {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }

    public void launchPlaceView(View view) {
        final EditText placeSelection = new EditText(this);
        placeSelection.setText("0");

        new AlertDialog.Builder(this)
                .setTitle("Place selection")
                .setMessage("Select ID: ")
                .setView(placeSelection)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long id = Long.parseLong(placeSelection.getText().toString());
                        Intent i = new Intent(MainActivity.this, PlaceViewActivity.class);
                        i.putExtra("id", id);
                        startActivity(i);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    public void exitActivity(View view)
    {
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; //true --> menu already visible
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_settings){
            return true;
        }

        if(id == R.id.menu_search)
        {
            launchPlaceView(null);
            return true;
        }

        if(id == R.id.menu_about)
        {
            launchAbout(null);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
