package com.example.architecturebattlearena.di

import com.example.architecturebattlearena.data.repository.BattleRepositoryImpl
import com.example.architecturebattlearena.domain.repository.BattleRepository
import org.koin.dsl.module

val appModule = module {
    single<BattleRepository> { BattleRepositoryImpl() }
}
