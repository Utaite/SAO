package com.utaite.sao.view.main.fragment.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import com.github.salomonbrys.kodein.LazyKodeinAware
import com.github.salomonbrys.kodein.instance
import com.utaite.sao.R
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.adapter.MainInfoAdapter
import com.utaite.sao.view.main.fragment.module.MainInfoModule
import fr.tvbarthel.lib.blurdialogfragment.SupportBlurDialogFragment
import kotlinx.android.synthetic.main.fragment_main_info.*


class MainInfoFragment : SupportBlurDialogFragment(), LazyKodeinAware {

    override val kodein = MainInfoModule(this@MainInfoFragment).module

    private val TAG = javaClass.simpleName

    private val act: MainActivity by instance()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_main_info, container, false).apply {
                dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        main_info_view.run {
            adapter = MainInfoAdapter(act, act.selectedItem)
            setOnTouchListener { _, event ->
                if (event.action == KeyEvent.ACTION_DOWN) {
                    dismiss()
                }
                false
            }
        }
    }

}
