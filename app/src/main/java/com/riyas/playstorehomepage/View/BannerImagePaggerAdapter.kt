package com.riyas.playstorehomepage.View

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.riyas.playstorehomepage.Model.RowModel
import com.riyas.playstorehomepage.R
import com.squareup.picasso.Picasso
import java.util.*


class BannerImagePaggerAdapter(context: Context, data: List<RowModel>) :PagerAdapter() {
    lateinit var data:List<RowModel>
    lateinit var context: Context
    lateinit var mLayoutInflater:LayoutInflater
    init {
        this.data = data
        this.context = context
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return data.count()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = mLayoutInflater.inflate(R.layout.banner_image_item, container, false)
        val imageView: ImageView = itemView.findViewById<View>(R.id.bannerimage) as ImageView
        val url:String = data.get(position).img
        val transformation = RoundedTransformationBuilder()
            .borderColor(Color.GRAY)
            .borderWidthDp(2f)
            .cornerRadiusDp(20f)
            .oval(false)
            .build()
        Picasso.with(context)
            .load(url)
            .fit()
            .transform(transformation)
            .into(imageView)

        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout?)
    }
}