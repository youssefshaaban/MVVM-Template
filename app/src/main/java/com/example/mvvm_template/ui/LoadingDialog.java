package com.example.mvvm_template.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.mvvm_template.R;


public class LoadingDialog extends Dialog {

    private Context context;
    public LoadingDialog(@NonNull Context context) {
        super(context);
        this.context=context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_loading_gif);
        Window window = getWindow();
        Point size = new Point();
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);
        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 1.0);
        int height = (int) (context.getResources().getDisplayMetrics().heightPixels * 1.0);
        getWindow().setLayout(width, height);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        window.setAttributes(wlp);
        setCancelable(false);
    }
    public static LoadingDialog create(Context context) {
        return new LoadingDialog(context);
    }

    public LoadingDialog showDialog(){
        if (!isShowing())
            show();
        return this;
    }

    public LoadingDialog dism(){
        if (isShowing()&&context !=null && !((Activity)context).isFinishing() )
            dismiss();
        return this;
    }

}
