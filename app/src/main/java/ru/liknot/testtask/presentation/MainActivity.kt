package ru.liknot.testtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import ru.liknot.testtask.R
import ru.liknot.testtask.presentation.screens.main.MainFragment

class MainActivity : AppCompatActivity() {

    @IdRes
    val fragmentsContainerId: Int = R.id.main_fragments_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(
                    fragmentsContainerId,
                    MainFragment.getInstance(),
                    MainFragment.MAIN_FRAGMENT_TAG
                )
                .commit()
        }

    }
}
