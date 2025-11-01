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
package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {ListGridActionGroup.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ListGridActionGroupDiffblueTest {
  @Autowired
  private ListGridActionGroup listGridActionGroup;

  /**
   * Method under test: {@link ListGridActionGroup#withName(String)}
   */
  @Test
  public void testWithName() {
    // Arrange and Act
    ListGridActionGroup actualWithNameResult = listGridActionGroup.withName("Name");

    // Assert
    assertEquals("Name", listGridActionGroup.getName());
    assertSame(listGridActionGroup, actualWithNameResult);
  }

  /**
   * Method under test: {@link ListGridActionGroup#withActionGroupClass(String)}
   */
  @Test
  public void testWithActionGroupClass() {
    // Arrange and Act
    ListGridActionGroup actualWithActionGroupClassResult = listGridActionGroup
        .withActionGroupClass("Action Group Class");

    // Assert
    assertEquals("Action Group Class", listGridActionGroup.getActionGroupClass());
    assertSame(listGridActionGroup, actualWithActionGroupClassResult);
  }

  /**
   * Method under test: {@link ListGridActionGroup#getActiveActions(boolean)}
   */
  @Test
  public void testGetActiveActions() {
    // Arrange, Act and Assert
    assertTrue((new ListGridActionGroup()).getActiveActions(true).isEmpty());
  }

  /**
   * Method under test: {@link ListGridActionGroup#getActiveActions(boolean)}
   */
  @Test
  public void testGetActiveActions2() {
    // Arrange
    ListGridActionGroup listGridActionGroup = new ListGridActionGroup();
    listGridActionGroup.addAction(DefaultListGridActions.ADD);

    // Act
    List<ListGridAction> actualActiveActions = listGridActionGroup.getActiveActions(true);

    // Assert
    assertEquals(1, actualActiveActions.size());
    ListGridAction getResult = actualActiveActions.get(0);
    assertEquals("Action Target Entity", getResult.getActionTargetEntity());
    assertEquals("Button Class all-capable single-action-only", getResult.getButtonClass());
    assertEquals("Button Class", getResult.buttonClass);
    assertEquals("Confirm Enabled Text", getResult.getConfirmEnabledText());
    assertEquals("Display Text", getResult.getDisplayText());
    assertEquals("Icon Class", getResult.getIconClass());
    assertEquals("https://example.org/example", getResult.getActionUrlOverride());
    assertEquals("https://example.org/example", getResult.getUrlPostfix());
    assertTrue(getResult.getAllCapable());
    assertTrue(getResult.getForListGridReadOnly());
    assertTrue(getResult.getIsConfirmEnabled());
    assertTrue(getResult.getRequiresNonEmptyGrid());
    assertTrue(getResult.getSingleActionOnly());
    assertTrue(getResult.isConfirmEnabled);
    assertEquals(ListGridAction.ADD, getResult.getActionId());
  }

  /**
   * Method under test: {@link ListGridActionGroup#getActiveActions(boolean)}
   */
  @Test
  public void testGetActiveActions3() {
    // Arrange
    ListGridActionGroup listGridActionGroup = new ListGridActionGroup();
    listGridActionGroup.addAction(DefaultListGridActions.ADD_EMPTY);

    // Act and Assert
    assertTrue(listGridActionGroup.getActiveActions(true).isEmpty());
  }

  /**
   * Method under test: {@link ListGridActionGroup#findAction(String)}
   */
  @Test
  public void testFindAction() {
    // Arrange, Act and Assert
    assertNull(listGridActionGroup.findAction("42"));
  }

  /**
   * Method under test: {@link ListGridActionGroup#addAction(ListGridAction)}
   */
  @Test
  public void testAddAction() {
    // Arrange
    ListGridActionGroup listGridActionGroup = new ListGridActionGroup();
    ListGridAction action = DefaultListGridActions.ADD;

    // Act
    listGridActionGroup.addAction(action);

    // Assert
    List<ListGridAction> listGridActions = listGridActionGroup.getListGridActions();
    assertEquals(1, listGridActions.size());
    assertSame(action, listGridActions.get(0));
  }

  /**
   * Method under test: {@link ListGridActionGroup#removeAllActions()}
   */
  @Test
  public void testRemoveAllActions() {
    // Arrange
    ListGridActionGroup listGridActionGroup = new ListGridActionGroup();

    // Act
    listGridActionGroup.removeAllActions();

    // Assert
    assertTrue(listGridActionGroup.getListGridActions().isEmpty());
  }

  /**
   * Method under test: {@link ListGridActionGroup#removeAllActions()}
   */
  @Test
  public void testRemoveAllActions2() {
    // Arrange
    ListGridActionGroup listGridActionGroup = new ListGridActionGroup();
    listGridActionGroup.addAction(mock(ListGridAction.class));

    // Act
    listGridActionGroup.removeAllActions();

    // Assert
    assertTrue(listGridActionGroup.getListGridActions().isEmpty());
  }

  /**
   * Method under test: {@link ListGridActionGroup#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    ListGridActionGroup actualCloneResult = (new ListGridActionGroup()).clone();

    // Assert
    assertEquals("", actualCloneResult.getActionGroupClass());
    assertEquals("", actualCloneResult.getName());
    assertTrue(actualCloneResult.getListGridActions().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ListGridActionGroup}
   *   <li>{@link ListGridActionGroup#setActionGroupClass(String)}
   *   <li>{@link ListGridActionGroup#setListGridActions(List)}
   *   <li>{@link ListGridActionGroup#setName(String)}
   *   <li>{@link ListGridActionGroup#getActionGroupClass()}
   *   <li>{@link ListGridActionGroup#getListGridActions()}
   *   <li>{@link ListGridActionGroup#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ListGridActionGroup actualListGridActionGroup = new ListGridActionGroup();
    actualListGridActionGroup.setActionGroupClass("Action Group Class");
    ArrayList<ListGridAction> listGridActions = new ArrayList<>();
    actualListGridActionGroup.setListGridActions(listGridActions);
    actualListGridActionGroup.setName("Name");
    String actualActionGroupClass = actualListGridActionGroup.getActionGroupClass();
    List<ListGridAction> actualListGridActions = actualListGridActionGroup.getListGridActions();

    // Assert that nothing has changed
    assertEquals("Action Group Class", actualActionGroupClass);
    assertEquals("Name", actualListGridActionGroup.getName());
    assertTrue(actualListGridActions.isEmpty());
    assertSame(listGridActions, actualListGridActions);
  }
}
