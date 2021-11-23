package com.chollan.profiledosenku

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class DosenAdapter(private val listDosen: ArrayList<Dosen>) : RecyclerView.Adapter<DosenAdapter.CardViewHolder>() {
    class CardViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto : CircleImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvNip : TextView = itemView.findViewById(R.id.tv_item_nip)
        var tvKeahlian : TextView = itemView.findViewById(R.id.tv_item_keahlian)
        var btnFavorite : Button = itemView.findViewById(R.id.btn_favorit)
        var btnDetail : Button = itemView.findViewById(R.id.btn_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dosen = listDosen[position]

        Glide.with(holder.itemView.context)
            .load(dosen.photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)

        holder.tvName.text = dosen.name
        holder.tvNip.text = dosen.nip
        holder.tvKeahlian.text = dosen.keahlian
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Click favorit or detail button!!",
                Toast.LENGTH_SHORT).show()
        }
        holder.btnFavorite.setOnClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Dosen Favorite \uD83D\uDC95")
                .setMessage("Kamu memilih ${listDosen[holder.adapterPosition].name} sebagai dosen favorite")
                .setCancelable(true)
                .setPositiveButton("Ya", DialogInterface.OnClickListener { _, _ ->
                    Toast.makeText(holder.itemView.context, "Ciyee kamu suka ${listDosen[holder.adapterPosition].name} \uD83E\uDD23 \uD83E\uDD23",
                        Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Nggk Jadi", DialogInterface.OnClickListener { dialog, _ ->  dialog.cancel()})
                .create()
                .show()
        }
        holder.btnDetail.setOnClickListener {
            val viewDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            viewDetail.putExtra(DetailActivity.EXTRA_NAME, listDosen[holder.adapterPosition].name)
            viewDetail.putExtra(DetailActivity.EXTRA_NIP, listDosen[holder.adapterPosition].nip)
            viewDetail.putExtra(DetailActivity.EXTRA_KEAHLIAN, listDosen[holder.adapterPosition].keahlian)
            viewDetail.putExtra(DetailActivity.EXTRA_PHOTO, listDosen[holder.adapterPosition].photo)
            holder.itemView.context.startActivity(viewDetail)
        }
    }

    override fun getItemCount(): Int {
        return listDosen.size
    }
}