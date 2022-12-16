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

package com.google.protos.google.cloud.binaryauthorization.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for BinauthzManagementServiceV1 client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties(
    "com.google.protos.google.cloud.binaryauthorization.v1.spring.auto.binauthz-management-service-v1")
public class BinauthzManagementServiceV1SpringProperties implements CredentialsSupplier {
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");

  private String quotaProjectId;
  private Integer executorThreadCount;
  private boolean useRest = false;
  private Duration getPolicyInitialRetryDelay;
  private Double getPolicyRetryDelayMultiplier;
  private Duration getPolicyMaxRetryDelay;
  private Duration getPolicyInitialRpcTimeout;
  private Double getPolicyRpcTimeoutMultiplier;
  private Duration getPolicyMaxRpcTimeout;
  private Duration getPolicyTotalTimeout;
  private Duration updatePolicyInitialRetryDelay;
  private Double updatePolicyRetryDelayMultiplier;
  private Duration updatePolicyMaxRetryDelay;
  private Duration updatePolicyInitialRpcTimeout;
  private Double updatePolicyRpcTimeoutMultiplier;
  private Duration updatePolicyMaxRpcTimeout;
  private Duration updatePolicyTotalTimeout;
  private Duration createAttestorInitialRpcTimeout;
  private Double createAttestorRpcTimeoutMultiplier;
  private Duration createAttestorMaxRpcTimeout;
  private Duration createAttestorTotalTimeout;
  private Duration getAttestorInitialRetryDelay;
  private Double getAttestorRetryDelayMultiplier;
  private Duration getAttestorMaxRetryDelay;
  private Duration getAttestorInitialRpcTimeout;
  private Double getAttestorRpcTimeoutMultiplier;
  private Duration getAttestorMaxRpcTimeout;
  private Duration getAttestorTotalTimeout;
  private Duration updateAttestorInitialRetryDelay;
  private Double updateAttestorRetryDelayMultiplier;
  private Duration updateAttestorMaxRetryDelay;
  private Duration updateAttestorInitialRpcTimeout;
  private Double updateAttestorRpcTimeoutMultiplier;
  private Duration updateAttestorMaxRpcTimeout;
  private Duration updateAttestorTotalTimeout;
  private Duration listAttestorsInitialRetryDelay;
  private Double listAttestorsRetryDelayMultiplier;
  private Duration listAttestorsMaxRetryDelay;
  private Duration listAttestorsInitialRpcTimeout;
  private Double listAttestorsRpcTimeoutMultiplier;
  private Duration listAttestorsMaxRpcTimeout;
  private Duration listAttestorsTotalTimeout;
  private Duration deleteAttestorInitialRetryDelay;
  private Double deleteAttestorRetryDelayMultiplier;
  private Duration deleteAttestorMaxRetryDelay;
  private Duration deleteAttestorInitialRpcTimeout;
  private Double deleteAttestorRpcTimeoutMultiplier;
  private Duration deleteAttestorMaxRpcTimeout;
  private Duration deleteAttestorTotalTimeout;

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

  public Duration getGetPolicyInitialRetryDelay() {
    return this.getPolicyInitialRetryDelay;
  }

  public void setGetPolicyInitialRetryDelay(java.time.Duration getPolicyInitialRetryDelay) {
    this.getPolicyInitialRetryDelay = Duration.parse(getPolicyInitialRetryDelay.toString());
  }

  public Double getGetPolicyRetryDelayMultiplier() {
    return this.getPolicyRetryDelayMultiplier;
  }

  public void setGetPolicyRetryDelayMultiplier(Double getPolicyRetryDelayMultiplier) {
    this.getPolicyRetryDelayMultiplier = getPolicyRetryDelayMultiplier;
  }

  public Duration getGetPolicyMaxRetryDelay() {
    return this.getPolicyMaxRetryDelay;
  }

  public void setGetPolicyMaxRetryDelay(java.time.Duration getPolicyMaxRetryDelay) {
    this.getPolicyMaxRetryDelay = Duration.parse(getPolicyMaxRetryDelay.toString());
  }

  public Duration getGetPolicyInitialRpcTimeout() {
    return this.getPolicyInitialRpcTimeout;
  }

  public void setGetPolicyInitialRpcTimeout(java.time.Duration getPolicyInitialRpcTimeout) {
    this.getPolicyInitialRpcTimeout = Duration.parse(getPolicyInitialRpcTimeout.toString());
  }

  public Double getGetPolicyRpcTimeoutMultiplier() {
    return this.getPolicyRpcTimeoutMultiplier;
  }

  public void setGetPolicyRpcTimeoutMultiplier(Double getPolicyRpcTimeoutMultiplier) {
    this.getPolicyRpcTimeoutMultiplier = getPolicyRpcTimeoutMultiplier;
  }

  public Duration getGetPolicyMaxRpcTimeout() {
    return this.getPolicyMaxRpcTimeout;
  }

  public void setGetPolicyMaxRpcTimeout(java.time.Duration getPolicyMaxRpcTimeout) {
    this.getPolicyMaxRpcTimeout = Duration.parse(getPolicyMaxRpcTimeout.toString());
  }

  public Duration getGetPolicyTotalTimeout() {
    return this.getPolicyTotalTimeout;
  }

  public void setGetPolicyTotalTimeout(java.time.Duration getPolicyTotalTimeout) {
    this.getPolicyTotalTimeout = Duration.parse(getPolicyTotalTimeout.toString());
  }

  public Duration getUpdatePolicyInitialRetryDelay() {
    return this.updatePolicyInitialRetryDelay;
  }

  public void setUpdatePolicyInitialRetryDelay(java.time.Duration updatePolicyInitialRetryDelay) {
    this.updatePolicyInitialRetryDelay = Duration.parse(updatePolicyInitialRetryDelay.toString());
  }

  public Double getUpdatePolicyRetryDelayMultiplier() {
    return this.updatePolicyRetryDelayMultiplier;
  }

  public void setUpdatePolicyRetryDelayMultiplier(Double updatePolicyRetryDelayMultiplier) {
    this.updatePolicyRetryDelayMultiplier = updatePolicyRetryDelayMultiplier;
  }

  public Duration getUpdatePolicyMaxRetryDelay() {
    return this.updatePolicyMaxRetryDelay;
  }

  public void setUpdatePolicyMaxRetryDelay(java.time.Duration updatePolicyMaxRetryDelay) {
    this.updatePolicyMaxRetryDelay = Duration.parse(updatePolicyMaxRetryDelay.toString());
  }

  public Duration getUpdatePolicyInitialRpcTimeout() {
    return this.updatePolicyInitialRpcTimeout;
  }

  public void setUpdatePolicyInitialRpcTimeout(java.time.Duration updatePolicyInitialRpcTimeout) {
    this.updatePolicyInitialRpcTimeout = Duration.parse(updatePolicyInitialRpcTimeout.toString());
  }

  public Double getUpdatePolicyRpcTimeoutMultiplier() {
    return this.updatePolicyRpcTimeoutMultiplier;
  }

  public void setUpdatePolicyRpcTimeoutMultiplier(Double updatePolicyRpcTimeoutMultiplier) {
    this.updatePolicyRpcTimeoutMultiplier = updatePolicyRpcTimeoutMultiplier;
  }

  public Duration getUpdatePolicyMaxRpcTimeout() {
    return this.updatePolicyMaxRpcTimeout;
  }

  public void setUpdatePolicyMaxRpcTimeout(java.time.Duration updatePolicyMaxRpcTimeout) {
    this.updatePolicyMaxRpcTimeout = Duration.parse(updatePolicyMaxRpcTimeout.toString());
  }

  public Duration getUpdatePolicyTotalTimeout() {
    return this.updatePolicyTotalTimeout;
  }

  public void setUpdatePolicyTotalTimeout(java.time.Duration updatePolicyTotalTimeout) {
    this.updatePolicyTotalTimeout = Duration.parse(updatePolicyTotalTimeout.toString());
  }

  public Duration getCreateAttestorInitialRpcTimeout() {
    return this.createAttestorInitialRpcTimeout;
  }

  public void setCreateAttestorInitialRpcTimeout(
      java.time.Duration createAttestorInitialRpcTimeout) {
    this.createAttestorInitialRpcTimeout =
        Duration.parse(createAttestorInitialRpcTimeout.toString());
  }

  public Double getCreateAttestorRpcTimeoutMultiplier() {
    return this.createAttestorRpcTimeoutMultiplier;
  }

  public void setCreateAttestorRpcTimeoutMultiplier(Double createAttestorRpcTimeoutMultiplier) {
    this.createAttestorRpcTimeoutMultiplier = createAttestorRpcTimeoutMultiplier;
  }

  public Duration getCreateAttestorMaxRpcTimeout() {
    return this.createAttestorMaxRpcTimeout;
  }

  public void setCreateAttestorMaxRpcTimeout(java.time.Duration createAttestorMaxRpcTimeout) {
    this.createAttestorMaxRpcTimeout = Duration.parse(createAttestorMaxRpcTimeout.toString());
  }

  public Duration getCreateAttestorTotalTimeout() {
    return this.createAttestorTotalTimeout;
  }

  public void setCreateAttestorTotalTimeout(java.time.Duration createAttestorTotalTimeout) {
    this.createAttestorTotalTimeout = Duration.parse(createAttestorTotalTimeout.toString());
  }

  public Duration getGetAttestorInitialRetryDelay() {
    return this.getAttestorInitialRetryDelay;
  }

  public void setGetAttestorInitialRetryDelay(java.time.Duration getAttestorInitialRetryDelay) {
    this.getAttestorInitialRetryDelay = Duration.parse(getAttestorInitialRetryDelay.toString());
  }

  public Double getGetAttestorRetryDelayMultiplier() {
    return this.getAttestorRetryDelayMultiplier;
  }

  public void setGetAttestorRetryDelayMultiplier(Double getAttestorRetryDelayMultiplier) {
    this.getAttestorRetryDelayMultiplier = getAttestorRetryDelayMultiplier;
  }

  public Duration getGetAttestorMaxRetryDelay() {
    return this.getAttestorMaxRetryDelay;
  }

  public void setGetAttestorMaxRetryDelay(java.time.Duration getAttestorMaxRetryDelay) {
    this.getAttestorMaxRetryDelay = Duration.parse(getAttestorMaxRetryDelay.toString());
  }

  public Duration getGetAttestorInitialRpcTimeout() {
    return this.getAttestorInitialRpcTimeout;
  }

  public void setGetAttestorInitialRpcTimeout(java.time.Duration getAttestorInitialRpcTimeout) {
    this.getAttestorInitialRpcTimeout = Duration.parse(getAttestorInitialRpcTimeout.toString());
  }

  public Double getGetAttestorRpcTimeoutMultiplier() {
    return this.getAttestorRpcTimeoutMultiplier;
  }

  public void setGetAttestorRpcTimeoutMultiplier(Double getAttestorRpcTimeoutMultiplier) {
    this.getAttestorRpcTimeoutMultiplier = getAttestorRpcTimeoutMultiplier;
  }

  public Duration getGetAttestorMaxRpcTimeout() {
    return this.getAttestorMaxRpcTimeout;
  }

  public void setGetAttestorMaxRpcTimeout(java.time.Duration getAttestorMaxRpcTimeout) {
    this.getAttestorMaxRpcTimeout = Duration.parse(getAttestorMaxRpcTimeout.toString());
  }

  public Duration getGetAttestorTotalTimeout() {
    return this.getAttestorTotalTimeout;
  }

  public void setGetAttestorTotalTimeout(java.time.Duration getAttestorTotalTimeout) {
    this.getAttestorTotalTimeout = Duration.parse(getAttestorTotalTimeout.toString());
  }

  public Duration getUpdateAttestorInitialRetryDelay() {
    return this.updateAttestorInitialRetryDelay;
  }

  public void setUpdateAttestorInitialRetryDelay(
      java.time.Duration updateAttestorInitialRetryDelay) {
    this.updateAttestorInitialRetryDelay =
        Duration.parse(updateAttestorInitialRetryDelay.toString());
  }

  public Double getUpdateAttestorRetryDelayMultiplier() {
    return this.updateAttestorRetryDelayMultiplier;
  }

  public void setUpdateAttestorRetryDelayMultiplier(Double updateAttestorRetryDelayMultiplier) {
    this.updateAttestorRetryDelayMultiplier = updateAttestorRetryDelayMultiplier;
  }

  public Duration getUpdateAttestorMaxRetryDelay() {
    return this.updateAttestorMaxRetryDelay;
  }

  public void setUpdateAttestorMaxRetryDelay(java.time.Duration updateAttestorMaxRetryDelay) {
    this.updateAttestorMaxRetryDelay = Duration.parse(updateAttestorMaxRetryDelay.toString());
  }

  public Duration getUpdateAttestorInitialRpcTimeout() {
    return this.updateAttestorInitialRpcTimeout;
  }

  public void setUpdateAttestorInitialRpcTimeout(
      java.time.Duration updateAttestorInitialRpcTimeout) {
    this.updateAttestorInitialRpcTimeout =
        Duration.parse(updateAttestorInitialRpcTimeout.toString());
  }

  public Double getUpdateAttestorRpcTimeoutMultiplier() {
    return this.updateAttestorRpcTimeoutMultiplier;
  }

  public void setUpdateAttestorRpcTimeoutMultiplier(Double updateAttestorRpcTimeoutMultiplier) {
    this.updateAttestorRpcTimeoutMultiplier = updateAttestorRpcTimeoutMultiplier;
  }

  public Duration getUpdateAttestorMaxRpcTimeout() {
    return this.updateAttestorMaxRpcTimeout;
  }

  public void setUpdateAttestorMaxRpcTimeout(java.time.Duration updateAttestorMaxRpcTimeout) {
    this.updateAttestorMaxRpcTimeout = Duration.parse(updateAttestorMaxRpcTimeout.toString());
  }

  public Duration getUpdateAttestorTotalTimeout() {
    return this.updateAttestorTotalTimeout;
  }

  public void setUpdateAttestorTotalTimeout(java.time.Duration updateAttestorTotalTimeout) {
    this.updateAttestorTotalTimeout = Duration.parse(updateAttestorTotalTimeout.toString());
  }

  public Duration getListAttestorsInitialRetryDelay() {
    return this.listAttestorsInitialRetryDelay;
  }

  public void setListAttestorsInitialRetryDelay(java.time.Duration listAttestorsInitialRetryDelay) {
    this.listAttestorsInitialRetryDelay = Duration.parse(listAttestorsInitialRetryDelay.toString());
  }

  public Double getListAttestorsRetryDelayMultiplier() {
    return this.listAttestorsRetryDelayMultiplier;
  }

  public void setListAttestorsRetryDelayMultiplier(Double listAttestorsRetryDelayMultiplier) {
    this.listAttestorsRetryDelayMultiplier = listAttestorsRetryDelayMultiplier;
  }

  public Duration getListAttestorsMaxRetryDelay() {
    return this.listAttestorsMaxRetryDelay;
  }

  public void setListAttestorsMaxRetryDelay(java.time.Duration listAttestorsMaxRetryDelay) {
    this.listAttestorsMaxRetryDelay = Duration.parse(listAttestorsMaxRetryDelay.toString());
  }

  public Duration getListAttestorsInitialRpcTimeout() {
    return this.listAttestorsInitialRpcTimeout;
  }

  public void setListAttestorsInitialRpcTimeout(java.time.Duration listAttestorsInitialRpcTimeout) {
    this.listAttestorsInitialRpcTimeout = Duration.parse(listAttestorsInitialRpcTimeout.toString());
  }

  public Double getListAttestorsRpcTimeoutMultiplier() {
    return this.listAttestorsRpcTimeoutMultiplier;
  }

  public void setListAttestorsRpcTimeoutMultiplier(Double listAttestorsRpcTimeoutMultiplier) {
    this.listAttestorsRpcTimeoutMultiplier = listAttestorsRpcTimeoutMultiplier;
  }

  public Duration getListAttestorsMaxRpcTimeout() {
    return this.listAttestorsMaxRpcTimeout;
  }

  public void setListAttestorsMaxRpcTimeout(java.time.Duration listAttestorsMaxRpcTimeout) {
    this.listAttestorsMaxRpcTimeout = Duration.parse(listAttestorsMaxRpcTimeout.toString());
  }

  public Duration getListAttestorsTotalTimeout() {
    return this.listAttestorsTotalTimeout;
  }

  public void setListAttestorsTotalTimeout(java.time.Duration listAttestorsTotalTimeout) {
    this.listAttestorsTotalTimeout = Duration.parse(listAttestorsTotalTimeout.toString());
  }

  public Duration getDeleteAttestorInitialRetryDelay() {
    return this.deleteAttestorInitialRetryDelay;
  }

  public void setDeleteAttestorInitialRetryDelay(
      java.time.Duration deleteAttestorInitialRetryDelay) {
    this.deleteAttestorInitialRetryDelay =
        Duration.parse(deleteAttestorInitialRetryDelay.toString());
  }

  public Double getDeleteAttestorRetryDelayMultiplier() {
    return this.deleteAttestorRetryDelayMultiplier;
  }

  public void setDeleteAttestorRetryDelayMultiplier(Double deleteAttestorRetryDelayMultiplier) {
    this.deleteAttestorRetryDelayMultiplier = deleteAttestorRetryDelayMultiplier;
  }

  public Duration getDeleteAttestorMaxRetryDelay() {
    return this.deleteAttestorMaxRetryDelay;
  }

  public void setDeleteAttestorMaxRetryDelay(java.time.Duration deleteAttestorMaxRetryDelay) {
    this.deleteAttestorMaxRetryDelay = Duration.parse(deleteAttestorMaxRetryDelay.toString());
  }

  public Duration getDeleteAttestorInitialRpcTimeout() {
    return this.deleteAttestorInitialRpcTimeout;
  }

  public void setDeleteAttestorInitialRpcTimeout(
      java.time.Duration deleteAttestorInitialRpcTimeout) {
    this.deleteAttestorInitialRpcTimeout =
        Duration.parse(deleteAttestorInitialRpcTimeout.toString());
  }

  public Double getDeleteAttestorRpcTimeoutMultiplier() {
    return this.deleteAttestorRpcTimeoutMultiplier;
  }

  public void setDeleteAttestorRpcTimeoutMultiplier(Double deleteAttestorRpcTimeoutMultiplier) {
    this.deleteAttestorRpcTimeoutMultiplier = deleteAttestorRpcTimeoutMultiplier;
  }

  public Duration getDeleteAttestorMaxRpcTimeout() {
    return this.deleteAttestorMaxRpcTimeout;
  }

  public void setDeleteAttestorMaxRpcTimeout(java.time.Duration deleteAttestorMaxRpcTimeout) {
    this.deleteAttestorMaxRpcTimeout = Duration.parse(deleteAttestorMaxRpcTimeout.toString());
  }

  public Duration getDeleteAttestorTotalTimeout() {
    return this.deleteAttestorTotalTimeout;
  }

  public void setDeleteAttestorTotalTimeout(java.time.Duration deleteAttestorTotalTimeout) {
    this.deleteAttestorTotalTimeout = Duration.parse(deleteAttestorTotalTimeout.toString());
  }
}
