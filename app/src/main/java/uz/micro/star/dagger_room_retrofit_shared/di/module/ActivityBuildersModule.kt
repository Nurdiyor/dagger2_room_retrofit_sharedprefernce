package uz.micro.star.dagger_room_retrofit_shared.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.micro.star.dagger_room_retrofit_shared.MainActivity


/**
 * Created by Microstar on 02.06.2020.
 */

@Module
abstract class ActivityBuildersModule {

//    @ContributesAndroidInjector
//    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class, ViewModelsModule::class])
    abstract fun contributeMainActivity(): MainActivity

}