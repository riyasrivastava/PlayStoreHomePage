package com.riyas.playstorehomepage.View

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.riyas.playstorehomepage.Model.RowModel
import com.riyas.playstorehomepage.R
import com.squareup.picasso.Picasso
import java.util.*

class RowOneRecyclerViewAdapter(context: Context, data: List<RowModel>) :
    RecyclerView.Adapter<RowOneRecyclerViewAdapter.RowOneListViewHolder>() {

    lateinit var data:List<RowModel>
    lateinit var context: Context

    init {
        this.data = data
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowOneListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return RowOneListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RowOneListViewHolder, position: Int) {

        val transformation = RoundedTransformationBuilder()
                .borderColor(Color.LTGRAY)
                .borderWidthDp(2f)
                .cornerRadiusDp(20f)
                .oval(false)
                .build()
        val url:String = data.get(position).img
        holder.name.text = data.get(position).name
        Picasso.with(context)
                .load(url)
                .fit()
                .transform(transformation)
                .into(holder.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RowOneListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.row_image_item)
        var name :TextView = view.findViewById(R.id.textView2)
    }
}