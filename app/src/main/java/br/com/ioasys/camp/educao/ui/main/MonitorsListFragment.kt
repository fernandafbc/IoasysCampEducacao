package br.com.ioasys.camp.educao.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ioasys.camp.educao.MainActivity

import br.com.ioasys.camp.educao.R
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_monitor_my_data.*
import kotlinx.android.synthetic.main.fragment_monitors_list.*

/**
 * A simple [Fragment] subclass.
 */
class MonitorsListFragment : Fragment() {

    //variável do adapter criado pro reciclerView
    lateinit var monitorAdapter: MonitorAdapter

    private val monitors = ArrayList<Monitor>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monitors_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //esses códigos de baixo não sei explicar, mas eles servem pra fazer o reciclerView funcionar
        monitorAdapter = MonitorAdapter(monitors)

        recyclerMonitor.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = monitorAdapter
        }


        val subjects = ArrayList<String>()
        subjects.add("Geometria Analítica e Álgebra Lienar")
        subjects.add("Cálculo 1")
        subjects.add("Cálculo 2")
        subjects.add("Algoritmos e Estrutura de dados")

        val subjects2 = ArrayList<String>()
        subjects2.add("Cálculo 1")
        subjects2.add("Cálculo 2")



        //criei uns monitores só pra testar como ficou o recyclerView; na real vamos usar a lista de monitores/matérias da API
        val monitor1: Monitor = Monitor("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico", subjects)
        val monitor2: Monitor = Monitor("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico", subjects2)
        val monitor3: Monitor = Monitor("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico", subjects)
        val monitor4: Monitor = Monitor("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico", subjects2)
        val monitor5: Monitor = Monitor("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico", subjects)
        val monitor6: Monitor = Monitor("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico", subjects2)
        monitors.add(monitor1)
        monitors.add(monitor2)
        monitors.add(monitor3)
        monitors.add(monitor4)
        monitors.add(monitor5)
        monitors.add(monitor6)


    }

}
