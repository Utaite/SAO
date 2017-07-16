package com.utaite.sao.view.main.fragment.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utaite.sao.R
import com.utaite.sao.util.DB
import com.utaite.sao.view.app.view.App
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.listener.SectionChangeListener
import com.utaite.sao.view.main.fragment.view.MainInfoFragment
import com.utaite.sao.view.main.fragment.vo.MainItem
import com.utaite.sao.view.main.fragment.vo.MainSection
import kotlinx.android.synthetic.main.fragment_main_item.view.*
import kotlinx.android.synthetic.main.fragment_main_section.view.*


class MainAdapter(private val act: MainActivity,
                  private val vo: MutableList<Any>,
                  private val gridLayoutManager: GridLayoutManager,
                  private val sectionStateChangeListener: SectionChangeListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val VIEW_TYPE_SECTION = R.layout.fragment_main_section
    private val VIEW_TYPE_ITEM = R.layout.fragment_main_item

    init {
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                    when (isSection(position)) {
                        true -> gridLayoutManager.spanCount
                        false -> 1
                    }
        }
    }

    private fun isSection(position: Int): Boolean =
            vo[position] is MainSection

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(act).inflate(viewType, parent, false), viewType).apply {
                itemView.main_item_img?.setOnClickListener {
                    act.selectedItem = vo[adapterPosition] as MainItem
                    MainInfoFragment().show(act.supportFragmentManager, "")
                }

                itemView.main_item_txt?.setOnClickListener {
                    act.selectedItem = vo[adapterPosition] as MainItem
                    MainInfoFragment().show(act.supportFragmentManager, "")
                }

                itemView.main_section_txt?.setOnClickListener {
                    (vo[adapterPosition] as MainSection).let {
                        sectionStateChangeListener.onSectionChanged(it, !it.isExpanded)
                    }
                }

                itemView.main_section_btn?.setOnCheckedChangeListener { _, isChecked ->
                    sectionStateChangeListener.onSectionChanged(vo[adapterPosition] as MainSection, isChecked)
                }
            }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.viewType) {
            VIEW_TYPE_ITEM -> {
                (vo[position] as MainItem).let {
                    holder.itemView.main_item_img.setImageResource(it.mainImg)

                    App.run {
                        holder.itemView.main_item_txt.run {
                            it.mainImg.getBitmap(act).getDominantColor().let { dominant ->
                                setTextColor(dominant)
                                setBackgroundColor(dominant.getOppositionColor())
                            }
                            text = it.nickNameKR + "\n(${it.nickNameJP})"
                            background.alpha = act.app.MAIN_TXT_BG_ALPHA
                        }
                    }
                }
            }

            VIEW_TYPE_SECTION -> {
                (vo[position] as MainSection).let {
                    holder.itemView.main_section_btn.isChecked = it.isExpanded

                    holder.itemView.main_section_txt.text = it.section
                    App.run {
                        when (holder.itemView.main_section_txt.text) {
                            DB.SECTION_SAO -> Pair(getColor(act, R.color.main_sao_bg_txt), getColor(act, R.color.main_sao_bg_layout))
                            DB.SECTION_ALO -> Pair(getColor(act, R.color.main_alo_bg_txt), getColor(act, R.color.main_alo_bg_layout))
                            DB.SECTION_GGO -> Pair(getColor(act, R.color.main_ggo_bg_txt), getColor(act, R.color.main_ggo_bg_layout))
                            else -> Pair(getColor(act, android.R.color.transparent), getColor(act, android.R.color.transparent))
                        }.let { backgroundColors ->
                            holder.itemView.main_section_txt.setBackgroundColor(backgroundColors.first)
                            holder.itemView.main_section_layout.setBackgroundColor(backgroundColors.second)
                        }
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
            when (isSection(position)) {
                true -> VIEW_TYPE_SECTION
                false -> VIEW_TYPE_ITEM
            }

    override fun getItemCount(): Int =
            vo.size

    class ViewHolder(view: View, val viewType: Int) : RecyclerView.ViewHolder(view)

}
