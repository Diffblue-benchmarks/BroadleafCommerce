/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.internal.SessionFactoryOptionsBuilder;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.boot.spi.SessionFactoryBuilderImplementor;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.service.internal.ProvidedService;
import org.hibernate.type.Type;
import org.junit.Ignore;
import org.junit.Test;

public class HibernateMappingProviderDiffblueTest {
  /**
   * Test {@link HibernateMappingProvider#HibernateMappingProvider()}.
   * <p>
   * Method under test:
   * {@link HibernateMappingProvider#HibernateMappingProvider()}
   */
  @Test
  public void testNewHibernateMappingProvider() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new HibernateMappingProvider();
  }

  /**
   * Test {@link HibernateMappingProvider#HibernateMappingProvider(Map)}.
   * <p>
   * Method under test:
   * {@link HibernateMappingProvider#HibernateMappingProvider(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewHibernateMappingProvider2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.hibernate.service.UnknownServiceException: Unknown service requested [org.hibernate.engine.config.spi.ConfigurationService]
    //       at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:210)
    //       at org.hibernate.boot.internal.MetadataBuilderImpl$MetadataBuildingOptionsImpl.<init>(MetadataBuilderImpl.java:631)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    HibernateMappingProvider actualHibernateMappingProvider = new HibernateMappingProvider(new HashMap<>());
    BootstrapServiceRegistryImpl bootstrapServiceRegistry = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators = new ArrayList<>();
    ArrayList<ProvidedService> providedServices = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry = new StandardServiceRegistryImpl(bootstrapServiceRegistry,
        serviceInitiators, providedServices, new HashMap<>());

    BootstrapServiceRegistryImpl bootstrapServiceRegistry2 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators2 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices2 = new ArrayList<>();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(serviceRegistry,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(bootstrapServiceRegistry2,
            serviceInitiators2, providedServices2, new HashMap<>())));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry3 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators3 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices3 = new ArrayList<>();
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(bootstrapServiceRegistry3,
            serviceInitiators3, providedServices3, new HashMap<>())));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry4 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators4 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices4 = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry2 = new StandardServiceRegistryImpl(bootstrapServiceRegistry4,
        serviceInitiators4, providedServices4, new HashMap<>());

    BootstrapServiceRegistryImpl bootstrapServiceRegistry5 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators5 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices5 = new ArrayList<>();
    BootstrapContextImpl bootstrapContext2 = new BootstrapContextImpl(serviceRegistry2,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(bootstrapServiceRegistry5,
            serviceInitiators5, providedServices5, new HashMap<>())));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry6 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators6 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices6 = new ArrayList<>();
    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(bootstrapContext2,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(bootstrapServiceRegistry6,
            serviceInitiators6, providedServices6, new HashMap<>())));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry7 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators7 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices7 = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry3 = new StandardServiceRegistryImpl(bootstrapServiceRegistry7,
        serviceInitiators7, providedServices7, new HashMap<>());

    BootstrapServiceRegistryImpl bootstrapServiceRegistry8 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators8 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices8 = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry4 = new StandardServiceRegistryImpl(bootstrapServiceRegistry8,
        serviceInitiators8, providedServices8, new HashMap<>());

    BootstrapServiceRegistryImpl bootstrapServiceRegistry9 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators9 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices9 = new ArrayList<>();
    actualHibernateMappingProvider.getSessionFactoryBuilder(metadata,
        new SessionFactoryBuilderImpl(metadata2,
            new SessionFactoryOptionsBuilder(serviceRegistry3,
                new BootstrapContextImpl(serviceRegistry4,
                    new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(
                        bootstrapServiceRegistry9, serviceInitiators9, providedServices9, new HashMap<>()))))));
  }

  /**
   * Test
   * {@link HibernateMappingProvider#getSessionFactoryBuilder(MetadataImplementor, SessionFactoryBuilderImplementor)}.
   * <p>
   * Method under test:
   * {@link HibernateMappingProvider#getSessionFactoryBuilder(MetadataImplementor, SessionFactoryBuilderImplementor)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSessionFactoryBuilder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.hibernate.service.UnknownServiceException: Unknown service requested [org.hibernate.engine.config.spi.ConfigurationService]
    //       at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:210)
    //       at org.hibernate.boot.internal.MetadataBuilderImpl$MetadataBuildingOptionsImpl.<init>(MetadataBuilderImpl.java:631)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HibernateMappingProvider hibernateMappingProvider = new HibernateMappingProvider();
    BootstrapServiceRegistryImpl bootstrapServiceRegistry = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators = new ArrayList<>();
    ArrayList<ProvidedService> providedServices = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry = new StandardServiceRegistryImpl(bootstrapServiceRegistry,
        serviceInitiators, providedServices, new HashMap<>());

    BootstrapServiceRegistryImpl bootstrapServiceRegistry2 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators2 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices2 = new ArrayList<>();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(serviceRegistry,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(bootstrapServiceRegistry2,
            serviceInitiators2, providedServices2, new HashMap<>())));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry3 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators3 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices3 = new ArrayList<>();
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(bootstrapServiceRegistry3,
            serviceInitiators3, providedServices3, new HashMap<>())));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry4 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators4 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices4 = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry2 = new StandardServiceRegistryImpl(bootstrapServiceRegistry4,
        serviceInitiators4, providedServices4, new HashMap<>());

    BootstrapContextImpl bootstrapContext2 = new BootstrapContextImpl(serviceRegistry2,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(mock(StandardServiceRegistry.class)));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry5 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators5 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices5 = new ArrayList<>();
    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(bootstrapContext2,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(new StandardServiceRegistryImpl(bootstrapServiceRegistry5,
            serviceInitiators5, providedServices5, new HashMap<>())));

    BootstrapServiceRegistryImpl bootstrapServiceRegistry6 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators6 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices6 = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry3 = new StandardServiceRegistryImpl(bootstrapServiceRegistry6,
        serviceInitiators6, providedServices6, new HashMap<>());

    BootstrapServiceRegistryImpl bootstrapServiceRegistry7 = new BootstrapServiceRegistryImpl();
    ArrayList<StandardServiceInitiator> serviceInitiators7 = new ArrayList<>();
    ArrayList<ProvidedService> providedServices7 = new ArrayList<>();
    StandardServiceRegistryImpl serviceRegistry4 = new StandardServiceRegistryImpl(bootstrapServiceRegistry7,
        serviceInitiators7, providedServices7, new HashMap<>());

    // Act
    hibernateMappingProvider.getSessionFactoryBuilder(metadata,
        new SessionFactoryBuilderImpl(metadata2,
            new SessionFactoryOptionsBuilder(serviceRegistry3, new BootstrapContextImpl(serviceRegistry4,
                new MetadataBuilderImpl.MetadataBuildingOptionsImpl(mock(StandardServiceRegistry.class))))));
  }

  /**
   * Test {@link HibernateMappingProvider#getMapping(String)}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getMapping(String)}
   */
  @Test
  public void testGetMapping() {
    // Arrange, Act and Assert
    assertNull(HibernateMappingProvider.getMapping("Entity Class"));
  }

  /**
   * Test {@link HibernateMappingProvider#getPropertyNames(String)}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getPropertyNames(String)}
   */
  @Test
  public void testGetPropertyNames() {
    // Arrange and Act
    List<String> actualPropertyNames = HibernateMappingProvider.getPropertyNames("Entity Class");

    // Assert
    assertTrue(actualPropertyNames.isEmpty());
  }

  /**
   * Test {@link HibernateMappingProvider#getPropertyTypes(String)}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getPropertyTypes(String)}
   */
  @Test
  public void testGetPropertyTypes() {
    // Arrange and Act
    List<Type> actualPropertyTypes = HibernateMappingProvider.getPropertyTypes("Entity Class");

    // Assert
    assertTrue(actualPropertyTypes.isEmpty());
  }

  /**
   * Test {@link HibernateMappingProvider#getAllMappings()}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getAllMappings()}
   */
  @Test
  public void testGetAllMappings() {
    // Arrange and Act
    Collection<PersistentClass> actualAllMappings = HibernateMappingProvider.getAllMappings();

    // Assert
    assertTrue(actualAllMappings.isEmpty());
  }
}
