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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ListGridActionGroup.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ListGridActionGroupDiffblueTest {
  @Autowired private ListGridActionGroup listGridActionGroup;

  /**
   * Test {@link ListGridActionGroup#withName(String)}.
   *
   * <p>Method under test: {@link ListGridActionGroup#withName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridActionGroup ListGridActionGroup.withName(String)"})
  public void testWithName() {
    // Arrange and Act
    ListGridActionGroup actualWithNameResult = listGridActionGroup.withName("Name");

    // Assert
    assertEquals("Name", listGridActionGroup.getName());
    assertSame(listGridActionGroup, actualWithNameResult);
  }

  /**
   * Test {@link ListGridActionGroup#withActionGroupClass(String)}.
   *
   * <p>Method under test: {@link ListGridActionGroup#withActionGroupClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridActionGroup ListGridActionGroup.withActionGroupClass(String)"})
  public void testWithActionGroupClass() {
    // Arrange and Act
    ListGridActionGroup actualWithActionGroupClassResult =
        listGridActionGroup.withActionGroupClass("Action Group Class");

    // Assert
    assertEquals("Action Group Class", listGridActionGroup.getActionGroupClass());
    assertSame(listGridActionGroup, actualWithActionGroupClassResult);
  }

  /**
   * Test {@link ListGridActionGroup#getActiveActions(boolean)}.
   *
   * <ul>
   *   <li>Given {@link ListGridActionGroup} (default constructor) addAction {@link
   *       DefaultListGridActions#ADD_EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListGridActionGroup#getActiveActions(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListGridActionGroup.getActiveActions(boolean)"})
  public void testGetActiveActions_givenListGridActionGroupAddActionAdd_empty_thenReturnEmpty() {
    // Arrange
    ListGridActionGroup listGridActionGroup = new ListGridActionGroup();
    listGridActionGroup.addAction(DefaultListGridActions.ADD_EMPTY);

    // Act and Assert
    assertTrue(listGridActionGroup.getActiveActions(true).isEmpty());
  }

  /**
   * Test {@link ListGridActionGroup#getActiveActions(boolean)}.
   *
   * <ul>
   *   <li>Given {@link ListGridActionGroup} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListGridActionGroup#getActiveActions(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListGridActionGroup.getActiveActions(boolean)"})
  public void testGetActiveActions_givenListGridActionGroup_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ListGridActionGroup().getActiveActions(true).isEmpty());
  }

  /**
   * Test {@link ListGridActionGroup#findAction(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DefaultListGridActions#ADD}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ListGridActionGroup#findAction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridActionGroup.findAction(String)"})
  public void testFindAction_givenArrayListAddAdd_thenReturnNull() {
    // Arrange
    ArrayList<ListGridAction> listGridActions = new ArrayList<>();
    listGridActions.add(DefaultListGridActions.ADD);
    listGridActionGroup.setListGridActions(listGridActions);

    // Act and Assert
    assertNull(listGridActionGroup.findAction("42"));
  }

  /**
   * Test {@link ListGridActionGroup#findAction(String)}.
   *
   * <ul>
   *   <li>Given {@link ListGridActionGroup}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ListGridActionGroup#findAction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridActionGroup.findAction(String)"})
  public void testFindAction_givenListGridActionGroup_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(listGridActionGroup.findAction("42"));
  }

  /**
   * Test {@link ListGridActionGroup#findAction(String)}.
   *
   * <ul>
   *   <li>Then return {@link ListGridAction#ListGridAction(String)} with actionId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ListGridActionGroup#findAction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridActionGroup.findAction(String)"})
  public void testFindAction_thenReturnListGridActionWithActionIdIs42() {
    // Arrange
    ArrayList<ListGridAction> listGridActions = new ArrayList<>();
    ListGridAction listGridAction = new ListGridAction("42");
    listGridActions.add(listGridAction);
    listGridActionGroup.setListGridActions(listGridActions);

    // Act and Assert
    assertSame(listGridAction, listGridActionGroup.findAction("42"));
  }

  /**
   * Test {@link ListGridActionGroup#addAction(ListGridAction)}.
   *
   * <p>Method under test: {@link ListGridActionGroup#addAction(ListGridAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListGridActionGroup.addAction(ListGridAction)"})
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
   * Test {@link ListGridActionGroup#clone()}.
   *
   * <p>Method under test: {@link ListGridActionGroup#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridActionGroup ListGridActionGroup.clone()"})
  public void testClone() {
    // Arrange and Act
    ListGridActionGroup actualCloneResult = new ListGridActionGroup().clone();

    // Assert
    assertEquals("", actualCloneResult.getActionGroupClass());
    assertEquals("", actualCloneResult.getName());
    assertTrue(actualCloneResult.getListGridActions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ListGridActionGroup.<init>()",
    "String ListGridActionGroup.getActionGroupClass()",
    "List ListGridActionGroup.getListGridActions()",
    "String ListGridActionGroup.getName()",
    "void ListGridActionGroup.setActionGroupClass(String)",
    "void ListGridActionGroup.setListGridActions(List)",
    "void ListGridActionGroup.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ListGridActionGroup actualListGridActionGroup = new ListGridActionGroup();
    actualListGridActionGroup.setActionGroupClass("Action Group Class");
    ArrayList<ListGridAction> listGridActions = new ArrayList<>();
    actualListGridActionGroup.setListGridActions(listGridActions);
    actualListGridActionGroup.setName("Name");
    String actualActionGroupClass = actualListGridActionGroup.getActionGroupClass();
    List<ListGridAction> actualListGridActions = actualListGridActionGroup.getListGridActions();

    // Assert
    assertEquals("Action Group Class", actualActionGroupClass);
    assertEquals("Name", actualListGridActionGroup.getName());
    assertTrue(actualListGridActions.isEmpty());
    assertSame(listGridActions, actualListGridActions);
  }
}
