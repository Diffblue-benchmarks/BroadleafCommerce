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
package org.broadleafcommerce.openadmin.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.junit.Test;

public class EntityFormVariableExpressionDiffblueTest {
  /**
   * Test {@link EntityFormVariableExpression#getName()}.
   * <p>
   * Method under test: {@link EntityFormVariableExpression#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ef", (new EntityFormVariableExpression()).getName());
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenHashSetAddNull_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(null);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(tabSet);

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, null);

    // Assert
    verify(ef).getTabs();
    assertTrue(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tab} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenHashSetAddTab_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(tabSet);

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, new Tab());

    // Assert
    verify(ef).getTabs();
    assertFalse(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getTabs()} return
   * {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenHashSet_whenEntityFormGetTabsReturnHashSet_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(new HashSet<>());

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, new Tab());

    // Assert
    verify(ef).getTabs();
    assertFalse(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link Tab} {@link Tab#getIsVisible()} return {@code true}.</li>
   *   <li>Then calls {@link Tab#getIsVisible()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenTabGetIsVisibleReturnTrue_thenCallsGetIsVisible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    Tab tab = mock(Tab.class);
    when(tab.getIsVisible()).thenReturn(true);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(tabSet);

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, new Tab());

    // Assert
    verify(ef).getTabs();
    verify(tab).getIsVisible();
    assertFalse(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_whenEntityForm_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertFalse(entityFormVariableExpression.isTabActive(ef, new Tab()));
  }
}
