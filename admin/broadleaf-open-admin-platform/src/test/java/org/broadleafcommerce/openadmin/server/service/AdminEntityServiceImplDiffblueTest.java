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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.CollectionMetadata;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
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
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.mockito.Mockito;

public class AdminEntityServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  public void testGetRecord() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  public void testAddEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getEntityType())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getIdProperty())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getMainEntityName())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getFields())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.findField(Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", entityForm);
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getCustomCriteriaOverride()).thenReturn(new String[]{"Custom Criteria Override"});
    EntityForm entityForm2 = mock(EntityForm.class);
    when(entityForm2.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm2.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm2.getEntityType()).thenReturn("");
    when(entityForm2.getId()).thenReturn("42");
    when(entityForm2.getIdProperty()).thenReturn("Id Property");
    when(entityForm2.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm2.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm2.getFields()).thenReturn(new HashMap<>());
    when(entityForm2.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm2).setId(Mockito.<String>any());
    entityForm2.setId("[");

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> adminEntityServiceImpl.addEntity(entityForm2, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(dynamicEntityFormInfo, atLeast(1)).getCustomCriteriaOverride();
    verify(entityForm2).findField(eq("Id Property"));
    verify(entityForm2, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm2).getDynamicFormInfo(eq("foo"));
    verify(entityForm2).getDynamicForms();
    verify(entityForm2).getEntityType();
    verify(entityForm2, atLeast(1)).getFields();
    verify(entityForm2).getId();
    verify(entityForm2).getIdProperty();
    verify(entityForm).getIdProperty();
    verify(entityForm2).getMainEntityName();
    verify(entityForm2).setId(eq("["));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#updateEntity(EntityForm, String[], List)}
   */
  @Test
  public void testUpdateEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getEntityType())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getIdProperty())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getMainEntityName())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getFields())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.findField(Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", entityForm);
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getCustomCriteriaOverride()).thenReturn(new String[]{"Custom Criteria Override"});
    EntityForm entityForm2 = mock(EntityForm.class);
    when(entityForm2.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm2.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm2.getEntityType()).thenReturn("");
    when(entityForm2.getId()).thenReturn("42");
    when(entityForm2.getIdProperty()).thenReturn("Id Property");
    when(entityForm2.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm2.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm2.getFields()).thenReturn(new HashMap<>());
    when(entityForm2.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm2).setId(Mockito.<String>any());
    entityForm2.setId("[");

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> adminEntityServiceImpl.updateEntity(entityForm2, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(dynamicEntityFormInfo, atLeast(1)).getCustomCriteriaOverride();
    verify(entityForm2).findField(eq("Id Property"));
    verify(entityForm2, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm2).getDynamicFormInfo(eq("foo"));
    verify(entityForm2).getDynamicForms();
    verify(entityForm2).getEntityType();
    verify(entityForm2, atLeast(1)).getFields();
    verify(entityForm2).getId();
    verify(entityForm2).getIdProperty();
    verify(entityForm).getIdProperty();
    verify(entityForm2, atLeast(1)).getMainEntityName();
    verify(entityForm2).setId(eq("["));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  public void testRemoveEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setId(Mockito.<String>any());
    entityForm.setId("[");

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).setId(eq("["));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  public void testRemoveEntity2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setId(Mockito.<String>any());
    entityForm.setId("[");

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
    verify(entityForm).setId(eq("["));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  public void testRemoveEntity3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setId(Mockito.<String>any());
    entityForm.setId("[");

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
    verify(entityForm).setId(eq("["));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    // Act and Assert
    assertTrue(adminEntityServiceImpl.getPropertiesFromEntityForm(new EntityForm()).isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    // Act
    List<Property> actualPropertiesFromEntityForm = adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertTrue(actualPropertiesFromEntityForm.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("foo", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
    assertEquals("foo", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = new EntityForm();

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Entity entity = actualRequestForEntityForm.getEntity();
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("id");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualRequestForEntityForm.getRequestingEntityName());
    assertEquals("id", getResult.getName());
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult2 = fields.get("id");
    assertEquals("id", getResult2.getName());
    assertEquals("id", getResult2.getTranslationFieldName());
    assertEquals("null/null", getResult2.getEntityViewPath());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(getResult2.getOrder());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(actualRequestForEntityForm.getCeilingEntityClassname());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    assertNull(actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertNull(getResult2.getAssociatedFieldName());
    assertNull(getResult2.getColumnWidth());
    assertNull(getResult2.getConfirmEnabledText());
    assertNull(getResult2.getDisplayType());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getFieldComponentRenderer());
    assertNull(getResult2.getFieldType());
    assertNull(getResult2.getForeignKeyClass());
    assertNull(getResult2.getForeignKeyDisplayValueProperty());
    assertNull(getResult2.getForeignKeySectionPath());
    assertNull(getResult2.getFriendlyName());
    assertNull(getResult2.getGridFieldComponentRenderer());
    assertNull(getResult2.getHelp());
    assertNull(getResult2.getHint());
    assertNull(getResult2.getIdOverride());
    assertNull(getResult2.getOnChangeTrigger());
    assertNull(getResult2.getOwningEntityClass());
    assertNull(getResult2.getRawDisplayValue());
    assertNull(getResult2.getTooltip());
    assertNull(getResult2.getValue());
    assertNull(entity.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    Property[] properties = entity.getProperties();
    assertEquals(1, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertFalse(getResult2.getAllowNoValueEnumOption());
    assertFalse(getResult2.getAlternateOrdering());
    assertFalse(getResult2.getCanLinkToExternalEntity());
    assertFalse(getResult2.getContentOverflowAllowed());
    assertFalse(getResult2.getDisabled());
    assertFalse(getResult2.getFilterSortDisabled());
    assertFalse(getResult2.getIsConfirmEnabled());
    assertFalse(getResult2.getIsDerived());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult2.getIsLargeEntry());
    assertFalse(getResult2.getIsTypeaheadEnabled());
    assertFalse(getResult2.getMainEntityLink());
    assertFalse(getResult2.getReadOnly());
    assertFalse(getResult2.getRequired());
    assertFalse(getResult2.getResizeDisabled());
    assertFalse(getResult2.getTranslatable());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertTrue(getResult2.getIsVisible());
    assertTrue(getResult2.getShouldRender());
    assertSame(getResult, properties[0]);
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
    assertArrayEquals(new String[]{null}, entity.getType());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Entity entity = actualRequestForEntityForm.getEntity();
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("id");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualRequestForEntityForm.getRequestingEntityName());
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult2 = fields.get("id");
    assertEquals("42", getResult2.getDisplayValue());
    assertEquals("42", getResult2.getValue());
    assertEquals("id", getResult.getName());
    assertEquals("id", getResult2.getName());
    assertEquals("id", getResult2.getTranslationFieldName());
    assertEquals("null/42", getResult2.getEntityViewPath());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(getResult2.getOrder());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(actualRequestForEntityForm.getCeilingEntityClassname());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    assertNull(actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertNull(getResult2.getAssociatedFieldName());
    assertNull(getResult2.getColumnWidth());
    assertNull(getResult2.getConfirmEnabledText());
    assertNull(getResult2.getDisplayType());
    assertNull(getResult2.getFieldComponentRenderer());
    assertNull(getResult2.getFieldType());
    assertNull(getResult2.getForeignKeyClass());
    assertNull(getResult2.getForeignKeyDisplayValueProperty());
    assertNull(getResult2.getForeignKeySectionPath());
    assertNull(getResult2.getFriendlyName());
    assertNull(getResult2.getGridFieldComponentRenderer());
    assertNull(getResult2.getHelp());
    assertNull(getResult2.getHint());
    assertNull(getResult2.getIdOverride());
    assertNull(getResult2.getOnChangeTrigger());
    assertNull(getResult2.getOwningEntityClass());
    assertNull(getResult2.getRawDisplayValue());
    assertNull(getResult2.getTooltip());
    assertNull(entity.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    Property[] properties = entity.getProperties();
    assertEquals(1, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertFalse(getResult2.getAllowNoValueEnumOption());
    assertFalse(getResult2.getAlternateOrdering());
    assertFalse(getResult2.getCanLinkToExternalEntity());
    assertFalse(getResult2.getContentOverflowAllowed());
    assertFalse(getResult2.getDisabled());
    assertFalse(getResult2.getFilterSortDisabled());
    assertFalse(getResult2.getIsConfirmEnabled());
    assertFalse(getResult2.getIsDerived());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult2.getIsLargeEntry());
    assertFalse(getResult2.getIsTypeaheadEnabled());
    assertFalse(getResult2.getMainEntityLink());
    assertFalse(getResult2.getReadOnly());
    assertFalse(getResult2.getRequired());
    assertFalse(getResult2.getResizeDisabled());
    assertFalse(getResult2.getTranslatable());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertTrue(getResult2.getIsVisible());
    assertTrue(getResult2.getShouldRender());
    assertSame(getResult, properties[0]);
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
    assertArrayEquals(new String[]{null}, entity.getType());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Entity entity = actualRequestForEntityForm.getEntity();
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("id");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualRequestForEntityForm.getRequestingEntityName());
    assertEquals("id", getResult.getName());
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult2 = fields.get("id");
    assertEquals("id", getResult2.getName());
    assertEquals("id", getResult2.getTranslationFieldName());
    assertEquals("null/null", getResult2.getEntityViewPath());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(getResult2.getOrder());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(actualRequestForEntityForm.getCeilingEntityClassname());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    assertNull(actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertNull(getResult2.getAssociatedFieldName());
    assertNull(getResult2.getColumnWidth());
    assertNull(getResult2.getConfirmEnabledText());
    assertNull(getResult2.getDisplayType());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getFieldComponentRenderer());
    assertNull(getResult2.getFieldType());
    assertNull(getResult2.getForeignKeyClass());
    assertNull(getResult2.getForeignKeyDisplayValueProperty());
    assertNull(getResult2.getForeignKeySectionPath());
    assertNull(getResult2.getFriendlyName());
    assertNull(getResult2.getGridFieldComponentRenderer());
    assertNull(getResult2.getHelp());
    assertNull(getResult2.getHint());
    assertNull(getResult2.getIdOverride());
    assertNull(getResult2.getOnChangeTrigger());
    assertNull(getResult2.getOwningEntityClass());
    assertNull(getResult2.getRawDisplayValue());
    assertNull(getResult2.getTooltip());
    assertNull(getResult2.getValue());
    assertNull(entity.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    Property[] properties = entity.getProperties();
    assertEquals(1, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertFalse(getResult2.getAllowNoValueEnumOption());
    assertFalse(getResult2.getAlternateOrdering());
    assertFalse(getResult2.getCanLinkToExternalEntity());
    assertFalse(getResult2.getContentOverflowAllowed());
    assertFalse(getResult2.getDisabled());
    assertFalse(getResult2.getFilterSortDisabled());
    assertFalse(getResult2.getIsConfirmEnabled());
    assertFalse(getResult2.getIsDerived());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult2.getIsLargeEntry());
    assertFalse(getResult2.getIsTypeaheadEnabled());
    assertFalse(getResult2.getMainEntityLink());
    assertFalse(getResult2.getReadOnly());
    assertFalse(getResult2.getRequired());
    assertFalse(getResult2.getResizeDisabled());
    assertFalse(getResult2.getTranslatable());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertTrue(getResult2.getIsVisible());
    assertTrue(getResult2.getShouldRender());
    assertSame(getResult, properties[0]);
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
    assertArrayEquals(new String[]{null}, entity.getType());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Entity entity = actualRequestForEntityForm.getEntity();
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("id");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualRequestForEntityForm.getRequestingEntityName());
    assertEquals("id", getResult.getName());
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult2 = fields.get("id");
    assertEquals("id", getResult2.getName());
    assertEquals("id", getResult2.getTranslationFieldName());
    assertEquals("null/null", getResult2.getEntityViewPath());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(getResult2.getOrder());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(actualRequestForEntityForm.getCeilingEntityClassname());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    assertNull(actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertNull(getResult2.getAssociatedFieldName());
    assertNull(getResult2.getColumnWidth());
    assertNull(getResult2.getConfirmEnabledText());
    assertNull(getResult2.getDisplayType());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getFieldComponentRenderer());
    assertNull(getResult2.getFieldType());
    assertNull(getResult2.getForeignKeyClass());
    assertNull(getResult2.getForeignKeyDisplayValueProperty());
    assertNull(getResult2.getForeignKeySectionPath());
    assertNull(getResult2.getFriendlyName());
    assertNull(getResult2.getGridFieldComponentRenderer());
    assertNull(getResult2.getHelp());
    assertNull(getResult2.getHint());
    assertNull(getResult2.getIdOverride());
    assertNull(getResult2.getOnChangeTrigger());
    assertNull(getResult2.getOwningEntityClass());
    assertNull(getResult2.getRawDisplayValue());
    assertNull(getResult2.getTooltip());
    assertNull(getResult2.getValue());
    assertNull(entity.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    Property[] properties = entity.getProperties();
    assertEquals(1, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertFalse(getResult2.getAllowNoValueEnumOption());
    assertFalse(getResult2.getAlternateOrdering());
    assertFalse(getResult2.getCanLinkToExternalEntity());
    assertFalse(getResult2.getContentOverflowAllowed());
    assertFalse(getResult2.getDisabled());
    assertFalse(getResult2.getFilterSortDisabled());
    assertFalse(getResult2.getIsConfirmEnabled());
    assertFalse(getResult2.getIsDerived());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult2.getIsLargeEntry());
    assertFalse(getResult2.getIsTypeaheadEnabled());
    assertFalse(getResult2.getMainEntityLink());
    assertFalse(getResult2.getReadOnly());
    assertFalse(getResult2.getRequired());
    assertFalse(getResult2.getResizeDisabled());
    assertFalse(getResult2.getTranslatable());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertTrue(getResult2.getIsVisible());
    assertTrue(getResult2.getShouldRender());
    assertSame(getResult, properties[0]);
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
    assertArrayEquals(new String[]{null}, entity.getType());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertNull(entity.getDeployDate());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, entity.getProperties().length);
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
    assertArrayEquals(new String[]{"Entity Type"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertNull(entity.getDeployDate());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, entity.getProperties().length);
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Ceiling Entity Classname"}, entity.getType());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertNull(entity.getDeployDate());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, entity.getProperties().length);
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Ceiling Entity Classname"}, entity.getType());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getCeilingEntityClassname());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertEquals("Id Property", getResult.getName());
    assertEquals("Main Entity Name", actualRequestForEntityForm.getRequestingEntityName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(actualRequestForEntityForm.getPresentationFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(actualRequestForEntityForm.getLowerCount());
    assertNull(actualRequestForEntityForm.getMaxIndex());
    assertNull(actualRequestForEntityForm.getMaxResults());
    assertNull(actualRequestForEntityForm.getPageSize());
    assertNull(actualRequestForEntityForm.getStartIndex());
    assertNull(actualRequestForEntityForm.getUpperCount());
    assertNull(actualRequestForEntityForm.getFirstId());
    assertNull(actualRequestForEntityForm.getFolderId());
    assertNull(actualRequestForEntityForm.getLastId());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(actualRequestForEntityForm.getConfigKey());
    assertNull(actualRequestForEntityForm.getMsg());
    assertNull(actualRequestForEntityForm.getSectionEntityField());
    assertNull(entity.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(actualRequestForEntityForm.getAdornedList());
    assertNull(actualRequestForEntityForm.getForeignKey());
    assertNull(actualRequestForEntityForm.getMapStructure());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertNull(actualRequestForEntityForm.getOperationTypesOverride());
    assertEquals(0, actualRequestForEntityForm.getAdditionalForeignKeys().length);
    assertEquals(0, actualRequestForEntityForm.getFilterAndSortCriteria().length);
    assertEquals(0, actualRequestForEntityForm.getSectionCrumbs().length);
    Property[] properties = entity.getProperties();
    assertEquals(1, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(PersistencePackageRequest.Type.STANDARD, actualRequestForEntityForm.getType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(actualRequestForEntityForm.hasSortCriteria());
    assertFalse(actualRequestForEntityForm.isAddOperationInspect());
    assertFalse(actualRequestForEntityForm.isFolderedLookup());
    assertFalse(actualRequestForEntityForm.isTreeCollection());
    assertFalse(actualRequestForEntityForm.isUpdateLookupType());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualRequestForEntityForm.getSubRequests().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(actualRequestForEntityForm.isValidateUnsubmittedProperties());
    assertSame(getResult, properties[0]);
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualRequestForEntityForm.getCustomCriteria());
    assertArrayEquals(new String[]{"Entity Type"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  public void testGetAdvancedCollectionRecord() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  public void testGetAdvancedCollectionRecord2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  public void testGetAdvancedCollectionRecord3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    OperationTypes operationTypes = new OperationTypes();
    basicCollectionMetadata.setPersistencePerspective(
        new PersistencePerspective(operationTypes, new String[]{"."}, new ForeignKey[]{new ForeignKey()}));
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("Name");
    when(collectionProperty.getMetadata()).thenReturn(basicCollectionMetadata);
    doNothing().when(collectionProperty).setName(Mockito.<String>any());
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
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty, atLeast(1)).getName();
    verify(property).getValue();
    verify(collectionProperty).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  public void testGetAdvancedCollectionRecord4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  public void testGetAdvancedCollectionRecord5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  public void testGetAdvancedCollectionRecord6() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    OperationTypes operationTypes = new OperationTypes();
    basicCollectionMetadata.setPersistencePerspective(
        new PersistencePerspective(operationTypes, new String[]{"."}, new ForeignKey[]{new ForeignKey()}));
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("Name");
    when(collectionProperty.getMetadata()).thenReturn(basicCollectionMetadata);
    doNothing().when(collectionProperty).setName(Mockito.<String>any());
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
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty, atLeast(1)).getName();
    verify(property).getValue();
    verify(collectionProperty).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  public void testGetRecordsForCollection() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  public void testGetRecordsForCollection2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollection3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollection4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollection5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
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
    when(containingEntity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("id");
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    when(collectionProperty.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getProperties();
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty).getName();
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollection6() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
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
    when(property.getName()).thenReturn("Name");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getProperties()).thenReturn(new Property[]{property});

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("id");
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    when(collectionProperty.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getProperties();
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty).getName();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollection7() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getPMap()).thenReturn(new HashMap<>());
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
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getProperties()).thenReturn(new Property[]{property});

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("id");
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    when(collectionProperty.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).getPMap();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getProperties();
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty).getName();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  public void testGetPagedRecordsForCollection() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  public void testGetPagedRecordsForCollection2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateTabInfo(CollectionMetadata, ClassMetadata, String, int)}
   */
  @Test
  public void testUpdateTabInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity2() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity3() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity4() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity5() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity6() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity2() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity3() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity4() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity5() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity6() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity7() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity8() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity9() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity10() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity11() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#updateSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, String, List)}
   */
  @Test
  public void testUpdateSubCollectionEntity12() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("\\.");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new EntityNotFoundException("."));
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property2});
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata,
        field, parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity).findProperty(eq("id"));
    verify(parentEntity).getProperties();
    verify(field).getName();
    verify(property2).getName();
    verify(property).getValue();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getPMap()).thenReturn(new HashMap<>());
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).getPMap();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity6() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity7() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("\\.");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new EntityNotFoundException("."));
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property2});
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata,
        field, parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity).findProperty(eq("id"));
    verify(parentEntity).getProperties();
    verify(field).getName();
    verify(property2).getName();
    verify(property).getValue();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntity8() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getPMap()).thenReturn(new HashMap<>());
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
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).getPMap();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
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
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "Property Name");

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    assertNull(actualContextSpecificRelationshipId);
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
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
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "Property Name");

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
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
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        ".");

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
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
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang.Integer"));
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity, atLeast(1)).getProperties();
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
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
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang.Integer"));
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPMap()).thenReturn(new HashMap<>());
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
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("java.lang");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang.Integer"));
    verify(cmd).getPMap();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPMap()).thenReturn(new HashMap<>());
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
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("java.lang");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property2});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "java.lang");

    // Assert
    verify(cmd).getPMap();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    verify(entity).getProperties();
    verify(property2, atLeast(1)).getName();
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty6() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty7() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty8() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Entity entity = new Entity();
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    Entity entity2 = e.getEntity();
    List<String> globalValidationErrors = entity2.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
    assertSame(entity, entity2);
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

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
   * Method under test:
   * {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  public void testGetForeignEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminEntityServiceImpl()).getForeignEntityName(null, null));
    assertNull((new AdminEntityServiceImpl()).getForeignEntityName("Owning Class", null));
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}
   */
  @Test
  public void testPopulateParentRecordStructure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    Entity entity2 = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    ClassTree polymorphicEntities = new ClassTree();
    parentMetadata.setPolymorphicEntities(polymorphicEntities);
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    parentMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    adminEntityServiceImpl.populateParentRecordStructure(persistencePackage, entity2, parentMetadata);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePackage
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.PARENTRECORDSTRUCTURE);
    assertTrue(getResult instanceof ParentRecordStructure);
    assertEquals(entity, entity2);
    assertSame(tabAndGroupMetadata, parentMetadata.getTabAndGroupMetadata());
    assertSame(parentMetadata, ((ParentRecordStructure) getResult).getParentMetadata());
    assertSame(polymorphicEntities, parentMetadata.getPolymorphicEntities());
    assertSame(entity2, ((ParentRecordStructure) getResult).getParentRecord());
  }

  /**
   * Method under test:
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}
   */
  @Test
  public void testPopulateParentRecordStructure2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    Entity entity = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    ClassTree polymorphicEntities = new ClassTree();
    parentMetadata.setPolymorphicEntities(polymorphicEntities);
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    parentMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    adminEntityServiceImpl.populateParentRecordStructure(persistencePackage, entity, parentMetadata);

    // Assert
    verify(persistencePackage).getPersistencePerspective();
    Map<String, Property> pMap = parentMetadata.getPMap();
    assertEquals(1, pMap.size());
    assertEquals(1, parentMetadata.getProperties().length);
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(pMap.containsKey(null));
    Map<String, TabMetadata> tabAndGroupMetadata2 = parentMetadata.getTabAndGroupMetadata();
    assertTrue(tabAndGroupMetadata2.isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(tabAndGroupMetadata, tabAndGroupMetadata2);
    assertSame(polymorphicEntities, parentMetadata.getPolymorphicEntities());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }
}
