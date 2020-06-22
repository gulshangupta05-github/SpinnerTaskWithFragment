package `in`.surelocal.spinnertask

import `in`.surelocal.spinnertask.spinner.SpinnerFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
                R.id.container,SpinnerFragment.newInstance()
        ).commit()
    }
}