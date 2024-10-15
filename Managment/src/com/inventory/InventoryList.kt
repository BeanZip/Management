package com.inventory

class InventoryList {
    private val items = mutableListOf<InventoryItem>()

    fun addItem(item: InventoryItem) {
        items.add(item)
    }

    fun removeItem(name: String): Boolean {
        return items.removeIf { it.name.equals(name, ignoreCase = true) }
    }

    fun clearItems() {
        items.clear()
    }

    fun getItems(): List<InventoryItem> {
        return items.toList() // Return a copy to prevent modification
    }

    // Add methods for saving to file, loading from file, etc.
}
