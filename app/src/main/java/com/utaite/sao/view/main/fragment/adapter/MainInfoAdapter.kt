package com.utaite.sao.view.main.fragment.adapter

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utaite.sao.R
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.vo.MainItem
import kotlinx.android.synthetic.main.fragment_main_info_view.view.*


class MainInfoAdapter(private val act: MainActivity,
                      private val vo: MutableList<MainItem>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        LayoutInflater.from(act).inflate(R.layout.fragment_main_info_view, container, false).let {
            it.main_view_frame.setOnClickListener { /* TODO */ }
            it.main_view_relative.setOnClickListener { /* TODO */ }

            it.main_view_txt.text = vo[position].nickNameKR + "\n(${vo[position].nickNameJP})"

            container.addView(it)
            return it
        }
    }

    override fun getCount() =
            vo.size

    override fun getItemPosition(obj: Any?) =
            POSITION_NONE

    override fun isViewFromObject(view: View, obj: Any) =
            view == obj

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) =
            container.removeView(obj as View)

}
