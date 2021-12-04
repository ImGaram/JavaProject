package com.example.word.Room

import androidx.room.Database
import androidx.room.RoomDatabase

// 데이터베이스 클래스
@Database(entities = arrayOf(RoomMemo::class), version = 1, exportSchema = false)
abstract class RoomHelper : RoomDatabase() {
    abstract fun roomMemoDao(): RoomMemoDAO
}