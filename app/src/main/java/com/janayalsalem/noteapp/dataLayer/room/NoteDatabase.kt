package com.janayalsalem.noteapp.dataLayer.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.janayalsalem.noteapp.dataLayer.model.Note
import com.janayalsalem.noteapp.util.DateConverter
import com.janayalsalem.noteapp.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}