package com.julienviet.demos.helloworld1;

import io.vertx.pgclient.PgConnectOptions;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;

public class PostgresServerHelper {

  private final GenericContainer<?> postgres;

  public PostgresServerHelper() {
    postgres = new GenericContainer<>("postgres:17")
      .withEnv("POSTGRES_PASSWORD", "postgres")
      .withExposedPorts(5432)
      .withClasspathResourceMapping("demo.sql", "/docker-entrypoint-initdb.d/create-postgres.sql", BindMode.READ_ONLY);
  }

  public PgConnectOptions startDb() {
    postgres.start();
    return new PgConnectOptions()
      .setPort(postgres.getMappedPort(5432))
      .setHost(postgres.getHost())
      .setDatabase("postgres")
      .setUser("postgres")
      .setPassword("postgres");
  }
}
