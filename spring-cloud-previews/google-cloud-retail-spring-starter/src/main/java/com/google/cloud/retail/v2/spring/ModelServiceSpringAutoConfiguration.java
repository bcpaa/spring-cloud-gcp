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

package com.google.cloud.retail.v2.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.retail.v2.ModelServiceClient;
import com.google.cloud.retail.v2.ModelServiceSettings;
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
 * Auto-configuration for {@link ModelServiceClient}.
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
@ConditionalOnClass(ModelServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.retail.v2.model-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(ModelServiceSpringProperties.class)
public class ModelServiceSpringAutoConfiguration {
  private final ModelServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(ModelServiceSpringAutoConfiguration.class);

  protected ModelServiceSpringAutoConfiguration(
      ModelServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from ModelService-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultModelServiceTransportChannelProvider")
  public TransportChannelProvider defaultModelServiceTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return ModelServiceSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return ModelServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a ModelServiceSettings bean configured to use a DefaultCredentialsProvider and the
   * client library's default transport channel provider
   * (defaultModelServiceTransportChannelProvider()). It also configures the quota project ID and
   * executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in ModelServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link ModelServiceSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public ModelServiceSettings modelServiceSettings(
      @Qualifier("defaultModelServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    ModelServiceSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = ModelServiceSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = ModelServiceSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(ModelServiceSettings.getDefaultEndpoint())
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
          ModelServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings getModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getModelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getModelSettings().setRetrySettings(getModelRetrySettings);

      RetrySettings pauseModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.pauseModelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.pauseModelSettings().setRetrySettings(pauseModelRetrySettings);

      RetrySettings resumeModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.resumeModelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.resumeModelSettings().setRetrySettings(resumeModelRetrySettings);

      RetrySettings deleteModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteModelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteModelSettings().setRetrySettings(deleteModelRetrySettings);

      RetrySettings listModelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listModelsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listModelsSettings().setRetrySettings(listModelsRetrySettings);

      RetrySettings updateModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateModelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateModelSettings().setRetrySettings(updateModelRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry getModelRetry = clientProperties.getGetModelRetry();
    if (getModelRetry != null) {
      RetrySettings getModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getModelSettings().getRetrySettings(), getModelRetry);
      clientSettingsBuilder.getModelSettings().setRetrySettings(getModelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getModel from properties.");
      }
    }
    Retry pauseModelRetry = clientProperties.getPauseModelRetry();
    if (pauseModelRetry != null) {
      RetrySettings pauseModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.pauseModelSettings().getRetrySettings(), pauseModelRetry);
      clientSettingsBuilder.pauseModelSettings().setRetrySettings(pauseModelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for pauseModel from properties.");
      }
    }
    Retry resumeModelRetry = clientProperties.getResumeModelRetry();
    if (resumeModelRetry != null) {
      RetrySettings resumeModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.resumeModelSettings().getRetrySettings(), resumeModelRetry);
      clientSettingsBuilder.resumeModelSettings().setRetrySettings(resumeModelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for resumeModel from properties.");
      }
    }
    Retry deleteModelRetry = clientProperties.getDeleteModelRetry();
    if (deleteModelRetry != null) {
      RetrySettings deleteModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteModelSettings().getRetrySettings(), deleteModelRetry);
      clientSettingsBuilder.deleteModelSettings().setRetrySettings(deleteModelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteModel from properties.");
      }
    }
    Retry listModelsRetry = clientProperties.getListModelsRetry();
    if (listModelsRetry != null) {
      RetrySettings listModelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listModelsSettings().getRetrySettings(), listModelsRetry);
      clientSettingsBuilder.listModelsSettings().setRetrySettings(listModelsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listModels from properties.");
      }
    }
    Retry updateModelRetry = clientProperties.getUpdateModelRetry();
    if (updateModelRetry != null) {
      RetrySettings updateModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateModelSettings().getRetrySettings(), updateModelRetry);
      clientSettingsBuilder.updateModelSettings().setRetrySettings(updateModelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateModel from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a ModelServiceClient bean configured with ModelServiceSettings.
   *
   * @param modelServiceSettings settings to configure an instance of client bean.
   * @return a {@link ModelServiceClient} bean configured with {@link ModelServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public ModelServiceClient modelServiceClient(ModelServiceSettings modelServiceSettings)
      throws IOException {
    return ModelServiceClient.create(modelServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-model-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
