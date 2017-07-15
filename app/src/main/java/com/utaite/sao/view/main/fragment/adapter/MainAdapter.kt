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
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.inter.SectionChangeListener
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
                    act.selectedItem.clear()
                    act.selectedItem.add(vo[adapterPosition] as MainItem)
                    act.selectedItem.add(vo[adapterPosition] as MainItem)
                    act.selectedItem.add(vo[adapterPosition] as MainItem)
                    MainInfoFragment().show(act.supportFragmentManager, "")
                }

                itemView.main_item_txt?.setOnClickListener {
                    act.selectedItem.clear()
                    act.selectedItem.add(vo[adapterPosition] as MainItem)
                    act.selectedItem.add(vo[adapterPosition] as MainItem)
                    act.selectedItem.add(vo[adapterPosition] as MainItem)
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
                    holder.itemView.main_item_txt.text = it.nickNameKR + "\n(${it.nickNameJP})"
                    it.mainImg.getBitmap().let { bitmap ->
                        holder.itemView.main_item_txt.setTextColor(bitmap.getDominantColor())
                        holder.itemView.main_item_txt.setBackgroundColor(bitmap.getDominantColor())
                    }
                }
            }

            VIEW_TYPE_SECTION -> {
                (vo[position] as MainSection).let {
                    holder.itemView.main_section_txt.text = it.section
                    holder.itemView.main_section_btn.isChecked = it.isExpanded
                }
            }
        }
    }

    private fun Int.getBitmap(): Bitmap =
            BitmapFactory.decodeResource(act.resources, this@getBitmap,
                    BitmapFactory.Options().apply {
                        inJustDecodeBounds = false
                        inPurgeable = true
                    })

    private fun Bitmap.getDominantColor(): Int =
            Bitmap.createScaledBitmap(this, 1, 1, true).let { bitmap ->
                val color = bitmap.getPixel(0, 0)
                bitmap.recycle()
                return color
            }

    private fun Int.getOppositionColor(): Int =
            Color.rgb(
                    255 - Color.red(this),
                    255 - Color.green(this),
                    255 - Color.blue(this)
            )

    override fun getItemViewType(position: Int): Int =
            when (isSection(position)) {
                true -> VIEW_TYPE_SECTION
                false -> VIEW_TYPE_ITEM
            }

    override fun getItemCount(): Int =
            vo.size

    class ViewHolder(view: View, val viewType: Int) : RecyclerView.ViewHolder(view)

}
