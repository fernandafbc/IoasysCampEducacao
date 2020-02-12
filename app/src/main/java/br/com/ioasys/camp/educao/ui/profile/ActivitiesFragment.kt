package br.com.ioasys.camp.educao.ui.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.ioasys.camp.educao.R
import kotlinx.android.synthetic.main.fragment_activities.*

/**
 * A simple [Fragment] subclass.
 */
class ActivitiesFragment : Fragment() {

    lateinit var activitiesAdapter: ActivitiesAdapter
    private val users = ArrayList<UserTeste>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adapter pro recyclerView
        activitiesAdapter = ActivitiesAdapter(users)

        recyclerActivities.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = activitiesAdapter
        }

        //teste pra ver como tá o recyclerView
        //aqui vai ser as informações do monitor que aceitou a solicitação de ajuda
        val user1: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val user2: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val user3: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val user4: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val user5: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        val user6: UserTeste = UserTeste("Fernanda Braga", "23 anos", "PUC Minas - Coração Eucarístico")
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)
        users.add(user6)
    }


}
