package com.example.sageadvice;

import android.content.Intent;
import android.provider.BaseColumns;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class Secret3 extends AppCompatActivity {


    private DrawerLayout drawerLayout;

    public void dataToSQL(View v) {
        final EditText password = (findViewById(R.id.confirmPassword));


        boolean handler = true;


        String passwordText = password.getText().toString();
        final EditText userName = (findViewById(R.id.userName));
        String userNameText = userName.getText().toString();
        User person = new User();
        person.setUserName(userNameText);
        person.setPassWord(passwordText);
        databaseHelper db = new databaseHelper(Secret3.this);
        db.addUser(person);
        Toast.makeText(getApplicationContext(), "Consider Yourself Registered With The Goat Sage League", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Secret3.this, Login.class);
        startActivity(intent);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret3);

        Toolbar toolbar2 = findViewById(R.id.toolbarty);

        setSupportActionBar(toolbar2);


        //menu button option, top-left
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();
                        int item = menuItem.getItemId();
                        if (item == R.id.meditation) {
                            Intent intent = new Intent(Secret3.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(Secret3.this, FAQ.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(Secret3.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.loginMenuOption) {
                            Intent intent = new Intent(Secret3.this, Login.class);
                            startActivity(intent);
                        }

                        // Add code here to update the UI based on the item selected


                        return true;
                    }
                });

        final Button button = findViewById(R.id.submission);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dataToSQL(v);
            }
        });


    }


    //makes drawer open when menu button is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.aboutOption:
                Intent intent = new Intent(Secret3.this, AboutPage.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }

}
