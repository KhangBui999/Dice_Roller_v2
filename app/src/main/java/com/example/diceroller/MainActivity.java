package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Elements
    private Button fourSided;
    private Button sixSided;
    private Button eightSided;
    private Button tenSided;
    private Button twelveSided;
    private Button twentySided;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for each button declared invoke the setButtonListener to streamline finding element
        setButtonListener(fourSided, R.id.m4sideBtn, 4);
        setButtonListener(sixSided, R.id.m6sideBtn, 6);
        setButtonListener(eightSided, R.id.m8sideBtn, 8);
        setButtonListener(tenSided, R.id.m10sideBtn, 10);
        setButtonListener(twelveSided, R.id.m12sideBtn, 12);
        setButtonListener(twentySided, R.id.m20sideBtn, 20);
    }

    /**
     * Sets button to listen for clicks, and when clicked allows it to change to the DetailActivity
     * with intended dice sides e.g. 6 sided dice will have only have a range of 1-6.
     * @param button - the button to have the onClickListener
     * @param rButtonId - the element ID in the activity_main.xml file
     * @param sides - number of sides the dice will have
     */
    protected void setButtonListener(Button button, int rButtonId, final int sides) {
        button = (Button) findViewById(rButtonId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailActivity(String.valueOf(sides));
            }
        });
    }


    //Launches detail activity and uses putExtra to store a "SIDE" value
    private void launchDetailActivity(String side) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("SIDE", side);
        startActivity(intent);
    }


}
