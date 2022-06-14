package com.example.demo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "resources")
data class ResourcesBean(var db: String = "", var logs: String = "", var secure: Boolean = true)