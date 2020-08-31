package com.mcs.applemusicchallenge.interfaces

import com.mcs.applemusicchallenge.pokos.ResultsPOKO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val endpointURL = "search"
interface IGetResultsService {
    @GET(endpointURL)
    fun getMeResults(@Query("term") termParam: String,
                     @Query("media") mediaParam: String,
                     @Query("entity") entityParam: String,
                     @Query("limit") limitParam: Int): Call<ResultsPOKO>
}

//https://itunes.apple.com/
// search?
// term=classick&
// media=music
// entity=song
// limit=50