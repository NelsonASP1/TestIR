package com.example.testir.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.testir.R
import com.example.testir.databinding.ActivityHomeBinding
import com.example.testir.databinding.ActivityMainBinding
import com.example.testir.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val versionViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        versionViewModel.versionResult.observe(this) { res ->
            val codigo = getAppVersion()
            if (res != codigo){
                showAlertDialog("Error","La version del aplicativo no coincide")
            }
        }
        versionViewModel.fetchVersion()
        init()
    }

    private fun init(){
        binding.loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAppVersion(): String {
        return try {
            val nameVersion = packageManager.getPackageInfo(packageName, 0)
            nameVersion.versionName }
        catch (e: Exception) {
            "N/A" }
    }

    private fun showAlertDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
