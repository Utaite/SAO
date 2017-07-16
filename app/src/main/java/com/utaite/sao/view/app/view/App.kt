package com.utaite.sao.view.app.view

import android.app.Application
import android.content.Context
import android.os.Build
import android.support.v4.content.ContextCompat
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

    val MAIN_TXT_BG_ALPHA = 170

    val INFO_VIEW_ITEM_COUNT = 2


    @Suppress("DEPRECATION")
    fun getColor(con: Context, id: Int): Int =
            when {
                Build.VERSION.SDK_INT >= 23 -> ContextCompat.getColor(con, id)
                else -> con.resources.getColor(id)
            }

}
