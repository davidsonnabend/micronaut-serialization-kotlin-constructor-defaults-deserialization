package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/foos")
class FooController {
    @Post
    fun save(@Body foo: Foo): HttpResponse<Foo> {
        return HttpResponse.created(foo)
    }
}
