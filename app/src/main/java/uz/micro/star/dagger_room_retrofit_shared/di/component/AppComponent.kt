package uz.micro.star.dagger_room_retrofit_shared.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import uz.micro.star.dagger_room_retrofit_shared.app.BaseApplication
import uz.micro.star.dagger_room_retrofit_shared.di.module.ActivityBuildersModule
import uz.micro.star.dagger_room_retrofit_shared.di.module.AppModule
import uz.micro.star.dagger_room_retrofit_shared.di.module.ViewModelFactoryModule
import javax.inject.Singleton

/**
 * Created by Microstar on 02.06.2020.
 */
//anotatsiya
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
