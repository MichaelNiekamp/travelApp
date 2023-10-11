package com.example.travel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.travel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var fragcount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFrag(Fragment1())

        binding.fragBtn1.setOnClickListener {
            fragcount += 5
            when (fragcount%6) {
                0 -> replaceFrag(Fragment1())
                1 -> replaceFrag(Fragment2())
                2 -> replaceFrag(Fragment3())
                3 -> replaceFrag(Fragment4())
                4 -> replaceFrag(Fragment5())
                5 -> replaceFrag(Fragment6())
                else -> { // Note the block
                    replaceFrag(Fragment1())
                }
            }
        }

        binding.fragBtn2.setOnClickListener {
            fragcount += 1
            when (fragcount%6) {
                0 -> replaceFrag(Fragment1())
                1 -> replaceFrag(Fragment2())
                2 -> replaceFrag(Fragment3())
                3 -> replaceFrag(Fragment4())
                4 -> replaceFrag(Fragment5())
                5 -> replaceFrag(Fragment6())
                else -> { // Note the block
                    replaceFrag(Fragment1())
                }
            }
        }
    }

    private fun replaceFrag (fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}