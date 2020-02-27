package com.jiahaoliuliu.collapsingtoolbarlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            POSITION_RECYCLER_VIEW_FRAGMENT -> SimpleRecyclerViewFragment()
            else -> SimpleFragment()
        }
    }
}

class SimpleRecyclerViewFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView

    companion object {
        private const val CONTENT_SIZE = 64
        private lateinit var contentList: Array<String>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        recyclerView = view.findViewById(R.id.content_list)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        contentList = Array(CONTENT_SIZE) { i -> "Content ${i+1}"}

        val viewManager = LinearLayoutManager(activity)
        val fragmentAdapter = FragmentAdapter(contentList)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = fragmentAdapter
    }
}

class FragmentAdapter(private val myContent: Array<String>): RecyclerView.Adapter<FragmentAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myContent[position]
    }

    override fun getItemCount() = myContent.size
}