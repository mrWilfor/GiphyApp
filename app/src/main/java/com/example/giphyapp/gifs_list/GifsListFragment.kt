package com.example.giphyapp.gifs_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giphyapp.GifsViewModel
import com.example.giphyapp.databinding.FragmentGifsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GifsListFragment : Fragment() {

    private var _binding: FragmentGifsListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GifsViewModel by viewModel()
    private val adapter by lazy { GifsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGifsListBinding
            .inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        binding.recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager: LinearLayoutManager =
                        recyclerView.layoutManager as LinearLayoutManager
                    val visibleItemCount: Int = layoutManager.childCount
                    val totalItemCount: Int = layoutManager.itemCount
                    val pastVisibleItems: Int =
                        layoutManager.findFirstCompletelyVisibleItemPosition()

                    if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                        binding.progressBar.isVisible = true
                        viewModel.search("q")
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        binding.progressBar.isVisible = true
        viewModel.search("q")
        viewModel.gifsInfos.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = false
            adapter.submitList(it)
        }


//        findNavController().navigate(GifsListFragmentDirections.actionGifsListFragmentToGifFragment())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}