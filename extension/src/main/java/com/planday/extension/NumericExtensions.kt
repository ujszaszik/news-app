package com.planday.extension

fun Number?.isZero(): Boolean = this == 0

fun Number.isNegative(): Boolean = this.toLong() < 0

fun Number.isSmallerThan(other: Number): Boolean = this.toLong() < other.toLong()