package com.ppereira.pull_request_list.di

import com.ppereira.pull_request_list.repository.PullRequestRepository
import com.ppereira.pull_request_list.viewmodel.PullRequestViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val featurePullRequestModule = module {
    singleOf(::PullRequestRepository)
    viewModel { PullRequestViewModel(get()) }
}
