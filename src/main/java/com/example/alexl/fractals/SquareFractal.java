package com.example.alexl.fractals;
import android.graphics.Canvas;
import android.graphics.Paint;

public class SquareFractal extends FractalPainter
{
    private int FractalLength;
    private Paint p;
    public SquareFractal(int length, int res)
    {
        super(res);
        this.FractalLength=length;
    }
    public void draw(Paint p,Canvas c,int xTop, int Ytop, int length) //help function to draw the fractal as asked
    {
        c.drawRect(xTop,Ytop,xTop+length,Ytop+length,p);
        if(length>=getResolution())
        {
               draw(p, c,xTop-length/2, Ytop, length/2);
               draw(p, c,xTop+length, Ytop+length/2, length/2);
               draw(p, c,xTop+length/2, Ytop-length/2, length/2);
               draw(p, c,xTop, Ytop+length, length/2);
        }
    }
    public void drawFractal(Canvas c, int fillType)
    {
        int midX=c.getWidth()/2, midY=c.getHeight()/2;
        Paint p=new Paint();

        if(fillType==FractalPainter.EMPTY)
        {
            p.setStyle(Paint.Style.STROKE);
            draw(p,c,midX-FractalLength/2,midY-FractalLength/2,FractalLength);
        }
        if(fillType==FractalPainter.FILL)
        {
            p.setStyle(Paint.Style.FILL);
            draw(p,c,midX-FractalLength/2,midY-FractalLength/2,FractalLength);
        }
    }
}
