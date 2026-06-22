package com.example.architecturebattlearena.di

import com.example.architecturebattlearena.data.repository.BattleRepositoryImpl
import com.example.architecturebattlearena.domain.repository.BattleRepository
import com.example.architecturebattlearena.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<BattleRepository> { BattleRepositoryImpl() }
    viewModel { HomeViewModel(get()) }
}
