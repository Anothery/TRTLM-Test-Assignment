package com.sudzu.trtlmtest.ui.main

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.forEach
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sudzu.trtlmtest.R
import com.sudzu.trtlmtest.databinding.ActivityMainBinding
import com.sudzu.trtlmtest.ui.bugdetails.BugDetailsActivity
import com.sudzu.trtlmtest.utils.BugsSortType
import com.sudzu.trtlmtest.utils.checkdataservice.CheckDataService
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding(ActivityMainBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private var adapter: BugsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initBugsList()

        binding.rvBugs.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE

        viewModel.bugs.observe(this, {
            binding.rvBugs.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE

            adapter?.setBugs(it)
            binding.rvBugs.smoothScrollToPosition(0)
        })
        viewModel.openBugDetails.observe(this, {
            val intent = Intent(this, BugDetailsActivity::class.java)
            intent.putExtra(BugDetailsActivity.BUG_ID, it)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        })
        viewModel.showSortDialog.observe(this, { showSortDialog(it) })

        viewModel.startCheckDataService.observe(this, {
            Intent(this, CheckDataService::class.java).also { startService(it) }
        })

        viewModel.stopCheckDataService.observe(this, {
            Intent(this, CheckDataService::class.java).also { stopService(it) }
        })
    }

    private fun initBugsList() {
        adapter = BugsAdapter(viewModel::onBugItemClicked)
        binding.rvBugs.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvBugs.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        menu?.forEach { menuItem ->
            menuItem.icon?.let {
                it.mutate()
                it.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
            }
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.abtnSort -> {
                viewModel.onSortButtonClicked()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showSortDialog(selectedItem: Int) {
        val items = BugsSortType.values().map { it.name }.toTypedArray()
        val builder = AlertDialog.Builder(this)
        builder.setTitle(resources.getString(R.string.sort_dialog_title))
        builder.setSingleChoiceItems(items, selectedItem) { _, position ->
            viewModel.onSortTypeChanged(position)
        }

        val dialog = builder.create()
        dialog.show()
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }
}