package com.example.parstagram

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


// Description: String
// Image: File
// User: User
@ParseClassName("Post")
class Post : ParseObject() {

    fun getDescription(): String? {
        return getString(KEY_DESCRIPTION)
    }

    fun setDescription(description: String) {
        put(KEY_DESCRIPTION, description)
    }

    fun getImage(): ParseFile? {
        return getParseFile(KEY_IMAGE)
    }

    fun setImage(parsefile: ParseFile) {
        put(KEY_IMAGE, parsefile)
    }

    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    fun setUser(user: ParseUser) {
        put(KEY_USER, user)
    }

    fun getDate(): String? {
        val date = getCreatedAt()

        val formatter = SimpleDateFormat("MM-dd-yyyy 'at' hh:mm aaa")
        val dateString = formatter.format(date)
        return dateString.substring(0, dateString.length)
    }

    companion object {
        const val KEY_DESCRIPTION = "description"
        const val KEY_IMAGE = "image"
        const val KEY_USER = "user"
        const val KEY_DATE = "createdAt"
    }
}