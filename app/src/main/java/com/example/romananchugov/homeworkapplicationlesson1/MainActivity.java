package com.example.romananchugov.homeworkapplicationlesson1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_TAG = "NAME";
    public static final String SURNAME_TAG = "SURNAME";
    public static final String DATE_TAG = "DATE";
    public static final String PREF_TAG = "PREFERENCES";

    private HashMap<String, String> users;
    private HashMap<String, Integer> usersDate;
    private HashMap<String, String> usersName;
    private HashMap<String, String> usersSurname;

    private Button loginButton;
    private EditText passwordEditText;
    private EditText loginEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(PREF_TAG, MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        users = new HashMap<>();
        usersDate  = new HashMap<>();
        usersName = new HashMap<>();
        usersSurname = new HashMap<>();


        users.put("Roma1", "1");
        users.put("Roma2", "2");
        users.put("Roma3", "3");
        users.put("Roma4", "4");
        users.put("Roma5", "5");

        usersDate.put("Roma1", 1);
        usersDate.put("Roma2", 2);
        usersDate.put("Roma3", 3);
        usersDate.put("Roma4", 4);
        usersDate.put("Roma5", 5);

        usersName.put("Roma1", "Roma");
        usersName.put("Roma2", "Tolya");
        usersName.put("Roma3", "Zhora");
        usersName.put("Roma4", "Zhopa");
        usersName.put("Roma5", "Zhizha");

        usersSurname.put("Roma1", "Anchugov");
        usersSurname.put("Roma2", "Priposov");
        usersSurname.put("Roma3", "Kekov");
        usersSurname.put("Roma4", "Loliks");
        usersSurname.put("Roma5", "Dibich");

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.loginButton = (Button) findViewById(R.id.loginButton);
                loginEditText = (EditText) findViewById(R.id.loginEditText);
                passwordEditText = (EditText) findViewById(R.id.passwordEditText);

                String login = loginEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(!login.equals("") && !password.equals("")){
                    if(users.containsKey(login) && users.get(login).equals(password)){
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                        editor.putString("login", loginEditText.getText().toString());
                        editor.putString("password", passwordEditText.getText().toString());
                        editor.putString(NAME_TAG, usersName.get(login));
                        editor.putString(SURNAME_TAG, usersSurname.get(login));
                        editor.putInt(DATE_TAG, usersDate.get(login));

                        editor.apply();
                        editor.commit();

                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Incorrect login\\password", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


        if(preferences.contains("login") && !preferences.getString("login", "login").equals("") && preferences.contains("password")){
            Toast.makeText(getApplicationContext(), preferences.getString("login", "login1") + " " + preferences.getString("password", "password1"), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        }


    }
}
