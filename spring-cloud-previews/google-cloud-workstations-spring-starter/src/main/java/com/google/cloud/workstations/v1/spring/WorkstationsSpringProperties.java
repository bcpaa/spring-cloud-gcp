/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.workstations.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for Workstations client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.workstations.v1.workstations")
public class WorkstationsSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of default transport channel provider to use REST instead of gRPC. */
  private boolean useRest = false;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for getWorkstationCluster. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getWorkstationClusterRetry;
  /**
   * Allow override of retry settings at method-level for listWorkstationClusters. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listWorkstationClustersRetry;
  /**
   * Allow override of retry settings at method-level for getWorkstationConfig. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getWorkstationConfigRetry;
  /**
   * Allow override of retry settings at method-level for listWorkstationConfigs. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listWorkstationConfigsRetry;
  /**
   * Allow override of retry settings at method-level for listUsableWorkstationConfigs. If defined,
   * this takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listUsableWorkstationConfigsRetry;
  /**
   * Allow override of retry settings at method-level for getWorkstation. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getWorkstationRetry;
  /**
   * Allow override of retry settings at method-level for listWorkstations. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listWorkstationsRetry;
  /**
   * Allow override of retry settings at method-level for listUsableWorkstations. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listUsableWorkstationsRetry;
  /**
   * Allow override of retry settings at method-level for generateAccessToken. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry generateAccessTokenRetry;
  /**
   * Allow override of retry settings at method-level for setIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry setIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for getIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for testIamPermissions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry testIamPermissionsRetry;

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

  public Retry getRetry() {
    return this.retry;
  }

  public void setRetry(Retry retry) {
    this.retry = retry;
  }

  public Retry getGetWorkstationClusterRetry() {
    return this.getWorkstationClusterRetry;
  }

  public void setGetWorkstationClusterRetry(Retry getWorkstationClusterRetry) {
    this.getWorkstationClusterRetry = getWorkstationClusterRetry;
  }

  public Retry getListWorkstationClustersRetry() {
    return this.listWorkstationClustersRetry;
  }

  public void setListWorkstationClustersRetry(Retry listWorkstationClustersRetry) {
    this.listWorkstationClustersRetry = listWorkstationClustersRetry;
  }

  public Retry getGetWorkstationConfigRetry() {
    return this.getWorkstationConfigRetry;
  }

  public void setGetWorkstationConfigRetry(Retry getWorkstationConfigRetry) {
    this.getWorkstationConfigRetry = getWorkstationConfigRetry;
  }

  public Retry getListWorkstationConfigsRetry() {
    return this.listWorkstationConfigsRetry;
  }

  public void setListWorkstationConfigsRetry(Retry listWorkstationConfigsRetry) {
    this.listWorkstationConfigsRetry = listWorkstationConfigsRetry;
  }

  public Retry getListUsableWorkstationConfigsRetry() {
    return this.listUsableWorkstationConfigsRetry;
  }

  public void setListUsableWorkstationConfigsRetry(Retry listUsableWorkstationConfigsRetry) {
    this.listUsableWorkstationConfigsRetry = listUsableWorkstationConfigsRetry;
  }

  public Retry getGetWorkstationRetry() {
    return this.getWorkstationRetry;
  }

  public void setGetWorkstationRetry(Retry getWorkstationRetry) {
    this.getWorkstationRetry = getWorkstationRetry;
  }

  public Retry getListWorkstationsRetry() {
    return this.listWorkstationsRetry;
  }

  public void setListWorkstationsRetry(Retry listWorkstationsRetry) {
    this.listWorkstationsRetry = listWorkstationsRetry;
  }

  public Retry getListUsableWorkstationsRetry() {
    return this.listUsableWorkstationsRetry;
  }

  public void setListUsableWorkstationsRetry(Retry listUsableWorkstationsRetry) {
    this.listUsableWorkstationsRetry = listUsableWorkstationsRetry;
  }

  public Retry getGenerateAccessTokenRetry() {
    return this.generateAccessTokenRetry;
  }

  public void setGenerateAccessTokenRetry(Retry generateAccessTokenRetry) {
    this.generateAccessTokenRetry = generateAccessTokenRetry;
  }

  public Retry getSetIamPolicyRetry() {
    return this.setIamPolicyRetry;
  }

  public void setSetIamPolicyRetry(Retry setIamPolicyRetry) {
    this.setIamPolicyRetry = setIamPolicyRetry;
  }

  public Retry getGetIamPolicyRetry() {
    return this.getIamPolicyRetry;
  }

  public void setGetIamPolicyRetry(Retry getIamPolicyRetry) {
    this.getIamPolicyRetry = getIamPolicyRetry;
  }

  public Retry getTestIamPermissionsRetry() {
    return this.testIamPermissionsRetry;
  }

  public void setTestIamPermissionsRetry(Retry testIamPermissionsRetry) {
    this.testIamPermissionsRetry = testIamPermissionsRetry;
  }
}
