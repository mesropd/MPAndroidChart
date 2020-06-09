package com.github.mikephil.charting.components;

import android.graphics.Bitmap;

public class ChartIcon {
    private float value;
    private Bitmap bitmap;

    public ChartIcon() {

    }

    public ChartIcon(float value, Bitmap bitmap) {
        this.value = value;
        this.bitmap = bitmap;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
