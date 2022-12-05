package com.example.giphyapp.gif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.giphyapp.GifsViewModel
import com.example.giphyapp.databinding.FragmentGifBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class GifFragment : Fragment() {
    private var _binding: FragmentGifBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GifsViewModel by activityViewModel()
    private val adapter by lazy { GifPagerAdapter(viewModel::saveGifLocally) }
    private val args: GifFragmentArgs by navArgs()

    private var currentItem: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGifBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentItem = args.selectedItem
        binding.viewPager.adapter = adapter
        viewModel.gifsInfos.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.viewPager.setCurrentItem(currentItem, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_ITEM_INDEX_KEY, binding.viewPager.currentItem)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if(savedInstanceState != null) {
            currentItem =  savedInstanceState.getInt(CURRENT_ITEM_INDEX_KEY, 0)
            binding.viewPager.currentItem = currentItem
        }
    }

    companion object {
        const val CURRENT_ITEM_INDEX_KEY = "item"
    }
}