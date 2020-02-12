package br.com.ioasys.camp.educao.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.ioasys.camp.educao.R
import kotlinx.android.synthetic.main.activity_authentication.*
import kotlinx.android.synthetic.main.fragment_register.*

class AuthenticationActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        //Tudo isso aqui em baixo é para colocar a toolbar em todos os fragments dessa activity

        val navController = findNavController(R.id.auth_nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        setSupportActionBar(authToolbar)
        authToolbar.setupWithNavController(navController, appBarConfiguration)


    }


    fun updateToolbar(title: String? = null, showToolbar: Boolean = true) {
        title?.let {
            authToolbar.title = title
        }

        authToolbar.visibility = if (showToolbar) View.VISIBLE else View.GONE
    }


}
