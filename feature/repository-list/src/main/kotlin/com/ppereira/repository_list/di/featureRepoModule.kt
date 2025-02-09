package com.ppereira.repository_list.di

import com.ppereira.repository_list.repository.GitHubReposRepository
import com.ppereira.repository_list.viewmodel.GitHubReposViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val featureRepoModule = module {
    singleOf(::GitHubReposRepository)
    viewModel { GitHubReposViewModel(get()) }
}
