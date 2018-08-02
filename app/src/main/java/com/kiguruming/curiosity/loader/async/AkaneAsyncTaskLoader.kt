package com.kiguruming.curiosity.loader.async

import android.content.Context
import android.support.v4.content.AsyncTaskLoader

class Result() {

}

class AkaneAsyncTaskLoader(context: Context) : AsyncTaskLoader<Result>(context) {
    override fun loadInBackground(): Result {
        return Result()
    }

    override fun onStartLoading() {
        super.onStartLoading()
        forceLoad()
    }
}
