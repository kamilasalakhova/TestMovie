package com.example.movietestapp.screen.movie.detail.adapter.holder

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import com.example.movietestapp.R
import com.example.movietestapp.databinding.ItemTextBinding
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailDescItems
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailItems

class MovieDetailDescriptionViewHolder(var binding: ItemTextBinding): MovieDetailBaseViewHolder<MovieDetailItems>(binding.root) {
    override fun bind(item: MovieDetailItems) {
        val itemDesc = item as MovieDetailDescItems
        val title = binding.root.context.resources.getString(R.string.description)
        val spannableString= SpannableString("$title \n ${itemDesc.text}")
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            0, // start
            title.length, // end
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        binding.data.text = spannableString
    }

}