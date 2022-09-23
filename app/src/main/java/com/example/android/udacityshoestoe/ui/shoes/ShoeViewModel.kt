package com.example.android.udacityshoestoe.ui.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.udacityshoestoe.models.ModelShoe

class ShoeViewModel : ViewModel() {

    private val _listOfShoes = MutableLiveData<MutableList<ModelShoe>>()
    val listOfShoes: LiveData<MutableList<ModelShoe>>
        get() = _listOfShoes

    private val _isSaved = MutableLiveData<Boolean>()
    val isSaved: LiveData<Boolean>
        get() = _isSaved

    init {
        _listOfShoes.value = mutableListOf()
        _isSaved.value = false
    }

    fun updateShoeList(newShoe: ModelShoe) {
        _listOfShoes.value?.add(newShoe)
        _isSaved.value = true
    }

    fun onSavedComplete() {
        _isSaved.value = false
    }

//


}