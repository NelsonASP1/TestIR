package com.example.testir.ui.home

import android.os.Bundle
import android.util.Log

import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testir.R
import com.example.testir.data.LoginRequest
import com.example.testir.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"

        homeViewModel.loginResult.observe(this) { result ->
            binding.textViewNombre.setText(result?.Nombre)
            binding.textViewApellido1.setText(result?.Apellido1)
            binding.textViewUsuario.setText(result?.Usuario)
            binding.textViewIdentificacion.setText(result?.Identificacion)
        }

        homeViewModel.localidades.observe(this){result ->
            binding.data1.setText( result.get(1).IdLocalidad)
            binding.data2.setText( result.get(1).IdTipoLocalidad)
            binding.data3.setText( result.get(1).IdAncestroPGrado)

            binding.data4.setText( result.get(2).IdLocalidad)
            binding.data5.setText( result.get(2).IdTipoLocalidad)
            binding.data6.setText( result.get(2).IdAncestroPGrado)
        }

        val loginRequest = LoginRequest(
            Mac = "",
            NomAplicacion = "Controller APP",
            Password = "SW50ZXIyMDIx\n",
            Path = "",
            Usuario = "cGFtLm1lcmVkeTIx\n"
        )

        homeViewModel.localidades()
        homeViewModel.login(loginRequest)
    }
}