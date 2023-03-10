package com.example.submission.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.databinding.ItemListVanguardsBinding

class VanguardAdapter(private val listVanguards : List<Vanguard>) : ListAdapter<Vanguard, VanguardAdapter.ListViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(var binding : ItemListVanguardsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemListVanguardsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (_, name, grade, nation, effect, image, _) = listVanguards[position]
        Glide.with(holder.itemView.context)
            .load(image)
            .into(holder.binding.ivItemImage)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemGrade.text = grade.toString()
        holder.binding.tvItemNation.text = nation
        holder.binding.tvItemEffect.text = effect
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listVanguards[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listVanguards.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Vanguard)
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Vanguard> =
            object : DiffUtil.ItemCallback<Vanguard>() {
                override fun areItemsTheSame(oldUser: Vanguard, newUser: Vanguard): Boolean {
                    return oldUser.vanguardId == newUser.vanguardId
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldUser: Vanguard, newUser: Vanguard): Boolean {
                    return oldUser == newUser
                }
            }
    }

}