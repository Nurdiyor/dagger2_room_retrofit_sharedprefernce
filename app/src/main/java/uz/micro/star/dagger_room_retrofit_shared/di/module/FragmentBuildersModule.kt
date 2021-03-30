package uz.micro.star.dagger_room_retrofit_shared.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.micro.star.dagger_room_retrofit_shared.fragments.FirstFragment
import uz.micro.star.dagger_room_retrofit_shared.fragments.SecondFragment


/**
 * Created by Microstar on 02.06.2020.
 */
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun firstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun secondFragment(): SecondFragment
}