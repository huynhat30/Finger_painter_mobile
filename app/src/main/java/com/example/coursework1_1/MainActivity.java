package com.example.coursework1_1;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
/**
 * Created by psyng1(Nhat Giang) on 8/11/21.
 *
 * This is the main activity for my coursework 1-1. This activity displays the drawing canvas and some
 * buttons to other functions.
 *
 * There is a main canvas which can be drawn on, and changed the background. There are two ways of changing
 * the background for canvas: choose directly in the application(success) or open phone Files manager application
 * then open image with the application(on develop)
 *
 * There are four buttons in this activity: Colour(to start ColourChoose activity), Background(to open phone folders
 * to choose background), Brush(to open BrushChoose activity), and Eraser(to active the eraser)
 *
 * I learned how to create different UI for each specific device or screenmode(portrait and landscape) from
 * https://www.youtube.com/watch?v=KJGKj078Qag&t=12s
 *
 * All other functions I studied and referred from lectures and labs resources of Mobile Device Programming module.
 */

public class MainActivity extends AppCompatActivity {
    /**
     * some variables for the activity
     */
    private static final int MY_COLOUR_CODE = 1; //The request code to ColourChoose activity
    private static final int MY_BRUSH_CODE = 2; //The request code to BrushChoose activity
    private static final int MY_BACKGROUND_CODE = 3; //The request code to changeBackground function in another activity
    private FingerPainterView myFingerPainterView;
    private TextView eraserWarning;
    private Uri selectImage;
    private Intent intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity try to get the image that opened in Files manager application
        //My application cannot identifies the image that put in data
        intent3 = getIntent();
        selectImage = intent3.getData();
        if(selectImage == null){
            myFingerPainterView = findViewById(R.id.fingerPainterView);
        }
        else{
            myFingerPainterView = findViewById(R.id.fingerPainterView);
            myFingerPainterView.load(selectImage);
        }

        eraserWarning = findViewById(R.id.eraserWarning);

    }


    /**
     * Function to open ColourChoose activity through Colour button,
     * and send request code to this activity
     *
     * @param view variable for "Colour" button in XML file
     */
    public void colourChooser(View view) {
        eraserWarning.setVisibility(View.INVISIBLE); //set visibility of eraser's warning
        Intent intent = new Intent(MainActivity.this, ColourChoose.class);
        startActivityForResult(intent, MY_COLOUR_CODE);
        Log.d("MainActivity", "button colour pressed");
    }

    /**
     * Function to open BrushChoose activity through Brush button,
     * and send request code to this activity
     *
     * @param view variable for "Brush" button in XML file
     */
    public void brushChooser(View view) {
        Intent intent = new Intent(MainActivity.this, BrushChoose.class);
        startActivityForResult(intent, MY_BRUSH_CODE);
        Log.d("MainActivity", "button brush pressed");
    }

    /**
     * Function to activate the Eraser on main activity through Eraser button.
     * Currently the Eraser just has white colour
     *
     * @param view variable for "Eraser" button in XML file
     */
    public void brushEraser(View view) {
        myFingerPainterView.setColour(Color.WHITE);
        myFingerPainterView.setBrushWidth(30);
        eraserWarning.setVisibility(View.VISIBLE);
    }

    /**
     * Function to open phone folders through Background button
     *
     * @param view variable for "Background" button in XML file
     */
    public void changeBackground(View view) {
        Intent intent2 = new Intent(Intent.ACTION_PICK);
        intent2.setType("image/*");
        startActivityForResult(intent2, MY_BACKGROUND_CODE);
    }

    /**
     * function to show a warning dialog on screen if something when wrong
     */
    public void warningDialog(){
        WarningDialog warningDialog = new WarningDialog();
        warningDialog.show(getSupportFragmentManager(), "Warning message");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == Activity.RESULT_OK) {
                assert data != null; // Make sure data not null
                int colourID = data.getIntExtra("colour", 0);
                int sizeID = data.getIntExtra("size", 0);
                String shapeID = data.getStringExtra("shape");

                //Cases for each request code that has been passed to other activities
                switch (requestCode){

                    case MY_COLOUR_CODE:
                        myFingerPainterView.setColour(colourID); //set painting colour
                        myFingerPainterView.getColour();
                        break;
                    case MY_BRUSH_CODE:
                        myFingerPainterView.setBrush(Paint.Cap.valueOf(shapeID)); //set shape of brush
                        myFingerPainterView.setBrushWidth(sizeID); //set size for brush
                        break;
                    case MY_BACKGROUND_CODE:
                        selectImage = data.getData(); //get image data from phone folders
                        myFingerPainterView.load(selectImage);// set background for canvas
                        break;
                }

            }
            else if (resultCode == Activity.RESULT_CANCELED) {
                Log.d("FingerPainter", "Activity canceled");
            }
            else{
                warningDialog();
                Log.d("FingerPainter", "Some error(s) come(s) up");
            }

    }

    //Below are Override function of lifecycle of an activity
    @Override
    protected void onStart() {
        super.onStart();
        //intent3 = getIntent();
        //selectImage = intent3.getData();
        //if (intent3.getType().contains("image/*")) {
        //    myFingerPainterView = findViewById(R.id.fingerPainterView);
        //    myFingerPainterView.load(selectImage);
        //} else {
        //   myFingerPainterView = findViewById(R.id.fingerPainterView);
        //}
        Log.d("mainActivity", "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mainActivity", "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("mainActivity", "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mainActivity", "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mainActivity", "on destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("mainActivity", "on restart");
    }



}