package br.com.ioasys.camp.educao.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.camp.educao.R
import kotlinx.android.synthetic.main.item_activities.view.*

//adapter pro recyclerView
class ActivitiesAdapter(private  val users: List<UserTeste>) : RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ActivitiesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_activities, parent, false)
        )

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val user = users[position]

        holder.bind(user)
    }

    class ActivitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(user: UserTeste) {
            itemView.actItemNameTxt.text = user.name
            itemView.actItemAgeTxt.text = user.age
            itemView.actItemUniversityTxt.text = user.university
        }
    }
}