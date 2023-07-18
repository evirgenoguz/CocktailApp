package com.evirgenoguz.cocktailapp.di

import android.content.Context
import com.evirgenoguz.cocktailapp.presenter.DefaultIndicatorPresenterImpl
import com.evirgenoguz.cocktailapp.presenter.IndicatorPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

/**
 * @Author: Oguz Evirgen
 * @Date: 18.07.2023
 */

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideIndicatorPresenter(@ActivityContext context: Context): IndicatorPresenter =
        DefaultIndicatorPresenterImpl(context)

}