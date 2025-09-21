/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.sandbox.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SandBoxImplDiffblueTest {
  /**
   * Test {@link SandBoxImpl#getSandBoxType()}.
   *
   * <p>Method under test: {@link SandBoxImpl#getSandBoxType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBoxType SandBoxImpl.getSandBoxType()"})
  public void testGetSandBoxType() {
    // Arrange, Act and Assert
    assertSame(SandBoxType.APPROVAL, new SandBoxImpl().getSandBoxType());
  }

  /**
   * Test {@link SandBoxImpl#setSandBoxType(SandBoxType)}.
   *
   * <ul>
   *   <li>Then {@link SandBoxImpl} (default constructor) SandBoxType Type is {@code APPROVAL}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#setSandBoxType(SandBoxType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxImpl.setSandBoxType(SandBoxType)"})
  public void testSetSandBoxType_thenSandBoxImplSandBoxTypeTypeIsApproval() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    // Act
    sandBoxImpl.setSandBoxType(null);

    // Assert that nothing has changed
    SandBoxType sandBoxType = sandBoxImpl.getSandBoxType();
    assertEquals("APPROVAL", sandBoxType.getType());
    assertEquals("APPROVAL", sandBoxImpl.sandboxType);
    assertEquals("Approval", sandBoxType.getFriendlyType());
    assertEquals(2, sandBoxType.getPriority().intValue());
  }

  /**
   * Test {@link SandBoxImpl#setSandBoxType(SandBoxType)}.
   *
   * <ul>
   *   <li>When {@link SandBoxType#APPROVAL}.
   *   <li>Then {@link SandBoxImpl} (default constructor) {@link SandBoxImpl#sandboxType} is {@code
   *       APPROVAL}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#setSandBoxType(SandBoxType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxImpl.setSandBoxType(SandBoxType)"})
  public void testSetSandBoxType_whenApproval_thenSandBoxImplSandboxTypeIsApproval() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();

    // Act
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    // Assert that nothing has changed
    assertEquals("APPROVAL", sandBoxImpl.sandboxType);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxImpl#setAuthor(Long)}
   *   <li>{@link SandBoxImpl#setChildSandBoxes(List)}
   *   <li>{@link SandBoxImpl#setColor(String)}
   *   <li>{@link SandBoxImpl#setGoLiveDate(Date)}
   *   <li>{@link SandBoxImpl#setId(Long)}
   *   <li>{@link SandBoxImpl#setName(String)}
   *   <li>{@link SandBoxImpl#setParentSandBox(SandBox)}
   *   <li>{@link SandBoxImpl#getAuthor()}
   *   <li>{@link SandBoxImpl#getChildSandBoxes()}
   *   <li>{@link SandBoxImpl#getGoLiveDate()}
   *   <li>{@link SandBoxImpl#getId()}
   *   <li>{@link SandBoxImpl#getName()}
   *   <li>{@link SandBoxImpl#getParentSandBox()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SandBoxImpl.getAuthor()",
    "List SandBoxImpl.getChildSandBoxes()",
    "Date SandBoxImpl.getGoLiveDate()",
    "Long SandBoxImpl.getId()",
    "String SandBoxImpl.getName()",
    "SandBox SandBoxImpl.getParentSandBox()",
    "void SandBoxImpl.setAuthor(Long)",
    "void SandBoxImpl.setChildSandBoxes(List)",
    "void SandBoxImpl.setColor(String)",
    "void SandBoxImpl.setGoLiveDate(Date)",
    "void SandBoxImpl.setId(Long)",
    "void SandBoxImpl.setName(String)",
    "void SandBoxImpl.setParentSandBox(SandBox)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();

    // Act
    sandBoxImpl.setAuthor(1L);
    ArrayList<SandBox> childSandBoxes = new ArrayList<>();
    sandBoxImpl.setChildSandBoxes(childSandBoxes);
    sandBoxImpl.setColor("Color");
    Date goLiveDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    sandBoxImpl.setGoLiveDate(goLiveDate);
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    SandBoxImpl parentSandBox = new SandBoxImpl();
    sandBoxImpl.setParentSandBox(parentSandBox);
    Long actualAuthor = sandBoxImpl.getAuthor();
    List<SandBox> actualChildSandBoxes = sandBoxImpl.getChildSandBoxes();
    Date actualGoLiveDate = sandBoxImpl.getGoLiveDate();
    Long actualId = sandBoxImpl.getId();
    String actualName = sandBoxImpl.getName();
    SandBox actualParentSandBox = sandBoxImpl.getParentSandBox();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(1L, actualAuthor.longValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualChildSandBoxes.isEmpty());
    assertSame(childSandBoxes, actualChildSandBoxes);
    assertSame(parentSandBox, actualParentSandBox);
    assertSame(goLiveDate, actualGoLiveDate);
  }

  /**
   * Test {@link SandBoxImpl#getColor()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor) Color is {@code not blank}.
   *   <li>Then return {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxImpl.getColor()"})
  public void testGetColor_givenSandBoxImplColorIsNotBlank_thenReturnNotBlank() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setColor("not blank");
    sandBoxImpl.setParentSandBox(null);

    // Act and Assert
    assertEquals("not blank", sandBoxImpl.getColor());
  }

  /**
   * Test {@link SandBoxImpl#getColor()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor) Color is space.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxImpl.getColor()"})
  public void testGetColor_givenSandBoxImplColorIsSpace_thenReturnNull() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setColor(" ");
    sandBoxImpl.setParentSandBox(null);

    // Act and Assert
    assertNull(sandBoxImpl.getColor());
  }

  /**
   * Test {@link SandBoxImpl#getColor()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor) ParentSandBox is {@link SandBoxImpl}
   *       (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxImpl.getColor()"})
  public void testGetColor_givenSandBoxImplParentSandBoxIsSandBoxImpl_thenReturnNull() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setColor(" ");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act and Assert
    assertNull(sandBoxImpl.getColor());
  }

  /**
   * Test {@link SandBoxImpl#getColor()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxImpl.getColor()"})
  public void testGetColor_givenSandBoxImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SandBoxImpl().getColor());
  }

  /**
   * Test {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)} with {@code
   * includeInherited}.
   *
   * <p>Method under test: {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SandBoxImpl.getSandBoxIdsForUpwardHierarchy(boolean)"})
  public void testGetSandBoxIdsForUpwardHierarchyWithIncludeInherited() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);

    // Act
    List<Long> actualSandBoxIdsForUpwardHierarchy =
        sandBoxImpl.getSandBoxIdsForUpwardHierarchy(false);

    // Assert
    assertEquals(1, actualSandBoxIdsForUpwardHierarchy.size());
    assertEquals(1L, actualSandBoxIdsForUpwardHierarchy.get(0).longValue());
  }

  /**
   * Test {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)} with {@code
   * includeInherited}, {@code includeCurrent}.
   *
   * <p>Method under test: {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SandBoxImpl.getSandBoxIdsForUpwardHierarchy(boolean, boolean)"})
  public void testGetSandBoxIdsForUpwardHierarchyWithIncludeInheritedIncludeCurrent() {
    // Arrange and Act
    List<Long> actualSandBoxIdsForUpwardHierarchy =
        new SandBoxImpl().getSandBoxIdsForUpwardHierarchy(true, true);

    // Assert
    assertEquals(1, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
  }

  /**
   * Test {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)} with {@code
   * includeInherited}, {@code includeCurrent}.
   *
   * <p>Method under test: {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SandBoxImpl.getSandBoxIdsForUpwardHierarchy(boolean, boolean)"})
  public void testGetSandBoxIdsForUpwardHierarchyWithIncludeInheritedIncludeCurrent2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);

    // Act and Assert
    assertTrue(sandBoxImpl.getSandBoxIdsForUpwardHierarchy(false, false).isEmpty());
  }

  /**
   * Test {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)} with {@code
   * includeInherited}, {@code includeCurrent}.
   *
   * <p>Method under test: {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SandBoxImpl.getSandBoxIdsForUpwardHierarchy(boolean, boolean)"})
  public void testGetSandBoxIdsForUpwardHierarchyWithIncludeInheritedIncludeCurrent3() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act
    List<Long> actualSandBoxIdsForUpwardHierarchy =
        sandBoxImpl.getSandBoxIdsForUpwardHierarchy(true, true);

    // Assert
    assertEquals(2, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(1));
  }

  /**
   * Test {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)} with {@code
   * includeInherited}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SandBoxImpl.getSandBoxIdsForUpwardHierarchy(boolean)"})
  public void testGetSandBoxIdsForUpwardHierarchyWithIncludeInherited_givenSandBoxImpl() {
    // Arrange and Act
    List<Long> actualSandBoxIdsForUpwardHierarchy =
        new SandBoxImpl().getSandBoxIdsForUpwardHierarchy(true);

    // Assert
    assertEquals(1, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
  }

  /**
   * Test {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)} with {@code
   * includeInherited}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SandBoxImpl.getSandBoxIdsForUpwardHierarchy(boolean)"})
  public void testGetSandBoxIdsForUpwardHierarchyWithIncludeInherited_thenReturnSizeIsTwo() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act
    List<Long> actualSandBoxIdsForUpwardHierarchy =
        sandBoxImpl.getSandBoxIdsForUpwardHierarchy(true);

    // Assert
    assertEquals(2, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(1));
  }

  /**
   * Test {@link SandBoxImpl#equals(Object)}, and {@link SandBoxImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxImpl#equals(Object)}
   *   <li>{@link SandBoxImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.equals(Object)", "int SandBoxImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxImpl2.setAuthor(1L);
    sandBoxImpl2.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl2.setColor("Color");
    sandBoxImpl2.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl2.setId(1L);
    sandBoxImpl2.setName("Name");
    sandBoxImpl2.setParentSandBox(new SandBoxImpl());
    sandBoxImpl2.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertEquals(sandBoxImpl, sandBoxImpl2);
    assertEquals(sandBoxImpl.hashCode(), sandBoxImpl2.hashCode());
  }

  /**
   * Test {@link SandBoxImpl#equals(Object)}, and {@link SandBoxImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxImpl#equals(Object)}
   *   <li>{@link SandBoxImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.equals(Object)", "int SandBoxImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertEquals(sandBoxImpl, sandBoxImpl);
    int expectedHashCodeResult = sandBoxImpl.hashCode();
    assertEquals(expectedHashCodeResult, sandBoxImpl.hashCode());
  }

  /**
   * Test {@link SandBoxImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.equals(Object)", "int SandBoxImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(0L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxImpl2.setAuthor(1L);
    sandBoxImpl2.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl2.setColor("Color");
    sandBoxImpl2.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl2.setId(1L);
    sandBoxImpl2.setName("Name");
    sandBoxImpl2.setParentSandBox(new SandBoxImpl());
    sandBoxImpl2.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertNotEquals(sandBoxImpl, sandBoxImpl2);
  }

  /**
   * Test {@link SandBoxImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.equals(Object)", "int SandBoxImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertNotEquals(sandBoxImpl, null);
  }

  /**
   * Test {@link SandBoxImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.equals(Object)", "int SandBoxImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertNotEquals(sandBoxImpl, "Different type to SandBoxImpl");
  }

  /**
   * Test {@link SandBoxImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link SandBoxImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SandBoxImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(new SandBoxImpl().getMainEntityName());
  }

  /**
   * Test {@link SandBoxImpl#getIsInDefaultHierarchy()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor) SandBoxType is {@link
   *       SandBoxType#APPROVAL}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.getIsInDefaultHierarchy()"})
  public void testGetIsInDefaultHierarchy_givenSandBoxImplSandBoxTypeIsApproval() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act and Assert
    assertFalse(sandBoxImpl.getIsInDefaultHierarchy());
  }

  /**
   * Test {@link SandBoxImpl#getIsInDefaultHierarchy()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor) SandBoxType is {@link
   *       SandBoxType#DEFAULT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.getIsInDefaultHierarchy()"})
  public void testGetIsInDefaultHierarchy_givenSandBoxImplSandBoxTypeIsDefault_thenReturnTrue() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.DEFAULT);
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act and Assert
    assertTrue(sandBoxImpl.getIsInDefaultHierarchy());
  }

  /**
   * Test {@link SandBoxImpl#getIsInDefaultHierarchy()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor) SandBoxType is {@link
   *       SandBoxType#SandBoxType()}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.getIsInDefaultHierarchy()"})
  public void testGetIsInDefaultHierarchy_givenSandBoxImplSandBoxTypeIsSandBoxType() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(new SandBoxType());
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act and Assert
    assertFalse(sandBoxImpl.getIsInDefaultHierarchy());
  }

  /**
   * Test {@link SandBoxImpl#getIsInDefaultHierarchy()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.getIsInDefaultHierarchy()"})
  public void testGetIsInDefaultHierarchy_givenSandBoxImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SandBoxImpl().getIsInDefaultHierarchy());
  }

  /**
   * Test {@link SandBoxImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link SandBoxImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();

    // Act
    sandBoxImpl.setArchived('A');

    // Assert
    assertEquals('A', sandBoxImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', sandBoxImpl.getArchived().charValue());
  }

  /**
   * Test {@link SandBoxImpl#getArchived()}.
   *
   * <p>Method under test: {@link SandBoxImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character SandBoxImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', new SandBoxImpl().getArchived().charValue());
  }

  /**
   * Test {@link SandBoxImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor) Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.isActive()"})
  public void testIsActive_givenSandBoxImplArchivedIsY_thenReturnFalse() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setArchived('Y');

    // Act and Assert
    assertFalse(sandBoxImpl.isActive());
  }

  /**
   * Test {@link SandBoxImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link SandBoxImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SandBoxImpl.isActive()"})
  public void testIsActive_givenSandBoxImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SandBoxImpl().isActive());
  }

  /**
   * Test new {@link SandBoxImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SandBoxImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SandBoxImpl.<init>()"})
  public void testNewSandBoxImpl() {
    // Arrange and Act
    SandBoxImpl actualSandBoxImpl = new SandBoxImpl();

    // Assert
    assertEquals("APPROVAL", actualSandBoxImpl.sandboxType);
    assertEquals('N', actualSandBoxImpl.getArchived().charValue());
    assertNull(actualSandBoxImpl.getAuthor());
    assertNull(actualSandBoxImpl.getId());
    assertNull(actualSandBoxImpl.getColor());
    assertNull(actualSandBoxImpl.getMainEntityName());
    assertNull(actualSandBoxImpl.getName());
    assertNull(actualSandBoxImpl.color);
    assertNull(actualSandBoxImpl.description);
    assertNull(actualSandBoxImpl.getGoLiveDate());
    assertNull(actualSandBoxImpl.getChildSandBoxes());
    assertNull(actualSandBoxImpl.getParentSandBox());
    assertFalse(actualSandBoxImpl.getIsInDefaultHierarchy());
  }
}
