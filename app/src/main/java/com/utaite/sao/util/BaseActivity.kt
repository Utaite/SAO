package com.utaite.sao.util

import android.content.Context
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


open class BaseActivity : RxAppCompatActivity() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base))
    }

    fun get(resId: Int): String
            = getString(resId)

}
