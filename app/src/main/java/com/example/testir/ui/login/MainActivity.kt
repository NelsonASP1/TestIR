package com.example.testir.ui.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.testir.R


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.data.observe(this, Observer { res ->
            val codigo = getAppVersion()
            if (res != codigo){
                showAlertDialog("Error","La versión del aplicativo no coincide")
            }
        })
        viewModel.fetchData()
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
