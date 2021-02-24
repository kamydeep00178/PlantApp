package com.core.plantxapp.utill


import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("capitalFirstLetter")
fun setFirstWordCapital(textView: TextView, name: String) {
    textView.text = name.capitalizeWords
}

val String.capitalizeWords
    get() = this.toLowerCase().split(" ").joinToString(" ") {
          it.capitalize()
    }

