package com.ppereira.gitrepo

import android.app.Application
import com.ppereira.repository_list.di._featureRepoModule
import com.ppereira.networking.di._networkModule
import org.koin.core.context.startKoin

class GitHubReposApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                _networkModule,
                _featureRepoModule
            )
        }
    }
}