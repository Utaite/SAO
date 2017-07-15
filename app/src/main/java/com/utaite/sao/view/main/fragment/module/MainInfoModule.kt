package com.utaite.sao.view.main.fragment.module

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.lazy
import com.github.salomonbrys.kodein.singleton
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.view.MainInfoFragment


class MainInfoModule(val fra: MainInfoFragment) {

    val module = Kodein.lazy {
        bind<MainActivity>() with singleton { fra.activity as MainActivity }
    }

}
