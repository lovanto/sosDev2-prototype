package com.lovanto.sosdev.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lovanto.sosdev.R
import com.lovanto.sosdev.model.DataFollowing
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_row_users.view.*

var followingFilterList = ArrayList<DataFollowing>()

class ListDataFollowingAdapter(listData: ArrayList<DataFollowing>) :
    RecyclerView.Adapter<ListDataFollowingAdapter.ListDataHolder>() {

    init {
        followingFilterList = listData
    }

    inner class ListDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageAvatar: CircleImageView = itemView.avatar
        var name: TextView = itemView.user_name
        var username: TextView = itemView.username
        var followers: TextView = itemView.followers
        var following: TextView = itemView.following
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(DataFollowing: DataFollowing)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListDataHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_users, viewGroup, false)
        val sch = ListDataHolder(view)
        mcontext = viewGroup.context
        return sch
    }

    override fun getItemCount(): Int {
        return followingFilterList.size
    }

    override fun onBindViewHolder(holder: ListDataHolder, position: Int) {
        val data = followingFilterList[position]
        Glide.with(holder.itemView.context)
            .load(data.avatar)
            .apply(RequestOptions().override(250, 250))
            .into(holder.imageAvatar)
        holder.name.text = data.name
        holder.username.text = data.username
        holder.followers.text = data.followers.toString().trim()
        holder.following.text = data.following.toString().trim()
        holder.itemView.setOnClickListener {
            //DO NOTHING
        }
    }
}