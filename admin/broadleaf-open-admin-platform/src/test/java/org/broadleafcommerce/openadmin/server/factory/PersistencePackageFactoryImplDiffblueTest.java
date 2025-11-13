package org.broadleafcommerce.openadmin.server.factory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest.Type;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersistencePackageFactoryImplDiffblueTest {
  @Mock private AdminNavigationService adminNavigationService;

  @InjectMocks private PersistencePackageFactoryImpl persistencePackageFactoryImpl;

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    PersistencePackageRequest request = new PersistencePackageRequest(Type.STANDARD);
    request.setForeignKey(new ForeignKey());
    request.setAdornedList(new AdornedTargetList());
    request.setMapStructure(new MapStructure());
    request.setOperationTypesOverride(new OperationTypes());
    request.setCeilingEntityClassname("");
    request.setSecurityCeilingEntityClassname("");
    request.setEntity(new Entity());

    // Act and Assert
    assertEquals(
        0,
        persistencePackageFactoryImpl
            .create(request)
            .getPersistencePerspective()
            .getAdditionalForeignKeys()
            .length);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate2() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    PersistencePackageRequest request = new PersistencePackageRequest(Type.STANDARD);
    request.setForeignKey(new ForeignKey());
    request.setAdornedList(new AdornedTargetList());
    request.setMapStructure(new MapStructure());
    request.setOperationTypesOverride(null);
    request.setCeilingEntityClassname("");
    request.setSecurityCeilingEntityClassname("");
    request.setEntity(new Entity());

    // Act and Assert
    assertEquals(
        0,
        persistencePackageFactoryImpl
            .create(request)
            .getPersistencePerspective()
            .getAdditionalForeignKeys()
            .length);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate3() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getSecurityCeilingEntityClassname())
        .thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getType()).thenReturn(Type.STANDARD);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request, atLeast(1)).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    assertEquals(
        "Ceiling Entity Classname", actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    assertEquals(
        "Ceiling Entity Classname", actualCreateResult.getBottomCrumb().getSectionIdentifier());
    assertEquals(
        "Security Ceiling Entity Classname",
        actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    assertEquals(
        1, actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys().length);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate4() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getType()).thenReturn(Type.STANDARD);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    verify(adminNavigationService).findAdminSectionByURI("/42");
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertEquals("", bottomCrumb.getSectionIdentifier());
    assertEquals("42", bottomCrumb.getOriginalSectionIdentifier());
    assertEquals(
        1, actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys().length);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Given {@link AdminSection} {@link AdminSection#getCeilingEntity()} return {@code Ceiling
   *       Entity}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_givenAdminSectionGetCeilingEntityReturnCeilingEntity() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getType()).thenReturn(Type.STANDARD);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI("/42");
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertEquals("", bottomCrumb.getSectionIdentifier());
    assertEquals("42", bottomCrumb.getOriginalSectionIdentifier());
    assertEquals(
        1, actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys().length);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Given {@link AdminSection} {@link AdminSection#getCeilingEntity()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_givenAdminSectionGetCeilingEntityThrowIllegalArgumentException() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenThrow(new IllegalArgumentException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getType()).thenReturn(Type.STANDARD);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI("/42");
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertEquals("", bottomCrumb.getSectionIdentifier());
    assertEquals("42", bottomCrumb.getOriginalSectionIdentifier());
    assertEquals(
        1, actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys().length);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code /} is adorned.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_givenHashMapSlashIsAdorned_thenThrowIllegalArgumentException() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    HashMap<String, PersistencePackageRequest> stringPersistencePackageRequestMap = new HashMap<>();
    stringPersistencePackageRequestMap.put("/", PersistencePackageRequest.adorned());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(stringPersistencePackageRequestMap);
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getMapStructure()).thenReturn(new MapStructure());
    when(request.getType()).thenReturn(Type.MAP);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> persistencePackageFactoryImpl.create(request));
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getMapStructure();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Given {@code STANDARD}.
   *   <li>Then return BottomCrumb SectionId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_givenStandard_thenReturnBottomCrumbSectionIdIs42() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getType()).thenReturn(Type.STANDARD);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertEquals("", bottomCrumb.getSectionIdentifier());
    assertEquals("42", bottomCrumb.getOriginalSectionIdentifier());
    assertEquals("42", bottomCrumb.getSectionId());
    assertEquals("Requesting Entity Name", actualCreateResult.getRequestingEntityName());
    assertEquals("Section Entity Field", actualCreateResult.getSectionEntityField());
    SectionCrumb[] sectionCrumbs = actualCreateResult.getSectionCrumbs();
    assertEquals(1, sectionCrumbs.length);
    assertTrue(actualCreateResult.isAddOperationInspect());
    assertTrue(actualCreateResult.isTreeCollection());
    assertSame(bottomCrumb, actualCreateResult.getTopCrumb());
    assertSame(bottomCrumb, sectionCrumbs[0]);
    assertArrayEquals(new String[] {"Custom Criteria"}, actualCreateResult.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return BottomCrumb is {@link SectionCrumb} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnBottomCrumbIsSectionCrumb() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getType()).thenReturn(Type.STANDARD);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI("/");
    assertEquals(
        1, actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys().length);
    assertEquals(sectionCrumb, actualCreateResult.getBottomCrumb());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return CeilingEntityFullyQualifiedClassname is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnCeilingEntityFullyQualifiedClassnameIsNull() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    PersistencePackageRequest request = new PersistencePackageRequest(Type.STANDARD);
    request.setForeignKey(new ForeignKey());
    request.setAdornedList(new AdornedTargetList());
    request.setMapStructure(new MapStructure());
    request.setOperationTypesOverride(new OperationTypes());
    request.setCeilingEntityClassname(null);
    request.setSecurityCeilingEntityClassname(null);
    request.setEntity(new Entity());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    assertNull(actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    assertNull(actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return Entity is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnEntityIsNull() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    PersistencePackageRequest request = new PersistencePackageRequest(Type.STANDARD);
    request.setForeignKey(new ForeignKey());
    request.setAdornedList(new AdornedTargetList());
    request.setMapStructure(new MapStructure());
    request.setOperationTypesOverride(new OperationTypes());
    request.setCeilingEntityClassname("");
    request.setSecurityCeilingEntityClassname("");
    request.setEntity(null);

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    assertNull(actualCreateResult.getEntity());
    assertEquals(
        0, actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys().length);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return PersistencePerspective AdditionalForeignKeys is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnPersistencePerspectiveAdditionalForeignKeysIsNull() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    MapStructure mapStructure = new MapStructure();
    when(request.getMapStructure()).thenReturn(mapStructure);
    when(request.getType()).thenReturn(Type.MAP);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(null);
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getMapStructure();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    assertNull(actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems =
        actualCreateResult.getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    assertTrue(persistencePerspectiveItems.containsKey(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(
        mapStructure, persistencePerspectiveItems.get(PersistencePerspectiveItemType.MAPSTRUCTURE));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return PersistencePerspectiveItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnPersistencePerspectiveItemsSizeIsOne() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    AdornedTargetList adornedList = new AdornedTargetList();
    request.setAdornedList(adornedList);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems =
        actualCreateResult.getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult =
        persistencePerspectiveItems.get(PersistencePerspectiveItemType.ADORNEDTARGETLIST);
    assertTrue(getResult instanceof AdornedTargetList);
    assertSame(adornedList, getResult);
    assertSame(
        persistencePerspectiveItems,
        actualCreateResult.getPersistencePerspective().getPersistencePerspectiveItems());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return PersistencePerspectiveItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnPersistencePerspectiveItemsSizeIsTwo() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    MapStructure mapStructure = new MapStructure();
    when(request.getMapStructure()).thenReturn(mapStructure);
    when(request.getType()).thenReturn(Type.MAP);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getMapStructure();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems =
        actualCreateResult.getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    assertTrue(persistencePerspectiveItems.containsKey(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(
        mapStructure, persistencePerspectiveItems.get(PersistencePerspectiveItemType.MAPSTRUCTURE));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return SubPackages {@code /} BottomCrumb SectionId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnSubPackagesSlashBottomCrumbSectionIdIs42() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest standardResult = PersistencePackageRequest.standard();
    standardResult.setSectionCrumbs(new SectionCrumb[] {sectionCrumb});

    HashMap<String, PersistencePackageRequest> stringPersistencePackageRequestMap = new HashMap<>();
    stringPersistencePackageRequestMap.put("/", standardResult);

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(stringPersistencePackageRequestMap);
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb2});
    when(request.getMapStructure()).thenReturn(new MapStructure());
    when(request.getType()).thenReturn(Type.MAP);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getMapStructure();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    Map<String, PersistencePackage> subPackages = actualCreateResult.getSubPackages();
    assertEquals(1, subPackages.size());
    PersistencePackage getResult = subPackages.get("/");
    SectionCrumb bottomCrumb = getResult.getBottomCrumb();
    assertEquals("42", bottomCrumb.getSectionId());
    SectionCrumb[] sectionCrumbs = getResult.getSectionCrumbs();
    assertEquals(1, sectionCrumbs.length);
    assertSame(bottomCrumb, getResult.getTopCrumb());
    assertSame(bottomCrumb, sectionCrumbs[0]);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return SubPackages {@code /} CeilingEntityFullyQualifiedClassname is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_thenReturnSubPackagesSlashCeilingEntityFullyQualifiedClassnameIsNull() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    HashMap<String, PersistencePackageRequest> stringPersistencePackageRequestMap = new HashMap<>();
    stringPersistencePackageRequestMap.put("/", PersistencePackageRequest.standard());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getCeilingEntityClassname()).thenReturn("");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(stringPersistencePackageRequestMap);
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(request.getMapStructure()).thenReturn(new MapStructure());
    when(request.getType()).thenReturn(Type.MAP);
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[] {new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getMapStructure();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    Map<String, PersistencePackage> subPackages = actualCreateResult.getSubPackages();
    assertEquals(1, subPackages.size());
    PersistencePackage getResult = subPackages.get("/");
    assertNull(getResult.getCeilingEntityFullyQualifiedClassname());
    assertNull(getResult.getCsrfToken());
    assertNull(getResult.getFetchTypeFullyQualifiedClassname());
    assertNull(getResult.getRequestingEntityName());
    assertNull(getResult.getSectionEntityField());
    assertNull(getResult.getSecurityCeilingEntityFullyQualifiedClassname());
    assertNull(getResult.getEntity());
    assertEquals(0, getResult.getCustomCriteria().length);
    assertEquals(0, getResult.getSectionCrumbs().length);
    assertFalse(getResult.isAddOperationInspect());
    assertFalse(getResult.isProcessedInternal());
    assertFalse(getResult.isTreeCollection());
    assertTrue(getResult.getDeferredOperations().isEmpty());
    assertTrue(getResult.getPersistencePerspectiveItems().isEmpty());
    assertTrue(getResult.getSubPackages().isEmpty());
    assertTrue(getResult.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>When adorned addAdditionalForeignKey {@link ForeignKey#ForeignKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_whenAdornedAddAdditionalForeignKeyForeignKey() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    request.addAdditionalForeignKey(new ForeignKey());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> persistencePackageFactoryImpl.create(request));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>When adorned.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_whenAdorned_thenThrowIllegalArgumentException() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.create(PersistencePackageRequest.adorned()));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>When map.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"
  })
  public void testCreate_whenMap_thenThrowIllegalArgumentException() {
    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl =
        new PersistencePackageFactoryImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.create(PersistencePackageRequest.map()));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}.
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationTypes PersistencePackageFactoryImpl.getDefaultOperationTypes()"})
  public void testGetDefaultOperationTypes() {
    // Arrange and Act
    OperationTypes actualDefaultOperationTypes =
        new PersistencePackageFactoryImpl().getDefaultOperationTypes();

    // Assert
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getAddType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getFetchType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getInspectType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getUpdateType());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}.
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OperationTypes PersistencePackageFactoryImpl.getOperationTypes(OperationType)"
  })
  public void testGetOperationTypes() {
    // Arrange and Act
    OperationTypes actualOperationTypes =
        new PersistencePackageFactoryImpl().getOperationTypes(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    assertEquals(OperationType.BASIC, actualOperationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getUpdateType());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}.
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistencePackageFactoryImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.getClassNameForSection("Section Key"));
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSection#getCeilingEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistencePackageFactoryImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenCallsGetCeilingEntity() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenThrow(new IllegalArgumentException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.getClassNameForSection("Section Key"));
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersistencePackageFactoryImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenThrowRuntimeException() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> persistencePackageFactoryImpl.getClassNameForSection("Section Key"));
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
  }
}
