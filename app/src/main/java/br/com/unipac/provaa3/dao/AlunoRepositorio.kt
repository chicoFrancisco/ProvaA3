package br.com.unipac.provaa3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.unipac.provaa3.model.Aluno

@Dao
interface AlunoRepositorio {

    @Query("SELECT * FROM aluno")
    fun getAll(): List<Aluno>

    @Query("SELECT * FROM aluno WHERE id IN (:alunoIds)")
    fun loadAllByIds(alunoIds: IntArray): List<Aluno>

    @Insert
    fun insert(aluno: Aluno)

    @Insert
    fun insertAll(vararg alunos: Aluno)

    @Delete
    fun delete(aluno: Aluno)
}