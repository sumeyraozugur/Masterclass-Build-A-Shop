package com.sum.ecommerce

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.sum.ecommerce.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
           // Snackbar.make(it, "SUmeyra", 1000).show()  görünüm alır.



        }
        // TODO : Assign the click listener to the views which we have implemented.
        // START
        // Click event assigned to Forgot Password text.
        binding.tvForgotPassword.setOnClickListener(this)
        // Click event assigned to Login button.
        binding.btnLogin.setOnClickListener(this)
        // Click event assigned to Register text.
        binding.tvRegister.setOnClickListener(this)
        // END


    }
    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {

                R.id.tvForgotPassword -> {
                    val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                    startActivity(intent)
                }

                R.id.btnLogin -> {

                   validateLoginDetails()
                }

                R.id.tvRegister -> {
                    // Launch the register screen when the user clicks on the text.
                    val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }

    private fun validateLoginDetails(): Boolean {
        return when {
            TextUtils.isEmpty(binding.etEmail.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }
            TextUtils.isEmpty(binding.etPassword.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }
            else -> {
                showErrorSnackBar("Your details are valid.", false)
                true
            }
        }
    }
}