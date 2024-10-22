package com.aditya.mycustomview.customview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aditya.mycustomview.MainActivity
import com.aditya.mycustomview.R

class CustomActivity : AppCompatActivity() {

    private lateinit var myButton: MyButton
    private lateinit var myEditText: MyEditText

    companion object {
        fun generateIntent(context: Context) {
            context.startActivity(Intent(context, CustomActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myButton = findViewById(R.id.my_button)
        myEditText = findViewById(R.id.my_edit_text)

        setMyButtonEnable()

        myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
        myButton.setOnClickListener { showMessage(myEditText.text.toString())}
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setMyButtonEnable() {
        myButton.isEnabled = myEditText.text.toString().isNotEmpty()
    }

}