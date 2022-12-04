package com.example.giphyapp.gifs_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.GifInfoDomain
import com.example.giphyapp.databinding.ItemListGifBinding

class GifsAdapter : ListAdapter<GifInfoDomain, GifsAdapter.GifViewHolder>(GifDiffCallBack()) {

    class GifViewHolder(
        private val binding: ItemListGifBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(user: GifInfoDomain) {
            Glide.with(binding.root.context)
                .load(user.url)
                .into(binding.gifIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder(ItemListGifBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

