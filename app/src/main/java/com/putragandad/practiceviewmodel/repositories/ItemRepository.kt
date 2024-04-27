package com.putragandad.practiceviewmodel.repositories

import com.putragandad.practiceviewmodel.utils.Constant
import com.putragandad.practiceviewmodel.models.Item

object ItemRepository {
    fun getItemData() : ArrayList<Item> {
        return Constant.itemConstantData()
    }
}