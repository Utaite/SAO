package com.utaite.sao.view.main.fragment.module

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.lazy
import com.github.salomonbrys.kodein.singleton
import com.utaite.sao.R
import com.utaite.sao.util.DB
import com.utaite.sao.view.main.activity.view.MainActivity
import com.utaite.sao.view.main.fragment.view.MainFragment
import com.utaite.sao.view.main.fragment.vo.MainItem


class MainModule(val fra: MainFragment) {

    val module = Kodein.lazy {
        bind<MainActivity>() with singleton { fra.activity as MainActivity }

        bind<MutableList<MainItem>>("SAO") with singleton {
            mutableListOf(
                    MainItem(
                            nickNameKR = "키리토",
                            nickNameJP = "キリト",
                            mainImg = R.drawable.main_kirito,
                            realNameKR = "키리가야 카즈토",
                            realNameJP = "桐ヶ谷和人",
                            gender = DB.GENDER_MALE,
                            birth = "20081007"
                    ),
                    MainItem(
                            nickNameKR = "아스나",
                            nickNameJP = "アスナ",
                            mainImg = R.drawable.main_asuna,
                            realNameKR = "유우키 아스나",
                            realNameJP = "結城明日奈",
                            gender = DB.GENDER_FEMALE,
                            birth = "20070930"
                    ),
                    MainItem(
                            nickNameKR = "유이",
                            nickNameJP = "ユイ",
                            mainImg = R.drawable.main_yui,
                            realNameKR = "",
                            realNameJP = "",
                            gender = DB.GENDER_FEMALE,
                            birth = "20081007"
                    )
            )
        }

        bind<MutableList<MainItem>>("ALO") with singleton {
            mutableListOf(
                    MainItem(
                            nickNameKR = "리파",
                            nickNameJP = "リーファ",
                            mainImg = 0,
                            realNameKR = "키리가야 스구하",
                            realNameJP = "桐ヶ谷直葉",
                            gender = DB.GENDER_FEMALE,
                            birth = "20090419"
                    ),
                    MainItem(
                            nickNameKR = "유우키",
                            nickNameJP = "ユウキ",
                            mainImg = 0,
                            realNameKR = "콘노 유우키",
                            realNameJP = "紺野木綿季",
                            gender = DB.GENDER_FEMALE,
                            birth = "20100523"
                    )
            )
        }

        bind<MutableList<MainItem>>("GGO") with singleton {
            mutableListOf(
                    MainItem(
                            nickNameKR = "시논",
                            nickNameJP = "シノン",
                            mainImg = 0,
                            realNameKR = "아사다 시노",
                            realNameJP = "朝田詩乃",
                            gender = DB.GENDER_FEMALE,
                            birth = "20090821"
                    ),
                    MainItem(
                            nickNameKR = "슈피겔",
                            nickNameJP = "アスナ",
                            mainImg = 0,
                            realNameKR = "신카와 쿄지",
                            realNameJP = "新川恭二",
                            gender = DB.GENDER_MALE,
                            birth = ""
                    )
            )
        }
    }

}
