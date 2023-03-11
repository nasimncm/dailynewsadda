package com.example.dailynewsadda

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


fun FragmentManager.addFragmentWithFadeIn(containerViewId: Int, fragment: Fragment, tag: String?) {
    this.beginTransaction()
        .addToBackStack(tag)
        .add(containerViewId, fragment, tag)
        .commitAllowingStateLoss()
}