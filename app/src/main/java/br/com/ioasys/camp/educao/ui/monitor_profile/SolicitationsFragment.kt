package br.com.ioasys.camp.educao.ui.monitor_profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.ioasys.camp.educao.R
import br.com.ioasys.camp.educao.ui.main.Monitor
import br.com.ioasys.camp.educao.ui.profile.UserTeste
import kotlinx.android.synthetic.main.fragment_solicitations.*

/**
 * A simple [Fragment] subclass.
 */
class SolicitationsFragment : Fragment() {
    lateinit var solicitationsAdapter: SolicitationsAdapter

    private val monitors = ArrayList<UserTeste>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_solicitations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adapter pro recyclerView
        solicitationsAdapter = SolicitationsAdapter(monitors)

        recyclerSolicitation.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = solicitationsAdapter
        }

        //criei uns testes pra ver como ficou o recyclerView
        //Aqui vai ser as informações da pessoa que pediu pra ser ajudada
        val monitor1: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val monitor2: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val monitor3: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val monitor4: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val monitor5: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val monitor6: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        monitors.add(monitor1)
        monitors.add(monitor2)
        monitors.add(monitor3)
        monitors.add(monitor4)
        monitors.add(monitor5)
        monitors.add(monitor6)


    }



}
