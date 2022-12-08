package hr.ferit.petrakis.lv7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductsAdapter(var items: List<Products>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return ProductViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout, parent,
                false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        when(holder) {
            is ProductViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    fun postItemsList(data: ArrayList<Products>) {
        items = data
    }
    class ProductViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView =
            itemView.findViewById(R.id.productImageView)
        private val productName: TextView =
            itemView.findViewById(R.id.ProductNameTextView)
        private val productPrice: TextView =
            itemView.findViewById(R.id.ProductPriceTextView)
        private val productRating: TextView =
            itemView.findViewById(R.id.RatingTextView3)
        private val productDesecription: TextView =
            itemView.findViewById(R.id.descriptionTextView)
        fun bind(product: Products) {
            Glide
                .with(itemView.context)
                .load(product.product_link)
                .into(productImage) //ucitava s url slike tu sliku
            productName.text =product.name
            productPrice.text = product.price
            productRating.text = product.rating.toString()
            productDesecription.text=product.description
        }
    }
}
