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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class AdminUserAttributeImplDiffblueTest {
  /**
   * Test {@link AdminUserAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link AdminUserAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenAdminUserAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminUserAttributeImpl()).getValue());
  }

  /**
   * Test {@link AdminUserAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link AdminUserAttributeImpl} (default constructor) AdminUser is
   * {@link AdminUserImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenAdminUserAttributeImplAdminUserIsAdminUserImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(mock(AdminUserImpl.class));

    // Act and Assert
    assertNull(adminUserAttributeImpl.getValue());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
    int notExpectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(mock(AdminUser.class));
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
    int notExpectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(null);
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
    int expectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl);
    int expectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, adminUserAttributeImpl.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(2L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(null);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName(null);
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("java.lang.String");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName(null);
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName(null);
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("Name");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(null);
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue(null);

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(null);
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, null);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, "Different type to AdminUserAttributeImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminUserAttributeImpl}
   *   <li>{@link AdminUserAttributeImpl#setAdminUser(AdminUser)}
   *   <li>{@link AdminUserAttributeImpl#setId(Long)}
   *   <li>{@link AdminUserAttributeImpl#setName(String)}
   *   <li>{@link AdminUserAttributeImpl#setValue(String)}
   *   <li>{@link AdminUserAttributeImpl#getAdminUser()}
   *   <li>{@link AdminUserAttributeImpl#getId()}
   *   <li>{@link AdminUserAttributeImpl#getName()}
   *   <li>{@link AdminUserAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminUserAttributeImpl actualAdminUserAttributeImpl = new AdminUserAttributeImpl();
    AdminUserImpl adminUser = new AdminUserImpl();
    actualAdminUserAttributeImpl.setAdminUser(adminUser);
    actualAdminUserAttributeImpl.setId(1L);
    actualAdminUserAttributeImpl.setName("Name");
    actualAdminUserAttributeImpl.setValue("42");
    AdminUser actualAdminUser = actualAdminUserAttributeImpl.getAdminUser();
    Long actualId = actualAdminUserAttributeImpl.getId();
    String actualName = actualAdminUserAttributeImpl.getName();
    String actualToStringResult = actualAdminUserAttributeImpl.toString();

    // Assert that nothing has changed
    assertEquals("42", actualAdminUserAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(1L, actualId.longValue());
    assertSame(adminUser, actualAdminUser);
  }
}
