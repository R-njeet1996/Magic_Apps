package com.example.magicapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.magicapps.R
import com.example.magicapps.utils.ItemClickListener

class PhotoAdapter (var context: Context,var task: ArrayList<String>,var image: ArrayList<String>,var itemClickListener: ItemClickListener): RecyclerView.Adapter<PhotoAdapter.CustomViewHolder>()
{
    inner  class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivPhoto :ImageView
        var tvTask :AppCompatTextView
        var rlMain :RelativeLayout

        init {

            ivPhoto = itemView.findViewById(R.id.iv_image)
            tvTask = itemView.findViewById(R.id.tv_task)
            rlMain = itemView.findViewById(R.id.rl_main)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoAdapter.CustomViewHolder {
        val mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.photo_inflator, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.CustomViewHolder, position: Int) {
      holder.tvTask.setText(task.get(position))
        holder.rlMain.setOnClickListener {

            itemClickListener.onItemCLickListener(it,position)
        }

        Glide.with(context)
            .load(image.get(position))
            .placeholder(R.color.black)
            .into(holder.ivPhoto)

    }

    override fun getItemCount(): Int {
       return task.size
    }

}