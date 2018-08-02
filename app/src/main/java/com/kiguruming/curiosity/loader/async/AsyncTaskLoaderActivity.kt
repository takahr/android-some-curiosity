package com.kiguruming.curiosity.loader.async

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kiguruming.curiosity.R
import com.kiguruming.curiosity.databinding.ActivityAsyncTaskLoaderBinding

class AsyncTaskLoaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityAsyncTaskLoaderBinding = DataBindingUtil.setContentView(this, R.layout.activity_async_task_loader);
    }
}
