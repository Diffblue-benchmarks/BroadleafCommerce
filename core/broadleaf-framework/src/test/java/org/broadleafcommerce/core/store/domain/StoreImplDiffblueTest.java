/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.store.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;

public class StoreImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StoreImpl#setAddress(Address)}
   *   <li>{@link StoreImpl#setId(Long)}
   *   <li>{@link StoreImpl#setLatitude(Double)}
   *   <li>{@link StoreImpl#setLongitude(Double)}
   *   <li>{@link StoreImpl#setName(String)}
   *   <li>{@link StoreImpl#setOpen(Boolean)}
   *   <li>{@link StoreImpl#setStoreHours(String)}
   *   <li>{@link StoreImpl#setStoreNumber(String)}
   *   <li>{@link StoreImpl#getAddress()}
   *   <li>{@link StoreImpl#getId()}
   *   <li>{@link StoreImpl#getLatitude()}
   *   <li>{@link StoreImpl#getLongitude()}
   *   <li>{@link StoreImpl#getName()}
   *   <li>{@link StoreImpl#getOpen()}
   *   <li>{@link StoreImpl#getStoreHours()}
   *   <li>{@link StoreImpl#getStoreNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    AddressImpl address = new AddressImpl();

    // Act
    storeImpl.setAddress(address);
    storeImpl.setId(1L);
    storeImpl.setLatitude(10.0d);
    storeImpl.setLongitude(10.0d);
    storeImpl.setName("Name");
    storeImpl.setOpen(true);
    storeImpl.setStoreHours("Store Hours");
    storeImpl.setStoreNumber("42");
    Address actualAddress = storeImpl.getAddress();
    Long actualId = storeImpl.getId();
    Double actualLatitude = storeImpl.getLatitude();
    Double actualLongitude = storeImpl.getLongitude();
    String actualName = storeImpl.getName();
    Boolean actualOpen = storeImpl.getOpen();
    String actualStoreHours = storeImpl.getStoreHours();

    // Assert that nothing has changed
    assertEquals("42", storeImpl.getStoreNumber());
    assertEquals("Name", actualName);
    assertEquals("Store Hours", actualStoreHours);
    assertEquals(10.0d, actualLatitude.doubleValue(), 0.0);
    assertEquals(10.0d, actualLongitude.doubleValue(), 0.0);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualOpen);
    assertSame(address, actualAddress);
  }

  /**
   * Test {@link StoreImpl#getArchived()}.
   * <p>
   * Method under test: {@link StoreImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new StoreImpl()).getArchived().charValue());
  }

  /**
   * Test {@link StoreImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link StoreImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();

    // Act
    storeImpl.setArchived('A');

    // Assert
    assertEquals('A', storeImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', storeImpl.getArchived().charValue());
  }

  /**
   * Test {@link StoreImpl#isActive()}.
   * <ul>
   *   <li>Given {@link StoreImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreImpl#isActive()}
   */
  @Test
  public void testIsActive_givenStoreImplArchivedIsY_thenReturnFalse() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    storeImpl.setArchived('Y');

    // Act and Assert
    assertFalse(storeImpl.isActive());
  }

  /**
   * Test {@link StoreImpl#isActive()}.
   * <ul>
   *   <li>Given {@link StoreImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreImpl#isActive()}
   */
  @Test
  public void testIsActive_givenStoreImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new StoreImpl()).isActive());
  }

  /**
   * Test new {@link StoreImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link StoreImpl}
   */
  @Test
  public void testNewStoreImpl() {
    // Arrange and Act
    StoreImpl actualStoreImpl = new StoreImpl();

    // Assert
    assertEquals('N', actualStoreImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualStoreImpl.getArchived().charValue());
    assertNull(actualStoreImpl.getOpen());
    assertNull(actualStoreImpl.getLatitude());
    assertNull(actualStoreImpl.getLongitude());
    assertNull(actualStoreImpl.getId());
    assertNull(actualStoreImpl.getName());
    assertNull(actualStoreImpl.getStoreHours());
    assertNull(actualStoreImpl.getStoreNumber());
    assertNull(actualStoreImpl.getAddress());
  }
}
