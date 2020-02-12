package br.com.ioasys.camp.educao.ui.monitor_profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.ioasys.camp.educao.R
import br.com.ioasys.camp.educao.ui.profile.MyDataFragment
import br.com.ioasys.camp.educao.ui.profile.ProfileViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_monitor_profile.*

/**
 * A simple [Fragment] subclass.
 */
class MonitorProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monitor_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //chama o viewPager adapter pra criar o swipe com os fragments do Meus Dados e Solicitações
        val adapter = ProfileViewPagerAdapter(childFragmentManager)
        adapter.addFragment(MonitorMyDataFragment(), "MEUS DADOS")
        adapter.addFragment(SolicitationsFragment(), "SOLICITAÇÕES")
        //o adapter do viewPager criado no layout vai ser igual o do criado aqui; seta o tabLayout com essa viewPager
        monitorProfileViewPager.adapter = adapter
        monitorProfileTabLayout.setupWithViewPager(monitorProfileViewPager)

    }


}
