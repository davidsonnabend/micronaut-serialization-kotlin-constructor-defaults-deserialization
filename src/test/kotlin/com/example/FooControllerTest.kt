package com.example

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import java.time.LocalDate

@MicronautTest
class FooControllerTest(@Client("/") val client: HttpClient) : ShouldSpec({

    should("return deserialized foo with default value for 'validFrom'") {
        val request: HttpRequest<Any> = HttpRequest.POST("/foos", "{\"bar\": \"some_value\"}")
        val body = client.toBlocking().retrieve(request)

        body shouldNotBe null
        body shouldContain "\"validFrom\":\"${LocalDate.now()}\""
    }

    should("return deserialized foo with provided value for 'validFrom'") {
        val request: HttpRequest<Any> = HttpRequest.POST(
            "/foos",
            "{\"bar\": \"some_value\", \"validFrom\": \"2023-11-10\"}"
        )

        val body = client.toBlocking().retrieve(request)

        body shouldNotBe null
        body shouldContain "\"validFrom\":\"2023-11-10\""
    }
})
