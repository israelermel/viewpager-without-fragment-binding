package com.example.testeviewpager;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.v4.view.ViewPager;
import android.util.Log;

import me.tatarka.bindingcollectionadapter2.ItemBinding;


public class ViewModel {

    private ViewPager mAdapter;

    public final ObservableList<String> items = new ObservableArrayList<>();
    public final ObservableList<String> items2 = new ObservableArrayList<>();
    public final ObservableList<String> items3 = new ObservableArrayList<>();
    public final ObservableList<String> items4 = new ObservableArrayList<>();

    public final ObservableBoolean enabledOption1 =  new ObservableBoolean();
    public final ObservableBoolean enabledOption2 =  new ObservableBoolean();
    public final ObservableBoolean enabledOption3 =  new ObservableBoolean();
    public final ObservableBoolean enabledOption4 =  new ObservableBoolean();

    public int index = 0;

    OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onItemClick(String item) {
            Log.d("israel %s", item);
            nextPage();
        }
    };

    public final ItemBinding<String> itemBinding = ItemBinding.<String>of(BR.item, R.layout.item).bindExtra(BR.listener, listener);

    public ViewModel(ViewPager adapter) {
        mAdapter = adapter;
    }

    public void nextPage() {
        index = mAdapter.getCurrentItem() + 1;
        mAdapter.setCurrentItem(index);
        configTab(index);
    }

    public void previousPage() {
        index = mAdapter.getCurrentItem() - 1;
        mAdapter.setCurrentItem(index);
        configTab(index);
    }


    public interface OnItemClickListener {
        void onItemClick(String item);
    }


    private void disableAll() {
        enabledOption1.set(false);
        enabledOption2.set(false);
        enabledOption3.set(false);
        enabledOption4.set(false);
    }

    public void configTab(int index) {

        if (index < 0 || index > 3) {return;}

        disableAll();

        switch (index) {
            case 0:
                enabledOption1.set(true);
                break;
            case 1:
                enabledOption2.set(true);
                break;
            case 2:
                enabledOption3.set(true);
                break;
            case 3:
                enabledOption4.set(true);
                break;
        }
    }

}
