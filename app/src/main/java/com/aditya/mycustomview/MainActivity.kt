package com.aditya.mycustomview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aditya.mycustomview.customview.CustomActivity
import com.aditya.mycustomview.customviewlike.CustomLikeActivity
import com.aditya.mycustomview.customviewraw.CustomRawActivity
import com.aditya.mycustomview.onboardingpage.OnBoardingPageActivity
import com.aditya.mycustomview.webview.WebViewActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnCustomView).setOnClickListener {
            CustomActivity.generateIntent(this)
        }

        findViewById<Button>(R.id.btnCustomRawView).setOnClickListener {
            CustomRawActivity.generateIntent(this)
        }

        findViewById<Button>(R.id.btnCustomLikeView).setOnClickListener {
           CustomLikeActivity.generateIntent(this)
        }

        findViewById<Button>(R.id.btnWebView).setOnClickListener {
            WebViewActivity.generateIntent(this)
        }

        findViewById<Button>(R.id.btnOnBoardingPage).setOnClickListener {
            OnBoardingPageActivity.generateIntent(this)
        }
    }

}