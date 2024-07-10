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

package com.google.cloud.vmmigration.v1.spring;

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
import com.google.cloud.vmmigration.v1.VmMigrationClient;
import com.google.cloud.vmmigration.v1.VmMigrationSettings;
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
 * Auto-configuration for {@link VmMigrationClient}.
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
@ConditionalOnClass(VmMigrationClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.vmmigration.v1.vm-migration.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(VmMigrationSpringProperties.class)
public class VmMigrationSpringAutoConfiguration {
  private final VmMigrationSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(VmMigrationSpringAutoConfiguration.class);

  protected VmMigrationSpringAutoConfiguration(
      VmMigrationSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from VmMigration-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultVmMigrationTransportChannelProvider")
  public TransportChannelProvider defaultVmMigrationTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return VmMigrationSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return VmMigrationSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a VmMigrationSettings bean configured to use a DefaultCredentialsProvider and the
   * client library's default transport channel provider
   * (defaultVmMigrationTransportChannelProvider()). It also configures the quota project ID and
   * executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in VmMigrationSpringProperties. Method-level properties will take precedence over service-level
   * properties if available, and client library defaults will be used if neither are specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link VmMigrationSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public VmMigrationSettings vmMigrationSettings(
      @Qualifier("defaultVmMigrationTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    VmMigrationSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = VmMigrationSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = VmMigrationSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(VmMigrationSettings.getDefaultEndpoint())
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
          VmMigrationSettings.defaultExecutorProviderBuilder()
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
      RetrySettings listSourcesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSourcesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listSourcesSettings().setRetrySettings(listSourcesRetrySettings);

      RetrySettings getSourceRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSourceSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getSourceSettings().setRetrySettings(getSourceRetrySettings);

      RetrySettings fetchInventoryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.fetchInventorySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.fetchInventorySettings().setRetrySettings(fetchInventoryRetrySettings);

      RetrySettings listUtilizationReportsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listUtilizationReportsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listUtilizationReportsSettings()
          .setRetrySettings(listUtilizationReportsRetrySettings);

      RetrySettings getUtilizationReportRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getUtilizationReportSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getUtilizationReportSettings()
          .setRetrySettings(getUtilizationReportRetrySettings);

      RetrySettings listDatacenterConnectorsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDatacenterConnectorsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listDatacenterConnectorsSettings()
          .setRetrySettings(listDatacenterConnectorsRetrySettings);

      RetrySettings getDatacenterConnectorRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDatacenterConnectorSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getDatacenterConnectorSettings()
          .setRetrySettings(getDatacenterConnectorRetrySettings);

      RetrySettings listMigratingVmsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listMigratingVmsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listMigratingVmsSettings()
          .setRetrySettings(listMigratingVmsRetrySettings);

      RetrySettings getMigratingVmRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getMigratingVmSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getMigratingVmSettings().setRetrySettings(getMigratingVmRetrySettings);

      RetrySettings listCloneJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listCloneJobsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listCloneJobsSettings().setRetrySettings(listCloneJobsRetrySettings);

      RetrySettings getCloneJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getCloneJobSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getCloneJobSettings().setRetrySettings(getCloneJobRetrySettings);

      RetrySettings listCutoverJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listCutoverJobsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listCutoverJobsSettings()
          .setRetrySettings(listCutoverJobsRetrySettings);

      RetrySettings getCutoverJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getCutoverJobSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getCutoverJobSettings().setRetrySettings(getCutoverJobRetrySettings);

      RetrySettings listGroupsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGroupsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listGroupsSettings().setRetrySettings(listGroupsRetrySettings);

      RetrySettings getGroupRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGroupSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getGroupSettings().setRetrySettings(getGroupRetrySettings);

      RetrySettings listTargetProjectsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTargetProjectsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listTargetProjectsSettings()
          .setRetrySettings(listTargetProjectsRetrySettings);

      RetrySettings getTargetProjectRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTargetProjectSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getTargetProjectSettings()
          .setRetrySettings(getTargetProjectRetrySettings);

      RetrySettings listReplicationCyclesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listReplicationCyclesSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listReplicationCyclesSettings()
          .setRetrySettings(listReplicationCyclesRetrySettings);

      RetrySettings getReplicationCycleRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getReplicationCycleSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getReplicationCycleSettings()
          .setRetrySettings(getReplicationCycleRetrySettings);

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
    Retry listSourcesRetry = clientProperties.getListSourcesRetry();
    if (listSourcesRetry != null) {
      RetrySettings listSourcesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSourcesSettings().getRetrySettings(), listSourcesRetry);
      clientSettingsBuilder.listSourcesSettings().setRetrySettings(listSourcesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listSources from properties.");
      }
    }
    Retry getSourceRetry = clientProperties.getGetSourceRetry();
    if (getSourceRetry != null) {
      RetrySettings getSourceRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSourceSettings().getRetrySettings(), getSourceRetry);
      clientSettingsBuilder.getSourceSettings().setRetrySettings(getSourceRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getSource from properties.");
      }
    }
    Retry fetchInventoryRetry = clientProperties.getFetchInventoryRetry();
    if (fetchInventoryRetry != null) {
      RetrySettings fetchInventoryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.fetchInventorySettings().getRetrySettings(),
              fetchInventoryRetry);
      clientSettingsBuilder.fetchInventorySettings().setRetrySettings(fetchInventoryRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for fetchInventory from properties.");
      }
    }
    Retry listUtilizationReportsRetry = clientProperties.getListUtilizationReportsRetry();
    if (listUtilizationReportsRetry != null) {
      RetrySettings listUtilizationReportsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listUtilizationReportsSettings().getRetrySettings(),
              listUtilizationReportsRetry);
      clientSettingsBuilder
          .listUtilizationReportsSettings()
          .setRetrySettings(listUtilizationReportsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listUtilizationReports from properties.");
      }
    }
    Retry getUtilizationReportRetry = clientProperties.getGetUtilizationReportRetry();
    if (getUtilizationReportRetry != null) {
      RetrySettings getUtilizationReportRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getUtilizationReportSettings().getRetrySettings(),
              getUtilizationReportRetry);
      clientSettingsBuilder
          .getUtilizationReportSettings()
          .setRetrySettings(getUtilizationReportRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getUtilizationReport from properties.");
      }
    }
    Retry listDatacenterConnectorsRetry = clientProperties.getListDatacenterConnectorsRetry();
    if (listDatacenterConnectorsRetry != null) {
      RetrySettings listDatacenterConnectorsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDatacenterConnectorsSettings().getRetrySettings(),
              listDatacenterConnectorsRetry);
      clientSettingsBuilder
          .listDatacenterConnectorsSettings()
          .setRetrySettings(listDatacenterConnectorsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listDatacenterConnectors from properties.");
      }
    }
    Retry getDatacenterConnectorRetry = clientProperties.getGetDatacenterConnectorRetry();
    if (getDatacenterConnectorRetry != null) {
      RetrySettings getDatacenterConnectorRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDatacenterConnectorSettings().getRetrySettings(),
              getDatacenterConnectorRetry);
      clientSettingsBuilder
          .getDatacenterConnectorSettings()
          .setRetrySettings(getDatacenterConnectorRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getDatacenterConnector from properties.");
      }
    }
    Retry listMigratingVmsRetry = clientProperties.getListMigratingVmsRetry();
    if (listMigratingVmsRetry != null) {
      RetrySettings listMigratingVmsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listMigratingVmsSettings().getRetrySettings(),
              listMigratingVmsRetry);
      clientSettingsBuilder
          .listMigratingVmsSettings()
          .setRetrySettings(listMigratingVmsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listMigratingVms from properties.");
      }
    }
    Retry getMigratingVmRetry = clientProperties.getGetMigratingVmRetry();
    if (getMigratingVmRetry != null) {
      RetrySettings getMigratingVmRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getMigratingVmSettings().getRetrySettings(),
              getMigratingVmRetry);
      clientSettingsBuilder.getMigratingVmSettings().setRetrySettings(getMigratingVmRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getMigratingVm from properties.");
      }
    }
    Retry listCloneJobsRetry = clientProperties.getListCloneJobsRetry();
    if (listCloneJobsRetry != null) {
      RetrySettings listCloneJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listCloneJobsSettings().getRetrySettings(), listCloneJobsRetry);
      clientSettingsBuilder.listCloneJobsSettings().setRetrySettings(listCloneJobsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listCloneJobs from properties.");
      }
    }
    Retry getCloneJobRetry = clientProperties.getGetCloneJobRetry();
    if (getCloneJobRetry != null) {
      RetrySettings getCloneJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getCloneJobSettings().getRetrySettings(), getCloneJobRetry);
      clientSettingsBuilder.getCloneJobSettings().setRetrySettings(getCloneJobRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getCloneJob from properties.");
      }
    }
    Retry listCutoverJobsRetry = clientProperties.getListCutoverJobsRetry();
    if (listCutoverJobsRetry != null) {
      RetrySettings listCutoverJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listCutoverJobsSettings().getRetrySettings(),
              listCutoverJobsRetry);
      clientSettingsBuilder
          .listCutoverJobsSettings()
          .setRetrySettings(listCutoverJobsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listCutoverJobs from properties.");
      }
    }
    Retry getCutoverJobRetry = clientProperties.getGetCutoverJobRetry();
    if (getCutoverJobRetry != null) {
      RetrySettings getCutoverJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getCutoverJobSettings().getRetrySettings(), getCutoverJobRetry);
      clientSettingsBuilder.getCutoverJobSettings().setRetrySettings(getCutoverJobRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getCutoverJob from properties.");
      }
    }
    Retry listGroupsRetry = clientProperties.getListGroupsRetry();
    if (listGroupsRetry != null) {
      RetrySettings listGroupsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGroupsSettings().getRetrySettings(), listGroupsRetry);
      clientSettingsBuilder.listGroupsSettings().setRetrySettings(listGroupsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listGroups from properties.");
      }
    }
    Retry getGroupRetry = clientProperties.getGetGroupRetry();
    if (getGroupRetry != null) {
      RetrySettings getGroupRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGroupSettings().getRetrySettings(), getGroupRetry);
      clientSettingsBuilder.getGroupSettings().setRetrySettings(getGroupRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getGroup from properties.");
      }
    }
    Retry listTargetProjectsRetry = clientProperties.getListTargetProjectsRetry();
    if (listTargetProjectsRetry != null) {
      RetrySettings listTargetProjectsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTargetProjectsSettings().getRetrySettings(),
              listTargetProjectsRetry);
      clientSettingsBuilder
          .listTargetProjectsSettings()
          .setRetrySettings(listTargetProjectsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listTargetProjects from properties.");
      }
    }
    Retry getTargetProjectRetry = clientProperties.getGetTargetProjectRetry();
    if (getTargetProjectRetry != null) {
      RetrySettings getTargetProjectRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTargetProjectSettings().getRetrySettings(),
              getTargetProjectRetry);
      clientSettingsBuilder
          .getTargetProjectSettings()
          .setRetrySettings(getTargetProjectRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getTargetProject from properties.");
      }
    }
    Retry listReplicationCyclesRetry = clientProperties.getListReplicationCyclesRetry();
    if (listReplicationCyclesRetry != null) {
      RetrySettings listReplicationCyclesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listReplicationCyclesSettings().getRetrySettings(),
              listReplicationCyclesRetry);
      clientSettingsBuilder
          .listReplicationCyclesSettings()
          .setRetrySettings(listReplicationCyclesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listReplicationCycles from properties.");
      }
    }
    Retry getReplicationCycleRetry = clientProperties.getGetReplicationCycleRetry();
    if (getReplicationCycleRetry != null) {
      RetrySettings getReplicationCycleRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getReplicationCycleSettings().getRetrySettings(),
              getReplicationCycleRetry);
      clientSettingsBuilder
          .getReplicationCycleSettings()
          .setRetrySettings(getReplicationCycleRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getReplicationCycle from properties.");
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
   * Provides a VmMigrationClient bean configured with VmMigrationSettings.
   *
   * @param vmMigrationSettings settings to configure an instance of client bean.
   * @return a {@link VmMigrationClient} bean configured with {@link VmMigrationSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public VmMigrationClient vmMigrationClient(VmMigrationSettings vmMigrationSettings)
      throws IOException {
    return VmMigrationClient.create(vmMigrationSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-vm-migration";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
