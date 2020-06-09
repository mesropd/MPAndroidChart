package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.github.mikephil.charting.components.ChartIcon;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.List;

public class YAxisIconRenderer extends YAxisRenderer {
    private Paint paint = new Paint();

    private List<ChartIcon> chartIcons;
    private int itemMargin;

    private final float[] positions = new float[]{0, 0};
    private final Rect srcRect = new Rect();
    private final Rect dstRect = new Rect();

    public YAxisIconRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer trans) {
        super(viewPortHandler, yAxis, trans);
    }

    @Override
    public void renderAxisLabels(Canvas c) {
        if (!mYAxis.isEnabled() || !mYAxis.isDrawLabelsEnabled() || chartIcons == null)
            return;

        for(ChartIcon chartIcon : chartIcons) {
            Bitmap bitmap = chartIcon.getBitmap();
            positions[0] = 0;
            positions[1] = chartIcon.getValue();
            mTrans.pointValuesToPixel(positions);
            positions[0] = mViewPortHandler.contentRight();
            srcRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            float measuredWidth = mViewPortHandler.offsetRight() - 2 * itemMargin;
            float measuredHeight = bitmap.getHeight() * ((float) measuredWidth / bitmap.getWidth());
            int x = (int) positions[0];
            int y = (int) (positions[1] - measuredHeight / 2);
            dstRect.set(x + itemMargin, y,
                    x + (int) mViewPortHandler.offsetRight() - itemMargin, y + (int)measuredHeight);
            c.drawBitmap(bitmap, srcRect, dstRect, paint);
        }
    }

    @Override
    public void renderGridLines(Canvas c) {

    }

    public List<ChartIcon> getChartIcons() {
        return chartIcons;
    }

    public void setChartIcons(List<ChartIcon> chartIcons) {
        this.chartIcons = chartIcons;
    }

    public int getItemMargin() {
        return itemMargin;
    }

    public void setItemMargin(int itemMargin) {
        this.itemMargin = itemMargin;
    }
}
