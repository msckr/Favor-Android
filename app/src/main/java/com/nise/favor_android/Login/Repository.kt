import android.util.Log
import com.nise.favor_android.Login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository() {
    private val Dr = Retrofit
    fun postRegisterForm(loginRequest: LoginRequest, param : GetDataCallBack<meuser>) {
        val call = Dr.service.requestLogin(loginRequest)
        call.enqueue(object : Callback<meuser>{
            override fun onResponse(call: Call<meuser>, response: Response<meuser>) {
                Log.d("log",response.body().toString())
                param.onSuccess(response.body())
            }
            override fun onFailure(call: Call<meuser>, t: Throwable) {
            }
        })
    }

    fun makeProfileForm(profileMake: ProfileMake,userNo: Int){

        val call = Dr.service.makeProfile(profileMake, userNo)
        call.enqueue(object :Callback<meuser>{
            override fun onResponse(call: Call<meuser>, response: Response<meuser>) {
                Log.d("log",response.body().toString())
            }
            override fun onFailure(call: Call<meuser>, t: Throwable) {
            }
        })
    }
    interface GetDataCallBack<T> {
        fun onSuccess(data:T?)
        fun onFailure()
    }

}