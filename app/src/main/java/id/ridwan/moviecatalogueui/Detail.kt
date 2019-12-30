package id.ridwan.moviecatalogueui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Detail : AppCompatActivity() {

    val checked : Boolean =  true

    companion object {
        const val KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val photod = findViewById<ImageView>(R.id.img_photod)
        val named = findViewById<TextView>(R.id.named)
        val descd = findViewById<TextView>(R.id.descd)

        val data = intent.getParcelableExtra(KEY) as Data

        if(data.check == "Movie" || data.check == "Film") {
            val photop = data.photo
            val namae = data.name
            val descds = data.desc

            Glide.with(this).load(photop).override(410, 500).into(photod)
            named.text = namae
            descd.text = descds
        }

        if(data.check == "TV Show" || data.check == "Acara TV"){
            val photop = data.photo
            val namae = data.name
            val descds = data.desc

            Glide.with(this).load(photop).override(410, 500).into(photod)
            named.text = namae
            descd.text = descds
        }
    }

}
