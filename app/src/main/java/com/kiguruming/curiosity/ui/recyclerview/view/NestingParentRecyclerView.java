package com.kiguruming.curiosity.ui.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParentHelper;
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
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.d(TAG, String.format("onStartNestedScroll child:%x target:%x axes:%d type:%d",
                System.identityHashCode(child), System.identityHashCode(target),
                axes, type));
        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        parentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        parentHelper.onStopNestedScroll(target, type);
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.d(TAG, String.format("onNestedScroll view:%x dxConsumed:%d dyConsumed:%d dxUnconsumed:%d dyUnconsumed:%d type:%d",
                System.identityHashCode(target), dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type));
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Log.d(TAG, String.format("onNestedPreScroll view:%x dx:%d dy:%d consumed[0]:%d consumed[1]:%d type:%d",
                System.identityHashCode(target), dx, dy, consumed[0], consumed[1], type));

    }
}
