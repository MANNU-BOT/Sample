package tech.dsckiet.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    var i = 0
    val test = Repository.Fetch(i)

    var currentQuestion: LiveData<String> = Repository.ques
    var option1: LiveData<String> = Repository.option1
    var option2: LiveData<String> = Repository.option2
    var option3: LiveData<String> = Repository.option3
    var option4: LiveData<String> = Repository.option4
    var ans: LiveData<String> = Repository.ans

    fun checkOption() {


    }

    fun skip() {
        if (i == 9) {

        } else {
            i++
        }

    }
}