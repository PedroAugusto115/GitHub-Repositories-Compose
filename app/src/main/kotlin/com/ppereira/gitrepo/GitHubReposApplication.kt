package com.ppereira.gitrepo

import android.app.Application
import com.ppereira.repository_list.di.featureRepoModule
import com.ppereira.networking.di.networkModule
import com.ppereira.pull_request_list.di.featurePullRequestModule
import org.koin.core.context.startKoin

class GitHubReposApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                networkModule,
                featureRepoModule,
                featurePullRequestModule
            )
        }
    }
}
