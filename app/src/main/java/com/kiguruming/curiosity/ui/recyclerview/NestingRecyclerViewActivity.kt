package com.kiguruming.curiosity.ui.recyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiguruming.curiosity.R
import com.kiguruming.curiosity.ui.recyclerview.adapter.OuterAdapter
import kotlinx.android.synthetic.main.activity_nesting_recycler_view.*

class NestingRecyclerViewActivity : AppCompatActivity() {
    val adapter = OuterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nesting_recycler_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter.notifyDataSetChanged()
    }

    companion object {
        fun createIntent(context: Context) : Intent {
            val intent = Intent(context, NestingRecyclerViewActivity::class.java)
            return intent
        }
    }
}
