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
package org.broadleafcommerce.openadmin.server.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
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
  @Mock
  private AdminNavigationService adminNavigationService;

  @InjectMocks
  private PersistencePackageFactoryImpl persistencePackageFactoryImpl;

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());

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
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    ForeignKey foreignKey = new ForeignKey();
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{foreignKey});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
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
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    assertEquals("Security Ceiling Entity Classname",
        actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    ForeignKey[] additionalForeignKeys = actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertTrue(persistencePerspectiveItems.containsKey(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate2() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("/"));

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
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    ForeignKey foreignKey = new ForeignKey();
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{foreignKey});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
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
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    assertEquals("Security Ceiling Entity Classname",
        actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    ForeignKey[] additionalForeignKeys = actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertTrue(persistencePerspectiveItems.containsKey(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate3() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSection);

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
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    ForeignKey foreignKey = new ForeignKey();
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{foreignKey});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
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
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    assertEquals("Security Ceiling Entity Classname",
        actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    ForeignKey[] additionalForeignKeys = actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertTrue(persistencePerspectiveItems.containsKey(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate4() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSection);

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
    when(request.getSecurityCeilingEntityClassname()).thenReturn("");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
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
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertEquals("42", bottomCrumb.getOriginalSectionIdentifier());
    assertEquals("Ceiling Entity Classname", actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    assertEquals("Ceiling Entity Classname", actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    assertEquals("Ceiling Entity Classname", bottomCrumb.getSectionIdentifier());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return CeilingEntityFullyQualifiedClassname is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_given42_thenReturnCeilingEntityFullyQualifiedClassnameIs42() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSection);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getCeilingEntityClassname()).thenReturn("42");
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
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
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    assertEquals("42", actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    assertEquals(sectionCrumb, actualCreateResult.getBottomCrumb());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@link AdminNavigationService}.</li>
   *   <li>When map.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_givenAdminNavigationService_whenMap_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.create(PersistencePackageRequest.map()));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@link AdornedTargetList#AdornedTargetList()}.</li>
   *   <li>Then return PersistencePerspectiveItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_givenAdornedTargetList_thenReturnPersistencePerspectiveItemsSizeIsTwo() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSection);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    when(request.getAdornedList()).thenReturn(adornedTargetList);
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.ADORNED);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getAdornedList();
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
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertEquals(2, persistencePerspectiveItems.size());
    assertTrue(persistencePerspectiveItems.containsKey(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(adornedTargetList, persistencePerspectiveItems.get(PersistencePerspectiveItemType.ADORNEDTARGETLIST));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code /} is adorned.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_givenHashMapSlashIsAdorned_thenThrowIllegalArgumentException() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSection);

    HashMap<String, PersistencePackageRequest> stringPersistencePackageRequestMap = new HashMap<>();
    stringPersistencePackageRequestMap.put("/", PersistencePackageRequest.adorned());

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
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(stringPersistencePackageRequestMap);
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> persistencePackageFactoryImpl.create(request));
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
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then return CeilingEntityFullyQualifiedClassname is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_thenReturnCeilingEntityFullyQualifiedClassnameIsNull() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSection);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getCeilingEntityClassname()).thenReturn(null);
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    ForeignKey foreignKey = new ForeignKey();
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{foreignKey});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
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
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    assertEquals("Security Ceiling Entity Classname",
        actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    assertNull(actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertNull(bottomCrumb.getOriginalSectionIdentifier());
    assertNull(bottomCrumb.getSectionIdentifier());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    ForeignKey[] additionalForeignKeys = actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertTrue(persistencePerspectiveItems.containsKey(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then return PersistencePerspective AdditionalForeignKeys is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_thenReturnPersistencePerspectiveAdditionalForeignKeysIsNull() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSection);

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
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(null);
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(Type.STANDARD);
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
    verify(adminSection).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI(eq("/42"));
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertEquals("42", bottomCrumb.getOriginalSectionIdentifier());
    assertEquals("Ceiling Entity Classname", actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    assertEquals("Ceiling Entity Classname", bottomCrumb.getSectionIdentifier());
    assertNull(actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>When adorned addAdditionalForeignKey {@link ForeignKey#ForeignKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_whenAdornedAddAdditionalForeignKeyForeignKey() {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    request.addAdditionalForeignKey(new ForeignKey());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> persistencePackageFactoryImpl.create(request));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>When adorned.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_whenAdorned_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.create(PersistencePackageRequest.adorned()));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>When standard.</li>
   *   <li>Then return RequestingEntityName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistencePackage PersistencePackageFactoryImpl.create(PersistencePackageRequest)"})
  public void testCreate_whenStandard_thenReturnRequestingEntityNameIsNull() {
    // Arrange and Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(PersistencePackageRequest.standard());

    // Assert
    assertNull(actualCreateResult.getRequestingEntityName());
    assertNull(actualCreateResult.getSectionEntityField());
    assertNull(actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertNull(bottomCrumb.getSectionId());
    assertNull(actualCreateResult.getEntity());
    assertEquals(0, actualCreateResult.getCustomCriteria().length);
    assertEquals(0, actualCreateResult.getSectionCrumbs().length);
    PersistencePerspective persistencePerspective = actualCreateResult.getPersistencePerspective();
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertFalse(actualCreateResult.isAddOperationInspect());
    assertFalse(actualCreateResult.isTreeCollection());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertTrue(persistencePerspectiveItems.isEmpty());
    assertEquals(bottomCrumb, actualCreateResult.getTopCrumb());
    assertSame(persistencePerspectiveItems, persistencePerspective.getPersistencePerspectiveItems());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}.
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OperationTypes PersistencePackageFactoryImpl.getDefaultOperationTypes()"})
  public void testGetDefaultOperationTypes() {
    // Arrange and Act
    OperationTypes actualDefaultOperationTypes = persistencePackageFactoryImpl.getDefaultOperationTypes();

    // Assert
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getAddType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getFetchType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getInspectType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getUpdateType());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}.
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OperationTypes PersistencePackageFactoryImpl.getOperationTypes(OperationType)"})
  public void testGetOperationTypes() {
    // Arrange and Act
    OperationTypes actualOperationTypes = persistencePackageFactoryImpl
        .getOperationTypes(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    assertEquals(OperationType.BASIC, actualOperationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getUpdateType());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}.
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistencePackageFactoryImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistencePackageFactoryImpl.getClassNameForSection("Section Key"));
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}.
   * <ul>
   *   <li>Then calls {@link AdminSectionImpl#getCeilingEntity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PersistencePackageFactoryImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenCallsGetCeilingEntity() {
    // Arrange
    AdminSectionImpl adminSectionImpl = mock(AdminSectionImpl.class);
    when(adminSectionImpl.getCeilingEntity()).thenThrow(new RuntimeException("foo"));
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> persistencePackageFactoryImpl.getClassNameForSection("Section Key"));
    verify(adminSectionImpl).getCeilingEntity();
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
  }
}
