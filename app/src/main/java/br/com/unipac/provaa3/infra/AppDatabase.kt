package br.com.unipac.provaa3.infra

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.unipac.provaa3.dao.AlunoRepositorio
import br.com.unipac.provaa3.model.Aluno

@Database(entities = [Aluno::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun AlunoRepositorio(): AlunoRepositorio

    companion object {
        private var instance: AppDatabase? = null
        private val databaseName = "provaa3.db"

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, databaseName
                    ).allowMainThreadQueries().build();
                }
            }
            return instance;
        }

        fun destroyInstance() {
            instance = null
        }
    }
}