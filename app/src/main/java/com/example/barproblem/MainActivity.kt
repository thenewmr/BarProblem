package com.example.barproblem

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text.text = "Text"
        value.text = "Value"

        val globalLayoutListener = MainActivityGlobalListener(item_view, text, value, percentage_bar)

        item_view.viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)
    }
}

class MainActivityGlobalListener(private val itemView: View,
                                 private val text: View,
                                 private val value: View,
                                 private val bar: View) : ViewTreeObserver.OnGlobalLayoutListener {

    override fun onGlobalLayout() {
        Log.i("yoyo", "in onGlobalLayout")

        val width = value.x - (text.x)
        Log.i("yoyo", "Width: $width")

        val params: ConstraintLayout.LayoutParams = bar.layoutParams as ConstraintLayout.LayoutParams

        params.matchConstraintMaxWidth = (1.0 * width).toInt()  // using 0.1 here - this value is dynamic in real life scenario
        bar.layoutParams = params

        // required to prevent infinite loop
        itemView.viewTreeObserver.removeOnGlobalLayoutListener(this)
    }
}


