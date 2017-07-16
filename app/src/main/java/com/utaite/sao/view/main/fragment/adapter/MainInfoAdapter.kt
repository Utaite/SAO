package com.utaite.sao.view.main.fragment.adapter

import android.content.Intent
import android.net.Uri
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.utaite.sao.R
import com.utaite.sao.util.DB
import com.utaite.sao.view.app.view.App
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.vo.MainItem
import kotlinx.android.synthetic.main.fragment_main_info_view0.view.*
import kotlinx.android.synthetic.main.fragment_main_info_view1.view.*


class MainInfoAdapter(private val act: MainActivity,
                      private val vo: MainItem) : PagerAdapter() {

    private val VIEW_TYPE_VIEW0 = R.layout.fragment_main_info_view0
    private val VIEW_TYPE_VIEW1 = R.layout.fragment_main_info_view1

    override fun instantiateItem(container: ViewGroup, position: Int): Any =
            getResource(position)?.let { resource ->
                LayoutInflater.from(act).inflate(resource, container, false).also {
                    it binding resource
                    container.addView(it)
                }
            } ?: Unit

    private fun getResource(position: Int): Int? =
            when (position) {
                0 -> VIEW_TYPE_VIEW0
                1 -> VIEW_TYPE_VIEW1
                else -> null
            }

    infix private fun View.binding(resource: Int) {
        when (resource) {
            VIEW_TYPE_VIEW0 -> {
                this.main_view0_frame.setOnClickListener { }
                this.main_view0_txt_top.setTopElement(R.string.main_view0_title)
                this.main_view0_txt_bot.setBottomElement()

                this.main_view0_img.setImageResource(vo.mainImg)

            }
            VIEW_TYPE_VIEW1 -> {
                this.main_view1_frame.setOnClickListener { }
                this.main_view1_txt_top.setTopElement(R.string.main_view1_title)
                this.main_view1_txt_bot.setBottomElement()

                this.main_view1_real_name.text = getRealName(vo.realNameKR, vo.realNameJP)
                this.main_view1_gender.text = getGender(vo.gender)
                this.main_view1_birth.text = getBirth(vo.birth)
                this.main_view1_keyword.text = getKeyword(vo.keyword)

                this.main_view1_more.setMore(vo.moreUri)
                this.main_view1_img.setImg(vo.imgUri)
            }
        }
    }

    private fun TextView.setTopElement(resId: Int) {
        App.run {
            this.run {
                vo.mainImg.getBitmap(act).getDominantColor().let { dominant ->
                    setTextColor(dominant)
                    setBackgroundColor(dominant.getOppositionColor())
                }
                background.alpha = act.app.MAIN_TXT_BG_ALPHA
                text = act.get(resId)
            }
        }
    }

    private fun TextView.setBottomElement() {
        App.run {
            this.run {
                vo.mainImg.getBitmap(act).getDominantColor().let { dominant ->
                    setTextColor(dominant)
                    setBackgroundColor(dominant.getOppositionColor())
                }
                background.alpha = act.app.MAIN_TXT_BG_ALPHA
                text = vo.nickNameKR + "\n(${vo.nickNameJP})"
            }
        }
    }

    private fun getRealName(realNameKR: String, realNameJP: String): String =
            when {
                realNameKR.isEmpty() && realNameJP.isEmpty() -> act.get(R.string.main_view1_undefined)
                realNameKR.isEmpty() -> realNameJP
                realNameJP.isEmpty() -> realNameKR
                else -> "${vo.realNameKR}\n(${vo.realNameJP})"
            }

    private fun getGender(gender: Int): String =
            when (gender) {
                DB.GENDER_UNDEFINED -> act.get(R.string.main_view1_undefined)
                DB.GENDER_MALE -> act.get(R.string.main_view1_gender_male)
                DB.GENDER_FEMALE -> act.get(R.string.main_view1_gender_female)
                else -> ""
            }

    private fun getBirth(birth: String): String =
            when {
                birth.isEmpty() -> act.get(R.string.main_view1_undefined)
                else -> "${birth.substring(0, 4)}${act.get(R.string.year)} ${birth.substring(4, 6)}${act.get(R.string.month)} ${birth.substring(6, 8)}${act.get(R.string.day)}"
            }

    private fun getKeyword(keyword: List<String>): String =
            keyword.toString().replace("[", "").replace("]", "")

    private fun TextView.setMore(moreUri: String) {
        when {
            moreUri.isEmpty() -> this@setMore.visibility = View.GONE
            else -> this@setMore.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse("https://namu.wiki/w/$moreUri")).let { intent ->
                    act.startActivity(intent)
                }
            }
        }
    }

    private fun TextView.setImg(imgUri: String) {
        when {
            imgUri.isEmpty() -> this@setImg.visibility = View.GONE
            else -> this@setImg.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr/search?q=$imgUri")).let { intent ->
                    act.startActivity(intent)
                }
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
