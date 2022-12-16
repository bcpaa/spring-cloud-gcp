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

package com.google.cloud.networkmanagement.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.networkmanagement.v1.ReachabilityServiceClient;
import com.google.cloud.networkmanagement.v1.ReachabilityServiceSettings;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.global.GlobalProperties;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link ReachabilityServiceClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@ConditionalOnClass(ReachabilityServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.networkmanagement.v1.spring.auto.reachability-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties({ReachabilityServiceSpringProperties.class, GlobalProperties.class})
public class ReachabilityServiceSpringAutoConfiguration {
  private final ReachabilityServiceSpringProperties clientProperties;
  private final GlobalProperties globalProperties;
  private static final Log LOGGER =
      LogFactory.getLog(ReachabilityServiceSpringAutoConfiguration.class);

  protected ReachabilityServiceSpringAutoConfiguration(
      ReachabilityServiceSpringProperties clientProperties, GlobalProperties globalProperties) {
    this.clientProperties = clientProperties;
    this.globalProperties = globalProperties;
  }

  /**
   * Obtains the default credentials provider. The used key will be obtained from Spring Boot
   * configuration data files.
   */
  @Bean
  @ConditionalOnMissingBean
  public CredentialsProvider reachabilityServiceCredentials() throws IOException {
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from ReachabilityService-specific configuration");
      }
      return ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    }
    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("Using credentials from global configuration");
    }
    return ((CredentialsProvider) new DefaultCredentialsProvider(this.globalProperties));
  }

  /**
   * Returns the default channel provider. The default is gRPC and will default to it unless the
   * useRest option is provided to use HTTP transport instead
   */
  @Bean
  @ConditionalOnMissingBean
  public TransportChannelProvider defaultReachabilityServiceTransportChannelProvider() {
    return ReachabilityServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a ReachabilityServiceClient bean configured to use the default credentials provider
   * (obtained with reachabilityServiceCredentials()) and its default transport channel provider
   * (defaultReachabilityServiceTransportChannelProvider()). It also configures the quota project ID
   * if provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Individual retry settings are configured as well. It will use the relevant client library's
   * default retry settings when they are not specified in ReachabilityServiceSpringProperties.
   */
  @Bean
  @ConditionalOnMissingBean
  public ReachabilityServiceSettings reachabilityServiceSettings(
      @Qualifier("reachabilityServiceCredentials") CredentialsProvider credentialsProvider,
      @Qualifier("defaultReachabilityServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    ReachabilityServiceSettings.Builder clientSettingsBuilder =
        ReachabilityServiceSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .setTransportChannelProvider(defaultTransportChannelProvider)
            .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          ReachabilityServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder.setTransportChannelProvider(
          ReachabilityServiceSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    RetrySettings.Builder listConnectivityTestsRetrySettingBuilder =
        clientSettingsBuilder.listConnectivityTestsSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getListConnectivityTestsInitialRpcTimeout() != null) {
      listConnectivityTestsRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getListConnectivityTestsInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectivityTestsInitialRpcTimeout set to "
                + this.clientProperties.getListConnectivityTestsInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getListConnectivityTestsRpcTimeoutMultiplier() != null) {
      listConnectivityTestsRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getListConnectivityTestsRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectivityTestsRpcTimeoutMultiplier set to "
                + this.clientProperties.getListConnectivityTestsRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getListConnectivityTestsMaxRpcTimeout() != null) {
      listConnectivityTestsRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getListConnectivityTestsMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectivityTestsMaxRpcTimeout set to "
                + this.clientProperties.getListConnectivityTestsMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getListConnectivityTestsTotalTimeout() != null) {
      listConnectivityTestsRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getListConnectivityTestsTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectivityTestsTotalTimeout set to "
                + this.clientProperties.getListConnectivityTestsTotalTimeout());
      }
    }
    clientSettingsBuilder
        .listConnectivityTestsSettings()
        .setRetrySettings(listConnectivityTestsRetrySettingBuilder.build());
    RetrySettings.Builder getConnectivityTestRetrySettingBuilder =
        clientSettingsBuilder.getConnectivityTestSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getGetConnectivityTestInitialRpcTimeout() != null) {
      getConnectivityTestRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getGetConnectivityTestInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectivityTestInitialRpcTimeout set to "
                + this.clientProperties.getGetConnectivityTestInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getGetConnectivityTestRpcTimeoutMultiplier() != null) {
      getConnectivityTestRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getGetConnectivityTestRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectivityTestRpcTimeoutMultiplier set to "
                + this.clientProperties.getGetConnectivityTestRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getGetConnectivityTestMaxRpcTimeout() != null) {
      getConnectivityTestRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getGetConnectivityTestMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectivityTestMaxRpcTimeout set to "
                + this.clientProperties.getGetConnectivityTestMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getGetConnectivityTestTotalTimeout() != null) {
      getConnectivityTestRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getGetConnectivityTestTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectivityTestTotalTimeout set to "
                + this.clientProperties.getGetConnectivityTestTotalTimeout());
      }
    }
    clientSettingsBuilder
        .getConnectivityTestSettings()
        .setRetrySettings(getConnectivityTestRetrySettingBuilder.build());
    RetrySettings.Builder createConnectivityTestRetrySettingBuilder =
        clientSettingsBuilder.createConnectivityTestSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getCreateConnectivityTestInitialRpcTimeout() != null) {
      createConnectivityTestRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getCreateConnectivityTestInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectivityTestInitialRpcTimeout set to "
                + this.clientProperties.getCreateConnectivityTestInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getCreateConnectivityTestRpcTimeoutMultiplier() != null) {
      createConnectivityTestRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getCreateConnectivityTestRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectivityTestRpcTimeoutMultiplier set to "
                + this.clientProperties.getCreateConnectivityTestRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getCreateConnectivityTestMaxRpcTimeout() != null) {
      createConnectivityTestRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getCreateConnectivityTestMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectivityTestMaxRpcTimeout set to "
                + this.clientProperties.getCreateConnectivityTestMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getCreateConnectivityTestTotalTimeout() != null) {
      createConnectivityTestRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getCreateConnectivityTestTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectivityTestTotalTimeout set to "
                + this.clientProperties.getCreateConnectivityTestTotalTimeout());
      }
    }
    clientSettingsBuilder
        .createConnectivityTestSettings()
        .setRetrySettings(createConnectivityTestRetrySettingBuilder.build());
    RetrySettings.Builder updateConnectivityTestRetrySettingBuilder =
        clientSettingsBuilder.updateConnectivityTestSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getUpdateConnectivityTestInitialRpcTimeout() != null) {
      updateConnectivityTestRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getUpdateConnectivityTestInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "UpdateConnectivityTestInitialRpcTimeout set to "
                + this.clientProperties.getUpdateConnectivityTestInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getUpdateConnectivityTestRpcTimeoutMultiplier() != null) {
      updateConnectivityTestRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getUpdateConnectivityTestRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "UpdateConnectivityTestRpcTimeoutMultiplier set to "
                + this.clientProperties.getUpdateConnectivityTestRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getUpdateConnectivityTestMaxRpcTimeout() != null) {
      updateConnectivityTestRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getUpdateConnectivityTestMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "UpdateConnectivityTestMaxRpcTimeout set to "
                + this.clientProperties.getUpdateConnectivityTestMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getUpdateConnectivityTestTotalTimeout() != null) {
      updateConnectivityTestRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getUpdateConnectivityTestTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "UpdateConnectivityTestTotalTimeout set to "
                + this.clientProperties.getUpdateConnectivityTestTotalTimeout());
      }
    }
    clientSettingsBuilder
        .updateConnectivityTestSettings()
        .setRetrySettings(updateConnectivityTestRetrySettingBuilder.build());
    RetrySettings.Builder rerunConnectivityTestRetrySettingBuilder =
        clientSettingsBuilder.rerunConnectivityTestSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRerunConnectivityTestInitialRpcTimeout() != null) {
      rerunConnectivityTestRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getRerunConnectivityTestInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "RerunConnectivityTestInitialRpcTimeout set to "
                + this.clientProperties.getRerunConnectivityTestInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getRerunConnectivityTestRpcTimeoutMultiplier() != null) {
      rerunConnectivityTestRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRerunConnectivityTestRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "RerunConnectivityTestRpcTimeoutMultiplier set to "
                + this.clientProperties.getRerunConnectivityTestRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getRerunConnectivityTestMaxRpcTimeout() != null) {
      rerunConnectivityTestRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getRerunConnectivityTestMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "RerunConnectivityTestMaxRpcTimeout set to "
                + this.clientProperties.getRerunConnectivityTestMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getRerunConnectivityTestTotalTimeout() != null) {
      rerunConnectivityTestRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getRerunConnectivityTestTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "RerunConnectivityTestTotalTimeout set to "
                + this.clientProperties.getRerunConnectivityTestTotalTimeout());
      }
    }
    clientSettingsBuilder
        .rerunConnectivityTestSettings()
        .setRetrySettings(rerunConnectivityTestRetrySettingBuilder.build());
    RetrySettings.Builder deleteConnectivityTestRetrySettingBuilder =
        clientSettingsBuilder.deleteConnectivityTestSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getDeleteConnectivityTestInitialRpcTimeout() != null) {
      deleteConnectivityTestRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getDeleteConnectivityTestInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectivityTestInitialRpcTimeout set to "
                + this.clientProperties.getDeleteConnectivityTestInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getDeleteConnectivityTestRpcTimeoutMultiplier() != null) {
      deleteConnectivityTestRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getDeleteConnectivityTestRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectivityTestRpcTimeoutMultiplier set to "
                + this.clientProperties.getDeleteConnectivityTestRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getDeleteConnectivityTestMaxRpcTimeout() != null) {
      deleteConnectivityTestRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getDeleteConnectivityTestMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectivityTestMaxRpcTimeout set to "
                + this.clientProperties.getDeleteConnectivityTestMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getDeleteConnectivityTestTotalTimeout() != null) {
      deleteConnectivityTestRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getDeleteConnectivityTestTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectivityTestTotalTimeout set to "
                + this.clientProperties.getDeleteConnectivityTestTotalTimeout());
      }
    }
    clientSettingsBuilder
        .deleteConnectivityTestSettings()
        .setRetrySettings(deleteConnectivityTestRetrySettingBuilder.build());
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public ReachabilityServiceClient reachabilityServiceClient(
      ReachabilityServiceSettings reachabilityServiceSettings) throws IOException {
    return ReachabilityServiceClient.create(reachabilityServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-reachability-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
