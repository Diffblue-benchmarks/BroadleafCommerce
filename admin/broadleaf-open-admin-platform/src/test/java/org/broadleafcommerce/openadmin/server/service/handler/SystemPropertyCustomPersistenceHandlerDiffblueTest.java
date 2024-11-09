/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class SystemPropertyCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}
   */
  @Test
  public void testClassMatches_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualClassMatchesResult = systemPropertyCustomPersistenceHandler.classMatches(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualClassMatchesResult);
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}
   */
  @Test
  public void testClassMatches_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.config.domain.SystemProperty");

    // Act
    Boolean actualClassMatchesResult = systemPropertyCustomPersistenceHandler.classMatches(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualClassMatchesResult);
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#classMatches(PersistencePackage)}
   */
  @Test
  public void testClassMatches_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();

    // Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.classMatches(new PersistencePackage()));
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleAddResult = systemPropertyCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.config.domain.SystemProperty");

    // Act
    Boolean actualCanHandleAddResult = systemPropertyCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();

    // Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleUpdateResult = systemPropertyCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.config.domain.SystemProperty");

    // Act
    Boolean actualCanHandleUpdateResult = systemPropertyCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();

    // Act and Assert
    assertFalse(systemPropertyCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> systemPropertyCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity).getType();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.common.config.domain.SystemProperty"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of
   * {@link String} with {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithJavaUtilList() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"java.util.List"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> systemPropertyCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }

  /**
   * Test
   * {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of
   * {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyCustomPersistenceHandler systemPropertyCustomPersistenceHandler = new SystemPropertyCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> systemPropertyCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
  }
}
