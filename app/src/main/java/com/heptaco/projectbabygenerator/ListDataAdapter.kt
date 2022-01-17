package com.heptaco.projectbabygenerator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListDataAdapter(var mCtx: Context, var resources:Int, var items:List<ListData>):ArrayAdapter<ListData>(mCtx, resources, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources, null)

        val imageView:ImageView = view.findViewById(R.id.img_item_photo)
        val titleView:TextView = view.findViewById(R.id.tv_item_name)
        val descriptionView:TextView = view.findViewById(R.id.tv_item_description)

        var mItem:ListData = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        titleView.text = mItem.judul
        descriptionView.text = mItem.deskripsi

        return view
    }
}