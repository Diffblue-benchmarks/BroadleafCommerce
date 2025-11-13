package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  @Mock private AdminNavigationService adminNavigationService;

  @InjectMocks
  private ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl;

  @Mock private PersistenceService persistenceService;

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"
  })
  public void testValidateClassNameParams() {
    // Arrange
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(false);

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "foo");

    // Act
    boolean actualValidateClassNameParamsResult =
        classNameRequestParamValidationServiceImpl.validateClassNameParams(
            requestParamToClassName, "Persistence Unit Name");

    // Assert
    verify(persistenceService).validateEntityClassName("foo");
    assertFalse(actualValidateClassNameParamsResult);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   *
   * <ul>
   *   <li>Given {@link ClassNameRequestParamValidationServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"
  })
  public void testValidateClassNameParams_givenClassNameRequestParamValidationServiceImpl() {
    // Arrange
    ClassNameRequestParamValidationServiceImpl classNameRequestParamValidationServiceImpl =
        new ClassNameRequestParamValidationServiceImpl();

    // Act and Assert
    assertFalse(
        classNameRequestParamValidationServiceImpl.validateClassNameParams(
            new HashMap<>(), "Persistence Unit Name"));
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link HashMap#HashMap()} empty string is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"
  })
  public void testValidateClassNameParams_givenEmptyString_whenHashMapEmptyStringIsEmptyString() {
    // Arrange
    when(persistenceService.validateEntityClassName(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("", "");
    requestParamToClassName.put("foo", "foo");

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () ->
            classNameRequestParamValidationServiceImpl.validateClassNameParams(
                requestParamToClassName, "Persistence Unit Name"));
    verify(persistenceService).validateEntityClassName("foo");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"
  })
  public void testValidateClassNameParams_thenReturnTrue() {
    // Arrange
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(true);

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "foo");

    // Act
    boolean actualValidateClassNameParamsResult =
        classNameRequestParamValidationServiceImpl.validateClassNameParams(
            requestParamToClassName, "Persistence Unit Name");

    // Assert
    verify(persistenceService).validateEntityClassName("foo");
    assertTrue(actualValidateClassNameParamsResult);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}.
   *
   * <ul>
   *   <li>Then throw {@link SectionKeyValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#validateClassNameParams(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ClassNameRequestParamValidationServiceImpl.validateClassNameParams(Map, String)"
  })
  public void testValidateClassNameParams_thenThrowSectionKeyValidationException() {
    // Arrange
    when(persistenceService.validateEntityClassName(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    HashMap<String, String> requestParamToClassName = new HashMap<>();
    requestParamToClassName.put("foo", "foo");

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () ->
            classNameRequestParamValidationServiceImpl.validateClassNameParams(
                requestParamToClassName, "Persistence Unit Name"));
    verify(persistenceService).validateEntityClassName("foo");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"
  })
  public void testGetClassNameForSection() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key"));
    verify(adminNavigationService).getClassNameForSection("Section Key");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"
  })
  public void testGetClassNameForSection2() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Section Key");
    when(persistenceService.validateEntityClassName(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key"));
    verify(persistenceService).validateEntityClassName("Section Key");
    verify(adminNavigationService).getClassNameForSection("Section Key");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"
  })
  public void testGetClassNameForSection3() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Section Key");
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key"));
    verify(persistenceService).validateEntityClassName("Section Key");
    verify(adminNavigationService).getClassNameForSection("Section Key");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   *
   * <ul>
   *   <li>Then return {@code Class Name For Section}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"
  })
  public void testGetClassNameForSection_thenReturnClassNameForSection() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");

    // Act
    String actualClassNameForSection =
        classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(adminNavigationService).getClassNameForSection("Section Key");
    assertEquals("Class Name For Section", actualClassNameForSection);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}.
   *
   * <ul>
   *   <li>Then return {@code Section Key}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ClassNameRequestParamValidationServiceImpl.getClassNameForSection(String)"
  })
  public void testGetClassNameForSection_thenReturnSectionKey() {
    // Arrange
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Section Key");
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualClassNameForSection =
        classNameRequestParamValidationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(persistenceService).validateEntityClassName("Section Key");
    verify(adminNavigationService).getClassNameForSection("Section Key");
    assertEquals("Section Key", actualClassNameForSection);
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs() {
    // Arrange
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List"));
    verify(adminNavigationService).getSectionCrumbs("Crumb List");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs2() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List"));
    verify(adminNavigationService).getClassNameForSection("42");
    verify(adminNavigationService).getSectionCrumbs("Crumb List");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs3() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Class Name For Section");
    sectionCrumb2.setSectionId("Class Name For Section");
    sectionCrumb2.setSectionIdentifier("Class Name For Section");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb2);
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);
    when(persistenceService.validateEntityClassName(Mockito.<String>any()))
        .thenThrow(new SectionKeyValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List"));
    verify(persistenceService).validateEntityClassName("Class Name For Section");
    verify(adminNavigationService).getClassNameForSection("Class Name For Section");
    verify(adminNavigationService).getSectionCrumbs("Crumb List");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>Given {@link PersistenceService} {@link
   *       PersistenceService#validateEntityClassName(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_givenPersistenceServiceValidateEntityClassNameReturnFalse() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Class Name For Section");
    sectionCrumb2.setSectionId("Class Name For Section");
    sectionCrumb2.setSectionIdentifier("Class Name For Section");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb2);
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        SectionKeyValidationException.class,
        () -> classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List"));
    verify(persistenceService).validateEntityClassName("Class Name For Section");
    verify(adminNavigationService).getClassNameForSection("Class Name For Section");
    verify(adminNavigationService).getSectionCrumbs("Crumb List");
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_thenReturnEmpty() {
    // Arrange
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List");

    // Assert
    verify(adminNavigationService).getSectionCrumbs("Crumb List");
    assertTrue(actualSectionCrumbs.isEmpty());
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_thenReturnSizeIsOne() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List");

    // Assert
    verify(adminNavigationService).getClassNameForSection("42");
    verify(adminNavigationService).getSectionCrumbs("Crumb List");
    assertEquals(1, actualSectionCrumbs.size());
    SectionCrumb getResult = actualSectionCrumbs.get(0);
    assertEquals("42", getResult.getOriginalSectionIdentifier());
    assertEquals("42", getResult.getSectionId());
    assertEquals("42", getResult.getSectionIdentifier());
  }

  /**
   * Test {@link ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassNameRequestParamValidationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassNameRequestParamValidationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_thenReturnSizeIsTwo() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Class Name For Section");
    sectionCrumb2.setSectionId("Class Name For Section");
    sectionCrumb2.setSectionIdentifier("Class Name For Section");

    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    sectionCrumbList.add(sectionCrumb2);
    sectionCrumbList.add(sectionCrumb);
    when(adminNavigationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(adminNavigationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);
    when(persistenceService.validateEntityClassName(Mockito.<String>any())).thenReturn(true);

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        classNameRequestParamValidationServiceImpl.getSectionCrumbs("Crumb List");

    // Assert
    verify(persistenceService).validateEntityClassName("Class Name For Section");
    verify(adminNavigationService, atLeast(1)).getClassNameForSection(Mockito.<String>any());
    verify(adminNavigationService).getSectionCrumbs("Crumb List");
    assertEquals(2, actualSectionCrumbs.size());
    SectionCrumb getResult = actualSectionCrumbs.get(0);
    assertEquals("Class Name For Section", getResult.getOriginalSectionIdentifier());
    assertEquals("Class Name For Section", getResult.getSectionId());
    assertEquals("Class Name For Section", getResult.getSectionIdentifier());
    assertSame(sectionCrumb, actualSectionCrumbs.get(1));
  }
}
