package com.example.fooddelivery.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.repository.HomePageRepository
import com.example.fooddelivery.ui.home.intent.HomeIntent
import com.example.fooddelivery.ui.home.viewstate.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.lang.reflect.Constructor
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getHomePageRepository: HomePageRepository) :
    ViewModel() {

    val homeIntent: Channel<HomeIntent> = Channel(Channel.UNLIMITED)

    private var _state = MutableStateFlow<HomeViewState>(HomeViewState.Idle)
    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        handleIntent()
    }

    fun handleIntent() {
        viewModelScope.launch {
            homeIntent.consumeAsFlow().collect() {
                when (it) {
                    HomeIntent.GetHomePageData -> fetchHomePageData()
                }
            }
        }
    }

    fun fetchHomePageData() {
        viewModelScope.launch {
            _state.value = HomeViewState.Loading
            try {
                _state.value = HomeViewState.Success(data = getHomePageRepository.getHomePageData())
            } catch (e: Exception) {
                _state.value = HomeViewState.Failure(failureMsg = e.message.toString())
            }
        }
    }
}