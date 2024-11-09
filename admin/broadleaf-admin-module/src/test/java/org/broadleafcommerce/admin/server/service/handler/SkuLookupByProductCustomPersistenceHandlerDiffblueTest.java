/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.junit.Test;

public class SkuLookupByProductCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleFetchResult = skuLookupByProductCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_givenArrayOfStringWithJavaText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"java.text"});

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(persistencePackage));
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCustomCriteria()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_thenCallsGetCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    boolean actualIsRequestForSkusFilteredByProductResult = skuLookupByProductCustomPersistenceHandler
        .isRequestForSkusFilteredByProduct(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualIsRequestForSkusFilteredByProductResult);
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(new PersistencePackage(
        "Dr Jane Doe", entity, new PersistencePerspective(), new String[]{"productFilterForSkus"}, "ABC123")));
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(new PersistencePackage()));
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}.
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147483645, (new SkuLookupByProductCustomPersistenceHandler()).getOrder());
  }
}
