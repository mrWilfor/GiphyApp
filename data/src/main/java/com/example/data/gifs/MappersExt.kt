package com.example.data.gifs

import com.example.data.gifs.db.GifInfoDb
import com.example.data.gifs.network.GifInfoNetwork
import com.example.domain.GifInfoDomain

fun GifInfoNetwork.toDb(): GifInfoDb = GifInfoDb(
    type = type,
    gifId = id,
    title = title,
    rating = rating,
    url = url,
    previewUrl = previewUrl
)

fun GifInfoDb.toDomain(): GifInfoDomain = GifInfoDomain(gifId, title, url, previewUrl)