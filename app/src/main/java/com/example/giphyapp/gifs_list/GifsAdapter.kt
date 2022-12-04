package com.example.giphyapp.gifs_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.GifInfoDomain
import com.example.giphyapp.databinding.ItemGifBinding


class GifsAdapter(
    private val saveGifLocalUrl: (gifId: String, bytes: ByteArray) -> Unit,
    private val onCLickItem: () -> Unit
) : ListAdapter<GifInfoDomain, GifViewHolder>(GifDiffCallBack()) {
    private var clickedItem: GifInfoDomain? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder(
            ItemGifBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            saveGifLocalUrl
        )
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.onBind(
            getItem(position),
            { this.clickedItem = it },
            onCLickItem
        )
    }

    fun getClickedItem(): GifInfoDomain? {
        return clickedItem
    }
}

