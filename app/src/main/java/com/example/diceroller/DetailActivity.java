package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    //Elements
    private ImageButton back;
    private TextView mTitle;
    private TextView d1Title;
    private TextView d2Title;
    private ImageView d1Image;
    private ImageView d2Image;
    private TextView d1Result;
    private TextView d2Result;
    private TextView sumTitle;
    private TextView sumResult;
    private Button btn;
    private int numOfSides;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Set declared objects to respective activity_detail.xml element
        d1Title = findViewById(R.id.mDiceTitle1);
        d2Title = findViewById(R.id.mDiceTitle2);
        d1Image = findViewById(R.id.imageView);
        d2Image = findViewById(R.id.imageView2);
        d1Result = findViewById(R.id.oneResult);
        d2Result = findViewById(R.id.twoResult);
        sumTitle = findViewById(R.id.resultTitle);
        sumResult = findViewById(R.id.sumResult);
        btn = findViewById(R.id.rollBtn);

        setBodyVisibility(View.GONE); //sets body to "GONE" - constraints to body objects temp. removed

        final Intent intent = getIntent();
        final String sides = intent.getStringExtra("SIDE");
        numOfSides = Integer.parseInt(sides);
        mTitle = findViewById(R.id.mTitle);
        mTitle.setText(sides+"-SIDED DICES"); //sets dice title based on the putExtra value from MainActivity
        setDiceImage(numOfSides); //sets dice image based on number of sides from MainActivity

        setBackButtonListener();
        setRollButtonListener();
    }

    /**
     * Sets the body visibility based on value given e.g. View.GONE, View.INVISIBLE, View.VISIBLE
     * @param visibility
     */
    protected void setBodyVisibility(int visibility) {
        d1Title.setVisibility(visibility);
        d2Title.setVisibility(visibility);
        d1Image.setVisibility(visibility);
        d2Image.setVisibility(visibility);
        d1Result.setVisibility(visibility);
        d2Result.setVisibility(visibility);
        sumTitle.setVisibility(visibility);
        sumResult.setVisibility(visibility);
    }

    //Sets back button listener to finish() activity when clicked --> returns to selection screen
    protected void setBackButtonListener() {
        back = (ImageButton) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //Sets roll button listener to roll() dice when activity
    protected void setRollButtonListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });
    }

    /**
     * setDiceImage based on the numberOfSides in the parameter
     * @param numOfSides - num of sides the dice should have
     */
    protected void setDiceImage(int numOfSides) {
        int imgId;
        switch(numOfSides) {
            case 4: imgId = R.drawable.d4_blank; break;
            case 6: imgId = R.drawable.d6_blank; break;
            case 8: imgId = R.drawable.d8_blank; break;
            case 10: imgId = R.drawable.d10_blank; break;
            case 12: imgId = R.drawable.d12_blank; break;
            case 20: imgId = R.drawable.d20_blank; break;
            default: imgId = Integer.parseInt(null); break;
        }
        d1Image.setImageResource(imgId);
        d2Image.setImageResource(imgId);
    }

    //Rolls the dice
    protected void roll() {
        int diceOne = (int) (Math.random()*numOfSides) + 1;
        int diceTwo = (int) (Math.random()*numOfSides) + 1;
        int rollSum = diceOne + diceTwo; //Sum of both dices

        d1Result.setText(String.valueOf(diceOne)); //Sets text to String value of diceOne
        d2Result.setText(String.valueOf(diceTwo)); //Sets text to String value of diceTwo
        sumResult.setText(String.valueOf(rollSum)); //Sets text to String value of rollSum

        setBodyVisibility(View.VISIBLE);
    }


}
