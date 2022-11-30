package com.example.data.gifs.network

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type


class GifInfoNetworkDeserializer : JsonDeserializer<GifInfoNetwork> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): GifInfoNetwork {
        val type = json.asJsonObject["type"].asString
        val id = json.asJsonObject["id"].asString
        val title = json.asJsonObject["title"].asString
        val rating = json.asJsonObject["rating"].asString
        val mp4 = json.asJsonObject["images"].asJsonObject["original"].asJsonObject["mp4"].asString
        val url = json.asJsonObject["images"].asJsonObject["preview_gif"].asJsonObject["url"].asString

        return GifInfoNetwork(type, id, title, rating, mp4, url)
    }
}