package com.simkowick.kate.counter;

/* Munchkin Max Game Counter
* Created by Kate Simkowiak to help my son, Max, keep track of his levels while
* playing the card game Munchkin.  Dragon by Xander Simkowiak
*/

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Counter extends AppCompatActivity {

    public int baseLevelValue = 1;
    public int equipmentLevelValue = 0;
    public int oneTimeLevelValue = 0;
    public int totalLevelValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // sets the toolbar to act as the actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    // Add one level to Base
    public void addBase(View view) {

        if(baseLevelValue < 10) {
            baseLevelValue++;
        }
        if(baseLevelValue == 10){
            Snackbar.make(view, "Winner, Level 10!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

        final TextView baseLevel = (TextView) findViewById(R.id.baseLevel);
        baseLevel.setText(String.valueOf(baseLevelValue));
        printFinalLevel();

    }

    // Subtract one level from Base.  Base must be between 1 and 10
    public void subtractBase(View view) {
        if(baseLevelValue <= 10 && baseLevelValue > 1)
            baseLevelValue--;

        final TextView baseLevel = (TextView) findViewById(R.id.baseLevel);
        baseLevel.setText(String.valueOf(baseLevelValue));
        printFinalLevel();

    }

    // Equipment cards add
    public void addEquip(View view) {
        equipmentLevelValue++;

        final TextView equipLevel = (TextView) findViewById(R.id.equipLevel);
        equipLevel.setText(String.valueOf(equipmentLevelValue));
        printFinalLevel();

    }

    // Equipment cards subtract
    public void subtractEquip(View view) {
        if(equipmentLevelValue > 0) {
            equipmentLevelValue--;
        }

        final TextView equipLevel = (TextView) findViewById(R.id.equipLevel);
        equipLevel.setText(String.valueOf(equipmentLevelValue));
        printFinalLevel();

    }

    // One Time Use cards add
    public void addOneX(View view) {

        oneTimeLevelValue++;

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oneTimeLevelValue));
        printFinalLevel();

    }

    // One Time Use cards subtract. This number may be negative
    public void subtractOneX(View view) {
        oneTimeLevelValue--;

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oneTimeLevelValue));
        printFinalLevel();

    }

    // resets one time use items to 0
    public void endTurn(View view){
        oneTimeLevelValue = 0;

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oneTimeLevelValue));
        printFinalLevel();
    }

    // Adds up and prints your level to the screen
    public void printFinalLevel (){

        totalLevelValue = baseLevelValue + equipmentLevelValue + oneTimeLevelValue;
        final TextView totalLevel = (TextView) findViewById(R.id.totalLevel);
        totalLevel.setText(String.valueOf(totalLevelValue));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_counter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Reset game if menu item clicked
        if (id == R.id.action_settings) {
            resetGame();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


    //resets levels for a new round
    public void resetGame(){
        baseLevelValue = 1;
        oneTimeLevelValue = 0;
        equipmentLevelValue = 0;

        final TextView baseLevel = (TextView) findViewById(R.id.baseLevel);
        baseLevel.setText(String.valueOf(baseLevelValue));

        final TextView equipLevel = (TextView) findViewById(R.id.equipLevel);
        equipLevel.setText(String.valueOf(equipmentLevelValue));

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oneTimeLevelValue));

        printFinalLevel();

    }
}