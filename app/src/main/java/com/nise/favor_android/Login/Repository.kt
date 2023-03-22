import com.nise.favor_android.Login.LoginRequest

import android.util.Log
import com.nise.favor_android.Login.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository() {
    private val Dr = Retrofit

    fun postRegisterForm(loginRequest: LoginRequest){
        val call = Dr.service.requestLogin(loginRequest)

        call.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.i("post_success",response.body().toString())
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
            }
        })
    }

    


}