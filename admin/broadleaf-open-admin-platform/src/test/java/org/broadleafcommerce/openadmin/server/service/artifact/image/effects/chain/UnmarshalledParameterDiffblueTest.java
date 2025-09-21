/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnmarshalledParameterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnmarshalledParameter}
   *   <li>{@link UnmarshalledParameter#setApplyFactor(boolean)}
   *   <li>{@link UnmarshalledParameter#setName(String)}
   *   <li>{@link UnmarshalledParameter#setType(String)}
   *   <li>{@link UnmarshalledParameter#setValue(String)}
   *   <li>{@link UnmarshalledParameter#getName()}
   *   <li>{@link UnmarshalledParameter#getType()}
   *   <li>{@link UnmarshalledParameter#getValue()}
   *   <li>{@link UnmarshalledParameter#isApplyFactor()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnmarshalledParameter.<init>()",
    "String UnmarshalledParameter.getName()",
    "String UnmarshalledParameter.getType()",
    "String UnmarshalledParameter.getValue()",
    "boolean UnmarshalledParameter.isApplyFactor()",
    "void UnmarshalledParameter.setApplyFactor(boolean)",
    "void UnmarshalledParameter.setName(String)",
    "void UnmarshalledParameter.setType(String)",
    "void UnmarshalledParameter.setValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UnmarshalledParameter actualUnmarshalledParameter = new UnmarshalledParameter();
    actualUnmarshalledParameter.setApplyFactor(true);
    actualUnmarshalledParameter.setName("Name");
    actualUnmarshalledParameter.setType("Type");
    actualUnmarshalledParameter.setValue("42");
    String actualName = actualUnmarshalledParameter.getName();
    String actualType = actualUnmarshalledParameter.getType();
    String actualValue = actualUnmarshalledParameter.getValue();

    // Assert
    assertEquals("42", actualValue);
    assertEquals("Name", actualName);
    assertEquals("Type", actualType);
    assertTrue(actualUnmarshalledParameter.isApplyFactor());
  }
}
