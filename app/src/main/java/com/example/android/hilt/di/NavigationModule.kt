package com.example.android.hilt.di

import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
//新しいナビゲーション情報（AppNavigator ）では、Activity に固有の情報が必要です
// （AppNavigatorImpl が依存関係として Activity を持つため）。
// そのため、Application コンテナではなく Activity コンテナ（Activity に関する情報がある）をインストールする必要があります。
@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

//    AppNavigator はインターフェースのため、コンストラクタ注入を使用できません。
//    インターフェースに使用する実装を Hilt に指示するには、Hilt モジュール内の関数に @Binds アノテーションを使用します。
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator

//    Hilt モジュールには、非静的バインディング メソッドと抽象バインディング メソッドを両方含めることはできないため、
//    @Binds アノテーションと @Provides アノテーションを同じクラスに配置することはできません。
}