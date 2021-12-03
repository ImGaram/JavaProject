package com.example.word.Room

import androidx.room.*
import java.nio.charset.CodingErrorAction.REPLACE


@Dao
interface RoomMemoDAO {
    @Query("select * from room_memo")
    fun getAll() : List<RoomMemo>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo:RoomMemo)

    @Delete
    fun delete(memo:RoomMemo)

}