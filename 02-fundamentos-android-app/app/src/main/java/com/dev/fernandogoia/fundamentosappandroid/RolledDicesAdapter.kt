package com.dev.fernandogoia.fundamentosappandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.fernandogoia.fundamentosappandroid.databinding.ItemRolledDicesBinding

data class RolledDices(
    val dice1: Int,
    val dice2: Int,
    val dice3: Int,
)

class RolledDicesAdapter(private val rolledDiceList: List<RolledDices>) :
    RecyclerView.Adapter<RolledDicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemRolledDicesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(playNumber = position + 1, rolledDices = rolledDiceList[position])
    }

    override fun getItemCount(): Int {
        return rolledDiceList.size
    }

    class ViewHolder(private val binding: ItemRolledDicesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(playNumber: Int, rolledDices: RolledDices) {
            with(binding) {
                tvRolledDiceNumber.text = playNumber.toString()
                ivRolledDice1.setImageResource(getDiceImageResource(rolledDices.dice1))
                ivRolledDice2.setImageResource(getDiceImageResource(rolledDices.dice2))
                ivRolledDice3.setImageResource(getDiceImageResource(rolledDices.dice3))
            }
        }

    }

}