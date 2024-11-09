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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class GroupMetadataDiffblueTest {
  /**
   * Test {@link GroupMetadata#getUntitled()}.
   * <ul>
   *   <li>Given {@link GroupMetadata} (default constructor) Untitled is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#getUntitled()}
   */
  @Test
  public void testGetUntitled_givenGroupMetadataUntitledIsTrue_thenReturnTrue() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();
    groupMetadata.setUntitled(true);

    // Act and Assert
    assertTrue(groupMetadata.getUntitled());
  }

  /**
   * Test {@link GroupMetadata#getUntitled()}.
   * <ul>
   *   <li>Given {@link GroupMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#getUntitled()}
   */
  @Test
  public void testGetUntitled_givenGroupMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new GroupMetadata()).getUntitled());
  }

  /**
   * Test {@link GroupMetadata#getCollapsed()}.
   * <ul>
   *   <li>Given {@link GroupMetadata} (default constructor) Collapsed is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#getCollapsed()}
   */
  @Test
  public void testGetCollapsed_givenGroupMetadataCollapsedIsTrue_thenReturnTrue() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();
    groupMetadata.setCollapsed(true);

    // Act and Assert
    assertTrue(groupMetadata.getCollapsed());
  }

  /**
   * Test {@link GroupMetadata#getCollapsed()}.
   * <ul>
   *   <li>Given {@link GroupMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#getCollapsed()}
   */
  @Test
  public void testGetCollapsed_givenGroupMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new GroupMetadata()).getCollapsed());
  }

  /**
   * Test {@link GroupMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link GroupMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata() {
    // Arrange and Act
    GroupMetadata actualCloneFieldMetadataResult = (new GroupMetadata()).cloneFieldMetadata();

    // Assert
    assertNull(actualCloneFieldMetadataResult.collapsed);
    assertNull(actualCloneFieldMetadataResult.untitled);
    assertNull(actualCloneFieldMetadataResult.getColumn());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getGroupName());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getTooltip());
    assertFalse(actualCloneFieldMetadataResult.getCollapsed());
    assertFalse(actualCloneFieldMetadataResult.getUntitled());
  }

  /**
   * Test {@link GroupMetadata#accept(MetadataVisitor)}.
   * <ul>
   *   <li>When {@link MetadataVisitorAdapter}
   * {@link MetadataVisitorAdapter#visit(GroupMetadata)} does nothing.</li>
   *   <li>Then calls {@link MetadataVisitorAdapter#visit(GroupMetadata)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#accept(MetadataVisitor)}
   */
  @Test
  public void testAccept_whenMetadataVisitorAdapterVisitDoesNothing_thenCallsVisit() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();
    MetadataVisitorAdapter visitor = mock(MetadataVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<GroupMetadata>any());

    // Act
    groupMetadata.accept(visitor);

    // Assert
    verify(visitor).visit(isA(GroupMetadata.class));
  }

  /**
   * Test {@link GroupMetadata#equals(Object)}, and
   * {@link GroupMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GroupMetadata#equals(Object)}
   *   <li>{@link GroupMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();

    // Act and Assert
    assertEquals(groupMetadata, groupMetadata);
    int expectedHashCodeResult = groupMetadata.hashCode();
    assertEquals(expectedHashCodeResult, groupMetadata.hashCode());
  }

  /**
   * Test {@link GroupMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();

    // Act and Assert
    assertNotEquals(groupMetadata, new GroupMetadata());
  }

  /**
   * Test {@link GroupMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GroupMetadata(), null);
  }

  /**
   * Test {@link GroupMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GroupMetadata(), "Different type to GroupMetadata");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GroupMetadata}
   *   <li>{@link GroupMetadata#setCollapsed(Boolean)}
   *   <li>{@link GroupMetadata#setColumn(Integer)}
   *   <li>{@link GroupMetadata#setGroupName(String)}
   *   <li>{@link GroupMetadata#setGroupOrder(Integer)}
   *   <li>{@link GroupMetadata#setOwningClass(String)}
   *   <li>{@link GroupMetadata#setTooltip(String)}
   *   <li>{@link GroupMetadata#setUntitled(Boolean)}
   *   <li>{@link GroupMetadata#getColumn()}
   *   <li>{@link GroupMetadata#getGroupName()}
   *   <li>{@link GroupMetadata#getGroupOrder()}
   *   <li>{@link GroupMetadata#getOwningClass()}
   *   <li>{@link GroupMetadata#getTooltip()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GroupMetadata actualGroupMetadata = new GroupMetadata();
    actualGroupMetadata.setCollapsed(true);
    actualGroupMetadata.setColumn(1);
    actualGroupMetadata.setGroupName("Group Name");
    actualGroupMetadata.setGroupOrder(1);
    actualGroupMetadata.setOwningClass("Owning Class");
    actualGroupMetadata.setTooltip("127.0.0.1");
    actualGroupMetadata.setUntitled(true);
    Integer actualColumn = actualGroupMetadata.getColumn();
    String actualGroupName = actualGroupMetadata.getGroupName();
    Integer actualGroupOrder = actualGroupMetadata.getGroupOrder();
    String actualOwningClass = actualGroupMetadata.getOwningClass();
    actualGroupMetadata.getTooltip();

    // Assert that nothing has changed
    assertEquals("Group Name", actualGroupName);
    assertEquals("Owning Class", actualOwningClass);
    assertEquals(1, actualColumn.intValue());
    assertEquals(1, actualGroupOrder.intValue());
  }
}
