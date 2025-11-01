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
   * Method under test: {@link EntityFormVariableExpression#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ef", (new EntityFormVariableExpression()).getName());
  }

  /**
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertFalse(entityFormVariableExpression.isTabActive(ef, new Tab()));
  }

  /**
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive2() {
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
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive3() {
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
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive4() {
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
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive5() {
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
}
