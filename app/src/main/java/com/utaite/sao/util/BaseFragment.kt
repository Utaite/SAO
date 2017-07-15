package com.utaite.sao.util

import android.support.v4.app.Fragment


open class BaseFragment : Fragment() {

    fun get(resId: Int): String
            = getString(resId)

}
