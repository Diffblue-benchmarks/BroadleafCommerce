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
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class SandBoxImplDiffblueTest {
  /**
   * Method under test: {@link SandBoxImpl#getSandBoxType()}
   */
  @Test
  public void testGetSandBoxType() {
    // Arrange and Act
    SandBoxType actualSandBoxType = (new SandBoxImpl()).getSandBoxType();

    // Assert
    assertSame(actualSandBoxType.APPROVAL, actualSandBoxType);
  }

  /**
   * Method under test: {@link SandBoxImpl#getSandBoxType()}
   */
  @Test
  public void testGetSandBoxType2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));

    // Act
    SandBoxType actualSandBoxType = sandBoxImpl.getSandBoxType();

    // Assert
    assertSame(actualSandBoxType.APPROVAL, actualSandBoxType);
  }

  /**
   * Method under test: {@link SandBoxImpl#setSandBoxType(SandBoxType)}
   */
  @Test
  public void testSetSandBoxType() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    SandBoxType sandboxType = SandBoxType.APPROVAL;

    // Act
    sandBoxImpl.setSandBoxType(sandboxType);

    // Assert
    assertEquals("APPROVAL", sandBoxImpl.sandboxType);
    SandBoxType expectedSandBoxType = sandboxType.APPROVAL;
    assertSame(expectedSandBoxType, sandBoxImpl.getSandBoxType());
  }

  /**
   * Method under test: {@link SandBoxImpl#setSandBoxType(SandBoxType)}
   */
  @Test
  public void testSetSandBoxType2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  public void testGetColor() {
    // Arrange, Act and Assert
    assertNull((new SandBoxImpl()).getColor());
  }

  /**
   * Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  public void testGetColor2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);
    sandBoxImpl.setColor("foo");

    // Act and Assert
    assertEquals("foo", sandBoxImpl.getColor());
  }

  /**
   * Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  public void testGetColor3() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setColor(null);

    // Act and Assert
    assertNull(sandBoxImpl.getColor());
  }

  /**
   * Method under test: {@link SandBoxImpl#getColor()}
   */
  @Test
  public void testGetColor4() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);
    sandBoxImpl.setColor("foo");

    // Act and Assert
    assertEquals("foo", sandBoxImpl.getColor());
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy() {
    // Arrange and Act
    List<Long> actualSandBoxIdsForUpwardHierarchy = (new SandBoxImpl()).getSandBoxIdsForUpwardHierarchy(true);

    // Assert
    assertEquals(1, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);

    // Act
    List<Long> actualSandBoxIdsForUpwardHierarchy = sandBoxImpl.getSandBoxIdsForUpwardHierarchy(false);

    // Assert
    assertEquals(1, actualSandBoxIdsForUpwardHierarchy.size());
    assertEquals(1L, actualSandBoxIdsForUpwardHierarchy.get(0).longValue());
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy3() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act
    List<Long> actualSandBoxIdsForUpwardHierarchy = sandBoxImpl.getSandBoxIdsForUpwardHierarchy(true);

    // Assert
    assertEquals(2, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(1));
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy4() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);

    // Act
    List<Long> actualSandBoxIdsForUpwardHierarchy = sandBoxImpl.getSandBoxIdsForUpwardHierarchy(false);

    // Assert
    assertEquals(1, actualSandBoxIdsForUpwardHierarchy.size());
    assertEquals(1L, actualSandBoxIdsForUpwardHierarchy.get(0).longValue());
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy5() {
    // Arrange and Act
    List<Long> actualSandBoxIdsForUpwardHierarchy = (new SandBoxImpl()).getSandBoxIdsForUpwardHierarchy(true, true);

    // Assert
    assertEquals(1, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy6() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);

    // Act and Assert
    assertTrue(sandBoxImpl.getSandBoxIdsForUpwardHierarchy(false, false).isEmpty());
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy7() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act
    List<Long> actualSandBoxIdsForUpwardHierarchy = sandBoxImpl.getSandBoxIdsForUpwardHierarchy(true, true);

    // Assert
    assertEquals(2, actualSandBoxIdsForUpwardHierarchy.size());
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(0));
    assertNull(actualSandBoxIdsForUpwardHierarchy.get(1));
  }

  /**
   * Method under test:
   * {@link SandBoxImpl#getSandBoxIdsForUpwardHierarchy(boolean, boolean)}
   */
  @Test
  public void testGetSandBoxIdsForUpwardHierarchy8() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);
    sandBoxImpl.setParentSandBox(null);

    // Act and Assert
    assertTrue(sandBoxImpl.getSandBoxIdsForUpwardHierarchy(false, false).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxImpl#equals(Object)}
   *   <li>{@link SandBoxImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxImpl2.setAuthor(1L);
    sandBoxImpl2.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl2.setColor("Color");
    sandBoxImpl2.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl2.setId(1L);
    sandBoxImpl2.setName("Name");
    sandBoxImpl2.setParentSandBox(new SandBoxImpl());
    sandBoxImpl2.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertEquals(sandBoxImpl, sandBoxImpl2);
    int expectedHashCodeResult = sandBoxImpl.hashCode();
    assertEquals(expectedHashCodeResult, sandBoxImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxImpl#equals(Object)}
   *   <li>{@link SandBoxImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(mock(SandBox.class));
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxImpl2.setAuthor(1L);
    sandBoxImpl2.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl2.setColor("Color");
    sandBoxImpl2.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl2.setId(1L);
    sandBoxImpl2.setName("Name");
    sandBoxImpl2.setParentSandBox(new SandBoxImpl());
    sandBoxImpl2.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertEquals(sandBoxImpl, sandBoxImpl2);
    int expectedHashCodeResult = sandBoxImpl.hashCode();
    assertEquals(expectedHashCodeResult, sandBoxImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxImpl#equals(Object)}
   *   <li>{@link SandBoxImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Method under test: {@link SandBoxImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new SandBoxImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link SandBoxImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));

    // Act and Assert
    assertNull(sandBoxImpl.getMainEntityName());
  }

  /**
   * Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  public void testGetIsInDefaultHierarchy() {
    // Arrange, Act and Assert
    assertFalse((new SandBoxImpl()).getIsInDefaultHierarchy());
  }

  /**
   * Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  public void testGetIsInDefaultHierarchy2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setParentSandBox(new SandBoxImpl());

    // Act and Assert
    assertFalse(sandBoxImpl.getIsInDefaultHierarchy());
  }

  /**
   * Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  public void testGetIsInDefaultHierarchy3() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setSandBoxType(SandBoxType.DEFAULT);

    // Act and Assert
    assertTrue(sandBoxImpl.getIsInDefaultHierarchy());
  }

  /**
   * Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  public void testGetIsInDefaultHierarchy4() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setSandBoxType(new SandBoxType());

    // Act and Assert
    assertFalse(sandBoxImpl.getIsInDefaultHierarchy());
  }

  /**
   * Method under test: {@link SandBoxImpl#getIsInDefaultHierarchy()}
   */
  @Test
  public void testGetIsInDefaultHierarchy5() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));

    // Act and Assert
    assertFalse(sandBoxImpl.getIsInDefaultHierarchy());
  }

  /**
   * Method under test: {@link SandBoxImpl#setArchived(Character)}
   */
  @Test
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
   * Method under test: {@link SandBoxImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));

    // Act
    sandBoxImpl.setArchived('A');

    // Assert
    assertEquals('A', sandBoxImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', sandBoxImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link SandBoxImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new SandBoxImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link SandBoxImpl#getArchived()}
   */
  @Test
  public void testGetArchived2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setGoLiveDate(mock(java.sql.Date.class));

    // Act and Assert
    assertEquals('N', sandBoxImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link SandBoxImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    // Arrange, Act and Assert
    assertTrue((new SandBoxImpl()).isActive());
  }

  /**
   * Method under test: {@link SandBoxImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setArchived('Y');

    // Act and Assert
    assertFalse(sandBoxImpl.isActive());
  }

  /**
   * Method under test: {@link SandBoxImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(0L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxImpl2.setAuthor(1L);
    sandBoxImpl2.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl2.setColor("Color");
    sandBoxImpl2.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl2.setId(1L);
    sandBoxImpl2.setName("Name");
    sandBoxImpl2.setParentSandBox(new SandBoxImpl());
    sandBoxImpl2.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertNotEquals(sandBoxImpl, sandBoxImpl2);
  }

  /**
   * Method under test: {@link SandBoxImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertNotEquals(sandBoxImpl, null);
  }

  /**
   * Method under test: {@link SandBoxImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxImpl.setAuthor(1L);
    sandBoxImpl.setChildSandBoxes(new ArrayList<>());
    sandBoxImpl.setColor("Color");
    sandBoxImpl.setGoLiveDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sandBoxImpl.setId(1L);
    sandBoxImpl.setName("Name");
    sandBoxImpl.setParentSandBox(new SandBoxImpl());
    sandBoxImpl.setSandBoxType(SandBoxType.APPROVAL);

    // Act and Assert
    assertNotEquals(sandBoxImpl, "Different type to SandBoxImpl");
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();

    // Act
    sandBoxImpl.setAuthor(1L);
    ArrayList<SandBox> childSandBoxes = new ArrayList<>();
    sandBoxImpl.setChildSandBoxes(childSandBoxes);
    sandBoxImpl.setColor("Color");
    Date goLiveDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1L, actualAuthor.longValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualChildSandBoxes.isEmpty());
    assertSame(childSandBoxes, actualChildSandBoxes);
    assertSame(parentSandBox, actualParentSandBox);
    assertSame(goLiveDate, actualGoLiveDate);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SandBoxImpl}
   */
  @Test
  public void testNewSandBoxImpl() {
    // Arrange and Act
    SandBoxImpl actualSandBoxImpl = new SandBoxImpl();

    // Assert
    SandBoxType sandBoxType = actualSandBoxImpl.getSandBoxType();
    assertEquals("APPROVAL", sandBoxType.getType());
    assertEquals("APPROVAL", actualSandBoxImpl.sandboxType);
    assertEquals("Approval", sandBoxType.getFriendlyType());
    assertEquals('N', actualSandBoxImpl.archiveStatus.getArchived().charValue());
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
    assertEquals(2, sandBoxType.getPriority().intValue());
    assertFalse(actualSandBoxImpl.getIsInDefaultHierarchy());
  }
}
