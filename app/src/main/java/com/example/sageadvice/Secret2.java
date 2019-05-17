package com.example.sageadvice;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Secret2 extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret2);
        Toolbar toolbar = findViewById(R.id.toolbartimaeus);

        setSupportActionBar(toolbar);

        //Input Stuff
        final EditText inputText = (EditText) findViewById(R.id.timInput);
        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handler = true;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String password = inputText.getText().toString().toLowerCase();
                    if (password.equals("timothy hudgeon") == true) {
                        Intent intent = new Intent(Secret2.this, Secret3.class);
                        startActivity(intent);
                    }


                } else {
                    Intent intent = new Intent(Secret2.this, Secret2.class);
                    startActivity(intent);
                }

                return handler;

            }
        });

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
                            Intent intent = new Intent(Secret2.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(Secret2.this, FAQ.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(Secret2.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.loginMenuOption) {
                            Intent intent = new Intent(Secret2.this, Login.class);
                            startActivity(intent);
                        }

                        // Add code here to update the UI based on the item selected


                        return true;
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
                Intent intent = new Intent(Secret2.this, AboutPage.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }

}
