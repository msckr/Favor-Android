import android.util.Log
import com.nise.favor_android.Login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository() {
    private val Dr = Retrofit

    fun postRegisterForm(loginRequest: LoginRequest){
        val call = Dr.service.requestLogin(loginRequest)
        call.enqueue(object : Callback<UserDTO>{
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
            }
            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
            }
        })
    }

    fun makeProfileForm(profileMake: ProfileMake,userNo : Int){
        val call = Dr.service.makeProfile(profileMake, userNo)
        call.enqueue(object :Callback<UserDTO>{
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
            }
            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
            }

        })


    }
}