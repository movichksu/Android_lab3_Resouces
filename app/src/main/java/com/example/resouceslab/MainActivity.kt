package com.example.resouceslab

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var orientationTextView: TextView
    private var orientation = Configuration().orientation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        orientationTextView = findViewById(R.id.orientationTextView)
        defineScreenOrientation()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        orientation = newConfig.orientation
        defineScreenOrientation()
    }

    private fun defineScreenOrientation() {
        val stringResource = when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> R.string.landscape_orientation
            Configuration.ORIENTATION_PORTRAIT -> R.string.portrait_orientation
            else -> R.string.unknown_orientation
        }
        orientationTextView.text = getString(stringResource)
    }
}