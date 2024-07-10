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

package com.google.cloud.oslogin.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.oslogin.v1.OsLoginServiceClient;
import com.google.cloud.oslogin.v1.OsLoginServiceSettings;
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
 * Auto-configuration for {@link OsLoginServiceClient}.
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
@ConditionalOnClass(OsLoginServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.oslogin.v1.os-login-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(OsLoginServiceSpringProperties.class)
public class OsLoginServiceSpringAutoConfiguration {
  private final OsLoginServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(OsLoginServiceSpringAutoConfiguration.class);

  protected OsLoginServiceSpringAutoConfiguration(
      OsLoginServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from OsLoginService-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultOsLoginServiceTransportChannelProvider")
  public TransportChannelProvider defaultOsLoginServiceTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return OsLoginServiceSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return OsLoginServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a OsLoginServiceSettings bean configured to use a DefaultCredentialsProvider and the
   * client library's default transport channel provider
   * (defaultOsLoginServiceTransportChannelProvider()). It also configures the quota project ID and
   * executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in OsLoginServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link OsLoginServiceSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public OsLoginServiceSettings osLoginServiceSettings(
      @Qualifier("defaultOsLoginServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    OsLoginServiceSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = OsLoginServiceSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = OsLoginServiceSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(OsLoginServiceSettings.getDefaultEndpoint())
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
          OsLoginServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings createSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSshPublicKeySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .createSshPublicKeySettings()
          .setRetrySettings(createSshPublicKeyRetrySettings);

      RetrySettings deletePosixAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deletePosixAccountSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .deletePosixAccountSettings()
          .setRetrySettings(deletePosixAccountRetrySettings);

      RetrySettings deleteSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSshPublicKeySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .deleteSshPublicKeySettings()
          .setRetrySettings(deleteSshPublicKeyRetrySettings);

      RetrySettings getLoginProfileRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLoginProfileSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getLoginProfileSettings()
          .setRetrySettings(getLoginProfileRetrySettings);

      RetrySettings getSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSshPublicKeySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getSshPublicKeySettings()
          .setRetrySettings(getSshPublicKeyRetrySettings);

      RetrySettings importSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.importSshPublicKeySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .importSshPublicKeySettings()
          .setRetrySettings(importSshPublicKeyRetrySettings);

      RetrySettings updateSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSshPublicKeySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .updateSshPublicKeySettings()
          .setRetrySettings(updateSshPublicKeyRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry createSshPublicKeyRetry = clientProperties.getCreateSshPublicKeyRetry();
    if (createSshPublicKeyRetry != null) {
      RetrySettings createSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSshPublicKeySettings().getRetrySettings(),
              createSshPublicKeyRetry);
      clientSettingsBuilder
          .createSshPublicKeySettings()
          .setRetrySettings(createSshPublicKeyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createSshPublicKey from properties.");
      }
    }
    Retry deletePosixAccountRetry = clientProperties.getDeletePosixAccountRetry();
    if (deletePosixAccountRetry != null) {
      RetrySettings deletePosixAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deletePosixAccountSettings().getRetrySettings(),
              deletePosixAccountRetry);
      clientSettingsBuilder
          .deletePosixAccountSettings()
          .setRetrySettings(deletePosixAccountRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deletePosixAccount from properties.");
      }
    }
    Retry deleteSshPublicKeyRetry = clientProperties.getDeleteSshPublicKeyRetry();
    if (deleteSshPublicKeyRetry != null) {
      RetrySettings deleteSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSshPublicKeySettings().getRetrySettings(),
              deleteSshPublicKeyRetry);
      clientSettingsBuilder
          .deleteSshPublicKeySettings()
          .setRetrySettings(deleteSshPublicKeyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteSshPublicKey from properties.");
      }
    }
    Retry getLoginProfileRetry = clientProperties.getGetLoginProfileRetry();
    if (getLoginProfileRetry != null) {
      RetrySettings getLoginProfileRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLoginProfileSettings().getRetrySettings(),
              getLoginProfileRetry);
      clientSettingsBuilder
          .getLoginProfileSettings()
          .setRetrySettings(getLoginProfileRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLoginProfile from properties.");
      }
    }
    Retry getSshPublicKeyRetry = clientProperties.getGetSshPublicKeyRetry();
    if (getSshPublicKeyRetry != null) {
      RetrySettings getSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSshPublicKeySettings().getRetrySettings(),
              getSshPublicKeyRetry);
      clientSettingsBuilder
          .getSshPublicKeySettings()
          .setRetrySettings(getSshPublicKeyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getSshPublicKey from properties.");
      }
    }
    Retry importSshPublicKeyRetry = clientProperties.getImportSshPublicKeyRetry();
    if (importSshPublicKeyRetry != null) {
      RetrySettings importSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.importSshPublicKeySettings().getRetrySettings(),
              importSshPublicKeyRetry);
      clientSettingsBuilder
          .importSshPublicKeySettings()
          .setRetrySettings(importSshPublicKeyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for importSshPublicKey from properties.");
      }
    }
    Retry updateSshPublicKeyRetry = clientProperties.getUpdateSshPublicKeyRetry();
    if (updateSshPublicKeyRetry != null) {
      RetrySettings updateSshPublicKeyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSshPublicKeySettings().getRetrySettings(),
              updateSshPublicKeyRetry);
      clientSettingsBuilder
          .updateSshPublicKeySettings()
          .setRetrySettings(updateSshPublicKeyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateSshPublicKey from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a OsLoginServiceClient bean configured with OsLoginServiceSettings.
   *
   * @param osLoginServiceSettings settings to configure an instance of client bean.
   * @return a {@link OsLoginServiceClient} bean configured with {@link OsLoginServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public OsLoginServiceClient osLoginServiceClient(OsLoginServiceSettings osLoginServiceSettings)
      throws IOException {
    return OsLoginServiceClient.create(osLoginServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-os-login-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
