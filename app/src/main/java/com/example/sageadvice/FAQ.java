package com.example.sageadvice;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;


public class FAQ extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        //Set up for menu option in toolbar
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        drawerLayout = findViewById(R.id.drawer_layout);

        //Add Functionality to Menu Options
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
                            Intent intent = new Intent(FAQ.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(FAQ.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(FAQ.this, FAQ.class);
                            startActivity(intent);
                        } else if (item == R.id.loginMenuOption) {
                            Intent intent = new Intent(FAQ.this, Login.class);
                            startActivity(intent);
                        }


                        return true;
                    }
                });
        //End of Menu Options Functions

        final ImageView firstImage = (ImageView) findViewById(R.id.SageGoodLooking);
        Glide.with(this)
                .load(R.drawable.p_why_goat)
                .into(firstImage);


        //makes image 1 clickable and change image when clicked
        firstImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstImage.setImageResource(R.drawable.why_is_goat);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Goes to next screen
                        Intent intent = new Intent(FAQ.this, Answers.class);
                        //sends a question id so answer.class knows what response to return to user
                        intent.putExtra("questionID", 1);
                        startActivity(intent);
                    }
                }, 0);
            }

        });


        final ImageView secondImage = (ImageView) findViewById(R.id.sageObjective);
        Glide.with(this)
                .load(R.drawable.p_sage_objective)
                .into(secondImage);

        secondImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondImage.setImageResource(R.drawable.sage_objective);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Goes to next screen
                        Intent intent = new Intent(FAQ.this, Answers.class);
                        //sends a question id so answer.class knows what response to return to user
                        intent.putExtra("questionID", 2);
                        startActivity(intent);
                    }
                }, 0);
            }

        });


        final ImageView thirdImage = (ImageView) findViewById(R.id.benefitMe);
        Glide.with(this)
                .load(R.drawable.p_benefit_me)
                .into(thirdImage);

        thirdImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdImage.setImageResource(R.drawable.benefit_me);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Goes to next screen
                        Intent intent = new Intent(FAQ.this, Answers.class);
                        //sends a question id so answer.class knows what response to return to user
                        intent.putExtra("questionID", 3);
                        startActivity(intent);
                    }
                }, 0);
            }

        });


        final ImageView fourthImage = (ImageView) findViewById(R.id.sageImpact);
        Glide.with(this)
                .load(R.drawable.p_sage_impact)
                .into(fourthImage);

        fourthImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourthImage.setImageResource(R.drawable.sage_impact);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Goes to next screen
                        Intent intent = new Intent(FAQ.this, Answers.class);
                        //sends a question id so answer.class knows what response to return to user
                        intent.putExtra("questionID", 4);
                        startActivity(intent);
                    }
                }, 0);
            }

        });


        final ImageView fifthImage = (ImageView) findViewById(R.id.helpSageGoat);
        Glide.with(this)
                .load(R.drawable.p_help_sage)
                .into(fifthImage);

        fifthImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fifthImage.setImageResource(R.drawable.help_sage);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Goes to next screen
                        Intent intent = new Intent(FAQ.this, Answers.class);
                        //sends a question id so answer.class knows what response to return to user
                        intent.putExtra("questionID", 5);
                        startActivity(intent);
                    }
                }, 0);
            }

        });

        final ImageView sixthImage = (ImageView) findViewById(R.id.whereGoatSage);
        Glide.with(this)
                .load(R.drawable.p_where_goat)
                .into(sixthImage);

        sixthImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sixthImage.setImageResource(R.drawable.where_goat);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Goes to next screen
                        Intent intent = new Intent(FAQ.this, Answers.class);
                        //sends a question id so answer.class knows what response to return to user
                        intent.putExtra("questionID", 6);
                        startActivity(intent);
                    }
                }, 0);
            }

        });

    }

    //makes drawer open when menu option is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}//end of entire class
