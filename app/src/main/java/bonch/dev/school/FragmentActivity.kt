package bonch.dev.school

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    var fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragment1 = FirstFragment()
        fm.beginTransaction().add(R.id.first_fragment_container, fragment1).commit()
    }

    fun replaceFragments()
    {
        val fragment2 = SecondFragment()
        fm.beginTransaction().replace(R.id.first_fragment_container, fragment2).addToBackStack("fragment_first").commit()
    }
}
