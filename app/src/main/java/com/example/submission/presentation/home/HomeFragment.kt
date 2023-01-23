package com.example.submission.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission.databinding.FragmentHomeBinding
import com.example.submission.presentation.detail.DetailVanguardActivity
import com.example.vanguard.core.domain.model.Vanguard
import com.example.vanguard.core.ui.VanguardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var recycleUser: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycleUser = binding.rvVanguard
        recycleUser.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(requireContext())
        recycleUser.layoutManager = layoutManager

        homeViewModel.data.observe(viewLifecycleOwner) {
            setListData(it)
        }

        homeViewModel.isLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }
    }

    private fun setListData(data : List<Vanguard>?){
        val adapter = data?.let { VanguardAdapter(it) }
        binding.rvVanguard.adapter = adapter
        adapter?.setOnItemClickCallback(object : VanguardAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Vanguard) {
//                Toast.makeText(requireActivity(),"Pencet",Toast.LENGTH_LONG).show()
                val intentToDetail = Intent(activity, DetailVanguardActivity::class.java)
                intentToDetail.putExtra(DetailVanguardActivity.EXTRA_DATA, data)
                startActivity(intentToDetail)
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}