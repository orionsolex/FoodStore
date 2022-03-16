package com.example.foodstore.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodstore.R
import com.example.foodstore.api.ApiFactory
import com.example.foodstore.data.GoodInfo
import com.example.foodstore.data.data
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DashboardViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _data = MutableLiveData<data>().apply {
        value?.goodInfo?.description =
            "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum"
        value?.goodInfo?.images =
            listOf("http://80.78.246.225:3000/api/images/products/example-1.jpg")
        value?.goodInfo?.rating?.score = 4.5
        value?.goodInfo?.title = "Tasty Metal Chicken"
        value?.goodInfo?.subTitle = "1 шт (625 г)"
        value?.goodInfo?.price?.value = 202
        value?.goodInfo?.price?.currency = "₽"
        value?.goodInfo?.shop?.title = "Мое здоровье"
        value?.goodInfo?.shop?.subTitle = "1000 товаров"
        value?.goodInfo?.shop?.image = "http://80.78.246.225:3000/api/images/products/example-1.jpg"
    }
    val data: LiveData<data> = _data

    init {
        loadData()
    }

    private fun loadData() {

        val disposable = ApiFactory.apiService.getData()
            .map { it.goodInfo }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.value?.goodInfo = it
                Log.d("Download success", it.toString())
            }, {
                Log.d("Error", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}