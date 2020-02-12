package br.com.ioasys.camp.educao.ui.monitor_profile

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.camp.educao.R
import br.com.ioasys.camp.educao.ui.main.Monitor
import br.com.ioasys.camp.educao.ui.profile.UserTeste
import kotlinx.android.synthetic.main.item_monitor.view.*
import kotlinx.android.synthetic.main.item_solicitations.view.*

//adapter pro recyclerView do fragmento de solicitações
class SolicitationsAdapter(private val users: List<UserTeste>) :
    RecyclerView.Adapter<SolicitationsAdapter.SolicitationsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SolicitationsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_solicitations, parent, false)
        )

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: SolicitationsViewHolder, position: Int) {
        val user = users[position]

        holder.bind(user)
    }

    class SolicitationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(user: UserTeste) {
            itemView.solItemNameTxt.text = user.name
            itemView.solItemAgeTxt.text = user.age
            itemView.solItemUniversityTxt.text = user.university
        }
    }
}