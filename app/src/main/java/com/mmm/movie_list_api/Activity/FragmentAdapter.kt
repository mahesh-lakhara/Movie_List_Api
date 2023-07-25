package com.mmm.movie_list_api.Activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

open class FragmentAdapter(fm: FragmentManager, fragment: Array<Fragment>, item: Array<String>) :
    FragmentPagerAdapter(fm) {

    var fragments = fragment
    var item = item

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return item.get(position)
    }

}