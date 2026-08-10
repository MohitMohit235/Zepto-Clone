package com.example.zepto

import com.example.zepto.data.repositoryimpl.cartrepositoryimpl.CartRepositoryImpl
import com.example.zepto.domain.repository.cartrepository.CartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCartRepository(
            iml: CartRepositoryImpl
    ): CartRepository

}