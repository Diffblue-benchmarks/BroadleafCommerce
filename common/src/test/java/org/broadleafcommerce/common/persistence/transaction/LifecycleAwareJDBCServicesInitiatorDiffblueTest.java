/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.boot.registry.selector.internal.StrategySelectorImpl;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.integrator.spi.IntegratorService;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.junit.Test;

public class LifecycleAwareJDBCServicesInitiatorDiffblueTest {
  /**
   * Test
   * {@link LifecycleAwareJDBCServicesInitiator#initiateService(Map, ServiceRegistryImplementor)}.
   * <p>
   * Method under test:
   * {@link LifecycleAwareJDBCServicesInitiator#initiateService(Map, ServiceRegistryImplementor)}
   */
  @Test
  public void testInitiateService() {
    // Arrange
    HashMap<Object, Object> configurationValues = new HashMap<>();
    ClassLoaderServiceImpl classLoaderService = new ClassLoaderServiceImpl();

    // Act
    JdbcServices actualInitiateServiceResult = LifecycleAwareJDBCServicesInitiator.INSTANCE
        .initiateService(configurationValues, new BootstrapServiceRegistryImpl(classLoaderService,
            new StrategySelectorImpl(new ClassLoaderServiceImpl()), mock(IntegratorService.class)));

    // Assert
    assertTrue(actualInitiateServiceResult instanceof LifecycleAwareJDBCServices);
    assertNull(actualInitiateServiceResult.getDialect());
    assertNull(actualInitiateServiceResult.getExtractedMetaDataSupport());
    assertNull(actualInitiateServiceResult.getJdbcEnvironment());
    assertNull(actualInitiateServiceResult.getResultSetWrapper());
    assertNull(actualInitiateServiceResult.getSqlExceptionHelper());
  }

  /**
   * Test
   * {@link LifecycleAwareJDBCServicesInitiator#initiateService(Map, ServiceRegistryImplementor)}.
   * <ul>
   *   <li>When
   * {@link BootstrapServiceRegistryImpl#BootstrapServiceRegistryImpl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LifecycleAwareJDBCServicesInitiator#initiateService(Map, ServiceRegistryImplementor)}
   */
  @Test
  public void testInitiateService_whenBootstrapServiceRegistryImpl() {
    // Arrange
    HashMap<Object, Object> configurationValues = new HashMap<>();

    // Act
    JdbcServices actualInitiateServiceResult = LifecycleAwareJDBCServicesInitiator.INSTANCE
        .initiateService(configurationValues, new BootstrapServiceRegistryImpl());

    // Assert
    assertTrue(actualInitiateServiceResult instanceof LifecycleAwareJDBCServices);
    assertNull(actualInitiateServiceResult.getDialect());
    assertNull(actualInitiateServiceResult.getExtractedMetaDataSupport());
    assertNull(actualInitiateServiceResult.getJdbcEnvironment());
    assertNull(actualInitiateServiceResult.getResultSetWrapper());
    assertNull(actualInitiateServiceResult.getSqlExceptionHelper());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link LifecycleAwareJDBCServicesInitiator}
   *   <li>{@link LifecycleAwareJDBCServicesInitiator#getServiceInitiated()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Class<JdbcServices> actualServiceInitiated = (new LifecycleAwareJDBCServicesInitiator()).getServiceInitiated();

    // Assert
    Class<JdbcServices> expectedServiceInitiated = JdbcServices.class;
    assertEquals(expectedServiceInitiated, actualServiceInitiated);
  }
}
