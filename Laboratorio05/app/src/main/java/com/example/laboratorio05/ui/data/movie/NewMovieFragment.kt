package com.example.laboratorio05.ui.data.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovielModel

class NewMovieFragment : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels{ MovieViewModel.Factory }
    private lateinit var addOneMovie: Button
    private lateinit var movieNameEditText: EditText
    private lateinit var movieCategoryEditText: EditText
    private lateinit var movieQualificationEditText: EditText
    private lateinit var movieDescriptionEditText: EditText



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        addListener()
    }

    private fun bind(){
        addOneMovie = view?.findViewById(R.id.submit_action)!!
        movieNameEditText = view?.findViewById(R.id.name_edit_text)!!
        movieCategoryEditText = view?.findViewById(R.id.category_edit_text)!!
        movieDescriptionEditText = view?.findViewById(R.id.description_edit_text)!!
        movieQualificationEditText = view?.findViewById(R.id.qualification_edit_text)!!
    }

    private fun addListener(){
        addOneMovie.setOnClickListener(){
            movieViewModel.addMovie(MovielModel(movieNameEditText.text.toString(),
            movieCategoryEditText.text.toString(),
            movieDescriptionEditText.text.toString(),
            movieQualificationEditText.text.toString()))

            Log.d("Movies", movieViewModel.getMovies().toString())
        }
    }

}