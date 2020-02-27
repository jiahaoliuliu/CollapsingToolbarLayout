package com.jiahaoliuliu.collapsingtoolbarlayout

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    companion object {
        private val optionsListOptions = listOf(
            "Normal",
            "With ViewPager",
            "With ViewPager and Tab",
            "With ViwPager, Tab and RecyclerView"
        )
        private const val POSITION_NORMAL = 0
        private const val POSITION_WITH_VIEW_PAGER = 1
        private const val POSITION_WITH_VIEW_PAGER_AND_TAB = 2
        private const val POSITION_WITH_VIEW_PAGER_TAB_AND_RECYCLER_VIEW = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, optionsListOptions)
        val listView = findViewById<ListView>(R.id.options_list)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _ , position, _ ->
            when(position) {
                POSITION_NORMAL -> startActivity(Intent(this, NormalScrollingActivity::class.java))
                POSITION_WITH_VIEW_PAGER -> startActivity(Intent(this, NormalScrollingViewPagerActivity::class.java))
                POSITION_WITH_VIEW_PAGER_AND_TAB, POSITION_WITH_VIEW_PAGER_TAB_AND_RECYCLER_VIEW
                    -> startActivity(Intent(this, NormalScrollingActivity::class.java))
            }
        }
    }
}