package com.example.romananchugov.homeworkapplicationlesson1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button accountButton;
    private Button cardsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        accountButton = (Button) findViewById(R.id.accountMenuButton);
        cardsButton = (Button) findViewById(R.id.cardsMenuButton);

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Account.class));
            }
        });
        cardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), RecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
