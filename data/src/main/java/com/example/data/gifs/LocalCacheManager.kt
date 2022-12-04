package com.example.data.gifs

import android.content.Context
import java.io.File

class LocalCacheManager(private val context: Context) {
    suspend fun saveGifLocally(gifId: String, bytes: ByteArray): File {
        var relativePath = "/gifs"
        val cachedGifsDir = File(context.filesDir, relativePath)

        if (!cachedGifsDir.exists()) {
            cachedGifsDir.mkdirs()
        }

        relativePath += "/${gifId}.gif"
        val file = File(context.filesDir, relativePath)

        file.createNewFile()

        file.outputStream()
            .use { fileOutputStream ->
                fileOutputStream.write(bytes, 0, bytes.size)
            }

        return file
    }

    suspend fun deleteGifFromLocalCache(localFilePath: String) {
        File(localFilePath).delete()
    }
}