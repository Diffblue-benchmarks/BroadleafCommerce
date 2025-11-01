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
package org.broadleafcommerce.openadmin.web.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class NonNullBooleanEditorDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link NonNullBooleanEditor}
   */
  @Test
  public void testNewNonNullBooleanEditor() {
    // Arrange and Act
    NonNullBooleanEditor actualNonNullBooleanEditor = new NonNullBooleanEditor();

    // Assert
    assertNull(actualNonNullBooleanEditor.getValue());
    assertSame(actualNonNullBooleanEditor, actualNonNullBooleanEditor.getSource());
  }

  /**
   * Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  public void testSetAsText() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NonNullBooleanEditor nonNullBooleanEditor = new NonNullBooleanEditor();

    // Act
    nonNullBooleanEditor.setAsText("");

    // Assert that nothing has changed
    String expectedAsText = Boolean.FALSE.toString();
    assertEquals(expectedAsText, nonNullBooleanEditor.getAsText());
  }
}
