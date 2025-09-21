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
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ClassMetadata.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ClassMetadataDiffblueTest {
  @Autowired private ClassMetadata classMetadata;

  /**
   * Test {@link ClassMetadata#getPMap()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getPMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ClassMetadata.getPMap()"})
  public void testGetPMap_givenClassMetadata_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ClassMetadata().getPMap().isEmpty());
  }

  /**
   * Test {@link ClassMetadata#getPMap()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getPMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ClassMetadata.getPMap()"})
  public void testGetPMap_thenReturnSizeIsOne() {
    // Arrange
    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    classMetadata.setProperties(new Property[] {property});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Property> actualPMap = classMetadata.getPMap();

    // Assert
    assertEquals(1, actualPMap.size());
    assertSame(property, actualPMap.get(null));
  }

  /**
   * Test {@link ClassMetadata#getTabMetadataUsingTabKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getTabMetadataUsingTabKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getTabMetadataUsingTabKey(String)"})
  public void testGetTabMetadataUsingTabKey_thenReturnNull() {
    // Arrange
    classMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(classMetadata.getTabMetadataUsingTabKey("Tab Key"));
  }

  /**
   * Test {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupMetadata} {@link GroupMetadata#getGroupName()} return {@code Group
   *       Key}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getTabMetadataUsingGroupKey(String)"})
  public void testGetTabMetadataUsingGroupKey_givenGroupMetadataGetGroupNameReturnGroupKey() {
    // Arrange
    GroupMetadata groupMetadata = mock(GroupMetadata.class);
    when(groupMetadata.getGroupName()).thenReturn("Group Key");

    HashMap<String, GroupMetadata> stringGroupMetadataMap = new HashMap<>();
    stringGroupMetadataMap.put("foo", groupMetadata);

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(stringGroupMetadataMap);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    classMetadata.getTabMetadataUsingGroupKey("Group Key");

    // Assert
    verify(groupMetadata, atLeast(1)).getGroupName();
    verify(tabMetadata, atLeast(1)).getGroupMetadata();
  }

  /**
   * Test {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupMetadata} {@link GroupMetadata#getGroupName()} return {@code Group
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getTabMetadataUsingGroupKey(String)"})
  public void testGetTabMetadataUsingGroupKey_givenGroupMetadataGetGroupNameReturnGroupName() {
    // Arrange
    GroupMetadata groupMetadata = mock(GroupMetadata.class);
    when(groupMetadata.getGroupName()).thenReturn("Group Name");

    HashMap<String, GroupMetadata> stringGroupMetadataMap = new HashMap<>();
    stringGroupMetadataMap.put("foo", groupMetadata);

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(stringGroupMetadataMap);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    TabMetadata actualTabMetadataUsingGroupKey =
        classMetadata.getTabMetadataUsingGroupKey("Group Key");

    // Assert
    verify(groupMetadata, atLeast(1)).getGroupName();
    verify(tabMetadata, atLeast(1)).getGroupMetadata();
    assertNull(actualTabMetadataUsingGroupKey);
  }

  /**
   * Test {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link GroupMetadata} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getTabMetadataUsingGroupKey(String)"})
  public void testGetTabMetadataUsingGroupKey_givenHashMapFooIsGroupMetadata() {
    // Arrange
    HashMap<String, GroupMetadata> stringGroupMetadataMap = new HashMap<>();
    stringGroupMetadataMap.put("foo", new GroupMetadata());

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(stringGroupMetadataMap);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    TabMetadata actualTabMetadataUsingGroupKey =
        classMetadata.getTabMetadataUsingGroupKey("Group Key");

    // Assert
    verify(tabMetadata, atLeast(1)).getGroupMetadata();
    assertNull(actualTabMetadataUsingGroupKey);
  }

  /**
   * Test {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link TabMetadata} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getTabMetadataUsingGroupKey(String)"})
  public void testGetTabMetadataUsingGroupKey_givenHashMapFooIsTabMetadata_thenReturnNull() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", new TabMetadata());

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertNull(classMetadata.getTabMetadataUsingGroupKey("Group Key"));
  }

  /**
   * Test {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}.
   *
   * <ul>
   *   <li>Then calls {@link TabMetadata#getGroupMetadata()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getTabMetadataUsingGroupKey(String)"})
  public void testGetTabMetadataUsingGroupKey_thenCallsGetGroupMetadata() {
    // Arrange
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    TabMetadata actualTabMetadataUsingGroupKey =
        classMetadata.getTabMetadataUsingGroupKey("Group Key");

    // Assert
    verify(tabMetadata, atLeast(1)).getGroupMetadata();
    assertNull(actualTabMetadataUsingGroupKey);
  }

  /**
   * Test {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getTabMetadataUsingGroupKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getTabMetadataUsingGroupKey(String)"})
  public void testGetTabMetadataUsingGroupKey_thenReturnNull() {
    // Arrange
    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(classMetadata.getTabMetadataUsingGroupKey("Group Key"));
  }

  /**
   * Test {@link ClassMetadata#getFirstTab()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getFirstTab()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getFirstTab()"})
  public void testGetFirstTab_givenClassMetadataCeilingTypeIsType_thenReturnNull() {
    // Arrange
    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(classMetadata.getFirstTab());
  }

  /**
   * Test {@link ClassMetadata#getFirstTab()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link TabMetadata} (default constructor).
   *   <li>Then return {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getFirstTab()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getFirstTab()"})
  public void testGetFirstTab_givenHashMap42IsTabMetadata_thenReturnTabMetadata() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    TabMetadata tabMetadata = new TabMetadata();
    tabAndGroupMetadata.put("42", tabMetadata);
    tabAndGroupMetadata.put("foo", new TabMetadata());

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertSame(tabMetadata, classMetadata.getFirstTab());
  }

  /**
   * Test {@link ClassMetadata#getFirstTab()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link TabMetadata} (default constructor).
   *   <li>Then return {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getFirstTab()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getFirstTab()"})
  public void testGetFirstTab_givenHashMapFooIsTabMetadata_thenReturnTabMetadata() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    TabMetadata tabMetadata = new TabMetadata();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertSame(tabMetadata, classMetadata.getFirstTab());
  }

  /**
   * Test {@link ClassMetadata#getFirstTab()}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor) TabOrder is one.
   *   <li>Then return {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getFirstTab()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getFirstTab()"})
  public void testGetFirstTab_givenTabMetadataTabOrderIsOne_thenReturnTabMetadata() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setTabOrder(1);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("42", new TabMetadata());
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertSame(tabMetadata, classMetadata.getFirstTab());
  }

  /**
   * Test {@link ClassMetadata#getFirstTab()}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor) TabOrder is one.
   *   <li>Then return {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getFirstTab()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getFirstTab()"})
  public void testGetFirstTab_givenTabMetadataTabOrderIsOne_thenReturnTabMetadata2() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setTabOrder(1);

    TabMetadata tabMetadata2 = new TabMetadata();
    tabMetadata2.setTabOrder(1);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("42", tabMetadata2);
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertSame(tabMetadata, classMetadata.getFirstTab());
  }

  /**
   * Test {@link ClassMetadata#getFirstTab()}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor) TabOrder is zero.
   *   <li>Then return {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getFirstTab()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TabMetadata ClassMetadata.getFirstTab()"})
  public void testGetFirstTab_givenTabMetadataTabOrderIsZero_thenReturnTabMetadata() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setTabOrder(1);

    TabMetadata tabMetadata2 = new TabMetadata();
    tabMetadata2.setTabOrder(0);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("42", tabMetadata2);
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertSame(tabMetadata2, classMetadata.getFirstTab());
  }

  /**
   * Test {@link ClassMetadata#getGroupOptionsFromTabAndGroupMetadata()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getGroupOptionsFromTabAndGroupMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[][] ClassMetadata.getGroupOptionsFromTabAndGroupMetadata()"})
  public void testGetGroupOptionsFromTabAndGroupMetadata_thenReturnArrayLengthIsZero() {
    // Arrange
    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(0, classMetadata.getGroupOptionsFromTabAndGroupMetadata().length);
  }

  /**
   * Test {@link ClassMetadata#getGroupOptionsFromTabAndGroupMetadata()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassMetadata#getGroupOptionsFromTabAndGroupMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[][] ClassMetadata.getGroupOptionsFromTabAndGroupMetadata()"})
  public void testGetGroupOptionsFromTabAndGroupMetadata_thenReturnArrayLengthIsZero2() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();
    tabMetadata.setGroupMetadata(new HashMap<>());

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[] {new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertEquals(0, classMetadata.getGroupOptionsFromTabAndGroupMetadata().length);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ClassMetadata}
   *   <li>{@link ClassMetadata#setCeilingType(String)}
   *   <li>{@link ClassMetadata#setCurrencyCode(String)}
   *   <li>{@link ClassMetadata#setPolymorphicEntities(ClassTree)}
   *   <li>{@link ClassMetadata#setProperties(Property[])}
   *   <li>{@link ClassMetadata#setSecurityCeilingType(String)}
   *   <li>{@link ClassMetadata#setTabAndGroupMetadata(Map)}
   *   <li>{@link ClassMetadata#getCeilingType()}
   *   <li>{@link ClassMetadata#getCurrencyCode()}
   *   <li>{@link ClassMetadata#getPolymorphicEntities()}
   *   <li>{@link ClassMetadata#getProperties()}
   *   <li>{@link ClassMetadata#getSecurityCeilingType()}
   *   <li>{@link ClassMetadata#getTabAndGroupMetadata()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClassMetadata.<init>()",
    "String ClassMetadata.getCeilingType()",
    "String ClassMetadata.getCurrencyCode()",
    "ClassTree ClassMetadata.getPolymorphicEntities()",
    "Property[] ClassMetadata.getProperties()",
    "String ClassMetadata.getSecurityCeilingType()",
    "Map ClassMetadata.getTabAndGroupMetadata()",
    "void ClassMetadata.setCeilingType(String)",
    "void ClassMetadata.setCurrencyCode(String)",
    "void ClassMetadata.setPolymorphicEntities(ClassTree)",
    "void ClassMetadata.setProperties(Property[])",
    "void ClassMetadata.setSecurityCeilingType(String)",
    "void ClassMetadata.setTabAndGroupMetadata(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ClassMetadata actualClassMetadata = new ClassMetadata();
    actualClassMetadata.setCeilingType("Type");
    actualClassMetadata.setCurrencyCode("GBP");
    ClassTree polymorphicEntities = new ClassTree();
    actualClassMetadata.setPolymorphicEntities(polymorphicEntities);
    Property[] properties = new Property[] {new Property()};
    actualClassMetadata.setProperties(properties);
    actualClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    actualClassMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);
    String actualCeilingType = actualClassMetadata.getCeilingType();
    String actualCurrencyCode = actualClassMetadata.getCurrencyCode();
    ClassTree actualPolymorphicEntities = actualClassMetadata.getPolymorphicEntities();
    Property[] actualProperties = actualClassMetadata.getProperties();
    String actualSecurityCeilingType = actualClassMetadata.getSecurityCeilingType();
    Map<String, TabMetadata> actualTabAndGroupMetadata =
        actualClassMetadata.getTabAndGroupMetadata();

    // Assert
    assertEquals("GBP", actualCurrencyCode);
    assertEquals("Security Ceiling Type", actualSecurityCeilingType);
    assertEquals("Type", actualCeilingType);
    assertTrue(actualTabAndGroupMetadata.isEmpty());
    assertSame(tabAndGroupMetadata, actualTabAndGroupMetadata);
    assertSame(polymorphicEntities, actualPolymorphicEntities);
    assertSame(properties, actualProperties);
  }
}
