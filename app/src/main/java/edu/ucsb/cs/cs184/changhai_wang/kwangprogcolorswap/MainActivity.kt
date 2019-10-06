package edu.ucsb.cs.cs184.changhai_wang.kwangprogcolorswap


import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color

import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //declare params for the layouts items
    var params: LinearLayout.LayoutParams? = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )

    //declare params for the layout
    var layout_params: ActionBar.LayoutParams? = ActionBar.LayoutParams(
        ActionBar.LayoutParams.MATCH_PARENT,
        ActionBar.LayoutParams.MATCH_PARENT
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declare UI elements
        var linearLayout = LinearLayout(this)
        var textView = TextView(this)
        var button = Button(this)

        //Set UI elements using synthetic properties
        textView.text = "Tap to Change Color"
        textView.textSize = 30.0f
        textView.layoutParams = params
        button.layoutParams = params
        button.text = "TAP ME!"
        linearLayout.layoutParams = layout_params
        linearLayout.setOrientation(LinearLayout.VERTICAL)
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL)

        //set onClick listener
        button.setOnClickListener {
            val red: Int = Random.nextInt(256)
            val green: Int = Random.nextInt(256)
            val blue: Int = Random.nextInt(256)
            val myColor: Int = Color.argb(255, red, green, blue)
            //val myColor: Int = Color.RED
            //val myColor: Int = Color.argb(255, 0, 255, 0)
            textView.text = "COLOR: ${red}r ${green}g ${blue}b"
            textView.setTextColor(myColor)
        }

        //add UI elements to layout
        linearLayout.addView(textView)
        linearLayout.addView(button)

        //add layout into the content view
        this.setContentView(linearLayout, layout_params)
    }
}
