package com.jiahaoliuliu.collapsingtoolbarlayout

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class NormalScrollingActivity : AppCompatActivity() {
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setupToolbar()
        setupFloatingActionButton()
        setupAppBar()
        setupViewPager()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    private fun setupFloatingActionButton() {
        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setupAppBar() {
        val appBarLayout = findViewById<View>(R.id.app_bar) as AppBarLayout
        appBarLayout.addOnOffsetChangedListener(object : OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1
            override fun onOffsetChanged(
                appBarLayout: AppBarLayout,
                verticalOffset: Int
            ) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true
                    showOption(R.id.action_info)
                } else if (isShow) {
                    isShow = false
                    hideOption(R.id.action_info)
                }
            }
        })
    }

    private fun setupViewPager() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean { // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        hideOption(R.id.action_info)
        return true
    }

    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        } else if (id == R.id.action_info) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hideOption(id: Int) {
        val item = menu!!.findItem(id)
        item.isVisible = false
    }

    private fun showOption(id: Int) {
        val item = menu!!.findItem(id)
        item.isVisible = true
    }
}