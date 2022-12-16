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

package com.google.cloud.dataproc.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.dataproc.v1.BatchControllerClient;
import com.google.cloud.dataproc.v1.BatchControllerSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link BatchControllerClient}.
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
@ConditionalOnClass(BatchControllerClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.dataproc.v1.spring.auto.batch-controller.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties({BatchControllerSpringProperties.class, GlobalProperties.class})
public class BatchControllerSpringAutoConfiguration {
  private final BatchControllerSpringProperties clientProperties;
  private final GlobalProperties globalProperties;
  private static final Log LOGGER = LogFactory.getLog(BatchControllerSpringAutoConfiguration.class);

  protected BatchControllerSpringAutoConfiguration(
      BatchControllerSpringProperties clientProperties, GlobalProperties globalProperties) {
    this.clientProperties = clientProperties;
    this.globalProperties = globalProperties;
  }

  /**
   * Obtains the default credentials provider. The used key will be obtained from Spring Boot
   * configuration data files.
   */
  @Bean
  @ConditionalOnMissingBean
  public CredentialsProvider batchControllerCredentials() throws IOException {
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from BatchController-specific configuration");
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
  public TransportChannelProvider defaultBatchControllerTransportChannelProvider() {
    return BatchControllerSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a BatchControllerClient bean configured to use the default credentials provider
   * (obtained with batchControllerCredentials()) and its default transport channel provider
   * (defaultBatchControllerTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Individual retry settings are configured as well. It will use the relevant client library's
   * default retry settings when they are not specified in BatchControllerSpringProperties.
   */
  @Bean
  @ConditionalOnMissingBean
  public BatchControllerSettings batchControllerSettings(
      @Qualifier("batchControllerCredentials") CredentialsProvider credentialsProvider,
      @Qualifier("defaultBatchControllerTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    BatchControllerSettings.Builder clientSettingsBuilder =
        BatchControllerSettings.newBuilder()
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
          BatchControllerSettings.defaultExecutorProviderBuilder()
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
          BatchControllerSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    RetrySettings.Builder createBatchRetrySettingBuilder =
        clientSettingsBuilder.createBatchSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getCreateBatchRpcTimeoutMultiplier() != null) {
      createBatchRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getCreateBatchRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "CreateBatchRpcTimeoutMultiplier set to "
                + this.clientProperties.getCreateBatchRpcTimeoutMultiplier());
      }
    }
    clientSettingsBuilder
        .createBatchSettings()
        .setRetrySettings(createBatchRetrySettingBuilder.build());
    RetrySettings.Builder getBatchRetrySettingBuilder =
        clientSettingsBuilder.getBatchSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getGetBatchRpcTimeoutMultiplier() != null) {
      getBatchRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getGetBatchRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "GetBatchRpcTimeoutMultiplier set to "
                + this.clientProperties.getGetBatchRpcTimeoutMultiplier());
      }
    }
    clientSettingsBuilder.getBatchSettings().setRetrySettings(getBatchRetrySettingBuilder.build());
    RetrySettings.Builder listBatchesRetrySettingBuilder =
        clientSettingsBuilder.listBatchesSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getListBatchesRpcTimeoutMultiplier() != null) {
      listBatchesRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getListBatchesRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "ListBatchesRpcTimeoutMultiplier set to "
                + this.clientProperties.getListBatchesRpcTimeoutMultiplier());
      }
    }
    clientSettingsBuilder
        .listBatchesSettings()
        .setRetrySettings(listBatchesRetrySettingBuilder.build());
    RetrySettings.Builder deleteBatchRetrySettingBuilder =
        clientSettingsBuilder.deleteBatchSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getDeleteBatchRpcTimeoutMultiplier() != null) {
      deleteBatchRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getDeleteBatchRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "DeleteBatchRpcTimeoutMultiplier set to "
                + this.clientProperties.getDeleteBatchRpcTimeoutMultiplier());
      }
    }
    clientSettingsBuilder
        .deleteBatchSettings()
        .setRetrySettings(deleteBatchRetrySettingBuilder.build());
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public BatchControllerClient batchControllerClient(
      BatchControllerSettings batchControllerSettings) throws IOException {
    return BatchControllerClient.create(batchControllerSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-batch-controller";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
