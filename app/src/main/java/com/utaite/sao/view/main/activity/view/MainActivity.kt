package com.utaite.sao.view.main.activity.view

import android.os.Bundle
import com.github.salomonbrys.kodein.LazyKodeinAware
import com.github.salomonbrys.kodein.instance
import com.pawegio.kandroid.toast
import com.utaite.sao.R
import com.utaite.sao.util.BaseActivity
import com.utaite.sao.view.app.view.App
import com.utaite.sao.view.main.activity.module.MainModule
import com.utaite.sao.view.main.activity.presenter.MainPresenter
import com.utaite.sao.view.main.fragment.vo.MainItem


class MainActivity : BaseActivity(), LazyKodeinAware {

    override val kodein = MainModule(this@MainActivity).module

    val app: App by instance()

    private val presenter: MainPresenter by instance()

    var selectedItem = MainItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onBackPressed() {
        when {
            supportFragmentManager.backStackEntryCount > 0 -> supportFragmentManager.popBackStack()
            app.CURRENT_TIME + app.BACK_TIME < System.currentTimeMillis() -> {
                app.CURRENT_TIME = System.currentTimeMillis()
                toast(R.string.onBackPressed)
            }
            else -> super.onBackPressed()
        }
    }

    private fun init() {
        initMain()
    }

    private fun initMain() {
        presenter.getFragmentManager(get(R.string.main_bot_main))
    }

}
