package br.com.unipac.provaa3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unipac.provaa3.infra.AppDatabase
import br.com.unipac.provaa3.model.Aluno

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var linearLayoutManage: LinearLayoutManager
    private lateinit var listDeProtocolosAdapter: ListDeAlunosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listDeProtocolosRv = findViewById<RecyclerView>(R.id.listDeAlunosRv)

        var aluno = Aluno()
        aluno.matricula = 1234
        aluno.email = "fon@dld.com"
        aluno.primeiroNome = "Ze"
        aluno.ultimoNome = "Silva"
        db?.AlunoRepositorio().insert(aluno)

        var listaDeAlunos = db.AlunoRepositorio().getAll()

        listDeProtocolosAdapter =
            ListDeAlunosAdapter(listaDeAlunos, this)
        linearLayoutManage = LinearLayoutManager(this)

        listDeProtocolosRv.layoutManager = linearLayoutManage
        listDeProtocolosRv.adapter = listDeProtocolosAdapter
    }
}