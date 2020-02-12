package br.com.ioasys.camp.educao.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ioasys.camp.educao.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.bottom_sheet_help.*
import kotlinx.android.synthetic.main.fragment_subject_register.*

//Era pra ser o bottomSheet de quando a pessoa vai pedir ajuda
class BottomSheet() : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //criei uma lista de matérias pra colocar nas tags só pra testar
        //essa lista de matérias vai ter que ser as matérias que o monitor ensina
        val subjects = ArrayList<String>()
        subjects.add("Geometria Analítica e Álgebra Lienar")
        subjects.add("Cálculo 1")
        subjects.add("Cálculo 2")
        subjects.add("Algoritmos e Estrutura de dados")

        subjects.forEach {
            val chip = Chip(context)
            chip.text = it
            bottomSheetChipGroup.addView(chip as View)
        }

    }
}