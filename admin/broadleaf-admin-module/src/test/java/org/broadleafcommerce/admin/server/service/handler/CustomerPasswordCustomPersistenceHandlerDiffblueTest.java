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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.junit.Test;

public class CustomerPasswordCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler = new CustomerPasswordCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleUpdateResult = customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithJavaText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler = new CustomerPasswordCustomPersistenceHandler();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"java.text"});

    // Act and Assert
    assertFalse(customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code passwordUpdate}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithPasswordUpdate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler = new CustomerPasswordCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"passwordUpdate"});

    // Act
    Boolean actualCanHandleUpdateResult = customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler = new CustomerPasswordCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleUpdateResult = customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler = new CustomerPasswordCustomPersistenceHandler();

    // Act and Assert
    assertFalse(customerPasswordCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }
}
