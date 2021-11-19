package br.com.unipac.provaa3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aluno")
class Aluno(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "primeiro_nome")
    var primeiroNome: String = "",
    @ColumnInfo(name = "ultimo_nome")
    var ultimoNome: String = "",
    var email: String = "",
    @ColumnInfo(name = "numero_protocolo")
    var matricula: Int = 0,
)