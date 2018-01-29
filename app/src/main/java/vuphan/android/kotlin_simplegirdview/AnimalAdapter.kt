package vuphan.android.kotlin_simplegirdview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_animal.view.*


/**
 * Created by User on 1/29/2018.
 */
class AnimalAdapter// data is passed into the constructor
internal constructor(context: Context, data: ArrayList<AnimalEntity>) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {


    private var context : Context? = null
    private var mData = ArrayList<AnimalEntity>()
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: ItemClickListener? = null

    init {
        this.mData = data
        this.context = context
    }

    // inflates the cell layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_animal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null) {
            Picasso.with(context)
                    .load(getItem(position)!!.url)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(holder.imageView)
            holder.textView!!.text = getItem(position)!!.name
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imageView: ImageView? = null
        var textView: TextView? = null

        init {
            imageView = itemView.imageView
            textView = itemView.textView
            itemView.imageView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }
    }

    // convenience method for getting data at click position
    internal fun getItem(id: Int): AnimalEntity? {
        return mData[id]
    }

    // allows clicks events to be caught
    internal fun setClickListener(itemClickListener: ItemClickListener) {
        this.mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}