package br.com.ioasys.camp.educao.ui.main

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.camp.educao.R
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.item_monitor.view.*
import kotlin.coroutines.coroutineContext


//Cria o adapter pro recyclerView; nessa List vai ter que mudar o Monitor pra classe real que criar dos monitores
class MonitorAdapter(private val monitors: List<Monitor>) :
        RecyclerView.Adapter<MonitorAdapter.MonitorViewHolder>(){

    //pega o layout do cardView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MonitorViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_monitor, parent, false)
    )

    override fun getItemCount(): Int {
        return monitors.size
    }

    //essa função meio que faz a ligação dos cardView (o layout item_monitor) com o recyclerView (não sei explicar)
    override fun onBindViewHolder(holder: MonitorViewHolder, position: Int) {

        val monitor: Monitor = monitors[position]

        holder.bind(monitor)

    }


    //essa é uma classe auxiliar pra fazer a ligação
    class MonitorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                it.findNavController().navigate(R.id.action_monitorsListFragment_to_otherProfileFragment)
            }
        }

        //aqui liga as informações pegadas da lista de monitores no cardView
        fun bind(monitor: Monitor) {

            itemView.itemNameTxt.text = monitor.name
            itemView.itemAgeTxt.text = monitor.age
            itemView.itemUniversityTxt.text = monitor.university

//            monitor.subjects.forEach {
//                val chip = Chip(itemView.context)
//                chip.text = it
//                itemView.monitorListChipGroup.addView(chip as View)
//            }

            val drawable = itemView.resources.getDrawable(R.drawable.ic_girl)

            itemView.avatarImg.setImageDrawable(drawable)


        }

    }


}