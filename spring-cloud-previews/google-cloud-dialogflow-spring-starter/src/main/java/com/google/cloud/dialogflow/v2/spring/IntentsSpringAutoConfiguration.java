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

package com.google.cloud.dialogflow.v2.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.IntentsSettings;
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
 * Auto-configuration for {@link IntentsClient}.
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
@ConditionalOnClass(IntentsClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.dialogflow.v2.intents.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(IntentsSpringProperties.class)
public class IntentsSpringAutoConfiguration {
  private final IntentsSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(IntentsSpringAutoConfiguration.class);

  protected IntentsSpringAutoConfiguration(
      IntentsSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from Intents-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultIntentsTransportChannelProvider")
  public TransportChannelProvider defaultIntentsTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return IntentsSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return IntentsSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a IntentsSettings bean configured to use a DefaultCredentialsProvider and the client
   * library's default transport channel provider (defaultIntentsTransportChannelProvider()). It
   * also configures the quota project ID and executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in IntentsSpringProperties. Method-level properties will take precedence over service-level
   * properties if available, and client library defaults will be used if neither are specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link IntentsSettings} bean configured with {@link TransportChannelProvider} bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public IntentsSettings intentsSettings(
      @Qualifier("defaultIntentsTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    IntentsSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = IntentsSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = IntentsSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(IntentsSettings.getDefaultEndpoint())
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
          IntentsSettings.defaultExecutorProviderBuilder()
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
      RetrySettings listIntentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listIntentsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listIntentsSettings().setRetrySettings(listIntentsRetrySettings);

      RetrySettings getIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIntentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getIntentSettings().setRetrySettings(getIntentRetrySettings);

      RetrySettings createIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createIntentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createIntentSettings().setRetrySettings(createIntentRetrySettings);

      RetrySettings updateIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateIntentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateIntentSettings().setRetrySettings(updateIntentRetrySettings);

      RetrySettings deleteIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteIntentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteIntentSettings().setRetrySettings(deleteIntentRetrySettings);

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
    Retry listIntentsRetry = clientProperties.getListIntentsRetry();
    if (listIntentsRetry != null) {
      RetrySettings listIntentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listIntentsSettings().getRetrySettings(), listIntentsRetry);
      clientSettingsBuilder.listIntentsSettings().setRetrySettings(listIntentsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listIntents from properties.");
      }
    }
    Retry getIntentRetry = clientProperties.getGetIntentRetry();
    if (getIntentRetry != null) {
      RetrySettings getIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIntentSettings().getRetrySettings(), getIntentRetry);
      clientSettingsBuilder.getIntentSettings().setRetrySettings(getIntentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getIntent from properties.");
      }
    }
    Retry createIntentRetry = clientProperties.getCreateIntentRetry();
    if (createIntentRetry != null) {
      RetrySettings createIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createIntentSettings().getRetrySettings(), createIntentRetry);
      clientSettingsBuilder.createIntentSettings().setRetrySettings(createIntentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createIntent from properties.");
      }
    }
    Retry updateIntentRetry = clientProperties.getUpdateIntentRetry();
    if (updateIntentRetry != null) {
      RetrySettings updateIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateIntentSettings().getRetrySettings(), updateIntentRetry);
      clientSettingsBuilder.updateIntentSettings().setRetrySettings(updateIntentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateIntent from properties.");
      }
    }
    Retry deleteIntentRetry = clientProperties.getDeleteIntentRetry();
    if (deleteIntentRetry != null) {
      RetrySettings deleteIntentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteIntentSettings().getRetrySettings(), deleteIntentRetry);
      clientSettingsBuilder.deleteIntentSettings().setRetrySettings(deleteIntentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteIntent from properties.");
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
   * Provides a IntentsClient bean configured with IntentsSettings.
   *
   * @param intentsSettings settings to configure an instance of client bean.
   * @return a {@link IntentsClient} bean configured with {@link IntentsSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public IntentsClient intentsClient(IntentsSettings intentsSettings) throws IOException {
    return IntentsClient.create(intentsSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-intents";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
