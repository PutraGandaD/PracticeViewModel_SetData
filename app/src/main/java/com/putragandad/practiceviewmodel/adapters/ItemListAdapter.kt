package com.putragandad.practiceviewmodel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.putragandad.practiceviewmodel.R
import com.putragandad.practiceviewmodel.models.Item

class ItemListAdapter(private val dataSet: ArrayList<Item>, private val onClickListener: OnClickListener): RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {
   class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val cardTitle = view.findViewById<TextView>(R.id.tv_list_card_title)
       val cardDescription = view.findViewById<TextView>(R.id.tv_list_card_desc)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_list_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet.get(position) // get data from the current position
        holder.cardTitle.text = data.name
        holder.cardDescription.text = data.description

        val itemCard = holder.itemView.findViewById<MaterialCardView>(R.id.card_list)
        itemCard.setOnClickListener {
            onClickListener.onItemClicked(data)
        }

    }
}

interface OnClickListener {
    fun onItemClicked(item: Item)
}