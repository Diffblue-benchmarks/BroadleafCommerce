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
import static org.junit.Assert.assertSame;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class FieldWrapperDiffblueTest {
  /**
   * Test {@link FieldWrapper#serialize()}.
   * <ul>
   *   <li>Given {@link FieldDTO} (default constructor) Id is {@code 42}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldWrapper#serialize()}
   */
  @Test
  public void testSerialize_givenFieldDTOIdIs42_thenReturnAString() throws IOException {
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
   * Test {@link FieldWrapper#serialize()}.
   * <ul>
   *   <li>Given {@link FieldDTO} (default constructor) Id is {@code Id}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldWrapper#serialize()}
   */
  @Test
  public void testSerialize_givenFieldDTOIdIsId_thenReturnAString() throws IOException {
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

  /**
   * Test {@link FieldWrapper#serialize()}.
   * <ul>
   *   <li>Given {@link FieldWrapper} (default constructor).</li>
   *   <li>Then return {@code {"fields":[]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldWrapper#serialize()}
   */
  @Test
  public void testSerialize_givenFieldWrapper_thenReturnFields() throws IOException {
    // Arrange, Act and Assert
    assertEquals("{\"fields\":[]}", (new FieldWrapper()).serialize());
  }

  /**
   * Test getters and setters.
   * <p>
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
}
