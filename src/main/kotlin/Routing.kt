package com.example

import com.example.service.MetricsService
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

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
