package com.mustafayilmaz.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mustafayilmaz.besinlerkitabi.R
import com.mustafayilmaz.besinlerkitabi.databinding.FragmentBesinDetayiBinding
import com.mustafayilmaz.besinlerkitabi.viewmodel.BesinDetayiViewModel

class BesinDetayiFragment : Fragment() {

    private lateinit var viewModel: BesinDetayiViewModel
    private var besinId = 0
    private lateinit var dataBinding: FragmentBesinDetayiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_besin_detayi, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinid
        }

        viewModel = ViewModelProvider(this).get(BesinDetayiViewModel::class.java)
        viewModel.roomVerisiniAl(besinId)

        observeLiveData()
    }

    fun observeLiveData() {

        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer { besin ->

            besin?.let {

                dataBinding.secilenBesin = it

                /*
                besinIsim.text = it.besinIsim
                besinKalori.text = it.besinKalori
                besinKarbonHidrat.text = it.besinKarbonhidrat
                besinProtein.text = it.besinProtein
                besinYag.text = it.besinYag
                context?.let {
                    besinImage.gorselIndir(besin.besinGorsel, placeholderYap(it))

                }*/
            }
        })
    }
}