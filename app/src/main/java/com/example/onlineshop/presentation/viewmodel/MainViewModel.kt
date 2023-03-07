package com.example.onlineshop.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.presentation.models.FlashSale
import com.example.onlineshop.presentation.models.Latest
import com.example.onlineshop.presentation.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    init {

    }

    private val _viewState = MutableStateFlow(
        ViewState()
    )
    val viewState = _viewState.asStateFlow()

   fun getData() {
        viewModelScope.launch {
            _viewState.update { currentState ->
                currentState.copy(
                    flashSales = listOf<FlashSale>(
                        FlashSale(
                            category = "Kids",
                            name = "New Balance Sneakers",
                            price = 22.5,
                            discount = (30).toDouble(),
                            image_url = "https://newbalance.ru/upload/iblock/697/iz997hht_nb_02_i.jpg"
                        ),
                        FlashSale(
                            category = "Kids",
                            name = "Reebok Classic",
                            price = (24).toDouble(),
                            discount = (30).toDouble(),
                            image_url = "https://assets.reebok.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/3613ebaf6ed24a609818ac63000250a3_9366/Classic_Leather_Shoes_-_Toddler_White_FZ2093_01_standard.jpg"
                        )
                    ),
                    latest = listOf<Latest>(
                        Latest(
                            category = "Phones",
                            name = "Samsung S10",
                            price = (1000).toDouble(),
                            image_url = "https://www.dhresource.com/0x0/f2/albu/g8/M01/9D/19/rBVaV1079WeAEW-AAARn9m_Dmh0487.jpg"
                        ),
                        Latest(
                            category = "Games",
                            name = "Sony Playstation 5",
                            price = (700).toDouble(),
                            image_url = "https://avatars.mds.yandex.net/get-mpic/6251774/img_id4273297770790914968.jpeg/orig"
                        ),
                        Latest(
                            category = "Games",
                            name = "Xbox ONE",
                            price = (500).toDouble(),
                            image_url = "https://www.tradeinn.com/f/13754/137546834/microsoft-xbox-xbox-one-s-1tb-console-additional-controller.jpg"
                        ),
                        Latest(
                            category = "Cars",
                            name = "BMW X6M",
                            price = (35000).toDouble(),
                            image_url = "https://mirbmw.ru/wp-content/uploads/2022/01/manhart-mhx6-700-01.jpg"
                        )
                    )
                )
            }
        }
    }
}