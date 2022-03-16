package com.example.foodstore.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.foodstore.data.Shop
import com.example.foodstore.databinding.FragmentDashboardBinding
import com.squareup.picasso.Picasso

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.data.observe(viewLifecycleOwner) {
            with(binding) {
                DescriptionTextView.text = it.goodInfo?.description
                RatingTextView.text = it.goodInfo?.toString()
                TitleTextView.text = it.goodInfo?.title
                SubtitleTextView.text = it.goodInfo?.subTitle
                PriceTextView.text = it.goodInfo?.price.toString().plus(" ").plus(it.goodInfo?.price?.currency)
                Picasso.get().load(it.goodInfo?.shop?.image).into(imageView)
                shopTitleTextView.text = it.goodInfo?.shop?.title
                shopSubTitleTextView.text = it.goodInfo?.shop?.subTitle
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}