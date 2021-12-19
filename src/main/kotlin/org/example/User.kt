package org.example

class User constructor(str: String) {
    val userId: String = str.split("->")[0].trim()
    val emails: MutableSet<String> = splitEmail(str)

    fun checkEquals(user: User): Boolean {
        return emails.filter{ email -> user.emails.contains(email) }.any()
    }

    fun splitEmail(str: String): MutableSet<String> {
        val stringList = str.split("->")[1].split(",")
        val emailsList : MutableSet<String> = HashSet()
        for (email: String in stringList){
            emailsList.add(email.trim())
        }
        return emailsList
    }

    fun addMail(newEmails: MutableSet<String>) {
        emails.addAll(newEmails)
    }

    override fun toString(): String {
        return "${userId} -> ${emails.joinToString(separator = ", ")}"
    }
}