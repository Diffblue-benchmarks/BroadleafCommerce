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
package org.broadleafcommerce.common.email.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class EmailTargetImplDiffblueTest {
  /**
   * Test {@link EmailTargetImpl#equals(Object)}, and
   * {@link EmailTargetImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTargetImpl#equals(Object)}
   *   <li>{@link EmailTargetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertEquals(emailTargetImpl, emailTargetImpl2);
    int expectedHashCodeResult = emailTargetImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTargetImpl2.hashCode());
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}, and
   * {@link EmailTargetImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTargetImpl#equals(Object)}
   *   <li>{@link EmailTargetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress(null);

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl2.setEmailAddress(null);

    // Act and Assert
    assertEquals(emailTargetImpl, emailTargetImpl2);
    int expectedHashCodeResult = emailTargetImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTargetImpl2.hashCode());
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}, and
   * {@link EmailTargetImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTargetImpl#equals(Object)}
   *   <li>{@link EmailTargetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    // Act and Assert
    assertEquals(emailTargetImpl, emailTargetImpl);
    int expectedHashCodeResult = emailTargetImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTargetImpl.hashCode());
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"17 High St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress("17 High St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress(null);

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, null);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[]{"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[]{"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, "Different type to EmailTargetImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTargetImpl}
   *   <li>{@link EmailTargetImpl#setBCCAddresses(String[])}
   *   <li>{@link EmailTargetImpl#setCCAddresses(String[])}
   *   <li>{@link EmailTargetImpl#setEmailAddress(String)}
   *   <li>{@link EmailTargetImpl#getBCCAddresses()}
   *   <li>{@link EmailTargetImpl#getCCAddresses()}
   *   <li>{@link EmailTargetImpl#getEmailAddress()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailTargetImpl actualEmailTargetImpl = new EmailTargetImpl();
    String[] bccAddresses = new String[]{"mary.somerville@example.org"};
    actualEmailTargetImpl.setBCCAddresses(bccAddresses);
    String[] ccAddresses = new String[]{"42 Main St"};
    actualEmailTargetImpl.setCCAddresses(ccAddresses);
    actualEmailTargetImpl.setEmailAddress("42 Main St");
    String[] actualBCCAddresses = actualEmailTargetImpl.getBCCAddresses();
    String[] actualCCAddresses = actualEmailTargetImpl.getCCAddresses();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailTargetImpl.getEmailAddress());
    assertSame(ccAddresses, actualCCAddresses);
    assertSame(bccAddresses, actualBCCAddresses);
    assertArrayEquals(new String[]{"42 Main St"}, actualCCAddresses);
    assertArrayEquals(new String[]{"mary.somerville@example.org"}, actualBCCAddresses);
  }
}
