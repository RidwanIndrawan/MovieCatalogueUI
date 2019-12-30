package id.ridwan.moviecatalogueui


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tvshow.*

/**
 * A simple [Fragment] subclass.
 */
class TVShow : Fragment() {

    private val listtv = ArrayList<Data>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvshows.setHasFixedSize(true)
        listtv.addAll(getListTVShows())
        showRecyclerList()

    }

    @SuppressLint("Recycle")
    private fun getListTVShows(): ArrayList<Data> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_tvshow_img)
        val dataName = resources.getStringArray(R.array.data_tvshow_name)
        val dataDescription = resources.getStringArray(R.array.data_tvshow_desc)
        val checked = resources.getString(R.string.tvshow)
        val listTVShow = ArrayList<Data>()
        for (position in dataName.indices) {
            val tvShow = Data(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position],checked
            )
            listTVShow.add(tvShow)
        }
        return listTVShow
    }

    private fun showRecyclerList() {
        tvshows.layoutManager = LinearLayoutManager(context)
        val dataTVShowAdapter = DataTVShowAdapter(listtv)
        tvshows.adapter = dataTVShowAdapter

    }

}

