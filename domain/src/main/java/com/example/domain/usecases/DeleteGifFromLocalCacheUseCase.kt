package com.example.domain.usecases

import com.example.domain.GifInfoRepository

class DeleteGifFromLocalCacheUseCase(
    private val gifInfoRepository: GifInfoRepository
) {

    suspend operator fun invoke(gifId: String, localFilePath: String) =
        gifInfoRepository.deleteGifFromLocalCache(gifId, localFilePath)
}
