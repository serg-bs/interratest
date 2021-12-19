package org.example

import org.assertj.core.api.Assertions.*

import org.junit.Test

class HelloTest {

    @Test
    fun compareUserTest() {
        val user1 = User("user3 -> xyz@pisem.net, vasya@pupkin.com")
        val user2 = User("user5 -> xyz@pisem.net")
        assertThat(user1.checkEquals(user2)).isTrue()
    }

    @Test
    fun addEqualUserTest() {
        val user1 = User("user3 -> xyz@pisem.net, vasya@pupkin.com")
        val user2 = User("user5 -> xyz@pisem.net")
        user1.addMail(user2.emails)
        assertThat(user1.emails).containsAll(user2.emails)
        assertThat(user1.emails.size).isGreaterThan(user2.emails.size)
    }

    @Test
    fun test() {
        val hello = Hello
        hello.addUser("user1 -> xxx@ya.ru, foo@gmail.com, lol@mail.ru")
        hello.addUser("user2 -> foo@gmail.com, ups@pisem.net")
        hello.addUser("user3 -> xyz@pisem.net, vasya@pupkin.com")
        hello.addUser("user4 -> ups@pisem.net, aaa@bbb.ru")
        hello.addUser("user5 -> xyz@pisem.net")
        val result: List<User> = hello.getResult()
        assertThat(result.size).isEqualTo(2)
    }

}
