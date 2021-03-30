package uz.micro.star.davrpay.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Example(
    @PrimaryKey
    var id: Int,
    var name: String
)