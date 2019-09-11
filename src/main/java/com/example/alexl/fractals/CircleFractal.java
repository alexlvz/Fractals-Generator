package com.example.alexl.fractals;
import android.graphics.Canvas;
import android.graphics.Paint;

public class CircleFractal extends FractalPainter
{
    private int FractalLength;
    private Paint p;
    public CircleFractal(int length, int res)
    {
        super(res);
        this.FractalLength=length;
    }
    public void draw(Paint p, Canvas c, int cx, int cy, int length) //help function to draw the fractal as asked
    {
        c.drawCircle(cx,cy,length,p);
        if(length>=getResolution()) {
            draw(p, c, cx + length / 2 + length, cy, length / 2);
            draw(p, c, cx - length / 2 - length, cy, length / 2);
            draw(p, c, cx , cy-length / 2 - length, length / 2);
            draw(p, c, cx , cy+length / 2 + length, length / 2);
        }
    }
    public void drawFractal(Canvas c, int fillType)
    {
        int midX=c.getWidth()/2, midY=c.getHeight()/2;
        Paint p=new Paint();

        if(fillType==FractalPainter.EMPTY)
        {
            p.setStyle(Paint.Style.STROKE);
            draw(p,c,midX,midY,FractalLength);
        }

        if(fillType==FractalPainter.FILL)
        {
            p.setStyle(Paint.Style.FILL);
            draw(p,c,midX,midY,FractalLength);
        }
    }
}
