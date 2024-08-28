package com.example.getapijetpackcomposeretrofithilt.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getapijetpackcomposeretrofithilt.model.Result
import com.example.getapijetpackcomposeretrofithilt.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repo: CharactersRepository
) :ViewModel() {
    private val _state = MutableStateFlow(emptyList<Result>())
    val state : StateFlow<List<Result>>
        get() = _state

    init {
        viewModelScope.launch {
        _state.value = repo.getCharacters().results
        }
    }
}