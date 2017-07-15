package com.utaite.sao.view.main.fragment.inter

import com.utaite.sao.view.main.fragment.vo.MainSection


interface SectionChangeListener {
    fun onSectionChanged(section: MainSection, isOpen: Boolean)
}
