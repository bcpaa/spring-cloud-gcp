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

package com.google.cloud.dataplex.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.dataplex.v1.MetadataServiceClient;
import com.google.cloud.dataplex.v1.MetadataServiceSettings;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link MetadataServiceClient}.
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
@AutoConfigureAfter(GcpContextAutoConfiguration.class)
@ConditionalOnClass(MetadataServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.dataplex.v1.metadata-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(MetadataServiceSpringProperties.class)
public class MetadataServiceSpringAutoConfiguration {
  private final MetadataServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(MetadataServiceSpringAutoConfiguration.class);

  protected MetadataServiceSpringAutoConfiguration(
      MetadataServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from MetadataService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Provides a default transport channel provider bean, corresponding to the client library's
   * default transport channel provider. If the library supports both GRPC and REST transport, and
   * the useRest property is configured, the HTTP/JSON transport provider will be used instead of
   * GRPC.
   *
   * @return a default transport channel provider.
   */
  @Bean
  @ConditionalOnMissingBean(name = "defaultMetadataServiceTransportChannelProvider")
  public TransportChannelProvider defaultMetadataServiceTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return MetadataServiceSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return MetadataServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a MetadataServiceSettings bean configured to use a DefaultCredentialsProvider and the
   * client library's default transport channel provider
   * (defaultMetadataServiceTransportChannelProvider()). It also configures the quota project ID and
   * executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in MetadataServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link MetadataServiceSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public MetadataServiceSettings metadataServiceSettings(
      @Qualifier("defaultMetadataServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    MetadataServiceSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = MetadataServiceSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = MetadataServiceSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(MetadataServiceSettings.getDefaultEndpoint())
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
          MetadataServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings createEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createEntitySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createEntitySettings().setRetrySettings(createEntityRetrySettings);

      RetrySettings updateEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateEntitySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateEntitySettings().setRetrySettings(updateEntityRetrySettings);

      RetrySettings deleteEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteEntitySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteEntitySettings().setRetrySettings(deleteEntityRetrySettings);

      RetrySettings getEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEntitySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getEntitySettings().setRetrySettings(getEntityRetrySettings);

      RetrySettings listEntitiesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEntitiesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listEntitiesSettings().setRetrySettings(listEntitiesRetrySettings);

      RetrySettings createPartitionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createPartitionSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .createPartitionSettings()
          .setRetrySettings(createPartitionRetrySettings);

      RetrySettings deletePartitionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deletePartitionSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .deletePartitionSettings()
          .setRetrySettings(deletePartitionRetrySettings);

      RetrySettings getPartitionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getPartitionSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getPartitionSettings().setRetrySettings(getPartitionRetrySettings);

      RetrySettings listPartitionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listPartitionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listPartitionsSettings().setRetrySettings(listPartitionsRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry createEntityRetry = clientProperties.getCreateEntityRetry();
    if (createEntityRetry != null) {
      RetrySettings createEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createEntitySettings().getRetrySettings(), createEntityRetry);
      clientSettingsBuilder.createEntitySettings().setRetrySettings(createEntityRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createEntity from properties.");
      }
    }
    Retry updateEntityRetry = clientProperties.getUpdateEntityRetry();
    if (updateEntityRetry != null) {
      RetrySettings updateEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateEntitySettings().getRetrySettings(), updateEntityRetry);
      clientSettingsBuilder.updateEntitySettings().setRetrySettings(updateEntityRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateEntity from properties.");
      }
    }
    Retry deleteEntityRetry = clientProperties.getDeleteEntityRetry();
    if (deleteEntityRetry != null) {
      RetrySettings deleteEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteEntitySettings().getRetrySettings(), deleteEntityRetry);
      clientSettingsBuilder.deleteEntitySettings().setRetrySettings(deleteEntityRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteEntity from properties.");
      }
    }
    Retry getEntityRetry = clientProperties.getGetEntityRetry();
    if (getEntityRetry != null) {
      RetrySettings getEntityRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEntitySettings().getRetrySettings(), getEntityRetry);
      clientSettingsBuilder.getEntitySettings().setRetrySettings(getEntityRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getEntity from properties.");
      }
    }
    Retry listEntitiesRetry = clientProperties.getListEntitiesRetry();
    if (listEntitiesRetry != null) {
      RetrySettings listEntitiesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEntitiesSettings().getRetrySettings(), listEntitiesRetry);
      clientSettingsBuilder.listEntitiesSettings().setRetrySettings(listEntitiesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listEntities from properties.");
      }
    }
    Retry createPartitionRetry = clientProperties.getCreatePartitionRetry();
    if (createPartitionRetry != null) {
      RetrySettings createPartitionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createPartitionSettings().getRetrySettings(),
              createPartitionRetry);
      clientSettingsBuilder
          .createPartitionSettings()
          .setRetrySettings(createPartitionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createPartition from properties.");
      }
    }
    Retry deletePartitionRetry = clientProperties.getDeletePartitionRetry();
    if (deletePartitionRetry != null) {
      RetrySettings deletePartitionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deletePartitionSettings().getRetrySettings(),
              deletePartitionRetry);
      clientSettingsBuilder
          .deletePartitionSettings()
          .setRetrySettings(deletePartitionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deletePartition from properties.");
      }
    }
    Retry getPartitionRetry = clientProperties.getGetPartitionRetry();
    if (getPartitionRetry != null) {
      RetrySettings getPartitionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getPartitionSettings().getRetrySettings(), getPartitionRetry);
      clientSettingsBuilder.getPartitionSettings().setRetrySettings(getPartitionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getPartition from properties.");
      }
    }
    Retry listPartitionsRetry = clientProperties.getListPartitionsRetry();
    if (listPartitionsRetry != null) {
      RetrySettings listPartitionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listPartitionsSettings().getRetrySettings(),
              listPartitionsRetry);
      clientSettingsBuilder.listPartitionsSettings().setRetrySettings(listPartitionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listPartitions from properties.");
      }
    }
    Retry listLocationsRetry = clientProperties.getListLocationsRetry();
    if (listLocationsRetry != null) {
      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), listLocationsRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLocations from properties.");
      }
    }
    Retry getLocationRetry = clientProperties.getGetLocationRetry();
    if (getLocationRetry != null) {
      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), getLocationRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLocation from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a MetadataServiceClient bean configured with MetadataServiceSettings.
   *
   * @param metadataServiceSettings settings to configure an instance of client bean.
   * @return a {@link MetadataServiceClient} bean configured with {@link MetadataServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public MetadataServiceClient metadataServiceClient(
      MetadataServiceSettings metadataServiceSettings) throws IOException {
    return MetadataServiceClient.create(metadataServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-metadata-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
