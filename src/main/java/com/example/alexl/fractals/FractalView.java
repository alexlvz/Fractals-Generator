package com.example.alexl.fractals;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class FractalView extends View
{
    private FractalPainter fractal;
    private int fillType;
    public FractalView(Context context, AttributeSet attrs)
    {
        super(context,attrs);

    }
    public void setFillType(int fill)
    {
        this.fillType=fill;
    }
    public void setFractal(FractalPainter frac) //initialize the shape to draw
    {
       this.fractal=frac;
    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if(this.fractal!=null) //avoid crashes
        fractal.drawFractal(canvas,fillType);
    }
}
