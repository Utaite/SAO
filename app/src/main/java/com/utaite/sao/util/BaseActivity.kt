package com.utaite.sao.util

import android.content.Context
import android.support.v7.app.AppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base))
    }

    fun get(resId: Int): String
            = getString(resId)

}
