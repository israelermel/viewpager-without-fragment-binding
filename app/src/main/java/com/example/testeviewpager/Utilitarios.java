package com.example.testeviewpager;


import android.databinding.BindingAdapter;
import android.graphics.Paint;
import android.widget.TextView;

public class Utilitarios {

    @BindingAdapter("text_underline")
    public static void textUnderline(TextView textView, boolean enabled) {
        if (enabled) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        } else {
            textView.setPaintFlags(textView.getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
        }
    }

}
