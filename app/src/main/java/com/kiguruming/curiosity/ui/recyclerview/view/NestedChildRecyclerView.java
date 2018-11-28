package com.kiguruming.curiosity.ui.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Locale;

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

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        Log.d(TAG, String.format("requestDisallowInterceptTouchEvent: %s", disallowIntercept));
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        boolean res = super.onTouchEvent(e);
        Log.d(TAG, String.format(Locale.US, "onTouchEvent: %d %s", e.getAction(), res));
        return res;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        boolean res = super.onInterceptTouchEvent(e);
        Log.d(TAG, String.format(Locale.US, "onInterceptTouchEvent: %d %s", e.getAction(), res));
        return res;
    }

    @Override
    public boolean startNestedScroll(int axes) {
        Log.d(TAG, String.format(Locale.US, "startNestedScroll: %d", axes));
        return super.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        Log.d(TAG, "stopNestedScroll");
        super.stopNestedScroll();
    }

    @Override
    public void stopNestedScroll(int type) {
        Log.d(TAG, String.format(Locale.US, "stopNestedScroll type:%d", type));
        super.stopNestedScroll(type);
    }

    @Override
    public boolean hasNestedScrollingParent() {
        boolean res = super.hasNestedScrollingParent();
        Log.d(TAG, String.format(Locale.US, "hasNestedScrollingParent :%s", res));
        return res;
    }
}
