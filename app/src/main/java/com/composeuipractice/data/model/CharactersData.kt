package com.composeuipractice.data.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class CharactersResponse(
    val actor: String?,
    val alive: Boolean?,
    val dateOfBirth: String?,
    val eyeColour: String?,
    val gender: String?,
    val hogwartsStaff: Boolean?,
    val hogwartsStudent: Boolean?,
    val id: String?,
    val image: String?,
    val name: String?
)

fun loadJsonFromAssets(context: Context, fileName: String): String{
    return context.assets.open(fileName)
        .bufferedReader()
        .use { it.readText() } }

fun getCharacters(context: Context): List<CharactersResponse>{
    val json = loadJsonFromAssets(context, "characters.json")

    val listType = object : TypeToken<List<CharactersResponse>>() {}.type
    val items: List<CharactersResponse> = Gson().fromJson(json, listType)

    return items
}
