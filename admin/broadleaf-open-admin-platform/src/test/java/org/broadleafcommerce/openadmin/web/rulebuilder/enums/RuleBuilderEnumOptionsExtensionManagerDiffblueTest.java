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
package org.broadleafcommerce.openadmin.web.rulebuilder.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RuleBuilderEnumOptionsExtensionManagerDiffblueTest {
  @Mock private List<RuleBuilderEnumOptionsExtensionListener> list;

  @InjectMocks
  private RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager;

  /**
   * Test {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleBuilderEnumOptionsExtensionManager.getOptionValues()"})
  public void testGetOptionValues_thenReturn42() {
    // Arrange
    RuleBuilderEnumOptionsExtensionListener ruleBuilderEnumOptionsExtensionListener =
        mock(RuleBuilderEnumOptionsExtensionListener.class);
    when(ruleBuilderEnumOptionsExtensionListener.getOptionValues()).thenReturn("42");

    ArrayList<RuleBuilderEnumOptionsExtensionListener> ruleBuilderEnumOptionsExtensionListenerList =
        new ArrayList<>();
    ruleBuilderEnumOptionsExtensionListenerList.add(ruleBuilderEnumOptionsExtensionListener);
    when(list.iterator()).thenReturn(ruleBuilderEnumOptionsExtensionListenerList.iterator());

    // Act
    String actualOptionValues = ruleBuilderEnumOptionsExtensionManager.getOptionValues();

    // Assert
    verify(list).iterator();
    verify(ruleBuilderEnumOptionsExtensionListener).getOptionValues();
    assertEquals("42\r\n", actualOptionValues);
  }

  /**
   * Test {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleBuilderEnumOptionsExtensionManager.getOptionValues()"})
  public void testGetOptionValues_thenReturnEmptyString() {
    // Arrange
    ArrayList<RuleBuilderEnumOptionsExtensionListener> ruleBuilderEnumOptionsExtensionListenerList =
        new ArrayList<>();
    when(list.iterator()).thenReturn(ruleBuilderEnumOptionsExtensionListenerList.iterator());

    // Act
    String actualOptionValues = ruleBuilderEnumOptionsExtensionManager.getOptionValues();

    // Assert
    verify(list).iterator();
    assertEquals("", actualOptionValues);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleBuilderEnumOptionsExtensionManager#setListeners(List)}
   *   <li>{@link RuleBuilderEnumOptionsExtensionManager#getListeners()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RuleBuilderEnumOptionsExtensionManager.getListeners()",
    "void RuleBuilderEnumOptionsExtensionManager.setListeners(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager =
        new RuleBuilderEnumOptionsExtensionManager();
    ArrayList<RuleBuilderEnumOptionsExtensionListener> listeners = new ArrayList<>();

    // Act
    ruleBuilderEnumOptionsExtensionManager.setListeners(listeners);
    List<RuleBuilderEnumOptionsExtensionListener> actualListeners =
        ruleBuilderEnumOptionsExtensionManager.getListeners();

    // Assert
    assertTrue(actualListeners.isEmpty());
    assertSame(listeners, actualListeners);
  }
}
