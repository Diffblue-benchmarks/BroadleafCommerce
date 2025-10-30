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
package org.broadleafcommerce.common.sandbox.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.sandbox.dao.SandBoxDao;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBoxType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SandBoxServiceImplDiffblueTest {
  @Mock
  private SandBoxDao sandBoxDao;

  @InjectMocks
  private SandBoxServiceImpl sandBoxServiceImpl;

  /**
   * Test {@link SandBoxServiceImpl#retrieveSandBoxById(Long)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveSandBoxById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.retrieveSandBoxById(Long)"})
  public void testRetrieveSandBoxById() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualRetrieveSandBoxByIdResult = sandBoxServiceImpl.retrieveSandBoxById(1L);

    // Assert
    verify(sandBoxDao).retrieve(eq(1L));
    assertSame(sandBoxImpl, actualRetrieveSandBoxByIdResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveAllSandBoxes()}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveAllSandBoxes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrieveAllSandBoxes()"})
  public void testRetrieveAllSandBoxes() {
    // Arrange
    when(sandBoxDao.retrieveAllSandBoxes()).thenReturn(new ArrayList<>());

    // Act
    List<SandBox> actualRetrieveAllSandBoxesResult = sandBoxServiceImpl.retrieveAllSandBoxes();

    // Assert
    verify(sandBoxDao).retrieveAllSandBoxes();
    assertTrue(actualRetrieveAllSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveSandBoxesByType(SandBoxType)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveSandBoxesByType(SandBoxType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrieveSandBoxesByType(SandBoxType)"})
  public void testRetrieveSandBoxesByType() {
    // Arrange
    when(sandBoxDao.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(new ArrayList<>());

    // Act
    List<SandBox> actualRetrieveSandBoxesByTypeResult = sandBoxServiceImpl
        .retrieveSandBoxesByType(SandBoxType.APPROVAL);

    // Assert
    verify(sandBoxDao).retrieveSandBoxesByType(isA(SandBoxType.class));
    assertTrue(actualRetrieveSandBoxesByTypeResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveUserSandBoxForParent(Long, Long)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveUserSandBoxForParent(Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.retrieveUserSandBoxForParent(Long, Long)"})
  public void testRetrieveUserSandBoxForParent() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieveUserSandBoxForParent(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualRetrieveUserSandBoxForParentResult = sandBoxServiceImpl.retrieveUserSandBoxForParent(1L, 1L);

    // Assert
    verify(sandBoxDao).retrieveUserSandBoxForParent(eq(1L), eq(1L));
    assertSame(sandBoxImpl, actualRetrieveUserSandBoxForParentResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveSandBoxManagementById(Long)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveSandBoxManagementById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.retrieveSandBoxManagementById(Long)"})
  public void testRetrieveSandBoxManagementById() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieveSandBoxManagementById(Mockito.<Long>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualRetrieveSandBoxManagementByIdResult = sandBoxServiceImpl.retrieveSandBoxManagementById(1L);

    // Assert
    verify(sandBoxDao).retrieveSandBoxManagementById(eq(1L));
    assertSame(sandBoxImpl, actualRetrieveSandBoxManagementByIdResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SandBoxImpl} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrievePreviewSandBoxes(Long)"})
  public void testRetrievePreviewSandBoxes_givenArrayListAddSandBoxImpl_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    sandBoxList.add(sandBoxImpl);
    when(sandBoxDao.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(sandBoxList);
    when(sandBoxDao.retrieveSandBoxesForAuthor(Mockito.<Long>any(), Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SandBox> actualRetrievePreviewSandBoxesResult = sandBoxServiceImpl.retrievePreviewSandBoxes(1L);

    // Assert
    verify(sandBoxDao, atLeast(1)).retrieveSandBoxesByType(Mockito.<SandBoxType>any());
    verify(sandBoxDao).retrieveSandBoxesForAuthor(eq(1L), isA(SandBoxType.class));
    assertEquals(2, actualRetrievePreviewSandBoxesResult.size());
    SandBox getResult = actualRetrievePreviewSandBoxesResult.get(0);
    assertSame(sandBoxImpl, getResult);
    assertSame(getResult, actualRetrievePreviewSandBoxesResult.get(1));
  }

  /**
   * Test {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}.
   * <ul>
   *   <li>Given {@link SandBoxImpl} {@link SandBoxImpl#getId()} return one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrievePreviewSandBoxes(Long)"})
  public void testRetrievePreviewSandBoxes_givenSandBoxImplGetIdReturnOne_thenReturnSizeIsOne() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    sandBoxList.add(sandBoxImpl);
    SandBoxImpl sandBoxImpl2 = mock(SandBoxImpl.class);
    when(sandBoxImpl2.getId()).thenReturn(1L);

    ArrayList<SandBox> sandBoxList2 = new ArrayList<>();
    sandBoxList2.add(sandBoxImpl2);
    when(sandBoxDao.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(sandBoxList);
    when(sandBoxDao.retrieveSandBoxesForAuthor(Mockito.<Long>any(), Mockito.<SandBoxType>any()))
        .thenReturn(sandBoxList2);

    // Act
    List<SandBox> actualRetrievePreviewSandBoxesResult = sandBoxServiceImpl.retrievePreviewSandBoxes(1L);

    // Assert
    verify(sandBoxDao, atLeast(1)).retrieveSandBoxesByType(Mockito.<SandBoxType>any());
    verify(sandBoxDao).retrieveSandBoxesForAuthor(eq(1L), isA(SandBoxType.class));
    verify(sandBoxImpl, atLeast(1)).getId();
    verify(sandBoxImpl2, atLeast(1)).getId();
    assertEquals(1, actualRetrievePreviewSandBoxesResult.size());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}.
   * <ul>
   *   <li>Given {@link SandBoxImpl} {@link SandBoxImpl#getId()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrievePreviewSandBoxes(Long)"})
  public void testRetrievePreviewSandBoxes_givenSandBoxImplGetIdReturnZero() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxList.add(sandBoxImpl2);
    sandBoxList.add(sandBoxImpl);
    SandBoxImpl sandBoxImpl3 = mock(SandBoxImpl.class);
    when(sandBoxImpl3.getId()).thenReturn(1L);
    SandBoxImpl sandBoxImpl4 = mock(SandBoxImpl.class);
    when(sandBoxImpl4.getId()).thenReturn(0L);
    when(sandBoxImpl4.getParentSandBox()).thenReturn(sandBoxImpl3);

    ArrayList<SandBox> sandBoxList2 = new ArrayList<>();
    sandBoxList2.add(sandBoxImpl4);
    when(sandBoxDao.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(sandBoxList);
    when(sandBoxDao.retrieveSandBoxesForAuthor(Mockito.<Long>any(), Mockito.<SandBoxType>any()))
        .thenReturn(sandBoxList2);

    // Act
    List<SandBox> actualRetrievePreviewSandBoxesResult = sandBoxServiceImpl.retrievePreviewSandBoxes(1L);

    // Assert
    verify(sandBoxDao, atLeast(1)).retrieveSandBoxesByType(Mockito.<SandBoxType>any());
    verify(sandBoxDao).retrieveSandBoxesForAuthor(eq(1L), isA(SandBoxType.class));
    verify(sandBoxImpl, atLeast(1)).getId();
    verify(sandBoxImpl4, atLeast(1)).getId();
    verify(sandBoxImpl3, atLeast(1)).getId();
    verify(sandBoxImpl4, atLeast(1)).getParentSandBox();
    assertEquals(3, actualRetrievePreviewSandBoxesResult.size());
    SandBox getResult = actualRetrievePreviewSandBoxesResult.get(1);
    assertTrue(getResult instanceof SandBoxImpl);
    assertEquals('N', getResult.getArchived().charValue());
    assertNull(getResult.getAuthor());
    assertNull(getResult.getId());
    assertNull(getResult.getColor());
    assertNull(getResult.getName());
    assertNull(((SandBoxImpl) getResult).getMainEntityName());
    assertNull(getResult.getGoLiveDate());
    assertNull(getResult.getChildSandBoxes());
    assertNull(getResult.getParentSandBox());
    assertFalse(getResult.getIsInDefaultHierarchy());
    assertSame(sandBoxImpl2, actualRetrievePreviewSandBoxesResult.get(2));
  }

  /**
   * Test {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}.
   * <ul>
   *   <li>Given {@link SandBoxImpl} {@link SandBoxImpl#getParentSandBox()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrievePreviewSandBoxes(Long)"})
  public void testRetrievePreviewSandBoxes_givenSandBoxImplGetParentSandBoxReturnNull() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxList.add(sandBoxImpl2);
    sandBoxList.add(sandBoxImpl);
    SandBoxImpl sandBoxImpl3 = mock(SandBoxImpl.class);
    when(sandBoxImpl3.getId()).thenReturn(1L);
    when(sandBoxImpl3.getParentSandBox()).thenReturn(null);

    ArrayList<SandBox> sandBoxList2 = new ArrayList<>();
    sandBoxList2.add(sandBoxImpl3);
    when(sandBoxDao.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(sandBoxList);
    when(sandBoxDao.retrieveSandBoxesForAuthor(Mockito.<Long>any(), Mockito.<SandBoxType>any()))
        .thenReturn(sandBoxList2);

    // Act
    List<SandBox> actualRetrievePreviewSandBoxesResult = sandBoxServiceImpl.retrievePreviewSandBoxes(1L);

    // Assert
    verify(sandBoxDao, atLeast(1)).retrieveSandBoxesByType(Mockito.<SandBoxType>any());
    verify(sandBoxDao).retrieveSandBoxesForAuthor(eq(1L), isA(SandBoxType.class));
    verify(sandBoxImpl, atLeast(1)).getId();
    verify(sandBoxImpl3, atLeast(1)).getId();
    verify(sandBoxImpl3, atLeast(1)).getParentSandBox();
    assertEquals(3, actualRetrievePreviewSandBoxesResult.size());
    SandBox getResult = actualRetrievePreviewSandBoxesResult.get(1);
    assertTrue(getResult instanceof SandBoxImpl);
    assertEquals('N', getResult.getArchived().charValue());
    assertNull(getResult.getAuthor());
    assertNull(getResult.getId());
    assertNull(getResult.getColor());
    assertNull(getResult.getName());
    assertNull(((SandBoxImpl) getResult).getMainEntityName());
    assertNull(getResult.getGoLiveDate());
    assertNull(getResult.getChildSandBoxes());
    assertNull(getResult.getParentSandBox());
    assertFalse(getResult.getIsInDefaultHierarchy());
    assertSame(sandBoxImpl2, actualRetrievePreviewSandBoxesResult.get(2));
  }

  /**
   * Test {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}.
   * <ul>
   *   <li>Given {@link SandBoxImpl} {@link SandBoxImpl#getParentSandBox()} return {@link SandBoxImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrievePreviewSandBoxes(Long)"})
  public void testRetrievePreviewSandBoxes_givenSandBoxImplGetParentSandBoxReturnSandBoxImpl() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    SandBoxImpl sandBoxImpl2 = new SandBoxImpl();
    sandBoxList.add(sandBoxImpl2);
    sandBoxList.add(sandBoxImpl);
    SandBoxImpl sandBoxImpl3 = mock(SandBoxImpl.class);
    when(sandBoxImpl3.getId()).thenReturn(1L);
    SandBoxImpl sandBoxImpl4 = mock(SandBoxImpl.class);
    when(sandBoxImpl4.getId()).thenReturn(1L);
    when(sandBoxImpl4.getParentSandBox()).thenReturn(sandBoxImpl3);

    ArrayList<SandBox> sandBoxList2 = new ArrayList<>();
    sandBoxList2.add(sandBoxImpl4);
    when(sandBoxDao.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(sandBoxList);
    when(sandBoxDao.retrieveSandBoxesForAuthor(Mockito.<Long>any(), Mockito.<SandBoxType>any()))
        .thenReturn(sandBoxList2);

    // Act
    List<SandBox> actualRetrievePreviewSandBoxesResult = sandBoxServiceImpl.retrievePreviewSandBoxes(1L);

    // Assert
    verify(sandBoxDao, atLeast(1)).retrieveSandBoxesByType(Mockito.<SandBoxType>any());
    verify(sandBoxDao).retrieveSandBoxesForAuthor(eq(1L), isA(SandBoxType.class));
    verify(sandBoxImpl, atLeast(1)).getId();
    verify(sandBoxImpl3, atLeast(1)).getId();
    verify(sandBoxImpl4, atLeast(1)).getId();
    verify(sandBoxImpl4, atLeast(1)).getParentSandBox();
    assertEquals(3, actualRetrievePreviewSandBoxesResult.size());
    SandBox getResult = actualRetrievePreviewSandBoxesResult.get(1);
    assertTrue(getResult instanceof SandBoxImpl);
    assertEquals('N', getResult.getArchived().charValue());
    assertNull(getResult.getAuthor());
    assertNull(getResult.getId());
    assertNull(getResult.getColor());
    assertNull(getResult.getName());
    assertNull(((SandBoxImpl) getResult).getMainEntityName());
    assertNull(getResult.getGoLiveDate());
    assertNull(getResult.getChildSandBoxes());
    assertNull(getResult.getParentSandBox());
    assertFalse(getResult.getIsInDefaultHierarchy());
    assertSame(sandBoxImpl2, actualRetrievePreviewSandBoxesResult.get(2));
  }

  /**
   * Test {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrievePreviewSandBoxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrievePreviewSandBoxes(Long)"})
  public void testRetrievePreviewSandBoxes_thenReturnEmpty() {
    // Arrange
    when(sandBoxDao.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(new ArrayList<>());
    when(sandBoxDao.retrieveSandBoxesForAuthor(Mockito.<Long>any(), Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SandBox> actualRetrievePreviewSandBoxesResult = sandBoxServiceImpl.retrievePreviewSandBoxes(1L);

    // Assert
    verify(sandBoxDao, atLeast(1)).retrieveSandBoxesByType(Mockito.<SandBoxType>any());
    verify(sandBoxDao).retrieveSandBoxesForAuthor(eq(1L), isA(SandBoxType.class));
    assertTrue(actualRetrievePreviewSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveUserSandBox(Long, Long, String)}.
   * <ul>
   *   <li>Given {@link SandBoxDao} {@link SandBoxDao#retrieveNamedSandBox(SandBoxType, String)} return {@link SandBoxImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveUserSandBox(Long, Long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.retrieveUserSandBox(Long, Long, String)"})
  public void testRetrieveUserSandBox_givenSandBoxDaoRetrieveNamedSandBoxReturnSandBoxImpl() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualRetrieveUserSandBoxResult = sandBoxServiceImpl.retrieveUserSandBox(1L, null, "Sand Box Name");

    // Assert
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), eq("Sand Box Name"));
    assertSame(sandBoxImpl, actualRetrieveUserSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveUserSandBox(Long, Long, String)}.
   * <ul>
   *   <li>Then calls {@link SandBoxDao#createSandBox(String, SandBoxType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveUserSandBox(Long, Long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.retrieveUserSandBox(Long, Long, String)"})
  public void testRetrieveUserSandBox_thenCallsCreateSandBox() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.createSandBox(Mockito.<String>any(), Mockito.<SandBoxType>any())).thenReturn(sandBoxImpl);
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    SandBox actualRetrieveUserSandBoxResult = sandBoxServiceImpl.retrieveUserSandBox(1L, null, "Sand Box Name");

    // Assert
    verify(sandBoxDao).createSandBox(eq("Sand Box Name"), isA(SandBoxType.class));
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), eq("Sand Box Name"));
    assertSame(sandBoxImpl, actualRetrieveUserSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveUserSandBox(Long, Long, String)}.
   * <ul>
   *   <li>Then calls {@link SandBoxDao#retrieve(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveUserSandBox(Long, Long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.retrieveUserSandBox(Long, Long, String)"})
  public void testRetrieveUserSandBox_thenCallsRetrieve() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualRetrieveUserSandBoxResult = sandBoxServiceImpl.retrieveUserSandBox(1L, 1L, "Sand Box Name");

    // Assert
    verify(sandBoxDao).retrieve(eq(1L));
    assertSame(sandBoxImpl, actualRetrieveUserSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveAuthorNamesForSandBoxes(Set)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link HashSet#HashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveAuthorNamesForSandBoxes(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SandBoxServiceImpl.retrieveAuthorNamesForSandBoxes(Set)"})
  public void testRetrieveAuthorNamesForSandBoxes_givenOne_whenHashSetAddOne() {
    // Arrange
    when(sandBoxDao.retrieveAuthorNamesForSandBoxes(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());

    HashSet<Long> sandBoxIds = new HashSet<>();
    sandBoxIds.add(1L);

    // Act
    Map<Long, String> actualRetrieveAuthorNamesForSandBoxesResult = sandBoxServiceImpl
        .retrieveAuthorNamesForSandBoxes(sandBoxIds);

    // Assert
    verify(sandBoxDao).retrieveAuthorNamesForSandBoxes(isA(Set.class));
    assertTrue(actualRetrieveAuthorNamesForSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveAuthorNamesForSandBoxes(Set)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashSet#HashSet()} add zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveAuthorNamesForSandBoxes(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SandBoxServiceImpl.retrieveAuthorNamesForSandBoxes(Set)"})
  public void testRetrieveAuthorNamesForSandBoxes_givenZero_whenHashSetAddZero() {
    // Arrange
    when(sandBoxDao.retrieveAuthorNamesForSandBoxes(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());

    HashSet<Long> sandBoxIds = new HashSet<>();
    sandBoxIds.add(0L);
    sandBoxIds.add(1L);

    // Act
    Map<Long, String> actualRetrieveAuthorNamesForSandBoxesResult = sandBoxServiceImpl
        .retrieveAuthorNamesForSandBoxes(sandBoxIds);

    // Assert
    verify(sandBoxDao).retrieveAuthorNamesForSandBoxes(isA(Set.class));
    assertTrue(actualRetrieveAuthorNamesForSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveAuthorNamesForSandBoxes(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveAuthorNamesForSandBoxes(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SandBoxServiceImpl.retrieveAuthorNamesForSandBoxes(Set)"})
  public void testRetrieveAuthorNamesForSandBoxes_whenHashSet() {
    // Arrange
    when(sandBoxDao.retrieveAuthorNamesForSandBoxes(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());

    // Act
    Map<Long, String> actualRetrieveAuthorNamesForSandBoxesResult = sandBoxServiceImpl
        .retrieveAuthorNamesForSandBoxes(new HashSet<>());

    // Assert
    verify(sandBoxDao).retrieveAuthorNamesForSandBoxes(isA(Set.class));
    assertTrue(actualRetrieveAuthorNamesForSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveSandboxNamesForSandBoxes(Set)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link HashSet#HashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveSandboxNamesForSandBoxes(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SandBoxServiceImpl.retrieveSandboxNamesForSandBoxes(Set)"})
  public void testRetrieveSandboxNamesForSandBoxes_givenOne_whenHashSetAddOne() {
    // Arrange
    when(sandBoxDao.retrieveSandboxNamesForSandBoxes(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());

    HashSet<Long> sandBoxIds = new HashSet<>();
    sandBoxIds.add(1L);

    // Act
    Map<Long, String> actualRetrieveSandboxNamesForSandBoxesResult = sandBoxServiceImpl
        .retrieveSandboxNamesForSandBoxes(sandBoxIds);

    // Assert
    verify(sandBoxDao).retrieveSandboxNamesForSandBoxes(isA(Set.class));
    assertTrue(actualRetrieveSandboxNamesForSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveSandboxNamesForSandBoxes(Set)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashSet#HashSet()} add zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveSandboxNamesForSandBoxes(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SandBoxServiceImpl.retrieveSandboxNamesForSandBoxes(Set)"})
  public void testRetrieveSandboxNamesForSandBoxes_givenZero_whenHashSetAddZero() {
    // Arrange
    when(sandBoxDao.retrieveSandboxNamesForSandBoxes(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());

    HashSet<Long> sandBoxIds = new HashSet<>();
    sandBoxIds.add(0L);
    sandBoxIds.add(1L);

    // Act
    Map<Long, String> actualRetrieveSandboxNamesForSandBoxesResult = sandBoxServiceImpl
        .retrieveSandboxNamesForSandBoxes(sandBoxIds);

    // Assert
    verify(sandBoxDao).retrieveSandboxNamesForSandBoxes(isA(Set.class));
    assertTrue(actualRetrieveSandboxNamesForSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveSandboxNamesForSandBoxes(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveSandboxNamesForSandBoxes(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SandBoxServiceImpl.retrieveSandboxNamesForSandBoxes(Set)"})
  public void testRetrieveSandboxNamesForSandBoxes_whenHashSet() {
    // Arrange
    when(sandBoxDao.retrieveSandboxNamesForSandBoxes(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());

    // Act
    Map<Long, String> actualRetrieveSandboxNamesForSandBoxesResult = sandBoxServiceImpl
        .retrieveSandboxNamesForSandBoxes(new HashSet<>());

    // Assert
    verify(sandBoxDao).retrieveSandboxNamesForSandBoxes(isA(Set.class));
    assertTrue(actualRetrieveSandboxNamesForSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#createSandBox(String, SandBoxType)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createSandBox(String, SandBoxType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.createSandBox(String, SandBoxType)"})
  public void testCreateSandBox() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.createSandBox(Mockito.<String>any(), Mockito.<SandBoxType>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualCreateSandBoxResult = sandBoxServiceImpl.createSandBox("Sand Box Name", SandBoxType.APPROVAL);

    // Assert
    verify(sandBoxDao).createSandBox(eq("Sand Box Name"), isA(SandBoxType.class));
    assertSame(sandBoxImpl, actualCreateSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#createUserSandBox(Long, SandBox)} with {@code authorId}, {@code approvalSandBox}.
   * <ul>
   *   <li>Then calls {@link SandBoxDao#createUserSandBox(Long, SandBox)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createUserSandBox(Long, SandBox)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.createUserSandBox(Long, SandBox)"})
  public void testCreateUserSandBoxWithAuthorIdApprovalSandBox_thenCallsCreateUserSandBox() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.createUserSandBox(Mockito.<Long>any(), Mockito.<SandBox>any())).thenReturn(sandBoxImpl);
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(null);

    // Act
    SandBox actualCreateUserSandBoxResult = sandBoxServiceImpl.createUserSandBox(1L, new SandBoxImpl());

    // Assert
    verify(sandBoxDao).createUserSandBox(eq(1L), isA(SandBox.class));
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), isNull(), eq(1L));
    assertSame(sandBoxImpl, actualCreateUserSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#createUserSandBox(Long, SandBox)} with {@code authorId}, {@code approvalSandBox}.
   * <ul>
   *   <li>Then return {@link SandBoxImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createUserSandBox(Long, SandBox)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.createUserSandBox(Long, SandBox)"})
  public void testCreateUserSandBoxWithAuthorIdApprovalSandBox_thenReturnSandBoxImpl() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(sandBoxImpl);

    // Act
    SandBox actualCreateUserSandBoxResult = sandBoxServiceImpl.createUserSandBox(1L, new SandBoxImpl());

    // Assert
    verify(sandBoxDao, atLeast(1)).retrieveNamedSandBox(isA(SandBoxType.class), isNull(), eq(1L));
    assertSame(sandBoxImpl, actualCreateUserSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#createUserSandBox(Long, Long)} with {@code authorId}, {@code approvalSandbox}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createUserSandBox(Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SandBoxServiceImpl.createUserSandBox(Long, Long)"})
  public void testCreateUserSandBoxWithAuthorIdApprovalSandbox_thenReturnLongValueIsOne() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(sandBoxImpl);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(new SandBoxImpl());

    // Act
    Long actualCreateUserSandBoxResult = sandBoxServiceImpl.createUserSandBox(1L, 42L);

    // Assert
    verify(sandBoxDao).retrieve(eq(42L));
    verify(sandBoxDao, atLeast(1)).retrieveNamedSandBox(isA(SandBoxType.class), isNull(), eq(1L));
    verify(sandBoxImpl).getId();
    assertEquals(1L, actualCreateUserSandBoxResult.longValue());
  }

  /**
   * Test {@link SandBoxServiceImpl#createUserSandBox(Long, Long)} with {@code authorId}, {@code approvalSandbox}.
   * <ul>
   *   <li>When four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createUserSandBox(Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SandBoxServiceImpl.createUserSandBox(Long, Long)"})
  public void testCreateUserSandBoxWithAuthorIdApprovalSandbox_whenFour() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(sandBoxImpl);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(new SandBoxImpl());

    // Act
    Long actualCreateUserSandBoxResult = sandBoxServiceImpl.createUserSandBox(4L, 42L);

    // Assert
    verify(sandBoxDao).retrieve(eq(42L));
    verify(sandBoxDao, atLeast(1)).retrieveNamedSandBox(isA(SandBoxType.class), isNull(), eq(4L));
    verify(sandBoxImpl).getId();
    assertEquals(1L, actualCreateUserSandBoxResult.longValue());
  }

  /**
   * Test {@link SandBoxServiceImpl#createUserSandBox(Long, Long)} with {@code authorId}, {@code approvalSandbox}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createUserSandBox(Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SandBoxServiceImpl.createUserSandBox(Long, Long)"})
  public void testCreateUserSandBoxWithAuthorIdApprovalSandbox_whenThree() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(sandBoxImpl);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(new SandBoxImpl());

    // Act
    Long actualCreateUserSandBoxResult = sandBoxServiceImpl.createUserSandBox(3L, 42L);

    // Assert
    verify(sandBoxDao).retrieve(eq(42L));
    verify(sandBoxDao, atLeast(1)).retrieveNamedSandBox(isA(SandBoxType.class), isNull(), eq(3L));
    verify(sandBoxImpl).getId();
    assertEquals(1L, actualCreateUserSandBoxResult.longValue());
  }

  /**
   * Test {@link SandBoxServiceImpl#createUserSandBox(Long, Long)} with {@code authorId}, {@code approvalSandbox}.
   * <ul>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createUserSandBox(Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SandBoxServiceImpl.createUserSandBox(Long, Long)"})
  public void testCreateUserSandBoxWithAuthorIdApprovalSandbox_whenTwo() {
    // Arrange
    SandBoxImpl sandBoxImpl = mock(SandBoxImpl.class);
    when(sandBoxImpl.getId()).thenReturn(1L);
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(sandBoxImpl);
    when(sandBoxDao.retrieve(Mockito.<Long>any())).thenReturn(new SandBoxImpl());

    // Act
    Long actualCreateUserSandBoxResult = sandBoxServiceImpl.createUserSandBox(2L, 42L);

    // Assert
    verify(sandBoxDao).retrieve(eq(42L));
    verify(sandBoxDao, atLeast(1)).retrieveNamedSandBox(isA(SandBoxType.class), isNull(), eq(2L));
    verify(sandBoxImpl).getId();
    assertEquals(1L, actualCreateUserSandBoxResult.longValue());
  }

  /**
   * Test {@link SandBoxServiceImpl#createDefaultSandBox()}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#createDefaultSandBox()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.createDefaultSandBox()"})
  public void testCreateDefaultSandBox() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.createDefaultSandBox()).thenReturn(sandBoxImpl);

    // Act
    SandBox actualCreateDefaultSandBoxResult = sandBoxServiceImpl.createDefaultSandBox();

    // Assert
    verify(sandBoxDao).createDefaultSandBox();
    assertSame(sandBoxImpl, actualCreateDefaultSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveSandBox(String, SandBoxType)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveSandBox(String, SandBoxType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox SandBoxServiceImpl.retrieveSandBox(String, SandBoxType)"})
  public void testRetrieveSandBox() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualRetrieveSandBoxResult = sandBoxServiceImpl.retrieveSandBox("Sand Box Name", SandBoxType.APPROVAL);

    // Assert
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), eq("Sand Box Name"));
    assertSame(sandBoxImpl, actualRetrieveSandBoxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveAllUserSandBoxes(Long)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveAllUserSandBoxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrieveAllUserSandBoxes(Long)"})
  public void testRetrieveAllUserSandBoxes() {
    // Arrange
    when(sandBoxDao.retrieveAllUserSandBoxes(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<SandBox> actualRetrieveAllUserSandBoxesResult = sandBoxServiceImpl.retrieveAllUserSandBoxes(1L);

    // Assert
    verify(sandBoxDao).retrieveAllUserSandBoxes(eq(1L));
    assertTrue(actualRetrieveAllUserSandBoxesResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#archiveChildSandboxes(Long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SandBoxImpl} (default constructor).</li>
   *   <li>Then calls {@link SandBoxDao#merge(SandBox)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#archiveChildSandboxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SandBoxServiceImpl.archiveChildSandboxes(Long)"})
  public void testArchiveChildSandboxes_givenArrayListAddSandBoxImpl_thenCallsMerge() {
    // Arrange
    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    sandBoxList.add(new SandBoxImpl());
    when(sandBoxDao.merge(Mockito.<SandBox>any())).thenReturn(new SandBoxImpl());
    when(sandBoxDao.retrieveChildSandBoxesByParentId(Mockito.<Long>any())).thenReturn(sandBoxList);

    // Act
    sandBoxServiceImpl.archiveChildSandboxes(1L);

    // Assert
    verify(sandBoxDao).merge(isA(SandBox.class));
    verify(sandBoxDao).retrieveChildSandBoxesByParentId(eq(1L));
  }

  /**
   * Test {@link SandBoxServiceImpl#archiveChildSandboxes(Long)}.
   * <ul>
   *   <li>Then calls {@link SandBoxDao#retrieveChildSandBoxesByParentId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#archiveChildSandboxes(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SandBoxServiceImpl.archiveChildSandboxes(Long)"})
  public void testArchiveChildSandboxes_thenCallsRetrieveChildSandBoxesByParentId() {
    // Arrange
    when(sandBoxDao.retrieveChildSandBoxesByParentId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    sandBoxServiceImpl.archiveChildSandboxes(1L);

    // Assert
    verify(sandBoxDao).retrieveChildSandBoxesByParentId(eq(1L));
  }

  /**
   * Test {@link SandBoxServiceImpl#retrieveChildSandBoxesByParentId(Long)}.
   * <p>
   * Method under test: {@link SandBoxServiceImpl#retrieveChildSandBoxesByParentId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SandBoxServiceImpl.retrieveChildSandBoxesByParentId(Long)"})
  public void testRetrieveChildSandBoxesByParentId() {
    // Arrange
    when(sandBoxDao.retrieveChildSandBoxesByParentId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<SandBox> actualRetrieveChildSandBoxesByParentIdResult = sandBoxServiceImpl
        .retrieveChildSandBoxesByParentId(1L);

    // Assert
    verify(sandBoxDao).retrieveChildSandBoxesByParentId(eq(1L));
    assertTrue(actualRetrieveChildSandBoxesByParentIdResult.isEmpty());
  }

  /**
   * Test {@link SandBoxServiceImpl#checkForExistingApprovalSandboxWithName(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#checkForExistingApprovalSandboxWithName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SandBoxServiceImpl.checkForExistingApprovalSandboxWithName(String)"})
  public void testCheckForExistingApprovalSandboxWithName_thenReturnFalse() {
    // Arrange
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(new SandBoxImpl());

    // Act
    boolean actualCheckForExistingApprovalSandboxWithNameResult = sandBoxServiceImpl
        .checkForExistingApprovalSandboxWithName("Sandbox Name");

    // Assert
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), eq("Sandbox Name"), isNull());
    assertFalse(actualCheckForExistingApprovalSandboxWithNameResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#checkForExistingApprovalSandboxWithName(String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#checkForExistingApprovalSandboxWithName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SandBoxServiceImpl.checkForExistingApprovalSandboxWithName(String)"})
  public void testCheckForExistingApprovalSandboxWithName_thenReturnTrue() {
    // Arrange
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(null);

    // Act
    boolean actualCheckForExistingApprovalSandboxWithNameResult = sandBoxServiceImpl
        .checkForExistingApprovalSandboxWithName("Sandbox Name");

    // Assert
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), eq("Sandbox Name"), isNull());
    assertTrue(actualCheckForExistingApprovalSandboxWithNameResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#checkForExistingSandbox(SandBoxType, String, Long)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#checkForExistingSandbox(SandBoxType, String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SandBoxServiceImpl.checkForExistingSandbox(SandBoxType, String, Long)"})
  public void testCheckForExistingSandbox_thenReturnFalse() {
    // Arrange
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(new SandBoxImpl());

    // Act
    boolean actualCheckForExistingSandboxResult = sandBoxServiceImpl.checkForExistingSandbox(SandBoxType.APPROVAL,
        "Sandbox Name", 1L);

    // Assert
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), eq("Sandbox Name"), eq(1L));
    assertFalse(actualCheckForExistingSandboxResult);
  }

  /**
   * Test {@link SandBoxServiceImpl#checkForExistingSandbox(SandBoxType, String, Long)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SandBoxServiceImpl#checkForExistingSandbox(SandBoxType, String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SandBoxServiceImpl.checkForExistingSandbox(SandBoxType, String, Long)"})
  public void testCheckForExistingSandbox_thenReturnTrue() {
    // Arrange
    when(sandBoxDao.retrieveNamedSandBox(Mockito.<SandBoxType>any(), Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(null);

    // Act
    boolean actualCheckForExistingSandboxResult = sandBoxServiceImpl.checkForExistingSandbox(SandBoxType.APPROVAL,
        "Sandbox Name", 1L);

    // Assert
    verify(sandBoxDao).retrieveNamedSandBox(isA(SandBoxType.class), eq("Sandbox Name"), eq(1L));
    assertTrue(actualCheckForExistingSandboxResult);
  }
}
