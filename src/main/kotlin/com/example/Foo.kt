package com.example

import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate

@Serdeable
data class Foo(
    val bar: String,
    var validFrom: LocalDate = LocalDate.now(),
)
