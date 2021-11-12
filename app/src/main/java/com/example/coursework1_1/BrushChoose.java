package com.example.coursework1_1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by psyng1(Nhat Giang) on 8/11/21.
 *
 * This is BrushChoose activity, where users can choose the shape and the size of brush.
 * There are two types of shape, each shape has a button.
 * There are two types of size, each size has a button.
 * There is a Confirm button, which default set to Unable
 * For each part, there is a warning prompt, users need to choose one option for each part, so the
 * confirm button will set to Enable
 */

public class BrushChoose extends AppCompatActivity {

    /**
     * some variables for the activity
     */
    Bundle bundle = new Bundle();
    private Button buttonConfirm;
    private Button roundBut;
    private Button squareBut;
    private Button smallBut;
    private Button largeBut;
    private TextView sizeWarn, styleWarn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_choose);

        buttonConfirm = findViewById(R.id.confirmBut); //match ID from XML for Confirm button
        roundBut = findViewById(R.id.roundBut);//match ID from XML for Round button
        squareBut = findViewById(R.id.squareBut);//match ID from XML for Square button
        smallBut = findViewById(R.id.smallBut);//match ID from XML for Small button
        largeBut = findViewById(R.id.largeBut);//match ID from XML for Large button
        sizeWarn = findViewById(R.id.brushSizeWarn);//match ID from XML for Size warning prompt
        styleWarn = findViewById(R.id.brushStyleWarn);//match ID from XML for Shape warning prompt


        //Action when click on Confirm button
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtras(bundle);// intent gets all extras
                setResult(Activity.RESULT_OK, intent); //set result code
                Log.d("BrushChoose", "button brush confirm pressed");
                finish();
            }
        });

    }

    /**
     * Function to set styles for painting brush
     *
     * @param view Variable for brush style view
     */
    public void brushStyleButtonPress(View view) {
        String shape;
        int size;

        if(roundBut.isPressed()){ //check if Round button is pressed
            shape = ("ROUND");
            bundle.putString("shape", shape); // set Brush shape to Round
            styleWarn.setVisibility(View.INVISIBLE);// set visibility for shape warning prompt
            Log.d("BrushShape", "round shape");
        }
        else if(squareBut.isPressed()){ //check if Square button is pressed
            shape = ("SQUARE");
            bundle.putString("shape", shape); // set Brush shape to Square
            styleWarn.setVisibility(View.INVISIBLE);// set visibility for shape warning prompt
            Log.d("BrushShape", "square shape");
        }

        if(smallBut.isPressed()){//check if Small button is pressed
            size = 15;
            bundle.putInt("size", size);//set Brush size to Small
            sizeWarn.setVisibility(View.INVISIBLE); // set visibility for size warning prompt
            Log.d("BrushSize", "small size");
        }

        else if(largeBut.isPressed()){//check if Large button is pressed
            size = 45;
            bundle.putInt("size", size);//set Brush size to Large
            sizeWarn.setVisibility(View.INVISIBLE); // set visibility for size warning prompt
            Log.d("BrushSize", "large size");
        }

        //After all warning prompt are invisible, set Confirm button enable
        buttonConfirm.setEnabled(styleWarn.getVisibility() == View.INVISIBLE && sizeWarn.getVisibility() == View.INVISIBLE);

    }

}