package com.kiguruming.curiosity.ui.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.view.NestedScrollingParent2;

public class NestingParentRecyclerView extends RecyclerView implements NestedScrollingParent2 {
    private static final String TAG = "NestedParent";

    private final NestedScrollingParentHelper parentHelper = new NestedScrollingParentHelper(this);

    public NestingParentRecyclerView(@NonNull Context context) {
        super(context);
    }

    public NestingParentRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestingParentRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.d(TAG, "onNestedScrollAccepted");
        parentHelper.onNestedScrollAccepted(child, target, axes, type);
        Log.d(TAG, "call startNestedScroll");
        startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
    }

    @Override
    public void onStopNestedScroll(View child) {
        super.onStopNestedScroll(child);
        parentHelper.onStopNestedScroll(child);
    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        super.onStopNestedScroll(target);
        parentHelper.onStopNestedScroll(target, type);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.d(TAG, String.format("onStartNestedScroll child:%x target:%x axes:%d type:%d",
                System.identityHashCode(child), System.identityHashCode(target),
                axes, type));
        return true;
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.d(TAG, String.format("onNestedScroll view:%x dxConsumed:%d dyConsumed:%d dxUnconsumed:%d dyUnconsumed:%d type:%d",
                System.identityHashCode(target), dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type));
        final int oldScrollY = getScrollY();
        scrollBy(0, dyUnconsumed);
        final int myConsumed = getScrollY() - oldScrollY;
        final int myUnconsumed  = dyUnconsumed - myConsumed;
        dispatchNestedScroll(0, myConsumed, 0, myUnconsumed, null);
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Log.d(TAG, String.format("onNestedPreScroll view:%x dx:%d dy:%d consumed[0]:%d consumed[1]:%d type:%d",
                System.identityHashCode(target), dx, dy, consumed[0], consumed[1], type));
        dispatchNestedPreScroll(dx, dy, consumed, null, type);
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
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
        Log.d(TAG, String.format("onNestedPreScroll without type view:%x dx:%d dy:%d consumed[0]:%d consumed[1]:%d",
                System.identityHashCode(target), dx, dy, consumed[0], consumed[1]));
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
}
