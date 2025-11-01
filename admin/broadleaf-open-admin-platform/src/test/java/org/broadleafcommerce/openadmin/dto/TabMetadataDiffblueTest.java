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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class TabMetadataDiffblueTest {
  /**
   * Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  public void testGetFirstGroup() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(tabMetadata.getFirstGroup());
  }

  /**
   * Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  public void testGetFirstGroup2() {
    // Arrange
    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    GroupMetadata groupMetadata2 = new GroupMetadata();
    groupMetadata.put("foo", groupMetadata2);

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata);

    // Act and Assert
    assertSame(groupMetadata2, tabMetadata.getFirstGroup());
  }

  /**
   * Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  public void testGetFirstGroup3() {
    // Arrange
    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    GroupMetadata groupMetadata2 = new GroupMetadata();
    groupMetadata.put("42", groupMetadata2);
    groupMetadata.put("foo", new GroupMetadata());

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata);

    // Act and Assert
    assertSame(groupMetadata2, tabMetadata.getFirstGroup());
  }

  /**
   * Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  public void testGetFirstGroup4() {
    // Arrange
    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    groupMetadata.computeIfPresent("foo", mock(BiFunction.class));
    GroupMetadata groupMetadata2 = new GroupMetadata();
    groupMetadata.put("foo", groupMetadata2);

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata);

    // Act and Assert
    assertSame(groupMetadata2, tabMetadata.getFirstGroup());
  }

  /**
   * Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  public void testGetFirstGroup5() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();
    groupMetadata.setGroupOrder(1);

    HashMap<String, GroupMetadata> groupMetadata2 = new HashMap<>();
    groupMetadata2.put("42", new GroupMetadata());
    groupMetadata2.put("foo", groupMetadata);

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata2);

    // Act and Assert
    assertSame(groupMetadata, tabMetadata.getFirstGroup());
  }

  /**
   * Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  public void testGetFirstGroup6() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();
    groupMetadata.setGroupOrder(1);

    GroupMetadata groupMetadata2 = new GroupMetadata();
    groupMetadata2.setGroupOrder(1);

    HashMap<String, GroupMetadata> groupMetadata3 = new HashMap<>();
    groupMetadata3.put("42", groupMetadata2);
    groupMetadata3.put("foo", groupMetadata);

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata3);

    // Act and Assert
    assertSame(groupMetadata, tabMetadata.getFirstGroup());
  }

  /**
   * Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  public void testGetFirstGroup7() {
    // Arrange
    GroupMetadata groupMetadata = new GroupMetadata();
    groupMetadata.setGroupOrder(1);

    GroupMetadata groupMetadata2 = new GroupMetadata();
    groupMetadata2.setGroupOrder(0);

    HashMap<String, GroupMetadata> groupMetadata3 = new HashMap<>();
    groupMetadata3.put("42", groupMetadata2);
    groupMetadata3.put("foo", groupMetadata);

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata3);

    // Act and Assert
    assertSame(groupMetadata2, tabMetadata.getFirstGroup());
  }

  /**
   * Method under test: {@link TabMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata() {
    // Arrange and Act
    TabMetadata actualCloneFieldMetadataResult = (new TabMetadata()).cloneFieldMetadata();

    // Assert
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getTabName());
    assertNull(actualCloneFieldMetadataResult.getGroupMetadata());
  }

  /**
   * Method under test: {@link TabMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata2() {
    // Arrange
    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    groupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata);

    // Act
    TabMetadata actualCloneFieldMetadataResult = tabMetadata.cloneFieldMetadata();

    // Assert
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getTabName());
    assertNull(actualCloneFieldMetadataResult.getFirstGroup());
    Map<String, GroupMetadata> groupMetadata2 = actualCloneFieldMetadataResult.getGroupMetadata();
    assertTrue(groupMetadata2.isEmpty());
    assertSame(groupMetadata, groupMetadata2);
  }

  /**
   * Method under test: {@link TabMetadata#accept(MetadataVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();
    MetadataVisitorAdapter visitor = mock(MetadataVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<TabMetadata>any());

    // Act
    tabMetadata.accept(visitor);

    // Assert
    verify(visitor).visit(isA(TabMetadata.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TabMetadata#equals(Object)}
   *   <li>{@link TabMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertEquals(tabMetadata, tabMetadata);
    int expectedHashCodeResult = tabMetadata.hashCode();
    assertEquals(expectedHashCodeResult, tabMetadata.hashCode());
  }

  /**
   * Method under test: {@link TabMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertNotEquals(tabMetadata, new TabMetadata());
  }

  /**
   * Method under test: {@link TabMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    groupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(groupMetadata);

    // Act and Assert
    assertNotEquals(tabMetadata, 1);
  }

  /**
   * Method under test: {@link TabMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TabMetadata(), null);
  }

  /**
   * Method under test: {@link TabMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TabMetadata(), "Different type to TabMetadata");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TabMetadata}
   *   <li>{@link TabMetadata#setGroupMetadata(Map)}
   *   <li>{@link TabMetadata#setOwningClass(String)}
   *   <li>{@link TabMetadata#setTabName(String)}
   *   <li>{@link TabMetadata#setTabOrder(Integer)}
   *   <li>{@link TabMetadata#getGroupMetadata()}
   *   <li>{@link TabMetadata#getOwningClass()}
   *   <li>{@link TabMetadata#getTabName()}
   *   <li>{@link TabMetadata#getTabOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TabMetadata actualTabMetadata = new TabMetadata();
    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    actualTabMetadata.setGroupMetadata(groupMetadata);
    actualTabMetadata.setOwningClass("Owning Class");
    actualTabMetadata.setTabName("Tab Name");
    actualTabMetadata.setTabOrder(1);
    Map<String, GroupMetadata> actualGroupMetadata = actualTabMetadata.getGroupMetadata();
    String actualOwningClass = actualTabMetadata.getOwningClass();
    String actualTabName = actualTabMetadata.getTabName();

    // Assert that nothing has changed
    assertEquals("Owning Class", actualOwningClass);
    assertEquals("Tab Name", actualTabName);
    assertEquals(1, actualTabMetadata.getTabOrder().intValue());
    assertTrue(actualGroupMetadata.isEmpty());
    assertSame(groupMetadata, actualGroupMetadata);
  }
}
