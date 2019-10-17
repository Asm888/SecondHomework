package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton : Button
    private lateinit var counterButton : Button
    private lateinit var textField : EditText
    private lateinit var nextActivityButton : Button
    private lateinit var counter : Counter
    var indicatorBool : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        InitializeViews()

        counter = if (savedInstanceState == null) {
            Counter()
        }
        else {
            Counter(savedInstanceState.getInt("TAP_AMOUNT"))
        }

        SetListeners()

    }

    private fun InitializeViews()
    {
        indicatorButton = indicator_button
        counterButton = counter_button
        textField = text_field
        nextActivityButton = next_activity_button
    }

    private fun SetListeners()
    {
        counterButton.setOnClickListener {
        counter.increment()
            counterButton.text = "Taps: ${counter.currentCount}"
        }

        indicatorButton.setOnClickListener {
            indicatorBool = true
            indicatorButton.setEnabled(false)
        }

        nextActivityButton.setOnClickListener {
            val intent = Intent(FirstActivity@this, SecondActivity::class.java)
            intent.putExtra("TAP_KEY", counter.currentCount)
            intent.putExtra("TAP_BOOL", indicatorBool)
            intent.putExtra("INPUT_TEXT", textField.getText().toString())
            startActivity(intent)
        }
    }
}
