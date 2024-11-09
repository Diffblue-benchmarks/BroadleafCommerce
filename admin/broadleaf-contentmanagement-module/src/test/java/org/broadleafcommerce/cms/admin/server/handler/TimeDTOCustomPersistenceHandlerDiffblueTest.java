/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class TimeDTOCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = timeDTOCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.common.TimeDTO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenOrgBroadleafcommerceCommonTimeDTO_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.TimeDTO");

    // Act
    Boolean actualCanHandleFetchResult = timeDTOCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenRequestDTOCustomPersistenceHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler = new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleAddResult = timeDTOCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.common.TimeDTO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenOrgBroadleafcommerceCommonTimeDTO_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.TimeDTO");

    // Act
    Boolean actualCanHandleAddResult = timeDTOCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default
   * constructor).</li>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenRequestDTOCustomPersistenceHandler_whenPersistencePackage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler = new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleRemoveResult = timeDTOCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.common.TimeDTO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenOrgBroadleafcommerceCommonTimeDTO_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.TimeDTO");

    // Act
    Boolean actualCanHandleRemoveResult = timeDTOCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenRequestDTOCustomPersistenceHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler = new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleUpdateResult = timeDTOCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.common.TimeDTO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenOrgBroadleafcommerceCommonTimeDTO_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.TimeDTO");

    // Act
    Boolean actualCanHandleUpdateResult = timeDTOCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link RequestDTOCustomPersistenceHandler} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenRequestDTOCustomPersistenceHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler = new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleInspectResult = timeDTOCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.common.TimeDTO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenOrgBroadleafcommerceCommonTimeDTO_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.TimeDTO");

    // Act
    Boolean actualCanHandleInspectResult = timeDTOCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(timeDTOCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test
   * {@link TimeDTOCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeDTOCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  public void testInspect_givenHashMap_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeDTOCustomPersistenceHandler timeDTOCustomPersistenceHandler = new TimeDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> timeDTOCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl()));
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(dynamicEntityDao).getSimpleMergedProperties(eq("Dr Jane Doe"), isA(PersistencePerspective.class));
  }
}
