package com.example.vanguard.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission.presentation.detail.DetailVanguardActivity
import com.example.vanguard.core.domain.model.Vanguard
import com.example.vanguard.core.ui.VanguardAdapter
import com.example.vanguard.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel by viewModels<FavoriteViewModel>()
    private lateinit var recycleUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getBundleExtra("DATA")
        val arr = data?.getParcelableArray("DATA") ?: emptyArray()

        init(arr.toList() as List<Vanguard>)
    }

    private fun init(data : List<Vanguard>?){
        recycleUser = binding.rvVanguard
        recycleUser.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recycleUser.layoutManager = layoutManager

        setListData(data)
    }

    private fun setListData(data : List<Vanguard>?){
        val adapter = data?.let { VanguardAdapter(it) }
        binding.rvVanguard.adapter = adapter
        adapter?.setOnItemClickCallback(object : VanguardAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Vanguard) {
                val intentToDetail = Intent(this@FavoriteActivity, DetailVanguardActivity::class.java)
                intentToDetail.putExtra(DetailVanguardActivity.EXTRA_DATA, data)
                startActivity(intentToDetail)
            }
        })
    }
}