package com.leodev.calorii;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button resultBtn;
    EditText queryInput;
    ListView queryResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uriText =
                        "mailto:voonlihhaur@gmail.com" +
                                "?subject=" + Uri.encode("Calorii App Feedback");
                Uri uri = Uri.parse(uriText);
                Intent email = new Intent(Intent.ACTION_SENDTO);
                email.setData(uri);
                startActivity(Intent.createChooser(email, "Feedback: Choose an Email client"));
            }
        });

        resultBtn = findViewById(R.id.calculateBtn);
        queryInput = findViewById(R.id.queryInput);
        queryResult = findViewById(R.id._dynamic);


        resultBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Getting result..", Snackbar.LENGTH_SHORT);
                snackbar.show();

                FoodCalorieService calorieService = new FoodCalorieService(MainActivity.this);

//                calorieService.getCalorie(queryInput.getText().toString(), new FoodCalorieService.VolleyOnEventListener() {
//                    @Override
//                    public void onSuccess(String food_calorie) {
//                         }
//
//                    @Override
//                    public void onError(String message) {
//                        demoView.setText(message);
//                    }
//                });

                calorieService.getFood(queryInput.getText().toString(), new FoodCalorieService.NutrientResponse() {
                    @Override
                    public void onSuccess(List<NutrientModel> nutrientModels) {

                        //Layout adapter
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, nutrientModels);
                        queryResult.setAdapter(arrayAdapter);


                    }


                    @Override
                    public void onError(String message) {

                        Toast.makeText(MainActivity.this, "Invalid request", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }

}