package com.kiguruming.curiosity.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiguruming.curiosity.R

class OuterAdapter : RecyclerView.Adapter<OuterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        when (viewType) {
            else -> {
                return FixedViewHolder.create(inflater, parent)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        return VIEWTYPE_FIXED
    }

    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class FixedViewHolder(itemView: View) : ViewHolder(itemView) {

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup) : FixedViewHolder {
                var view = inflater.inflate(R.layout.item_fixed, parent, false);
                return FixedViewHolder(view)
            }
        }
    }

    companion object {
        const val VIEWTYPE_FIXED = 1
        const val VIEWTYPE_RECYCLER = 2
    }

}