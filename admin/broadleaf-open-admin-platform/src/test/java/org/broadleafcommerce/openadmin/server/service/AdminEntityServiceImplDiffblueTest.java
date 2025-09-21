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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.GroupMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
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
  @InjectMocks private AdminEntityServiceImpl adminEntityServiceImpl;

  @Mock private DynamicEntityService dynamicEntityService;

  @Mock private PersistencePackageFactory persistencePackageFactory;

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"
  })
  public void testGetClassMetadata() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getClassMetadata(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"
  })
  public void testGetClassMetadata2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getClassMetadata(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"
  })
  public void testGetClassMetadata3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    adminEntityServiceImpl.getClassMetadata(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Given {@code Security Ceiling Entity Classname}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"
  })
  public void testGetClassMetadata_givenSecurityCeilingEntityClassname() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getSecurityCeilingEntityClassname())
        .thenReturn("Security Ceiling Entity Classname");
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
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getClassMetadata(PersistencePackageRequest)"
  })
  public void testGetClassMetadata_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

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
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualClassMetadata =
        adminEntityServiceImpl.getClassMetadata(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualClassMetadata);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecords(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecords(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecords(PersistencePackageRequest)"
  })
  public void testGetRecords_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("admin.default.max.results"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getRecords(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType())
        .thenThrow(new EntityNotFoundException("Could not determine ID field for "));

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("."));
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord_givenArrayOfPropertyWithProperty() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@code
   *       UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord_givenBasicFieldMetadataGetFieldTypeReturnUnknown()
      throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link EntityNotFoundException#EntityNotFoundException(String)} with s is {@code
   *       .}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord_givenEntityNotFoundExceptionWithSIsDot() throws ServiceException {
    // Arrange
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenThrow(new EntityNotFoundException("."));

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(request).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord_givenPropertyGetMetadataReturnBasicFieldMetadata()
      throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code .}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord_givenPropertyGetNameReturnDot_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord_givenPropertyMetadataIsAdornedTargetCollectionMetadata()
      throws ServiceException {
    // Arrange
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest,
   * String, ClassMetadata, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)"
  })
  public void testGetRecord_thenThrowIllegalArgumentException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new IllegalArgumentException());

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(request).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());

    DynamicEntityFormInfo dynamicEntityFormInfo = new DynamicEntityFormInfo();
    dynamicEntityFormInfo.setCustomCriteriaOverride(new String[] {"Dynamic Form Info"});

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo("foo");
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) MainEntityName is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_givenEntityFormMainEntityNameIsLeftSquareBracket()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    EntityForm entityForm = new EntityForm();
    entityForm.setMainEntityName("[");

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", entityForm);

    DynamicEntityFormInfo dynamicEntityFormInfo = new DynamicEntityFormInfo();
    dynamicEntityFormInfo.setCustomCriteriaOverride(null);

    EntityForm entityForm2 = mock(EntityForm.class);
    when(entityForm2.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm2.getEntityType()).thenReturn("");
    when(entityForm2.getFields()).thenReturn(new HashMap<>());
    when(entityForm2.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm2.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm2.getId()).thenReturn("42");
    when(entityForm2.getIdProperty()).thenReturn("Id Property");
    when(entityForm2.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm2.getDynamicForms()).thenReturn(stringEntityFormMap);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm2, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm2).findField("Id Property");
    verify(entityForm2, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm2).getDynamicFormInfo("foo");
    verify(entityForm2).getDynamicForms();
    verify(entityForm2).getEntityType();
    verify(entityForm2, atLeast(1)).getFields();
    verify(entityForm2, atLeast(1)).getId();
    verify(entityForm2, atLeast(1)).getIdProperty();
    verify(entityForm2).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link EntityNotFoundException#EntityNotFoundException(String)} with s is {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_givenEntityNotFoundExceptionWithSIsFoo() throws ServiceException {
    // Arrange
    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any()))
        .thenThrow(new EntityNotFoundException("foo"));
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo("foo");
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@code Entity Type}.
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code Entity Type}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_givenEntityType_whenEntityFormGetEntityTypeReturnEntityType()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    PersistenceResponse actualAddEntityResult =
        adminEntityServiceImpl.addEntity(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumb2);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualAddEntityResult.getEntity());
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_givenSectionCrumbOriginalSectionIdentifierIsLeftSquareBracket()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("[");
    sectionCrumb2.setSectionId("[");
    sectionCrumb2.setSectionIdentifier("[");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act
    PersistenceResponse actualAddEntityResult =
        adminEntityServiceImpl.addEntity(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumb3);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualAddEntityResult.getEntity());
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    PersistenceResponse actualAddEntityResult =
        adminEntityServiceImpl.addEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualAddEntityResult.getEntity());
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityForm#getDynamicFormInfo(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_thenCallsGetDynamicFormInfo() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());

    DynamicEntityFormInfo dynamicEntityFormInfo = new DynamicEntityFormInfo();
    dynamicEntityFormInfo.setCustomCriteriaOverride(null);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo("foo");
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm, atLeast(1)).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_thenCallsSetValue() throws ServiceException {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField("Id Property");
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualAddEntityResult =
        adminEntityServiceImpl.addEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(entity, actualAddEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_thenThrowIllegalArgumentException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) Id is {@code 42}.
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} DisplayValue is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_whenEntityFormIdIs42_thenEntityFormFieldsIdDisplayValueIs42()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act
    PersistenceResponse actualAddEntityResult =
        adminEntityServiceImpl.addEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getValue());
    assertEquals("null/42", getResult.getEntityViewPath());
    assertNull(actualAddEntityResult.getEntity());
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} EntityViewPath is {@code
   *       null/null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_whenEntityForm_thenEntityFormFieldsIdEntityViewPathIsNullNull()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualAddEntityResult =
        adminEntityServiceImpl.addEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualAddEntityResult.getEntity());
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} EntityViewPath is {@code
   *       null/null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addEntity(EntityForm, String[], List)"
  })
  public void testAddEntity_whenNull_thenEntityFormFieldsIdEntityViewPathIsNullNull()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualAddEntityResult =
        adminEntityServiceImpl.addEntity(entityForm, null, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualAddEntityResult.getEntity());
    assertSame(persistenceResponse, actualAddEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());

    DynamicEntityFormInfo dynamicEntityFormInfo = new DynamicEntityFormInfo();
    dynamicEntityFormInfo.setCustomCriteriaOverride(new String[] {"Dynamic Form Info"});

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo("foo");
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} (default constructor).
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link CodeField}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_givenCodeField_whenEntityFormFindFieldReturnCodeField()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());

    DynamicEntityFormInfo dynamicEntityFormInfo = new DynamicEntityFormInfo();
    dynamicEntityFormInfo.setCustomCriteriaOverride(null);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new CodeField());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo("foo");
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm, atLeast(1)).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link EntityNotFoundException#EntityNotFoundException(String)} with s is {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_givenEntityNotFoundExceptionWithSIsFoo() throws ServiceException {
    // Arrange
    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", new EntityForm());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfo(Mockito.<String>any()))
        .thenThrow(new EntityNotFoundException("foo"));
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(stringEntityFormMap);

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicFormInfo("foo");
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@code Entity Type}.
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code Entity Type}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_givenEntityType_whenEntityFormGetEntityTypeReturnEntityType()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_givenNull_thenThrowIllegalArgumentException()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getDynamicForms()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getDynamicForms();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm, atLeast(1)).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    PersistenceResponse actualUpdateEntityResult =
        adminEntityServiceImpl.updateEntity(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumb2);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualUpdateEntityResult.getEntity());
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_givenSectionCrumbOriginalSectionIdentifierIsLeftSquareBracket()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("[");
    sectionCrumb2.setSectionId("[");
    sectionCrumb2.setSectionIdentifier("[");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act
    PersistenceResponse actualUpdateEntityResult =
        adminEntityServiceImpl.updateEntity(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumb3);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualUpdateEntityResult.getEntity());
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    PersistenceResponse actualUpdateEntityResult =
        adminEntityServiceImpl.updateEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualUpdateEntityResult.getEntity());
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_thenCallsSetValue() throws ServiceException {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.updateEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField("Id Property");
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualUpdateEntityResult =
        adminEntityServiceImpl.updateEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(entity, actualUpdateEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) Id is {@code 42}.
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} DisplayValue is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_whenEntityFormIdIs42_thenEntityFormFieldsIdDisplayValueIs42()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act
    PersistenceResponse actualUpdateEntityResult =
        adminEntityServiceImpl.updateEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getValue());
    assertEquals("null/42", getResult.getEntityViewPath());
    assertNull(actualUpdateEntityResult.getEntity());
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} EntityViewPath is {@code
   *       null/null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_whenEntityForm_thenEntityFormFieldsIdEntityViewPathIsNullNull()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualUpdateEntityResult =
        adminEntityServiceImpl.updateEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualUpdateEntityResult.getEntity());
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} EntityViewPath is {@code
   *       null/null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateEntity(EntityForm, String[], List)"
  })
  public void testUpdateEntity_whenNull_thenEntityFormFieldsIdEntityViewPathIsNullNull()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualUpdateEntityResult =
        adminEntityServiceImpl.updateEntity(entityForm, null, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualUpdateEntityResult.getEntity());
    assertSame(persistenceResponse, actualUpdateEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.removeEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("["));
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.removeEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_givenEmptyString_whenEntityFormGetEntityTypeReturnEmptyString()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.removeEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@code Entity Type}.
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return {@code Entity Type}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_givenEntityType_whenEntityFormGetEntityTypeReturnEntityType()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new IllegalArgumentException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.removeEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    verify(entityForm).findField("Id Property");
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_givenLeftSquareBracket() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualRemoveEntityResult.getEntity());
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumb2);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualRemoveEntityResult.getEntity());
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_givenSectionCrumbOriginalSectionIdentifierIsLeftSquareBracket()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("[");
    sectionCrumb2.setSectionId("[");
    sectionCrumb2.setSectionIdentifier("[");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumb3);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualRemoveEntityResult.getEntity());
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualRemoveEntityResult.getEntity());
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_thenCallsSetValue() throws ServiceException {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.removeEntity(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField("Id Property");
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(entity, actualRemoveEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) Id is {@code 42}.
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} DisplayValue is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_whenEntityFormIdIs42_thenEntityFormFieldsIdDisplayValueIs42()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getValue());
    assertEquals("null/42", getResult.getEntityViewPath());
    assertNull(actualRemoveEntityResult.getEntity());
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} EntityViewPath is {@code
   *       null/null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_whenEntityForm_thenEntityFormFieldsIdEntityViewPathIsNullNull()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualRemoveEntityResult.getEntity());
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link EntityForm} (default constructor) Fields {@code id} EntityViewPath is {@code
   *       null/null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.removeEntity(EntityForm, String[], List)"
  })
  public void testRemoveEntity_whenNull_thenEntityFormFieldsIdEntityViewPathIsNullNull()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);
    EntityForm entityForm = new EntityForm();

    // Act
    PersistenceResponse actualRemoveEntityResult =
        adminEntityServiceImpl.removeEntity(entityForm, null, new ArrayList<>());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
    assertNull(actualRemoveEntityResult.getEntity());
    assertSame(persistenceResponse, actualRemoveEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminEntityServiceImpl.getPropertiesFromEntityForm(EntityForm)"})
  public void testGetPropertiesFromEntityForm_givenHashMap_thenReturnEmpty() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    // Act
    List<Property> actualPropertiesFromEntityForm =
        adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertTrue(actualPropertiesFromEntityForm.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   *
   * <ul>
   *   <li>Then return first DisplayValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    List<Property> actualPropertiesFromEntityForm =
        adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

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
   *
   * <ul>
   *   <li>Then return first DisplayValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminEntityServiceImpl.getPropertiesFromEntityForm(EntityForm)"})
  public void testGetPropertiesFromEntityForm_thenReturnFirstDisplayValueIsNull() {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    // Act
    List<Property> actualPropertiesFromEntityForm =
        adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

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
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminEntityServiceImpl.getPropertiesFromEntityForm(EntityForm)"})
  public void testGetPropertiesFromEntityForm_whenEntityForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminEntityServiceImpl.getPropertiesFromEntityForm(new EntityForm()).isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

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
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm2() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
    verify(entityForm).putDynamicForm(eq("["), isA(EntityForm.class));
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(1, entity.getProperties().length);
    assertArrayEquals(new String[] {"Ceiling Entity Classname"}, entity.getType());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm3() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("[", new EntityForm());

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
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumbs);

    // Assert
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
    verify(entityForm).putDynamicForm(eq("["), isA(EntityForm.class));
    SectionCrumb[] sectionCrumbs2 = actualRequestForEntityForm.getSectionCrumbs();
    SectionCrumb sectionCrumb3 = sectionCrumbs2[0];
    assertEquals("Original Section Identifier", sectionCrumb3.getOriginalSectionIdentifier());
    assertEquals("Section Id", sectionCrumb3.getSectionId());
    assertEquals("Section Identifier", sectionCrumb3.getSectionIdentifier());
    assertEquals(2, sectionCrumbs2.length);
    assertSame(sectionCrumb, sectionCrumbs2[1]);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@code Entity Type}.
   *   <li>Then return Entity PMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm_givenEntityType_thenReturnEntityPMapEmpty() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField("Id Property");
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    verify(entityForm).putDynamicForm(eq("["), isA(EntityForm.class));
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(0, entity.getProperties().length);
    assertTrue(entity.getPMap().isEmpty());
    assertArrayEquals(new String[] {"Entity Type"}, entity.getType());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm_givenTabMetadata() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

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
   *
   * <ul>
   *   <li>Then return Entity PMap {@code id} DisplayValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm_thenReturnEntityPMapIdDisplayValueIs42() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act and Assert
    Map<String, Property> pMap =
        adminEntityServiceImpl
            .getRequestForEntityForm(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>())
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
   *
   * <ul>
   *   <li>Then return first element OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm_thenReturnFirstElementOriginalSectionIdentifierIs42() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("[", new EntityForm());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(
            entityForm, new String[] {"Custom Criteria"}, sectionCrumbs);

    // Assert
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
    verify(entityForm).putDynamicForm(eq("["), isA(EntityForm.class));
    SectionCrumb[] sectionCrumbs2 = actualRequestForEntityForm.getSectionCrumbs();
    SectionCrumb sectionCrumb2 = sectionCrumbs2[0];
    assertEquals("42", sectionCrumb2.getOriginalSectionIdentifier());
    assertEquals("42", sectionCrumb2.getSectionId());
    assertEquals("42", sectionCrumb2.getSectionIdentifier());
    assertEquals(1, sectionCrumbs2.length);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm_thenThrowEntityNotFoundException() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("[", new EntityForm());

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.getRequestForEntityForm(
                entityForm, new String[] {"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField("Id Property");
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).putDynamicForm(eq("["), isA(EntityForm.class));
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm_whenEntityForm() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(
            entityForm, new String[] {"Custom Criteria"}, new ArrayList<>());

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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm,
   * String[], List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePackageRequest AdminEntityServiceImpl.getRequestForEntityForm(EntityForm, String[], List)"
  })
  public void testGetRequestForEntityForm_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistencePackageRequest actualRequestForEntityForm =
        adminEntityServiceImpl.getRequestForEntityForm(entityForm, null, new ArrayList<>());

    // Assert
    verify(entityForm).findField("Id Property");
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
    verify(entityForm).putDynamicForm(eq("["), isA(EntityForm.class));
    assertEquals(0, actualRequestForEntityForm.getCustomCriteria().length);
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(1, entity.getProperties().length);
    assertArrayEquals(new String[] {"Ceiling Entity Classname"}, entity.getType());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property,
   * String, List, String)} with {@code containingClassMetadata}, {@code containingEntity}, {@code
   * collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata,
   * Entity, Property, String, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)"
  })
  public void
      testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getAdvancedCollectionRecord(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                "42",
                new ArrayList<>(),
                "42"));
    verify(containingEntity).findProperty("id");
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property,
   * String, List, String)} with {@code containingClassMetadata}, {@code containingEntity}, {@code
   * collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs}, {@code alternateId}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata,
   * Entity, Property, String, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)"
  })
  public void
      testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId2()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getAdvancedCollectionRecord(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                "42",
                new ArrayList<>(),
                "42"));
    verify(containingEntity).findProperty("id");
    verify(property).getValue();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property,
   * String, List, String, String[])} with {@code containingClassMetadata}, {@code
   * containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}, {@code customCriteria}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata,
   * Entity, Property, String, List, String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])"
  })
  public void
      testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getAdvancedCollectionRecord(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                "42",
                new ArrayList<>(),
                "42",
                new String[] {"Custom Criteria"}));
    verify(containingEntity).findProperty("id");
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property,
   * String, List, String, String[])} with {@code containingClassMetadata}, {@code
   * containingEntity}, {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}, {@code customCriteria}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata,
   * Entity, Property, String, List, String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])"
  })
  public void
      testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria2()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getAdvancedCollectionRecord(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                "42",
                new ArrayList<>(),
                "42",
                new String[] {"Custom Criteria"}));
    verify(containingEntity).findProperty("id");
    verify(property).getValue();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property,
   * FilterAndSortCriteria[], Integer, Integer, String, List)} with {@code containingClassMetadata},
   * {@code containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code
   * maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)"
  })
  public void
      testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                1,
                1,
                "42",
                new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property,
   * FilterAndSortCriteria[], Integer, Integer, String, List)} with {@code containingClassMetadata},
   * {@code containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code
   * maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)"
  })
  public void
      testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs2()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                1,
                1,
                "42",
                sectionCrumbs));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property,
   * FilterAndSortCriteria[], Integer, Integer, String, List)} with {@code containingClassMetadata},
   * {@code containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code
   * maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)"
  })
  public void
      testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs3()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionId(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                1,
                1,
                "42",
                sectionCrumbs));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property,
   * FilterAndSortCriteria[], Integer, Integer, List)} with {@code containingClassMetadata}, {@code
   * containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code
   * maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)"
  })
  public void
      testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                1,
                1,
                new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property,
   * FilterAndSortCriteria[], Integer, Integer, List)} with {@code containingClassMetadata}, {@code
   * containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code
   * maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)"
  })
  public void
      testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb2()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                1,
                1,
                sectionCrumb2));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property,
   * FilterAndSortCriteria[], Integer, Integer, List)} with {@code containingClassMetadata}, {@code
   * containingEntity}, {@code collectionProperty}, {@code fascs}, {@code startIndex}, {@code
   * maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)"
  })
  public void
      testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb3()
          throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionId(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                1,
                1,
                sectionCrumb3));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity,
   * Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)"
  })
  public void testGetPagedRecordsForCollection() throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionId(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getPagedRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                fetchPageRequest,
                "42",
                sectionCrumbs));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity,
   * Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)"
  })
  public void testGetPagedRecordsForCollection_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getPagedRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                fetchPageRequest,
                "42",
                sectionCrumbs));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity,
   * Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata,
   * Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)"
  })
  public void testGetPagedRecordsForCollection_whenProperty_thenThrowIllegalArgumentException()
      throws ServiceException {
    // Arrange
    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[] {new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.getPagedRecordsForCollection(
                containingClassMetadata,
                containingEntity,
                collectionProperty,
                new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")},
                fetchPageRequest,
                "42",
                new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.getRecordsForAllSubCollections(
                ppr, containingEntity, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb2()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.getRecordsForAllSubCollections(
                ppr, containingEntity, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb3()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, new ArrayList<>());

    // Assert
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb4()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = new Entity();
    containingEntity.setType(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, new ArrayList<>());

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb5()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, new ArrayList<>());

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb6()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    classMetaData2.setProperties(new Property[] {property, new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, new ArrayList<>());

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb7()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(ppr, containingEntity, sectionCrumb2);

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, List)} with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)"
  })
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb8()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

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
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(ppr, containingEntity, sectionCrumb3);

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.getRecordsForAllSubCollections(
                ppr, containingEntity, 1, 1, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb2()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.getRecordsForAllSubCollections(
                ppr, containingEntity, 1, 1, new ArrayList<>()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb3()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, 1, 1, new ArrayList<>());

    // Assert
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getSecurityCeilingEntityClassname();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    verify(persistenceResponse, atLeast(1)).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertTrue(actualRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb4()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = new Entity();
    containingEntity.setType(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, 1, 1, new ArrayList<>());

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb5()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, 1, 1, new ArrayList<>());

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb6()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    classMetaData2.setProperties(new Property[] {property, new Property()});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, 1, 1, new ArrayList<>());

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb7()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, 1, 1, sectionCrumb2);

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest,
   * Entity, Integer, Integer, List)} with {@code ppr}, {@code containingEntity}, {@code
   * startIndex}, {@code maxIndex}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity,
   * Integer, Integer, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)"
  })
  public void
      testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb8()
          throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata classMetaData2 = new ClassMetadata();
    classMetaData2.setCeilingType("Type");
    classMetaData2.setCurrencyCode("GBP");
    classMetaData2.setPolymorphicEntities(new ClassTree());
    classMetaData2.setProperties(new Property[] {property});
    classMetaData2.setSecurityCeilingType("Security Ceiling Type");
    classMetaData2.setTabAndGroupMetadata(new HashMap<>());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet())
        .thenReturn(new DynamicResultSet(classMetaData2));
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

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
    Map<String, DynamicResultSet> actualRecordsForAllSubCollections =
        adminEntityServiceImpl.getRecordsForAllSubCollections(
            ppr, containingEntity, 1, 1, sectionCrumb3);

    // Assert
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
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List,
   * String)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata,
   * Entity, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"
  })
  public void testGetRecordsForSelectedTab() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

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
    Map<String, DynamicResultSet> actualRecordsForSelectedTab =
        adminEntityServiceImpl.getRecordsForSelectedTab(
            cmd, containingEntity, sectionCrumb3, "Current Tab Name");

    // Assert
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List,
   * String)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()} and {@link
   *       Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata,
   * Entity, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"
  })
  public void testGetRecordsForSelectedTab_givenArrayOfPropertyWithPropertyAndProperty()
      throws ServiceException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    cmd.setProperties(new Property[] {property, new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab =
        adminEntityServiceImpl.getRecordsForSelectedTab(
            cmd, containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(containingEntity, atLeast(1)).getType();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List,
   * String)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Property}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata,
   * Entity, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"
  })
  public void testGetRecordsForSelectedTab_givenEmptyArrayOfProperty() throws ServiceException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();

    // Act and Assert
    assertTrue(
        adminEntityServiceImpl
            .getRecordsForSelectedTab(cmd, containingEntity, new ArrayList<>(), "Current Tab Name")
            .isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata,
   * Entity, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"
  })
  public void testGetRecordsForSelectedTab_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab =
        adminEntityServiceImpl.getRecordsForSelectedTab(
            cmd, containingEntity, sectionCrumb2, "Current Tab Name");

    // Assert
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata,
   * Entity, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"
  })
  public void testGetRecordsForSelectedTab_thenCallsGetType() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab =
        adminEntityServiceImpl.getRecordsForSelectedTab(
            cmd, containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List,
   * String)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       Type}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata,
   * Entity, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getRecordsForSelectedTab(ClassMetadata, Entity, List, String)"
  })
  public void testGetRecordsForSelectedTab_whenEntityTypeIsArrayOfStringWithType()
      throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = new Entity();
    containingEntity.setType(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab =
        adminEntityServiceImpl.getRecordsForSelectedTab(
            cmd, containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata, ClassMetadata, String,
   * int)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Tab Name} is {@link TabMetadata}.
   *   <li>Then calls {@link TabMetadata#getTabOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata,
   * ClassMetadata, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.updateTabInfo(CollectionMetadata, ClassMetadata, String, int)"
  })
  public void testUpdateTabInfo_givenHashMapTabNameIsTabMetadata_thenCallsGetTabOrder() {
    // Arrange
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    groupMetadata.put("foo", new GroupMetadata());

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabOrder()).thenReturn(1);
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());
    when(tabMetadata.getTabName()).thenReturn("Tab Name");
    doNothing().when(tabMetadata).setGroupMetadata(Mockito.<Map<String, GroupMetadata>>any());
    tabMetadata.setGroupMetadata(groupMetadata);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("Tab Name", tabMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    adminEntityServiceImpl.updateTabInfo(fmd, cmd, "Tab Name", 1);

    // Assert
    verify(tabMetadata).getGroupMetadata();
    verify(tabMetadata).getTabName();
    verify(tabMetadata).getTabOrder();
    verify(tabMetadata).setGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata, ClassMetadata, String,
   * int)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} {@link TabMetadata#getTabName()} return {@code foo}.
   *   <li>Then calls {@link TabMetadata#getGroupMetadata()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata,
   * ClassMetadata, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.updateTabInfo(CollectionMetadata, ClassMetadata, String, int)"
  })
  public void testUpdateTabInfo_givenTabMetadataGetTabNameReturnFoo_thenCallsGetGroupMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    groupMetadata.put("foo", new GroupMetadata());

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());
    when(tabMetadata.getTabName()).thenReturn("foo");
    doNothing().when(tabMetadata).setGroupMetadata(Mockito.<Map<String, GroupMetadata>>any());
    tabMetadata.setGroupMetadata(groupMetadata);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    adminEntityServiceImpl.updateTabInfo(fmd, cmd, "Tab Name", 1);

    // Assert
    verify(tabMetadata).getGroupMetadata();
    verify(tabMetadata).getTabName();
    verify(tabMetadata).setGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata, ClassMetadata, String,
   * int)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} {@link TabMetadata#getTabOrder()} return one.
   *   <li>Then calls {@link TabMetadata#getTabOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata,
   * ClassMetadata, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.updateTabInfo(CollectionMetadata, ClassMetadata, String, int)"
  })
  public void testUpdateTabInfo_givenTabMetadataGetTabOrderReturnOne_thenCallsGetTabOrder() {
    // Arrange
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    groupMetadata.put("foo", new GroupMetadata());

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabOrder()).thenReturn(1);
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());
    when(tabMetadata.getTabName()).thenReturn("Tab Name");
    doNothing().when(tabMetadata).setGroupMetadata(Mockito.<Map<String, GroupMetadata>>any());
    tabMetadata.setGroupMetadata(groupMetadata);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    adminEntityServiceImpl.updateTabInfo(fmd, cmd, "Tab Name", 1);

    // Assert
    verify(tabMetadata).getGroupMetadata();
    verify(tabMetadata, atLeast(1)).getTabName();
    verify(tabMetadata).getTabOrder();
    verify(tabMetadata).setGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata, ClassMetadata, String,
   * int)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata,
   * ClassMetadata, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.updateTabInfo(CollectionMetadata, ClassMetadata, String, int)"
  })
  public void testUpdateTabInfo_thenThrowEntityNotFoundException() {
    // Arrange
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    HashMap<String, GroupMetadata> groupMetadata = new HashMap<>();
    groupMetadata.put("foo", new GroupMetadata());

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabOrder()).thenThrow(new EntityNotFoundException("foo"));
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());
    when(tabMetadata.getTabName()).thenReturn("Tab Name");
    doNothing().when(tabMetadata).setGroupMetadata(Mockito.<Map<String, GroupMetadata>>any());
    tabMetadata.setGroupMetadata(groupMetadata);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("foo", tabMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.updateTabInfo(fmd, cmd, "Tab Name", 1));
    verify(tabMetadata).getGroupMetadata();
    verify(tabMetadata, atLeast(1)).getTabName();
    verify(tabMetadata).getTabOrder();
    verify(tabMetadata).setGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity,
   * List)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"
  })
  public void testGetAllRecordsForAllSubCollections() throws ServiceException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    cmd.setProperties(new Property[] {property, new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections =
        adminEntityServiceImpl.getAllRecordsForAllSubCollections(
            cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(containingEntity, atLeast(1)).getType();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity,
   * List)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"
  })
  public void testGetAllRecordsForAllSubCollections2() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections =
        adminEntityServiceImpl.getAllRecordsForAllSubCollections(
            cmd, containingEntity, sectionCrumb2);

    // Assert
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity,
   * List)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"
  })
  public void testGetAllRecordsForAllSubCollections3() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

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
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections =
        adminEntityServiceImpl.getAllRecordsForAllSubCollections(
            cmd, containingEntity, sectionCrumb3);

    // Assert
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity,
   * List)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Property}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"
  })
  public void testGetAllRecordsForAllSubCollections_givenEmptyArrayOfProperty()
      throws ServiceException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();

    // Act and Assert
    assertTrue(
        adminEntityServiceImpl
            .getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"
  })
  public void testGetAllRecordsForAllSubCollections_thenCallsGetType() throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections =
        adminEntityServiceImpl.getAllRecordsForAllSubCollections(
            cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity,
   * List)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminEntityServiceImpl.getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)"
  })
  public void testGetAllRecordsForAllSubCollections_whenEntityTypeIsArrayOfStringWithType()
      throws ServiceException {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity containingEntity = new Entity();
    containingEntity.setType(new String[] {"Type"});

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections =
        adminEntityServiceImpl.getAllRecordsForAllSubCollections(
            cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity() throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity2() throws ClassNotFoundException, ServiceException {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put(
        "The specified field [%s] for class [%s] was not a collection field.", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity3() throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionId(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, sectionCrumbs));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity4() throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("."));

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(null);

    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity5() throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("."));

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(null);

    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code .} is {@link Field} (default constructor).
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity_givenHashMapDotIsField_thenReturnPersistenceResponse()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put(".", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(null);

    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualAddSubCollectionEntityResult =
        adminEntityServiceImpl.addSubCollectionEntity(
            entityForm, mainMetadata, field, parentEntity, new ArrayList<>());

    // Assert
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
    assertSame(persistenceResponse, actualAddSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, sectionCrumbs));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity_givenTabMetadata()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity_thenReturnEntityIsEntity()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(null);

    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualAddSubCollectionEntityResult =
        adminEntityServiceImpl.addSubCollectionEntity(
            entityForm, mainMetadata, field, parentEntity, new ArrayList<>());

    // Assert
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
    assertSame(entity, actualAddSubCollectionEntityResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity_thenReturnPersistenceResponse()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(null);

    Property field = mock(Property.class);
    when(field.getName()).thenReturn(".");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    Entity parentEntity = new Entity();

    // Act
    PersistenceResponse actualAddSubCollectionEntityResult =
        adminEntityServiceImpl.addSubCollectionEntity(
            entityForm, mainMetadata, field, parentEntity, new ArrayList<>());

    // Assert
    verify(field).getMetadata();
    verify(field).getName();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
    assertSame(persistenceResponse, actualAddSubCollectionEntityResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity_whenEntityForm_thenThrowIllegalArgumentException()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property,
   * Entity, List)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)"
  })
  public void testAddSubCollectionEntity_whenProperty_thenThrowIllegalArgumentException()
      throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.addSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code
   * field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code
   * sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code
   * field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code
   * sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs2()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code
   * field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code
   * sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs3()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code
   * field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code
   * sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs4()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code
   * field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code
   * sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs5()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put(
        "The specified field [%s] for class [%s] was not a collection field.", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code
   * field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code
   * sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs6()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", "42", sectionCrumbs));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code
   * field}, {@code parentEntity}, {@code collectionItemId}, {@code alternateId}, {@code
   * sectionCrumbs}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdAlternateIdSectionCrumbs7()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionId(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", "42", sectionCrumbs));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field},
   * {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field},
   * {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb2()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field},
   * {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb3()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>()));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field},
   * {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb4()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field},
   * {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb5()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put(
        "The specified field [%s] for class [%s] was not a collection field.", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field},
   * {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb6()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", sectionCrumb2));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata,
   * Property, Entity, String, List)} with {@code entityForm}, {@code mainMetadata}, {@code field},
   * {@code parentEntity}, {@code collectionItemId}, {@code sectionCrumb}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm,
   * ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)"
  })
  public void
      testUpdateSubCollectionEntityWithEntityFormMainMetadataFieldParentEntityCollectionItemIdSectionCrumb7()
          throws ClassNotFoundException, ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm(
        "The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[] {new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionId(
        "The specified field [%s] for class [%s] was not a collection field.");
    sectionCrumb2.setSectionIdentifier(
        "The specified field [%s] for class [%s] was not a collection field.");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            adminEntityServiceImpl.updateSubCollectionEntity(
                entityForm, mainMetadata, field, parentEntity, "42", sectionCrumb3));
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm)
        .putDynamicForm(
            eq("The specified field [%s] for class [%s] was not a collection field."),
            isA(EntityForm.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity,
   * String)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"
  })
  public void testGetContextSpecificRelationshipId() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property(".", "42")});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminEntityServiceImpl.getContextSpecificRelationshipId(
                cmd, entity, "java.lang.Integer"));
    verify(entity, atLeast(1)).getProperties();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code java.lang}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"
  })
  public void testGetContextSpecificRelationshipId_givenPropertyGetNameReturnJavaLang() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("java.lang");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminEntityServiceImpl.getContextSpecificRelationshipId(
                cmd, entity, "java.lang.Integer"));
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"
  })
  public void testGetContextSpecificRelationshipId_givenPropertyGetNameReturnName() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminEntityServiceImpl.getContextSpecificRelationshipId(
                cmd, entity, "java.lang.Integer"));
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>When {@code java.lang}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"
  })
  public void testGetContextSpecificRelationshipId_givenPropertyGetNameReturnName_whenJavaLang() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property2});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId =
        adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang");

    // Assert
    verify(entity).findProperty("id");
    verify(entity).getProperties();
    verify(property2).getName();
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"
  })
  public void testGetContextSpecificRelationshipId_givenProperty_thenReturnNull() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    String actualContextSpecificRelationshipId =
        adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "Property Name");

    // Assert
    verify(entity).findProperty("id");
    assertNull(actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity,
   * String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"
  })
  public void testGetContextSpecificRelationshipId_whenDot_thenReturn42() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId =
        adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, ".");

    // Assert
    verify(entity).findProperty("id");
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Property Name}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminEntityServiceImpl.getContextSpecificRelationshipId(ClassMetadata, Entity, String)"
  })
  public void testGetContextSpecificRelationshipId_whenPropertyName_thenReturn42() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId =
        adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "Property Name");

    // Assert
    verify(entity).findProperty("id");
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenArrayOfPropertyWithProperty() throws ServiceException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@code
   *       UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenBasicFieldMetadataGetFieldTypeReturnUnknown()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyGetMetadataReturnBasicFieldMetadata()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code .}.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyGetNameReturnDot_thenCallsGetName()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyGetNameReturnName_thenReturnName()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualIdProperty = adminEntityServiceImpl.getIdProperty(cmd);

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    assertEquals("Name", actualIdProperty);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_givenPropertyMetadataIsAdornedTargetCollectionMetadata()
      throws ServiceException {
    // Arrange
    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getIdProperty(ClassMetadata)"})
  public void testGetIdProperty_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType())
        .thenThrow(new EntityNotFoundException("Could not determine ID field for "));

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.add(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.add(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    // Act
    PersistenceResponse actualAddResult =
        adminEntityServiceImpl.add(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Entity entity = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

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
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest5() throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistencePackage);

    Entity entity2 = mock(Entity.class);
    when(entity2.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity2));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(entity2).isValidationFailure();
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualAddResult.getDynamicResultSet());
    assertTrue(actualAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.add(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.add(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    // Act
    PersistenceResponse actualAddResult =
        adminEntityServiceImpl.add(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    Entity entity = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

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
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional5() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request, true));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional6() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Entity entity = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional7() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Entity entity2 = actualAddResult.getEntity();
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("An error occurred", getResult.get(0));
    assertTrue(entity2.getGlobalValidationErrors().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional8() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addGlobalValidationError("An error occurred");
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Entity entity2 = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity2.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertEquals("An error occurred", globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity2.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional9() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, false);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional10() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request, false));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional11() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, false);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    Entity entity = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional12() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalAdd(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(false);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, false);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalAdd(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional13() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalAdd(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(false);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.add(request, false));
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalAdd(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional14() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalAdd(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(false);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, false);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalAdd(isA(PersistencePackage.class));
    Entity entity = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional_givenEntityIsValidationFailureReturnTrue()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(entity).isValidationFailure();
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualAddResult.getDynamicResultSet());
    assertTrue(actualAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

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
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityService#add(PersistencePackage)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional_thenCallsAdd() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualAddResult =
        adminEntityServiceImpl.add(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityService#add(PersistencePackage)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional_thenCallsAdd2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(false);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest, boolean)"
  })
  public void testAddWithRequestTransactional_thenCallsAddGlobalValidationError()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request, true);

    // Assert
    verify(entity).addGlobalValidationError(null);
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(true);
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualAddResult.getDynamicResultSet());
    assertTrue(actualAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityService} {@link
   *       DynamicEntityService#update(PersistencePackage)} return {@link PersistenceResponse}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_givenDynamicEntityServiceUpdateReturnPersistenceResponse()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

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
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_givenEntityIsValidationFailureReturnTrue()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(entity).isValidationFailure();
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualAddResult.getDynamicResultSet());
    assertTrue(actualAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_givenFalse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(false);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) SectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_givenSectionCrumbSectionIdentifierIs42() throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistencePackage);
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

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
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) SectionIdentifier is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_givenSectionCrumbSectionIdentifierIsEmptyString()
      throws ServiceException {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("");
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {sectionCrumb});
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistencePackage);

    Entity entity2 = mock(Entity.class);
    when(entity2.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity2));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(entity2).isValidationFailure();
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualAddResult.getDynamicResultSet());
    assertTrue(actualAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_thenCallsAddGlobalValidationError() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(entity).addGlobalValidationError(null);
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(true);
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualAddResult.getDynamicResultSet());
    assertTrue(actualAddResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return Entity GlobalValidationErrors first is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_thenReturnEntityGlobalValidationErrorsFirstIsAnErrorOccurred()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addGlobalValidationError("An error occurred");
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Entity entity2 = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity2.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertEquals("An error occurred", globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity2.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return Entity GlobalValidationErrors first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_thenReturnEntityGlobalValidationErrorsFirstIsNull()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Entity entity = actualAddResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return Entity PropertyValidationErrors size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_thenReturnEntityPropertyValidationErrorsSizeIsOne()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isUpdateLookupType()).thenReturn(true);

    // Act
    PersistenceResponse actualAddResult = adminEntityServiceImpl.add(request);

    // Assert
    verify(request).isUpdateLookupType();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Entity entity2 = actualAddResult.getEntity();
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("An error occurred", getResult.get(0));
    assertTrue(entity2.getGlobalValidationErrors().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.add(PersistencePackageRequest)"})
  public void testAddWithRequest_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.add(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualAddResult =
        adminEntityServiceImpl.add(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).add(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualAddResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"
  })
  public void testUpdateWithRequest() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"
  })
  public void testUpdateWithRequest2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualUpdateResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    Entity entity = actualUpdateResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional5() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualUpdateResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional6() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), false));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional7() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    Entity entity = actualUpdateResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional8() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    Entity entity2 = actualUpdateResult.getEntity();
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("An error occurred", getResult.get(0));
    assertTrue(entity2.getGlobalValidationErrors().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional9() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addGlobalValidationError("An error occurred");
    when(dynamicEntityService.nonTransactionalUpdate(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalUpdate(isA(PersistencePackage.class));
    Entity entity2 = actualUpdateResult.getEntity();
    List<String> globalValidationErrors = entity2.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertEquals("An error occurred", globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity2.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional_givenEntityIsValidationFailureReturnTrue()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(entity).isValidationFailure();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualUpdateResult.getDynamicResultSet());
    assertTrue(actualUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest, boolean)"
  })
  public void testUpdateWithRequestTransactional_thenCallsAddGlobalValidationError()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(entity).addGlobalValidationError(null);
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(true);
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualUpdateResult.getDynamicResultSet());
    assertTrue(actualUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"
  })
  public void testUpdateWithRequest_givenEntityIsValidationFailureReturnTrue()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualUpdateResult.getDynamicResultSet());
    assertTrue(actualUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"
  })
  public void testUpdateWithRequest_thenCallsAddGlobalValidationError() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).addGlobalValidationError(null);
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(true);
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertNull(actualUpdateResult.getDynamicResultSet());
    assertTrue(actualUpdateResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"
  })
  public void testUpdateWithRequest_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(entity, actualUpdateResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#update(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#update(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.update(PersistencePackageRequest)"
  })
  public void testUpdateWithRequest_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.update(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualUpdateResult =
        adminEntityServiceImpl.update(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).update(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualUpdateResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.inspect(PersistencePackageRequest)"
  })
  public void testInspect() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.inspect(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.inspect(PersistencePackageRequest)"
  })
  public void testInspect2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.inspect(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.inspect(PersistencePackageRequest)"
  })
  public void testInspect_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.inspect(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualInspectResult =
        adminEntityServiceImpl.inspect(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).inspect(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualInspectResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"
  })
  public void testRemoveWithRequest() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"
  })
  public void testRemoveWithRequest2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional2() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional3() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional4() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    Entity entity = actualRemoveResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional5() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.nonTransactionalRemove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalRemove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional6() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalRemove(Mockito.<PersistencePackage>any()))
        .thenThrow(new EntityNotFoundException("foo"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), false));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalRemove(isA(PersistencePackage.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional7() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    when(dynamicEntityService.nonTransactionalRemove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(new Entity()));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalRemove(isA(PersistencePackage.class));
    Entity entity = actualRemoveResult.getEntity();
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional8() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");
    when(dynamicEntityService.nonTransactionalRemove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalRemove(isA(PersistencePackage.class));
    Entity entity2 = actualRemoveResult.getEntity();
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("An error occurred", getResult.get(0));
    assertTrue(entity2.getGlobalValidationErrors().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional9() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = new Entity();
    entity.addGlobalValidationError("An error occurred");
    when(dynamicEntityService.nonTransactionalRemove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), false);

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).nonTransactionalRemove(isA(PersistencePackage.class));
    Entity entity2 = actualRemoveResult.getEntity();
    List<String> globalValidationErrors = entity2.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertEquals("An error occurred", globalValidationErrors.get(0));
    Map<String, List<String>> propertyValidationErrors = entity2.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity2.getValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional_givenEntityIsValidationFailureReturnTrue()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(entity).isValidationFailure();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertNull(actualRemoveResult.getDynamicResultSet());
    assertTrue(actualRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)} with {@code
   * request}, {@code transactional}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest, boolean)"
  })
  public void testRemoveWithRequestTransactional_thenCallsAddGlobalValidationError()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned(), true);

    // Assert
    verify(entity).addGlobalValidationError(null);
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(true);
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertNull(actualRemoveResult.getDynamicResultSet());
    assertTrue(actualRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#isValidationFailure()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"
  })
  public void testRemoveWithRequest_givenEntityIsValidationFailureReturnTrue()
      throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertNull(actualRemoveResult.getDynamicResultSet());
    assertTrue(actualRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"
  })
  public void testRemoveWithRequest_thenCallsAddGlobalValidationError() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(entity).addGlobalValidationError(null);
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(true);
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertNull(actualRemoveResult.getDynamicResultSet());
    assertTrue(actualRemoveResult.getAdditionalData().isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return Entity is {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"
  })
  public void testRemoveWithRequest_thenReturnEntityIsEntity() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    Entity entity = new Entity();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenThrow(new ValidationException(entity));

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(entity, actualRemoveResult.getEntity());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with {@code request}.
   *
   * <ul>
   *   <li>Then return {@link PersistenceResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistenceResponse AdminEntityServiceImpl.remove(PersistencePackageRequest)"
  })
  public void testRemoveWithRequest_thenReturnPersistenceResponse() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistencePackage());
    PersistenceResponse persistenceResponse = new PersistenceResponse();
    when(dynamicEntityService.remove(Mockito.<PersistencePackage>any()))
        .thenReturn(persistenceResponse);

    // Act
    PersistenceResponse actualRemoveResult =
        adminEntityServiceImpl.remove(PersistencePackageRequest.adorned());

    // Assert
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
    verify(dynamicEntityService).remove(isA(PersistencePackage.class));
    assertSame(persistenceResponse, actualRemoveResult);
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"
  })
  public void testEnsureEntityMarkedAsValidationFailure() {
    // Arrange
    ValidationException e = new ValidationException(new Entity());

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(
        e, PersistencePackageRequest.adorned());

    // Assert
    List<String> globalValidationErrors = e.getEntity().getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"
  })
  public void testEnsureEntityMarkedAsValidationFailure2() {
    // Arrange
    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(null);
    ArrayList<String> globalValidationErrors = new ArrayList<>();
    entity.setGlobalValidationErrors(globalValidationErrors);

    ValidationException e = new ValidationException(new Entity());
    e.setEntity(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(
        e, PersistencePackageRequest.adorned());

    // Assert
    List<String> globalValidationErrors2 = e.getEntity().getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors2.size());
    assertNull(globalValidationErrors2.get(0));
    assertSame(globalValidationErrors, globalValidationErrors2);
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"
  })
  public void testEnsureEntityMarkedAsValidationFailure3() {
    // Arrange
    ArrayList<String> globalValidationErrors = new ArrayList<>();
    globalValidationErrors.add("foo");

    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(null);
    entity.setGlobalValidationErrors(globalValidationErrors);

    ValidationException e = new ValidationException(new Entity());
    e.setEntity(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(
        e, PersistencePackageRequest.adorned());

    // Assert that nothing has changed
    List<String> globalValidationErrors2 = e.getEntity().getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors2.size());
    assertEquals("foo", globalValidationErrors2.get(0));
    assertSame(globalValidationErrors, globalValidationErrors2);
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"
  })
  public void testEnsureEntityMarkedAsValidationFailure4() {
    // Arrange
    Entity entity = new Entity();
    entity.setValidationFailure(true);
    entity.setPropertyValidationErrors(null);
    entity.setGlobalValidationErrors(null);

    ValidationException e = new ValidationException(new Entity());
    e.setEntity(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(
        e, PersistencePackageRequest.adorned());

    // Assert that nothing has changed
    assertNull(e.getEntity().getGlobalValidationErrors());
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"
  })
  public void testEnsureEntityMarkedAsValidationFailure_givenTrue() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(
        e, PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
  }

  /**
   * Test {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException,
   * PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)"
  })
  public void testEnsureEntityMarkedAsValidationFailure_thenCallsAddGlobalValidationError() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(
        e, PersistencePackageRequest.adorned());

    // Assert
    verify(entity).addGlobalValidationError(null);
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(true);
  }

  /**
   * Test {@link AdminEntityServiceImpl#fetch(PersistencePackageRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#fetch(PersistencePackageRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceResponse AdminEntityServiceImpl.fetch(PersistencePackageRequest)"})
  public void testFetch_thenThrowEntityNotFoundException() throws ServiceException {
    // Arrange
    when(persistencePackageFactory.create(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new EntityNotFoundException("admin.default.max.results"));

    // Act and Assert
    assertThrows(
        EntityNotFoundException.class,
        () -> adminEntityServiceImpl.fetch(PersistencePackageRequest.adorned()));
    verify(persistencePackageFactory).create(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getForeignEntityName(String, String)"})
  public void testGetForeignEntityName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminEntityServiceImpl.getForeignEntityName(null, null));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}.
   *
   * <ul>
   *   <li>When {@code Owning Class}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminEntityServiceImpl.getForeignEntityName(String, String)"})
  public void testGetForeignEntityName_whenOwningClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminEntityServiceImpl.getForeignEntityName("Owning Class", null));
  }

  /**
   * Test {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminEntityServiceImpl.populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)"
  })
  public void testPopulateParentRecordStructure() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.PARENTRECORDSTRUCTURE, new AdornedTargetList());
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", new Entity(), persistencePerspective, customCriteria, "ABC123");
    Entity entity = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl.populateParentRecordStructure(
        persistencePackage, entity, parentMetadata);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 =
        persistencePackage.getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult =
        persistencePerspectiveItems2.get(PersistencePerspectiveItemType.PARENTRECORDSTRUCTURE);
    assertTrue(getResult instanceof ParentRecordStructure);
    assertSame(parentMetadata, ((ParentRecordStructure) getResult).getParentMetadata());
    assertSame(entity, ((ParentRecordStructure) getResult).getParentRecord());
  }
}
