package org.example

import java.util.*


object Hello {
    val userList: MutableList<User> = ArrayList()

    fun addUser(str: String) {
        val user = User(str)
        val first = userList.filter { u -> u.checkEquals(user) }.firstOrNull()
        if ( first != null) {
            first.addMail(user.emails)
        } else {
            userList.add(user)
        }
    }

    fun getResult(): List<User> {
        return userList
    }
}

fun main(args: Array<String>) {
    println("Hello, World")
    val scanner = Scanner(System.`in`)
    val hello = Hello

    scanner.use {
        while (scanner.hasNextLine()) {
            val str = scanner.nextLine()
            if(str.isEmpty() ){
                printResult(hello)
                return
            }
            hello.addUser(str)
        }
    }

}

private fun printResult(hello: Hello) {
    val result = hello.getResult()
    for (item in result) {
        System.out.println(item.toString())
    }
}

