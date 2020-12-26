package com.android.marvelapi.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ComicListItemBinding
import com.android.marvelapi.model.MarvelComic
import com.bumptech.glide.Glide

class ComicListAdapter(val listOfComics: List<MarvelComic>): RecyclerView.Adapter<ComicListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ComicListItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfComics[position])
    }

    override fun getItemCount(): Int = listOfComics.size

    inner class ViewHolder(val view: ComicListItemBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(comic: MarvelComic) = with(view) {
            Glide.with(view.root.context).load(comic.thumbnail.path).placeholder(R.drawable.marvel_logo).into(imComicCover)
            tvEdition.text = "#${comic.issueNumber}"
        }
    }
}