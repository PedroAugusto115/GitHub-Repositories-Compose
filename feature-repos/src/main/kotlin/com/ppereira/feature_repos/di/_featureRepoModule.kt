package com.ppereira.feature_repos.di

import com.ppereira.feature_repos.repository.GitHubReposRepository
import com.ppereira.feature_repos.viewmodel.GitHubReposViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val _featureRepoModule = module {
    singleOf(::GitHubReposRepository)
    viewModel { GitHubReposViewModel(get()) }
}