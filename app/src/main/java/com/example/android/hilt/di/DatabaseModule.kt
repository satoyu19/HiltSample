package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class) //バインディングを使用できるコンテナをHilt指示
@Module
object DatabaseModule {

    //AppDatabaseはRoomによって生成されるため、プロジェクトにない別のクラスである、@Provides関数を使用してこのクラスを提供する事ができる。
//    各 Hilt コンテナには、Hilt がカスタム バインディングに依存関係として注入できるデフォルト バインディングのセットが用意されています。
//    たとえば applicationContext の場合、アクセスするにはフィールドに @ApplicationContext アノテーションを付ける必要があります。
    @Provides
    @Singleton  //常にHiltは同じデータベースインスタンスを返す。
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "logging.db"
        ).build()
    }

//    LogDao のインスタンスを提供する際に、database.logDao() を実行する必要があることを Hilt に指示しています。
//    推移的な依存関係として AppDatabase があるため、その型のインスタンスを提供する方法を Hilt に指示する必要がある。
    @Provides   //Hiltがこの型のインスタンスを提供するたびに実行される。
    fun provideLogDao(database: AppDatabase): LogDao{
        return database.logDao()
    }
}