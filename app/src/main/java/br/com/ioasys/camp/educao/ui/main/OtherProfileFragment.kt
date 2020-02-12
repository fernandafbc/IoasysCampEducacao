package br.com.ioasys.camp.educao.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import br.com.ioasys.camp.educao.R
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_other_profile.*

/**
 * A simple [Fragment] subclass.
 */
class OtherProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //criei algumas matérias teste pra colocar nas tags
        //mas vamos precisar da lista de matérias do monitor que a pessoa clicou pra ver o perfil
        val subjects = ArrayList<String>()
        subjects.add("Geometria Analítica e Álgebra Lienar")
        subjects.add("Cálculo 1")
        subjects.add("Cálculo 2")
        subjects.add("Algoritmos e Estrutura de dados")

        subjects.forEach {
            val chip = Chip(context)
            chip.text = it
            otherProfileChipGroup.addView(chip as View)
        }

        //chama o bottomSheet (que não tá funcionando ;-;)
        askHelpBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_otherProfileFragment_to_bottomSheet)
        }

    }


}
