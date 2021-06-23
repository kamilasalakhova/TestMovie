package com.example.movietestapp.screen.movie.actor.adapter.holders

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import com.example.movietestapp.R
import com.example.movietestapp.databinding.ItemTextBinding
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailDescItems
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailItems

class ActorDetailBioViewHolder(var binding: ItemTextBinding): ActorDetailBaseViewHolder<ActorDetailItems>(binding.root) {
    override fun bind(item: ActorDetailItems) {
        val itemDesc = item as ActorDetailDescItems
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