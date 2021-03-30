package uz.micro.star.dagger_room_retrofit_shared.fragments


import android.widget.Toast
import uz.micro.star.dagger_room_retrofit_shared.databinding.FragmentFirstBinding


class FirstFragment : BaseHomeFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    override fun onViewCreate() {
        binding.myText.text = "efgwregwegewgweg"
//        viewModel
//        shared
//        Toast.makeText(requireContext(), user.name, Toast.LENGTH_SHORT).show()
        viewModel.data.observe(this, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
        viewModel.login()
    }


}