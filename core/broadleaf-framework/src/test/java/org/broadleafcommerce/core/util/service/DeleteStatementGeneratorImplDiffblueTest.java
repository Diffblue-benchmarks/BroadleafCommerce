/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Stack;
import org.broadleafcommerce.core.util.service.DeleteStatementGeneratorImpl.OperationStackHolder;
import org.broadleafcommerce.core.util.service.DeleteStatementGeneratorImpl.PathElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeleteStatementGeneratorImplDiffblueTest {
  /**
   * Test {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   *
   * <p>Method under test: {@link DeleteStatementGeneratorImpl#getSqls(String,
   * OperationStackHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeleteStatementGeneratorImpl.getSqls(String, OperationStackHolder)"})
  public void testGetSqls() {
    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    PathElement pathElement = mock(PathElement.class);
    when(pathElement.getIdField()).thenReturn("Id Field");
    when(pathElement.isFromManyToOne()).thenReturn(true);
    when(pathElement.getJoinColumn()).thenReturn("Join Column");
    when(pathElement.getName()).thenReturn("Name");

    Stack<PathElement> stack = new Stack<>();
    PathElement pathElement2 = new PathElement("delete FROM ", "delete FROM ", "delete FROM ");
    stack.add(pathElement2);
    stack.add(pathElement);
    OperationStackHolder operationStackHolder = new OperationStackHolder(stack);

    // Act
    String actualSqls = deleteStatementGeneratorImpl.getSqls("42", operationStackHolder);

    // Assert
    verify(pathElement).getIdField();
    verify(pathElement, atLeast(1)).getJoinColumn();
    verify(pathElement).getName();
    verify(pathElement).isFromManyToOne();
    assertEquals(
        "delete FROM Name WHERE Id Field IN (SELECT t.Join Column FROM delete FROM  t WHERE t.delete"
            + " FROM =42)",
        actualSqls);
    Stack<PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   *
   * <ul>
   *   <li>Given {@link PathElement} {@link PathElement#getJoinColumn()} return {@code Join Column}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DeleteStatementGeneratorImpl#getSqls(String,
   * OperationStackHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeleteStatementGeneratorImpl.getSqls(String, OperationStackHolder)"})
  public void testGetSqls_givenPathElementGetJoinColumnReturnJoinColumn_thenReturnAString() {
    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    PathElement pathElement = mock(PathElement.class);
    when(pathElement.getJoinColumn()).thenReturn("Join Column");
    when(pathElement.getName()).thenReturn("Name");

    PathElement pathElement2 = mock(PathElement.class);
    when(pathElement2.isFromManyToOne()).thenReturn(true);
    when(pathElement2.getIdField()).thenReturn("Id Field");
    when(pathElement2.getJoinColumn()).thenReturn("Join Column");
    when(pathElement2.getName()).thenReturn("Name");

    Stack<PathElement> stack = new Stack<>();
    PathElement pathElement3 = new PathElement("delete FROM ", "delete FROM ", "delete FROM ");
    stack.add(pathElement3);
    stack.add(pathElement2);
    stack.add(pathElement);
    OperationStackHolder operationStackHolder = new OperationStackHolder(stack);

    // Act
    String actualSqls = deleteStatementGeneratorImpl.getSqls("42", operationStackHolder);

    // Assert
    verify(pathElement2, atLeast(1)).getIdField();
    verify(pathElement2).getJoinColumn();
    verify(pathElement).getJoinColumn();
    verify(pathElement2).getName();
    verify(pathElement).getName();
    verify(pathElement2).isFromManyToOne();
    assertEquals(
        "delete FROM Name WHERE Join Column IN (SELECT b.Id Field FROM Name b inner join delete FROM  a0 on"
            + " b.Id Field=a0.Join Column WHERE a0.delete FROM =42)",
        actualSqls);
    Stack<PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   *
   * <ul>
   *   <li>Given {@link PathElement#PathElement(String, String, String)} with {@code Name} and
   *       {@code Id Field} and {@code Join Column}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DeleteStatementGeneratorImpl#getSqls(String,
   * OperationStackHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeleteStatementGeneratorImpl.getSqls(String, OperationStackHolder)"})
  public void testGetSqls_givenPathElementWithNameAndIdFieldAndJoinColumn_thenReturnAString() {
    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<PathElement> stack = new Stack<>();
    PathElement pathElement = new PathElement("delete FROM ", "delete FROM ", "delete FROM ");
    stack.add(pathElement);
    PathElement pathElement2 = new PathElement("delete FROM ", "delete FROM ", "delete FROM ");
    stack.add(pathElement2);
    PathElement pathElement3 = new PathElement("Name", "Id Field", "Join Column");
    stack.add(pathElement3);
    OperationStackHolder operationStackHolder = new OperationStackHolder(stack);

    // Act and Assert
    assertEquals(
        "delete FROM Name WHERE Join Column IN (SELECT b.delete FROM  FROM delete FROM  b inner join delete"
            + " FROM  a0 on b.delete FROM =a0.delete FROM  WHERE a0.delete FROM =42)",
        deleteStatementGeneratorImpl.getSqls("42", operationStackHolder));
    Stack<PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   *
   * <ul>
   *   <li>Then return {@code delete FROM delete FROM WHERE delete FROM =42}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteStatementGeneratorImpl#getSqls(String,
   * OperationStackHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeleteStatementGeneratorImpl.getSqls(String, OperationStackHolder)"})
  public void testGetSqls_thenReturnDeleteFromDeleteFromWhereDeleteFrom42() {
    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<PathElement> stack = new Stack<>();
    PathElement pathElement = new PathElement("delete FROM ", "delete FROM ", "delete FROM ");
    stack.add(pathElement);
    PathElement pathElement2 =
        new PathElement("delete FROM ", "delete FROM ", "delete FROM ", true);
    stack.add(pathElement2);
    OperationStackHolder operationStackHolder = new OperationStackHolder(stack);

    // Act and Assert
    assertEquals(
        "delete FROM delete FROM  WHERE delete FROM =42",
        deleteStatementGeneratorImpl.getSqls("42", operationStackHolder));
    Stack<PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   *
   * <ul>
   *   <li>Then return {@code delete FROM Name WHERE Id Field=42}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteStatementGeneratorImpl#getSqls(String,
   * OperationStackHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeleteStatementGeneratorImpl.getSqls(String, OperationStackHolder)"})
  public void testGetSqls_thenReturnDeleteFromNameWhereIdField42() {
    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<PathElement> stack = new Stack<>();
    PathElement pathElement = new PathElement("Name", "Id Field", "Join Column");
    stack.add(pathElement);
    OperationStackHolder operationStackHolder = new OperationStackHolder(stack);

    // Act and Assert
    assertEquals(
        "delete FROM Name WHERE Id Field=42",
        deleteStatementGeneratorImpl.getSqls("42", operationStackHolder));
    Stack<PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test {@link DeleteStatementGeneratorImpl#getSqls(String, OperationStackHolder)}.
   *
   * <ul>
   *   <li>Then return {@code delete FROM Name WHERE Join Column=42}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteStatementGeneratorImpl#getSqls(String,
   * OperationStackHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeleteStatementGeneratorImpl.getSqls(String, OperationStackHolder)"})
  public void testGetSqls_thenReturnDeleteFromNameWhereJoinColumn42() {
    // Arrange
    DeleteStatementGeneratorImpl deleteStatementGeneratorImpl = new DeleteStatementGeneratorImpl();

    Stack<PathElement> stack = new Stack<>();
    PathElement pathElement = new PathElement("delete FROM ", "delete FROM ", "delete FROM ");
    stack.add(pathElement);
    PathElement pathElement2 = new PathElement("Name", "Id Field", "Join Column");
    stack.add(pathElement2);
    OperationStackHolder operationStackHolder = new OperationStackHolder(stack);

    // Act and Assert
    assertEquals(
        "delete FROM Name WHERE Join Column=42",
        deleteStatementGeneratorImpl.getSqls("42", operationStackHolder));
    Stack<PathElement> stack2 = operationStackHolder.getStack();
    assertTrue(stack2.isEmpty());
    assertSame(stack, stack2);
  }

  /**
   * Test OperationStackHolder getters and setters.
   *
   * <ul>
   *   <li>Then return ColumnToUpdate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationStackHolder#OperationStackHolder(Stack, boolean, String)}
   *   <li>{@link OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link OperationStackHolder#getStack()}
   *   <li>{@link OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>{@link OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link OperationStackHolder#isUpdate()}
   *   <li>{@link OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationStackHolder.<init>(Stack)",
    "void OperationStackHolder.<init>(Stack, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean, boolean)",
    "String OperationStackHolder.getColumnToUpdate()",
    "Stack OperationStackHolder.getStack()",
    "boolean OperationStackHolder.isManyToOneRelationshipDelete()",
    "boolean OperationStackHolder.isRelationshipUpdate()",
    "boolean OperationStackHolder.isUpdate()",
    "boolean OperationStackHolder.isXref()"
  })
  public void testOperationStackHolderGettersAndSetters_thenReturnColumnToUpdateIs20200301() {
    // Arrange
    Stack<PathElement> stack = new Stack<>();

    // Act
    OperationStackHolder actualOperationStackHolder =
        new OperationStackHolder(stack, true, "2020-03-01");
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult =
        actualOperationStackHolder.isManyToOneRelationshipDelete();
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
   *
   * <ul>
   *   <li>Then return ColumnToUpdate is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationStackHolder#OperationStackHolder(Stack)}
   *   <li>{@link OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link OperationStackHolder#getStack()}
   *   <li>{@link OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>{@link OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link OperationStackHolder#isUpdate()}
   *   <li>{@link OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationStackHolder.<init>(Stack)",
    "void OperationStackHolder.<init>(Stack, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean, boolean)",
    "String OperationStackHolder.getColumnToUpdate()",
    "Stack OperationStackHolder.getStack()",
    "boolean OperationStackHolder.isManyToOneRelationshipDelete()",
    "boolean OperationStackHolder.isRelationshipUpdate()",
    "boolean OperationStackHolder.isUpdate()",
    "boolean OperationStackHolder.isXref()"
  })
  public void testOperationStackHolderGettersAndSetters_thenReturnColumnToUpdateIsNull() {
    // Arrange
    Stack<PathElement> stack = new Stack<>();

    // Act
    OperationStackHolder actualOperationStackHolder = new OperationStackHolder(stack);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult =
        actualOperationStackHolder.isManyToOneRelationshipDelete();
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
   *
   * <ul>
   *   <li>Then return ManyToOneRelationshipDelete.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationStackHolder#OperationStackHolder(Stack, boolean, String, boolean,
   *       boolean)}
   *   <li>{@link OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link OperationStackHolder#getStack()}
   *   <li>{@link OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>{@link OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link OperationStackHolder#isUpdate()}
   *   <li>{@link OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationStackHolder.<init>(Stack)",
    "void OperationStackHolder.<init>(Stack, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean, boolean)",
    "String OperationStackHolder.getColumnToUpdate()",
    "Stack OperationStackHolder.getStack()",
    "boolean OperationStackHolder.isManyToOneRelationshipDelete()",
    "boolean OperationStackHolder.isRelationshipUpdate()",
    "boolean OperationStackHolder.isUpdate()",
    "boolean OperationStackHolder.isXref()"
  })
  public void testOperationStackHolderGettersAndSetters_thenReturnManyToOneRelationshipDelete() {
    // Arrange
    Stack<PathElement> stack = new Stack<>();

    // Act
    OperationStackHolder actualOperationStackHolder =
        new OperationStackHolder(stack, true, "2020-03-01", true, true);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult =
        actualOperationStackHolder.isManyToOneRelationshipDelete();
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
   *
   * <ul>
   *   <li>Then return RelationshipUpdate.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationStackHolder#OperationStackHolder(Stack, boolean, String, boolean)}
   *   <li>{@link OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link OperationStackHolder#getStack()}
   *   <li>{@link OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>{@link OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link OperationStackHolder#isUpdate()}
   *   <li>{@link OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationStackHolder.<init>(Stack)",
    "void OperationStackHolder.<init>(Stack, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean, boolean)",
    "String OperationStackHolder.getColumnToUpdate()",
    "Stack OperationStackHolder.getStack()",
    "boolean OperationStackHolder.isManyToOneRelationshipDelete()",
    "boolean OperationStackHolder.isRelationshipUpdate()",
    "boolean OperationStackHolder.isUpdate()",
    "boolean OperationStackHolder.isXref()"
  })
  public void testOperationStackHolderGettersAndSetters_thenReturnRelationshipUpdate() {
    // Arrange
    Stack<PathElement> stack = new Stack<>();

    // Act
    OperationStackHolder actualOperationStackHolder =
        new OperationStackHolder(stack, true, "2020-03-01", true);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult =
        actualOperationStackHolder.isManyToOneRelationshipDelete();
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
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Xref.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationStackHolder#OperationStackHolder(Stack, boolean)}
   *   <li>{@link OperationStackHolder#getColumnToUpdate()}
   *   <li>{@link OperationStackHolder#getStack()}
   *   <li>{@link OperationStackHolder#isManyToOneRelationshipDelete()}
   *   <li>{@link OperationStackHolder#isRelationshipUpdate()}
   *   <li>{@link OperationStackHolder#isUpdate()}
   *   <li>{@link OperationStackHolder#isXref()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationStackHolder.<init>(Stack)",
    "void OperationStackHolder.<init>(Stack, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean)",
    "void OperationStackHolder.<init>(Stack, boolean, String, boolean, boolean)",
    "String OperationStackHolder.getColumnToUpdate()",
    "Stack OperationStackHolder.getStack()",
    "boolean OperationStackHolder.isManyToOneRelationshipDelete()",
    "boolean OperationStackHolder.isRelationshipUpdate()",
    "boolean OperationStackHolder.isUpdate()",
    "boolean OperationStackHolder.isXref()"
  })
  public void testOperationStackHolderGettersAndSetters_whenTrue_thenReturnXref() {
    // Arrange
    Stack<PathElement> stack = new Stack<>();

    // Act
    OperationStackHolder actualOperationStackHolder = new OperationStackHolder(stack, true);
    String actualColumnToUpdate = actualOperationStackHolder.getColumnToUpdate();
    Stack<PathElement> actualStack = actualOperationStackHolder.getStack();
    boolean actualIsManyToOneRelationshipDeleteResult =
        actualOperationStackHolder.isManyToOneRelationshipDelete();
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
   *
   * <ul>
   *   <li>When {@code Join Column}.
   *   <li>Then return not FromManyToOne.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathElement#PathElement(String, String, String)}
   *   <li>{@link PathElement#getIdField()}
   *   <li>{@link PathElement#getJoinColumn()}
   *   <li>{@link PathElement#getName()}
   *   <li>{@link PathElement#isFromManyToOne()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PathElement.<init>(String, String, String)",
    "void PathElement.<init>(String, String, String, boolean)",
    "String PathElement.getIdField()",
    "String PathElement.getJoinColumn()",
    "String PathElement.getName()",
    "boolean PathElement.isFromManyToOne()"
  })
  public void testPathElementGettersAndSetters_whenJoinColumn_thenReturnNotFromManyToOne() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Name", "Id Field", "Join Column");
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
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return FromManyToOne.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathElement#PathElement(String, String, String, boolean)}
   *   <li>{@link PathElement#getIdField()}
   *   <li>{@link PathElement#getJoinColumn()}
   *   <li>{@link PathElement#getName()}
   *   <li>{@link PathElement#isFromManyToOne()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PathElement.<init>(String, String, String)",
    "void PathElement.<init>(String, String, String, boolean)",
    "String PathElement.getIdField()",
    "String PathElement.getJoinColumn()",
    "String PathElement.getName()",
    "boolean PathElement.isFromManyToOne()"
  })
  public void testPathElementGettersAndSetters_whenTrue_thenReturnFromManyToOne() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Name", "Id Field", "Join Column", true);
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
