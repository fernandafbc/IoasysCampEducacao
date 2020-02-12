package br.com.ioasys.camp.educao.ui.authentication.register


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.navigation.findNavController
import br.com.ioasys.camp.educao.R
import br.com.ioasys.camp.educao.ui.authentication.AuthenticationActivity
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_subject_register.*

/**
 * A simple [Fragment] subclass.
 */
class SubjectRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subject_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //seta a toolbar
        (activity as AuthenticationActivity).updateToolbar(title = "")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //cria uma variável para receber uma matéria
        var subject: String

        //cria uma lista de matérias para receber todas as matérias que o monitor escolher;
        //é essa lista que vai ser passada para a API
        val subjects = ArrayList<String>()

        //sempre que o botão de adicionar matéria é pressionado, cria uma nova tag com o nome da matéria
        addSubjectBtn.setOnClickListener {

            //a variável subject recebe o texto do que a pessoa escreveu no editText
            subject = addSubjectEdTxt.text.toString()

            //adiona a matéria à lista
            subjects.add(subject)

            //cria a tag/chip e adiciona ela ao chipGroup
            val chip = Chip(context)
            chip.text = subject
            chip.isCloseIconVisible = true

            chipGroup.addView(chip as View)

            //se clicar no botão de close, o chip é retirado do chipGroup e da lista de matérias
            chip.setOnCloseIconClickListener {
                chipGroup.removeView(chip as View)
                subjects.remove(subject)

            }

            //limpa o editText para poder adicionar outra matéria
            addSubjectEdTxt.text.clear()

        }

        subjectContinueButton.setOnClickListener {

            //se a pessoa não adicionar nenhuma matéria, mostra um Toast pedindo para add pelo menos uma; senão vai para o feed
            if(chipGroup.isEmpty()){
                Toast.makeText(context, "ESCOLHA PELO MENOS UMA MATÉRIA!", Toast.LENGTH_SHORT).show()
            } else {
                it.findNavController().navigate(R.id.action_subjectRegisterFragment_to_mainActivity)
            }
        }

    }

}
