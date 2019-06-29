package com.merricklabs.sparksandbox

import spark.Spark

object SparkResources {
    fun defineResources() {
        Spark.get("/hello") { _, _ -> "Hello World" }
    }
}