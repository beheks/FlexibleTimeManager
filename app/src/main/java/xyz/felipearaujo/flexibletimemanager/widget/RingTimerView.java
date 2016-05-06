package xyz.felipearaujo.flexibletimemanager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;

import xyz.felipearaujo.flexibletimemanager.R;

public class RingTimerView extends View {
    private Paint mRingPaint;
    private Paint mRingFirstMilestonePaint;
    private Paint mRingSecondMilestonePaint;
    private Paint mRingBackgroundPaint;
    private int mStrokeWidth;
    private int mRadius;
    private float mFirstMilestone;
    private float mSecondMilestone;
    private RectF mRingBounds;

    private TextPaint mBigTextPaint;
    private TextPaint mSmallTextPaint;
    private float mTextSpacing;
    private float mTextSize;
    private float mSmallTextSize;
    private float mCenterOffset;
    private float mSmallTextHeight;
    private float mBigTextHeight;

    private boolean mVisible;
    private boolean mStarted;
    private boolean mRunning;

    private OnRingTimerTickListener mOnRingTimerTickListener;
    private static final int TICK = 1;

    private int x;
    private int y;

    private long mCurrentTime;
    private long mGoal;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message m) {
            if (mRunning) {
                //updateText(SystemClock.elapsedRealtime());
                dispatchChronometerTick();
                sendMessageDelayed(Message.obtain(this, TICK), 1000);
            }
        }
    };

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
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attrSet) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrSet,
                R.styleable.RingTimerView,
                0, 0);
        try {
            mStrokeWidth = a.getInt(R.styleable.RingTimerView_ringStrokeWidth, 30);

            mRingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mRingPaint.setStyle(Paint.Style.STROKE);
            mRingPaint.setStrokeWidth(mStrokeWidth);
            mRingPaint.setColor(a.getColor(
                            R.styleable.RingTimerView_ringColor,
                            Color.argb(255, 255, 0, 0)));

            mRingBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mRingBackgroundPaint.setStyle(Paint.Style.STROKE);
            mRingBackgroundPaint.setStrokeWidth(mStrokeWidth - 6);
            mRingBackgroundPaint.setColor(
                    a.getColor(R.styleable.RingTimerView_ringColor, Color.LTGRAY));


            mRingFirstMilestonePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mRingFirstMilestonePaint.setStyle(Paint.Style.STROKE);
            mRingFirstMilestonePaint.setStrokeWidth(mStrokeWidth);
            mRingFirstMilestonePaint.setColor(a.getColor(
                    R.styleable.RingTimerView_ringFirstMilestoneColor,
                    mRingPaint.getColor()));

            mRingSecondMilestonePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mRingSecondMilestonePaint.setStyle(Paint.Style.STROKE);
            mRingSecondMilestonePaint.setStrokeWidth(mStrokeWidth);
            mRingSecondMilestonePaint.setColor(a.getColor(
                    R.styleable.RingTimerView_ringSecondMilestoneColor,
                    mRingFirstMilestonePaint.getColor()));

            mBigTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
            mBigTextPaint.setTextAlign(Paint.Align.CENTER);

            mSmallTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
            mSmallTextPaint.setTextAlign(Paint.Align.CENTER);

            mRadius = a.getDimensionPixelSize(R.styleable.RingTimerView_ringRadius, 0);

            mFirstMilestone = a.getFraction(
                    R.styleable.RingTimerView_ringFirstMilestone,
                    1,
                    1,
                    0.33f);

            mSecondMilestone = a.getFraction(
                    R.styleable.RingTimerView_ringFirstMilestone,
                    1,
                    1,
                    mFirstMilestone);
        }
        finally {
            a.recycle();
        }

        mRunning = true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if(mRadius == 0) {
            mRadius = w / 2;
            if (w > h) mRadius = h / 2;
        }

        if(mTextSize == 0) {
            mTextSize = mRadius * 0.4f;
            mTextSpacing = mTextSize * 0.2f;
            mSmallTextSize = mTextSize * 0.5f;
        }

        Rect tempRect = new Rect();

        mBigTextPaint.setTextSize(mTextSize);
        mBigTextPaint.getTextBounds("0:0", 0, 2, tempRect);
        mBigTextHeight = tempRect.height();

        mSmallTextPaint.setTextSize(mSmallTextSize);
        mSmallTextPaint.getTextBounds("0:0", 0, 2, tempRect);
        mSmallTextHeight = tempRect.height();

        mCenterOffset = (mBigTextHeight + mTextSpacing + mSmallTextHeight) / 2;

        x = w/2;
        y = h/2;

        mRingBounds = new RectF(x - mRadius + mStrokeWidth/2,
                y - mRadius + mStrokeWidth/2,
                x + mRadius - mStrokeWidth/2,
                y + mRadius - mStrokeWidth/2);

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float ratio = (float) mCurrentTime / mGoal;

        Paint appropriatePaint = mRingPaint;

        if(ratio >= mFirstMilestone && ratio <= mSecondMilestone)
            appropriatePaint = mRingFirstMilestonePaint;

        else if(ratio > mSecondMilestone) appropriatePaint = mRingSecondMilestonePaint;

        canvas.drawCircle(x, y, mRadius - mStrokeWidth/2, mRingBackgroundPaint);
        canvas.drawArc(mRingBounds, 270.0f, 360f * ratio, false, appropriatePaint);

        canvas.drawText(
                ViewUtil.secToText(mCurrentTime, false),
                x,
                y + mCenterOffset - mTextSpacing - mSmallTextHeight,
                mBigTextPaint);

        canvas.drawText(ViewUtil.secToText(mGoal, true), x, y + mCenterOffset, mSmallTextPaint);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mVisible = (visibility == VISIBLE);
    }

    protected void updateTime(long now) {

    }

    protected void dispatchChronometerTick() {
        if(mOnRingTimerTickListener != null) {
            mOnRingTimerTickListener.onRingTimerTick(this);
        }
    }

    public void setTimeSpent(int newValue) {
        mCurrentTime = newValue;
        invalidate();
        requestLayout();
    }

    public void setGoal(int goal) {
        mGoal = goal;
        invalidate();
        requestLayout();
    }
}
