package tech.dsckiet.search.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import tech.dsckiet.search.MainViewModel
import tech.dsckiet.search.R
import tech.dsckiet.search.databinding.FragmentScoresBinding

/**
 * A simple [Fragment] subclass.
 */
class Scores : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scores, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        DataBindingUtil.setContentView<FragmentScoresBinding>(
            requireActivity(),
            R.layout.fragment_scores
        ).apply {
            this.lifecycleOwner = this@Scores
            this.viewmodel = mainViewModel
        }

    }
}
