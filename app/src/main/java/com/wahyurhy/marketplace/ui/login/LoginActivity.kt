package com.wahyurhy.marketplace.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wahyurhy.marketplace.databinding.ActivityLoginBinding
import com.wahyurhy.marketplace.util.Prefs

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val s = Prefs(this)
        if (s.getIsLogin()) {
            binding.tvStatus.text = "SUDAH LOGIN"
        } else binding.tvStatus.text = "BELUM LOGIN"

        binding.btnLogin.setOnClickListener {
            s.setIsLogin(true)
            onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            s.setIsLogin(false)
            onBackPressed()
        }
    }
}