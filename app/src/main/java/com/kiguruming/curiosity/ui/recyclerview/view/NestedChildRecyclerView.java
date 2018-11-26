package com.kiguruming.curiosity.ui.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NestedChildRecyclerView extends RecyclerView {
    private static final String TAG = "NestedChiled";

    public NestedChildRecyclerView(@NonNull Context context) {
        super(context);
        Log.d(TAG, "ctor1");
    }

    public NestedChildRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "ctor2");
    }

    public NestedChildRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.d(TAG, "ctor3");
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        boolean res = super.onNestedFling(target, velocityX, velocityY, consumed);
        Log.d(TAG, String.format("onNestedFling target:%x velocityX:%f velocityY:%f consumed:%s result:%s", System.identityHashCode(target), velocityX, velocityY, consumed, res));
        return res;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        boolean res = super.onNestedPreFling(target, velocityX, velocityY);
        Log.d(TAG, String.format("onNestedPreFling target:%x velocityX:%f velocityY:%f result:%s", System.identityHashCode(target), velocityX, velocityY, res));
        return res;
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        boolean res = super.onStartNestedScroll(child, target, nestedScrollAxes);
        Log.d(TAG, String.format("onStartNestedScroll child:%x target:%x, axes:%d result:%s",
                System.identityHashCode(child), System.identityHashCode(target), nestedScrollAxes, res));
        return res;
    }
}
