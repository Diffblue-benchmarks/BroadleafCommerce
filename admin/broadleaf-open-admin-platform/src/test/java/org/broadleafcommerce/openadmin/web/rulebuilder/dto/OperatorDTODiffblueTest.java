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
package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OperatorDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OperatorDTO}
   *   <li>{@link OperatorDTO#setFieldType(String)}
   *   <li>{@link OperatorDTO#setLabel(String)}
   *   <li>{@link OperatorDTO#setName(String)}
   *   <li>{@link OperatorDTO#getFieldType()}
   *   <li>{@link OperatorDTO#getLabel()}
   *   <li>{@link OperatorDTO#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OperatorDTO actualOperatorDTO = new OperatorDTO();
    actualOperatorDTO.setFieldType("Field Type");
    actualOperatorDTO.setLabel("Label");
    actualOperatorDTO.setName("Name");
    String actualFieldType = actualOperatorDTO.getFieldType();
    String actualLabel = actualOperatorDTO.getLabel();

    // Assert that nothing has changed
    assertEquals("Field Type", actualFieldType);
    assertEquals("Label", actualLabel);
    assertEquals("Name", actualOperatorDTO.getName());
  }
}
