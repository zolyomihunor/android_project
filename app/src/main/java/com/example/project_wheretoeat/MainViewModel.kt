package com.example.project_wheretoeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_wheretoeat.model.Resdata
import com.example.project_wheretoeat.model.Restaurant
import com.example.project_wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) :ViewModel(){

    val myResponse: MutableLiveData<List<Restaurant>> = MutableLiveData()
    //var myCustomRestaurants: MutableLiveData<Response<List<Restaurant>>> = MutableLiveData()
    val myRestaurant: MutableLiveData<Restaurant> = MutableLiveData()


    fun getRestaurants(){
        viewModelScope.launch {

            val response = repository.getRestaurants().restaurants
            myResponse.value = response
        }
    }

    fun getOneRestaurant(id:Int){
        viewModelScope.launch {
            val response_restaurant = repository.getOneRestaurant(id)
            myRestaurant.value = response_restaurant
        }
    }






}