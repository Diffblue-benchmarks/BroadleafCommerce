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
package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityFormAction.class, String.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityFormActionDiffblueTest {
  @Autowired private EntityFormAction entityFormAction;

  /**
   * Test {@link EntityFormAction#EntityFormAction(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#EntityFormAction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFormAction.<init>(String)"})
  public void testNewEntityFormAction() {
    // Arrange and Act
    EntityFormAction actualEntityFormAction = new EntityFormAction("42");

    // Assert
    assertEquals("", actualEntityFormAction.getButtonClass());
    assertEquals("", actualEntityFormAction.getConfirmEnabledText());
    assertEquals("", actualEntityFormAction.getDisplayText());
    assertEquals("", actualEntityFormAction.getIconClass());
    assertEquals("", actualEntityFormAction.getUrlPostfix());
    assertEquals("42", actualEntityFormAction.getId());
    assertEquals("button", actualEntityFormAction.getButtonType());
    assertNull(actualEntityFormAction.getUrlOverride());
    assertFalse(actualEntityFormAction.getIsConfirmEnabled());
    assertFalse(actualEntityFormAction.isConfirmEnabled);
  }

  /**
   * Test {@link EntityFormAction#equals(Object)}, and {@link EntityFormAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormAction.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityFormAction entityFormAction = DefaultAdornedEntityFormActions.Add;
    EntityFormAction entityFormAction2 = DefaultAdornedEntityFormActions.Add;

    // Act and Assert
    assertEquals(entityFormAction, entityFormAction2);
    assertEquals(entityFormAction.hashCode(), entityFormAction2.hashCode());
  }

  /**
   * Test {@link EntityFormAction#equals(Object)}, and {@link EntityFormAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormAction.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityFormAction entityFormAction = DefaultAdornedEntityFormActions.Add;

    // Act and Assert
    assertEquals(entityFormAction, entityFormAction);
    int expectedHashCodeResult = entityFormAction.hashCode();
    assertEquals(expectedHashCodeResult, entityFormAction.hashCode());
  }

  /**
   * Test {@link EntityFormAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormAction.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DefaultAdornedEntityFormActions.Save, DefaultAdornedEntityFormActions.Add);
  }

  /**
   * Test {@link EntityFormAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormAction.equals(Object)"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DefaultAdornedEntityFormActions.Add, null);
  }

  /**
   * Test {@link EntityFormAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormAction#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormAction.equals(Object)"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DefaultAdornedEntityFormActions.Add, "Different type to EntityFormAction");
  }

  /**
   * Test {@link EntityFormAction#withButtonType(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#withButtonType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withButtonType(String)"})
  public void testWithButtonType() {
    // Arrange and Act
    EntityFormAction actualWithButtonTypeResult = entityFormAction.withButtonType("Button Type");

    // Assert
    assertEquals("Button Type", entityFormAction.getButtonType());
    assertSame(entityFormAction, actualWithButtonTypeResult);
  }

  /**
   * Test {@link EntityFormAction#withButtonClass(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#withButtonClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withButtonClass(String)"})
  public void testWithButtonClass() {
    // Arrange and Act
    EntityFormAction actualWithButtonClassResult = entityFormAction.withButtonClass("Button Class");

    // Assert
    assertEquals("Button Class", entityFormAction.getButtonClass());
    assertSame(entityFormAction, actualWithButtonClassResult);
  }

  /**
   * Test {@link EntityFormAction#withUrlPostfix(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#withUrlPostfix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withUrlPostfix(String)"})
  public void testWithUrlPostfix() {
    // Arrange and Act
    EntityFormAction actualWithUrlPostfixResult =
        entityFormAction.withUrlPostfix("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", entityFormAction.getUrlPostfix());
    assertSame(entityFormAction, actualWithUrlPostfixResult);
  }

  /**
   * Test {@link EntityFormAction#withIconClass(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#withIconClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withIconClass(String)"})
  public void testWithIconClass() {
    // Arrange and Act
    EntityFormAction actualWithIconClassResult = entityFormAction.withIconClass("Icon Class");

    // Assert
    assertEquals("Icon Class", entityFormAction.getIconClass());
    assertSame(entityFormAction, actualWithIconClassResult);
  }

  /**
   * Test {@link EntityFormAction#withDisplayText(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#withDisplayText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withDisplayText(String)"})
  public void testWithDisplayText() {
    // Arrange and Act
    EntityFormAction actualWithDisplayTextResult = entityFormAction.withDisplayText("Display Text");

    // Assert
    assertEquals("Display Text", entityFormAction.getDisplayText());
    assertSame(entityFormAction, actualWithDisplayTextResult);
  }

  /**
   * Test {@link EntityFormAction#withUrlOverride(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#withUrlOverride(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withUrlOverride(String)"})
  public void testWithUrlOverride() {
    // Arrange and Act
    EntityFormAction actualWithUrlOverrideResult =
        entityFormAction.withUrlOverride("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", entityFormAction.getUrlOverride());
    assertSame(entityFormAction, actualWithUrlOverrideResult);
  }

  /**
   * Test {@link EntityFormAction#withIsConfirmEnabled(Boolean)}.
   *
   * <p>Method under test: {@link EntityFormAction#withIsConfirmEnabled(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withIsConfirmEnabled(Boolean)"})
  public void testWithIsConfirmEnabled() {
    // Arrange
    EntityFormAction entityFormAction = DefaultAdornedEntityFormActions.Add;

    // Act
    EntityFormAction actualWithIsConfirmEnabledResult = entityFormAction.withIsConfirmEnabled(true);

    // Assert
    assertSame(entityFormAction, actualWithIsConfirmEnabledResult);
  }

  /**
   * Test {@link EntityFormAction#withConfirmEnabledText(String)}.
   *
   * <p>Method under test: {@link EntityFormAction#withConfirmEnabledText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFormAction EntityFormAction.withConfirmEnabledText(String)"})
  public void testWithConfirmEnabledText() {
    // Arrange and Act
    EntityFormAction actualWithConfirmEnabledTextResult =
        entityFormAction.withConfirmEnabledText("Confirm Enabled Text");

    // Assert
    assertEquals("Confirm Enabled Text", entityFormAction.getConfirmEnabledText());
    assertSame(entityFormAction, actualWithConfirmEnabledTextResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityFormAction#setButtonClass(String)}
   *   <li>{@link EntityFormAction#setButtonType(String)}
   *   <li>{@link EntityFormAction#setConfirmEnabledText(String)}
   *   <li>{@link EntityFormAction#setDisplayText(String)}
   *   <li>{@link EntityFormAction#setIconClass(String)}
   *   <li>{@link EntityFormAction#setIsConfirmEnabled(Boolean)}
   *   <li>{@link EntityFormAction#setUrlOverride(String)}
   *   <li>{@link EntityFormAction#setUrlPostfix(String)}
   *   <li>{@link EntityFormAction#getButtonClass()}
   *   <li>{@link EntityFormAction#getButtonType()}
   *   <li>{@link EntityFormAction#getConfirmEnabledText()}
   *   <li>{@link EntityFormAction#getDisplayText()}
   *   <li>{@link EntityFormAction#getIconClass()}
   *   <li>{@link EntityFormAction#getId()}
   *   <li>{@link EntityFormAction#getUrlOverride()}
   *   <li>{@link EntityFormAction#getUrlPostfix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityFormAction.getButtonClass()",
    "String EntityFormAction.getButtonType()",
    "String EntityFormAction.getConfirmEnabledText()",
    "String EntityFormAction.getDisplayText()",
    "String EntityFormAction.getIconClass()",
    "String EntityFormAction.getId()",
    "String EntityFormAction.getUrlOverride()",
    "String EntityFormAction.getUrlPostfix()",
    "void EntityFormAction.setButtonClass(String)",
    "void EntityFormAction.setButtonType(String)",
    "void EntityFormAction.setConfirmEnabledText(String)",
    "void EntityFormAction.setDisplayText(String)",
    "void EntityFormAction.setIconClass(String)",
    "void EntityFormAction.setIsConfirmEnabled(Boolean)",
    "void EntityFormAction.setUrlOverride(String)",
    "void EntityFormAction.setUrlPostfix(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    EntityFormAction entityFormAction = new EntityFormAction("42");

    // Act
    entityFormAction.setButtonClass("Button Class");
    entityFormAction.setButtonType("Button Type");
    entityFormAction.setConfirmEnabledText("Confirm Enabled Text");
    entityFormAction.setDisplayText("Display Text");
    entityFormAction.setIconClass("Icon Class");
    entityFormAction.setIsConfirmEnabled(true);
    entityFormAction.setUrlOverride("https://example.org/example");
    entityFormAction.setUrlPostfix("https://example.org/example");
    String actualButtonClass = entityFormAction.getButtonClass();
    String actualButtonType = entityFormAction.getButtonType();
    String actualConfirmEnabledText = entityFormAction.getConfirmEnabledText();
    String actualDisplayText = entityFormAction.getDisplayText();
    String actualIconClass = entityFormAction.getIconClass();
    String actualId = entityFormAction.getId();
    String actualUrlOverride = entityFormAction.getUrlOverride();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Button Class", actualButtonClass);
    assertEquals("Button Type", actualButtonType);
    assertEquals("Confirm Enabled Text", actualConfirmEnabledText);
    assertEquals("Display Text", actualDisplayText);
    assertEquals("Icon Class", actualIconClass);
    assertEquals("https://example.org/example", actualUrlOverride);
    assertEquals("https://example.org/example", entityFormAction.getUrlPostfix());
  }

  /**
   * Test {@link EntityFormAction#getIsConfirmEnabled()}.
   *
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add} IsConfirmEnabled is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormAction#getIsConfirmEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean EntityFormAction.getIsConfirmEnabled()"})
  public void testGetIsConfirmEnabled_givenAddIsConfirmEnabledIsNull_thenReturnFalse() {
    // Arrange
    EntityFormAction entityFormAction = DefaultAdornedEntityFormActions.Add;
    entityFormAction.setIsConfirmEnabled(null);

    // Act and Assert
    assertFalse(entityFormAction.getIsConfirmEnabled());
  }

  /**
   * Test {@link EntityFormAction#getIsConfirmEnabled()}.
   *
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add} IsConfirmEnabled is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormAction#getIsConfirmEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean EntityFormAction.getIsConfirmEnabled()"})
  public void testGetIsConfirmEnabled_givenAddIsConfirmEnabledIsTrue_thenReturnTrue() {
    // Arrange
    EntityFormAction entityFormAction = DefaultAdornedEntityFormActions.Add;
    entityFormAction.setIsConfirmEnabled(true);

    // Act and Assert
    assertTrue(entityFormAction.getIsConfirmEnabled());
  }
}
