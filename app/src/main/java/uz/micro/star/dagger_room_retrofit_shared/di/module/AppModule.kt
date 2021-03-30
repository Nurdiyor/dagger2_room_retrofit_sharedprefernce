package uz.micro.star.dagger_room_retrofit_shared.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import uz.micro.star.dagger_room_retrofit_shared.utils.SharedPreferencesHelper
import uz.micro.star.dagger_room_retrofit_shared.utils.User
import uz.micro.star.davrpay.di.modue.NetworkModule
import javax.inject.Singleton

/**
 * Created by Microstar on 02.06.2020.
 */

@Module(
    includes = [
        NetworkModule::class,
        RoomModule::class
    ]
)
object AppModule {

    @Singleton
    @Provides
    fun provideShared(application: Application) = SharedPreferencesHelper(application)

    @Singleton
    @Provides
    fun user(application: Application) = User("Hello world")

//    @Singleton
//    @Provides
//    fun provideShowLoadingDialog(application: Application)= ShowLoadingDialog(application)
}