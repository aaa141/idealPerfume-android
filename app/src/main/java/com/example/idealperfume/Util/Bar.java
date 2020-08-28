package com.example.idealperfume.Util;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class Bar extends ProgressBar {


	public Bar(Context context) {
		super(context);
	}

	public Bar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Bar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(h, w, oldh, oldw);
	}

	@Override
	protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected synchronized void onDraw(Canvas canvas) {
		canvas.rotate(-90);
		canvas.translate(-getHeight(), 0);
		super.onDraw(canvas);
	}

}
