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
package org.broadleafcommerce.common.sandbox.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class SandBoxManagementImplDiffblueTest {
  /**
   * Test {@link SandBoxManagementImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SandBoxImpl} {@link SandBoxImpl#getName()} return
   * {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxManagementImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSandBoxImplGetNameReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SandBoxImpl sandBox = mock(SandBoxImpl.class);
    when(sandBox.getName()).thenReturn("Name");

    SandBoxManagementImpl sandBoxManagementImpl = new SandBoxManagementImpl();
    sandBoxManagementImpl.setSandBox(sandBox);

    // Act
    String actualMainEntityName = sandBoxManagementImpl.getMainEntityName();

    // Assert
    verify(sandBox).getName();
    assertEquals("Name", actualMainEntityName);
  }

  /**
   * Test {@link SandBoxManagementImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxManagementImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SandBoxManagementImpl sandBoxManagementImpl = new SandBoxManagementImpl();
    sandBoxManagementImpl.setSandBox(new SandBoxImpl());

    // Act and Assert
    assertNull(sandBoxManagementImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SandBoxManagementImpl}
   *   <li>{@link SandBoxManagementImpl#setSandBox(SandBox)}
   *   <li>{@link SandBoxManagementImpl#getSandBox()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SandBoxManagementImpl actualSandBoxManagementImpl = new SandBoxManagementImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    actualSandBoxManagementImpl.setSandBox(sandBox);

    // Assert that nothing has changed
    assertSame(sandBox, actualSandBoxManagementImpl.getSandBox());
  }
}
