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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.web.JsonResponse;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
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
  @InjectMocks
  private AdminExportController adminExportController;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private FormBuilderService formBuilderService;

  @Mock
  private ExploitProtectionService exploitProtectionService;

  @Mock
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock
  private AdminNavigationService adminNavigationService;

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code sectionKey}, {@code sectionClassName}, {@code id}.
   * <p>
   * Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new ServiceException("An error occurred"));

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminExportController.getEntityForm("Section Key", "Section Class Name", "42"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code sectionKey}, {@code sectionClassName}, {@code id}.
   * <p>
   * Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId2() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminExportController.getEntityForm("Section Key", "Section Class Name", "42"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class),
        eq(false));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code sectionKey}, {@code sectionClassName}, {@code id}.
   * <p>
   * Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId3() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet(new Entity[]{new Entity()}, 1));
    when(adminEntityService.getRecordsForAllSubCollections(Mockito.<PersistencePackageRequest>any(),
        Mockito.<Entity>any(), Mockito.<List<SectionCrumb>>any())).thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminExportController.getEntityForm("Section Key", "Section Class Name", "42"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class),
        eq(false));
    verify(adminEntityService).getRecordsForAllSubCollections(isA(PersistencePackageRequest.class), isA(Entity.class),
        isA(List.class));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getEntityForm(String, String, String)} with {@code sectionKey}, {@code sectionClassName}, {@code id}.
   * <ul>
   *   <li>Then return {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getEntityForm(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityForm AdminAbstractController.getEntityForm(String, String, String)"})
  public void testGetEntityFormWithSectionKeySectionClassNameId_thenReturnEntityForm() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(entityForm);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet(new Entity[]{new Entity()}, 1));
    when(adminEntityService.getRecordsForAllSubCollections(Mockito.<PersistencePackageRequest>any(),
        Mockito.<Entity>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new HashMap<>());
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);

    // Act
    EntityForm actualEntityForm = adminExportController.getEntityForm("Section Key", "Section Class Name", "42");

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class),
        eq(false));
    verify(adminEntityService).getRecordsForAllSubCollections(isA(PersistencePackageRequest.class), isA(Entity.class),
        isA(List.class));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isA(Map.class),
        isA(List.class));
    assertSame(entityForm, actualEntityForm);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code persistenceResponse}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs()
      throws ServiceException {
    // Arrange
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();
    HttpHeaders requestParams = new HttpHeaders();
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    // Act
    ListGrid actualCollectionListGrid = adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", persistenceResponse, new ArrayList<>());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(isNull(), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code persistenceResponse}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs2()
      throws ServiceException {
    // Arrange
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();
    HttpHeaders requestParams = new HttpHeaders();
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", persistenceResponse, new ArrayList<>()));
    verify(entity).findProperty(eq("Id Property"));
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(isNull(), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code persistenceResponse}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs3()
      throws ServiceException {
    // Arrange
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();
    HttpHeaders requestParams = new HttpHeaders();
    PersistenceResponse persistenceResponse = new PersistenceResponse();

    // Act
    ListGrid actualCollectionListGrid = adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", persistenceResponse, new ArrayList<>());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code persistenceResponse}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, PersistenceResponse, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeyPersistenceResponseSectionCrumbs4()
      throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
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
    ListGrid actualCollectionListGrid = adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", persistenceResponse, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(entity).findProperty(eq("Id Property"));
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs()
      throws ServiceException {
    // Arrange
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();
    HttpHeaders requestParams = new HttpHeaders();

    // Act
    ListGrid actualCollectionListGrid = adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", new ArrayList<>());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(isNull(), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs2()
      throws ServiceException {
    // Arrange
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    Property collectionProperty = new Property();
    HttpHeaders requestParams = new HttpHeaders();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", new ArrayList<>()));
    verify(entity).findProperty(eq("Id Property"));
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(isNull(), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs3()
      throws ServiceException {
    // Arrange
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Property collectionProperty = new Property();
    HttpHeaders requestParams = new HttpHeaders();

    // Act
    ListGrid actualCollectionListGrid = adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", new ArrayList<>());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)} with {@code mainMetadata}, {@code entity}, {@code collectionProperty}, {@code requestParams}, {@code sectionKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid AdminAbstractController.getCollectionListGrid(ClassMetadata, Entity, Property, MultiValueMap, String, List)"})
  public void testGetCollectionListGridWithMainMetadataEntityCollectionPropertyRequestParamsSectionKeySectionCrumbs4()
      throws ServiceException {
    // Arrange
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    when(adminEntityService.getIdProperty(Mockito.<ClassMetadata>any())).thenReturn("Id Property");
    when(adminEntityService.getPagedRecordsForCollection(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Property>any(), Mockito.<FilterAndSortCriteria[]>any(), Mockito.<FetchPageRequest>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
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
    ListGrid actualCollectionListGrid = adminExportController.getCollectionListGrid(mainMetadata, entity,
        collectionProperty, requestParams, "Section Key", new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(entity).findProperty(eq("Id Property"));
    verify(property).getValue();
    verify(adminEntityService).getIdProperty(isA(ClassMetadata.class));
    verify(adminEntityService).getPagedRecordsForCollection(isA(ClassMetadata.class), isA(Entity.class),
        isA(Property.class), isA(FilterAndSortCriteria[].class), isA(FetchPageRequest.class), isNull(),
        isA(List.class));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    assertSame(listGrid, actualCollectionListGrid);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"})
  public void testGetDynamicFieldTemplateForm_givenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(entityForm);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet(new Entity[]{new Entity()}, 1));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act
    EntityForm actualDynamicFieldTemplateForm = adminExportController.getDynamicFieldTemplateForm(info, "42",
        new EntityForm());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class),
        eq(true));
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
    assertSame(entityForm, actualDynamicFieldTemplateForm);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"})
  public void testGetDynamicFieldTemplateForm_thenCallsClearFieldsMap() throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(entityForm);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet(new Entity[]{new Entity()}, 1));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act
    adminExportController.getDynamicFieldTemplateForm(info, "42", new EntityForm());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class),
        eq(true));
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getTabs();
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"})
  public void testGetDynamicFieldTemplateForm_thenCallsClearFieldsMap2() throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(entityForm);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet(new Entity[]{new Entity()}, 1));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);

    // Act
    adminExportController.getDynamicFieldTemplateForm(new DynamicEntityFormInfo(), "42", null);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class),
        eq(true));
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getTabs();
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}.
   * <ul>
   *   <li>Then return {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"})
  public void testGetDynamicFieldTemplateForm_thenReturnEntityForm() throws ServiceException {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(entityForm);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet(new Entity[]{new Entity()}, 1));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act
    EntityForm actualDynamicFieldTemplateForm = adminExportController.getDynamicFieldTemplateForm(info, "42",
        new EntityForm());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class),
        eq(true));
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isNull(), isNull());
    assertSame(entityForm, actualDynamicFieldTemplateForm);
  }

  /**
   * Test {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminAbstractController.getDynamicFieldTemplateForm(DynamicEntityFormInfo, String, EntityForm)"})
  public void testGetDynamicFieldTemplateForm_thenThrowServiceException() throws ServiceException {
    // Arrange
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminExportController.getDynamicFieldTemplateForm(info, "42", new EntityForm()));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), isNull(), isA(ClassMetadata.class),
        eq(true));
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getOrder()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());
    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(field);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
    verify(field).setName(eq("null|Name"));
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getOrder()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnOne2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());
    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(field);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
    verify(field).setName(eq("null|Name"));
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getOrder()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnZero() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());
    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(0);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(field);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
    verify(field).setName(eq("null|Name"));
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenFieldGroupAddListGridListGrid() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addListGrid(new ListGrid());
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link FieldGroup} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenHashSetAddFieldGroup() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Field} (default constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_givenHashSetAddField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    HashSet<Field> fieldSet = new HashSet<>();
    fieldSet.add(new Field());
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tab} (default constructor).</li>
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link Tab#getFieldGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_thenCallsGetFieldGroups() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(new HashSet<>());

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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
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
   * Test {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link Field#getFriendlyName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)"})
  public void testSetSpecializedNameForFields_thenCallsGetFriendlyName() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    EntityForm dynamicForm = mock(EntityForm.class);

    HashSet<Tab> tabSet = new HashSet<>();
    Tab tab = mock(Tab.class);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();

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
    when(fieldGroup2.getFields()).thenReturn(new HashSet<>());
    fieldGroupSet.add(fieldGroup2);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);
    tabSet.add(tab);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field2).getAlternateOrdering();
    verify(field).getFriendlyName();
    verify(field2).getFriendlyName();
    verify(field, atLeast(1)).getName();
    verify(field2, atLeast(1)).getName();
    verify(field2, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName(eq("null|Name"));
    verify(field2).setName(eq("null|Name"));
    verify(fieldGroup2).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link Field} (default constructor).</li>
   *   <li>Then calls {@link EntityForm#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.extractDynamicFormFields(ClassMetadata, EntityForm)"})
  public void testExtractDynamicFormFields_givenHashMapFooIsField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
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
   * <ul>
   *   <li>Then calls {@link EntityForm#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.extractDynamicFormFields(ClassMetadata, EntityForm)"})
  public void testExtractDynamicFormFields_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
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
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminAbstractController.getSectionKey(Map)"})
  public void testGetSectionKey() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return first element FilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenFoo_thenReturnFirstElementFilterValuesEmpty() {
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
    assertNull(filterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualCriteria.length);
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return first element FilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenFoo_thenReturnFirstElementFilterValuesEmpty2() {
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
    assertNull(filterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualCriteria.length);
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code maxIndex}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code sortDirection}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code sortDirection} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenSortDirection_whenHashMapSortDirectionIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortDirection", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code sortProperty}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code sortProperty} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_givenSortProperty_whenHashMapSortPropertyIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortProperty", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code startIndex}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return first element FilterValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertNull(filterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualCriteria.length);
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FilterAndSortCriteria[] AdminAbstractController.getCriteria(Map)"})
  public void testGetCriteria_whenHashMap_thenReturnArrayLengthIsZero() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(new HashMap<>()).length);
  }

  /**
   * Test {@link AdminAbstractController#getSortDirections(Map)}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSortDirections(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSortDirections(Map)"})
  public void testGetSortDirections() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortDirections(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getSortPropertyNames(Map)}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSortPropertyNames(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSortPropertyNames(Map)"})
  public void testGetSortPropertyNames() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortPropertyNames(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getClassNameForSection(String)}.
   * <ul>
   *   <li>Then return {@code Class Name For Section}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminAbstractController.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnClassNameForSection() {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");

    // Act
    String actualClassNameForSection = adminExportController.getClassNameForSection("Section Key");

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("Section Key"));
    assertEquals("Class Name For Section", actualClassNameForSection);
  }

  /**
   * Test {@link AdminAbstractController#getAddEntityTypes(ClassTree)}.
   * <ul>
   *   <li>When {@link ClassTree#ClassTree()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getAddEntityTypes(ClassTree)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link AdminAbstractController#getDefaultEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminAbstractController.getDefaultEntityType()"})
  public void testGetDefaultEntityType() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getDefaultEntityType());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCustomCriteria()}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCustomCriteria()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminAbstractController.getSectionCustomCriteria()"})
  public void testGetSectionCustomCriteria() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getSectionCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getStartIndex(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getStartIndex(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getStartIndex(Map)"})
  public void testGetStartIndex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getStartIndex(null));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getMaxIndex(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxIndex(Map)"})
  public void testGetMaxIndex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getMaxIndex(null));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getMaxResults(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxResults} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxResults} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxResults(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getMaxResults(Map)"})
  public void testGetMaxResults_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getMaxResults(null));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lastId} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lastId} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getLastId(Map)"})
  public void testGetLastId_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLastId(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getLastId(Map)"})
  public void testGetLastId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getLastId(null));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code firstId} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code firstId} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getFirstId(Map)"})
  public void testGetFirstId_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getFirstId(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long AdminAbstractController.getFirstId(Map)"})
  public void testGetFirstId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getFirstId(null));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getUpperCount(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code upperCount} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code upperCount} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getUpperCount(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getUpperCount(Map)"})
  public void testGetUpperCount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getUpperCount(null));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getLowerCount(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lowerCount} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lowerCount} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLowerCount(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getLowerCount(Map)"})
  public void testGetLowerCount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getLowerCount(null));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getPageSize(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code pageSize} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code pageSize} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getPageSize(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer AdminAbstractController.getPageSize(Map)"})
  public void testGetPageSize_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getPageSize(null));
  }

  /**
   * Test {@link AdminAbstractController#setModelAttributes(Model, String)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setModelAttributes(Model, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link AdminAbstractController#setModelAttributes(Model, String)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#setModelAttributes(Model, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminAbstractController.setModelAttributes(Model, String)"})
  public void testSetModelAttributes_thenConcurrentModelSizeIsTwo() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminExportController.setModelAttributes(model, "Section Key");

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    assertEquals(2, model.size());
    assertEquals("Section Key", model.get("sectionKey"));
    assertSame(adminSectionImpl, model.get(AdminAbstractController.CURRENT_ADMIN_SECTION_ATTRIBUTE_NAME));
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    HttpHeaders requestParams = new HttpHeaders();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertArrayEquals(new String[]{"Merge Section Custom Criteria"},
        actualSectionPersistencePackageRequest.getCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    HttpHeaders requestParams = new HttpHeaders();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
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
    assertEquals(Type.STANDARD, actualSectionPersistencePackageRequest.getType());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
    assertFalse(actualSectionPersistencePackageRequest.isAddOperationInspect());
    assertFalse(actualSectionPersistencePackageRequest.isFolderedLookup());
    assertFalse(actualSectionPersistencePackageRequest.isTreeCollection());
    assertFalse(actualSectionPersistencePackageRequest.isUpdateLookupType());
    assertTrue(actualSectionPersistencePackageRequest.getSubRequests().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.getPresentationFetch());
    assertTrue(actualSectionPersistencePackageRequest.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs3()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs4()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenReturn(AdminAbstractController.FILTER_VALUE_SEPARATOR);

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs5()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.addAll("sortProperty", new ArrayList<>());
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs6() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("sortDirection", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertArrayEquals(new String[]{"Merge Section Custom Criteria"},
        actualSectionPersistencePackageRequest.getCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs7() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "%");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("\\%", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs8()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
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
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs9()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
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
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs);

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("sortProperty", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("sortProperty", sectionCrumb3.getSectionId());
    assertEquals("sortProperty", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbs10()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, new ArrayList<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    HttpHeaders requestParams = new HttpHeaders();
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertArrayEquals(new String[]{"Merge Section Custom Criteria"},
        actualSectionPersistencePackageRequest.getCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    HttpHeaders requestParams = new HttpHeaders();
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
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
    assertEquals(Type.STANDARD, actualSectionPersistencePackageRequest.getType());
    assertFalse(actualSectionPersistencePackageRequest.hasSortCriteria());
    assertFalse(actualSectionPersistencePackageRequest.isAddOperationInspect());
    assertFalse(actualSectionPersistencePackageRequest.isFolderedLookup());
    assertFalse(actualSectionPersistencePackageRequest.isTreeCollection());
    assertFalse(actualSectionPersistencePackageRequest.isUpdateLookupType());
    assertTrue(actualSectionPersistencePackageRequest.getSubRequests().isEmpty());
    assertTrue(actualSectionPersistencePackageRequest.getPresentationFetch());
    assertTrue(actualSectionPersistencePackageRequest.isValidateUnsubmittedProperties());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars3()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars4()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenReturn(AdminAbstractController.FILTER_VALUE_SEPARATOR);

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars5()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.addAll("sortProperty", new ArrayList<>());
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("Clean String", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars6() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("sortDirection", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals(0, actualSectionPersistencePackageRequest.getFilterAndSortCriteria().length);
    assertEquals(0, actualSectionPersistencePackageRequest.getSectionCrumbs().length);
    assertArrayEquals(new String[]{"Merge Section Custom Criteria"},
        actualSectionPersistencePackageRequest.getCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars7() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "%");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("\\%", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars8()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
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
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars9()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
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
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("sortProperty", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("sortProperty", sectionCrumb3.getSectionId());
    assertEquals("sortProperty", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)} with {@code sectionClassName}, {@code requestParams}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, MultiValueMap, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameRequestParamsSectionCrumbsPathVars10()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));

    HttpHeaders requestParams = new HttpHeaders();
    requestParams.add("https://example.org/example", "https://example.org/example");
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", requestParams, sectionCrumbs, new HashMap<>());

    // Assert
    verify(exploitProtectionService).cleanString(eq("https://example.org/example"));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    FilterAndSortCriteria[] filterAndSortCriteria = actualSectionPersistencePackageRequest.getFilterAndSortCriteria();
    FilterAndSortCriteria filterAndSortCriteria2 = filterAndSortCriteria[0];
    List<String> filterValues = filterAndSortCriteria2.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("https://example.org/example", filterValues.get(0));
    assertEquals("https://example.org/example", filterAndSortCriteria2.getPropertyId());
    assertNull(filterAndSortCriteria2.getSortAscending());
    assertNull(filterAndSortCriteria2.getSortDirection());
    assertNull(filterAndSortCriteria2.getRestrictionType());
    assertEquals(1, filterAndSortCriteria.length);
    assertTrue(filterAndSortCriteria2.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria2.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria2.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with {@code sectionClassName}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
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
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with {@code sectionClassName}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{});

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", new ArrayList<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
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
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with {@code sectionClassName}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs3() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", sectionCrumbs);

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)} with {@code sectionClassName}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbs4() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

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
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", sectionCrumbs);

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("Original Section Identifier", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("Section Id", sectionCrumb3.getSectionId());
    assertEquals("Section Identifier", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)} with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
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
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)} with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars2() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{});
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getCeilingEntityClassname());
    assertEquals("Section Class Name", actualSectionPersistencePackageRequest.getSecurityCeilingEntityClassname());
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
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)} with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars3() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
    SectionCrumb[] sectionCrumbs2 = actualSectionPersistencePackageRequest.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)} with {@code sectionClassName}, {@code sectionCrumbs}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionPersistencePackageRequest(String, List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminAbstractController.getSectionPersistencePackageRequest(String, List, Map)"})
  public void testGetSectionPersistencePackageRequestWithSectionClassNameSectionCrumbsPathVars4() {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

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
    PersistencePackageRequest actualSectionPersistencePackageRequest = adminExportController
        .getSectionPersistencePackageRequest("Section Class Name", sectionCrumbs, new HashMap<>());

    // Assert
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Section Class Name"), isNull());
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
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController.getSectionCrumbs(request, "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    assertTrue(request.getRequest() instanceof MockHttpServletRequest);
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs2() {
    // Arrange
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController.getSectionCrumbs(request, "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    ServletRequest request2 = request.getRequest();
    assertTrue(request2 instanceof HttpServletRequestWrapper);
    ServletRequest request3 = ((HttpServletRequestWrapper) request2).getRequest();
    assertTrue(request3 instanceof JSCompatibilityRequestWrapper);
    assertTrue(((JSCompatibilityRequestWrapper) request3).getRequest() instanceof MockHttpServletRequest);
    assertEquals(1, actualSectionCrumbs.size());
    assertEquals("Current Section", actualSectionCrumbs.get(0).getSectionIdentifier());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs_givenEmptyString() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController
        .getSectionCrumbs(new JSCompatibilityRequestWrapper(request), "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(eq(""));
    verify(request).getParameter(eq("sectionCrumbs"));
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs_givenHttpsExampleOrgExample() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController
        .getSectionCrumbs(new JSCompatibilityRequestWrapper(request), "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(eq("https://example.org/example"));
    verify(request).getParameter(eq("sectionCrumbs"));
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs_givenHttpsExampleOrgExample_whenNull_thenReturnEmpty() {
    // Arrange
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController
        .getSectionCrumbs(new JSCompatibilityRequestWrapper(request), null, "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(eq("https://example.org/example"));
    verify(request).getParameter(eq("sectionCrumbs"));
    assertTrue(actualSectionCrumbs.isEmpty());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs_givenHttpsExampleOrgExample_whenNull_thenReturnEmpty2() {
    // Arrange
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController
        .getSectionCrumbs(new JSCompatibilityRequestWrapper(request), "Current Section", null);

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(eq("https://example.org/example"));
    verify(request).getParameter(eq("sectionCrumbs"));
    assertTrue(actualSectionCrumbs.isEmpty());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs_givenHttpsExampleOrgExample_whenSlash_thenReturnArrayList() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController
        .getSectionCrumbs(new JSCompatibilityRequestWrapper(request), "/", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(eq("https://example.org/example"));
    verify(request).getParameter(eq("sectionCrumbs"));
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCrumbs(HttpServletRequest, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminAbstractController.getSectionCrumbs(HttpServletRequest, String, String)"})
  public void testGetSectionCrumbs_whenMockHttpServletRequest_thenReturnArrayList() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbList = new ArrayList<>();
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(sectionCrumbList);

    // Act
    List<SectionCrumb> actualSectionCrumbs = adminExportController.getSectionCrumbs(new MockHttpServletRequest(),
        "Current Section", "42");

    // Assert
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    assertSame(sectionCrumbList, actualSectionCrumbs);
  }

  /**
   * Test {@link AdminAbstractController#createSectionCrumb(String, String)}.
   * <ul>
   *   <li>Then return SectionIdentifier is {@code Current Section}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SectionCrumb AdminAbstractController.createSectionCrumb(String, String)"})
  public void testCreateSectionCrumb_thenReturnSectionIdentifierIsCurrentSection() {
    // Arrange and Act
    SectionCrumb actualCreateSectionCrumbResult = (new AdminExportController()).createSectionCrumb("Current Section",
        "42");

    // Assert
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertEquals("Current Section", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminAbstractController#createSectionCrumb(String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return SectionIdentifier is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SectionCrumb AdminAbstractController.createSectionCrumb(String, String)"})
  public void testCreateSectionCrumb_whenSlash_thenReturnSectionIdentifierIsEmptyString() {
    // Arrange and Act
    SectionCrumb actualCreateSectionCrumbResult = (new AdminExportController()).createSectionCrumb("/", "42");

    // Assert
    assertEquals("", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}.
   * <p>
   * Method under test: {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "JsonResponse AdminAbstractController.populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)"})
  public void testPopulateJsonValidationErrors() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("errors", "errors"));
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act and Assert
    assertSame(json, adminExportController.populateJsonValidationErrors(form, result, json));
  }

  /**
   * Test {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}.
   * <p>
   * Method under test: {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "JsonResponse AdminAbstractController.populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)"})
  public void testPopulateJsonValidationErrors2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("errorType", "errorType"));
    result.addError(new ObjectError("errors", "errors"));
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act and Assert
    assertSame(json, adminExportController.populateJsonValidationErrors(form, result, json));
  }

  /**
   * Test {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}.
   * <ul>
   *   <li>When {@link BindException#BindException(Object, String)} with {@code Target} and {@code Object Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "JsonResponse AdminAbstractController.populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)"})
  public void testPopulateJsonValidationErrors_whenBindExceptionWithTargetAndObjectName() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();
    BindException result = new BindException("Target", "Object Name");

    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act and Assert
    assertSame(json, adminExportController.populateJsonValidationErrors(form, result, json));
  }

  /**
   * Test {@link AdminAbstractController#translateErrorMessage(ObjectError)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#translateErrorMessage(ObjectError)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminAbstractController.translateErrorMessage(ObjectError)"})
  public void testTranslateErrorMessage_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.translateErrorMessage(new ObjectError("Object Name", "Default Message")));
  }
}
