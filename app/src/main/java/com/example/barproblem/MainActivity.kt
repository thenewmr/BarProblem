package com.example.barproblem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val params: ConstraintLayout.LayoutParams = percentage_bar.layoutParams as ConstraintLayout.LayoutParams

        params.matchConstraintPercentWidth = 1.0.toFloat()

        // the following line "works" but feels a bit hacky.  Just basically tries to reduce the overall value
        // I feel like there should be a better way
        //params.matchConstraintPercentWidth = 1.0.toFloat() * 0.8.toFloat()

        percentage_bar.layoutParams = params

        text.text = "Text"
        value.text = "Value"
    }
}
