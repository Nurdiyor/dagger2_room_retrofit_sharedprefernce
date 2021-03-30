package uz.micro.star.davrpay.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [
        Example::class
    ], version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getInputData(): AppDao
}