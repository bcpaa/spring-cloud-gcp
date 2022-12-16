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

package com.google.cloud.vpcaccess.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.global.GlobalProperties;
import com.google.cloud.vpcaccess.v1.VpcAccessServiceClient;
import com.google.cloud.vpcaccess.v1.VpcAccessServiceSettings;
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
 * Auto-configuration for {@link VpcAccessServiceClient}.
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
@ConditionalOnClass(VpcAccessServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.vpcaccess.v1.spring.auto.vpc-access-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties({VpcAccessServiceSpringProperties.class, GlobalProperties.class})
public class VpcAccessServiceSpringAutoConfiguration {
  private final VpcAccessServiceSpringProperties clientProperties;
  private final GlobalProperties globalProperties;
  private static final Log LOGGER =
      LogFactory.getLog(VpcAccessServiceSpringAutoConfiguration.class);

  protected VpcAccessServiceSpringAutoConfiguration(
      VpcAccessServiceSpringProperties clientProperties, GlobalProperties globalProperties) {
    this.clientProperties = clientProperties;
    this.globalProperties = globalProperties;
  }

  /**
   * Obtains the default credentials provider. The used key will be obtained from Spring Boot
   * configuration data files.
   */
  @Bean
  @ConditionalOnMissingBean
  public CredentialsProvider vpcAccessServiceCredentials() throws IOException {
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from VpcAccessService-specific configuration");
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
  public TransportChannelProvider defaultVpcAccessServiceTransportChannelProvider() {
    return VpcAccessServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a VpcAccessServiceClient bean configured to use the default credentials provider
   * (obtained with vpcAccessServiceCredentials()) and its default transport channel provider
   * (defaultVpcAccessServiceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Individual retry settings are configured as well. It will use the relevant client library's
   * default retry settings when they are not specified in VpcAccessServiceSpringProperties.
   */
  @Bean
  @ConditionalOnMissingBean
  public VpcAccessServiceSettings vpcAccessServiceSettings(
      @Qualifier("vpcAccessServiceCredentials") CredentialsProvider credentialsProvider,
      @Qualifier("defaultVpcAccessServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    VpcAccessServiceSettings.Builder clientSettingsBuilder =
        VpcAccessServiceSettings.newBuilder()
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
          VpcAccessServiceSettings.defaultExecutorProviderBuilder()
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
          VpcAccessServiceSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    RetrySettings.Builder createConnectorRetrySettingBuilder =
        clientSettingsBuilder.createConnectorSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getCreateConnectorInitialRpcTimeout() != null) {
      createConnectorRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getCreateConnectorInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectorInitialRpcTimeout set to "
                + this.clientProperties.getCreateConnectorInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getCreateConnectorRpcTimeoutMultiplier() != null) {
      createConnectorRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getCreateConnectorRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectorRpcTimeoutMultiplier set to "
                + this.clientProperties.getCreateConnectorRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getCreateConnectorMaxRpcTimeout() != null) {
      createConnectorRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getCreateConnectorMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectorMaxRpcTimeout set to "
                + this.clientProperties.getCreateConnectorMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getCreateConnectorTotalTimeout() != null) {
      createConnectorRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getCreateConnectorTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateConnectorTotalTimeout set to "
                + this.clientProperties.getCreateConnectorTotalTimeout());
      }
    }
    clientSettingsBuilder
        .createConnectorSettings()
        .setRetrySettings(createConnectorRetrySettingBuilder.build());
    RetrySettings.Builder getConnectorRetrySettingBuilder =
        clientSettingsBuilder.getConnectorSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getGetConnectorInitialRpcTimeout() != null) {
      getConnectorRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getGetConnectorInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectorInitialRpcTimeout set to "
                + this.clientProperties.getGetConnectorInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getGetConnectorRpcTimeoutMultiplier() != null) {
      getConnectorRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getGetConnectorRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectorRpcTimeoutMultiplier set to "
                + this.clientProperties.getGetConnectorRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getGetConnectorMaxRpcTimeout() != null) {
      getConnectorRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getGetConnectorMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectorMaxRpcTimeout set to "
                + this.clientProperties.getGetConnectorMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getGetConnectorTotalTimeout() != null) {
      getConnectorRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getGetConnectorTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetConnectorTotalTimeout set to "
                + this.clientProperties.getGetConnectorTotalTimeout());
      }
    }
    clientSettingsBuilder
        .getConnectorSettings()
        .setRetrySettings(getConnectorRetrySettingBuilder.build());
    RetrySettings.Builder listConnectorsRetrySettingBuilder =
        clientSettingsBuilder.listConnectorsSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getListConnectorsInitialRpcTimeout() != null) {
      listConnectorsRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getListConnectorsInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectorsInitialRpcTimeout set to "
                + this.clientProperties.getListConnectorsInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getListConnectorsRpcTimeoutMultiplier() != null) {
      listConnectorsRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getListConnectorsRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectorsRpcTimeoutMultiplier set to "
                + this.clientProperties.getListConnectorsRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getListConnectorsMaxRpcTimeout() != null) {
      listConnectorsRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getListConnectorsMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectorsMaxRpcTimeout set to "
                + this.clientProperties.getListConnectorsMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getListConnectorsTotalTimeout() != null) {
      listConnectorsRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getListConnectorsTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListConnectorsTotalTimeout set to "
                + this.clientProperties.getListConnectorsTotalTimeout());
      }
    }
    clientSettingsBuilder
        .listConnectorsSettings()
        .setRetrySettings(listConnectorsRetrySettingBuilder.build());
    RetrySettings.Builder deleteConnectorRetrySettingBuilder =
        clientSettingsBuilder.deleteConnectorSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getDeleteConnectorInitialRpcTimeout() != null) {
      deleteConnectorRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getDeleteConnectorInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectorInitialRpcTimeout set to "
                + this.clientProperties.getDeleteConnectorInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getDeleteConnectorRpcTimeoutMultiplier() != null) {
      deleteConnectorRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getDeleteConnectorRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectorRpcTimeoutMultiplier set to "
                + this.clientProperties.getDeleteConnectorRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getDeleteConnectorMaxRpcTimeout() != null) {
      deleteConnectorRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getDeleteConnectorMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectorMaxRpcTimeout set to "
                + this.clientProperties.getDeleteConnectorMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getDeleteConnectorTotalTimeout() != null) {
      deleteConnectorRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getDeleteConnectorTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteConnectorTotalTimeout set to "
                + this.clientProperties.getDeleteConnectorTotalTimeout());
      }
    }
    clientSettingsBuilder
        .deleteConnectorSettings()
        .setRetrySettings(deleteConnectorRetrySettingBuilder.build());
    RetrySettings.Builder listLocationsRetrySettingBuilder =
        clientSettingsBuilder.listLocationsSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getListLocationsInitialRetryDelay() != null) {
      listLocationsRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getListLocationsInitialRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListLocationsInitialRetryDelay set to "
                + this.clientProperties.getListLocationsInitialRetryDelay());
      }
    }
    if (this.clientProperties.getListLocationsRetryDelayMultiplier() != null) {
      listLocationsRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getListLocationsRetryDelayMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListLocationsRetryDelayMultiplier set to "
                + this.clientProperties.getListLocationsRetryDelayMultiplier());
      }
    }
    if (this.clientProperties.getListLocationsMaxRetryDelay() != null) {
      listLocationsRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getListLocationsMaxRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListLocationsMaxRetryDelay set to "
                + this.clientProperties.getListLocationsMaxRetryDelay());
      }
    }
    if (this.clientProperties.getListLocationsInitialRpcTimeout() != null) {
      listLocationsRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getListLocationsInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListLocationsInitialRpcTimeout set to "
                + this.clientProperties.getListLocationsInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getListLocationsRpcTimeoutMultiplier() != null) {
      listLocationsRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getListLocationsRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListLocationsRpcTimeoutMultiplier set to "
                + this.clientProperties.getListLocationsRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getListLocationsMaxRpcTimeout() != null) {
      listLocationsRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getListLocationsMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListLocationsMaxRpcTimeout set to "
                + this.clientProperties.getListLocationsMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getListLocationsTotalTimeout() != null) {
      listLocationsRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getListLocationsTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListLocationsTotalTimeout set to "
                + this.clientProperties.getListLocationsTotalTimeout());
      }
    }
    clientSettingsBuilder
        .listLocationsSettings()
        .setRetrySettings(listLocationsRetrySettingBuilder.build());
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public VpcAccessServiceClient vpcAccessServiceClient(
      VpcAccessServiceSettings vpcAccessServiceSettings) throws IOException {
    return VpcAccessServiceClient.create(vpcAccessServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-vpc-access-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
