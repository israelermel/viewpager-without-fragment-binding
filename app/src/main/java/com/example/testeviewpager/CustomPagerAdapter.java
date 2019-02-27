package com.example.testeviewpager;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testeviewpager.databinding.PrimeiroBinding;
import com.example.testeviewpager.databinding.SegundoBinding;
import com.example.testeviewpager.databinding.TerceiroBinding;

public class CustomPagerAdapter extends PagerAdapter {

    private ViewModel mViewModel;
    private Context mContext;

    public CustomPagerAdapter(Context context) {
        this(context, null);
    }

    public CustomPagerAdapter(Context context, ViewModel viewModel) {
        mContext = context;
        mViewModel = viewModel;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];

        switch (position) {
            case 0:
                PrimeiroBinding layout = DataBindingUtil.inflate(inflater, customPagerEnum.getLayoutResId(), collection, false);
                layout.setViewModel(mViewModel);
                collection.addView(layout.getRoot());
                return layout;
            case 1:
                SegundoBinding layout2 = DataBindingUtil.inflate(inflater, customPagerEnum.getLayoutResId(), collection, false);
                layout2.setViewModel(mViewModel);
                collection.addView(layout2.getRoot());
                return layout2;
            default:
                TerceiroBinding layout3 = DataBindingUtil.inflate(inflater, customPagerEnum.getLayoutResId(), collection, false);
                layout3.setViewModel(mViewModel);
                collection.addView(layout3.getRoot());
                return layout3;

        }
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return CustomPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }
}
