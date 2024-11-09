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
package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {ComboField.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ComboFieldDiffblueTest {
  @Autowired
  private ComboField comboField;

  /**
   * Test {@link ComboField#putOption(String, String)}.
   * <p>
   * Method under test: {@link ComboField#putOption(String, String)}
   */
  @Test
  public void testPutOption() {
    // Arrange and Act
    comboField.putOption("Key", "42");

    // Assert
    Map<String, String> options = comboField.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Key"));
  }

  /**
   * Test {@link ComboField#setOptions(String[][])} with {@code String[][]}.
   * <ul>
   *   <li>Then {@link ComboField} (default constructor) Options size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComboField#setOptions(String[][])}
   */
  @Test
  public void testSetOptionsWithString_thenComboFieldOptionsSizeIsOne() {
    // Arrange
    ComboField comboField = new ComboField();

    // Act
    comboField.setOptions(new String[][]{new String[]{"Options", null}});

    // Assert
    Map<String, String> options = comboField.getOptions();
    assertEquals(1, options.size());
    assertNull(options.get("Options"));
  }

  /**
   * Test {@link ComboField#setOptions(String[][])} with {@code String[][]}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ComboField} (default constructor) Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComboField#setOptions(String[][])}
   */
  @Test
  public void testSetOptionsWithString_whenNull_thenComboFieldOptionsEmpty() {
    // Arrange
    ComboField comboField = new ComboField();

    // Act
    comboField.setOptions((String[][]) null);

    // Assert that nothing has changed
    assertTrue(comboField.getOptions().isEmpty());
  }

  /**
   * Test {@link ComboField#getOption(String)}.
   * <p>
   * Method under test: {@link ComboField#getOption(String)}
   */
  @Test
  public void testGetOption() {
    // Arrange, Act and Assert
    assertNull(comboField.getOption("Option Key"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ComboField}
   *   <li>{@link ComboField#setOptions(Map)}
   *   <li>{@link ComboField#getOptions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ComboField actualComboField = new ComboField();
    HashMap<String, String> options = new HashMap<>();
    actualComboField.setOptions(options);
    Map<String, String> actualOptions = actualComboField.getOptions();

    // Assert that nothing has changed
    assertFalse(actualComboField.getAllowNoValueEnumOption());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualComboField.getAttributes().isEmpty());
    assertTrue(actualComboField.getShouldRender());
    assertSame(options, actualOptions);
  }
}
