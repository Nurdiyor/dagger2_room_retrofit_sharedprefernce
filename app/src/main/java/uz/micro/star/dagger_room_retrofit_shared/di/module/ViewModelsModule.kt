package uz.micro.star.dagger_room_retrofit_shared.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.micro.star.dagger_room_retrofit_shared.di.scope.ViewModelKey
import uz.micro.star.dagger_room_retrofit_shared.viewmodel.MainActivityViewModel

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun homeViewModel(homeViewModel: MainActivityViewModel): ViewModel

}