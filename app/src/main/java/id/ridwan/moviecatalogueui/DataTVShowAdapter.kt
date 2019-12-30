package id.ridwan.moviecatalogueui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_tvshow.view.*
import kotlinx.android.synthetic.main.item_row_movie.view.*
import kotlinx.android.synthetic.main.item_row_tv.view.*

class DataTVShowAdapter(private val listTVShow : ArrayList<Data>) : RecyclerView.Adapter<DataTVShowAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_tv, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listTVShow.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTVShow[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: Data) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(tvShow.photo)
                    .apply(RequestOptions().override(100, 150))
                    .into(img_phototv)
                txt_nametv.text = tvShow.name
                txt_descriptiontv.text = tvShow.desc
                txt_chacktv.text = tvShow.check

                itemView.setOnClickListener{

                    Toast.makeText(itemView.context, tvShow.name, Toast.LENGTH_SHORT).show()

                    val intent = Intent(itemView.context, Detail::class.java)

                    intent.putExtra(Detail.KEY, tvShow)
                    itemView.context.startActivity(intent)

                }
            }
        }
    }
}
