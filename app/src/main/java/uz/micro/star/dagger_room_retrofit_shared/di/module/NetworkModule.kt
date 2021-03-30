package uz.micro.star.davrpay.di.modue

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uz.micro.star.dagger_room_retrofit_shared.network.RetrofitService
import uz.micro.star.dagger_room_retrofit_shared.utils.SharedPreferencesHelper
import javax.inject.Singleton


/**
 * Created by Microstar on 05.06.2020.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().create()
                )
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthApi(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        shared: SharedPreferencesHelper
    ): OkHttpClient {
        return OkHttpClient.Builder()
//            .readTimeout(60, TimeUnit.SECONDS)
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request()

                val newRequest = if (shared.getToken()!!
                        .equals("xxx")
                ) request.newBuilder() else request.newBuilder()
                    .header("Authorization", "Token ${shared.getToken()!!}")
                chain.proceed(newRequest.build())
            }
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()
    }

}