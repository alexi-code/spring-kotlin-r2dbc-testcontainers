package com.matcher.server

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.TestPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.PostgreSQLR2DBCDatabaseContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.MountableFile

@TestPropertySource("classpath:application-test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ServerApplication::class])
@Testcontainers
class MatchingTest {

//	@Value("\${db.user}")
//	private var dbUser: String? = null
//
//	@Value("\${db.password}")
//	private var dbPassword: String? = null
//
//	@Value("\${db.name}")
//	private var dbName: String? = null

	companion object {

		private var dbName: String = "matcherDBName"
		private var dbPassword: String = "matcherDBPassword"
		private var dbUser: String? = "matcherDBUser"

		private val postgresqlContainer = PostgreSQLContainer<Nothing>("postgres:13.3-alpine")
		private lateinit var postgresqlR2DBCContainer: PostgreSQLR2DBCDatabaseContainer

		@JvmStatic
		@DynamicPropertySource
		fun properties(registry: DynamicPropertyRegistry) {
			postgresqlContainer.addEnv("POSTGRES_USER", dbUser)
			postgresqlContainer.addEnv("POSTGRES_PASSWORD", dbPassword)
			postgresqlContainer.addEnv("POSTGRES_DB", dbName)
			postgresqlContainer.start()
			postgresqlContainer.copyFileToContainer(
				MountableFile.forClasspathResource("postgresql-entry-init.sh") , "/docker-entrypoint-initdb.d/")
			val path = "postgresql://" + postgresqlContainer.host + ":" + postgresqlContainer.getMappedPort(5432) + "/" + dbName
			registry.add("spring.r2dbc.url") { "r2dbc:tc:$path" }
			registry.add("spring.liquibase.url") { "jdbc:$path" }
			postgresqlR2DBCContainer = PostgreSQLR2DBCDatabaseContainer(postgresqlContainer)
			System.out.println("123321")
		}

		@BeforeAll
		fun beforeAll() {
			System.out.println("Hooray!")
		}

		@AfterAll
		fun afterAll() {
			postgresqlContainer.stop()
		}
	}

	@Test
	fun contextLoads() {

	}

}
