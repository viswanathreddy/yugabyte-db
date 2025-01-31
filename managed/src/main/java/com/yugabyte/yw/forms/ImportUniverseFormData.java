// Copyright (c) YugaByte, Inc.

package com.yugabyte.yw.forms;

import java.util.UUID;

import com.yugabyte.yw.commissioner.Common.CloudType;

import play.data.validation.Constraints;

public class ImportUniverseFormData {
  public static final String DEFAULT_INSTANCE = "default-type";

  public enum State {
    BEGIN,
    IMPORTED_MASTERS,
    IMPORTED_TSERVERS,
    FINISHED
  }

  // The name for the universe being imported.
  @Constraints.Required
  public String universeName;

  // The master addresses of the universe to import.
  @Constraints.Required
  public String masterAddresses;

  // The cloud provider type.
  public String cloudProviderType = CloudType.other.name();

  // State of the import.
  public State currentState = State.BEGIN;

  // The UUID of the universe, if it is already created and uuid is known.
  public UUID universeUUID;

  // Default values of cloud, region and zone for importing a universe.
  public final String cloudName = "My Cloud";
  public final CloudType providerType = CloudType.other;
  public final String regionName = "Region 1";
  public final String regionCode = "region-1";
  public final String zoneName = "Zone 1";
  public final String zoneCode = "zone-1";

  public final String instanceType = DEFAULT_INSTANCE;
  public final int replicationFactor = 1;
}
