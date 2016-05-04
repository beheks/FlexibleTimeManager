package xyz.felipearaujo.flexibletimemanager.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;

public class RingTimerView extends View {
    private Paint mPaintGoalNotReached;
    private Paint mPaintGoalAlmostReached;
    private Paint mPaintGoalReached;

    private Paint mBigText;
    private Paint mSmallText;
    private int mTextSpacing;
    private int mTextSize;
    private float mSmallTextScale;
    private int mCenterOffset;

    private int mSmallTextHeight;
    private int mBigTextHeight;

    private int mRadius;

    private int mStrokeWidth;

    private int x;
    private int y;

    public interface OnRingTimeCounterTickListener {
        void onRing
    }

    public RingTimerView(Context context) {
        this(context, null);
    }

    public RingTimerView(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public RingTimerView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init();
    }

    private void init() {
        mStrokeWidth = 20;

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
        mBigText.getTextBounds("0:0", 0, 1, tempRect);
        mBigTextHeight = tempRect.height();

        mSmallText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSmallText.setTextAlign(Paint.Align.CENTER);
        mSmallText.setTextSize(mTextSize * mSmallTextScale);
        mSmallText.getTextBounds("0:0", 0, 1, tempRect);
        mSmallTextHeight = tempRect.height();

        mCenterOffset = (mBigTextHeight + mTextSpacing + mSmallTextHeight) / 2;

        mRadius = 0;

        new Chronometer()

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mRadius = w;
        if(w > h) mRadius = h;

        x = w/2;
        y = h/2;

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x, y, mRadius/2 - mStrokeWidth/2, mPaintGoalReached);

        canvas.drawText("0:10", x, y + mCenterOffset - mTextSpacing - mSmallTextHeight, mBigText);
        canvas.drawText("0:50", x, y + mCenterOffset, mSmallText);
    }
}
