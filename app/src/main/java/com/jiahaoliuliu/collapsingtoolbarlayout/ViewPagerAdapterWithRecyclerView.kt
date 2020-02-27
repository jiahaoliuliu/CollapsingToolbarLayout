package com.jiahaoliuliu.collapsingtoolbarlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapterWithRecyclerView(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    companion object {
        private const val POSITION_SIMPLE_FRAGMENT = 0
        private const val POSITION_RECYCLER_VIEW_FRAGMENT = 1
        private const val ITEM_COUNT = 2
    }

    override fun getItemCount() = ITEM_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            POSITION_SIMPLE_FRAGMENT -> SimpleFragment()
            POSITION_RECYCLER_VIEW_FRAGMENT -> SimpleFragment()
            else -> SimpleFragment()
        }
    }
}