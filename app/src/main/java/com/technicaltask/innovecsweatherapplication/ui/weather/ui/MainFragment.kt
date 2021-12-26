package com.technicaltask.innovecsweatherapplication.ui.weather.ui

import android.Manifest
import android.R
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.technicaltask.innovecsweatherapplication.MyApp
import com.technicaltask.innovecsweatherapplication.databinding.MainFragmentBinding
import com.technicaltask.innovecsweatherapplication.ui.weather.vm.MainFragmentViewModel
import com.technicaltask.innovecsweatherapplication.utils.Utils
import javax.inject.Inject
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    private var arrayAdapter: ArrayAdapter<String>? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @Inject
    lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        viewModel.deleteAllLocalData()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    private val permReqLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                checkLocationPermission()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        permReqLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        viewModel.cityLiveData.observe(viewLifecycleOwner) { it ->
            arrayAdapter = ArrayAdapter(
                requireActivity(),
                R.layout.simple_spinner_dropdown_item,
                it
            )
            arrayAdapter!!.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            binding.svCity.adapter = arrayAdapter
        }
        buttonEffect()
        searchWeather()
    }

    private fun init() {
        MyApp.appComponent.inject(fragment = this)
        viewModel.weatherCityData.observe(viewLifecycleOwner) {
            binding.cityName.text = it.name
            binding.txtTemp.text = "${it.temp}°"
            binding.maxTemp.text = "Max ${it.temp_max}°"
            binding.minTemp.text = "Min ${it.temp_min}°"
            binding.windSpeed.text = "Wind speed ${it.wind_speed}m/s"
            binding.feelsLike.text = "Feels like ${it.feels_like}°"
            binding.description.text = it.description
            binding.celcius.text = "С"
            Utils.getUrlImage(binding.imageWeather, it.icon)
        }
    }

    private fun searchWeather() {
        binding.btnSearch.setOnClickListener {
            val city = binding.svCity.selectedItem.toString()
            if (binding.svCity.selectedItem.toString() == "<current location>") {
                viewModel.currentLocationSelect()
            } else {
                viewModel.citySelect(city)
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    fun buttonEffect() {
        binding.btnSearch.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.background.setColorFilter(-0x1f0b8adf, PorterDuff.Mode.SRC_ATOP)
                    v.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    v.background.clearColorFilter()
                    v.invalidate()
                }
            }
            false
        }

    }

    private fun checkLocationPermission(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return false
        }
        LocationServices.getFusedLocationProviderClient(requireActivity()).lastLocation.addOnCompleteListener { task ->
            if (task.isSuccessful && task.result != null) {
                val location = task.result
                viewModel.setLocation(location.latitude, location.longitude)
            }
        }
        return true
    }
}