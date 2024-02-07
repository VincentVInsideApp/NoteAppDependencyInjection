package com.vvsoftdev.noteapp

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vvsoftdev.noteapp.ui.MyFlutterFragment

class FlutterHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getStringExtra(EXTRA_DATA)

        val fragment = MyFlutterFragment.instance(data!!)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content, fragment)
            .commit()
    }

    companion object {
        private const val EXTRA_DATA = "EXTRA_DATA"

        fun newIntent(context: Context?, data: String?): Intent {
            val intent = Intent(context, FlutterHostActivity::class.java)
            intent.putExtra(EXTRA_DATA, data)
            return intent
        }
    }
}