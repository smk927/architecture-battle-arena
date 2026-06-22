package com.example.architecturebattlearena

import android.app.Application
import com.example.architecturebattlearena.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ArchitectureBattleArenaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ArchitectureBattleArenaApp)
            modules(appModule)
        }
    }
}
