package com.kiguruming.curiosity.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiguruming.curiosity.R
import kotlinx.android.synthetic.main.item_inner_fixed.view.*

class InnerAdapter : RecyclerView.Adapter<InnerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return InnerFixedViewHolder.create(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAdapter(this, position)
    }

    override fun getItemCount(): Int {
        return 45
    }

    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindAdapter(adapter: InnerAdapter, position : Int)
    }

    class InnerFixedViewHolder(itemView: View) : ViewHolder(itemView) {
        override fun bindAdapter(adapter: InnerAdapter, position: Int) {
            itemView.button.text = itemView.context.getString(R.string.button_inner_format, position)
        }

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup) : InnerFixedViewHolder {
                var view = inflater.inflate(R.layout.item_inner_fixed, parent, false)
                return InnerFixedViewHolder(view)
            }
        }
    }

}