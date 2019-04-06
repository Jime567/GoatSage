package com.example.sageadvice;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);
        Intent intent = getIntent();

        final DrawerLayout drawerLayout;
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
                            Intent intent = new Intent(DisplayScreen.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(DisplayScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(DisplayScreen.this, FAQ.class);
                            startActivity(intent);
                        }
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
        ImageView mImageView = (ImageView) findViewById(R.id.menu_button_zippo);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });

    }
}
