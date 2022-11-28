package com.example.fooddelivery.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.data.model.HomePageData
import com.example.fooddelivery.data.model.home_recyclerview_model.HomeRecyclcerViewItem
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.example.fooddelivery.ui.home.adapter.HomeRecyclerViewAdapter
import com.example.fooddelivery.ui.home.intent.HomeIntent
import com.example.fooddelivery.ui.home.viewmodel.HomeViewModel
import com.example.fooddelivery.ui.home.viewstate.HomeViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val homeRecyclerViewAdapter = HomeRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        observeViewModels()

        lifecycleScope.launch {
            homeViewModel.homeIntent.send(HomeIntent.GetHomePageData)
        }
    }

    private fun initView() {
        _binding!!.mainRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = homeRecyclerViewAdapter
        }
    }

    private fun observeViewModels() {
        lifecycleScope.launch {
            homeViewModel.state.collect {
                when (it) {
                    is HomeViewState.Idle -> _binding!!.progressBar.visibility = View.GONE
                    is HomeViewState.Loading -> _binding!!.progressBar.visibility = View.VISIBLE
                    is HomeViewState.Failure -> {
                        _binding!!.progressBar.visibility = View.GONE
                        _binding!!.textView.text = it.failureMsg
                    }
                    is HomeViewState.Success -> {
                        _binding!!.progressBar.visibility = View.GONE
                        //it.data has the response
                        val status = it.data.status
                        _binding!!.textView.visibility = View.GONE
                        processResponse(status, it.data)
                    }
                }
            }
        }
    }

    private fun processResponse(status: Int, homePageData: HomePageData) {
        if (status == 200) {
            setMainRecyclerViewData(homePageData)
        } else {
            _binding!!.textView.text = "Some error occurred"
        }
    }

    private fun setMainRecyclerViewData(homePageData: HomePageData) {
        val items = ArrayList<HomeRecyclcerViewItem>()

        homePageData?.data?.let {
            it.banners?.let { items.add(HomeRecyclcerViewItem.BannersList(it)) }
            it.food_categories?.let { items.add(HomeRecyclcerViewItem.FoodCategoryList(it)) }
            it.number_of_active_vouchers?.let { items.add(HomeRecyclcerViewItem.ActiveVouchers(it)) }
            it.offer_collections?.let { items.add(HomeRecyclcerViewItem.OfferCollectionList(it)) }
            it.restaurant_collections?.let {
                if (it[0].priority < it[1].priority) {
                    items.add(HomeRecyclcerViewItem.RestaurantCollection(it[0]))
                    items.add(HomeRecyclcerViewItem.RestaurantCollection(it[1]))
                } else {
                    items.add(HomeRecyclcerViewItem.RestaurantCollection(it[1]))
                    items.add(HomeRecyclcerViewItem.RestaurantCollection(it[0]))
                }
            }
            homeRecyclerViewAdapter.addItems(items)
        }
    }
}