package com.utaite.sao.view.app.module

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.lazy
import com.github.salomonbrys.kodein.singleton
import com.utaite.sao.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class AppModule(val app: Application) {

    val module = Kodein.lazy {
        bind<CalligraphyConfig>() with singleton {
            CalligraphyConfig.Builder()
                    .setDefaultFontPath(app.getString(R.string.font_nanum_gothic))
                    .setFontAttrId(R.attr.fontPath)
                    .build()
        }
    }

}
