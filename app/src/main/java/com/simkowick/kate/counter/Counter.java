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

    public int bLevel = 1;
    public int eLevel = 0;
    public int oLevel = 0;
    public int tLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // sets the toolbar to act as the actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    // Add one level to Base
    public void onClickAddBase(View view) {

        if(bLevel < 10) {
            bLevel++;
        }
        if(bLevel == 10){
            Snackbar.make(view, "Winner, Level 10!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

        final TextView baseLevel = (TextView) findViewById(R.id.baseLevel);
        baseLevel.setText(String.valueOf(bLevel));
        printFinalLevel();

    }

    // Subtract one level from Base.  Base must be between 1 and 10
    public void onClickSubtractBase(View view) {
        if(bLevel <= 10 && bLevel > 1)
            bLevel--;

        final TextView baseLevel = (TextView) findViewById(R.id.baseLevel);
        baseLevel.setText(String.valueOf(bLevel));
        printFinalLevel();

    }

    // Equipment cards add
    public void onClickAddEquip(View view) {
        eLevel++;

        final TextView equipLevel = (TextView) findViewById(R.id.equipLevel);
        equipLevel.setText(String.valueOf(eLevel));
        printFinalLevel();

    }

    // Equipment cards subtract
    public void onClickSubtractEquip(View view) {
        if(eLevel > 0) {
            eLevel--;
        }

        final TextView equipLevel = (TextView) findViewById(R.id.equipLevel);
        equipLevel.setText(String.valueOf(eLevel));
        printFinalLevel();

    }

    // One Time Use cards add
    public void onClickAddOneX(View view) {

        oLevel++;

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oLevel));
        printFinalLevel();

    }

    // One Time Use cards subtract
    public void onClickSubtractOneX(View view) {
        if(oLevel > 0) {
            oLevel--;
        }

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oLevel));
        printFinalLevel();

    }

    // resets one time use items to 0
    public void onClickEndTurn(View view){
        oLevel = 0;

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oLevel));
        printFinalLevel();
    }

    // Adds up and prints your level to the screen
    public void printFinalLevel (){

        tLevel = bLevel + eLevel + oLevel;
        final TextView totalLevel = (TextView) findViewById(R.id.totalLevel);
        totalLevel.setText(String.valueOf(tLevel));

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
        bLevel = 1;
        oLevel = 0;
        eLevel = 0;

        final TextView baseLevel = (TextView) findViewById(R.id.baseLevel);
        baseLevel.setText(String.valueOf(bLevel));

        final TextView equipLevel = (TextView) findViewById(R.id.equipLevel);
        equipLevel.setText(String.valueOf(eLevel));

        final TextView oneTimeLevel = (TextView) findViewById(R.id.oneTimeLevel);
        oneTimeLevel.setText(String.valueOf(oLevel));

        printFinalLevel();

    }
}
