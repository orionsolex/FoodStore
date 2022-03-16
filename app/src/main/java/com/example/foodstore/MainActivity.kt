package com.example.foodstore

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.foodstore.api.ApiFactory
import com.example.foodstore.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity  () {

    private lateinit var binding: ActivityMainBinding
   // private lateinit var viewModel: GoodsViewModel
    private val compositeDisposable = CompositeDisposable()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //viewModel = ViewModelProvider(this)[GoodsViewModel::class.java]

        val disposable=ApiFactory.apiService.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("realy", it.toString())
            }, {
                Log.d("realy", it.message.toString())
            })
compositeDisposable.add(disposable)

//    private fun getPriceListFromRawData(
//        coinPriceInfoRawData: CoinPriceInfoRawData
//    ): List<CoinPriceInfo> {
//        val result = ArrayList<CoinPriceInfo>()
//        val jsonObject: JsonObject = coinPriceInfoRawData.coinPriceInfoJsonObject ?: return result
//        val coinKeySet = jsonObject.keySet()
//        for (coinKey in coinKeySet) {
//            val currencyJson: JsonObject = jsonObject.getAsJsonObject(coinKey)
//            val currencyKeySet = currencyJson.keySet()
//            for (currencyKey in currencyKeySet) {
//                val priceInfo = Gson().fromJson(
//                    currencyJson.getAsJsonObject(currencyKey),
//                    CoinPriceInfo::class.java
//                )
//                result.add(priceInfo)
//            }
//        }
//        return result
//    }

        }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }


//        viewPager = findViewById(R.id.description_pager)

//        tabLayout = binding.container.findViewWithTag(tabLayout)
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//        }.attach()
    }

