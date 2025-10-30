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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EntityFormVariableExpressionDiffblueTest {
  @InjectMocks
  private EntityFormVariableExpression entityFormVariableExpression;

  /**
   * Test {@link EntityFormVariableExpression#getName()}.
   * <p>
   * Method under test: {@link EntityFormVariableExpression#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String EntityFormVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ef", (new EntityFormVariableExpression()).getName());
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityFormVariableExpression.isTabActive(EntityForm, Tab)"})
  public void testIsTabActive_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata() {
    // Arrange
    EntityForm ef = new EntityForm();
    ef.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    assertFalse(entityFormVariableExpression.isTabActive(ef, new Tab()));
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityFormVariableExpression.isTabActive(EntityForm, Tab)"})
  public void testIsTabActive_whenEntityForm_thenReturnFalse() {
    // Arrange
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertFalse(entityFormVariableExpression.isTabActive(ef, new Tab()));
  }
}
