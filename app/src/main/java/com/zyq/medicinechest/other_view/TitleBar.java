package com.zyq.medicinechest.other_view;



import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyq.medicinechest.R;

/**
 * @describe TitleBar.java
 * @author Huanghuan
 * @date 2015年9月8日
 * @version 1.0
 */
public class TitleBar extends FrameLayout {
	private TextView tvLeft;
	private TextView tvCenter;
	private TextView tvRight;
	private FrameLayout view;
	private ImageView remind;

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.include_titlebar, this);
		view = (FrameLayout) findViewById(R.id.bg_include_titlebar);
		tvLeft = (TextView) findViewById(R.id.tv_left_titlebar);
		remind = (ImageView) findViewById(R.id.remind_title_bar);
		tvCenter = (TextView) findViewById(R.id.tv_title_titlebar);
		tvRight = (TextView) findViewById(R.id.tv_right_titlebar);
	}

	public void setRemindVisible(boolean isVisible) {
		if (isVisible) {
			remind.setVisibility(View.VISIBLE);
		} else {
			remind.setVisibility(View.GONE);
		}

	}

	public void setBackgroundColor(String colorString) {
		view.setBackgroundColor(Color.parseColor(colorString));
	}

	public void setTitleText(String text) {
		tvCenter.setText(text);
	}

	public void setLeftText(String text) {
		tvLeft.setText(text);
	}

	public void setLeftButtonClickListener(OnClickListener listener) {
		tvLeft.setOnClickListener(listener);
	}

	public void setLeftImage(Drawable d) {
		tvLeft.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
	}

	public void setLeftImage(int id) {
		tvLeft.setCompoundDrawablesWithIntrinsicBounds(id, 0, 0, 0);
	}

	public void setRightText(String text) {
		tvRight.setText(text);
	}

	public void setRightButtonClickListener(OnClickListener listener) {
		tvRight.setOnClickListener(listener);
	}

	public void setRightImage(Drawable d) {
		tvRight.setCompoundDrawablesWithIntrinsicBounds(null, null, d, null);
	}

	public void setRightImage(int id) {
		tvRight.setCompoundDrawablesWithIntrinsicBounds(0, 0, id, 0);
	}

}
