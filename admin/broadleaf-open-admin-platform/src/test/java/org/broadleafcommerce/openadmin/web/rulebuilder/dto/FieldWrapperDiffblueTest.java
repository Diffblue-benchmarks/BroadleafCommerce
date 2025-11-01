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
package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class FieldWrapperDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldWrapper}
   *   <li>{@link FieldWrapper#setFields(ArrayList)}
   *   <li>{@link FieldWrapper#getFields()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldWrapper actualFieldWrapper = new FieldWrapper();
    ArrayList<FieldDTO> fields = new ArrayList<>();
    actualFieldWrapper.setFields(fields);

    // Assert that nothing has changed
    assertSame(fields, actualFieldWrapper.getFields());
  }

  /**
   * Method under test: {@link FieldWrapper#serialize()}
   */
  @Test
  public void testSerialize() throws IOException {
    // Arrange, Act and Assert
    assertEquals("{\"fields\":[]}", (new FieldWrapper()).serialize());
  }

  /**
   * Method under test: {@link FieldWrapper#serialize()}
   */
  @Test
  public void testSerialize2() throws IOException {
    // Arrange
    FieldDTO fieldDTO = new FieldDTO();
    fieldDTO.setId("42");
    fieldDTO.setInput("Input");
    fieldDTO.setLabel("Label");
    fieldDTO.setOperators("Operators");
    fieldDTO.setSelectizeSectionKey("Selectize Section Key");
    fieldDTO.setType("Type");
    fieldDTO.setValues("42");

    ArrayList<FieldDTO> fields = new ArrayList<>();
    fields.add(fieldDTO);

    FieldWrapper fieldWrapper = new FieldWrapper();
    fieldWrapper.setFields(fields);

    // Act and Assert
    assertEquals(
        "{\"fields\":[{\"id\":\"42\",\"label\":\"Label\",\"type\":\"Type\",\"input\":\"Input\",\"operators\":\"Operators\","
            + "\"selectizeSectionKey\":\"Selectize Section Key\",\"values\":\"42\"}]}",
        fieldWrapper.serialize());
  }

  /**
   * Method under test: {@link FieldWrapper#serialize()}
   */
  @Test
  public void testSerialize3() throws IOException {
    // Arrange
    FieldDTO fieldDTO = new FieldDTO();
    fieldDTO.setId("42");
    fieldDTO.setInput("Input");
    fieldDTO.setLabel("Label");
    fieldDTO.setOperators("Operators");
    fieldDTO.setSelectizeSectionKey("Selectize Section Key");
    fieldDTO.setType("Type");
    fieldDTO.setValues("42");

    FieldDTO fieldDTO2 = new FieldDTO();
    fieldDTO2.setId("Id");
    fieldDTO2.setInput("42");
    fieldDTO2.setLabel("42");
    fieldDTO2.setOperators("42");
    fieldDTO2.setSelectizeSectionKey("42");
    fieldDTO2.setType("42");
    fieldDTO2.setValues("Values");

    ArrayList<FieldDTO> fields = new ArrayList<>();
    fields.add(fieldDTO2);
    fields.add(fieldDTO);

    FieldWrapper fieldWrapper = new FieldWrapper();
    fieldWrapper.setFields(fields);

    // Act and Assert
    assertEquals(
        "{\"fields\":[{\"id\":\"Id\",\"label\":\"42\",\"type\":\"42\",\"input\":\"42\",\"operators\":\"42\",\"selectizeSectionKey\":"
            + "\"42\",\"values\":\"Values\"},{\"id\":\"42\",\"label\":\"Label\",\"type\":\"Type\",\"input\":\"Input\",\"operators\":\"Operators"
            + "\",\"selectizeSectionKey\":\"Selectize Section Key\",\"values\":\"42\"}]}",
        fieldWrapper.serialize());
  }
}
