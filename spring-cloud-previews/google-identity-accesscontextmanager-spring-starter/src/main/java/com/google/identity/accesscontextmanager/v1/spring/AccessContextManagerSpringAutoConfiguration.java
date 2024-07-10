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

package com.google.identity.accesscontextmanager.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerClient;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerSettings;
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
 * Auto-configuration for {@link AccessContextManagerClient}.
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
@ConditionalOnClass(AccessContextManagerClient.class)
@ConditionalOnProperty(
    value = "com.google.identity.accesscontextmanager.v1.access-context-manager.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(AccessContextManagerSpringProperties.class)
public class AccessContextManagerSpringAutoConfiguration {
  private final AccessContextManagerSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(AccessContextManagerSpringAutoConfiguration.class);

  protected AccessContextManagerSpringAutoConfiguration(
      AccessContextManagerSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from AccessContextManager-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultAccessContextManagerTransportChannelProvider")
  public TransportChannelProvider defaultAccessContextManagerTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return AccessContextManagerSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return AccessContextManagerSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a AccessContextManagerSettings bean configured to use a DefaultCredentialsProvider and
   * the client library's default transport channel provider
   * (defaultAccessContextManagerTransportChannelProvider()). It also configures the quota project
   * ID and executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in AccessContextManagerSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link AccessContextManagerSettings} bean configured with {@link
   *     TransportChannelProvider} bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public AccessContextManagerSettings accessContextManagerSettings(
      @Qualifier("defaultAccessContextManagerTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    AccessContextManagerSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = AccessContextManagerSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = AccessContextManagerSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(AccessContextManagerSettings.getDefaultEndpoint())
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
          AccessContextManagerSettings.defaultExecutorProviderBuilder()
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
      RetrySettings listAccessPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAccessPoliciesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listAccessPoliciesSettings()
          .setRetrySettings(listAccessPoliciesRetrySettings);

      RetrySettings getAccessPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAccessPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getAccessPolicySettings()
          .setRetrySettings(getAccessPolicyRetrySettings);

      RetrySettings listAccessLevelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAccessLevelsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listAccessLevelsSettings()
          .setRetrySettings(listAccessLevelsRetrySettings);

      RetrySettings getAccessLevelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAccessLevelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getAccessLevelSettings().setRetrySettings(getAccessLevelRetrySettings);

      RetrySettings listServicePerimetersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listServicePerimetersSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listServicePerimetersSettings()
          .setRetrySettings(listServicePerimetersRetrySettings);

      RetrySettings getServicePerimeterRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getServicePerimeterSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getServicePerimeterSettings()
          .setRetrySettings(getServicePerimeterRetrySettings);

      RetrySettings listGcpUserAccessBindingsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGcpUserAccessBindingsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listGcpUserAccessBindingsSettings()
          .setRetrySettings(listGcpUserAccessBindingsRetrySettings);

      RetrySettings getGcpUserAccessBindingRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGcpUserAccessBindingSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getGcpUserAccessBindingSettings()
          .setRetrySettings(getGcpUserAccessBindingRetrySettings);

      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);

      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);

      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry listAccessPoliciesRetry = clientProperties.getListAccessPoliciesRetry();
    if (listAccessPoliciesRetry != null) {
      RetrySettings listAccessPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAccessPoliciesSettings().getRetrySettings(),
              listAccessPoliciesRetry);
      clientSettingsBuilder
          .listAccessPoliciesSettings()
          .setRetrySettings(listAccessPoliciesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listAccessPolicies from properties.");
      }
    }
    Retry getAccessPolicyRetry = clientProperties.getGetAccessPolicyRetry();
    if (getAccessPolicyRetry != null) {
      RetrySettings getAccessPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAccessPolicySettings().getRetrySettings(),
              getAccessPolicyRetry);
      clientSettingsBuilder
          .getAccessPolicySettings()
          .setRetrySettings(getAccessPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getAccessPolicy from properties.");
      }
    }
    Retry listAccessLevelsRetry = clientProperties.getListAccessLevelsRetry();
    if (listAccessLevelsRetry != null) {
      RetrySettings listAccessLevelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAccessLevelsSettings().getRetrySettings(),
              listAccessLevelsRetry);
      clientSettingsBuilder
          .listAccessLevelsSettings()
          .setRetrySettings(listAccessLevelsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listAccessLevels from properties.");
      }
    }
    Retry getAccessLevelRetry = clientProperties.getGetAccessLevelRetry();
    if (getAccessLevelRetry != null) {
      RetrySettings getAccessLevelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAccessLevelSettings().getRetrySettings(),
              getAccessLevelRetry);
      clientSettingsBuilder.getAccessLevelSettings().setRetrySettings(getAccessLevelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getAccessLevel from properties.");
      }
    }
    Retry listServicePerimetersRetry = clientProperties.getListServicePerimetersRetry();
    if (listServicePerimetersRetry != null) {
      RetrySettings listServicePerimetersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listServicePerimetersSettings().getRetrySettings(),
              listServicePerimetersRetry);
      clientSettingsBuilder
          .listServicePerimetersSettings()
          .setRetrySettings(listServicePerimetersRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listServicePerimeters from properties.");
      }
    }
    Retry getServicePerimeterRetry = clientProperties.getGetServicePerimeterRetry();
    if (getServicePerimeterRetry != null) {
      RetrySettings getServicePerimeterRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getServicePerimeterSettings().getRetrySettings(),
              getServicePerimeterRetry);
      clientSettingsBuilder
          .getServicePerimeterSettings()
          .setRetrySettings(getServicePerimeterRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getServicePerimeter from properties.");
      }
    }
    Retry listGcpUserAccessBindingsRetry = clientProperties.getListGcpUserAccessBindingsRetry();
    if (listGcpUserAccessBindingsRetry != null) {
      RetrySettings listGcpUserAccessBindingsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGcpUserAccessBindingsSettings().getRetrySettings(),
              listGcpUserAccessBindingsRetry);
      clientSettingsBuilder
          .listGcpUserAccessBindingsSettings()
          .setRetrySettings(listGcpUserAccessBindingsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listGcpUserAccessBindings from properties.");
      }
    }
    Retry getGcpUserAccessBindingRetry = clientProperties.getGetGcpUserAccessBindingRetry();
    if (getGcpUserAccessBindingRetry != null) {
      RetrySettings getGcpUserAccessBindingRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGcpUserAccessBindingSettings().getRetrySettings(),
              getGcpUserAccessBindingRetry);
      clientSettingsBuilder
          .getGcpUserAccessBindingSettings()
          .setRetrySettings(getGcpUserAccessBindingRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getGcpUserAccessBinding from properties.");
      }
    }
    Retry setIamPolicyRetry = clientProperties.getSetIamPolicyRetry();
    if (setIamPolicyRetry != null) {
      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), setIamPolicyRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for setIamPolicy from properties.");
      }
    }
    Retry getIamPolicyRetry = clientProperties.getGetIamPolicyRetry();
    if (getIamPolicyRetry != null) {
      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), getIamPolicyRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getIamPolicy from properties.");
      }
    }
    Retry testIamPermissionsRetry = clientProperties.getTestIamPermissionsRetry();
    if (testIamPermissionsRetry != null) {
      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(),
              testIamPermissionsRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for testIamPermissions from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a AccessContextManagerClient bean configured with AccessContextManagerSettings.
   *
   * @param accessContextManagerSettings settings to configure an instance of client bean.
   * @return a {@link AccessContextManagerClient} bean configured with {@link
   *     AccessContextManagerSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public AccessContextManagerClient accessContextManagerClient(
      AccessContextManagerSettings accessContextManagerSettings) throws IOException {
    return AccessContextManagerClient.create(accessContextManagerSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-access-context-manager";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
