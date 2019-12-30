package id.ridwan.moviecatalogueui


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_movie.view.*

class DataMovieAdapter(private val listMovie : ArrayList<Data>) : RecyclerView.Adapter<DataMovieAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_movie, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int =listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val list = ArrayList<Data>()


       fun bind(movie: Data) {
           with(itemView) {
               Glide.with(itemView.context)
                   .load(movie.photo)
                   .apply(RequestOptions().override(100, 150))
                   .into(img_photo)
               txt_name.text = movie.name
               txt_description.text = movie.desc
               txt_chack.text = movie.check

               itemView.setOnClickListener{

                   Toast.makeText(itemView.context, movie.name, Toast.LENGTH_SHORT).show()

                   val intent = Intent(itemView.context, Detail::class.java)

                   intent.putExtra(Detail.KEY, movie)
                   itemView.context.startActivity(intent)

               }
           }
       }
   }

}
