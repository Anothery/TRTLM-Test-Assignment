package com.sudzu.trtlmtest.ui.bugdetails

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sudzu.trtlmtest.R
import com.sudzu.trtlmtest.databinding.ActivityBugDetailsBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class BugDetailsActivity : DaggerAppCompatActivity(R.layout.activity_bug_details) {
    companion object {
        const val BUG_ID = "BUG_ID"
    }

    private val binding by viewBinding(ActivityBugDetailsBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: BugDetailsViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.details.observe(this, {
            supportActionBar?.let { ab ->
                ab.title = it.id.toString()
            }

            binding.tvType.text = it.type
            binding.tvStatus.text = it.status
            binding.tvAssignedTo.text = it.assignedTo
            binding.tvIsOpen.text = it.isOpen.toString()
            binding.tvPriority.text = it.priority
            binding.tvUrl.text = it.url
            binding.tvCreator.text = it.creator
            binding.tvCreationTime.text = it.creationTime
            binding.tvClassification.text = it.classification
            binding.tvSummary.text = it.summary
            binding.tvQaContact.text = it.qaContact
        })

        viewModel.onBugIdCatched(intent.extras!!.getInt(BUG_ID))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}