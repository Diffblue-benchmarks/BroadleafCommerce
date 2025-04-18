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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NonNullBooleanEditorDiffblueTest {
  /**
   * Test new {@link NonNullBooleanEditor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link NonNullBooleanEditor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NonNullBooleanEditor.<init>()"})
  public void testNewNonNullBooleanEditor() {
    // Arrange and Act
    NonNullBooleanEditor actualNonNullBooleanEditor = new NonNullBooleanEditor();

    // Assert
    assertNull(actualNonNullBooleanEditor.getValue());
    assertSame(actualNonNullBooleanEditor, actualNonNullBooleanEditor.getSource());
  }

  /**
   * Test {@link NonNullBooleanEditor#setAsText(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then not {@link NonNullBooleanEditor} (default constructor) Value.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NonNullBooleanEditor.setAsText(String)"})
  public void testSetAsText_whenEmptyString_thenNotNonNullBooleanEditorValue() throws IllegalArgumentException {
    // Arrange
    NonNullBooleanEditor nonNullBooleanEditor = new NonNullBooleanEditor();

    // Act
    nonNullBooleanEditor.setAsText("");

    // Assert
    assertFalse((Boolean) nonNullBooleanEditor.getValue());
    String expectedAsText = Boolean.FALSE.toString();
    assertEquals(expectedAsText, nonNullBooleanEditor.getAsText());
  }

  /**
   * Test {@link NonNullBooleanEditor#setAsText(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then not {@link NonNullBooleanEditor} (default constructor) Value.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NonNullBooleanEditor.setAsText(String)"})
  public void testSetAsText_whenSpace_thenNotNonNullBooleanEditorValue() throws IllegalArgumentException {
    // Arrange
    NonNullBooleanEditor nonNullBooleanEditor = new NonNullBooleanEditor();

    // Act
    nonNullBooleanEditor.setAsText(" ");

    // Assert
    assertFalse((Boolean) nonNullBooleanEditor.getValue());
    String expectedAsText = Boolean.FALSE.toString();
    assertEquals(expectedAsText, nonNullBooleanEditor.getAsText());
  }
}
