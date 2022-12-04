package com.example.giphyapp.gifs_list

import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.view.View.OnLongClickListener
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.domain.GifInfoDomain
import com.example.giphyapp.R
import com.example.giphyapp.databinding.ItemGifBinding
import java.io.File
import java.nio.ByteBuffer

class GifViewHolder(
    private val binding: ItemGifBinding,
    private val saveGifLocaly: (gifId: String, bytes: ByteArray) -> Unit
) : RecyclerView.ViewHolder(binding.root), View.OnCreateContextMenuListener {

    fun onBind(
        gifInfo: GifInfoDomain,
        onLongClickListener: (gifInfo: GifInfoDomain) -> Unit,
        onCLickItem: () -> Unit
    ) {
        val context = binding.root.context
        val builder = Glide.with(context).asGif()

        if (gifInfo.localUrl == null) {
            builder
                .load(gifInfo.url)
                .listener(object : RequestListener<GifDrawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<GifDrawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: GifDrawable?,
                        model: Any?,
                        target: Target<GifDrawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        val bytes = ByteArray(resource?.buffer?.capacity() ?: 0)
                        (resource?.buffer?.duplicate()?.clear() as ByteBuffer).get(bytes)

                        saveGifLocaly(gifInfo.gifId, bytes)
                        return false
                    }
                })
        } else {
            builder.load(File(gifInfo.localUrl).toUri())
        }.into(binding.gifIv)
        binding.gifIv.setOnCreateContextMenuListener(this)
        binding.gifIv.setOnLongClickListener {
            onLongClickListener(gifInfo)
            return@setOnLongClickListener false
        }
        binding.gifIv.setOnClickListener {
            onCLickItem()
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu.add(Menu.NONE, R.id.remove_item, Menu.NONE, R.string.remove)
    }
}