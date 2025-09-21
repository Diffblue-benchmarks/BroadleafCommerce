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
package org.broadleafcommerce.common.rest.api.wrapper;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MapElementWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MapElementWrapper}
   *   <li>{@link MapElementWrapper#setKey(String)}
   *   <li>{@link MapElementWrapper#setValue(String)}
   *   <li>{@link MapElementWrapper#getKey()}
   *   <li>{@link MapElementWrapper#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapElementWrapper.<init>()",
    "String MapElementWrapper.getKey()",
    "String MapElementWrapper.getValue()",
    "void MapElementWrapper.setKey(String)",
    "void MapElementWrapper.setValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MapElementWrapper actualMapElementWrapper = new MapElementWrapper();
    actualMapElementWrapper.setKey("Key");
    actualMapElementWrapper.setValue("42");
    String actualKey = actualMapElementWrapper.getKey();

    // Assert
    assertEquals("42", actualMapElementWrapper.getValue());
    assertEquals("Key", actualKey);
  }
}
