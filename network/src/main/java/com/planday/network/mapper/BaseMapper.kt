package com.planday.network.mapper

interface BaseMapper<Remote, Local> {
    fun map(remote: Remote): Local
}