package com.technicaltask.innovecsweatherapplication.utils

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.technicaltask.innovecsweatherapplication.R
import java.lang.Exception

class Utils {
    companion object {
        fun getUrlImage( image: ImageView, imageCode: String){
            Picasso.get()
                .load(Constants.BASE_URL_IMG + imageCode + ".png")
                .error(R.drawable.ic_launcher_foreground)
                .into(image, object:  Callback{
                    override fun onSuccess() {
                        Log.d("Success", "Success", )

                    }
                    override fun onError(e: Exception?) {
                        Log.e("Error", "onError: $e")
                    }
                })
        }
    }
}