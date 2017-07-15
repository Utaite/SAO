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
                    ),
                    MainItem(
                            nickNameKR = "사치",
                            nickNameJP = "サチ",
                            mainImg = R.drawable.main_sachi,
                            realNameKR = "",
                            realNameJP = "",
                            gender = DB.GENDER_FEMALE,
                            birth = ""
                    ),
                    MainItem(
                            nickNameKR = "클라인",
                            nickNameJP = "クライン",
                            mainImg = R.drawable.main_klein,
                            realNameKR = "츠보이 료타로",
                            realNameJP = "壷井遼太郎",
                            gender = DB.GENDER_MALE,
                            birth = ""
                    ),
                    MainItem(
                            nickNameKR = "리즈벳",
                            nickNameJP = "リズベット",
                            mainImg = R.drawable.main_lisbeth,
                            realNameKR = "시노자키 리카",
                            realNameJP = "篠崎里香",
                            gender = DB.GENDER_FEMALE,
                            birth = ""
                    ),
                    MainItem(
                            nickNameKR = "시리카",
                            nickNameJP = "シリカ",
                            mainImg = R.drawable.main_silica,
                            realNameKR = "아야노 케이코",
                            realNameJP = "綾野珪子",
                            gender = DB.GENDER_FEMALE,
                            birth = "20101004"
                    ),
                    MainItem(
                            nickNameKR = "에길",
                            nickNameJP = "エギル",
                            mainImg = R.drawable.main_agil,
                            realNameKR = "앤드루 길버트 밀즈",
                            realNameJP = "アンドリュー・ギルバート・ミルズ",
                            gender = DB.GENDER_MALE,
                            birth = ""
                    ),
                    MainItem(
                            nickNameKR = "히스클리프",
                            nickNameJP = "ヒースクリフ",
                            mainImg = R.drawable.main_heathcliff,
                            realNameKR = "카야바 아키히코",
                            realNameJP = "茅場晶彦",
                            gender = DB.GENDER_MALE,
                            birth = ""
                    )
            )
        }

        bind<MutableList<MainItem>>("ALO") with singleton {
            mutableListOf(
                    MainItem(
                            nickNameKR = "리파",
                            nickNameJP = "リーファ",
                            mainImg = R.drawable.main_leafa,
                            realNameKR = "키리가야 스구하",
                            realNameJP = "桐ヶ谷直葉",
                            gender = DB.GENDER_FEMALE,
                            birth = "20090419"
                    ),
                    MainItem(
                            nickNameKR = "유우키",
                            nickNameJP = "ユウキ",
                            mainImg = R.drawable.main_yuuki,
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
                            mainImg = R.drawable.main_sinon,
                            realNameKR = "아사다 시노",
                            realNameJP = "朝田詩乃",
                            gender = DB.GENDER_FEMALE,
                            birth = "20090821"
                    )
            )
        }
    }

}
