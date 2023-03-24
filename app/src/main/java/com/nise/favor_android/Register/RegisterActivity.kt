package com.nise.favor_android.Register

import Repository
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import androidx.core.widget.doAfterTextChanged
import com.nise.favor_android.Login.Retrofit
import com.nise.favor_android.Login.meuser
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var groups: List<Group>


    internal data class Group(
        var verified: Boolean, val edit: EditText, val bar: View, val txt: TextView,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewmodel = RegisterForm()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            groups = listOf(
                Group(false, editEmail, barEmail, txtWarningEmail),
                Group(false, editPassword, barPassword, txtWarningPassword),
                Group(false, editPasswordConfirm, barPasswordConfirm, txtWarningPasswordConfirm)
            )

            editEmail.onFocusChangeListener = onFocusChangeListener
            editPassword.onFocusChangeListener = onFocusChangeListener
            editPasswordConfirm.onFocusChangeListener = onFocusChangeListener

            afterTextChanged(
                groups[0], "실제 사용하는 이메일을 입력해주세요.", "사용 가능한 이메일입니다.", null
            ) { it.matches(Regex("^[\\w.\\-]+@([\\w\\-]+\\.)+\\w{2,4}$")) }

            afterTextChanged(
                groups[1], "영문, 숫자 혼용 8자 이상", "사용 가능한 비밀번호입니다.", null
            ) {
                editPasswordConfirm.text = editPasswordConfirm.text
                it.matches(Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))
            }

            afterTextChanged(
                groups[2], "비밀번호를 한 번 더 입력해주세요.", "", "비밀번호가 일치하지 않습니다."
            ) { editPassword.text.length >= 8 && it == groups[1].edit.text.toString() }
        }


        binding.btnNext.setOnClickListener {
            if(verify()){
                var email = binding.editEmail.text.toString()
                var password = binding.editPassword.text.toString()
                viewmodel.postRegisterForm(email, password)
                startActivity(Intent(applicationContext, MakeProfileActivity::class.java))
            }
        }


    }

    private val onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        when (v.id) {
            R.id.edit_email -> binding.barEmail
            R.id.edit_password -> binding.barPassword
            R.id.edit_password_confirm -> binding.barPasswordConfirm
            else -> null
        }!!.setBackgroundResource(if (hasFocus) R.color.textcolor else R.color.box1)
    }

    fun onHomeClicked(view: View) = onBackPressedDispatcher.onBackPressed()


    fun onClick(view: View) {
        val isChecked = (view as CheckBox).isChecked
        val edittext: EditText = (view.parent as LinearLayout).getChildAt(0) as EditText
        edittext.transformationMethod =
            if (isChecked) HideReturnsTransformationMethod.getInstance()
            else PasswordTransformationMethod.getInstance()
    }

    private fun verify(): Boolean = groups.map { it.verified }.reduce { acc, b -> acc && b }

    private fun btnActivation() {
        if (verify()) {
            binding.btnNext.setTextColor(getColor(R.color.white))
            binding.btnNext.setBackgroundResource(R.drawable.back_maincolor)
        } else {
            binding.btnNext.setTextColor(getColor(R.color.textcolor))
            binding.btnNext.setBackgroundResource(R.drawable.back_button_light)
        }
    }

    private fun afterTextChanged(
        group: Group,
        msgDefault: String,
        msgSuccess: String,
        msgWarning: String?,
        confirm: (it: String) -> Boolean,
    ) {
        group.edit.doAfterTextChanged {
            if (confirm(it.toString())) {
                group.verified = true
                group.txt.text = msgSuccess
                group.txt.setTextColor(getColor(R.color.box2))
                group.bar.setBackgroundResource(if (group.edit.hasFocus()) R.color.textcolor else R.color.box1)
            } else if (it!!.isBlank()) {
                group.verified = false
                group.txt.text = msgDefault
                group.txt.setTextColor(getColor(R.color.box2))
                group.bar.setBackgroundResource(if (group.edit.hasFocus()) R.color.textcolor else R.color.box1)
            } else {
                group.verified = false
                group.txt.text = msgWarning ?: msgDefault
                group.txt.setTextColor(Color.RED)
                group.bar.setBackgroundColor(Color.RED)
            }
            btnActivation()
        }
    }

}
