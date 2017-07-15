package com.utaite.sao.view.main.fragment.vo


data class MainItem(
        /** Main Fragment */

        // 한국어 닉네임
        val nickNameKR: String = "",

        // 일본어 닉네임
        val nickNameJP: String = "",

        // 메인 이미지
        val mainImg: Int = 0,

        /** Main Info Fragment */

        // 한국어 본명
        val realNameKR: String = "",

        // 일본어 본명
        val realNameJP: String = "",

        /*
        성별
        0: 알 수 없음
        1: 남자
        2: 여자
        */
        val gender: Int = 0,

        // 생년월일
        val birth: String = ""
)
