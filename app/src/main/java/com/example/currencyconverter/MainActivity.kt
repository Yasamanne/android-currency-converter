package com.example.currencyconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.usText)
        val displayEU = findViewById<TextView>(R.id.euTextView)
        val displayYuan = findViewById<TextView>(R.id.chinaTextView)
        val displayPound = findViewById<TextView>(R.id.englandTextView)
        val displayCad = findViewById<TextView>(R.id.canadaTextView)
        val displayFranc = findViewById<TextView>(R.id.swissTextView)
        val displaySwissField = findViewById<LinearLayout>(R.id.swissCurrencyLine)
        val addSwitzerlandButton = findViewById<Button>(R.id.addSwitzerlandButton)

        // Set a click listener for the button
        addSwitzerlandButton.setOnClickListener {
            // Add your code here to perform the action when the button is clicked
            // For example, you can display a toast message
            if (displaySwissField.visibility == LinearLayout.VISIBLE) {
                Toast.makeText(this, "Switzerland already added!", Toast.LENGTH_SHORT).show()
            }
            else {
                displaySwissField.visibility = LinearLayout.VISIBLE
            }

        }

        // Add a TextWatcher to monitor changes in the EditText
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called before the text is changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // This method is called as the text is being changed
            }

            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text has been changed
                val userInput = s.toString()
                // You can access and use the user's input (userInput) here
                Log.d("MyApp", "userInput: $userInput")
                val userInputAsInt = userInput.toIntOrNull()
                if (userInputAsInt != null) {
                    val euExchange = userInputAsInt * 0.95
                    val yuanExchange = userInputAsInt * 7.29
                    val cadExchange = userInputAsInt * 1.36
                    val poundExchange = userInputAsInt * 0.82
                    val francExchange = userInputAsInt * 0.92
                    displayEU.text = " $euExchange Euro"
                    displayYuan.text = "$yuanExchange Yuan"
                    displayCad.text = " $cadExchange CAD"
                    displayPound.text = "$poundExchange Pound"
                    displayFranc.text = "$francExchange Franc"
                } else {
                    // Handle the case when userInput cannot be converted to an integer
                    displayEU.text = "Enter USD in first cell"
                }
            }
        })
    }
}
