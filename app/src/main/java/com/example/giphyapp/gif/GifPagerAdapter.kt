package com.example.giphyapp.gif

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.GifInfoDomain
import com.example.giphyapp.databinding.ItemPagerGifBinding
import com.example.giphyapp.gifs_list.GifDiffCallBack

class GifPagerAdapter(
    private val saveGifLocalUrl: (gifId: String, bytes: ByteArray) -> Unit,
) : ListAdapter<GifInfoDomain, GifPagerViewHolder>(GifDiffCallBack()) {
    private var clickedItem: GifInfoDomain? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifPagerViewHolder {
        return GifPagerViewHolder(
            ItemPagerGifBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            saveGifLocalUrl
        )
    }

    override fun onBindViewHolder(holder: GifPagerViewHolder, position: Int) {
        holder.onBind(getItem(position)) { this.clickedItem = it }
    }
}