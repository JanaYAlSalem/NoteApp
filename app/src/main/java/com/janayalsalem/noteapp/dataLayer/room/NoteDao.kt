package com.janayalsalem.noteapp.dataLayer.room

import androidx.room.*
import com.janayalsalem.noteapp.dataLayer.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * from notes_table")
    fun getNotes():
            Flow<List<Note>>

    @Query("SELECT * from notes_table where id =:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from notes_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)


}