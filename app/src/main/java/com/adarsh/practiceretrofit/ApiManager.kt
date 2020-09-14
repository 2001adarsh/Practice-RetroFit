package com.adarsh.practiceretrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiManager {
    @GET("/users")
    suspend fun getUser(): Response<List<User>>

    @GET("/users/{name}")
    suspend fun getUserByName(@Path("name") name:String): Response<User>

    @GET("/search/users")
    suspend fun searchUser(@Query("q")query: String): Response<SearchClass>
}