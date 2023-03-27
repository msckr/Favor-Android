package com.nise.favor_android.Register

import Repository
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.doAfterTextChanged
import com.bumptech.glide.Glide
import com.nise.favor_android.Login.ProfileMake
import com.nise.favor_android.Login.meuser
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivityMakeProfileBinding

class MakeProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMakeProfileBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repo = Repository()
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
                val userId = binding.editId.text
                val name = binding.editName.text
                val userNo = intent.getIntExtra("userNo",0)
                Log.d("유저번호",userNo.toString())
                val intent = Intent(applicationContext, RegisterTermActivity::class.java)
                val profileMake = ProfileMake(
                    userId.substring(1,userId.lastIndex).trim(),
                    name.toString().trim()
                )
                    repo.makeProfileForm(profileMake,userNo,object : Repository.GetDataCallBack<meuser>{
                        override fun onSuccess(data: meuser?) {
                            Log.d("유저정보",data.toString())
                            Log.d("유저아이디",profileMake.userId)
                            intent.putExtra("name",profileMake.name)
                            startActivity(intent)
                        }
                        override fun onFailure() {
                        }

                    })


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