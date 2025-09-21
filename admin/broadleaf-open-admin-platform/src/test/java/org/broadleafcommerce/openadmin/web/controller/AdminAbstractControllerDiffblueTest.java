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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.Part;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.web.JsonResponse;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.SortDirection;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.FetchPageRequest;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest.Type;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.FieldGroup;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class AdminAbstractControllerDiffblueTest {
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock private AdminEntityService adminEntityService;

  @InjectMocks private AdminExportController adminExportController;

  @Mock private AdminNavigationService adminNavigationService;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private ExploitProtectionService exploitProtectionService;

  @Mock private FormBuilderService formBuilderService;

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code
   * sectionKey}, {@code sectionClassName}, {@code id}.
   *
   * <p>Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new ServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminExportController.getEntityForm("Section Key", "Section Class Name", "42"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code
   * sectionKey}, {@code sectionClassName}, {@code id}.
   *
   * <p>Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId2() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("structured-content/all");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("structured-content/all");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminExportController.getEntityForm("Section Key", "Section Class Name", "42"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code
   * sectionKey}, {@code sectionClassName}, {@code id}.
   *
   * <p>Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId3() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("structured-content/all");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("structured-content/all");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForAllSubCollections(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminExportController.getEntityForm("Section Key", "Section Class Name", "42"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminEntityService)
        .getRecordsForAllSubCollections(
            isA(PersistencePackageRequest.class), isA(Entity.class), isA(List.class));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code
   * sectionKey}, {@code sectionClassName}, {@code id}.
   *
   * <p>Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId4() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("structured-content/all");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("structured-content/all");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForAllSubCollections(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new HashMap<>());
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminExportController.getEntityForm("Section Key", "Section Class Name", "42"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminEntityService)
        .getRecordsForAllSubCollections(
            isA(PersistencePackageRequest.class), isA(Entity.class), isA(List.class));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    verify(formBuilderService)
        .createEntityForm(
            isA(ClassMetadata.class), isA(Entity.class), isA(Map.class), isA(List.class));
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code
   * sectionKey}, {@code sectionClassName}, {@code id}.
   *
   * <ul>
   *   <li>Then return {@link EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId_thenReturnEntityForm()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("structured-content/all");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("structured-content/all");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForAllSubCollections(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new HashMap<>());
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    // Act
    EntityForm actualEntityForm =
        adminExportController.getEntityForm("Section Key", "Section Class Name", "42");

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminEntityService)
        .getRecordsForAllSubCollections(
            isA(PersistencePackageRequest.class), isA(Entity.class), isA(List.class));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    verify(formBuilderService)
        .createEntityForm(
            isA(ClassMetadata.class), isA(Entity.class), isA(Map.class), isA(List.class));
    assertSame(entityForm, actualEntityForm);
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code
   * sectionKey}, {@code sectionClassName}, {@code id}.
   *
   * <ul>
   *   <li>Then return {@link EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId_thenReturnEntityForm2()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("structured-content/all");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("structured-content/all");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForAllSubCollections(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new HashMap<>());
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    // Act
    EntityForm actualEntityForm =
        adminExportController.getEntityForm("Section Key", "Section Class Name", "42");

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminEntityService)
        .getRecordsForAllSubCollections(
            isA(PersistencePackageRequest.class), isA(Entity.class), isA(List.class));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    verify(formBuilderService)
        .createEntityForm(
            isA(ClassMetadata.class), isA(Entity.class), isA(Map.class), isA(List.class));
    assertSame(entityForm, actualEntityForm);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity},
   * {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code
   * persistenceResponse}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            persistenceResponse,
            new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            isNull(), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity},
   * {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code
   * persistenceResponse}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs2()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminExportController.getCollectionListGrid(
                mainMetadata,
                entity,
                collectionProperty,
                requestParams,
                "Section Key",
                persistenceResponse,
                new ArrayList<>()));
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            isNull(), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity},
   * {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code
   * persistenceResponse}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs3()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            persistenceResponse,
            new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity},
   * {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code
   * persistenceResponse}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs4()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            null,
            new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity},
   * {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code
   * persistenceResponse}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs5()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("cloneId", null);
    stringObjectMap.put("cloneId", "Additional Data");

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getAdditionalData()).thenReturn(stringObjectMap);

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            persistenceResponse,
            new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity, atLeast(1)).findProperty("Id Property");
    verify(property).getValue();
    verify(property).setValue("Additional Data");
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(persistenceResponse, atLeast(1)).getAdditionalData();
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity},
   * {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code
   * persistenceResponse}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs6()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("cloneId", null);
    stringObjectMap.put("cloneId", "Additional Data");

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getAdditionalData()).thenReturn(stringObjectMap);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            persistenceResponse,
            sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity, atLeast(1)).findProperty("Id Property");
    verify(property).getValue();
    verify(property).setValue("Additional Data");
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(persistenceResponse, atLeast(1)).getAdditionalData();
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity},
   * {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code
   * persistenceResponse}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs7()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("cloneId", null);
    stringObjectMap.put("cloneId", "Additional Data");

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getAdditionalData()).thenReturn(stringObjectMap);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("cloneId");
    sectionCrumb2.setSectionId("cloneId");
    sectionCrumb2.setSectionIdentifier("cloneId");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            persistenceResponse,
            sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity, atLeast(1)).findProperty("Id Property");
    verify(property).getValue();
    verify(property).setValue("Additional Data");
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(persistenceResponse, atLeast(1)).getAdditionalData();
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            isNull(), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs2()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminExportController.getCollectionListGrid(
                mainMetadata,
                entity,
                collectionProperty,
                requestParams,
                "Section Key",
                new ArrayList<>()));
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            isNull(), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs3()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs4()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata, entity, collectionProperty, requestParams, "Section Key", sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs5()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("lastId");
    sectionCrumb2.setSectionId("lastId");
    sectionCrumb2.setSectionIdentifier("lastId");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata, entity, collectionProperty, requestParams, "Section Key", sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs6()
          throws ServiceException {
    // Arrange
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("sortDirection", "https://example.org/example");

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            new ArrayList<>());

    // Assert
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs7()
          throws ServiceException {
    // Arrange
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "%");

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            new ArrayList<>());

    // Assert
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs8()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenReturn(AdminAbstractController.FILTER_VALUE_SEPARATOR);
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs9()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("lastId", "42");
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata, entity, collectionProperty, requestParams, "Section Key", sectionCrumbs);

    // Assert
    verify(exploitProtectionService, atLeast(1)).cleanString(Mockito.<String>any());
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs10()
          throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.addAll("lastId", new ArrayList<>());
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata, entity, collectionProperty, requestParams, "Section Key", sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property,
   * MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code
   * collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata,
   * Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"
  })
  public void
      testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs11()
          throws ServiceException {
    // Arrange
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Property>any(),
            Mockito.<FilterAndSortCriteria[]>any(),
            Mockito.<FetchPageRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("startIndex", "42");

    // Act
    ListGrid actualCollectionListGrid =
        adminExportController.getCollectionListGrid(
            mainMetadata,
            entity,
            collectionProperty,
            requestParams,
            "Section Key",
            new ArrayList<>());

    // Assert
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService)
        .getPagedRecordsForCollection(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Property.class),
            isA(FilterAndSortCriteria[].class),
            isA(FetchPageRequest.class),
            isNull(),
            isA(List.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminExportController.getDynamicFieldTemplateForm(info, "42", new EntityForm()));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm2() throws ServiceException {
    // Arrange
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> adminExportController.getDynamicFieldTemplateForm(info, "42", new EntityForm()));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link EntityForm} (default constructor) DynamicForm {@code 42} is {@link
   *       EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_given42_whenEntityFormDynamicForm42IsEntityForm()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    EntityForm dynamicFormOverride = new EntityForm();
    dynamicFormOverride.putDynamicForm("42", new EntityForm());

    // Act
    EntityForm actualDynamicFieldTemplateForm =
        adminExportController.getDynamicFieldTemplateForm(info, "42", dynamicFormOverride);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
    assertSame(entityForm, actualDynamicFieldTemplateForm);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_givenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act
    EntityForm actualDynamicFieldTemplateForm =
        adminExportController.getDynamicFieldTemplateForm(info, "42", new EntityForm());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
    assertSame(entityForm, actualDynamicFieldTemplateForm);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Name is {@code Name}.
   *   <li>Then calls {@link Property#getMetadata()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_givenFieldNameIsName_thenCallsGetMetadata()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).addField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    Field field = new Field();
    field.setName("Name");

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", field);

    EntityForm dynamicFormOverride = mock(EntityForm.class);
    when(dynamicFormOverride.getFields()).thenReturn(stringFieldMap);
    doNothing().when(dynamicFormOverride).clearFieldsMap();

    // Act
    adminExportController.getDynamicFieldTemplateForm(info, "42", dynamicFormOverride);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(property).getMetadata();
    verify(property).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(entityForm).addField(isA(ClassMetadata.class), isA(Field.class));
    verify(entityForm).clearFieldsMap();
    verify(dynamicFormOverride).clearFieldsMap();
    verify(dynamicFormOverride).getFields();
    verify(entityForm).getTabs();
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link Property#Property()}.
   *   <li>Then calls {@link Entity#getPMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_givenHashMapFooIsProperty_thenCallsGetPMap()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {mock(Property.class)});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("foo", new Property());

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());

    EntityForm dynamicFormOverride = mock(EntityForm.class);
    when(dynamicFormOverride.getFields()).thenReturn(stringFieldMap);
    doNothing().when(dynamicFormOverride).clearFieldsMap();

    // Act
    adminExportController.getDynamicFieldTemplateForm(info, "42", dynamicFormOverride);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(entity, atLeast(1)).getPMap();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(entityForm).clearFieldsMap();
    verify(dynamicFormOverride).clearFieldsMap();
    verify(dynamicFormOverride).getFields();
    verify(entityForm).getTabs();
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link EntityForm#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_givenHashMap_thenCallsGetFields()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    EntityForm dynamicFormOverride = mock(EntityForm.class);
    when(dynamicFormOverride.getFields()).thenReturn(new HashMap<>());
    doNothing().when(dynamicFormOverride).clearFieldsMap();

    // Act
    adminExportController.getDynamicFieldTemplateForm(info, "42", dynamicFormOverride);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(entityForm).clearFieldsMap();
    verify(dynamicFormOverride).clearFieldsMap();
    verify(dynamicFormOverride).getFields();
    verify(entityForm).getTabs();
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_givenTabMetadata() throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    EntityForm dynamicFormOverride = new EntityForm();
    dynamicFormOverride.addTabFromTabMetadata(new TabMetadata());

    // Act
    EntityForm actualDynamicFieldTemplateForm =
        adminExportController.getDynamicFieldTemplateForm(info, "42", dynamicFormOverride);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
    assertSame(entityForm, actualDynamicFieldTemplateForm);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Then return {@link EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_thenReturnEntityForm() throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act
    EntityForm actualDynamicFieldTemplateForm =
        adminExportController.getDynamicFieldTemplateForm(info, "42", new EntityForm());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
    assertSame(entityForm, actualDynamicFieldTemplateForm);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_whenEntityForm_thenCallsClearFieldsMap()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act
    adminExportController.getDynamicFieldTemplateForm(info, "42", new EntityForm());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getTabs();
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String,
   * EntityForm)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"
  })
  public void testGetDynamicFieldTemplateForm_whenNull_thenReturnEntityForm()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    // Act
    EntityForm actualDynamicFieldTemplateForm =
        adminExportController.getDynamicFieldTemplateForm(new DynamicEntityFormInfo(), "42", null);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class), eq(true));
    verify(formBuilderService)
        .createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
    assertSame(entityForm, actualDynamicFieldTemplateForm);
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getOrder()} return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(field);

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field).getName();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName("null|Name");
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getOrder()} return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnOne2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(field);

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field).getName();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName("null|Name");
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getOrder()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnZero() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(0);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(field);

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field).getName();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName("null|Name");
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then calls {@link FieldGroup#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then calls {@link FieldGroup#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then calls {@link FieldGroup#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenFieldGroupAddListGridListGrid() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addListGrid(new ListGrid());
    fieldGroup2.addField(new Field());

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tab} (default constructor).
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenHashSetAddTab_thenCallsClearFieldsMap() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenHashSet_thenCallsClearFieldsMap() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link FieldGroup} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenLinkedHashSetAddFieldGroup() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(new FieldGroup());

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Field} (default constructor).
   *   <li>Then calls {@link FieldGroup#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_givenLinkedHashSetAddField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();
    fieldGroupSet.add(fieldGroup);

    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#getFriendlyName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"
  })
  public void testSetSpecializedNameForFields_thenCallsGetFriendlyName() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    EntityForm dynamicForm = mock(EntityForm.class);

    HashSet<Tab> tabSet = new HashSet<>();

    Tab tab = mock(Tab.class);

    LinkedHashSet<FieldGroup> fieldGroupSet = new LinkedHashSet<>();

    FieldGroup fieldGroup = new FieldGroup();

    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());
    fieldGroup.addField(field);

    CodeField field2 = mock(CodeField.class);
    when(field2.getFriendlyName()).thenReturn("Friendly Name");
    when(field2.getOrder()).thenReturn(1);
    when(field2.getAlternateOrdering()).thenReturn(true);
    when(field2.getName()).thenReturn("Name");
    doNothing().when(field2).setName(Mockito.<String>any());
    fieldGroup.addField(field2);
    fieldGroupSet.add(fieldGroup);

    FieldGroup fieldGroup2 = mock(FieldGroup.class);

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(new Field());
    when(fieldGroup2.getFields()).thenReturn(fieldSet);
    fieldGroupSet.add(fieldGroup2);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);
    tabSet.add(tab);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).getTabs();
    verify(dynamicForm).clearFieldsMap();
    verify(tab).getFieldGroups();
    verify(field).getAlternateOrdering();
    verify(field, atLeast(1)).getOrder();
    verify(field).getFriendlyName();
    verify(field, atLeast(1)).getName();
    verify(field).setName("null|Name");
    verify(field2).getAlternateOrdering();
    verify(field2, atLeast(1)).getOrder();
    verify(field2).getFriendlyName();
    verify(field2, atLeast(1)).getName();
    verify(field2).setName("null|Name");
    verify(fieldGroup2).getFields();
  }

  /**
   * Test {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link Field} (default constructor).
   *   <li>Then calls {@link EntityForm#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.extractDynamicFormFields(ClassMetadata, EntityForm)"
  })
  public void testExtractDynamicFormFields_givenHashMapFooIsField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    // Act
    adminExportController.extractDynamicFormFields(cmd, entityForm);

    // Assert
    verify(entityForm).getFields();
  }

  /**
   * Test {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityForm#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAbstractController.extractDynamicFormFields(ClassMetadata, EntityForm)"
  })
  public void testExtractDynamicFormFields_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    // Act
    adminExportController.extractDynamicFormFields(cmd, entityForm);

    // Assert
    verify(entityForm).getFields();
  }

  /**
   * Test {@link AdminAbstractController#getSectionKey(Map)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminAbstractController.getSectionKey(Map)"})
  public void testGetSectionKey() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return first element PropertyId is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenFoo_thenReturnFirstElementPropertyIdIsFoo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertEquals(1, actualCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return first element PropertyId is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenFoo_thenReturnFirstElementPropertyIdIsFoo2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("foo", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertEquals(1, actualCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code maxIndex}.
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenMaxIndex_whenHashMapMaxIndexIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code sortDirection}.
   *   <li>Then return first element PropertyId is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenSortDirection_thenReturnFirstElementPropertyIdIsFoo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortDirection", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertEquals(1, actualCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code sortProperty}.
   *   <li>Then return first element PropertyId is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenSortProperty_thenReturnFirstElementPropertyIdIsFoo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortProperty", new ArrayList<>());
    requestParams.put("sortDirection", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertEquals(1, actualCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code sortProperty}.
   *   <li>Then return second element SortAscending is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenSortProperty_thenReturnSecondElementSortAscendingIsNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("sortProperty");

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("sortProperty");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortProperty", stringList2);
    requestParams.put("sortDirection", stringList);
    requestParams.put("foo", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[1];
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertEquals(2, actualCriteria.length);
    FilterAndSortCriteria filterAndSortCriteria2 = actualCriteria[0];
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria2.getSortDirection());
    assertFalse(filterAndSortCriteria2.getSortAscending());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code startIndex}.
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenStartIndex_whenHashMapStartIndexIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Then return first element FilterValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_thenReturnFirstElementFilterValuesSizeIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("sortProperty");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("foo", stringList);

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    List<String> filterValues = filterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("sortProperty", filterValues.get(0));
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertEquals(1, actualCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Then return first element SortDirection is {@code ASCENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_thenReturnFirstElementSortDirectionIsAscending() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("ASCENDING");

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("sortProperty");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortProperty", stringList2);
    requestParams.put("sortDirection", stringList);
    requestParams.put("foo", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[1];
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertEquals(2, actualCriteria.length);
    FilterAndSortCriteria filterAndSortCriteria2 = actualCriteria[0];
    assertEquals(SortDirection.ASCENDING, filterAndSortCriteria2.getSortDirection());
    assertTrue(filterAndSortCriteria2.getSortAscending());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>Then return second element SortDirection is {@code DESCENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_thenReturnSecondElementSortDirectionIsDescending() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add("sortProperty");

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    stringList2.add("sortProperty");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortProperty", stringList2);
    requestParams.put("sortDirection", stringList);
    requestParams.put("foo", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    assertEquals(2, actualCriteria.length);
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria.getSortDirection());
    FilterAndSortCriteria filterAndSortCriteria2 = actualCriteria[1];
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria2.getSortDirection());
    assertFalse(filterAndSortCriteria.getSortAscending());
    assertFalse(filterAndSortCriteria2.getSortAscending());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_whenHashMap_thenReturnArrayLengthIsZero() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(new HashMap<>()).length);
  }

  /**
   * Test {@link AdminAbstractController#getSortDirections(Map)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSortDirections(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminAbstractController.getSortDirections(Map)"})
  public void testGetSortDirections() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortDirections(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getSortPropertyNames(Map)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSortPropertyNames(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminAbstractController.getSortPropertyNames(Map)"})
  public void testGetSortPropertyNames() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortPropertyNames(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getClassNameForSection(String)}.
   *
   * <ul>
   *   <li>Then return {@code Class Name For Section}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminAbstractController.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnClassNameForSection() {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");

    // Act
    String actualClassNameForSection = adminExportController.getClassNameForSection("Section Key");

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    assertEquals("Class Name For Section", actualClassNameForSection);
  }

  /**
   * Test {@link AdminAbstractController#getAddEntityTypes(ClassTree)}.
   *
   * <ul>
   *   <li>When {@link ClassTree#ClassTree()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getAddEntityTypes(ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminAbstractController.getAddEntityTypes(ClassTree)"})
  public void testGetAddEntityTypes_whenClassTree_thenReturnSizeIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    ClassTree classTree = new ClassTree();

    // Act
    List<ClassTree> actualAddEntityTypes = adminExportController.getAddEntityTypes(classTree);

    // Assert
    assertEquals(1, actualAddEntityTypes.size());
    assertSame(classTree, actualAddEntityTypes.get(0));
  }

  /**
   * Test {@link AdminAbstractController#getDefaultEntityType()}.
   *
   * <p>Method under test: {@link AdminAbstractController#getDefaultEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminAbstractController.getDefaultEntityType()"})
  public void testGetDefaultEntityType() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getDefaultEntityType());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCustomCriteria()}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCustomCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminAbstractController.getSectionCustomCriteria()"})
  public void testGetSectionCustomCriteria() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getSectionCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 1}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_givenArrayListAdd1_thenReturnIntValueIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", stringList);

    // Act and Assert
    assertEquals(1, adminExportController.getStartIndex(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_givenArrayList_whenHashMapStartIndexIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_givenNull_whenHashMapStartIndexIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", null);

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getStartIndex(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getStartIndex(null));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 1}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_givenArrayListAdd1_thenReturnIntValueIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", stringList);

    // Act and Assert
    assertEquals(1, adminExportController.getMaxIndex(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_givenArrayList_whenHashMapMaxIndexIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_givenNull_whenHashMapMaxIndexIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", null);

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getMaxIndex(null));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 1}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_givenArrayListAdd1_thenReturnIntValueIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", stringList);

    // Act and Assert
    assertEquals(1, adminExportController.getMaxResults(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code maxResults} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_givenArrayList_whenHashMapMaxResultsIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code maxResults} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_givenNull_whenHashMapMaxResultsIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", null);

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxResults(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getMaxResults(null));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getLastId(Map)"})
  public void testGetLastId_givenArrayListAdd42_thenReturnLongValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", stringList);

    // Act and Assert
    assertEquals(42L, adminExportController.getLastId(requestParams).longValue());
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code lastId} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getLastId(Map)"})
  public void testGetLastId_givenArrayList_whenHashMapLastIdIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code lastId} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getLastId(Map)"})
  public void testGetLastId_givenNull_whenHashMapLastIdIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", null);

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getLastId(Map)"})
  public void testGetLastId_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLastId(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getLastId(Map)"})
  public void testGetLastId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getLastId(null));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getFirstId(Map)"})
  public void testGetFirstId_givenArrayListAdd42_thenReturnLongValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", stringList);

    // Act and Assert
    assertEquals(42L, adminExportController.getFirstId(requestParams).longValue());
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code firstId} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getFirstId(Map)"})
  public void testGetFirstId_givenArrayList_whenHashMapFirstIdIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code firstId} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getFirstId(Map)"})
  public void testGetFirstId_givenNull_whenHashMapFirstIdIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", null);

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getFirstId(Map)"})
  public void testGetFirstId_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getFirstId(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getFirstId(Map)"})
  public void testGetFirstId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getFirstId(null));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 1}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_givenArrayListAdd1_thenReturnIntValueIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", stringList);

    // Act and Assert
    assertEquals(1, adminExportController.getUpperCount(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code upperCount} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_givenArrayList_whenHashMapUpperCountIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code upperCount} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_givenNull_whenHashMapUpperCountIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", null);

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getUpperCount(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getUpperCount(null));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 1}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_givenArrayListAdd1_thenReturnIntValueIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", stringList);

    // Act and Assert
    assertEquals(1, adminExportController.getLowerCount(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code lowerCount} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_givenArrayList_whenHashMapLowerCountIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code lowerCount} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_givenNull_whenHashMapLowerCountIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", null);

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLowerCount(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getLowerCount(null));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 1}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_givenArrayListAdd1_thenReturnIntValueIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("1");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", stringList);

    // Act and Assert
    assertEquals(1, adminExportController.getPageSize(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code pageSize} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_givenArrayList_whenHashMapPageSizeIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code pageSize} is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_givenNull_whenHashMapPageSizeIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", null);

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getPageSize(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminExportController().getPageSize(null));
  }

  /**
   * Test {@link AdminAbstractController#setModelAttributes(Model, String)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#setModelAttributes(Model, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminAbstractController.setModelAttributes(Model, String)"})
  public void testSetModelAttributes_thenConcurrentModelEmpty() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(null);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminExportController.setModelAttributes(model, "Section Key");

    // Assert that nothing has changed
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link AdminAbstractController#setModelAttributes(Model, String)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#setModelAttributes(Model, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminAbstractController.setModelAttributes(Model, String)"})
  public void testSetModelAttributes_thenConcurrentModelSizeIsTwo() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminExportController.setModelAttributes(model, "Section Key");

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    assertEquals(2, model.size());
    assertEquals("Section Key", model.get("sectionKey"));
    assertSame(
        adminSectionImpl, model.get(AdminAbstractController.CURRENT_ADMIN_SECTION_ATTRIBUTE_NAME));
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    HttpHeaders requestParams = new HttpHeaders();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertNull(actualSectionPersistencePackageRequest.getMaxIndex());
    assertNull(actualSectionPersistencePackageRequest.getStartIndex());
    assertArrayEquals(
        new String[] {"Merge Section Custom Criteria"},
        actualSectionPersistencePackageRequest.getCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    HttpHeaders requestParams = new HttpHeaders();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getCustomCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs3()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs4()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs5()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.addAll("sortProperty", new ArrayList<>());
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs6()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs7()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("sortProperty");
    sectionCrumb2.setSectionId("sortProperty");
    sectionCrumb2.setSectionIdentifier("sortProperty");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("sortProperty", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("sortProperty", sectionCrumb3.getSectionId());
    assertEquals("sortProperty", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs8()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("sortDirection", "sortProperty");
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs9() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "%");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("\\%", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs10()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenReturn(AdminAbstractController.FILTER_VALUE_SEPARATOR);

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs11() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("sortDirection", "sortProperty");
    requestParams.add("sortProperty", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria.length);
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria2.getSortDirection());
    assertFalse(filterAndSortCriteria2.getSortAscending());
    assertTrue(filterAndSortCriteria2.getFilterValues().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs12()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    requestParams.add("sortDirection", "sortProperty");
    requestParams.add("sortProperty", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertEquals(1, filterAndSortCriteria.length);
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria2.getSortDirection());
    assertFalse(filterAndSortCriteria2.getSortAscending());
    assertTrue(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs13() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("maxIndex", "42");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertEquals(42, actualSectionPersistencePackageRequest.getMaxIndex().intValue());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs14() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("startIndex", "42");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertEquals(42, actualSectionPersistencePackageRequest.getStartIndex().intValue());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    HttpHeaders requestParams = new HttpHeaders();
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertNull(actualSectionPersistencePackageRequest.getMaxIndex());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
    assertArrayEquals(
        new String[] {"Merge Section Custom Criteria"},
        actualSectionPersistencePackageRequest.getCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    HttpHeaders requestParams = new HttpHeaders();
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getCustomCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars3()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars4()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars5()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.addAll("sortProperty", new ArrayList<>());
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars6()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars7()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("sortProperty");
    sectionCrumb2.setSectionId("sortProperty");
    sectionCrumb2.setSectionIdentifier("sortProperty");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("sortProperty", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("sortProperty", sectionCrumb3.getSectionId());
    assertEquals("sortProperty", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars8()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("sortDirection", "sortProperty");
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars9() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "%");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("\\%", filterValues.get(0));
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertEquals(1, filterAndSortCriteria.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars10()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenReturn(AdminAbstractController.FILTER_VALUE_SEPARATOR);

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars11() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("sortDirection", "sortProperty");
    requestParams.add("sortProperty", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    assertEquals(1, filterAndSortCriteria.length);
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria2.getSortDirection());
    assertFalse(filterAndSortCriteria2.getSortAscending());
    assertTrue(filterAndSortCriteria2.getFilterValues().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars12()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    requestParams.add("sortDirection", "sortProperty");
    requestParams.add("sortProperty", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString("https://example.org/example");
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria =
        actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertEquals(1, filterAndSortCriteria.length);
    assertEquals(SortDirection.DESCENDING, filterAndSortCriteria2.getSortDirection());
    assertFalse(filterAndSortCriteria2.getSortAscending());
    assertTrue(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap,
   * List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code
   * pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"
  })
  public void
      testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars13() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("maxIndex", "42");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertEquals(42, actualSectionPersistencePackageRequest.getMaxIndex().intValue());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with
   * {@code sectionClassName}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(
        "Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals(
        "Section Class Name",
        actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
    assertNull(actualSectionPersistencePackageRequest.getPresentationFetch());
    assertNull(actualSectionPersistencePackageRequest.getLowerCount());
    assertNull(actualSectionPersistencePackageRequest.getMaxIndex());
    assertNull(actualSectionPersistencePackageRequest.getMaxResults());
    assertNull(actualSectionPersistencePackageRequest.getPageSize());
    assertNull(actualSectionPersistencePackageRequest.getStartIndex());
    assertNull(actualSectionPersistencePackageRequest.getUpperCount());
    assertNull(actualSectionPersistencePackageRequest.getFirstId());
    assertNull(actualSectionPersistencePackageRequest.getFolderId());
    assertNull(actualSectionPersistencePackageRequest.getLastId());
    assertNull(actualSectionPersistencePackageRequest.getConfigKey());
    assertNull(actualSectionPersistencePackageRequest.getMsg());
    assertNull(actualSectionPersistencePackageRequest.getRequestingEntityName());
    assertNull(actualSectionPersistencePackageRequest.getSectionEntityField());
    assertNull(actualSectionPersistencePackageRequest.getAdornedList());
    assertNull(actualSectionPersistencePackageRequest.getEntity());
    assertNull(actualSectionPersistencePackageRequest.getForeignKey());
    assertNull(actualSectionPersistencePackageRequest.getMapStructure());
    assertNull(actualSectionPersistencePackageRequest.getOperationTypesOverride());
    assertEquals(0, actualSectionPersistencePackageRequest.getAdditionalForeignKeys().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertEquals(1, actualSectionPersistencePackageRequest.getCustomCriteria().length);
    assertEquals(Type.STANDARD, actualSectionPersistencePackageRequest.getType());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
    assertFalse(actualSectionPersistencePackageRequest.isAddOperationInspect());
    assertFalse(actualSectionPersistencePackageRequest.isFolderedLookup());
    assertFalse(actualSectionPersistencePackageRequest.isTreeCollection());
    assertFalse(actualSectionPersistencePackageRequest.isUpdateLookupType());
    assertTrue(actualSectionPersistencePackageRequest.getSubRequests().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with
   * {@code sectionClassName}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(
        "Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals(
        "Section Class Name",
        actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
    assertNull(actualSectionPersistencePackageRequest.getPresentationFetch());
    assertNull(actualSectionPersistencePackageRequest.getLowerCount());
    assertNull(actualSectionPersistencePackageRequest.getMaxIndex());
    assertNull(actualSectionPersistencePackageRequest.getMaxResults());
    assertNull(actualSectionPersistencePackageRequest.getPageSize());
    assertNull(actualSectionPersistencePackageRequest.getStartIndex());
    assertNull(actualSectionPersistencePackageRequest.getUpperCount());
    assertNull(actualSectionPersistencePackageRequest.getFirstId());
    assertNull(actualSectionPersistencePackageRequest.getFolderId());
    assertNull(actualSectionPersistencePackageRequest.getLastId());
    assertNull(actualSectionPersistencePackageRequest.getConfigKey());
    assertNull(actualSectionPersistencePackageRequest.getMsg());
    assertNull(actualSectionPersistencePackageRequest.getRequestingEntityName());
    assertNull(actualSectionPersistencePackageRequest.getSectionEntityField());
    assertNull(actualSectionPersistencePackageRequest.getAdornedList());
    assertNull(actualSectionPersistencePackageRequest.getEntity());
    assertNull(actualSectionPersistencePackageRequest.getForeignKey());
    assertNull(actualSectionPersistencePackageRequest.getMapStructure());
    assertNull(actualSectionPersistencePackageRequest.getOperationTypesOverride());
    assertEquals(0, actualSectionPersistencePackageRequest.getAdditionalForeignKeys().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getCustomCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertEquals(Type.STANDARD, actualSectionPersistencePackageRequest.getType());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
    assertFalse(actualSectionPersistencePackageRequest.isAddOperationInspect());
    assertFalse(actualSectionPersistencePackageRequest.isFolderedLookup());
    assertFalse(actualSectionPersistencePackageRequest.isTreeCollection());
    assertFalse(actualSectionPersistencePackageRequest.isUpdateLookupType());
    assertTrue(actualSectionPersistencePackageRequest.getSubRequests().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with
   * {@code sectionClassName}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs3() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", sectionCrumbs);

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with
   * {@code sectionClassName}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs4() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", sectionCrumbs);

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("Original Section Identifier", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("Section Id", sectionCrumb3.getSectionId());
    assertEquals("Section Identifier", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   * with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(
        "Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals(
        "Section Class Name",
        actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
    assertNull(actualSectionPersistencePackageRequest.getPresentationFetch());
    assertNull(actualSectionPersistencePackageRequest.getLowerCount());
    assertNull(actualSectionPersistencePackageRequest.getMaxIndex());
    assertNull(actualSectionPersistencePackageRequest.getMaxResults());
    assertNull(actualSectionPersistencePackageRequest.getPageSize());
    assertNull(actualSectionPersistencePackageRequest.getStartIndex());
    assertNull(actualSectionPersistencePackageRequest.getUpperCount());
    assertNull(actualSectionPersistencePackageRequest.getFirstId());
    assertNull(actualSectionPersistencePackageRequest.getFolderId());
    assertNull(actualSectionPersistencePackageRequest.getLastId());
    assertNull(actualSectionPersistencePackageRequest.getConfigKey());
    assertNull(actualSectionPersistencePackageRequest.getMsg());
    assertNull(actualSectionPersistencePackageRequest.getRequestingEntityName());
    assertNull(actualSectionPersistencePackageRequest.getSectionEntityField());
    assertNull(actualSectionPersistencePackageRequest.getAdornedList());
    assertNull(actualSectionPersistencePackageRequest.getEntity());
    assertNull(actualSectionPersistencePackageRequest.getForeignKey());
    assertNull(actualSectionPersistencePackageRequest.getMapStructure());
    assertNull(actualSectionPersistencePackageRequest.getOperationTypesOverride());
    assertEquals(0, actualSectionPersistencePackageRequest.getAdditionalForeignKeys().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertEquals(1, actualSectionPersistencePackageRequest.getCustomCriteria().length);
    assertEquals(Type.STANDARD, actualSectionPersistencePackageRequest.getType());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
    assertFalse(actualSectionPersistencePackageRequest.isAddOperationInspect());
    assertFalse(actualSectionPersistencePackageRequest.isFolderedLookup());
    assertFalse(actualSectionPersistencePackageRequest.isTreeCollection());
    assertFalse(actualSectionPersistencePackageRequest.isUpdateLookupType());
    assertTrue(actualSectionPersistencePackageRequest.getSubRequests().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   * with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(
        "Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals(
        "Section Class Name",
        actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
    assertNull(actualSectionPersistencePackageRequest.getPresentationFetch());
    assertNull(actualSectionPersistencePackageRequest.getLowerCount());
    assertNull(actualSectionPersistencePackageRequest.getMaxIndex());
    assertNull(actualSectionPersistencePackageRequest.getMaxResults());
    assertNull(actualSectionPersistencePackageRequest.getPageSize());
    assertNull(actualSectionPersistencePackageRequest.getStartIndex());
    assertNull(actualSectionPersistencePackageRequest.getUpperCount());
    assertNull(actualSectionPersistencePackageRequest.getFirstId());
    assertNull(actualSectionPersistencePackageRequest.getFolderId());
    assertNull(actualSectionPersistencePackageRequest.getLastId());
    assertNull(actualSectionPersistencePackageRequest.getConfigKey());
    assertNull(actualSectionPersistencePackageRequest.getMsg());
    assertNull(actualSectionPersistencePackageRequest.getRequestingEntityName());
    assertNull(actualSectionPersistencePackageRequest.getSectionEntityField());
    assertNull(actualSectionPersistencePackageRequest.getAdornedList());
    assertNull(actualSectionPersistencePackageRequest.getEntity());
    assertNull(actualSectionPersistencePackageRequest.getForeignKey());
    assertNull(actualSectionPersistencePackageRequest.getMapStructure());
    assertNull(actualSectionPersistencePackageRequest.getOperationTypesOverride());
    assertEquals(0, actualSectionPersistencePackageRequest.getAdditionalForeignKeys().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getCustomCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertEquals(Type.STANDARD, actualSectionPersistencePackageRequest.getType());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
    assertFalse(actualSectionPersistencePackageRequest.isAddOperationInspect());
    assertFalse(actualSectionPersistencePackageRequest.isFolderedLookup());
    assertFalse(actualSectionPersistencePackageRequest.isTreeCollection());
    assertFalse(actualSectionPersistencePackageRequest.isUpdateLookupType());
    assertTrue(actualSectionPersistencePackageRequest.getSubRequests().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   * with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars3() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   * with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   *
   * <p>Method under test: {@link
   * AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"
  })
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars4() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest =
        adminExportController.getSectionPersistencePackageRequest(
            "Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("Original Section Identifier", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("Section Id", sectionCrumb3.getSectionId());
    assertEquals("Section Identifier", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        adminExportController.getSectionCrumbs(request, "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    ServletRequest request2 = request.getRequest();
    assertTrue(request2 instanceof JSCompatibilityRequestWrapper);
    assertTrue(
        ((JSCompatibilityRequestWrapper) request2).getRequest() instanceof MockHttpServletRequest);
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs2() {
    // Arrange
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    adminExportController.getSectionCrumbs(request3, "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    ServletRequest request4 = request3.getRequest();
    ServletRequest request5 = ((JSCompatibilityRequestWrapper) request4).getRequest();
    assertTrue(request5 instanceof HttpServletRequestWrapper);
    assertTrue(request4 instanceof JSCompatibilityRequestWrapper);
    ServletRequest request6 = ((HttpServletRequestWrapper) request5).getRequest();
    assertTrue(request6 instanceof JSCompatibilityRequestWrapper);
    assertTrue(
        ((JSCompatibilityRequestWrapper) request6).getRequest() instanceof MockHttpServletRequest);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs3() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        adminExportController.getSectionCrumbs(request, "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    assertTrue(request.getRequest() instanceof MockHttpServletRequest);
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs4() throws IOException, ServletException {
    // Arrange
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        adminExportController.getSectionCrumbs(request3, null, "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs("https://example.org/example");
    verify(request).getParameter("sectionCrumbs");
    ServletRequest request4 = request3.getRequest();
    Collection<Part> parts = ((JSCompatibilityRequestWrapper) request4).getParts();
    assertTrue(parts instanceof List);
    assertTrue(request4 instanceof JSCompatibilityRequestWrapper);
    assertTrue(parts.isEmpty());
    assertTrue(actualSectionCrumbs.isEmpty());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs5() throws IOException, ServletException {
    // Arrange
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        adminExportController.getSectionCrumbs(request3, "Current Section", null);

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs("https://example.org/example");
    verify(request).getParameter("sectionCrumbs");
    ServletRequest request4 = request3.getRequest();
    Collection<Part> parts = ((JSCompatibilityRequestWrapper) request4).getParts();
    assertTrue(parts instanceof List);
    assertTrue(request4 instanceof JSCompatibilityRequestWrapper);
    assertTrue(parts.isEmpty());
    assertTrue(actualSectionCrumbs.isEmpty());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs_givenEmptyString() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        adminExportController.getSectionCrumbs(request3, "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs("");
    verify(request).getParameter("sectionCrumbs");
    assertTrue(request3.getRequest() instanceof JSCompatibilityRequestWrapper);
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs_givenHttpsExampleOrgExample() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        adminExportController.getSectionCrumbs(request3, "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs("https://example.org/example");
    verify(request).getParameter("sectionCrumbs");
    assertTrue(request3.getRequest() instanceof JSCompatibilityRequestWrapper);
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>When {@code /}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"
  })
  public void testGetSectionCrumbs_givenHttpsExampleOrgExample_whenSlash_thenReturnArrayList() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(sectionCrumbList);

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act
    List<SectionCrumb> actualSectionCrumbs =
        adminExportController.getSectionCrumbs(request3, "/", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs("https://example.org/example");
    verify(request).getParameter("sectionCrumbs");
    assertTrue(request3.getRequest() instanceof JSCompatibilityRequestWrapper);
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#createSectionCrumb(String, String)}.
   *
   * <ul>
   *   <li>Then return SectionIdentifier is {@code Current Section}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SectionCrumb AdminAbstractController.createSectionCrumb(String, String)"})
  public void testCreateSectionCrumb_thenReturnSectionIdentifierIsCurrentSection() {
    // Arrange and Act
    SectionCrumb actualCreateSectionCrumbResult =
        new AdminExportController().createSectionCrumb("Current Section", "42");

    // Assert
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertEquals("Current Section", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminAbstractController#createSectionCrumb(String, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return SectionIdentifier is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SectionCrumb AdminAbstractController.createSectionCrumb(String, String)"})
  public void testCreateSectionCrumb_whenSlash_thenReturnSectionIdentifierIsEmptyString() {
    // Arrange and Act
    SectionCrumb actualCreateSectionCrumbResult =
        new AdminExportController().createSectionCrumb("/", "42");

    // Assert
    assertEquals("", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult,
   * JsonResponse)}.
   *
   * <p>Method under test: {@link AdminAbstractController#populateJsonValidationErrors(EntityForm,
   * BindingResult, JsonResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonResponse AdminAbstractController.populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)"
  })
  public void testPopulateJsonValidationErrors() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();
    BindException result = new BindException("Target", "Object Name");
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act
    JsonResponse actualPopulateJsonValidationErrorsResult =
        adminExportController.populateJsonValidationErrors(form, result, json);

    // Assert
    assertSame(json, actualPopulateJsonValidationErrorsResult);
  }

  /**
   * Test {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult,
   * JsonResponse)}.
   *
   * <p>Method under test: {@link AdminAbstractController#populateJsonValidationErrors(EntityForm,
   * BindingResult, JsonResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonResponse AdminAbstractController.populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)"
  })
  public void testPopulateJsonValidationErrors2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("errors", "errors"));
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act
    JsonResponse actualPopulateJsonValidationErrorsResult =
        adminExportController.populateJsonValidationErrors(form, result, json);

    // Assert
    assertSame(json, actualPopulateJsonValidationErrorsResult);
  }

  /**
   * Test {@link AdminAbstractController#translateErrorMessage(ObjectError)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAbstractController#translateErrorMessage(ObjectError)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminAbstractController.translateErrorMessage(ObjectError)"})
  public void testTranslateErrorMessage_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act
    String actualTranslateErrorMessageResult =
        adminExportController.translateErrorMessage(
            new ObjectError("Object Name", "Default Message"));

    // Assert
    assertNull(actualTranslateErrorMessageResult);
  }
}
