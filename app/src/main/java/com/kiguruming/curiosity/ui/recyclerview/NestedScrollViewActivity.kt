package com.kiguruming.curiosity.ui.recyclerview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiguruming.curiosity.R
import com.kiguruming.curiosity.ui.recyclerview.adapter.InnerAdapter
import kotlinx.android.synthetic.main.activity_nested_scroll_view.*

class NestedScrollViewActivity : AppCompatActivity() {
    val adapter = InnerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter.notifyDataSetChanged()
    }

    companion object {
        fun createIntent(context: Context) : Intent {
            val intent = Intent(context, NestedScrollViewActivity::class.java)
            return intent
        }
    }
}
