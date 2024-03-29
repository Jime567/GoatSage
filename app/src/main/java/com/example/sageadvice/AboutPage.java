package com.example.sageadvice;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AboutPage extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        //Sets up tool bar (made in xml file) to be action bar to hold all the icons and menus
        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        //Set up for menu option in toolbar
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        drawerLayout = findViewById(R.id.drawer_layout);


        //Add Functionality to Menu Options
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(//this line fails without proper xml stuff
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();
                        int item = menuItem.getItemId();
                        if (item == R.id.meditation) {
                            Intent intent = new Intent(AboutPage.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(AboutPage.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(AboutPage.this, FAQ.class);
                            startActivity(intent);
                        } else if (item == R.id.loginMenuOption) {
                            Intent intent = new Intent(AboutPage.this, Login.class);
                            startActivity(intent);
                        }


                        return true;
                    }
                });
        //End of Menu Options Functions

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void secretTracker(View v) {
        int temp = ((GlobalVariables) this.getApplication()).getSecretTrack();
        temp += 1;
        ((GlobalVariables) this.getApplication()).setSecretTrack(temp);
        temp = ((GlobalVariables) this.getApplication()).getSecretTrack();

        if (temp == 4) {

            Toast.makeText(getApplicationContext(), "Click Once More to Enter Secret Mode", Toast.LENGTH_LONG).show();
        } else if (temp == 5) {
            ((GlobalVariables) this.getApplication()).setSecretTrack(0);
            Intent intent = new Intent(this, Secret2.class);
            startActivity(intent);

        }

    } //end of secretTracker
}
