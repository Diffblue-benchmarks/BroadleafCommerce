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
package org.broadleafcommerce.common.vendor.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ContainerSizeType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ContainerSizeTypeDiffblueTest {
  @Autowired
  private ContainerSizeType containerSizeType;

  /**
   * Test {@link ContainerSizeType#getInstance(String)}.
   * <p>
   * Method under test: {@link ContainerSizeType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ContainerSizeType actualInstance = ContainerSizeType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContainerSizeType#ContainerSizeType()}
   *   <li>{@link ContainerSizeType#getFriendlyType()}
   *   <li>{@link ContainerSizeType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ContainerSizeType actualContainerSizeType = new ContainerSizeType();
    String actualFriendlyType = actualContainerSizeType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualContainerSizeType.getType());
  }

  /**
   * Test {@link ContainerSizeType#ContainerSizeType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContainerSizeType#ContainerSizeType(String, String)}
   */
  @Test
  public void testNewContainerSizeType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ContainerSizeType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link ContainerSizeType#ContainerSizeType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContainerSizeType#ContainerSizeType(String, String)}
   */
  @Test
  public void testNewContainerSizeType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ContainerSizeType("Type", "Friendly Type"));

  }

  /**
   * Test {@link ContainerSizeType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContainerSizeType#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: Cannot add the type: (Type). It already exists as a type via org.broadleafcommerce.common.vendor.service.type.ContainerSizeType
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.setType(ContainerSizeType.java:66)
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.<init>(ContainerSizeType.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ContainerSizeType containerSizeType = new ContainerSizeType("Type", "Friendly Type");

    // Act
    containerSizeType.equals(new ContainerSizeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link ContainerSizeType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContainerSizeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ContainerSizeType(), BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link ContainerSizeType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContainerSizeType#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange, Act and Assert
    assertNotEquals(new ContainerSizeType("Type", "Friendly Type"), null);
  }

  /**
   * Test {@link ContainerSizeType#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContainerSizeType#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsSame() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new ContainerSizeType("Type", "Friendly Type")).equals(new ContainerSizeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link ContainerSizeType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContainerSizeType#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsWrongType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new ContainerSizeType("Type", "Friendly Type")).equals("Different type to ContainerSizeType");
  }
}
