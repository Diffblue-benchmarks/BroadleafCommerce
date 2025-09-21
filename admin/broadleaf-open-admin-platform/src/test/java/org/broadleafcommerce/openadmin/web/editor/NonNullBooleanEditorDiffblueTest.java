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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NonNullBooleanEditor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NonNullBooleanEditorDiffblueTest {
  @Autowired private NonNullBooleanEditor nonNullBooleanEditor;

  /**
   * Test new {@link NonNullBooleanEditor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NonNullBooleanEditor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonNullBooleanEditor.<init>()"})
  public void testNewNonNullBooleanEditor() {
    // Arrange and Act
    NonNullBooleanEditor actualNonNullBooleanEditor = new NonNullBooleanEditor();

    // Assert
    assertNull(actualNonNullBooleanEditor.getValue());
    Object actualSource = actualNonNullBooleanEditor.getSource();
    assertSame(actualNonNullBooleanEditor, actualSource);
  }

  /**
   * Test {@link NonNullBooleanEditor#setAsText(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PropertyChangeListener#propertyChange(PropertyChangeEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonNullBooleanEditor.setAsText(String)"})
  public void testSetAsText_thenCallsPropertyChange() throws IllegalArgumentException {
    // Arrange
    PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
    doThrow(new IllegalArgumentException())
        .when(propertyChangeListener)
        .propertyChange(Mockito.<PropertyChangeEvent>any());

    NonNullBooleanEditor nonNullBooleanEditor = new NonNullBooleanEditor();
    nonNullBooleanEditor.addPropertyChangeListener(propertyChangeListener);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> nonNullBooleanEditor.setAsText(" "));
    verify(propertyChangeListener).propertyChange(isA(PropertyChangeEvent.class));
  }

  /**
   * Test {@link NonNullBooleanEditor#setAsText(String)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonNullBooleanEditor.setAsText(String)"})
  public void testSetAsText_whenText_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> nonNullBooleanEditor.setAsText("Text"));
  }
}
