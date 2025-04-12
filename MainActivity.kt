package com.example.mealsuggestor

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import androidx.mealsuggestor.AppComponentActivity

class MainActivity : ComponentActivity() {
    //These are our main UI parts- the text field for time, a label for meal hints, and a button to clear things.
    private lateinit var inputField:EditText
    private lateinit var suggetionLabel:TextView
    private lateinit var clearButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Grab the views from our layout(we're simply finding them by their IDs)
        inputField=findViewById(R.id.time_edit_text)
        suggestionLabel=findViewId(R.id.suggestion_text_view)
        clearButton=findViewID(R.id.reset_button)

        //when the clearButton gets tapped, we wipe any text present in both the input and the suggestion label.
        clearButton.setOnClickListener{
            inputField.text.clear()
            suggestionLabel.text=""
        }

        //Listen for key events on the input field - in most cases, when a key is pressed down,
        // we check the entered text(trimmed, lowercased) and then choose an appropriate meal suggestion.
        inputField.setOnKeyListener {
            _, _, keyEvent>
            if (keyEvent.action == keyEvent.Action_Down) {
                val typedTime = inputField.text.toString().trim().toLowerCase()

                //Basic suggestion logic: match the text to a mealtime and update the suggestion accordingly
                if (typedTime == "morning") {
                    suggetionLabel.text = "Eggs"
                } else if (typedTime == "mid_morning") {
                    suggestionLabel.text = "Fruit"
                } else if (typedTime == "afternoon") {
                    suggestionLabel.text = "Sandwich"
                } else if (typedTime == "mid_afternoon") {
                    suggestionLabel.text = "Cake"
                } else if (typedTime == "dinner") {
                    suggetionLabel.text = "Pasta"
                } else if (typedTime == "after dinner") {
                    suggestionLabel.text = "Ice cream"
                } else {
                    suggestionLabel.text =
                        "Invalid time of day. Please enter: morning, mid_morning, afternoon, mid_afternoon, dinner, or after dinner."
                }
            }
            false
        }
        }
                }







