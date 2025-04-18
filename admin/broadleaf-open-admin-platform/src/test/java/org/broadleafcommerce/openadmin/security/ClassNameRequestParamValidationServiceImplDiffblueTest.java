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
package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import org.broadleafcommerce.common.service.PersistenceService;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.exception.SectionKeyValidationException;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassNameRequestParamValidationServiceImplDiffblueTest {
  @Mock
  private AdminNavigationService adminNavigationService;

  @InjectMocks
  private ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl;

  @Mock
  private EntityManagerFactory entityManagerFactory;

  @Mock
  private PersistenceService persistenceService;

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"})
  public void testValidateClassNameParams() {
    // Arrange
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(true);

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "foo");

    // Act
    boolean actualValidateClassNameParamsResult = classNameRequestParamValidationServiceImpl
        .validateClassNameParams(requestParamToClassName, "Persistence Unit Name");

    // Assert
    verify(persistenceService).validateEntityClassName(eq("foo"));
    assertTrue(actualValidateClassNameParamsResult);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"})
  public void testValidateClassNameParams2() {
    // Arrange
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(false);

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "foo");

    // Act
    boolean actualValidateClassNameParamsResult = classNameRequestParamValidationServiceImpl
        .validateClassNameParams(requestParamToClassName, "Persistence Unit Name");

    // Assert
    verify(persistenceService).validateEntityClassName(eq("foo"));
    assertFalse(actualValidateClassNameParamsResult);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"})
  public void testValidateClassNameParams_givenEmptyString_whenHashMapFooIsEmptyString() {
    // Arrange
    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "");

    // Act and Assert
    assertTrue(classNameRequestParamValidationServiceImpl.validateClassNameParams(requestParamToClassName,
        "Persistence Unit Name"));
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <ul>
   *   <li>Given {@link PersistenceService}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"})
  public void testValidateClassNameParams_givenPersistenceService_whenHashMap_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        classNameRequestParamValidationServiceImpl.validateClassNameParams(new HashMap<>(), "Persistence Unit Name"));
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   * <ul>
   *   <li>Then throw {@link SectionKeyValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"})
  public void testValidateClassNameParams_thenThrowSectionKeyValidationException() {
    // Arrange
    when(persistenceService.validateEntityClassName(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "foo");

    // Act and Assert
    assertThrows(SectionKeyValidationException.class, () -> classNameRequestParamValidationServiceImpl
        .validateClassNameParams(requestParamToClassName, "Persistence Unit Name"));
    verify(persistenceService).validateEntityClassName(eq("foo"));
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any())).thenReturn("Section Key");
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key"));
    verify(persistenceService).validateEntityClassName(eq("Section Key"));
    verify(adminNavigationService).getClassNameForSection(eq("Section Key"));
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection2() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any())).thenReturn("Section Key");
    when(persistenceService.validateEntityClassName(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    // Act and Assert
    assertThrows(SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key"));
    verify(persistenceService).validateEntityClassName(eq("Section Key"));
    verify(adminNavigationService).getClassNameForSection(eq("Section Key"));
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   * <ul>
   *   <li>Then return {@code Class Name For Section}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnClassNameForSection() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any())).thenReturn("Class Name For Section");

    // Act
    String actualClassNameForSection = classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(adminNavigationService).getClassNameForSection(eq("Section Key"));
    assertEquals("Class Name For Section", actualClassNameForSection);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   * <ul>
   *   <li>Then return {@code Section Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnSectionKey() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any())).thenReturn("Section Key");
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualClassNameForSection = classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(persistenceService).validateEntityClassName(eq("Section Key"));
    verify(adminNavigationService).getClassNameForSection(eq("Section Key"));
    assertEquals("Section Key", actualClassNameForSection);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any())).thenReturn("Class Name For Section");
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);

    // Act
    List<SectionCrumb> actualSectionCrumbs = classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List");

    // Assert
    verify(adminNavigationService).getClassNameForSection(eq("42"));
    verify(adminNavigationService).getSectionCrumbs(eq("Crumb List"));
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   * <ul>
   *   <li>Given {@link PersistenceService} {@link PersistenceService#validateEntityClassName(String)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_givenPersistenceServiceValidateEntityClassNameReturnTrue() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any())).thenReturn("42");
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(true);

    // Act
    List<SectionCrumb> actualSectionCrumbs = classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List");

    // Assert
    verify(persistenceService).validateEntityClassName(eq("42"));
    verify(adminNavigationService).getClassNameForSection(eq("42"));
    verify(adminNavigationService).getSectionCrumbs(eq("Crumb List"));
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   * <ul>
   *   <li>Given {@link PersistenceService}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_givenPersistenceService_thenReturnEmpty() {
    // Arrange
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<SectionCrumb> actualSectionCrumbs = classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List");

    // Assert
    verify(adminNavigationService).getSectionCrumbs(eq("Crumb List"));
    assertTrue(actualSectionCrumbs.isEmpty());
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   * <ul>
   *   <li>Then throw {@link SectionKeyValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_thenThrowSectionKeyValidationException() {
    // Arrange
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn("42");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any())).thenReturn("42");
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List"));
    verify(persistenceService).validateEntityClassName(eq("42"));
    verify(sectionCrumb, atLeast(1)).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    verify(adminNavigationService).getClassNameForSection(eq("42"));
    verify(adminNavigationService).getSectionCrumbs(eq("Crumb List"));
  }
}
