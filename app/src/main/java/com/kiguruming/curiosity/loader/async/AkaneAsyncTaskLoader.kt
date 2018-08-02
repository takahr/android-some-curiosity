package com.kiguruming.curiosity.loader.async

import android.content.AsyncTaskLoader
import android.content.Context

class Result() {

}

class AkaneAsyncTaskLoader(context: Context) : AsyncTaskLoader<Result>(context) {
    override fun loadInBackground(): Result {
        return Result()
    }
}
