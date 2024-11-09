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

public class FieldDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldDTO}
   *   <li>{@link FieldDTO#setId(String)}
   *   <li>{@link FieldDTO#setInput(String)}
   *   <li>{@link FieldDTO#setLabel(String)}
   *   <li>{@link FieldDTO#setOperators(String)}
   *   <li>{@link FieldDTO#setSelectizeSectionKey(String)}
   *   <li>{@link FieldDTO#setType(String)}
   *   <li>{@link FieldDTO#setValues(String)}
   *   <li>{@link FieldDTO#getId()}
   *   <li>{@link FieldDTO#getInput()}
   *   <li>{@link FieldDTO#getLabel()}
   *   <li>{@link FieldDTO#getOperators()}
   *   <li>{@link FieldDTO#getSelectizeSectionKey()}
   *   <li>{@link FieldDTO#getType()}
   *   <li>{@link FieldDTO#getValues()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldDTO actualFieldDTO = new FieldDTO();
    actualFieldDTO.setId("42");
    actualFieldDTO.setInput("Input");
    actualFieldDTO.setLabel("Label");
    actualFieldDTO.setOperators("Operators");
    actualFieldDTO.setSelectizeSectionKey("Selectize Section Key");
    actualFieldDTO.setType("Type");
    actualFieldDTO.setValues("42");
    String actualId = actualFieldDTO.getId();
    String actualInput = actualFieldDTO.getInput();
    String actualLabel = actualFieldDTO.getLabel();
    String actualOperators = actualFieldDTO.getOperators();
    String actualSelectizeSectionKey = actualFieldDTO.getSelectizeSectionKey();
    String actualType = actualFieldDTO.getType();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("42", actualFieldDTO.getValues());
    assertEquals("Input", actualInput);
    assertEquals("Label", actualLabel);
    assertEquals("Operators", actualOperators);
    assertEquals("Selectize Section Key", actualSelectizeSectionKey);
    assertEquals("Type", actualType);
  }
}
