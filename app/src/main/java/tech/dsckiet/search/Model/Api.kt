package tech.dsckiet.search.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://opentdb.com/"

interface Api {

    @GET("api.php")
    fun getQuestions(@Query("amount=") amount: Int)
            : Call<QuizResponse>

}