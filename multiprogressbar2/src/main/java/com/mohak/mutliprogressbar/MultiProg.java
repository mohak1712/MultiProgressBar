package com.mohak.mutliprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by mohak on 22/7/16.
 */
public class MultiProg extends View {

    //TODO : add padding to view

    private int mMaxProgress;


    /**
     * Current progress, can not exceed the max progress.
     */

    private int mCurrentProgress = 0;

    /**
     * The progress area bar color.
     */
    private int mReachedBarColor;

    /**
     * The bar unreached area color.
     */
    private int mUnreachedBarColor;

    /**
     * The bar height.
     */
    private int mBarHeight;

    /**
     * The desc color.
     */
    private int mDescColor;

    /**
     * The circleLeft text color.
     */
    private int mTextColor;

    /**
     * The circleRight text color.
     */
    private int mTextColor2;


    /**
     * The circleLeft  color.
     */
    private int mColorLeft;

    /**
     * The circleRight  color.
     */
    private int mColorRight;

    /**
     * The background  color.
     */
    private int mBackgroundColor;


    /**
     * The text size.
     */

    private int mTextSize;


    /**
     * The progress text to be shown.
     */

    private String mTextbarprog, mTextbarprog2;

    /**
     * Paint to be used.
     */

    Paint mReached, mUnReached, mTextPaint, mTextPaint2, mCircleLeft, mCircleRight;

    /**
     * Movement of circle
     */
    int mov, dir = 0;

    public MultiProg(Context context) {
        super(context);
    }

    public MultiProg(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.MultiProg, 0, 0);

        try {

            mCurrentProgress = a.getInteger(R.styleable.MultiProg_progress, 0);
            mReachedBarColor = a.getColor(R.styleable.MultiProg_mReachedBarColor, Color.BLUE);
            mUnreachedBarColor = a.getColor(R.styleable.MultiProg_mUnReachedBarColor, Color.GRAY);
            mBarHeight = a.getDimensionPixelSize(R.styleable.MultiProg_barHeight, 1);
            mTextSize = a.getDimensionPixelSize(R.styleable.MultiProg_textsize, 10);
            mMaxProgress = a.getInt(R.styleable.MultiProg_maxprogress, 100);
            mTextColor = a.getColor(R.styleable.MultiProg_mTextColor, Color.GREEN);
            mTextColor2 = a.getColor(R.styleable.MultiProg_mTextColor2, Color.RED);
            mColorLeft = a.getColor(R.styleable.MultiProg_mColorLeft, Color.WHITE);
            mColorRight = a.getColor(R.styleable.MultiProg_mColorRight, Color.WHITE);
            mBackgroundColor = a.getColor(R.styleable.MultiProg_mBgcolor, Color.WHITE);
            setmMaxProgress(mMaxProgress);
            setmCurrentProgress(mCurrentProgress);
            setmReachedBarColor(mReachedBarColor);
            setmUnreachedBarColor(mUnreachedBarColor);
            setmDescColor(mDescColor);
            setmTextColor(mTextColor);
            setmTextColor2(mTextColor2);
            setmColorLeft(mColorLeft);
            setmColorRight(mColorRight);

        } finally {

            a.recycle();
        }

        mReachedPaint();
        mUnReachedPaint();
        mTextPaint();
        mTextPaint2();
        mCircleLeft();
        mCircleRight();

    }

    private void mCircleRight() {

        mCircleRight = new Paint();
        mCircleRight.setColor(mColorRight);
        mCircleRight.setStyle(Paint.Style.FILL);
        mCircleRight.setFlags(Paint.ANTI_ALIAS_FLAG);
        setmCircleRight(mCircleRight);

    }


    private void mTextPaint2() {

        mTextPaint2 = new Paint();
        mTextPaint2.setColor(mTextColor2);
        mTextPaint2.setStyle(Paint.Style.STROKE);
        mTextPaint2.setTextSize(mTextSize);
        mTextPaint2.setFlags(Paint.ANTI_ALIAS_FLAG);
        setmTextPaint2(mTextPaint2);
    }

    private void mCircleLeft() {

        mCircleLeft = new Paint();
        mCircleLeft.setColor(mColorLeft);
        mCircleLeft.setStyle(Paint.Style.FILL);
        mCircleLeft.setFlags(Paint.ANTI_ALIAS_FLAG);
        setmCircleLeft(mCircleLeft);
    }


    private void mReachedPaint() {

        mReached = new Paint();
        mReached.setColor(mReachedBarColor);
        mReached.setStyle(Paint.Style.FILL_AND_STROKE);
        mReached.setStrokeWidth(mBarHeight);
//        mReached.setFlags(Paint.ANTI_ALIAS_FLAG);
        setmReached(mReached);
    }

    private void mUnReachedPaint() {

        mUnReached = new Paint();
        mUnReached.setColor(mUnreachedBarColor);
        mUnReached.setStyle(Paint.Style.FILL_AND_STROKE);
        mUnReached.setStrokeWidth(1);
//        mUnReached.setFlags(Paint.ANTI_ALIAS_FLAG);
        setmUnReached(mUnReached);
    }


    private void mTextPaint() {

        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        setmTextPaint(mTextPaint);

    }


    public void setmMaxProgress(int mMaxProgress) {

        this.mMaxProgress = mMaxProgress;
        invalidate();

    }

    public void setmDescColor(int mDescColor) {
        this.mDescColor = mDescColor;
        invalidate();
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
        invalidate();
    }

    public void setmTextColor2(int mTextColor2) {
        this.mTextColor2 = mTextColor2;
        invalidate();
    }


    public void setmColorLeft(int mColorLeft) {
        this.mColorLeft = mColorLeft;
        invalidate();
    }

    public void setmColorRight(int mColorRight) {
        this.mColorRight = mColorRight;
        invalidate();
    }

    public void setmCircleRight(Paint mCircleRight) {
        this.mCircleRight = mCircleRight;
    }

    public void setmTextbarprog(String mTextbarprog) {
        this.mTextbarprog = mTextbarprog;
        invalidate();
    }

    public void setmTextbarprog2(String mTextbarprog2) {
        this.mTextbarprog2 = mTextbarprog2;
        invalidate();
    }


    public void setmCurrentProgress(int mCurrentProgress) {

        this.mCurrentProgress = mCurrentProgress;
        setmTextbarprog("" + mCurrentProgress + "%");
        setmTextbarprog2("" + (mMaxProgress - mCurrentProgress) + "%");
        invalidate();
    }

    public void setmReachedBarColor(int mReachedBarColor) {

        this.mReachedBarColor = mReachedBarColor;
        invalidate();
    }

    public void setmUnreachedBarColor(int mUnreachedBarColor) {

        this.mUnreachedBarColor = mUnreachedBarColor;
        invalidate();
    }


    public void setmReached(Paint mReached) {
        this.mReached = mReached;
        invalidate();
    }

    public void setmUnReached(Paint mUnReached) {
        this.mUnReached = mUnReached;
        invalidate();
    }


    public void setmTextPaint2(Paint mTextPaint2) {
        this.mTextPaint2 = mTextPaint2;
        invalidate();
    }

    public void setmCircleLeft(Paint mCircleLeft) {
        this.mCircleLeft = mCircleLeft;
        invalidate();
    }


    public void setmTextPaint(Paint mTextPaint) {
        this.mTextPaint = mTextPaint;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int height;

        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int specHeight = MeasureSpec.getSize(heightMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        switch (heightMode) {


            case MeasureSpec.EXACTLY:
                height = specHeight;
                break;

            default:
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                height = (int) Math.max(2 * mTextPaint.measureText(mTextbarprog), 2 * mTextPaint.measureText("" + mMaxProgress + "%"));
                break;

        }
        setMeasuredDimension(specWidth, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setUpCanvas(canvas);
    }

    private void setUpCanvas(Canvas canvas) {

        if (mCurrentProgress < mMaxProgress) {

            canvas.drawRect(new RectF(0, getHeight() / 2,
                    getWidth(), getHeight() / 2), mUnReached);

            canvas.drawRect(new RectF(0, getHeight() / 2,
                    ((getWidth()) * mCurrentProgress) / mMaxProgress, getHeight() / 2), mReached);

            canvas.drawCircle(mTextPaint.measureText(mTextbarprog), getHeight() / 2, mTextPaint.measureText(mTextbarprog), mCircleLeft);
            canvas.drawText(mTextbarprog, mTextPaint.measureText(mTextbarprog) / 2, getHeight() / 2 + mTextPaint.getTextSize() / 2, mTextPaint);
            canvas.drawCircle(getWidth() - mTextPaint2.measureText(mTextbarprog2), getHeight() / 2, mTextPaint2.measureText(mTextbarprog2), mCircleRight);
            canvas.drawText(mTextbarprog2, (float) (getWidth() - 1.5 * mTextPaint2.measureText(mTextbarprog2)), getHeight() / 2 + mTextPaint2.getTextSize() / 2, mTextPaint2);

        }
        if (mCurrentProgress == mMaxProgress) {

            canvas.drawColor(mBackgroundColor);
            canvas.drawRect(new RectF(0, getHeight() / 2,
                    getWidth(), getHeight() / 2), mReached);
            mov = (int) (mTextPaint.measureText(mTextbarprog)) / 4;
            dir += mov;
            canvas.drawCircle(mTextPaint.measureText(mTextbarprog) + dir, getHeight() / 2, mTextPaint.measureText(mTextbarprog), mCircleLeft);
            canvas.drawText(mTextbarprog, mTextPaint.measureText(mTextbarprog) / 2 + dir, getHeight() / 2 + mTextPaint.getTextSize() / 2, mTextPaint);
            if (getWidth() - dir - mov > 2 * mTextPaint.measureText(mTextbarprog))
                invalidate();
            else {
                canvas.drawColor(mBackgroundColor);
                canvas.drawRect(new RectF(0, +getHeight() / 2,
                        getWidth(), getHeight() / 2), mReached);
                canvas.drawCircle(getWidth() - mTextPaint.measureText(mTextbarprog), getHeight() / 2, mTextPaint.measureText(mTextbarprog), mCircleLeft);
                canvas.drawText(mTextbarprog, (float) (getWidth() - 1.5 * mTextPaint.measureText(mTextbarprog)), getHeight() / 2 + mTextPaint.getTextSize() / 2, mTextPaint);
            }

        }
    }


}
