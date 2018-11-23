package com.kiguruming.curiosity

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiguruming.curiosity.databinding.ActivityMainBinding
import com.kiguruming.curiosity.ui.recyclerview.NestingRecyclerViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.ui = UiListener()
    }

    inner class UiListener {
        fun onClickNestingRecyclerViewActivity() {
            startActivity(NestingRecyclerViewActivity.createIntent(this@MainActivity))
        }
    }
}
