package tech.dsckiet.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.dsckiet.search.Network.Client
import tech.dsckiet.search.Network.QuizResponse

object Repository {

    var s = ""


    fun Fetch(i: Int) {

        var option: List<String>
        val callAPI = Client.service.getQuestions(10)

        callAPI.enqueue(object : Callback<QuizResponse> {
            override fun onFailure(call: Call<QuizResponse>, t: Throwable) {
                s = "Failure : ${t.message}"
            }

            override fun onResponse(call: Call<QuizResponse>, response: Response<QuizResponse>) {

                val reply = response.body()!!.results
                val quiz = reply.elementAt(i)
                _ques.value = quiz.question
                _ans.value = quiz.correct_answer
                option = listOf(
                    quiz.correct_answer,
                    quiz.incorrect_answers.elementAt(0),
                    quiz.incorrect_answers.elementAt(1),
                    quiz.incorrect_answers.elementAt(2)
                )
                option.shuffled()
                _option1.value = option.first()
                _option2.value = option.elementAt(1)
                _option3.value = option.elementAt(2)
                _option4.value = option.last()

            }

        })
    }

    private val _ques = MutableLiveData<String>()
    private val _ans = MutableLiveData<String>()
    private val _option1 = MutableLiveData<String>()
    private val _option2 = MutableLiveData<String>()
    private val _option3 = MutableLiveData<String>()
    private val _option4 = MutableLiveData<String>()

    val ques: LiveData<String> = _ques
    val ans: LiveData<String> = _ans
    val option1: LiveData<String> = _option1
    val option2: LiveData<String> = _option2
    val option3: LiveData<String> = _option3
    val option4: LiveData<String> = _option4


}