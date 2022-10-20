package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }

    private fun makeColored(view: View) {

        when (view.id) {

            // Boxes using Color class colors for the background
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.ic_launcher_foreground2)
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.ic_launcher_foreground)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.ic_launcher_foreground3)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {


        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout
            )
        val redButton = findViewById<Button>(R.id.red_button)
        redButton.setOnClickListener {
            boxThreeText.setBackgroundResource(R.color.my_red)
        }
        val greenButton = findViewById<Button>(R.id.green_button)
        greenButton.setOnClickListener {
            boxFourText.setBackgroundResource(R.color.my_green)
        }
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        yellowButton.setOnClickListener {
            boxFiveText.setBackgroundResource(R.color.my_yellow)
        }
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}