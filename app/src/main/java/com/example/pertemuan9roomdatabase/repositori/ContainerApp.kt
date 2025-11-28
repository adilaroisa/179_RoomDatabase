package com.example.pertemuan9roomdatabase.repositori

import android.app.Application
import android.content.Context
import com.example.pertemuan9roomdatabase.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context): ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            siswaDao = DatabaseSiswa.getDatabase(context).siswaDao()
        )
    }
}

class AplikasiSiswa : Application() {
    /**
    AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(context = this)
    }
}