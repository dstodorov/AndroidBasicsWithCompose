package com.dstod.a30daysmotivation.data

import androidx.annotation.StringRes
import com.dstod.a30daysmotivation.R

data class Quote(
    @StringRes val dayNumber: Int,
    @StringRes val title: Int,
    @StringRes val quote: Int,
    @StringRes val author: Int
)

val quotes = listOf(
    Quote(R.string.quote1_day, R.string.quote1_title, R.string.quote1_quote, R.string.quote1_author),
    Quote(R.string.quote2_day, R.string.quote2_title, R.string.quote2_quote, R.string.quote2_author),
    Quote(R.string.quote3_day, R.string.quote3_title, R.string.quote3_quote, R.string.quote3_author),
    Quote(R.string.quote4_day, R.string.quote4_title, R.string.quote4_quote, R.string.quote4_author),
    Quote(R.string.quote5_day, R.string.quote5_title, R.string.quote5_quote, R.string.quote5_author),
    Quote(R.string.quote6_day, R.string.quote6_title, R.string.quote6_quote, R.string.quote6_author),
    Quote(R.string.quote7_day, R.string.quote7_title, R.string.quote7_quote, R.string.quote7_author),
    Quote(R.string.quote8_day, R.string.quote8_title, R.string.quote8_quote, R.string.quote8_author),
    Quote(R.string.quote9_day, R.string.quote9_title, R.string.quote9_quote, R.string.quote9_author),
    Quote(R.string.quote10_day, R.string.quote10_title, R.string.quote10_quote, R.string.quote10_author),
    Quote(R.string.quote11_day, R.string.quote11_title, R.string.quote11_quote, R.string.quote11_author),
    Quote(R.string.quote12_day, R.string.quote12_title, R.string.quote12_quote, R.string.quote12_author),
    Quote(R.string.quote13_day, R.string.quote13_title, R.string.quote13_quote, R.string.quote13_author),
    Quote(R.string.quote14_day, R.string.quote14_title, R.string.quote14_quote, R.string.quote14_author),
    Quote(R.string.quote15_day, R.string.quote15_title, R.string.quote15_quote, R.string.quote15_author),
    Quote(R.string.quote16_day, R.string.quote16_title, R.string.quote16_quote, R.string.quote16_author),
    Quote(R.string.quote17_day, R.string.quote17_title, R.string.quote17_quote, R.string.quote17_author),
    Quote(R.string.quote18_day, R.string.quote18_title, R.string.quote18_quote, R.string.quote18_author),
    Quote(R.string.quote19_day, R.string.quote19_title, R.string.quote19_quote, R.string.quote19_author),
    Quote(R.string.quote20_day, R.string.quote20_title, R.string.quote20_quote, R.string.quote20_author),
    Quote(R.string.quote21_day, R.string.quote21_title, R.string.quote21_quote, R.string.quote21_author),
    Quote(R.string.quote22_day, R.string.quote22_title, R.string.quote22_quote, R.string.quote22_author),
    Quote(R.string.quote23_day, R.string.quote23_title, R.string.quote23_quote, R.string.quote23_author),
    Quote(R.string.quote24_day, R.string.quote24_title, R.string.quote24_quote, R.string.quote24_author),
    Quote(R.string.quote25_day, R.string.quote25_title, R.string.quote25_quote, R.string.quote25_author),
    Quote(R.string.quote26_day, R.string.quote26_title, R.string.quote26_quote, R.string.quote26_author),
    Quote(R.string.quote27_day, R.string.quote27_title, R.string.quote27_quote, R.string.quote27_author),
    Quote(R.string.quote28_day, R.string.quote28_title, R.string.quote28_quote, R.string.quote28_author),
    Quote(R.string.quote29_day, R.string.quote29_title, R.string.quote29_quote, R.string.quote29_author),
    Quote(R.string.quote30_day, R.string.quote30_title, R.string.quote30_quote, R.string.quote30_author),
)