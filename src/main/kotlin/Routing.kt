package com.example

import com.example.service.MetricsService
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/health") {
            call.respond(mapOf("status" to "UP"))
            MetricsService.incrementRequests()
        }
        get("/uptime") {
            call.respond(mapOf("uptimeSeconds" to MetricsService.getUptimeSeconds()))
            MetricsService.incrementRequests()
        }
        get("/metrics") {
            call.respond(mapOf("totalRequests" to MetricsService.getTotalRequests()))
        }
    }
}
