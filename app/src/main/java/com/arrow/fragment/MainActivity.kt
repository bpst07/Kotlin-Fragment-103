package com.arrow.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var fragmentOne: FragmentOne = FragmentOne()
    private var fragmentTwo: FragmentTwo = FragmentTwo()

    private val fragmentOneTag = "Fragment One"
    private val fragmentTwoTag = "Fragment One"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add "FragmentOne" to container (Main Activity)
        // provide tag name to handle configuration changes
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, fragmentOne, fragmentOneTag)
                    .commit()
        }

        // replace fragment button on-click listener
        buttonReplaceFragment.setOnClickListener {
            // if current fragment added to container is fragment one then replace it with fragment two
            if (!fragmentTwo.isAdded) {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragmentTwo, fragmentTwoTag)
                        .commit()
            } else {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragmentOne, fragmentOneTag)
                        .commit()
            }
        }
    }
}