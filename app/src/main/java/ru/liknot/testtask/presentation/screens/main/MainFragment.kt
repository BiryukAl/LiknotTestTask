package ru.liknot.testtask.presentation.screens.main

import androidx.fragment.app.Fragment
import ru.liknot.testtask.R

class MainFragment: Fragment(R.layout.fragment_main) {


    companion object{
        const val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"


        fun getInstance() = MainFragment()
    }
}

