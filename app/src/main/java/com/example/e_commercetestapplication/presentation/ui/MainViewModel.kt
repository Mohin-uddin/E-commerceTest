package com.example.e_commercetestapplication.presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commercetestapplication.data.remote.ProductItem
import com.example.e_commercetestapplication.data.remote.ProductListResponse
import com.example.e_commercetestapplication.domain.repository.GetProductListRepository
import com.example.e_commercetestapplication.domain.repository.ProductLocalDatabaseRepository
import com.example.e_commercetestapplication.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val repository: GetProductListRepository,
   private val productLocalDatabaseRepository: ProductLocalDatabaseRepository
): ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _isLoading.value = false
            loadProductList()
        }
    }

    private var _selectProduct = MutableStateFlow<ProductItem?>(null)
    val selectProduct : StateFlow<ProductItem?> = _selectProduct
    private var _cartListLItem = MutableStateFlow<List<ProductItem>>(emptyList())
    var cartListLItem: StateFlow<List<ProductItem>> = _cartListLItem.asStateFlow()

    var state by mutableStateOf(ProductListState())
        private set

    private fun loadProductList() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = ""
            )

            when(val result = repository.getProductData()){
                is Resource.Success -> {
                    state = state.copy(
                        productList = dataAttach(result.data)
                        ,
                        isLoading = false,
                        error = ""
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        productList = emptyList(),
                        isLoading = false,
                        error = result.message?:"Something is error"
                    )
                }
            }
        }

    }

    private fun dataAttach(data: ProductListResponse?): List<ProductItem> {
        val updateList : ArrayList <ProductItem> = arrayListOf ()
        data?.productList?.forEach { productItem ->
            productItem.productStatus = returnProductStatus()
            updateList.add(productItem)
        }
       return updateList
    }

    private fun returnProductStatus():String{
        val status  = arrayOf("Available","StockOut","Coming Soon")
        val index = (0..2).random()
        return status[index]
    }
    fun selectItem( productItem: ProductItem){
        _selectProduct.value = productItem
    }
    fun cartDataAdd(productItem: ProductItem){
        viewModelScope.launch {
            productLocalDatabaseRepository.insertProduct(productItem = productItem)
        }
    }
    fun getAllCartList(){
        viewModelScope.launch(){
            productLocalDatabaseRepository.getAllCartProduct().collectLatest {
                _cartListLItem.emit(it)
            }
        }
    }
}