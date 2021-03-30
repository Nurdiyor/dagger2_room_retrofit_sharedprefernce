package uz.micro.star.dagger_room_retrofit_shared.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment
import uz.micro.star.dagger_room_retrofit_shared.R
import uz.micro.star.dagger_room_retrofit_shared.utils.SharedPreferencesHelper
import uz.micro.star.dagger_room_retrofit_shared.utils.User
import uz.micro.star.dagger_room_retrofit_shared.viewmodel.DaggerViewModelFactory
import uz.micro.star.dagger_room_retrofit_shared.viewmodel.MainActivityViewModel
import javax.inject.Inject

/**
 * Created by Microstar on 02.06.2020.
 */

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseHomeFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : DaggerFragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!

    @Inject
    lateinit var providerFactory: DaggerViewModelFactory

    lateinit var viewModel: MainActivityViewModel
    lateinit var navController: NavController

    @Inject
    lateinit var shared: SharedPreferencesHelper

    @Inject
    lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(
            requireActivity(),
            providerFactory
        )[MainActivityViewModel::class.java]
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.main_nav_fragment)
        onViewCreate()
    }

    abstract fun onViewCreate()

}