package com.londonappbrewery.destini;

import android.support.annotation.IdRes;

public class Story {

    @IdRes
    private int mLabel;

    @IdRes
    private int mButtonTop;

    @IdRes
    private int mButtonBottom;

    public Story(int label, int buttonTop, int buttonBottom) {
        mLabel = label;
        mButtonTop = buttonTop;
        mButtonBottom = buttonBottom;
    }

    public int getLabel() {
        return mLabel;
    }

    public void setLabel(int label) {
        mLabel = label;
    }

    public int getButtonTop() {
        return mButtonTop;
    }

    public void setButtonTop(int buttonTop) {
        mButtonTop = buttonTop;
    }

    public int getButtonBottom() {
        return mButtonBottom;
    }

    public void setButtonBottom(int buttonBottom) {
        mButtonBottom = buttonBottom;
    }
}
