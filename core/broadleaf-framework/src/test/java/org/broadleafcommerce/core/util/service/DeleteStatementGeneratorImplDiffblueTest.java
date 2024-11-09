/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Stack;
import org.junit.Test;

public class DeleteStatementGeneratorImplDiffblueTest {
  /**
   * Test
   * {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeleteStatementGeneratorImpl#getSqls(String, DeleteStatementGeneratorImpl.OperationStackHolder)}
   */
  @Test
  public void testGetSqls_thenReturnAString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();
    stack.add(new DeleteStatementGeneratorImpl.PathElement("delete FROM ", "delete FROM ", "delete FROM "));
    stack.add(new DeleteStatementGeneratorImpl.PathElement("delete FROM ", "delete FROM ", "delete FROM "));
    stack.add(new DeleteStatementGeneratorImpl.PathElement("Name", "Id Field", "Join Column"));
    DeleteStatementGeneratorImpl.OperationStackHolder operationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack);

    // Act and Assert
    assertEquals(
        "delete FROM Name WHERE Join Column IN (SELECT b.delete FROM  FROM delete FROM  b inner join delete"
            + " FROM  a0 on b.delete FROM =a0.delete FROM  WHERE a0.delete FROM =42)",
        deleteStatementGeneratorImpl.getSqls("42", operationStackHolder));
    Stack<DeleteStatementGeneratorImpl.PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test
   * {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   * <ul>
   *   <li>Then return {@code delete FROM Name WHERE Id Field=42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeleteStatementGeneratorImpl#getSqls(String, DeleteStatementGeneratorImpl.OperationStackHolder)}
   */
  @Test
  public void testGetSqls_thenReturnDeleteFromNameWhereIdField42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();
    stack.add(new DeleteStatementGeneratorImpl.PathElement("Name", "Id Field", "Join Column"));
    DeleteStatementGeneratorImpl.OperationStackHolder operationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack);

    // Act and Assert
    assertEquals("delete FROM Name WHERE Id Field=42",
        deleteStatementGeneratorImpl.getSqls("42", operationStackHolder));
    Stack<DeleteStatementGeneratorImpl.PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test
   * {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   * <ul>
   *   <li>Then return {@code delete FROM Name WHERE Join Column=42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeleteStatementGeneratorImpl#getSqls(String, DeleteStatementGeneratorImpl.OperationStackHolder)}
   */
  @Test
  public void testGetSqls_thenReturnDeleteFromNameWhereJoinColumn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();
    stack.add(new DeleteStatementGeneratorImpl.PathElement("delete FROM ", "delete FROM ", "delete FROM "));
    stack.add(new DeleteStatementGeneratorImpl.PathElement("Name", "Id Field", "Join Column"));
    DeleteStatementGeneratorImpl.OperationStackHolder operationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack);

    // Act and Assert
    assertEquals("delete FROM Name WHERE Join Column=42",
        deleteStatementGeneratorImpl.getSqls("42", operationStackHolder));
    Stack<DeleteStatementGeneratorImpl.PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test
   * {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   * <ul>
   *   <li>Then return
   * {@code update Name SET 2020-03-01=NULL WHERE Id Field=42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeleteStatementGeneratorImpl#getSqls(String, DeleteStatementGeneratorImpl.OperationStackHolder)}
   */
  @Test
  public void testGetSqls_thenReturnUpdateNameSet20200301NullWhereIdField42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<DeleteStatementGeneratorImpl.PathElement> pathElementList = new Stack<>();
    pathElementList.add(new DeleteStatementGeneratorImpl.PathElement("Name", "Id Field", "Join Column"));
    DeleteStatementGeneratorImpl.OperationStackHolder operationStackHolder = mock(
        DeleteStatementGeneratorImpl.OperationStackHolder.class);
    when(operationStackHolder.getColumnToUpdate()).thenReturn("2020-03-01");
    when(operationStackHolder.isUpdate()).thenReturn(true);
    when(operationStackHolder.getStack()).thenReturn(pathElementList);

    // Act
    String actualSqls = deleteStatementGeneratorImpl.getSqls("42", operationStackHolder);

    // Assert
    verify(operationStackHolder).getColumnToUpdate();
    verify(operationStackHolder).getStack();
    verify(operationStackHolder).isUpdate();
    assertEquals("update Name SET 2020-03-01=NULL WHERE Id Field=42", actualSqls);
  }

  /**
   * Test OperationStackHolder getters and setters.
   * <ul>
   *   <li>Then return ColumnToUpdate is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#OperationStackHolder(Stack, boolean, String)}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#getStack()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  public void testOperationStackHolderGettersAndSetters_thenReturnColumnToUpdateIs20200301() {
    // Arrange
    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();

    // Act
    DeleteStatementGeneratorImpl.OperationStackHolder actualOperationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack, true, "2020-03-01");
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<DeleteStatementGeneratorImpl.PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult = actualOperationStackHolder.isManyToOneRelationshipDelete();
    boolean actualIsRelationshipUpdateResult = actualOperationStackHolder.isRelationshipUpdate();
    boolean actualIsUpdateResult = actualOperationStackHolder.isUpdate();

    // Assert
    assertEquals("2020-03-01", actualColumnToUpdate);
    assertFalse(actualIsManyToOneRelationshipDeleteResult);
    assertFalse(actualIsRelationshipUpdateResult);
    assertFalse(actualOperationStackHolder.isXref());
    assertTrue(actualIsUpdateResult);
    assertSame(stack, actualStack);
  }

  /**
   * Test OperationStackHolder getters and setters.
   * <ul>
   *   <li>Then return ColumnToUpdate is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#OperationStackHolder(Stack)}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#getStack()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  public void testOperationStackHolderGettersAndSetters_thenReturnColumnToUpdateIsNull() {
    // Arrange
    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();

    // Act
    DeleteStatementGeneratorImpl.OperationStackHolder actualOperationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<DeleteStatementGeneratorImpl.PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult = actualOperationStackHolder.isManyToOneRelationshipDelete();
    boolean actualIsRelationshipUpdateResult = actualOperationStackHolder.isRelationshipUpdate();
    boolean actualIsUpdateResult = actualOperationStackHolder.isUpdate();

    // Assert
    assertNull(actualColumnToUpdate);
    assertFalse(actualIsManyToOneRelationshipDeleteResult);
    assertFalse(actualIsRelationshipUpdateResult);
    assertFalse(actualIsUpdateResult);
    assertFalse(actualOperationStackHolder.isXref());
    assertSame(stack, actualStack);
  }

  /**
   * Test OperationStackHolder getters and setters.
   * <ul>
   *   <li>Then return ManyToOneRelationshipDelete.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#OperationStackHolder(Stack, boolean, String, boolean, boolean)}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#getStack()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  public void testOperationStackHolderGettersAndSetters_thenReturnManyToOneRelationshipDelete() {
    // Arrange
    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();

    // Act
    DeleteStatementGeneratorImpl.OperationStackHolder actualOperationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack, true, "2020-03-01", true, true);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<DeleteStatementGeneratorImpl.PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult = actualOperationStackHolder.isManyToOneRelationshipDelete();
    boolean actualIsRelationshipUpdateResult = actualOperationStackHolder.isRelationshipUpdate();
    boolean actualIsUpdateResult = actualOperationStackHolder.isUpdate();

    // Assert
    assertEquals("2020-03-01", actualColumnToUpdate);
    assertFalse(actualOperationStackHolder.isXref());
    assertTrue(actualIsManyToOneRelationshipDeleteResult);
    assertTrue(actualIsRelationshipUpdateResult);
    assertTrue(actualIsUpdateResult);
    assertSame(stack, actualStack);
  }

  /**
   * Test OperationStackHolder getters and setters.
   * <ul>
   *   <li>Then return RelationshipUpdate.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#OperationStackHolder(Stack, boolean, String, boolean)}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#getStack()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  public void testOperationStackHolderGettersAndSetters_thenReturnRelationshipUpdate() {
    // Arrange
    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();

    // Act
    DeleteStatementGeneratorImpl.OperationStackHolder actualOperationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack, true, "2020-03-01", true);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<DeleteStatementGeneratorImpl.PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult = actualOperationStackHolder.isManyToOneRelationshipDelete();
    boolean actualIsRelationshipUpdateResult = actualOperationStackHolder.isRelationshipUpdate();
    boolean actualIsUpdateResult = actualOperationStackHolder.isUpdate();

    // Assert
    assertEquals("2020-03-01", actualColumnToUpdate);
    assertFalse(actualIsManyToOneRelationshipDeleteResult);
    assertFalse(actualOperationStackHolder.isXref());
    assertTrue(actualIsRelationshipUpdateResult);
    assertTrue(actualIsUpdateResult);
    assertSame(stack, actualStack);
  }

  /**
   * Test OperationStackHolder getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Xref.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#OperationStackHolder(Stack, boolean)}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#getStack()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>
   * {@link DeleteStatementGeneratorImpl.OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isUpdate()}
   *   <li>{@link DeleteStatementGeneratorImpl.OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  public void testOperationStackHolderGettersAndSetters_whenTrue_thenReturnXref() {
    // Arrange
    Stack<DeleteStatementGeneratorImpl.PathElement> stack = new Stack<>();

    // Act
    DeleteStatementGeneratorImpl.OperationStackHolder actualOperationStackHolder = new DeleteStatementGeneratorImpl.OperationStackHolder(
        stack, true);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<DeleteStatementGeneratorImpl.PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult = actualOperationStackHolder.isManyToOneRelationshipDelete();
    boolean actualIsRelationshipUpdateResult = actualOperationStackHolder.isRelationshipUpdate();
    boolean actualIsUpdateResult = actualOperationStackHolder.isUpdate();

    // Assert
    assertNull(actualColumnToUpdate);
    assertFalse(actualIsManyToOneRelationshipDeleteResult);
    assertFalse(actualIsRelationshipUpdateResult);
    assertFalse(actualIsUpdateResult);
    assertTrue(actualOperationStackHolder.isXref());
    assertSame(stack, actualStack);
  }

  /**
   * Test PathElement getters and setters.
   * <ul>
   *   <li>When {@code Join Column}.</li>
   *   <li>Then return not FromManyToOne.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteStatementGeneratorImpl.PathElement#PathElement(String, String, String)}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#getIdField()}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#getJoinColumn()}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#getName()}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#isFromManyToOne()}
   * </ul>
   */
  @Test
  public void testPathElementGettersAndSetters_whenJoinColumn_thenReturnNotFromManyToOne() {
    // Arrange and Act
    DeleteStatementGeneratorImpl.PathElement actualPathElement = new DeleteStatementGeneratorImpl.PathElement("Name",
        "Id Field", "Join Column");
    String actualIdField = actualPathElement.getIdField();
    String actualJoinColumn = actualPathElement.getJoinColumn();
    String actualName = actualPathElement.getName();

    // Assert
    assertEquals("Id Field", actualIdField);
    assertEquals("Join Column", actualJoinColumn);
    assertEquals("Name", actualName);
    assertFalse(actualPathElement.isFromManyToOne());
  }

  /**
   * Test PathElement getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return FromManyToOne.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteStatementGeneratorImpl.PathElement#PathElement(String, String, String, boolean)}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#getIdField()}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#getJoinColumn()}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#getName()}
   *   <li>{@link DeleteStatementGeneratorImpl.PathElement#isFromManyToOne()}
   * </ul>
   */
  @Test
  public void testPathElementGettersAndSetters_whenTrue_thenReturnFromManyToOne() {
    // Arrange and Act
    DeleteStatementGeneratorImpl.PathElement actualPathElement = new DeleteStatementGeneratorImpl.PathElement("Name",
        "Id Field", "Join Column", true);
    String actualIdField = actualPathElement.getIdField();
    String actualJoinColumn = actualPathElement.getJoinColumn();
    String actualName = actualPathElement.getName();

    // Assert
    assertEquals("Id Field", actualIdField);
    assertEquals("Join Column", actualJoinColumn);
    assertEquals("Name", actualName);
    assertTrue(actualPathElement.isFromManyToOne());
  }
}
