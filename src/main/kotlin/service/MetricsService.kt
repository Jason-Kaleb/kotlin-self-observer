package com.example.service

object MetricsService {
    private val startTime = System.currentTimeMillis()

    fun getUptimeSeconds(): Long {
        return (System.currentTimeMillis() - startTime) / 1000
    }
}