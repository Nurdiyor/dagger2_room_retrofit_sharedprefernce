package uz.micro.star.dagger_room_retrofit_shared.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.micro.star.dagger_room_retrofit_shared.network.RetrofitService
import uz.micro.star.dagger_room_retrofit_shared.utils.SharedPreferencesHelper

import javax.inject.Inject

/**
 * Created by Microstar on 02.06.2020.
 */

class MainActivityViewModel @Inject constructor(
    var service: RetrofitService,
    var sharedPreferencesHelper: SharedPreferencesHelper
) : ViewModel(){
    var data=MutableLiveData<String>()

    fun login():LiveData<String>{
        CoroutineScope(Dispatchers.IO).launch {
//           service.

            withContext(Dispatchers.Main) {
               data.value="Shaxzod dars tugadi!!!"
            }
        }
        return data
    }
    //    fun logIn(context: Context, logInRequest: LogInRequest,fcmToken:String): LiveData<Int> {
//        var logIn = MutableLiveData<Int>()
//        var user: Int
//        var showLoadingDialog = ShowLoadingDialog(context)
//        showLoadingDialog.show()
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                var response = service.logIn(fcmToken,logInRequest)
//                if (response.code() == 200) {
//                    sharedPreferencesHelper.setProfileSaving(true)
//                    sharedPreferencesHelper.setToken(response.body()!!.token)
//                    sharedPreferencesHelper.setUserName(response.body()!!.user.first_name)
//                    sharedPreferencesHelper.setUserID(response.body()!!.masterId)
//                    sharedPreferencesHelper.setCurrentBalance(response.body()!!.balance)
//                    sharedPreferencesHelper.setCurrentPoint(response.body()!!.points)
//                    sharedPreferencesHelper.setHeadMaster(response.body()!!.isHeadMaster)
//                    sharedPreferencesHelper.setUserPassword(logInRequest.password)
//                    if (response.body()!!.isHeadMaster) {
//                        user = 1
//                    } else {
//                        user = 2
//                    }
//
//                } else {
//                    user = 0
//                }
//                showLoadingDialog.dismiss()
//            } catch (e: HttpException) {
//                user = -1
//                Log.d("TTTT", "HttpException: " + e.message())
//                showLoadingDialog.dismiss()
//            } catch (e: Throwable) {
//                user = -1
//                showLoadingDialog.dismiss()
//                Log.d("TTTT", "Ooops: Something else went wrong: " + e)
//            }
//            withContext(Dispatchers.Main) {
//                when (user) {
//                    0 -> toast(context, context.getString(R.string.username_or_passowrd_incorrect))
//                    -1 -> toast(context, context.getString(R.string.no_internet_connection))
//                    else -> logIn.value = user
//                }
//            }
//        }
//        return logIn
//    }
}