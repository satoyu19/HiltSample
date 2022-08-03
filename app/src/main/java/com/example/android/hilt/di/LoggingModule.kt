package com.example.android.hilt.di

import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.LoggerInMemoryDataSource
import com.example.android.hilt.data.LoggerLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

//LoggerDataSourceの各実装のスコープは異なるコンテナに設定されているため、同じモジュールを使用することはできない。
@Module
@InstallIn(SingletonComponent::class)
abstract class LoggingDatabaseModule {

    @DatabaseLogger
    @Singleton  //型がスコープ設定されている場合、@Binds メソッドにはスコープ設定アノテーションが必要
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource): LoggerDataSource
}

@Module
@InstallIn(ActivityComponent::class)
abstract class LoggingInMemoryModule{

    @InMemoryLogger
    @ActivityScoped
    @Binds
    abstract fun bindInMemoryModule(impl: LoggerInMemoryDataSource): LoggerDataSource
}

//同じ型のことなる実装(複数のバインディング)を提供する方法をHiltに提示するために、それぞれの修飾子を用意し、各モジュールのBindsメソッドの修飾子とする。
@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DatabaseLogger