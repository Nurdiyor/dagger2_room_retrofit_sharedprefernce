package uz.micro.star.dagger_room_retrofit_shared.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.micro.star.davrpay.room.AppDatabase
import javax.inject.Singleton

/**
 * Created by Microstar on 05.06.2020.
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesAppDatabase(application: Application) = Room.databaseBuilder(
        application.applicationContext, AppDatabase::class.java, "data_name"
    )
//        .allowMainThreadQueries()
//        .fallbackToDestructiveMigration()
//        .addMigrations(Migrations.isBonusTypeMigration)
        .build()

    @Singleton
    @Provides
    fun providesAppDao(appDatabase: AppDatabase) = appDatabase.getInputData()

}