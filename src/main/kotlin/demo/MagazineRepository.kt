package demo

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository // (1)
interface MagazineRepository : CrudRepository<Magazine, Long> { // (2)
    @Executable
    fun find(title: String): Magazine
}