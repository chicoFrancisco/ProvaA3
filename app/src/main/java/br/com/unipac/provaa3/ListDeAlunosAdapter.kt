package br.com.unipac.provaa3

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unipac.provaa3.model.Aluno

class ListDeAlunosAdapter(listaDeAlunos: List<Aluno>, internal val context: Context) :
    RecyclerView.Adapter<ListDeAlunosAdapter.ViewHolder>() {
    internal var listDeProtocolos: List<Aluno> = ArrayList<Aluno>()

    init {
        if (listDeProtocolos != null) {
            this.listDeProtocolos = listDeProtocolos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflateView =
            LayoutInflater.from(context).inflate(R.layout.content_item_aluno, parent, false)
        return ViewHolder(inflateView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var protocolo = listDeProtocolos[position]

        holder.tvName.text = "${protocolo.primeiroNome}"
        if (position % 2 == 0) {
            holder.tvName.setBackgroundColor(Color.GRAY)
        } else {
            holder.tvName.setBackgroundColor(Color.WHITE)
        }

        holder.tvNumeroProtocolo.text = "${protocolo.matricula}"

    }

    override fun getItemCount(): Int {
        return listDeProtocolos.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvNumeroProtocolo: TextView = view.findViewById(R.id.tvMatricula)
    }

}
