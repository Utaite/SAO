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
                            mainImg = R.drawable._main_kirito,
                            realNameKR = "키리가야 카즈토",
                            realNameJP = "桐ヶ谷和人",
                            gender = DB.GENDER_MALE,
                            birth = "20081007",
                            keyword = listOf("냉정", "도전", "무모"),
                            moreUri = "%ED%82%A4%EB%A6%AC%ED%86%A0(%EC%86%8C%EB%93%9C%20%EC%95%84%ED%8A%B8%20%EC%98%A8%EB%9D%BC%EC%9D%B8)",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%ED%82%A4%EB%A6%AC%ED%86%A0&source=lnms&tbm=isch&sa=X&ved=0ahUKEwj6_L-Iio7VAhWFsJQKHSWPAmwQ_AUICigB&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "아스나",
                            nickNameJP = "アスナ",
                            mainImg = R.drawable._main_asuna,
                            realNameKR = "유우키 아스나",
                            realNameJP = "結城明日奈",
                            gender = DB.GENDER_FEMALE,
                            birth = "20070930",
                            keyword = listOf("따뜻", "상냥", "성숙"),
                            moreUri = "%EC%95%84%EC%8A%A4%EB%82%98(%EC%86%8C%EB%93%9C%20%EC%95%84%ED%8A%B8%20%EC%98%A8%EB%9D%BC%EC%9D%B8)",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%95%84%EC%8A%A4%EB%82%98&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjg0q-yio7VAhWIH5QKHRErBWcQ_AUICigB&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "유이",
                            nickNameJP = "ユイ",
                            mainImg = R.drawable._main_yui,
                            realNameKR = "",
                            realNameJP = "",
                            gender = DB.GENDER_FEMALE,
                            birth = "20081007",
                            keyword = listOf("소망", "순수", "희망"),
                            moreUri = "%EC%9C%A0%EC%9D%B4(%EC%86%8C%EB%93%9C%20%EC%95%84%ED%8A%B8%20%EC%98%A8%EB%9D%BC%EC%9D%B8)",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%9C%A0%EC%9D%B4&source=lnms&tbm=isch&sa=X&ved=0ahUKEwj8gIfBio7VAhVCsJQKHYccAhMQ_AUICigB&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "사치",
                            nickNameJP = "サチ",
                            mainImg = R.drawable._main_sachi,
                            realNameKR = "",
                            realNameJP = "",
                            gender = DB.GENDER_FEMALE,
                            birth = "",
                            keyword = listOf("위로", "책임", "희생"),
                            moreUri = "%EC%82%AC%EC%B9%98(%EC%86%8C%EB%93%9C%20%EC%95%84%ED%8A%B8%20%EC%98%A8%EB%9D%BC%EC%9D%B8)",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%82%AC%EC%B9%98&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjZ-f7Mio7VAhUDH5QKHbnvDvEQ_AUICygC&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "클라인",
                            nickNameJP = "クライン",
                            mainImg = R.drawable._main_klein,
                            realNameKR = "츠보이 료타로",
                            realNameJP = "壷井遼太郎",
                            gender = DB.GENDER_MALE,
                            birth = "",
                            keyword = listOf("믿음", "우정", "유쾌"),
                            moreUri = "%ED%81%B4%EB%9D%BC%EC%9D%B8(%EC%86%8C%EB%93%9C%20%EC%95%84%ED%8A%B8%20%EC%98%A8%EB%9D%BC%EC%9D%B8)",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%ED%81%B4%EB%9D%BC%EC%9D%B8&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjgkfjWio7VAhUFpZQKHTypDswQ_AUICigB&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "리즈벳",
                            nickNameJP = "リズベット",
                            mainImg = R.drawable._main_lisbeth,
                            realNameKR = "시노자키 리카",
                            realNameJP = "篠崎里香",
                            gender = DB.GENDER_FEMALE,
                            birth = "",
                            keyword = listOf("도움", "성장", "솔직"),
                            moreUri = "%EB%A6%AC%EC%A6%88%EB%B2%B3",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EB%A6%AC%EC%A6%88%EB%B2%B3&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjslMbeio7VAhUBP5QKHYnxBukQ_AUICigB&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "시리카",
                            nickNameJP = "シリカ",
                            mainImg = R.drawable._main_silica,
                            realNameKR = "아야노 케이코",
                            realNameJP = "綾野珪子",
                            gender = DB.GENDER_FEMALE,
                            birth = "20101004",
                            keyword = listOf("긍정", "소심", "애정"),
                            moreUri = "%EC%8B%9C%EB%A6%AC%EC%B9%B4",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%8B%9C%EB%A6%AC%EC%B9%B4&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi3r43nio7VAhXCrJQKHcOCC4EQ_AUICigB&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "에길",
                            nickNameJP = "エギル",
                            mainImg = R.drawable._main_agil,
                            realNameKR = "앤드루 길버트 밀즈",
                            realNameJP = "アンドリュー・ギルバート・ミルズ",
                            gender = DB.GENDER_MALE,
                            birth = "",
                            keyword = listOf("도움", "성실", "이해"),
                            moreUri = "%EC%97%90%EA%B8%B8",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%97%90%EA%B8%B8&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjVxvHvio7VAhVFkJQKHfX1CfsQ_AUICygC&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "히스클리프",
                            nickNameJP = "ヒースクリフ",
                            mainImg = R.drawable._main_heathcliff,
                            realNameKR = "카야바 아키히코",
                            realNameJP = "茅場晶彦",
                            gender = DB.GENDER_MALE,
                            birth = "",
                            keyword = listOf("리더십", "신뢰", "카리스마"),
                            moreUri = "%ED%9E%88%EC%8A%A4%ED%81%B4%EB%A6%AC%ED%94%84(%EC%86%8C%EB%93%9C%20%EC%95%84%ED%8A%B8%20%EC%98%A8%EB%9D%BC%EC%9D%B8)",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%ED%9E%88%EC%8A%A4%ED%81%B4%EB%A6%AC%ED%94%84&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjpq9H4io7VAhXDkJQKHXJFDnQQ_AUICygC&biw=1224&bih=707"
                    )
            )
        }

        bind<MutableList<MainItem>>("ALO") with singleton {
            mutableListOf(
                    MainItem(
                            nickNameKR = "리파",
                            nickNameJP = "リーファ",
                            mainImg = R.drawable._main_leafa,
                            realNameKR = "키리가야 스구하",
                            realNameJP = "桐ヶ谷直葉",
                            gender = DB.GENDER_FEMALE,
                            birth = "20090419",
                            keyword = listOf("비운", "성실", "애정"),
                            moreUri = "%EB%A6%AC%ED%8C%8C",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EB%A6%AC%ED%8C%8C&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjE97CFi47VAhWDGZQKHY8YCEgQ_AUICigB&biw=1224&bih=707"
                    ),
                    MainItem(
                            nickNameKR = "유우키",
                            nickNameJP = "ユウキ",
                            mainImg = R.drawable._main_yuuki,
                            realNameKR = "콘노 유우키",
                            realNameJP = "紺野木綿季",
                            gender = DB.GENDER_FEMALE,
                            birth = "20100523",
                            keyword = listOf("애틋", "친구", "활발"),
                            moreUri = "%EC%9C%A0%EC%9A%B0%ED%82%A4(%EC%86%8C%EB%93%9C%20%EC%95%84%ED%8A%B8%20%EC%98%A8%EB%9D%BC%EC%9D%B8)",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%9C%A0%EC%9A%B0%ED%82%A4&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi5sJSMi47VAhVGJZQKHRBwDw0Q_AUICigB"
                    )
            )
        }

        bind<MutableList<MainItem>>("GGO") with singleton {
            mutableListOf(
                    MainItem(
                            nickNameKR = "시논",
                            nickNameJP = "シノン",
                            mainImg = R.drawable._main_sinon,
                            realNameKR = "아사다 시노",
                            realNameJP = "朝田詩乃",
                            gender = DB.GENDER_FEMALE,
                            birth = "20090821",
                            keyword = listOf("과묵", "불안", "여린"),
                            moreUri = "%EC%8B%9C%EB%85%BC",
                            imgUri = "%EC%86%8C%EB%93%9C%EC%95%84%ED%8A%B8%EC%98%A8%EB%9D%BC%EC%9D%B8+%EC%8B%9C%EB%85%BC&source=lnms&tbm=isch&sa=X&ved=0ahUKEwj44JKSi47VAhUDF5QKHfOuAUMQ_AUICigB&biw=1224&bih=707"
                    )
            )
        }
    }

}
