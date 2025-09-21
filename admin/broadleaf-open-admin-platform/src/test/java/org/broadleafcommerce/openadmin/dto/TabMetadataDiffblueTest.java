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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class TabMetadataDiffblueTest {
  /**
   * Test {@link TabMetadata#getFirstGroup()}.
   *
   * <ul>
   *   <li>Given {@link GroupMetadata} (default constructor) GroupOrder is one.
   *   <li>Then return {@link GroupMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupMetadata TabMetadata.getFirstGroup()"})
  public void testGetFirstGroup_givenGroupMetadataGroupOrderIsOne_thenReturnGroupMetadata() {
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
   * Test {@link TabMetadata#getFirstGroup()}.
   *
   * <ul>
   *   <li>Given {@link GroupMetadata} (default constructor) GroupOrder is one.
   *   <li>Then return {@link GroupMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupMetadata TabMetadata.getFirstGroup()"})
  public void testGetFirstGroup_givenGroupMetadataGroupOrderIsOne_thenReturnGroupMetadata2() {
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
   * Test {@link TabMetadata#getFirstGroup()}.
   *
   * <ul>
   *   <li>Given {@link GroupMetadata} (default constructor) GroupOrder is zero.
   *   <li>Then return {@link GroupMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupMetadata TabMetadata.getFirstGroup()"})
  public void testGetFirstGroup_givenGroupMetadataGroupOrderIsZero_thenReturnGroupMetadata() {
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
   * Test {@link TabMetadata#getFirstGroup()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link GroupMetadata} (default
   *       constructor).
   *   <li>Then return {@link GroupMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupMetadata TabMetadata.getFirstGroup()"})
  public void testGetFirstGroup_givenHashMap42IsGroupMetadata_thenReturnGroupMetadata() {
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
   * Test {@link TabMetadata#getFirstGroup()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link GroupMetadata} (default
   *       constructor).
   *   <li>Then return {@link GroupMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupMetadata TabMetadata.getFirstGroup()"})
  public void testGetFirstGroup_givenHashMapFooIsGroupMetadata_thenReturnGroupMetadata() {
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
   * Test {@link TabMetadata#getFirstGroup()}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor) GroupMetadata is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#getFirstGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupMetadata TabMetadata.getFirstGroup()"})
  public void testGetFirstGroup_givenTabMetadataGroupMetadataIsHashMap_thenReturnNull() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(tabMetadata.getFirstGroup());
  }

  /**
   * Test {@link TabMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link TabMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata TabMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata() {
    // Arrange and Act
    TabMetadata actualCloneFieldMetadataResult = new TabMetadata().cloneFieldMetadata();

    // Assert
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getTabName());
    assertNull(actualCloneFieldMetadataResult.getGroupMetadata());
  }

  /**
   * Test {@link TabMetadata#accept(MetadataVisitor)}.
   *
   * <ul>
   *   <li>When {@link MetadataVisitorAdapter} {@link MetadataVisitorAdapter#visit(TabMetadata)}
   *       does nothing.
   *   <li>Then calls {@link MetadataVisitorAdapter#visit(TabMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#accept(MetadataVisitor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TabMetadata.accept(MetadataVisitor)"})
  public void testAccept_whenMetadataVisitorAdapterVisitDoesNothing_thenCallsVisit() {
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
   * Test {@link TabMetadata#equals(Object)}, and {@link TabMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TabMetadata#equals(Object)}
   *   <li>{@link TabMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TabMetadata.equals(Object)", "int TabMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertEquals(tabMetadata, tabMetadata);
    int expectedHashCodeResult = tabMetadata.hashCode();
    assertEquals(expectedHashCodeResult, tabMetadata.hashCode());
  }

  /**
   * Test {@link TabMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TabMetadata.equals(Object)", "int TabMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertNotEquals(tabMetadata, new TabMetadata());
  }

  /**
   * Test {@link TabMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TabMetadata.equals(Object)", "int TabMetadata.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TabMetadata(), null);
  }

  /**
   * Test {@link TabMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TabMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TabMetadata.equals(Object)", "int TabMetadata.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TabMetadata(), "Different type to TabMetadata");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TabMetadata.<init>()",
    "Map TabMetadata.getGroupMetadata()",
    "String TabMetadata.getOwningClass()",
    "String TabMetadata.getTabName()",
    "Integer TabMetadata.getTabOrder()",
    "void TabMetadata.setGroupMetadata(Map)",
    "void TabMetadata.setOwningClass(String)",
    "void TabMetadata.setTabName(String)",
    "void TabMetadata.setTabOrder(Integer)"
  })
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

    // Assert
    assertEquals("Owning Class", actualOwningClass);
    assertEquals("Tab Name", actualTabName);
    assertEquals(1, actualTabMetadata.getTabOrder().intValue());
    assertTrue(actualGroupMetadata.isEmpty());
    assertSame(groupMetadata, actualGroupMetadata);
  }
}
