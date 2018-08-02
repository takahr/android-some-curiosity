package com.kiguruming.curiosity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiguruming.curiosity.databinding.ActivityMainBinding
import com.kiguruming.curiosity.loader.async.AsyncTaskLoaderActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.ui = UiListener()
    }

    inner class UiListener {
        fun onClick() {
        }
    }
}
