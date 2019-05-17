package com.example.sageadvice;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class portal extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);


        //Toolbar stuff, bar across top with menu option
        Toolbar toolbar4 = findViewById(R.id.toolbartering);
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
                            Intent intent = new Intent(portal.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(portal.this, FAQ.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(portal.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.loginMenuOption) {
                            Intent intent = new Intent(portal.this, Login.class);
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
                Intent intent = new Intent(portal.this, AboutPage.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }
}
