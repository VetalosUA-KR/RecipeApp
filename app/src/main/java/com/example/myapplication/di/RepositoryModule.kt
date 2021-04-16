package com.example.myapplication.di

import com.example.myapplication.network.RecipeService
import com.example.myapplication.network.model.RecipeDtoMapper
import com.example.myapplication.repository.RecipeRepository
import com.example.myapplication.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    //in this API we need put token inside the query, so we added provider in NetworkNodule, which will be return this token
    @Singleton
    @Provides
    fun recipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepository_Impl(recipeService, recipeDtoMapper)
    }

}