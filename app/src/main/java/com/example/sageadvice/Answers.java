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
import android.widget.TextView;

public class Answers extends AppCompatActivity {
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        //Sets up tool bar (made in xml file) to be action bar to hold all the icons and menus
        Toolbar toolbar = findViewById(R.id.toolbar3);
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
                            Intent intent = new Intent(Answers.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.home_button) {
                            Intent intent = new Intent(Answers.this, MainActivity.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(Answers.this, FAQ.class);
                            startActivity(intent);
                        }


                        return true;
                    }
                });
        //End of Menu Options Functions

        /* Roughly how one would go about receiving the message from FAQ.class

        Bundle bundle = getIntent().getExtras();
        int code = bundle.getInt("message");*/

        Bundle bundle = getIntent().getExtras();
        int code = bundle.getInt("questionID");
        TextView title = findViewById(R.id.questionsText);
        TextView response = findViewById(R.id.answerText);

        if (code == 1) {
            title.setText("Why is Goat Sage so Good Looking?");
            response.setText("   First, the fact your are asking this question shows how observant your are. Second, the fact this question in particular is frequently asked shows there is still hope for the majority of users. Now to answer: it is because when one is as intelligent as Sage Goat, they can not simply help but to be amazing in every other aspect too. ");
        } else if (code == 2) {
            title.setText("What is the Goat Sage Objective?");
            response.setText("   Goat Sage has five primary objectives. First, improve literacy rates worldwide. Second, spread the Goat Sage movement. Third, to put pants on all chiddlers. Fourth, to improve the quality of life for all. Fifth, to do all the previous thingers in the most epic ways possible.");
        } else if (code == 3) {
            title.setText("How does Goat Sage benefit me?");
            response.setText("   Goat Sage benefits any of his users by providing the most up to date and relevant facts and advice for whatever the situation. He is an awesome party asset, bodyguard, and fashion advisor. He also single handedly improves the lives of many poor peoples around the world at the same time. For you specifically, he can tell you when your ideas are bad, when your forgot your clothes, and where to go to get mugged by his associates.");
        } else if (code == 4) {
            title.setText("Global Goat Sage Impact?");
            response.setText("   On the global scale, Goat Sage is a major contributor to three-hundred charities humanitarian efforts (only one of which he does not own *Ramen Noodle Co.*). Goat Sage also provides wifi to impoverished places and works closely with the big corporations to make as much money for something undisclosed to you. Goat Sage also received an Emmy Award for his efforts to help orphans in the Oceanic Islands. ");
        } else if (code == 5) {
            title.setText("Can I Help Goat Sage?");
            response.setText("   Before we answer this, one must know that Goat Sage does not need help because he is too good for everyone. However, you can help spread the Goat Sage message and movement by getting his app on as many people's devices as possible by legal means. Sage Goat isn't bound by law either, so illegal means are a green light too.");
        } else if (code == 6) {
            title.setText("Where is Goat Sage?");
            response.setText("   If you are asking this question, then you are missing some fundamental principles of the existence of Goat Sage in your intellect. Goat Sage is not bound by geographical positions as we are, instead he transcends them and does whatever he wants. Just think, he might even be living in your liver right now....          Food for thought :)");
        }
    }//end of onCreate

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
}
