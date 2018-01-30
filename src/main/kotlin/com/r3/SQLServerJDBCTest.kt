package com.r3

import java.sql.DriverManager

fun main(args: Array<String>) {
    val (connectionString, username, password) = args
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
    val conn = DriverManager.getConnection(connectionString, username, password)
    println("connected")
    val statement = conn.createStatement()
    val queryString = "select * from sysobjects where type='u'"
    val rs = statement.executeQuery(queryString)
    while (rs.next()) {
        println(rs.getString(1))
    }
}