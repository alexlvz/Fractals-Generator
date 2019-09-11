package com.example.alexl.fractals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

public class FractalActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private FractalView fractal;
    private FractalPainter shape;
    private Button draw;
    private Switch sw;
    private int fillOrEmpty=2;
    RatingBar resolutionSet; //for the stars
    private int resolution; //to set the resolution interval

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractal);

        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.fractals,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        fractal=(FractalView)findViewById(R.id.fractal);
        draw=(Button)findViewById(R.id.button);
        sw=(Switch)findViewById(R.id.switch1);
        resolutionSet=(RatingBar)findViewById(R.id.ratingBar);
        resolutionSet.setStepSize(1);
        resolutionSet.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {
                //set the resolution interval
                if(resolutionSet.getRating()==4)
                    resolution=2;
                if(resolutionSet.getRating()==3)
                   resolution=4;
                if(resolutionSet.getRating()==2)
                   resolution=8;
                if(resolutionSet.getRating()==1)
                   resolution=16;
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { //for the switch
                if(sw.isChecked())
                    fillOrEmpty=1;
                else
                    fillOrEmpty=2;
            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(resolutionSet.getRating()!=0) //have to set some rating...
                {
                    shape.setResolution(resolution);
                    fractal.setFillType(fillOrEmpty);
                    fractal.setFractal(shape); //initialize the shape
                    fractal.invalidate(); //redraw
                }
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) //for the spinner , set fractal to draw according to chosen
    {
        if(spinner.getSelectedItem().toString().equals("SquareFractal"))
            shape=new SquareFractal((int)(fractal.getHeight()/4.25),resolution);
        else
            shape=new CircleFractal((int)(fractal.getHeight()/8.25),resolution);
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
