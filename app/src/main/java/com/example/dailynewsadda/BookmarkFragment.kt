package com.example.dailynewsadda

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.RequiresFeature
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment


class BookmarkFragment : Fragment() {

    //private lateinit var drawerLayout: DrawerLayout
    //private lateinit var getSupportActionBar: ActionBar
    //private lateinit var requestWindowFeature: RequiresFeature

    companion object {
        val TAG = BookmarkFragment.javaClass.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bookmark, container, false)
        //getSupportActionBar.hide()
        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END)
        return view
    }
}