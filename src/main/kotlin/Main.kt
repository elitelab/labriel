package io.runelab

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.github.michaelbull.logging.InlineLogger
import org.flywaydb.core.Flyway

val logger = InlineLogger()

fun main() {
    val env = System.getenv("env") ?: "dev"
    val discordToken =
        System.getenv("discord_token")
            ?: run {
                logger.error {
                    "Please set the environment variable 'discord_token' to your bot's token."
                }
                return
            }
    val database = "jdbc:sqlite:./data/discordbot.db"
    Flyway.configure().dataSource(database, "", "").load().run { migrate() }
    val driver = JdbcSqliteDriver(database)
    Bot(env, discordToken, driver).run()
}
