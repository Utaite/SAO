package com.utaite.sao.view.app.view

import android.app.Application
import com.github.salomonbrys.kodein.LazyKodeinAware
import com.github.salomonbrys.kodein.instance
import com.utaite.sao.view.app.module.AppModule
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class App : Application(), LazyKodeinAware {

    override val kodein = AppModule(this@App).module

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        val calligraphyConfig: CalligraphyConfig by instance()
        CalligraphyConfig.initDefault(calligraphyConfig)
    }


    val BACK_TIME = 2000
    var CURRENT_TIME = 0L

    val GRID_SPAN_COUNT = 3

}
