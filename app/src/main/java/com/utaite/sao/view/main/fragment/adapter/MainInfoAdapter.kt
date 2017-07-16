package com.utaite.sao.view.main.fragment.adapter

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utaite.sao.R
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.vo.MainItem
import kotlinx.android.synthetic.main.fragment_main_info_view0.view.*


class MainInfoAdapter(private val act: MainActivity,
                      private val vo: MainItem) : PagerAdapter() {

    private val VIEW_TYPE_VIEW0 = R.layout.fragment_main_info_view0
    private val VIEW_TYPE_VIEW1 = R.layout.fragment_main_info_view1

    override fun instantiateItem(container: ViewGroup, position: Int): Any =
            getResource(position)?.let { resource ->
                LayoutInflater.from(act).inflate(resource, container, false).also {
                    it.main_view_frame.setOnClickListener { }
                    it.binding(resource)
                    container.addView(it)
                }
            } ?: Unit

    private fun getResource(position: Int): Int? =
            when (position) {
                0 -> VIEW_TYPE_VIEW0
                1 -> VIEW_TYPE_VIEW1
                else -> null
            }

    private fun View.binding(resource: Int) {
        when (resource) {
            VIEW_TYPE_VIEW0 -> {
                this.main_view_txt.text = vo.nickNameKR + "\n(${vo.nickNameJP})"
            }
            VIEW_TYPE_VIEW1 -> {
                this.main_view_txt.text = vo.nickNameKR + "\n(${vo.nickNameKR})"
            }
        }
    }

    override fun getCount() =
            act.app.INFO_VIEW_ITEM_COUNT

    override fun getItemPosition(obj: Any?) =
            POSITION_NONE

    override fun isViewFromObject(view: View, obj: Any) =
            view == obj

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) =
            container.removeView(obj as View)

}
