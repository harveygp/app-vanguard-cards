package com.example.submission.presentation.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.submission.MainActivity
import com.example.submission.R
import com.example.submission.databinding.ActivityDetailVanguardBinding
import com.example.vanguard.core.domain.model.Vanguard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailVanguardActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailVanguardBinding

    private val detailVanguardViewModel: DetailVanguardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVanguardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailVanguard = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DATA, Vanguard::class.java)
        } else {
            intent.getParcelableExtra<Vanguard>(EXTRA_DATA)
        }
        showDetailVanguard(detailVanguard)

        onBackPressedDispatcher.addCallback(this /* lifecycle owner */, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intentToHome = Intent(this@DetailVanguardActivity, MainActivity::class.java)
                intentToHome.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intentToHome)
                finish()
            }
        })
    }

    private fun showDetailVanguard(detailVanguard: Vanguard?) {
        detailVanguard?.let {
            supportActionBar?.title = detailVanguard.name
            binding.content.tvItemName.text = detailVanguard.name
            binding.content.tvItemEffect.text = detailVanguard.effect
            binding.content.tvItemNation.text = detailVanguard.nation
            binding.content.tvItemGrade.text = detailVanguard.grade.toString()
            Glide.with(this@DetailVanguardActivity)
                .load(detailVanguard.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailVanguard.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                lifecycleScope.launch(Dispatchers.Main) {
                    detailVanguardViewModel.setFavoriteVanguard(detailVanguard, statusFavorite)
                }
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
