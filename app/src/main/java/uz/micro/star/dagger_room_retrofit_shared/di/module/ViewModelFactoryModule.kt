package uz.micro.star.dagger_room_retrofit_shared.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import uz.micro.star.dagger_room_retrofit_shared.viewmodel.DaggerViewModelFactory


/**
 * Created by Microstar on 02.06.2020.
 */
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactor(modelProviderFactory: DaggerViewModelFactory?): ViewModelProvider.Factory?
}