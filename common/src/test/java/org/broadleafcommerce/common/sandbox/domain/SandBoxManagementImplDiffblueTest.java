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
package org.broadleafcommerce.common.sandbox.domain;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SandBoxManagementImplDiffblueTest {
  /**
   * Test {@link SandBoxManagementImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxManagementImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SandBoxManagementImpl.getMainEntityName()"})
  public void testGetMainEntityName_thenReturnNull() {
    // Arrange
    SandBoxManagementImpl sandBoxManagementImpl = new SandBoxManagementImpl();
    sandBoxManagementImpl.setSandBox(new SandBoxImpl());

    // Act and Assert
    assertNull(sandBoxManagementImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SandBoxManagementImpl}
   *   <li>{@link SandBoxManagementImpl#setSandBox(SandBox)}
   *   <li>{@link SandBoxManagementImpl#getSandBox()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SandBoxManagementImpl.<init>()",
    "SandBox SandBoxManagementImpl.getSandBox()",
    "void SandBoxManagementImpl.setSandBox(SandBox)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SandBoxManagementImpl actualSandBoxManagementImpl = new SandBoxManagementImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    actualSandBoxManagementImpl.setSandBox(sandBox);

    // Assert
    assertSame(sandBox, actualSandBoxManagementImpl.getSandBox());
  }
}
