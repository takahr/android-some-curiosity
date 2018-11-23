package com.kiguruming.curiosity.ui.recyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiguruming.curiosity.R

class NestingRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nesting_recycler_view)
    }

    companion object {
        fun createIntent(context: Context) : Intent {
            val intent = Intent(context, NestingRecyclerViewActivity::class.java);
            return intent;
        }
    }
}
