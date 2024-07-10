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

package com.google.cloud.domains.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.domains.v1.DomainsClient;
import com.google.cloud.domains.v1.DomainsSettings;
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
 * Auto-configuration for {@link DomainsClient}.
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
@ConditionalOnClass(DomainsClient.class)
@ConditionalOnProperty(value = "com.google.cloud.domains.v1.domains.enabled", matchIfMissing = true)
@EnableConfigurationProperties(DomainsSpringProperties.class)
public class DomainsSpringAutoConfiguration {
  private final DomainsSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(DomainsSpringAutoConfiguration.class);

  protected DomainsSpringAutoConfiguration(
      DomainsSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from Domains-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultDomainsTransportChannelProvider")
  public TransportChannelProvider defaultDomainsTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return DomainsSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return DomainsSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a DomainsSettings bean configured to use a DefaultCredentialsProvider and the client
   * library's default transport channel provider (defaultDomainsTransportChannelProvider()). It
   * also configures the quota project ID and executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in DomainsSpringProperties. Method-level properties will take precedence over service-level
   * properties if available, and client library defaults will be used if neither are specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link DomainsSettings} bean configured with {@link TransportChannelProvider} bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public DomainsSettings domainsSettings(
      @Qualifier("defaultDomainsTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    DomainsSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = DomainsSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = DomainsSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(DomainsSettings.getDefaultEndpoint())
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
          DomainsSettings.defaultExecutorProviderBuilder()
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
      RetrySettings searchDomainsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.searchDomainsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.searchDomainsSettings().setRetrySettings(searchDomainsRetrySettings);

      RetrySettings retrieveRegisterParametersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.retrieveRegisterParametersSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .retrieveRegisterParametersSettings()
          .setRetrySettings(retrieveRegisterParametersRetrySettings);

      RetrySettings retrieveTransferParametersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.retrieveTransferParametersSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .retrieveTransferParametersSettings()
          .setRetrySettings(retrieveTransferParametersRetrySettings);

      RetrySettings listRegistrationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRegistrationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listRegistrationsSettings()
          .setRetrySettings(listRegistrationsRetrySettings);

      RetrySettings getRegistrationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRegistrationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getRegistrationSettings()
          .setRetrySettings(getRegistrationRetrySettings);

      RetrySettings retrieveAuthorizationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.retrieveAuthorizationCodeSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .retrieveAuthorizationCodeSettings()
          .setRetrySettings(retrieveAuthorizationCodeRetrySettings);

      RetrySettings resetAuthorizationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.resetAuthorizationCodeSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .resetAuthorizationCodeSettings()
          .setRetrySettings(resetAuthorizationCodeRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry searchDomainsRetry = clientProperties.getSearchDomainsRetry();
    if (searchDomainsRetry != null) {
      RetrySettings searchDomainsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.searchDomainsSettings().getRetrySettings(), searchDomainsRetry);
      clientSettingsBuilder.searchDomainsSettings().setRetrySettings(searchDomainsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for searchDomains from properties.");
      }
    }
    Retry retrieveRegisterParametersRetry = clientProperties.getRetrieveRegisterParametersRetry();
    if (retrieveRegisterParametersRetry != null) {
      RetrySettings retrieveRegisterParametersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.retrieveRegisterParametersSettings().getRetrySettings(),
              retrieveRegisterParametersRetry);
      clientSettingsBuilder
          .retrieveRegisterParametersSettings()
          .setRetrySettings(retrieveRegisterParametersRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for retrieveRegisterParameters from properties.");
      }
    }
    Retry retrieveTransferParametersRetry = clientProperties.getRetrieveTransferParametersRetry();
    if (retrieveTransferParametersRetry != null) {
      RetrySettings retrieveTransferParametersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.retrieveTransferParametersSettings().getRetrySettings(),
              retrieveTransferParametersRetry);
      clientSettingsBuilder
          .retrieveTransferParametersSettings()
          .setRetrySettings(retrieveTransferParametersRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for retrieveTransferParameters from properties.");
      }
    }
    Retry listRegistrationsRetry = clientProperties.getListRegistrationsRetry();
    if (listRegistrationsRetry != null) {
      RetrySettings listRegistrationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRegistrationsSettings().getRetrySettings(),
              listRegistrationsRetry);
      clientSettingsBuilder
          .listRegistrationsSettings()
          .setRetrySettings(listRegistrationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listRegistrations from properties.");
      }
    }
    Retry getRegistrationRetry = clientProperties.getGetRegistrationRetry();
    if (getRegistrationRetry != null) {
      RetrySettings getRegistrationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRegistrationSettings().getRetrySettings(),
              getRegistrationRetry);
      clientSettingsBuilder
          .getRegistrationSettings()
          .setRetrySettings(getRegistrationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getRegistration from properties.");
      }
    }
    Retry retrieveAuthorizationCodeRetry = clientProperties.getRetrieveAuthorizationCodeRetry();
    if (retrieveAuthorizationCodeRetry != null) {
      RetrySettings retrieveAuthorizationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.retrieveAuthorizationCodeSettings().getRetrySettings(),
              retrieveAuthorizationCodeRetry);
      clientSettingsBuilder
          .retrieveAuthorizationCodeSettings()
          .setRetrySettings(retrieveAuthorizationCodeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for retrieveAuthorizationCode from properties.");
      }
    }
    Retry resetAuthorizationCodeRetry = clientProperties.getResetAuthorizationCodeRetry();
    if (resetAuthorizationCodeRetry != null) {
      RetrySettings resetAuthorizationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.resetAuthorizationCodeSettings().getRetrySettings(),
              resetAuthorizationCodeRetry);
      clientSettingsBuilder
          .resetAuthorizationCodeSettings()
          .setRetrySettings(resetAuthorizationCodeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for resetAuthorizationCode from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a DomainsClient bean configured with DomainsSettings.
   *
   * @param domainsSettings settings to configure an instance of client bean.
   * @return a {@link DomainsClient} bean configured with {@link DomainsSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public DomainsClient domainsClient(DomainsSettings domainsSettings) throws IOException {
    return DomainsClient.create(domainsSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-domains";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
