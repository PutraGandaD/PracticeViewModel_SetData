package com.putragandad.practiceviewmodel.utils

import com.putragandad.practiceviewmodel.models.Note

class Constant {
    fun itemConstantData() : ArrayList<Note> {
        val item = ArrayList<Note>()

        val item1 = Note("Item 1", "This is Item 1")
        val item2 = Note("Item 2", "This is Item 2")
        val item3 = Note("Item 3", "This is Item 3")

        item.add(item1)
        item.add(item2)
        item.add(item3)

        return item
    }

    companion object {
        val NOTES_DATA = "NOTES_DATA"
    }
}