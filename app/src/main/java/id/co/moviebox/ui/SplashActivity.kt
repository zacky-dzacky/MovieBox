package id.co.moviebox.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import id.co.moviebox.R
import androidx.activity.viewModels
import id.co.moviebox.base_component.ui.BaseActivity
import id.co.moviebox.vm.SplashViewModel

class SplashActivity(layout: Int = R.layout.splash_activity) : BaseActivity(layout) {

    private val splashViewModel: SplashViewModel by viewModels { viewModelFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "Splash")
        listenObserver()
        splashViewModel.run {
            splashViewModel.openMain()
        }
    }

    private fun listenObserver() {
        splashViewModel.run {
            statusOpenMain.listen(this@SplashActivity,
            onSuccess = {
                startActivity(
                    Intent(
                        this@SplashActivity, HostActivity::class.java
                    )
                )
                finish()
            },
            onError = {
                      Log.v("ErrorRetrofit", it.message)
//                startActivity(
//                    Intent(
//                        this@SplashActivity, MainActivity::class.java
//                    )
//                )
//                finish()
            },
            onComplete = {
//                startActivity(
//                    Intent(
//                        this@SplashActivity, MainActivity::class.java
//                    )
//                )
//                finish()
            })
        }

    }
}