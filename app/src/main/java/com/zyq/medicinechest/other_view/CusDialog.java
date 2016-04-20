package com.zyq.medicinechest.other_view;

/**
 * @author Bright Van
 */

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyq.medicinechest.R;
import com.zyq.medicinechest.app.App;


public class CusDialog {

	/**
	 * 进度Dialog
	 * 
	 * @param
	 */
	public static AlertDialog showProgressDialog(Context context, String str) {

		AlertDialog dialog = new AlertDialog.Builder(context).create();
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.dialog_progress, null);
		dialog.show();
		dialog.setContentView(view);
		ImageView imageView = (ImageView) view
				.findViewById(R.id.dialog_progress_iv);
		AnimationDrawable animation = (AnimationDrawable) imageView
				.getDrawable();
		animation.start();
		dialog.getWindow().setLayout(
				(int) (App.getMetrics().widthPixels * 0.5),
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		TextView tv = (TextView) view.findViewById(R.id.dialog_progress_tv);
		tv.setText(str);
		return dialog;
	}

}
