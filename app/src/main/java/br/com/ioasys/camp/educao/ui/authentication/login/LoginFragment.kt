package br.com.ioasys.camp.educao.ui.authentication.login

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import br.com.ioasys.camp.educao.MainActivity
import br.com.ioasys.camp.educao.ui.profile.ProfileActivity

import br.com.ioasys.camp.educao.R
import br.com.ioasys.camp.educao.service.models.request.LoginRequest
import br.com.ioasys.camp.educao.service.models.response.LoginResponse
import br.com.ioasys.camp.educao.service.repository.LoginRepository.server_Response
import br.com.ioasys.camp.educao.ui.authentication.AuthenticationActivity
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginRequest: LoginRequest

    internal val loginFragmentContext = this.context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.login_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //deixa esse fragment sem toolbar, já que é a primeira página e não tem como voltar
        (activity as AuthenticationActivity).updateToolbar(showToolbar = false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        registrateTxt.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        loginButton.setOnClickListener {
            val emailLogin = emailEdTxt.text
            val passwordLogin = passwordEdTxt.text

            val validInput = isValidInput(emailLogin, passwordLogin)
            if (validInput) {
                it.findNavController()
                    .navigate(R.id.action_loginFragment_to_mainActivity)
                activity?.finish()

                loginRequest = LoginRequest(emailLogin.toString(), passwordLogin.toString())
                observeLoginViewModel(loginViewModel)

                //tentativa de animation/transição de tela
//                val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.sample_anim)
//                it.startAnimation(animation)

            }
        }
    }

    private fun isValidInput(emailLogin: Editable?, passwordLogin: Editable?): Boolean {
        var isValid = true

        val email = emailLogin?: ""
        val password = passwordLogin?: ""

        val emailVerify: String = email.toString()

        if (email.isEmpty()) {
            isValid = false
            emailInputLayout.error = getString(R.string.main_fragment_empty_error)
        }
        else if(isEmailNotValid(emailVerify)){
            isValid = false
            emailInputLayout.error = getString(R.string.main_fragment_format_error)
        }
        else {
            emailInputLayout.error = null
        }

        if (password.isEmpty()) {
            isValid = false
            passwordInputLayout.error = getString(R.string.main_fragment_empty_error)
        } else {
            passwordInputLayout.error = null
        }

        return isValid
    }

    private fun isEmailNotValid(email: String): Boolean {
        return !PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun observeLoginViewModel(loginViewModel: LoginViewModel){
        var success: Boolean
        loginViewModel.requestLogin(loginRequest)
        loginViewModel.loginObservable.observe(viewLifecycleOwner, Observer<LoginResponse>{
            it.let {
                success = true
            }

        })
//        return success
    }

//    private fun showErrorMessage(){
//        loginViewModel.
//    }

}
//            when("$t") {
//            "Invalid password"  -> server_Response = "Senha incorreta"
//            "User not Found" -> server_Response = "Usuário não encontrado"
//            "The user could not be authenticated" -> server_Response
//        }