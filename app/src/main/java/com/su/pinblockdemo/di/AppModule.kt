package com.su.pinblockdemo.di

import com.su.pinblockdemo.data.PinBlockUsecase
import com.su.pinblockdemo.data.PinBlockUsecaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providePinBlockUserCase(): PinBlockUsecase = PinBlockUsecaseImpl()
}