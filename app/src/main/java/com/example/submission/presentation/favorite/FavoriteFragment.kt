package com.example.submission.presentation.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.core.ui.VanguardAdapter
import com.example.submission.databinding.FragmentFavoriteBinding
import com.example.submission.presentation.detail.DetailVanguardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val favoriteViewModel: FavoriteViewModel by activityViewModels()
    private lateinit var recycleUser: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycleUser = binding.rvVanguard
        recycleUser.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(requireContext())
        recycleUser.layoutManager = layoutManager

        favoriteViewModel.favoriteVanguards.observe(viewLifecycleOwner){
            setListData(it)
            binding.viewEmpty.root.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
        }

    }

    private fun setListData(data : List<Vanguard>?){
        val adapter = data?.let { VanguardAdapter(it) }
        binding.rvVanguard.adapter = adapter
        adapter?.setOnItemClickCallback(object : VanguardAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Vanguard) {
                val intentToDetail = Intent(activity, DetailVanguardActivity::class.java)
                intentToDetail.putExtra(DetailVanguardActivity.EXTRA_DATA, data)
                startActivity(intentToDetail)
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}