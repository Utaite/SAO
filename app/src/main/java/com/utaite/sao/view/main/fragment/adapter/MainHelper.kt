package com.utaite.sao.view.main.fragment.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.GridLayoutManager
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.listener.SectionChangeListener
import com.utaite.sao.view.main.fragment.vo.MainItem
import com.utaite.sao.view.main.fragment.vo.MainSection


class MainHelper(private val act: MainActivity,
                 private val recyclerView: RecyclerView,
                 private val gridSpanCount: Int) : SectionChangeListener {

    private val sectionDataMap = LinkedHashMap<MainSection, MutableList<MainItem>>()
    private val sectionMap = HashMap<String, MainSection>()

    private val dataArray = mutableListOf<Any>()

    init {
        recyclerView.let {
            it.layoutManager = GridLayoutManager(act, gridSpanCount)
            it.adapter = MainAdapter(act, dataArray, it.layoutManager as GridLayoutManager, this)
        }
    }

    fun notifyDataSetChanged() {
        generateDataList()
        recyclerView.adapter.notifyDataSetChanged()
    }

    private fun generateDataList() {
        dataArray.clear()

        for ((key, value) in sectionDataMap) {
            dataArray.add(key)
            if (key.isExpanded) {
                dataArray.addAll(value)
            }
        }
    }

    fun addSection(section: String, items: MutableList<MainItem>) {
        MainSection(section).let {
            sectionMap.put(section, it)
            sectionDataMap.put(it, items)
        }
    }

    fun removeSection(section: String) {
        sectionDataMap.remove(sectionMap[section])
        sectionMap.remove(section)
    }

    fun addItem(section: String, item: MainItem) =
            sectionDataMap[sectionMap[section]]?.add(item)

    fun removeItem(section: String, item: MainItem) =
            sectionDataMap[sectionMap[section]]?.remove(item)

    override fun onSectionChanged(section: MainSection, isOpen: Boolean) {
        if (!recyclerView.isComputingLayout) {
            section.isExpanded = isOpen
            notifyDataSetChanged()
        }
    }

}
