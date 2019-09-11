package com.example.alexl.fractals;
import android.graphics.Canvas;

public abstract class FractalPainter {
    public static final int MIN_RES = 2;
    public static final int EMPTY = 1, FILL = 2;
    private int resolution;

    public FractalPainter(int resolution) {
        setResolution(resolution);
    }

    public void setResolution(int resolution) {
        this.resolution = (resolution < MIN_RES) ? MIN_RES : resolution;
    }
    public int getResolution() {
        return resolution;
    }

    public abstract void drawFractal(Canvas c, int fillType);
}

