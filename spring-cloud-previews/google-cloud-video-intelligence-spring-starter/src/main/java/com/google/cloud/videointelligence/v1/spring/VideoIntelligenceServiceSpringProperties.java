/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.videointelligence.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for VideoIntelligenceService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties(
    "com.google.cloud.videointelligence.v1.spring.auto.video-intelligence-service")
public class VideoIntelligenceServiceSpringProperties implements CredentialsSupplier {
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");

  private String quotaProjectId;
  private Integer executorThreadCount;
  private boolean useRest = false;
  private Duration annotateVideoInitialRetryDelay;
  private Double annotateVideoRetryDelayMultiplier;
  private Duration annotateVideoMaxRetryDelay;
  private Duration annotateVideoInitialRpcTimeout;
  private Double annotateVideoRpcTimeoutMultiplier;
  private Duration annotateVideoMaxRpcTimeout;
  private Duration annotateVideoTotalTimeout;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  public void setQuotaProjectId(String quotaProjectId) {
    this.quotaProjectId = quotaProjectId;
  }

  public boolean getUseRest() {
    return this.useRest;
  }

  public void setUseRest(boolean useRest) {
    this.useRest = useRest;
  }

  public Integer getExecutorThreadCount() {
    return this.executorThreadCount;
  }

  public void setExecutorThreadCount(Integer executorThreadCount) {
    this.executorThreadCount = executorThreadCount;
  }

  public Duration getAnnotateVideoInitialRetryDelay() {
    return this.annotateVideoInitialRetryDelay;
  }

  public void setAnnotateVideoInitialRetryDelay(java.time.Duration annotateVideoInitialRetryDelay) {
    this.annotateVideoInitialRetryDelay = Duration.parse(annotateVideoInitialRetryDelay.toString());
  }

  public Double getAnnotateVideoRetryDelayMultiplier() {
    return this.annotateVideoRetryDelayMultiplier;
  }

  public void setAnnotateVideoRetryDelayMultiplier(Double annotateVideoRetryDelayMultiplier) {
    this.annotateVideoRetryDelayMultiplier = annotateVideoRetryDelayMultiplier;
  }

  public Duration getAnnotateVideoMaxRetryDelay() {
    return this.annotateVideoMaxRetryDelay;
  }

  public void setAnnotateVideoMaxRetryDelay(java.time.Duration annotateVideoMaxRetryDelay) {
    this.annotateVideoMaxRetryDelay = Duration.parse(annotateVideoMaxRetryDelay.toString());
  }

  public Duration getAnnotateVideoInitialRpcTimeout() {
    return this.annotateVideoInitialRpcTimeout;
  }

  public void setAnnotateVideoInitialRpcTimeout(java.time.Duration annotateVideoInitialRpcTimeout) {
    this.annotateVideoInitialRpcTimeout = Duration.parse(annotateVideoInitialRpcTimeout.toString());
  }

  public Double getAnnotateVideoRpcTimeoutMultiplier() {
    return this.annotateVideoRpcTimeoutMultiplier;
  }

  public void setAnnotateVideoRpcTimeoutMultiplier(Double annotateVideoRpcTimeoutMultiplier) {
    this.annotateVideoRpcTimeoutMultiplier = annotateVideoRpcTimeoutMultiplier;
  }

  public Duration getAnnotateVideoMaxRpcTimeout() {
    return this.annotateVideoMaxRpcTimeout;
  }

  public void setAnnotateVideoMaxRpcTimeout(java.time.Duration annotateVideoMaxRpcTimeout) {
    this.annotateVideoMaxRpcTimeout = Duration.parse(annotateVideoMaxRpcTimeout.toString());
  }

  public Duration getAnnotateVideoTotalTimeout() {
    return this.annotateVideoTotalTimeout;
  }

  public void setAnnotateVideoTotalTimeout(java.time.Duration annotateVideoTotalTimeout) {
    this.annotateVideoTotalTimeout = Duration.parse(annotateVideoTotalTimeout.toString());
  }
}
