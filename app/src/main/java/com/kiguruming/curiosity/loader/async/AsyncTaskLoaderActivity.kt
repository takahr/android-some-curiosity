package com.kiguruming.curiosity.loader.async

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.util.Log
import com.kiguruming.curiosity.R
import com.kiguruming.curiosity.databinding.ActivityAsyncTaskLoaderBinding

class AsyncTaskLoaderActivity : AppCompatActivity() {

    val loaderCallbacks = object: LoaderManager.LoaderCallbacks<Result> {
        override fun onCreateLoader(id: Int, args: Bundle?): Loader<Result> {
            return AkaneAsyncTaskLoader(this@AsyncTaskLoaderActivity)
        }

        override fun onLoadFinished(loader: Loader<Result>, data: Result?) {
            Log.d(TAG, "onLoadFinished")
        }

        override fun onLoaderReset(loader: Loader<Result>) {
            Log.d(TAG, "onLoaderReset")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityAsyncTaskLoaderBinding = DataBindingUtil.setContentView(this, R.layout.activity_async_task_loader)

        val loaderManager = supportLoaderManager
        loaderManager.initLoader(LOADER_AKANE_ID, null, loaderCallbacks)
    }

    companion object {
        const val TAG = "AsyncTaskLoaderActivity"
        const val LOADER_AKANE_ID = 1
    }
}
