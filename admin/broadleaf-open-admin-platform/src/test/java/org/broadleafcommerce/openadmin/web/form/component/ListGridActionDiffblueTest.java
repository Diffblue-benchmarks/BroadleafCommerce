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
package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ListGridAction.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ListGridActionDiffblueTest {
  @Autowired
  private ListGridAction listGridAction;

  /**
   * Test {@link ListGridAction#ListGridAction(String)}.
   * <p>
   * Method under test: {@link ListGridAction#ListGridAction(String)}
   */
  @Test
  public void testNewListGridAction() {
    // Arrange and Act
    ListGridAction actualListGridAction = new ListGridAction("42");

    // Assert
    assertEquals("", actualListGridAction.getActionTargetEntity());
    assertEquals("", actualListGridAction.getButtonClass());
    assertEquals("", actualListGridAction.getConfirmEnabledText());
    assertEquals("", actualListGridAction.getDisplayText());
    assertEquals("", actualListGridAction.getIconClass());
    assertEquals("", actualListGridAction.getUrlPostfix());
    assertEquals("", actualListGridAction.buttonClass);
    assertEquals("42", actualListGridAction.getActionId());
    assertNull(actualListGridAction.getActionUrlOverride());
    assertFalse(actualListGridAction.getAllCapable());
    assertFalse(actualListGridAction.getForListGridReadOnly());
    assertFalse(actualListGridAction.getIsConfirmEnabled());
    assertFalse(actualListGridAction.getRequiresNonEmptyGrid());
    assertFalse(actualListGridAction.getSingleActionOnly());
    assertFalse(actualListGridAction.isConfirmEnabled);
  }

  /**
   * Test {@link ListGridAction#withButtonClass(String)}.
   * <p>
   * Method under test: {@link ListGridAction#withButtonClass(String)}
   */
  @Test
  public void testWithButtonClass() {
    // Arrange
    ListGridAction listGridAction2 = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction2, listGridAction2.withButtonClass("Button Class"));
  }

  /**
   * Test {@link ListGridAction#withUrlPostfix(String)}.
   * <p>
   * Method under test: {@link ListGridAction#withUrlPostfix(String)}
   */
  @Test
  public void testWithUrlPostfix() {
    // Arrange
    ListGridAction listGridAction2 = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction2, listGridAction2.withUrlPostfix("https://example.org/example"));
  }

  /**
   * Test {@link ListGridAction#withIconClass(String)}.
   * <p>
   * Method under test: {@link ListGridAction#withIconClass(String)}
   */
  @Test
  public void testWithIconClass() {
    // Arrange
    ListGridAction listGridAction2 = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction2, listGridAction2.withIconClass("Icon Class"));
  }

  /**
   * Test {@link ListGridAction#withRequiresNonEmptyGrid(Boolean)}.
   * <p>
   * Method under test: {@link ListGridAction#withRequiresNonEmptyGrid(Boolean)}
   */
  @Test
  public void testWithRequiresNonEmptyGrid() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction, listGridAction.withRequiresNonEmptyGrid(true));
  }

  /**
   * Test {@link ListGridAction#withDisplayText(String)}.
   * <p>
   * Method under test: {@link ListGridAction#withDisplayText(String)}
   */
  @Test
  public void testWithDisplayText() {
    // Arrange
    ListGridAction listGridAction2 = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction2, listGridAction2.withDisplayText("Display Text"));
  }

  /**
   * Test {@link ListGridAction#withForListGridReadOnly(Boolean)}.
   * <p>
   * Method under test: {@link ListGridAction#withForListGridReadOnly(Boolean)}
   */
  @Test
  public void testWithForListGridReadOnly() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction, listGridAction.withForListGridReadOnly(true));
  }

  /**
   * Test {@link ListGridAction#withActionUrlOverride(String)}.
   * <p>
   * Method under test: {@link ListGridAction#withActionUrlOverride(String)}
   */
  @Test
  public void testWithActionUrlOverride() {
    // Arrange
    ListGridAction listGridAction2 = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction2, listGridAction2.withActionUrlOverride("https://example.org/example"));
  }

  /**
   * Test {@link ListGridAction#withAllCapable(Boolean)}.
   * <p>
   * Method under test: {@link ListGridAction#withAllCapable(Boolean)}
   */
  @Test
  public void testWithAllCapable() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction, listGridAction.withAllCapable(true));
  }

  /**
   * Test {@link ListGridAction#withSingleActionOnly(Boolean)}.
   * <p>
   * Method under test: {@link ListGridAction#withSingleActionOnly(Boolean)}
   */
  @Test
  public void testWithSingleActionOnly() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction, listGridAction.withSingleActionOnly(true));
  }

  /**
   * Test {@link ListGridAction#withActionTargetEntity(String)}.
   * <p>
   * Method under test: {@link ListGridAction#withActionTargetEntity(String)}
   */
  @Test
  public void testWithActionTargetEntity() {
    // Arrange
    ListGridAction listGridAction2 = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction2, listGridAction2.withActionTargetEntity("Action Target Entity"));
  }

  /**
   * Test {@link ListGridAction#withIsConfirmEnabled(Boolean)}.
   * <p>
   * Method under test: {@link ListGridAction#withIsConfirmEnabled(Boolean)}
   */
  @Test
  public void testWithIsConfirmEnabled() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction, listGridAction.withIsConfirmEnabled(true));
  }

  /**
   * Test {@link ListGridAction#withConfirmEnabledText(String)}.
   * <p>
   * Method under test: {@link ListGridAction#withConfirmEnabledText(String)}
   */
  @Test
  public void testWithConfirmEnabledText() {
    // Arrange
    ListGridAction listGridAction2 = DefaultListGridActions.ADD;

    // Act and Assert
    assertSame(listGridAction2, listGridAction2.withConfirmEnabledText("Confirm Enabled Text"));
  }

  /**
   * Test {@link ListGridAction#getButtonClass()}.
   * <ul>
   *   <li>Then return {@code all-capable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGridAction#getButtonClass()}
   */
  @Test
  public void testGetButtonClass_thenReturnAllCapable() {
    // Arrange
    ListGridAction listGridAction = new ListGridAction("42");
    listGridAction.setAllCapable(true);

    // Act and Assert
    assertEquals(" all-capable", listGridAction.getButtonClass());
  }

  /**
   * Test {@link ListGridAction#getButtonClass()}.
   * <ul>
   *   <li>Then return {@code asset-grid-single-select single-action-only}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGridAction#getButtonClass()}
   */
  @Test
  public void testGetButtonClass_thenReturnAssetGridSingleSelectSingleActionOnly() {
    // Arrange, Act and Assert
    assertEquals("asset-grid-single-select single-action-only",
        DefaultListGridActions.ASSET_GRID_SINGLE_SELECT.getButtonClass());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ListGridAction#setActionTargetEntity(String)}
   *   <li>{@link ListGridAction#setActionUrlOverride(String)}
   *   <li>{@link ListGridAction#setAllCapable(Boolean)}
   *   <li>{@link ListGridAction#setButtonClass(String)}
   *   <li>{@link ListGridAction#setConfirmEnabledText(String)}
   *   <li>{@link ListGridAction#setDisplayText(String)}
   *   <li>{@link ListGridAction#setForListGridReadOnly(Boolean)}
   *   <li>{@link ListGridAction#setIconClass(String)}
   *   <li>{@link ListGridAction#setIsConfirmEnabled(Boolean)}
   *   <li>{@link ListGridAction#setRequiresNonEmptyGrid(Boolean)}
   *   <li>{@link ListGridAction#setSingleActionOnly(Boolean)}
   *   <li>{@link ListGridAction#setUrlPostfix(String)}
   *   <li>{@link ListGridAction#getActionId()}
   *   <li>{@link ListGridAction#getActionTargetEntity()}
   *   <li>{@link ListGridAction#getActionUrlOverride()}
   *   <li>{@link ListGridAction#getAllCapable()}
   *   <li>{@link ListGridAction#getConfirmEnabledText()}
   *   <li>{@link ListGridAction#getDisplayText()}
   *   <li>{@link ListGridAction#getForListGridReadOnly()}
   *   <li>{@link ListGridAction#getIconClass()}
   *   <li>{@link ListGridAction#getRequiresNonEmptyGrid()}
   *   <li>{@link ListGridAction#getSingleActionOnly()}
   *   <li>{@link ListGridAction#getUrlPostfix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ListGridAction listGridAction = new ListGridAction("42");

    // Act
    listGridAction.setActionTargetEntity("Action Target Entity");
    listGridAction.setActionUrlOverride("https://example.org/example");
    listGridAction.setAllCapable(true);
    listGridAction.setButtonClass("Button Class");
    listGridAction.setConfirmEnabledText("Confirm Enabled Text");
    listGridAction.setDisplayText("Display Text");
    listGridAction.setForListGridReadOnly(true);
    listGridAction.setIconClass("Icon Class");
    listGridAction.setIsConfirmEnabled(true);
    listGridAction.setRequiresNonEmptyGrid(true);
    listGridAction.setSingleActionOnly(true);
    listGridAction.setUrlPostfix("https://example.org/example");
    String actualActionId = listGridAction.getActionId();
    String actualActionTargetEntity = listGridAction.getActionTargetEntity();
    String actualActionUrlOverride = listGridAction.getActionUrlOverride();
    Boolean actualAllCapable = listGridAction.getAllCapable();
    String actualConfirmEnabledText = listGridAction.getConfirmEnabledText();
    String actualDisplayText = listGridAction.getDisplayText();
    Boolean actualForListGridReadOnly = listGridAction.getForListGridReadOnly();
    String actualIconClass = listGridAction.getIconClass();
    Boolean actualRequiresNonEmptyGrid = listGridAction.getRequiresNonEmptyGrid();
    Boolean actualSingleActionOnly = listGridAction.getSingleActionOnly();

    // Assert that nothing has changed
    assertEquals("42", actualActionId);
    assertEquals("Action Target Entity", actualActionTargetEntity);
    assertEquals("Confirm Enabled Text", actualConfirmEnabledText);
    assertEquals("Display Text", actualDisplayText);
    assertEquals("Icon Class", actualIconClass);
    assertEquals("https://example.org/example", actualActionUrlOverride);
    assertEquals("https://example.org/example", listGridAction.getUrlPostfix());
    assertTrue(actualAllCapable);
    assertTrue(actualForListGridReadOnly);
    assertTrue(actualRequiresNonEmptyGrid);
    assertTrue(actualSingleActionOnly);
  }

  /**
   * Test {@link ListGridAction#getIsConfirmEnabled()}.
   * <ul>
   *   <li>Given {@link DefaultListGridActions#ADD} IsConfirmEnabled is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGridAction#getIsConfirmEnabled()}
   */
  @Test
  public void testGetIsConfirmEnabled_givenAddIsConfirmEnabledIsNull_thenReturnFalse() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;
    listGridAction.setIsConfirmEnabled(null);

    // Act and Assert
    assertFalse(listGridAction.getIsConfirmEnabled());
  }

  /**
   * Test {@link ListGridAction#getIsConfirmEnabled()}.
   * <ul>
   *   <li>Given {@link DefaultListGridActions#ADD} IsConfirmEnabled is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGridAction#getIsConfirmEnabled()}
   */
  @Test
  public void testGetIsConfirmEnabled_givenAddIsConfirmEnabledIsTrue_thenReturnTrue() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;
    listGridAction.setIsConfirmEnabled(true);

    // Act and Assert
    assertTrue(listGridAction.getIsConfirmEnabled());
  }
}
