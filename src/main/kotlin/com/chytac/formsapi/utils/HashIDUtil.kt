package com.chytac.formsapi.utils

import org.hashids.Hashids

class HashIDUtil {

    companion object{
        private var HASH_SALT: String = "zKIyLbLcGhy3aE6mjoqM3Ei6tNAz8geLSIJ6sF9J9U7aBMMMq0oKFNOeNG4KJmVw3u3F1jrFqM5wnAnGCHBJIlQOw6IXRsydtDVR7QJBRvOppEQrHcNDmrKer1qUK"

        private val hashId: Hashids = Hashids(HASH_SALT, 16)

        fun getHash(id: Long): String{
            return hashId.encode(id)
        }

        fun getId(hash: String): Long{
            return hashId.decode(hash)[0]
        }
    }
}