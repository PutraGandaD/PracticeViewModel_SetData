package com.putragandad.practiceviewmodel.data

import com.putragandad.practiceviewmodel.models.Item

object Constant {
    fun itemConstantData() : ArrayList<Item> {
        val item = ArrayList<Item>()

        val item1 = Item("Item 1", "This is Item 1")
        val item2 = Item("Item 2", "This is Item 2")
        val item3 = Item("Item 3", "This is Item 3")

        item.add(item1)
        item.add(item2)
        item.add(item3)

        return item
    }
}