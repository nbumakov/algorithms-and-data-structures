package com.leatcode.t535

class Codec() {

    private val encodeMap = mutableMapOf<String, String>()
    private val decodeMap = mutableMapOf<String, String>()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String = encodeMap.getOrPut(longUrl) {
        val tinyUrl = BASE_URL + encodeMap.size
        decodeMap[tinyUrl] = longUrl
        tinyUrl
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String = decodeMap[shortUrl]!!

    companion object{
        private const val BASE_URL = "http://tinyurl.com/"
    }
}