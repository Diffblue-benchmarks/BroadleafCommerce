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
package org.broadleafcommerce.openadmin.server.service;

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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.CollectionMetadata;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ParentRecordStructure;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.exception.EntityNotFoundException;
import org.broadleafcommerce.openadmin.server.domain.FetchPageRequest;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.factory.PersistencePackageFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminEntityServiceImplDiffblueTest {
  @InjectMocks
  private AdminEntityServiceImpl adminEntityServiceImpl;

  @Mock
  private DynamicEntityService dynamicEntityService;

  @Mock
  private PersistencePackageFactory persistencePackageFactory;

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"})
  public void testGetClassMetadata() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(new ClassMetadata()));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    // Act
    adminEntityServiceImpl.getClassMetadata(request);

    // Assert
    verify(request).getCeilingEntityClassname();
    verify(request).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then calls {@link ClassMetadata#setCeilingType(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"})
  public void testGetClassMetadata_thenCallsSetCeilingType() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(classMetaData));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    // Act
    adminEntityServiceImpl.getClassMetadata(request);

    // Assert
    verify(classMetaData).setCeilingType(eq("Ceiling Entity Classname"));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Entity Classname"));
    verify(request).getCeilingEntityClassname();
    verify(request).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"})
  public void testGetClassMetadata_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualClassMetadata = adminEntityServiceImpl
        .getClassMetadata(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualClassMetadata);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"})
  public void testGetClassMetadata_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getClassMetadata(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecords(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecords(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.getRecords(PersistencePackageRequest)"})
  public void testGetRecords_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("admin.default.max.results"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getRecords(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"})
  public void testGetRecord_givenBasicFieldMetadataGetFieldTypeReturnUnknown() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"})
  public void testGetRecord_givenPropertyGetMetadataReturnAdornedTargetCollectionMetadata() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"})
  public void testGetRecord_givenPropertyGetMetadataReturnBasicFieldMetadata() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackageRequest#addFilterAndSortCriteria(FilterAndSortCriteria)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"})
  public void testGetRecord_thenCallsAddFilterAndSortCriteria() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenThrow(new EntityNotFoundException("."));
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(request).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackageFactory#create(PersistencePackageRequest)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"})
  public void testGetRecord_thenCallsCreate() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("."));
    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"})
  public void testGetRecord_whenClassMetadataCeilingTypeIsType_thenThrowServiceException() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <ul>
   *   <li>When {@link ClassMetadata} {@link ClassMetadata#getProperties()} return array of {@link Property} with {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"})
  public void testGetRecord_whenClassMetadataGetPropertiesReturnArrayOfPropertyWithProperty() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{new Property()});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getPropertyName()).thenReturn("Property Name");
    when(dynamicEntityFormInfo.getCustomCriteriaOverride()).thenReturn(new String[]{});
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualAddEntityResult = adminEntityServiceImpl.addEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getCustomCriteriaOverride();
    verify(dynamicEntityFormInfo).getPropertyName();
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo(eq("foo"));
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link EntityForm} (default constructor) Id is {@code 42}.</li>
   *   <li>Then {@link EntityForm} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_given42_whenEntityFormIdIs42_thenEntityFormFieldsSizeIsOne() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act
    adminEntityServiceImpl.addEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link DynamicEntityFormInfo} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_givenDynamicEntityFormInfo() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(new DynamicEntityFormInfo());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualAddEntityResult = adminEntityServiceImpl.addEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo(eq("foo"));
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm, atLeast(1)).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_givenEmptyString_whenEntityFormGetEntityTypeReturnEmptyString() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualAddEntityResult = adminEntityServiceImpl.addEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code Entity Type}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_givenEntityType_whenEntityFormGetEntityTypeReturnEntityType() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualAddEntityResult = adminEntityServiceImpl.addEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_givenNull_whenEntityFormGetEntityTypeReturnNull() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn(null);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualAddEntityResult = adminEntityServiceImpl.addEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    adminEntityServiceImpl.addEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then calls {@link DynamicEntityFormInfo#getCustomCriteriaOverride()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_thenCallsGetCustomCriteriaOverride() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getPropertyName()).thenReturn("Property Name");
    when(dynamicEntityFormInfo.getCustomCriteriaOverride()).thenReturn(new String[]{"Custom Criteria Override"});
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualAddEntityResult = adminEntityServiceImpl.addEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getCustomCriteriaOverride();
    verify(dynamicEntityFormInfo).getPropertyName();
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo(eq("foo"));
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualAddEntityResult = adminEntityServiceImpl.addEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(entity, actualAddEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.addEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"})
  public void testAddEntity_whenEntityForm_thenEntityFormFieldsSizeIsOne() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());
    EntityForm entityForm = new EntityForm();

    // Act
    adminEntityServiceImpl.addEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getPropertyName()).thenReturn("Property Name");
    when(dynamicEntityFormInfo.getSecurityCeilingClassName()).thenReturn("Security Ceiling Class Name");
    when(dynamicEntityFormInfo.getCustomCriteriaOverride()).thenReturn(new String[]{});
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualUpdateEntityResult = adminEntityServiceImpl.updateEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getCustomCriteriaOverride();
    verify(dynamicEntityFormInfo).getPropertyName();
    verify(dynamicEntityFormInfo).getSecurityCeilingClassName();
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo(eq("foo"));
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link EntityForm} (default constructor) Id is {@code 42}.</li>
   *   <li>Then {@link EntityForm} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_given42_whenEntityFormIdIs42_thenEntityFormFieldsSizeIsOne() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act
    adminEntityServiceImpl.updateEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link DynamicEntityFormInfo} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_givenDynamicEntityFormInfo() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(new DynamicEntityFormInfo());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualUpdateEntityResult = adminEntityServiceImpl.updateEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo(eq("foo"));
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm, atLeast(1)).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_givenEmptyString_whenEntityFormGetEntityTypeReturnEmptyString() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualUpdateEntityResult = adminEntityServiceImpl.updateEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code Entity Type}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_givenEntityType_whenEntityFormGetEntityTypeReturnEntityType() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualUpdateEntityResult = adminEntityServiceImpl.updateEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_givenNull_whenEntityFormGetEntityTypeReturnNull() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn(null);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualUpdateEntityResult = adminEntityServiceImpl.updateEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    adminEntityServiceImpl.updateEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then calls {@link DynamicEntityFormInfo#getCustomCriteriaOverride()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_thenCallsGetCustomCriteriaOverride() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getPropertyName()).thenReturn("Property Name");
    when(dynamicEntityFormInfo.getSecurityCeilingClassName()).thenReturn("Security Ceiling Class Name");
    when(dynamicEntityFormInfo.getCustomCriteriaOverride()).thenReturn(new String[]{"Custom Criteria Override"});
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualUpdateEntityResult = adminEntityServiceImpl.updateEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getCustomCriteriaOverride();
    verify(dynamicEntityFormInfo).getPropertyName();
    verify(dynamicEntityFormInfo).getSecurityCeilingClassName();
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo(eq("foo"));
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualUpdateEntityResult = adminEntityServiceImpl.updateEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(entity, actualUpdateEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.updateEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"})
  public void testUpdateEntity_whenEntityForm_thenEntityFormFieldsSizeIsOne() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());
    EntityForm entityForm = new EntityForm();

    // Act
    adminEntityServiceImpl.updateEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity2() throws ServiceException {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, sectionCrumb3));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link EntityForm} (default constructor) Id is {@code 42}.</li>
   *   <li>Then {@link EntityForm} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_given42_whenEntityFormIdIs42_thenEntityFormFieldsSizeIsOne() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act
    adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_givenEmptyString_whenEntityFormGetEntityTypeReturnEmptyString() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualRemoveEntityResult = adminEntityServiceImpl.removeEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code Entity Type}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_givenEntityType_whenEntityFormFindFieldReturnNull() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);

    // Act
    PersistenceResponse actualRemoveEntityResult = adminEntityServiceImpl.removeEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code Entity Type}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_givenEntityType_whenEntityFormGetEntityTypeReturnEntityType() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualRemoveEntityResult = adminEntityServiceImpl.removeEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_givenLeftSquareBracket() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_givenNull_whenEntityFormGetEntityTypeReturnNull() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn(null);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistenceResponse actualRemoveEntityResult = adminEntityServiceImpl.removeEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_givenSectionCrumbOriginalSectionIdentifierIs42() throws ServiceException {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, sectionCrumb2));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then calls {@link Field#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_thenCallsSetValue() throws ServiceException {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualRemoveEntityResult = adminEntityServiceImpl.removeEntity(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(entity, actualRemoveEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"})
  public void testRemoveEntity_whenEntityForm_thenEntityFormFieldsSizeIsOne() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(new PersistenceResponse());
    EntityForm entityForm = new EntityForm();

    // Act
    adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminEntityServiceImpl.getPropertiesFromEntityForm(EntityForm)"})
  public void testGetPropertiesFromEntityForm_givenHashMap_thenReturnEmpty() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    // Act
    List<Property> actualPropertiesFromEntityForm = adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertTrue(actualPropertiesFromEntityForm.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>Then return first DisplayValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminEntityServiceImpl.getPropertiesFromEntityForm(EntityForm)"})
  public void testGetPropertiesFromEntityForm_thenReturnFirstDisplayValueIs42() {
    // Arrange
    Field field = new Field();
    field.setValue("42");

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", field);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    // Act
    List<Property> actualPropertiesFromEntityForm = adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertEquals(1, actualPropertiesFromEntityForm.size());
    Property getResult = actualPropertiesFromEntityForm.get(0);
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>Then return first DisplayValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminEntityServiceImpl.getPropertiesFromEntityForm(EntityForm)"})
  public void testGetPropertiesFromEntityForm_thenReturnFirstDisplayValueIsNull() {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    // Act
    List<Property> actualPropertiesFromEntityForm = adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertEquals(1, actualPropertiesFromEntityForm.size());
    Property getResult = actualPropertiesFromEntityForm.get(0);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminEntityServiceImpl.getPropertiesFromEntityForm(EntityForm)"})
  public void testGetPropertiesFromEntityForm_whenEntityForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminEntityServiceImpl.getPropertiesFromEntityForm(new EntityForm()).isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
    Entity entity = actualRequestForEntityForm.getEntity();
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("Id Property");
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
    assertEquals("Id Property", getResult.getName());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    Property[] properties = entity.getProperties();
    assertEquals(1, properties.length);
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(getResult, properties[0]);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm2() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

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

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, sectionCrumbs));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_givenEmptyString() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getCeilingEntityClassname());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertEquals("Main Entity Name", actualRequestForEntityForm.getRequestingEntityName());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(0, entity.getProperties().length);
    assertTrue(entity.getPMap().isEmpty());
    assertArrayEquals(new String[]{"Ceiling Entity Classname"}, entity.getType());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_givenLeftSquareBracket() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    Map<String, Property> pMap = actualRequestForEntityForm.getEntity().getPMap();
    assertEquals(1, pMap.size());
    Property getResult2 = pMap.get("id");
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_givenSectionCrumbOriginalSectionIdentifierIs42() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, sectionCrumbs));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_givenTabMetadata() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    Map<String, Property> pMap = actualRequestForEntityForm.getEntity().getPMap();
    assertEquals(1, pMap.size());
    Property getResult2 = pMap.get("id");
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then return Entity PMap {@code id} DisplayValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_thenReturnEntityPMapIdDisplayValueIs42() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act and Assert
    Map<String, Property> pMap = adminEntityServiceImpl
        .getRequestForEntityForm(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>())
        .getEntity()
        .getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("id");
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult2 = fields.get("id");
    assertEquals("42", getResult2.getDisplayValue());
    assertEquals("42", getResult2.getValue());
    assertEquals("null/42", getResult2.getEntityViewPath());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then return Entity Type is array of {@link String} with {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_thenReturnEntityTypeIsArrayOfStringWithEntityType() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getCeilingEntityClassname());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertEquals("Main Entity Name", actualRequestForEntityForm.getRequestingEntityName());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(0, entity.getProperties().length);
    assertTrue(entity.getPMap().isEmpty());
    assertArrayEquals(new String[]{"Entity Type"}, entity.getType());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_thenThrowEntityNotFoundException() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_whenEntityForm() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    Map<String, Property> pMap = actualRequestForEntityForm.getEntity().getPMap();
    assertEquals(1, pMap.size());
    Property getResult2 = pMap.get("id");
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"})
  public void testGetRequestForEntityForm_whenEntityFormGetEntityTypeReturnNull() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn(null);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getCeilingEntityClassname());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertEquals("Main Entity Name", actualRequestForEntityForm.getRequestingEntityName());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(0, entity.getProperties().length);
    assertTrue(entity.getPMap().isEmpty());
    assertArrayEquals(new String[]{"Ceiling Entity Classname"}, entity.getType());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)"})
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42"));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)"})
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId2()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42"));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)"})
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId3()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42"));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
    verify(property).getValue();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])"})
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"}));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])"})
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria2()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"}));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])"})
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria3()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"}));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
    verify(property).getValue();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)"})
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, "42",
            new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)"})
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs2()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, "42",
            new ArrayList<>()));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)"})
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)} with {@code containingClassMetadata}, {@code containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)"})
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb2()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)"})
  public void testGetPagedRecordsForCollection_whenClassMetadataCeilingTypeIsType() throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getPagedRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, fetchPageRequest, "42",
            new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   * <ul>
   *   <li>When {@link Property#Property()}.</li>
   *   <li>Then calls {@link ClassMetadata#getCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)"})
  public void testGetPagedRecordsForCollection_whenProperty_thenCallsGetCeilingType() throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getPagedRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, fetchPageRequest, "42",
            new ArrayList<>()));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getRecordsForAllSubCollections(ppr, containingEntity, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(classMetaData));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(mock(DynamicResultSet.class));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections = adminEntityServiceImpl
        .getRecordsForAllSubCollections(ppr, containingEntity, new ArrayList<>());

    // Assert
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Ceiling Entity Classname"));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Entity Classname"));
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(classMetaData));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(mock(DynamicResultSet.class));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections = adminEntityServiceImpl
        .getRecordsForAllSubCollections(ppr, containingEntity, new ArrayList<>());

    // Assert
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Ceiling Entity Classname"));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Entity Classname"));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    Property property = new Property();
    when(classMetaData.getProperties()).thenReturn(new Property[]{property, new Property()});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(classMetaData));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(mock(DynamicResultSet.class));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections = adminEntityServiceImpl
        .getRecordsForAllSubCollections(ppr, containingEntity, new ArrayList<>());

    // Assert
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Ceiling Entity Classname"));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Entity Classname"));
    verify(containingEntity, atLeast(1)).getType();
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getRecordsForAllSubCollections(ppr, containingEntity, 1, 1, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb2()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(classMetaData));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(mock(DynamicResultSet.class));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections = adminEntityServiceImpl
        .getRecordsForAllSubCollections(ppr, containingEntity, 1, 1, new ArrayList<>());

    // Assert
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Ceiling Entity Classname"));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Entity Classname"));
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb3()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(classMetaData));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(mock(DynamicResultSet.class));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections = adminEntityServiceImpl
        .getRecordsForAllSubCollections(ppr, containingEntity, 1, 1, new ArrayList<>());

    // Assert
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Ceiling Entity Classname"));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Entity Classname"));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"})
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb4()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    Property property = new Property();
    when(classMetaData.getProperties()).thenReturn(new Property[]{property, new Property()});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet(classMetaData));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(mock(DynamicResultSet.class));
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections = adminEntityServiceImpl
        .getRecordsForAllSubCollections(ppr, containingEntity, 1, 1, new ArrayList<>());

    // Assert
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Ceiling Entity Classname"));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Entity Classname"));
    verify(containingEntity, atLeast(1)).getType();
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"})
  public void testGetRecordsForSelectedTab() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, sectionCrumb3, "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()} and {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"})
  public void testGetRecordsForSelectedTab_givenArrayOfPropertyWithPropertyAndProperty() throws ServiceException {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    Property property = new Property();
    when(cmd.getProperties()).thenReturn(new Property[]{property, new Property()});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getType();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Given empty array of {@link Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"})
  public void testGetRecordsForSelectedTab_givenEmptyArrayOfProperty() throws ServiceException {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"})
  public void testGetRecordsForSelectedTab_givenSectionCrumbOriginalSectionIdentifierIs42() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, sectionCrumb2, "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#getAvailableToTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"})
  public void testGetRecordsForSelectedTab_thenCallsGetAvailableToTypes() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata, ClassMetadata, String, int)}.
   * <ul>
   *   <li>Then calls {@link ClassMetadata#getTabAndGroupMetadata()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata, ClassMetadata, String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminEntityServiceImpl.updateTabInfo(CollectionMetadata, ClassMetadata, String, int)"})
  public void testUpdateTabInfo_thenCallsGetTabAndGroupMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getTabAndGroupMetadata()).thenReturn(new HashMap<>());
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl.updateTabInfo(fmd, cmd, "Tab Name", 1);

    // Assert
    verify(cmd).getTabAndGroupMetadata();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"})
  public void testGetAllRecordsForAllSubCollections() throws ServiceException {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    Property property = new Property();
    when(cmd.getProperties()).thenReturn(new Property[]{property, new Property()});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getType();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"})
  public void testGetAllRecordsForAllSubCollections2() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, sectionCrumb2);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"})
  public void testGetAllRecordsForAllSubCollections3() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, sectionCrumb3);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given empty array of {@link Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"})
  public void testGetAllRecordsForAllSubCollections_givenEmptyArrayOfProperty() throws ServiceException {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#getAvailableToTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"})
  public void testGetAllRecordsForAllSubCollections_thenCallsGetAvailableToTypes() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity() throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity2() throws ClassNotFoundException, ServiceException {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("The specified field [%s] for class [%s] was not a collection field.", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Given {@code Ceiling Type}.</li>
   *   <li>Then calls {@link ClassMetadata#getCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_givenCeilingType_thenCallsGetCeilingType()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(mainMetadata).getCeilingType();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property} {@link Property#getName()} return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_givenDot_whenPropertyGetNameReturnDot()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualAddSubCollectionEntityResult = adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    assertSame(persistenceResponse, actualAddSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code __adminMainEntity} is {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_givenHashMapAdminMainEntityIsField()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("__adminMainEntity", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualAddSubCollectionEntityResult = adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    assertSame(persistenceResponse, actualAddSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_givenTabMetadata() throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_thenReturnEntityIsEntity() throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualAddSubCollectionEntityResult = adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    assertSame(entity, actualAddSubCollectionEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_thenReturnPersistenceResponse()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualAddSubCollectionEntityResult = adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    assertSame(persistenceResponse, actualAddSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_thenThrowEntityNotFoundException()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("."));
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_thenThrowIllegalArgumentException()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"})
  public void testAddSubCollectionEntity_whenEntityForm_thenThrowIllegalArgumentException()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs2()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs3()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs4()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs5()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("The specified field [%s] for class [%s] was not a collection field.", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs6()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
    verify(mainMetadata).getCeilingType();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs7()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs8()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn("ALTERNATE_ID");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs9()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn(null);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs10()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put(".", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs11()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb2()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb3()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb4()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb5()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("The specified field [%s] for class [%s] was not a collection field.", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb6()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.updateSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, "42", new ArrayList<>()));
    verify(mainMetadata).getCeilingType();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb7()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb8()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("__adminMainEntity", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"})
  public void testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb9()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualUpdateSubCollectionEntityResult = adminEntityServiceImpl
        .updateSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getIdProperty();
    assertSame(persistenceResponse, actualUpdateSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)} with {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code itemId}, {@code alternateId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)"})
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdAlternateIdPriorKeySectionCrumbs()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getPMap()).thenReturn(new HashMap<>());
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    PersistenceResponse actualRemoveSubCollectionEntityResult = adminEntityServiceImpl
        .removeSubCollectionEntity(mainMetadata, field, parentEntity, "42", "42", "Prior Key", new ArrayList<>());

    // Assert
    verify(parentEntity).findProperty(eq("id"));
    verify(parentEntity).getPMap();
    verify(field, atLeast(1)).getMetadata();
    verify(field, atLeast(1)).getName();
    verify(field).setName(eq("id"));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)} with {@code mainMetadata}, {@code field}, {@code parentEntity}, {@code itemId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PersistenceResponse AdminEntityServiceImpl.removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)"})
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdPriorKeySectionCrumbs()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property field = mock(Property.class);
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getPMap()).thenReturn(new HashMap<>());
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    PersistenceResponse actualRemoveSubCollectionEntityResult = adminEntityServiceImpl
        .removeSubCollectionEntity(mainMetadata, field, parentEntity, "42", "Prior Key", new ArrayList<>());

    // Assert
    verify(parentEntity).findProperty(eq("id"));
    verify(parentEntity).getPMap();
    verify(field, atLeast(1)).getMetadata();
    verify(field, atLeast(1)).getName();
    verify(field).setName(eq("id"));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"})
  public void testGetContextSpecificRelationshipId_givenPropertyGetValueReturn42_thenReturn42() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "Property Name");

    // Assert
    verify(entity).findProperty(eq("id"));
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"})
  public void testGetContextSpecificRelationshipId_givenProperty_thenReturnNull() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "Property Name");

    // Assert
    verify(entity).findProperty(eq("id"));
    assertNull(actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"})
  public void testGetContextSpecificRelationshipId_whenDot_thenReturn42() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        ".");

    // Assert
    verify(entity).findProperty(eq("id"));
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty() throws ServiceException {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{new Property()});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenBasicFieldMetadataGetFieldTypeReturnUnknown() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyGetMetadataReturnAdornedTargetCollectionMetadata()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyGetMetadataReturnBasicFieldMetadata() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code .}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyGetNameReturnDot_thenCallsGetName() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyGetNameReturnName_thenReturnName() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualIdProperty = adminEntityServiceImpl.getIdProperty(cmd);

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    assertEquals("Name", actualIdProperty);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new EntityNotFoundException("."));
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_whenClassMetadataCeilingTypeIsType_thenThrowServiceException() throws ServiceException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(entity, actualAddResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(entity, actualAddResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest5() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    doNothing().when(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(Mockito.<String>any());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest6() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    doThrow(new EntityNotFoundException("foo")).when(persistencePackage)
        .setSecurityCeilingEntityFullyQualifiedClassname(Mockito.<String>any());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request));
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest7() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.add(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(entity, actualAddResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional5() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request, true));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional6() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(entity, actualAddResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional7() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    doThrow(new EntityNotFoundException("foo")).when(persistencePackage)
        .setSecurityCeilingEntityFullyQualifiedClassname(Mockito.<String>any());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request, true));
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional8() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn("");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional9() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional10() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(mock(PersistencePackage.class));
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalAdd(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(false);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, false);

    // Assert
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalAdd(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional11() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(mock(PersistencePackage.class));
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    when(dynamicEntityService.nonTransactionalAdd(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(false);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request, false));
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalAdd(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <ul>
   *   <li>Given {@link SectionCrumb} {@link SectionCrumb#getSectionIdentifier()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional_givenSectionCrumbGetSectionIdentifierReturn42() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn("42");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    doNothing().when(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(Mockito.<String>any());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, false);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(eq("42"));
    verify(sectionCrumb, atLeast(1)).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <ul>
   *   <li>Given {@link SectionCrumb} {@link SectionCrumb#getSectionIdentifier()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional_givenSectionCrumbGetSectionIdentifierReturnNull()
      throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn(null);
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, false);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"})
  public void testAddWithRequestTransactional_givenSectionCrumbOriginalSectionIdentifierIs42() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    doNothing().when(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(Mockito.<String>any());
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(persistencePackage).setSecurityCeilingEntityFullyQualifiedClassname(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Given {@link DynamicEntityService} {@link DynamicEntityService#add(PersistencePackage)} return {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_givenDynamicEntityServiceAddReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then calls {@link SectionCrumb#getSectionIdentifier()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_thenCallsGetSectionIdentifier() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn("");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any())).thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(persistencePackage, atLeast(1)).getSectionCrumbs();
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"})
  public void testUpdateWithRequestTransactional() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualUpdateResult = adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualUpdateResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"})
  public void testUpdateWithRequestTransactional2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"})
  public void testUpdateWithRequestTransactional3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualUpdateResult = adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualUpdateResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"})
  public void testUpdateWithRequestTransactional4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), false));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"})
  public void testUpdateWithRequestTransactional_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult = adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(entity, actualUpdateResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"})
  public void testUpdateWithRequest_givenEntityIsValidationFailureReturnTrue() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult = adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualUpdateResult.getDynamicResultSet());
    assertTrue(actualUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"})
  public void testUpdateWithRequest_thenCallsAddGlobalValidationError() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult = adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).addGlobalValidationError(isNull());
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(eq(true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualUpdateResult.getDynamicResultSet());
    assertTrue(actualUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"})
  public void testUpdateWithRequest_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult = adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(entity, actualUpdateResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"})
  public void testUpdateWithRequest_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualUpdateResult = adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualUpdateResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"})
  public void testUpdateWithRequest_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.inspect(PersistencePackageRequest)"})
  public void testInspect_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualInspectResult = adminEntityServiceImpl.inspect(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualInspectResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.inspect(PersistencePackageRequest)"})
  public void testInspect_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.inspect(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"})
  public void testRemoveWithRequestTransactional() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualRemoveResult = adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"})
  public void testRemoveWithRequestTransactional2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"})
  public void testRemoveWithRequestTransactional3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalRemove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualRemoveResult = adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalRemove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"})
  public void testRemoveWithRequestTransactional4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalRemove(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), false));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalRemove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code request}, {@code transactional}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"})
  public void testRemoveWithRequestTransactional_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult = adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(entity, actualRemoveResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"})
  public void testRemoveWithRequest_givenEntityIsValidationFailureReturnTrue() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult = adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertNull(actualRemoveResult.getDynamicResultSet());
    assertTrue(actualRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"})
  public void testRemoveWithRequest_thenCallsAddGlobalValidationError() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult = adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).addGlobalValidationError(isNull());
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(eq(true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertNull(actualRemoveResult.getDynamicResultSet());
    assertTrue(actualRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"})
  public void testRemoveWithRequest_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult = adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(entity, actualRemoveResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"})
  public void testRemoveWithRequest_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualRemoveResult = adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"})
  public void testRemoveWithRequest_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any())).thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"})
  public void testEnsureEntityMarkedAsValidationFailure() {
    // Arrange
    ValidationException e = new ValidationException(new Entity());

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    List<String> globalValidationErrors = e.getEntity().getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"})
  public void testEnsureEntityMarkedAsValidationFailure2() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"})
  public void testEnsureEntityMarkedAsValidationFailure3() {
    // Arrange
    ValidationException e = mock(ValidationException.class);
    when(e.containsCause(Mockito.<Class<Throwable>>any())).thenReturn(true);
    when(e.getEntity()).thenReturn(new Entity());

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(e).containsCause(isA(Class.class));
    verify(e).getEntity();
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"})
  public void testEnsureEntityMarkedAsValidationFailure4() {
    // Arrange
    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");
    ValidationException e = mock(ValidationException.class);
    when(e.containsCause(Mockito.<Class<Throwable>>any())).thenReturn(false);
    when(e.getEntity()).thenReturn(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(e).containsCause(isA(Class.class));
    verify(e).getEntity();
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"})
  public void testEnsureEntityMarkedAsValidationFailure5() {
    // Arrange
    Entity entity = new Entity();
    entity.addGlobalValidationError("An error occurred");
    ValidationException e = mock(ValidationException.class);
    when(e.containsCause(Mockito.<Class<Throwable>>any())).thenReturn(false);
    when(e.getEntity()).thenReturn(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(e).containsCause(isA(Class.class));
    verify(e).getEntity();
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"})
  public void testEnsureEntityMarkedAsValidationFailure_thenCallsAddGlobalValidationError() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(entity).addGlobalValidationError(isNull());
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(eq(true));
  }

  /**
   * Test {@link AdminEntityServiceImpl#fetch(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#fetch(PersistencePackageRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.fetch(PersistencePackageRequest)"})
  public void testFetch_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("admin.default.max.results"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.fetch(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getForeignEntityName(String, String)"})
  public void testGetForeignEntityName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminEntityServiceImpl.getForeignEntityName(null, null));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}.
   * <ul>
   *   <li>When {@code Owning Class}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminEntityServiceImpl.getForeignEntityName(String, String)"})
  public void testGetForeignEntityName_whenOwningClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminEntityServiceImpl.getForeignEntityName("Owning Class", null));
  }

  /**
   * Test {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminEntityServiceImpl.populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)"})
  public void testPopulateParentRecordStructure() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    Entity entity2 = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl.populateParentRecordStructure(persistencePackage, entity2, parentMetadata);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePackage
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.PARENTRECORDSTRUCTURE);
    assertTrue(getResult instanceof ParentRecordStructure);
    assertSame(parentMetadata, ((ParentRecordStructure) getResult).getParentMetadata());
    assertSame(entity2, ((ParentRecordStructure) getResult).getParentRecord());
  }
}
