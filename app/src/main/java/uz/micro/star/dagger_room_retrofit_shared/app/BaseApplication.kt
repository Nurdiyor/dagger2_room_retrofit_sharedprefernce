package uz.micro.star.dagger_room_retrofit_shared.app

import dagger.android.support.DaggerApplication
import uz.micro.star.dagger_room_retrofit_shared.di.component.DaggerAppComponent

/**
 * Created by Microstar on 02.06.2020.
 */
class BaseApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()
}