package com.example.coursework1_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
/**
 * Created by psyng1(Nhat Giang) on 8/11/21.
 *
 * This is ColourChoose activity, where users can choose the colour that displayed for painting.
 * There are six types of colour, each colour has a button.
 */

public class ColourChoose extends AppCompatActivity {

    int clID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_choose);
    }
    public void redColour(View view){ //check if the Red colour button is pressed
        Intent intent = new Intent();
        clID = 0xFFE15555;
        intent.putExtra("colour", clID); //set colour for painting
        setResult(Activity.RESULT_OK, intent); //set result code
        Log.d("ColourChoose", "button red colour pressed");
        finish();
    }

    public void blueColour(View view){//check if the Red colour button is pressed
        Intent intent = new Intent();
        clID = 0xFF92C4EF;
        intent.putExtra("colour", clID);//set colour for painting
        setResult(Activity.RESULT_OK, intent);//set result code
        Log.d("ColourChoose", "button blue colour pressed");
        finish();
    }

    public void greenColour(View view){//check if the Green colour button is pressed
        Intent intent = new Intent();
        clID = 0xFF4CAF50;
        intent.putExtra("colour", clID);//set colour for painting
        setResult(Activity.RESULT_OK, intent);//set result code
        Log.d("ColourChoose", "button green colour pressed");
        finish();
    }

    public void blackColour(View view){//check if the Black colour button is pressed
        Intent intent = new Intent();
        clID = 0xFF171616;
        intent.putExtra("colour", clID);//set colour for painting
        setResult(Activity.RESULT_OK, intent);//set result code
        Log.d("ColourChoose", "button black colour pressed");
        finish();
    }
    public void orangeColour(View view){//check if the Orange colour button is pressed
        Intent intent = new Intent();
        clID = 0xFFFF9800;
        intent.putExtra("colour", clID);//set colour for painting
        setResult(Activity.RESULT_OK, intent);//set result code
        Log.d("ColourChoose", "button orange colour pressed");
        finish();
    }

    public void yellowColour(View view){//check if the Yellow colour button is pressed
        Intent intent = new Intent();
        clID = 0xFFFFEB3B;
        intent.putExtra("colour", clID);//set colour for painting
        setResult(Activity.RESULT_OK, intent);//set result code
        Log.d("ColourChoose", "button yellow colour pressed");
        finish();
    }
}