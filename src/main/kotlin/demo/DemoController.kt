package demo

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/public")
@ExecuteOn(TaskExecutors.BLOCKING)
class DemoController(val bookRepository: BookRepository) {

    @Get("/get")
    fun demo(): MutableHttpResponse<out Any>? {
        val result = bookRepository.findAll()
        return HttpResponse.ok(result.size)
    }
}
