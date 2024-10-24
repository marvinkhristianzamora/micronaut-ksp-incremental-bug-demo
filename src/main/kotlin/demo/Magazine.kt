package demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Magazine(
    @Id
    @GeneratedValue
    var id: Long,
    var title: String,
    var pages: Int = 0
)