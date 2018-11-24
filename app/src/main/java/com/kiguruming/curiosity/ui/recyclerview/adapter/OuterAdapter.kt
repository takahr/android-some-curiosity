package com.kiguruming.curiosity.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiguruming.curiosity.R
import kotlinx.android.synthetic.main.item_fixed.view.*
import kotlinx.android.synthetic.main.item_inner_recycler.view.*

class OuterAdapter : RecyclerView.Adapter<OuterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEWTYPE_RECYCLER -> RecyclerViewHolder.create(inflater, parent)
            else -> FixedViewHolder.create(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAdapter(this, position)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            5 -> VIEWTYPE_RECYCLER
            else -> VIEWTYPE_FIXED
        }
    }

    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindAdapter(adapter: OuterAdapter, position: Int)
    }

    class FixedViewHolder(itemView: View) : ViewHolder(itemView) {
        override fun bindAdapter(adapter: OuterAdapter, position: Int) {
            itemView.button.text = itemView.context.getString(R.string.button_outer_format, position)
        }

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): FixedViewHolder {
                var view = inflater.inflate(R.layout.item_fixed, parent, false);
                return FixedViewHolder(view)
            }
        }
    }

    class RecyclerViewHolder(itemView: View) : ViewHolder(itemView) {
        override fun bindAdapter(adapter: OuterAdapter, position: Int) {
            itemView.recyclerView.adapter = InnerAdapter()
            itemView.recyclerView.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
        }

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): RecyclerViewHolder {
                var view = inflater.inflate(R.layout.item_inner_recycler, parent, false)
                return RecyclerViewHolder(view)
            }
        }
    }

    companion object {
        const val VIEWTYPE_FIXED = 1
        const val VIEWTYPE_RECYCLER = 2
    }

}