package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var textViewSecondActivity : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewSecondActivity = text_view_secondActivity

        val firstActivityButtonBool = intent.getBooleanExtra("TAP_BOOL",false)
        val firstActivityTaps = intent.getIntExtra("TAP_KEY",0)
        val firstActivityInputText = intent.getStringExtra("INPUT_TEXT")

        textViewSecondActivity.setText("""Кнопка-индикатор была нажата - ${firstActivityButtonBool}
            |Кнопка была нажата ${firstActivityTaps} раз
            |Текст который вы ввели: ${firstActivityInputText}""".trimMargin())
    }
}
