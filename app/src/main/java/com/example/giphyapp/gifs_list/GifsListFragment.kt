package com.example.giphyapp.gifs_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.giphyapp.GifsViewModel
import com.example.giphyapp.databinding.FragmentGifsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GifsListFragment : Fragment() {

    private var _binding: FragmentGifsListBinding? = null
    private val binding get() = _binding!!

    private val gifsViewModel: GifsViewModel by viewModel()

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
//        findNavController().navigate(GifsListFragmentDirections.actionGifsListFragmentToGifFragment())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}