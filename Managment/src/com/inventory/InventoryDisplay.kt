package com.inventory

import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTable
import javax.swing.table.DefaultTableModel


class InventoryDisplay(title: String?, inventoryList: InventoryList) : JFrame(title) {
    private var inventoryTable: JTable? = null
    private var tableModel: DefaultTableModel? = null

    init {
        setupTable(inventoryList)
        setupFrame()
    }

    private fun setupTable(inventoryList: InventoryList) {
        val columnNames = arrayOf("Name", "Quantity", "Price")
        tableModel = DefaultTableModel(columnNames, 0)
        inventoryTable = JTable(tableModel)

        // Load inventory items into the table
        loadInventory(inventoryList.getItems())

        // Add the table to a scroll pane
        val scrollPane = JScrollPane(inventoryTable)
        add(scrollPane, BorderLayout.CENTER)
    }

    private fun loadInventory(items: List<InventoryItem>) {
        tableModel!!.rowCount = 0 // Clear existing rows
        for ((name, quantity, price) in items) {
            val row = arrayOf<Any>(name, quantity, price)
            tableModel!!.addRow(row)
        }
    }

    private fun setupFrame() {
        defaultCloseOperation = DISPOSE_ON_CLOSE
        setSize(400, 300)
        setLocationRelativeTo(null)
        isVisible = true
    }
}
