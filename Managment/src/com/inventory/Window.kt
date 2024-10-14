package com.inventory

import javax.swing.JFrame

open class Window(title: String) : JFrame(title){
    private val screenHeight = 400
    private val screenWidth = screenHeight * 2
    fun active(){
        setSize(screenWidth,screenHeight)
        isVisible = true
    }
}