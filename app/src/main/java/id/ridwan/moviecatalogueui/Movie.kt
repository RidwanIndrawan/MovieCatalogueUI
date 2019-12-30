package id.ridwan.moviecatalogueui


import android.annotation.SuppressLint
import android.content.Intent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.ridwan.moviecatalogueui.Detail.Companion.KEY
import kotlinx.android.synthetic.main.fragment_movie.*



/**
 * A simple [Fragment] subclass.
 */
class Movie : Fragment() {

    private val list = ArrayList<Data>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        movies.setHasFixedSize(true)
        list.addAll(getListMovies())
        showRecyclerList()
    }


    @SuppressLint("Recycle")
    private fun getListMovies(): ArrayList<Data> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_movie_img)
        val dataName = resources.getStringArray(R.array.data_movie_name)
        val dataDescription = resources.getStringArray(R.array.data_movie_desc)
        val checked  = resources.getString(R.string.movie)
        val listMovie = ArrayList<Data>()
        for (position in dataName.indices) {
         val movie = Data(
               dataPhoto.getResourceId(position, -1),
              dataName[position],
               dataDescription[position],
             checked

                )
          listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        movies.layoutManager = LinearLayoutManager(context)
        val dataMovieAdapter = DataMovieAdapter(list)
        movies.adapter = dataMovieAdapter

    }

}

