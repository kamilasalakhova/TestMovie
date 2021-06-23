package com.example.movietestapp.data.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.widget.TextView
import com.example.movietestapp.R




fun alertDialog(context: Context, message: String, positiveButtonText: String, buttonAction: (()->(Unit))? = null) {
    val builder1 = AlertDialog.Builder(context, R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
    builder1.setMessage(message)
    builder1.setCancelable(true)
    builder1.setPositiveButton(
            positiveButtonText
    ) { dialog, _ ->
        buttonAction?.invoke()
        dialog.cancel()
    }

    val alert = builder1.create()
    alert?.show()

    alert?.getButton(AlertDialog.BUTTON_POSITIVE)?.setBackgroundColor(Color.TRANSPARENT)
    alert?.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(Color.BLACK)
    alert?.getButton(AlertDialog.BUTTON_POSITIVE)?.textSize = 20f
    alert?.getButton(AlertDialog.BUTTON_POSITIVE)?.isAllCaps = false

    val tv = alert.findViewById<TextView>(android.R.id.message)
    tv?.setTextColor(Color.BLACK)
    tv?.textSize = 22f
}
