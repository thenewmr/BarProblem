package com.example.barproblem

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.doOnLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text.text = "Text"
        value.text = "Value"

        item_view.doOnLayout {
            Log.i("yoyo", "in onGlobalLayout")

            val width = value.x - (text.x)
            Log.i("yoyo", "Width: $width")

            val params: ConstraintLayout.LayoutParams = percentage_bar.layoutParams as ConstraintLayout.LayoutParams

            params.matchConstraintMaxWidth = (1.0 * width).toInt()  // using 0.1 here - this value is dynamic in real life scenario
            percentage_bar.layoutParams = params
        }
    }
}


