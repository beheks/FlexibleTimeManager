package xyz.felipearaujo.flexibletimemanager.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class RingTimerView extends View {
    private Paint mPaintGoalNotReached;
    private Paint mPaintGoalAlmostReached;
    private Paint mPaintGoalReached;
    private int mStrokeWidth;
    private int mRadius;

    private Paint mBigText;
    private Paint mSmallText;
    private int mTextSpacing;
    private int mTextSize;
    private float mSmallTextScale;
    private int mCenterOffset;
    private int mSmallTextHeight;

    private int x;
    private int y;

    private long mCurrentTime;
    private long mGoal;

    private boolean mStarted;
    private boolean mVisible;

    private StringBuilder mRecycle = new StringBuilder(8);

    public interface OnRingTimerTickListener {
        void onRingTimerTick(RingTimerView ringTimerView);
    }

    public RingTimerView(Context context) {
        this(context, null);
    }

    public RingTimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RingTimerView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init();
    }

    private void init() {
        mStrokeWidth = 30;

        mPaintGoalNotReached = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintGoalNotReached.setARGB(255, 255, 0, 0);
        mPaintGoalNotReached.setStyle(Paint.Style.STROKE);
        mPaintGoalNotReached.setStrokeWidth(mStrokeWidth);

        mPaintGoalAlmostReached = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintGoalAlmostReached.setARGB(255, 255, 255, 0);
        mPaintGoalAlmostReached.setStyle(Paint.Style.STROKE);
        mPaintGoalAlmostReached.setStrokeWidth(mStrokeWidth);

        mPaintGoalReached = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintGoalReached.setARGB(255, 0, 255, 0);
        mPaintGoalReached.setStyle(Paint.Style.STROKE);
        mPaintGoalReached.setStrokeWidth(mStrokeWidth);

        Rect tempRect = new Rect();

        mTextSize = 300;
        mTextSpacing = 50;
        mSmallTextScale = 0.5f;

        mBigText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBigText.setTextAlign(Paint.Align.CENTER);
        mBigText.setTextSize(mTextSize);
        mBigText.getTextBounds("0:0", 0, 2, tempRect);
        int bigTextHeight = tempRect.height();

        mSmallText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSmallText.setTextAlign(Paint.Align.CENTER);
        mSmallText.setTextSize(mTextSize * mSmallTextScale);
        mSmallText.getTextBounds("0:0", 0, 2, tempRect);
        mSmallTextHeight = tempRect.height();

        mCenterOffset = (bigTextHeight + mTextSpacing + mSmallTextHeight) / 2;

        mRadius = 0;

        //TODO: stop being fixed
        mCurrentTime = 30;
        mGoal = 400;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mRadius = w/2;
        if(w > h) mRadius = h/2;

        x = w/2;
        y = h/2;

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float ratio = (float) mCurrentTime / mGoal;

        Paint appropriatePaint = mPaintGoalNotReached;
        if(ratio >= 0.33 && ratio <= 0.66) appropriatePaint = mPaintGoalAlmostReached;
        else if(ratio > 0.66) appropriatePaint = mPaintGoalReached;

        Log.d("RINGTIMER", "" + mRadius);
        drawArc(canvas, 360f , appropriatePaint);

        canvas.drawText(
                secToText(mCurrentTime),
                x,
                y + mCenterOffset - mTextSpacing - mSmallTextHeight,
                mBigText);

        canvas.drawText(secToText(mGoal), x, y + mCenterOffset, mSmallText);
    }

    private String secToText(long time) {
        return DateUtils.formatElapsedTime(mRecycle, time);
    }

    //TODO: MAKE BACKWARDS COMPATIBLE
    @TargetApi(21)
    private void drawArc(Canvas canvas, float angleInDegrees, Paint paint) {
        Log.d("RingTimer", "" + angleInDegrees);
        canvas.drawArc(
                x - mRadius + mStrokeWidth/2,
                y - mRadius + mStrokeWidth/2,
                x + mRadius - mStrokeWidth/2,
                y + mRadius - mStrokeWidth/2,
                270.0f,
                angleInDegrees,
                false,
                paint
        );
    }
}
