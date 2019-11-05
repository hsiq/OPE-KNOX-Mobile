package com.aula.knoxope

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface DisciplinaDAO {
    @Query("SELECT * FROM disciplina where cpf = :cpf")
    fun getById(cpf: Long) : Disciplina?

    @Query("SELECT * FROM disciplina")
    fun findAll(): List<Disciplina>

    @Insert
    fun insert(disciplina: Disciplina)

    @Delete
    fun delete(disciplina: Disciplina)

}