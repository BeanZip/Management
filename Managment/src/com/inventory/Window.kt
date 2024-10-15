package com.inventory

import javax.swing.JFrame

open class Window(title: String) : JFrame(title) {
    private val screenHeight = 400
    private val screenWidth = screenHeight * 2

    init {
        setupWindow()
    }

    private fun setupWindow() {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(screenWidth, screenHeight)
        setLocationRelativeTo(null) // Center the window
    }

    fun activate() {
        isVisible = true
    }
}
