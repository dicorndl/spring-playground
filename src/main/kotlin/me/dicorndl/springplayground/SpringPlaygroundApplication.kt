package me.dicorndl.springplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class SpringPlaygroundApplication

fun main(args: Array<String>) {
  runApplication<SpringPlaygroundApplication>(*args)
}
