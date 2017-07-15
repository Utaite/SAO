package com.utaite.sao.view.main.activity.presenter

import android.support.v4.app.Fragment
import com.utaite.sao.R
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.view.MainFragment


class MainPresenter(val act: MainActivity) {

    fun getFragmentManager(title: CharSequence) =
            act.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, getFragment(title))
                    .commit()

    private fun getFragment(title: CharSequence): Fragment? =
            when (title) {
                act.get(R.string.main_bot_main) -> MainFragment()
                else -> null
            }

}
