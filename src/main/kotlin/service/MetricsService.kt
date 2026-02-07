package com.example.service

import java.util.concurrent.atomic.AtomicLong

object MetricsService {
    private val startTime = System.currentTimeMillis()
    private val totalRequests = AtomicLong(0)

    fun getUptimeSeconds(): Long {
        return (System.currentTimeMillis() - startTime) / 1000
    }

    fun incrementRequests() {
        totalRequests.incrementAndGet()
    }

    fun getTotalRequests(): Long {
        return totalRequests.get()
    }
}