package br.com.ioasys.camp.educao.ui.monitor_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.ioasys.camp.educao.R
import kotlinx.android.synthetic.main.activity_monitor_profile.*

class MonitorProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitor_profile)

        val navController = findNavController(R.id.monitor_profile_nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        setSupportActionBar(monitorProfileToolbar)
        monitorProfileToolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
