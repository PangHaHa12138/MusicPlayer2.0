package com.panghaha.it.mymusicplayerdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

import com.panghaha.it.mymusicplayerdemo.R;


/**
 * 圆角 ImageView
 *
 * <p> xml 中通过 xround，yround 设置 X 方向 Y 方向圆角值，单位：dp
 * Created by renxuelong on 23/11/2018
 */
public class RoundImageView extends AppCompatImageView {

    private static final int ROUND_DEFAULT = 5;

    private Path path;
    private RectF rectF;
    private float roundX, roundY;
    private float rLeftTopX, rLeftTopY, rLeftBottomX, rLeftBottomY, rRightTopX, rRightTopY, rRightBottomX, rRightBottomY;

    public float getrLeftTopX() {
        return rLeftTopX;
    }

    public void setrLeftTopX(float rLeftTopX) {
        this.rLeftTopX = rLeftTopX;
        postInvalidate();
    }

    public float getrLeftTopY() {
        return rLeftTopY;
    }

    public void setrLeftTopY(float rLeftTopY) {
        this.rLeftTopY = rLeftTopY;
        postInvalidate();
    }

    public float getrLeftBottomX() {
        return rLeftBottomX;
    }

    public void setrLeftBottomX(float rLeftBottomX) {
        this.rLeftBottomX = rLeftBottomX;
        postInvalidate();
    }

    public float getrLeftBottomY() {
        return rLeftBottomY;
    }

    public void setrLeftBottomY(float rLeftBottomY) {
        this.rLeftBottomY = rLeftBottomY;
        postInvalidate();
    }

    public float getrRightTopX() {
        return rRightTopX;
    }

    public void setrRightTopX(float rRightTopX) {
        this.rRightTopX = rRightTopX;
        postInvalidate();
    }

    public float getrRightTopY() {
        return rRightTopY;
    }

    public void setrRightTopY(float rRightTopY) {
        this.rRightTopY = rRightTopY;
        postInvalidate();
    }

    public float getrRightBottomX() {
        return rRightBottomX;
    }

    public void setrRightBottomX(float rRightBottomX) {
        this.rRightBottomX = rRightBottomX;
        postInvalidate();
    }

    public float getrRightBottomY() {
        return rRightBottomY;
    }

    public void setrRightBottomY(float rRightBottomY) {
        this.rRightBottomY = rRightBottomY;
        postInvalidate();
    }

    public void setRoundX(float roundX) {
        this.roundX = roundX;
        rLeftTopX = this.roundX;
        rLeftBottomX = this.roundX;
        rRightTopX = this.roundX;
        rRightBottomX = this.roundX;
        postInvalidate();
    }

    public void setRoundY(float roundY) {
        this.roundY = roundY;
        rLeftTopY = this.roundY;
        rLeftBottomY = this.roundY;
        rRightTopY = this.roundY;
        rRightBottomY = this.roundY;
        postInvalidate();
    }

    public float getRoundX() {
        return roundX;
    }

    public float getRoundY() {
        return roundY;
    }


    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray types = context.obtainStyledAttributes(
                attrs, R.styleable.RoundImageView, defStyleAttr, 0);
        roundX = types.getDimension(R.styleable.RoundImageView_round_x, ROUND_DEFAULT);
        roundY = types.getDimension(R.styleable.RoundImageView_round_y, ROUND_DEFAULT);

        roundX *= getResources().getDisplayMetrics().density;
        roundY *= getResources().getDisplayMetrics().density;

        rLeftTopX = types.getDimension(R.styleable.RoundImageView_left_top_x, roundX);
        rLeftBottomX = types.getDimension(R.styleable.RoundImageView_left_bottom_x, roundX);
        rRightTopX = types.getDimension(R.styleable.RoundImageView_right_top_x, roundX);
        rRightBottomX = types.getDimension(R.styleable.RoundImageView_right_bottom_x, roundX);

        rLeftTopY = types.getDimension(R.styleable.RoundImageView_left_top_y, roundY);
        rLeftBottomY = types.getDimension(R.styleable.RoundImageView_left_bottom_y, roundY);
        rRightTopY = types.getDimension(R.styleable.RoundImageView_right_top_y, roundY);
        rRightBottomY = types.getDimension(R.styleable.RoundImageView_right_bottom_y, roundY);
        types.recycle();
        init();
    }

    private void init() {
        path = new Path();
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        canvas.save();
        path.reset();
        rectF.left = 0;
        rectF.top = 0;
        rectF.right = getWidth();
        rectF.bottom = getHeight();
        path.addRoundRect(rectF, new float[]{rLeftTopX, rLeftTopY, rRightTopX, rRightTopY, rRightBottomX, rRightBottomY, rLeftBottomX, rLeftBottomY}, Path.Direction.CCW);
        canvas.clipPath(path);
        super.onDraw(canvas);
        canvas.restore();
        setLayerType(View.LAYER_TYPE_NONE, null);
    }
}
