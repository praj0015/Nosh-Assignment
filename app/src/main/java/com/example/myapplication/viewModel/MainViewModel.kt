package com.example.noshassignment.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.DishesLocalModel
import com.example.myapplication.data.repository.DishesRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

//    var data : MutableState<List<DishesLocalModel>> = mutableStateOf(emptyList())
    val repository = DishesRepository()
    private var _list = MutableLiveData<List<DishesLocalModel>>()
    val list: LiveData<List<DishesLocalModel>>
        get() = _list

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                if(repository.getDishesData().isNotEmpty()) {
                    Log.d("fetch", "${repository.getDishesData()}")
                    _list.postValue(repository.getDishesData())
                }
            } catch(err: Exception) {
                Log.d("error", "Something went wrong ${err.message}!")
            }
        }
    }
}