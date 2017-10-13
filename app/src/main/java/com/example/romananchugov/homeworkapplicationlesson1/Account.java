package com.example.romananchugov.homeworkapplicationlesson1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    private TextView nameTextView;
    private TextView surnameTextView;
    private TextView dateTextView;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        surnameTextView = (TextView) findViewById(R.id.surnameTextView);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        exitButton = (Button) findViewById(R.id.exitButton);

        SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_TAG, MODE_PRIVATE);
        nameTextView.setText(preferences.getString(MainActivity.NAME_TAG, "NAME"));
        surnameTextView.setText(preferences.getString(MainActivity.SURNAME_TAG, "SURNAME"));
        String date;
        if(preferences.getInt(MainActivity.DATE_TAG, 1) < 2) {
            date = preferences.getInt(MainActivity.DATE_TAG, 1) + " day ago";
        }else{
            date = preferences.getInt(MainActivity.DATE_TAG, 1) + " days ago";
        }
        dateTextView.setText(date);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_TAG, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("login", "");
                editor.apply();
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
