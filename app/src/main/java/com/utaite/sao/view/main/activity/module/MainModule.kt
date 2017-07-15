package com.utaite.sao.view.main.activity.module

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.lazy
import com.github.salomonbrys.kodein.singleton
import com.utaite.sao.view.app.view.App
import com.utaite.sao.view.main.activity.presenter.MainPresenter
import com.utaite.sao.view.main.activity.view.MainActivity


class MainModule(val act: MainActivity) {

    val module = Kodein.lazy {
        bind<App>() with singleton { act.application as App }
        bind<MainPresenter>() with singleton { MainPresenter(act) }
    }

}
