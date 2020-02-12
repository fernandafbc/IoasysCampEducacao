package br.com.ioasys.camp.educao.ui.authentication.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import br.com.ioasys.camp.educao.R
import br.com.ioasys.camp.educao.ui.authentication.AuthenticationActivity
import kotlinx.android.synthetic.main.fragment_second_register.*

/**
 * A simple [Fragment] subclass.
 */
class SecondRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //seta a toolbar
        (activity as AuthenticationActivity).updateToolbar(title = "")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //passa para a próxima página de registro
        continueButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondRegisterFragment_to_thirdRegisterFragment)
        }
    }


}
