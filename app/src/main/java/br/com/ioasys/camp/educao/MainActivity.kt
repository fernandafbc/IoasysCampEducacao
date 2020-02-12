package br.com.ioasys.camp.educao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import br.com.ioasys.camp.educao.ui.monitor_profile.MonitorProfileActivity
import br.com.ioasys.camp.educao.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.custom_toolbar.*

class MainActivity : AppCompatActivity() {

//    private var sexSpinner: Spinner? = null
    private var string= "vamos testar esses upload"

//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    //é essa variável item que tem que pegar pra saber qual foi o gênero escolhido
//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        var item: String = parent?.getItemAtPosition(position) as String
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(mainToolbar)


        //cria o spinner lá no registro. Não sei pq não tô conseguindo passar isso pra AuthenticationActivity
//        sexSpinner = findViewById(R.id.sexSpinner)
//        sexSpinner?.onItemSelectedListener = this

    }

    override fun onStart() {
        super.onStart()

        //ao clicar na foto de perfil na toolbar, vai para a página de perfil próprio
        //tem que verificar se o usuário é um monitor ou um usuário normal, pq são activities diferentes
        profilePicture.setOnClickListener {

            //if (!user.isMonitor) -> se não for monitor, usa esse intent
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)

            //fi (user.isMonitor) -> se for monitor, usa esse intent
            val intent = Intent(this, MonitorProfileActivity::class.java)
            startActivity(intent)
        }
    }

}
