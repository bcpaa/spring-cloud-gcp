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

package com.google.cloud.aiplatform.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.aiplatform.v1.VizierServiceClient;
import com.google.cloud.aiplatform.v1.VizierServiceSettings;
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
 * Auto-configuration for {@link VizierServiceClient}.
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
@ConditionalOnClass(VizierServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.aiplatform.v1.vizier-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(VizierServiceSpringProperties.class)
public class VizierServiceSpringAutoConfiguration {
  private final VizierServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(VizierServiceSpringAutoConfiguration.class);

  protected VizierServiceSpringAutoConfiguration(
      VizierServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from VizierService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Provides a default transport channel provider bean. The default is gRPC and will default to it
   * unless the useRest option is provided to use HTTP transport instead
   *
   * @return a default transport channel provider.
   */
  @Bean
  @ConditionalOnMissingBean(name = "defaultVizierServiceTransportChannelProvider")
  public TransportChannelProvider defaultVizierServiceTransportChannelProvider() {
    return VizierServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a VizierServiceSettings bean configured to use the default credentials provider
   * (obtained with vizierServiceCredentials()) and its default transport channel provider
   * (defaultVizierServiceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in VizierServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link VizierServiceSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public VizierServiceSettings vizierServiceSettings(
      @Qualifier("defaultVizierServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    VizierServiceSettings.Builder clientSettingsBuilder = VizierServiceSettings.newBuilder();
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
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
          VizierServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings createStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createStudySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createStudySettings().setRetrySettings(createStudyRetrySettings);

      RetrySettings getStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getStudySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getStudySettings().setRetrySettings(getStudyRetrySettings);

      RetrySettings listStudiesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listStudiesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listStudiesSettings().setRetrySettings(listStudiesRetrySettings);

      RetrySettings deleteStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteStudySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteStudySettings().setRetrySettings(deleteStudyRetrySettings);

      RetrySettings lookupStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.lookupStudySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.lookupStudySettings().setRetrySettings(lookupStudyRetrySettings);

      RetrySettings createTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createTrialSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createTrialSettings().setRetrySettings(createTrialRetrySettings);

      RetrySettings getTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTrialSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getTrialSettings().setRetrySettings(getTrialRetrySettings);

      RetrySettings listTrialsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTrialsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listTrialsSettings().setRetrySettings(listTrialsRetrySettings);

      RetrySettings addTrialMeasurementRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.addTrialMeasurementSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .addTrialMeasurementSettings()
          .setRetrySettings(addTrialMeasurementRetrySettings);

      RetrySettings completeTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.completeTrialSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.completeTrialSettings().setRetrySettings(completeTrialRetrySettings);

      RetrySettings deleteTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteTrialSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteTrialSettings().setRetrySettings(deleteTrialRetrySettings);

      RetrySettings stopTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.stopTrialSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.stopTrialSettings().setRetrySettings(stopTrialRetrySettings);

      RetrySettings listOptimalTrialsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listOptimalTrialsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listOptimalTrialsSettings()
          .setRetrySettings(listOptimalTrialsRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

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
    Retry createStudyRetry = clientProperties.getCreateStudyRetry();
    if (createStudyRetry != null) {
      RetrySettings createStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createStudySettings().getRetrySettings(), createStudyRetry);
      clientSettingsBuilder.createStudySettings().setRetrySettings(createStudyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createStudy from properties.");
      }
    }
    Retry getStudyRetry = clientProperties.getGetStudyRetry();
    if (getStudyRetry != null) {
      RetrySettings getStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getStudySettings().getRetrySettings(), getStudyRetry);
      clientSettingsBuilder.getStudySettings().setRetrySettings(getStudyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getStudy from properties.");
      }
    }
    Retry listStudiesRetry = clientProperties.getListStudiesRetry();
    if (listStudiesRetry != null) {
      RetrySettings listStudiesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listStudiesSettings().getRetrySettings(), listStudiesRetry);
      clientSettingsBuilder.listStudiesSettings().setRetrySettings(listStudiesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listStudies from properties.");
      }
    }
    Retry deleteStudyRetry = clientProperties.getDeleteStudyRetry();
    if (deleteStudyRetry != null) {
      RetrySettings deleteStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteStudySettings().getRetrySettings(), deleteStudyRetry);
      clientSettingsBuilder.deleteStudySettings().setRetrySettings(deleteStudyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteStudy from properties.");
      }
    }
    Retry lookupStudyRetry = clientProperties.getLookupStudyRetry();
    if (lookupStudyRetry != null) {
      RetrySettings lookupStudyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.lookupStudySettings().getRetrySettings(), lookupStudyRetry);
      clientSettingsBuilder.lookupStudySettings().setRetrySettings(lookupStudyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for lookupStudy from properties.");
      }
    }
    Retry createTrialRetry = clientProperties.getCreateTrialRetry();
    if (createTrialRetry != null) {
      RetrySettings createTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createTrialSettings().getRetrySettings(), createTrialRetry);
      clientSettingsBuilder.createTrialSettings().setRetrySettings(createTrialRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createTrial from properties.");
      }
    }
    Retry getTrialRetry = clientProperties.getGetTrialRetry();
    if (getTrialRetry != null) {
      RetrySettings getTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTrialSettings().getRetrySettings(), getTrialRetry);
      clientSettingsBuilder.getTrialSettings().setRetrySettings(getTrialRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getTrial from properties.");
      }
    }
    Retry listTrialsRetry = clientProperties.getListTrialsRetry();
    if (listTrialsRetry != null) {
      RetrySettings listTrialsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTrialsSettings().getRetrySettings(), listTrialsRetry);
      clientSettingsBuilder.listTrialsSettings().setRetrySettings(listTrialsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listTrials from properties.");
      }
    }
    Retry addTrialMeasurementRetry = clientProperties.getAddTrialMeasurementRetry();
    if (addTrialMeasurementRetry != null) {
      RetrySettings addTrialMeasurementRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.addTrialMeasurementSettings().getRetrySettings(),
              addTrialMeasurementRetry);
      clientSettingsBuilder
          .addTrialMeasurementSettings()
          .setRetrySettings(addTrialMeasurementRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for addTrialMeasurement from properties.");
      }
    }
    Retry completeTrialRetry = clientProperties.getCompleteTrialRetry();
    if (completeTrialRetry != null) {
      RetrySettings completeTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.completeTrialSettings().getRetrySettings(), completeTrialRetry);
      clientSettingsBuilder.completeTrialSettings().setRetrySettings(completeTrialRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for completeTrial from properties.");
      }
    }
    Retry deleteTrialRetry = clientProperties.getDeleteTrialRetry();
    if (deleteTrialRetry != null) {
      RetrySettings deleteTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteTrialSettings().getRetrySettings(), deleteTrialRetry);
      clientSettingsBuilder.deleteTrialSettings().setRetrySettings(deleteTrialRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteTrial from properties.");
      }
    }
    Retry stopTrialRetry = clientProperties.getStopTrialRetry();
    if (stopTrialRetry != null) {
      RetrySettings stopTrialRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.stopTrialSettings().getRetrySettings(), stopTrialRetry);
      clientSettingsBuilder.stopTrialSettings().setRetrySettings(stopTrialRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for stopTrial from properties.");
      }
    }
    Retry listOptimalTrialsRetry = clientProperties.getListOptimalTrialsRetry();
    if (listOptimalTrialsRetry != null) {
      RetrySettings listOptimalTrialsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listOptimalTrialsSettings().getRetrySettings(),
              listOptimalTrialsRetry);
      clientSettingsBuilder
          .listOptimalTrialsSettings()
          .setRetrySettings(listOptimalTrialsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listOptimalTrials from properties.");
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
   * Provides a VizierServiceClient bean configured with VizierServiceSettings.
   *
   * @param vizierServiceSettings settings to configure an instance of client bean.
   * @return a {@link VizierServiceClient} bean configured with {@link VizierServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public VizierServiceClient vizierServiceClient(VizierServiceSettings vizierServiceSettings)
      throws IOException {
    return VizierServiceClient.create(vizierServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-vizier-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
