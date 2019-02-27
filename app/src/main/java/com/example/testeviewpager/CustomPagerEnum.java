package com.example.testeviewpager;

public enum  CustomPagerEnum {

    RED(R.string.primeiro, R.layout.primeiro),
    BLUE(R.string.segundo, R.layout.segundo),
    ORANGE(R.string.terceiro, R.layout.terceiro);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
