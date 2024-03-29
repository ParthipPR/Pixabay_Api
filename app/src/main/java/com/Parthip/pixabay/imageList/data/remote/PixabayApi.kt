package com.Parthip.pixabay.imageList.data.remote

import com.Parthip.pixabay.imageList.data.remote.respond.ImageListDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("api/")
    suspend fun getImageList(
        @Query("key") key: String = API_KEY
    ): ImageListDTO

    companion object{
        const val BASE_URL = "https://pixabay.com/"
        const val API_KEY = "43089777-9cab70f444be315c4e8e4ead6"
    }
}