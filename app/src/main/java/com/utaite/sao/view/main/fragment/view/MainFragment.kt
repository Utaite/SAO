package com.utaite.sao.view.main.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kodein.LazyKodeinAware
import com.github.salomonbrys.kodein.instance
import com.utaite.sao.R
import com.utaite.sao.util.BaseFragment
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.adapter.MainHelper
import com.utaite.sao.view.main.fragment.module.MainModule
import com.utaite.sao.view.main.fragment.vo.MainItem
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : BaseFragment(), LazyKodeinAware {

    override val kodein = MainModule(this@MainFragment).module

    private val act: MainActivity by instance()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        val helper = MainHelper(act, main_recycler_view, act.app.GRID_SPAN_COUNT)
        val listSAO: MutableList<MainItem> by instance("SAO")
        val listALO: MutableList<MainItem> by instance("ALO")
        val listGGO: MutableList<MainItem> by instance("GGO")

        helper.run {
            addSection("Sword Art Online", listSAO)
            addSection("ALfheim Online", listALO)
            addSection("Gun Gale Online", listGGO)
            notifyDataSetChanged()
        }
    }

}
