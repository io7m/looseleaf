/*
 * Copyright © 2023 Mark Raynsford <code@io7m.com> https://www.io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.looseleaf.server.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

/**
 * Configuration information for OpenTelemetry.
 *
 * @param logicalServiceName The logical service name
 * @param logs               The configuration for OTLP logs
 * @param metrics            The configuration for OTLP metrics
 * @param traces             The configuration for OTLP traces
 */

@JsonDeserialize
@JsonSerialize
public record LLTelemetryConfiguration(
  @JsonProperty(value = "logicalServiceName", required = true)
  String logicalServiceName,
  @JsonProperty(value = "logs", required = false)
  Optional<LLLogs> logs,
  @JsonProperty(value = "metrics", required = false)
  Optional<LLMetrics> metrics,
  @JsonProperty(value = "traces", required = false)
  Optional<LLTraces> traces)
{
  /**
   * Configuration information for OpenTelemetry.
   *
   * @param logicalServiceName The logical service name
   * @param logs               The configuration for OTLP logs
   * @param metrics            The configuration for OTLP metrics
   * @param traces             The configuration for OTLP traces
   */

  public LLTelemetryConfiguration
  {
    Objects.requireNonNull(logicalServiceName, "logicalServiceName");
    Objects.requireNonNull(logs, "logs");
    Objects.requireNonNull(metrics, "metrics");
    Objects.requireNonNull(traces, "traces");
  }

  /**
   * The protocol used to deliver OpenTelemetry data.
   */

  @JsonDeserialize
  @JsonSerialize
  public enum LLOTLPProtocol
  {
    /**
     * gRPC
     */

    GRPC,

    /**
     * HTTP(s)
     */

    HTTP
  }

  /**
   * Metrics configuration.
   *
   * @param endpoint The endpoint to which OTLP metrics data will be sent.
   * @param protocol The protocol used to deliver OpenTelemetry data.
   */

  @JsonDeserialize
  @JsonSerialize
  public record LLMetrics(
    @JsonProperty("endpoint")
    URI endpoint,
    @JsonProperty("protocol")
    LLOTLPProtocol protocol)
  {
    /**
     * Metrics configuration.
     */

    public LLMetrics
    {
      Objects.requireNonNull(endpoint, "endpoint");
      Objects.requireNonNull(protocol, "protocol");
    }
  }

  /**
   * Trace configuration.
   *
   * @param endpoint The endpoint to which OTLP trace data will be sent.
   * @param protocol The protocol used to deliver OpenTelemetry data.
   */

  @JsonDeserialize
  @JsonSerialize
  public record LLTraces(
    @JsonProperty("endpoint")
    URI endpoint,
    @JsonProperty("protocol")
    LLOTLPProtocol protocol)
  {
    /**
     * Trace configuration.
     */

    public LLTraces
    {
      Objects.requireNonNull(endpoint, "endpoint");
      Objects.requireNonNull(protocol, "protocol");
    }
  }

  /**
   * Log configuration.
   *
   * @param endpoint The endpoint to which OTLP log data will be sent.
   * @param protocol The protocol used to deliver OpenTelemetry data.
   */

  @JsonDeserialize
  @JsonSerialize
  public record LLLogs(
    @JsonProperty("endpoint")
    URI endpoint,
    @JsonProperty("protocol")
    LLOTLPProtocol protocol)
  {
    /**
     * Log configuration.
     */

    public LLLogs
    {
      Objects.requireNonNull(endpoint, "endpoint");
      Objects.requireNonNull(protocol, "protocol");
    }
  }
}
