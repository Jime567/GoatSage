package com.example.sageadvice;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This is absolutely essential for the toolbar to work, else it is null
        setContentView(R.layout.activity_login);

        //Toolbar stuff, bar across top with menu option
        Toolbar toolbar4 = findViewById(R.id.toolbarter);
        ActionBar actionbar;
        setSupportActionBar(toolbar4);

        //menu button option, top-left
        actionbar = getSupportActionBar();
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
                            Intent intent = new Intent(Login.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(Login.this, FAQ.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.loginMenuOption) {
                            Intent intent = new Intent(Login.this, Login.class);
                            startActivity(intent);
                        }
                        // Add code here to update the UI based on the item selected


                        return true;
                    }
                });


    }

    public void loginMethod(View v) {
        final EditText password = findViewById(R.id.loginPasswordText);
        String passwordText = password.getText().toString();
        final EditText username = findViewById(R.id.loginText);
        String usernameText = username.getText().toString();

        databaseHelper db = new databaseHelper(Login.this);
        db.getReadableDatabase();

        if (db.authenticateUser(passwordText, usernameText) == true) {
            Intent intent = new Intent(Login.this, portal.class);
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

            startActivity(intent);
        } else if (db.authenticateUser(passwordText, usernameText) == false) {
            Toast.makeText(getApplicationContext(), "Username or Password Not Recognized", Toast.LENGTH_LONG).show();

        }
    }

    //makes drawer open when menu button is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.aboutOption:
                Intent intent = new Intent(Login.this, AboutPage.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }
}
