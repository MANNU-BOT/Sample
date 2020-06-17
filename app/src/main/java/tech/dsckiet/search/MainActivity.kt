package tech.dsckiet.search

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.dsckiet.search.Model.Client
import tech.dsckiet.search.Model.Questions
import tech.dsckiet.search.Model.QuizResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val callAPI=Client.service.getQuestions(10)


        callAPI.enqueue(object :Callback<QuizResponse>{
            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<QuizResponse>, t: Throwable) {
                txt.text = "Failure : ${t.message}"
            }

            override fun onResponse(call: Call<QuizResponse>, response: Response<QuizResponse>) {
                val string: StringBuilder = StringBuilder()
                val reply = response.body()!!.results


                for (i in reply){
                    string.append(i.question.toString()+"/n")
                }

                string.append("hi")
                txt.text=string
            }

        })
    }
}
