package com.planday.newsapp.navigation.host

import android.util.Base64
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.planday.extension.empty

val moshi: Moshi = Moshi.Builder().build()

internal val hostAdapter = moshi.adapter(Host::class.java)

@JsonClass(generateAdapter = true)
data class Host(
    var route: String,
    val title: String = String.empty,
    val type: HostType = HostType.DEFAULT,
    val showSearchBar: Boolean = false,
    val backPressStrategy: BackPressStrategy = BackPressStrategy.POP_BACKSTACK
)

fun Host?.actualType(): HostType = this?.type ?: HostType.DEFAULT

fun Host?.showTopAppBar(): Boolean = this?.type?.showAppBar ?: false

fun Host?.isSubHost(): Boolean = this.actualType() == HostType.SUB

fun Host.compress(): String = hostAdapter.toJson(this)

fun String.extractHost(): Host? = hostAdapter.fromJson(this)

// path/{param}
fun Host.acceptParam(param: String): Host = apply {
    route = StringBuilder().apply {
        append(route)
        append("/{")
        append(param)
        append("}")
    }.toString()
}

inline fun <reified T> Host.withData(data: T?): String {
    return route.plus(moshi.adapter(T::class.java).toJson(data))
}

inline fun <reified T> Host.withEncodedData(data: T?): String {
    val json = moshi.adapter(T::class.java).toJson(data)
    val encodedByteArray = Base64.encode(json.toByteArray(Charsets.UTF_8), Base64.DEFAULT)
    return route.plus(String(encodedByteArray))
}