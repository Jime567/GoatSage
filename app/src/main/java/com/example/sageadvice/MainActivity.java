package com.example.sageadvice;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.sageadvice.R.id.showMessage;

public class MainActivity extends AppCompatActivity {
    private TextView dispMessage;
    private DrawerLayout drawerLayout;
    public final static String EXTRA_MESSAGE = "com.example.SageAdvice.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dispMessage = (TextView) findViewById(showMessage);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

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
                            Intent intent = new Intent(MainActivity.this, DisplayScreen.class);
                            startActivity(intent);
                        } else if (item == R.id.faq_nav) {
                            Intent intent = new Intent(MainActivity.this, FAQ.class);
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
                Intent intent = new Intent(MainActivity.this, AboutPage.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    //Hopefully adds the about menu to actionbar in top right
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }



    public void Advice(View view) {
        Random numGenerator = new Random();
        int randNum = numGenerator.nextInt(34);
        if (randNum == 0) {
            dispMessage.setText("PUT SOME PANTS ON YA HIPPIE!");
        } else if (randNum == 1) {
            dispMessage.setText("Goat Cheese Supports Brain Developement");
        } else if (randNum == 2) {
            dispMessage.setText("You never know when");
        } else if (randNum == 3) {
            dispMessage.setText("Have you tried getting a haircut?");
        } else if (randNum == 4) {
            dispMessage.setText("It's always up to those who do not know");
        } else if (randNum == 5) {
            dispMessage.setText("Run to survive the Zombies!");
        } else if (randNum == 6) {
            dispMessage.setText("1+1 can equal 2");
        } else if (randNum == 7) {
            dispMessage.setText("There is two types of people in this world.");
        } else if (randNum == 8) {
            dispMessage.setText("Dogs are the manifestation of angels");
        } else if (randNum == 9) {
            dispMessage.setText("Where Bear is, is also some poo");
        } else if (randNum == 10) {
            dispMessage.setText("The emperor might do that too!");
        } else if (randNum == 11) {
            dispMessage.setText("Books are bad fer chiddlers");
        } else if (randNum == 12) {
            dispMessage.setText("Dobby will claim you for his own...");
        } else if (randNum == 13) {
            dispMessage.setText("Moose are among the most harmful birds");
        } else if (randNum == 14) {
            dispMessage.setText("Moses is like Mooses");
        } else if (randNum == 15) {
            dispMessage.setText("Goat is watching");
        } else if (randNum == 16) {
            dispMessage.setText("If you are feeling surrounded, you probably are");
        } else if (randNum == 17) {
            dispMessage.setText("An uppercut and sneaky uprise to the left often brings wanted results");
        } else if (randNum == 18) {
            dispMessage.setText("Get them in the gut, whether by food or force, it\'s up to you");
        } else if (randNum == 19) {
            dispMessage.setText("Your arm is a useful feature");
        } else if (randNum == 20) {
            dispMessage.setText("Bless the lives of your friends with Goat Sage downloads");
        } else if (randNum == 21) {
            dispMessage.setText("It is advisable that you do not listen to those who give you advice");
        } else if (randNum == 22) {
            dispMessage.setText("The light is seen when lights are lit");
        } else if (randNum == 23) {
            dispMessage.setText("Do not suppose because you know math you can math");
        } else if (randNum == 24) {
            dispMessage.setText("Do not punch babies when they are born");
        } else if (randNum == 25) {
            dispMessage.setText("Licking rocks could be detrimental to your health");
        } else if (randNum == 26) {
            dispMessage.setText("One way to save money is to stop buying socks at school");
        } else if (randNum == 27) {
            dispMessage.setText("Picking your nose often yields something");
        } else if (randNum == 28) {
            dispMessage.setText("No one knows you like you do, except for me");
        } else if (randNum == 29) {
            dispMessage.setText("Do not wear gloves, cuz then the gloves know the back of your hand better than you");
        } else if (randNum == 30) {
            dispMessage.setText("Speak in another language so no one knows when your saying something stupid");
        } else if (randNum == 31) {
            dispMessage.setText("The computer works better when you turn it on first");
        } else if (randNum == 32) {
            dispMessage.setText("Go watch the movie, \"Goat Carnage: The Story of a Sage\"");
        } else if (randNum == 33) {
            dispMessage.setText("Read a book to learn what the book is about");
        }

    } //end of advice


    public void doMotivation(View view) {
        Random numberGenerator = new Random();
        int numNum = numberGenerator.nextInt(33);
        if (numNum == 0) {
            dispMessage.setText("You might be smarter than the average bee!");
        } else if (numNum == 1) {
            dispMessage.setText("You can think any thoughts you think!");
        } else if (numNum == 2) {
            dispMessage.setText("This isn't a mirror, so you can look safely!");
        } else if (numNum == 3) {
            dispMessage.setText("You can usually open doors first try!");
        } else if (numNum == 4) {
            dispMessage.setText("You are capable of clicking buttons!");
        } else if (numNum == 5) {
            dispMessage.setText("You are alive since your are reading this!");
        } else if (numNum == 6) {
            dispMessage.setText("I bet you know where you are!");
        } else if (numNum == 7) {
            dispMessage.setText("You can't stoop as low as elmo!");
        } else if (numNum == 8) {
            dispMessage.setText("Chances are you can read!");
        } else if (numNum == 9) {
            dispMessage.setText("You probably have more friends than trees do!");
        } else if (numNum == 10) {
            dispMessage.setText("You have a finger!");
        } else if (numNum == 11) {
            dispMessage.setText("You were born!");
        } else if (numNum == 12) {
            dispMessage.setText("You are higher in status than a house elf!");
        } else if (numNum == 13) {
            dispMessage.setText("You may be amazing!");
        } else if (numNum == 14) {
            dispMessage.setText("You can walk faster than a fish can!");
        } else if (numNum == 15) {
            dispMessage.setText("You are in the same animal kingdom as a dog!");
        } else if (numNum == 16) {
            dispMessage.setText("You are still living at this moment!");
        } else if (numNum == 17) {
            dispMessage.setText("You know how to Read!");
        } else if (numNum == 18) {
            dispMessage.setText("Statistically speaking, your probably are not the dumbest person!");
        } else if (numNum == 19) {
            dispMessage.setText("The sky likes you enough not to crush you!");
        } else if (numNum == 20) {
            dispMessage.setText("No one hates you enough to stop you from having Goat Sage in your life!");
        } else if (numNum == 21) {
            dispMessage.setText("If you have feet, then you have a spot for shoes!");
        } else if (numNum == 22) {
            dispMessage.setText("You now know no bounds in spelling the sound \"no\"!");
        } else if (numNum == 23) {
            dispMessage.setText("There is four wheels in the world for every car you have seen with 4 wheels!");
        } else if (numNum == 24) {
            dispMessage.setText("Goat Sage supports your usage of his app!");
        } else if (numNum == 25) {
            dispMessage.setText("There is not anything you can't do if your only option is to click that button!");
        } else if (numNum == 26) {
            dispMessage.setText("What goes up comes down until you hit space, so you can keep going too!");
        } else if (numNum == 27) {
            dispMessage.setText("This message had to have been written by someone for you!");
        } else if (numNum == 28) {
            dispMessage.setText("You have the will to move fingers!");
        } else if (numNum == 29) {
            dispMessage.setText("You probably know what this says!");
        } else if (numNum == 30) {
            dispMessage.setText("If you were the only person on Earth, then you'd be the smartest!");
        } else if (numNum == 31) {
            dispMessage.setText("You have the potential to do things!");
        } else if (numNum == 32) {
            dispMessage.setText("No one knows what sleeping with your calf-bone is like, but you do!");
        }

    }//motivation end

    public void nextScreen(View view) {
        Intent intent = new Intent(this, DisplayScreen.class);
        startActivity(intent);
    }//end of nextScreen()
}

