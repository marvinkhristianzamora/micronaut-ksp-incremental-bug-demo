package demo

import io.micronaut.aop.Around
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.Introduction
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import jakarta.inject.Singleton

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@Around
annotation class CustomAnnotation

@Singleton
@Introduction
@InterceptorBean(CustomAnnotation::class)
open class CustomAnnotationInterceptor : MethodInterceptor<Any, Any> {

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        return try {
            context.proceed()
        } catch (e: Throwable) {
            println("Error occurred!")
            throw e
        }
    }
}
