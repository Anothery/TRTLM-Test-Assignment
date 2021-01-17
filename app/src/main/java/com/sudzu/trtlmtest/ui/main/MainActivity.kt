package com.sudzu.trtlmtest.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sudzu.trtlmtest.R
import com.sudzu.trtlmtest.databinding.ActivityMainBinding
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
        viewModel.bugs.observe(this, { adapter?.setBugs(it) })
    }

    private fun initBugsList() {
        adapter = BugsAdapter(viewModel::onBugItemClicked)
        binding.rvBugs.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvBugs.adapter = adapter
    }
}