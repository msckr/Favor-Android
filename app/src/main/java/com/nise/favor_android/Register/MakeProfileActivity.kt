package com.nise.favor_android.Register

import Repository
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.doAfterTextChanged
import com.bumptech.glide.Glide
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityMakeProfileBinding

class MakeProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMakeProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editName.onFocusChangeListener = onFocusChangeListener
        binding.editId.onFocusChangeListener = onFocusChangeListener

        binding.editName.doAfterTextChanged { btnActivation() }
        binding.editId.doAfterTextChanged {
            btnActivation()
            if (it!!.isBlank()) return@doAfterTextChanged
            if (it.toString() == "@") it.clear()
            else if (!it.startsWith("@")) it.insert(0, "@")
        }
        binding.imgProfileEdit.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            activityResult.launch(intent)
        }
        binding.btnNext.setOnClickListener{
            if(verify()){
                MakeProfileForm().patchMakeProfile(binding.editId.text.toString(),binding.editName.text.toString())
                startActivity(Intent(applicationContext,RegisterTermActivity::class.java))
            }
        }
    }

    private val activityResult : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK && it.data!=null){
            val uri = it.data!!.data
            Glide.with(this)
                .load(uri)
                .into(binding.imgProfile)
        }
    }
    private val onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        when (v.id) {
            R.id.edit_name -> binding.barName
            R.id.edit_id -> binding.barId
            else -> null
        }!!.setBackgroundResource(if (hasFocus) R.color.textcolor else R.color.box1)
    }

    fun onHomeClicked(view: View) = onBackPressedDispatcher.onBackPressed()

    fun onNextButtonClicked(view: View) {
        val intent = Intent(applicationContext, RegisterTermActivity::class.java)
        if (verify()){
            var userId = binding.editId.text.toString()
            var userName = binding.editName.text.toString()

            intent.putExtra("name",binding.editName.text.toString())
            startActivity(intent)}
    }

    private fun verify(): Boolean =
        binding.editName.text.isNotBlank() && binding.editId.text.isNotBlank() && binding.editId.length() > 1

    private fun btnActivation() {
        if (verify()) {
            binding.btnNext.setTextColor(getColor(R.color.white))
            binding.btnNext.setBackgroundResource(R.drawable.back_maincolor)
        } else {
            binding.btnNext.setTextColor(getColor(R.color.textcolor))
            binding.btnNext.setBackgroundResource(R.drawable.back_button_light)
        }
    }

}