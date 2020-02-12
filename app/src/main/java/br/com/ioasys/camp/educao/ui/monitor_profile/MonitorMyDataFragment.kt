package br.com.ioasys.camp.educao.ui.monitor_profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.ioasys.camp.educao.R
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_monitor_my_data.*

/**
 * A simple [Fragment] subclass.
 */
class MonitorMyDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monitor_my_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //criei algumas matérias pra colocar nas tags de teste
        val subjects = ArrayList<String>()
        subjects.add("Geometria Analítica e Álgebra Lienar")
        subjects.add("Cálculo 1")
        subjects.add("Cálculo 2")
        subjects.add("Algoritmos e Estrutura de dados")

        subjects.forEach {
            val chip = Chip(context)
            chip.text = it
            mProfileChipGroup.addView(chip as View)
        }
    }


}
