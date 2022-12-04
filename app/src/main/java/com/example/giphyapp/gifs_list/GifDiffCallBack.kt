package com.example.giphyapp.gifs_list

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.GifInfoDomain

class GifDiffCallBack : DiffUtil.ItemCallback<GifInfoDomain>() {
    override fun areItemsTheSame(oldItem: GifInfoDomain, newItem: GifInfoDomain): Boolean =
        oldItem.gifId == newItem.gifId

    override fun areContentsTheSame(oldItem: GifInfoDomain, newItem: GifInfoDomain): Boolean =
        oldItem == newItem
}