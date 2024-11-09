/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.ComboField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormAction;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldDTO;
import org.junit.Test;
import org.mockito.Mockito;

public class FormBuilderServiceImplDiffblueTest {
  /**
   * Test
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getName()}
   * return {@code Name}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid_givenBasicFieldMetadataGetNameReturnName_thenCallsGetName()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getName()).thenReturn("Name");
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("id"));
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
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
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getName();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
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
   * Test
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getIsFilter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid_thenCallsGetIsFilter() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFriendlyName()).thenThrow(new NumberFormatException("id"));
    when(basicFieldMetadata.getIsFilter()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(false);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
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
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getIsFilter();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getVisibility()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid_thenCallsGetVisibility() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("id"));
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Property property = mock(Property.class);
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
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
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
   * Test
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid_thenThrowRuntimeException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getName()).thenThrow(new RuntimeException("id"));
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
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
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getName();
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
   * Test
   * {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <ul>
   *   <li>Given {@link FieldDTO} {@link FieldDTO#setId(String)} does nothing.</li>
   *   <li>Then calls {@link FieldDTO#setId(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  public void testGetTranslationSearchField_givenFieldDTOSetIdDoesNothing_thenCallsSetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    FieldDTO fieldDTO = mock(FieldDTO.class);
    doNothing().when(fieldDTO).setId(Mockito.<String>any());
    doNothing().when(fieldDTO).setInput(Mockito.<String>any());
    doNothing().when(fieldDTO).setLabel(Mockito.<String>any());
    doNothing().when(fieldDTO).setOperators(Mockito.<String>any());
    doNothing().when(fieldDTO).setSelectizeSectionKey(Mockito.<String>any());
    doNothing().when(fieldDTO).setType(Mockito.<String>any());
    doNothing().when(fieldDTO).setValues(Mockito.<String>any());
    fieldDTO.setId("42");
    fieldDTO.setInput("Input");
    fieldDTO.setLabel("Label");
    fieldDTO.setOperators("Operators");
    fieldDTO.setSelectizeSectionKey("Selectize Section Key");
    fieldDTO.setType("Type");
    fieldDTO.setValues("42");

    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();
    defaultWrapperFields.add(fieldDTO);

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert that nothing has changed
    verify(fieldDTO).setId(eq("42"));
    verify(fieldDTO).setInput(eq("Input"));
    verify(fieldDTO).setLabel(eq("Label"));
    verify(fieldDTO).setOperators(eq("Operators"));
    verify(fieldDTO).setSelectizeSectionKey(eq("Selectize Section Key"));
    verify(fieldDTO).setType(eq("Type"));
    verify(fieldDTO).setValues(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("BOOLEAN");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Boolean", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code DECIMAL}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is
   * {@code DECIMAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData_givenDecimal_whenFieldFieldTypeIsDecimal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("DECIMAL");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Field Type}.</li>
   *   <li>Then return Label is {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData_givenFieldType_thenReturnLabelIsFriendlyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("Field Type");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals("blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code MONEY}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is {@code MONEY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData_givenMoney_whenFieldFieldTypeIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("MONEY");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code NUMBER}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is
   * {@code NUMBER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData_givenNumber_whenFieldFieldTypeIsNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("NUMBER");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code STRING}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is
   * {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData_givenString_whenFieldFieldTypeIsString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("STRING");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return Operators is {@code blcFilterOperators_Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData_thenReturnOperatorsIsBlcFilterOperatorsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("DATE");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Date", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName("");
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return FieldType is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField_thenReturnFieldTypeIsUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("UNKNOWN", actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return FriendlyName is {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField_thenReturnFriendlyNameIsFmd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName("Fmd");
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("Fmd", actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return OwningEntityClass is {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField_thenReturnOwningEntityClassIsFmd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("Fmd", actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FriendlyName is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField_whenBasicFieldMetadataFriendlyNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return FriendlyName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField_whenBasicFieldMetadata_thenReturnFriendlyNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = mock(Property.class);
    when(p.getName()).thenReturn("Name");

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, new BasicFieldMetadata());

    // Assert
    verify(p, atLeast(1)).getName();
    assertEquals("Name", actualCreateHeaderFieldResult.getFriendlyName());
    assertEquals("Name", actualCreateHeaderFieldResult.getName());
    assertEquals("Name", actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return FriendlyName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField_whenBasicFieldMetadata_thenReturnFriendlyNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, new BasicFieldMetadata());

    // Assert
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given empty 2D array of {@link String}.</li>
   *   <li>Then return {@link ComboField}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  public void testInitHeaderField_givenEmpty2dArrayOfString_thenReturnComboField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getEnumerationValues()).thenReturn(new String[][]{});
    when(fmd.getFieldType()).thenReturn(SupportedFieldType.BROADLEAF_ENUMERATION);

    // Act
    Field actualInitHeaderFieldResult = formBuilderServiceImpl.initHeaderField(fmd);

    // Assert
    verify(fmd).getEnumerationValues();
    verify(fmd).getFieldType();
    assertTrue(actualInitHeaderFieldResult instanceof ComboField);
    assertEquals("null/null", actualInitHeaderFieldResult.getEntityViewPath());
    assertNull(actualInitHeaderFieldResult.getOrder());
    assertNull(actualInitHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualInitHeaderFieldResult.getColumnWidth());
    assertNull(actualInitHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualInitHeaderFieldResult.getDisplayType());
    assertNull(actualInitHeaderFieldResult.getDisplayValue());
    assertNull(actualInitHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getFieldType());
    assertNull(actualInitHeaderFieldResult.getForeignKeyClass());
    assertNull(actualInitHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualInitHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualInitHeaderFieldResult.getFriendlyName());
    assertNull(actualInitHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getHelp());
    assertNull(actualInitHeaderFieldResult.getHint());
    assertNull(actualInitHeaderFieldResult.getIdOverride());
    assertNull(actualInitHeaderFieldResult.getName());
    assertNull(actualInitHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualInitHeaderFieldResult.getOwningEntityClass());
    assertNull(actualInitHeaderFieldResult.getRawDisplayValue());
    assertNull(actualInitHeaderFieldResult.getTooltip());
    assertNull(actualInitHeaderFieldResult.getTranslationFieldName());
    assertNull(actualInitHeaderFieldResult.getValue());
    assertFalse(actualInitHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualInitHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualInitHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualInitHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualInitHeaderFieldResult.getDisabled());
    assertFalse(actualInitHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualInitHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualInitHeaderFieldResult.getIsDerived());
    assertFalse(actualInitHeaderFieldResult.getIsDirty());
    assertFalse(actualInitHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualInitHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualInitHeaderFieldResult.getMainEntityLink());
    assertFalse(actualInitHeaderFieldResult.getReadOnly());
    assertFalse(actualInitHeaderFieldResult.getRequired());
    assertFalse(actualInitHeaderFieldResult.getResizeDisabled());
    assertFalse(actualInitHeaderFieldResult.getTranslatable());
    assertTrue(((ComboField) actualInitHeaderFieldResult).getOptions().isEmpty());
    assertTrue(actualInitHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualInitHeaderFieldResult.getIsVisible());
    assertTrue(actualInitHeaderFieldResult.getShouldRender());
  }

  /**
   * Test {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()}
   * return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  public void testInitHeaderField_givenUnknown_whenBasicFieldMetadataGetFieldTypeReturnUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    Field actualInitHeaderFieldResult = formBuilderServiceImpl.initHeaderField(fmd);

    // Assert
    verify(fmd).getFieldType();
    assertEquals("null/null", actualInitHeaderFieldResult.getEntityViewPath());
    assertNull(actualInitHeaderFieldResult.getOrder());
    assertNull(actualInitHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualInitHeaderFieldResult.getColumnWidth());
    assertNull(actualInitHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualInitHeaderFieldResult.getDisplayType());
    assertNull(actualInitHeaderFieldResult.getDisplayValue());
    assertNull(actualInitHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getFieldType());
    assertNull(actualInitHeaderFieldResult.getForeignKeyClass());
    assertNull(actualInitHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualInitHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualInitHeaderFieldResult.getFriendlyName());
    assertNull(actualInitHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getHelp());
    assertNull(actualInitHeaderFieldResult.getHint());
    assertNull(actualInitHeaderFieldResult.getIdOverride());
    assertNull(actualInitHeaderFieldResult.getName());
    assertNull(actualInitHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualInitHeaderFieldResult.getOwningEntityClass());
    assertNull(actualInitHeaderFieldResult.getRawDisplayValue());
    assertNull(actualInitHeaderFieldResult.getTooltip());
    assertNull(actualInitHeaderFieldResult.getTranslationFieldName());
    assertNull(actualInitHeaderFieldResult.getValue());
    assertFalse(actualInitHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualInitHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualInitHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualInitHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualInitHeaderFieldResult.getDisabled());
    assertFalse(actualInitHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualInitHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualInitHeaderFieldResult.getIsDerived());
    assertFalse(actualInitHeaderFieldResult.getIsDirty());
    assertFalse(actualInitHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualInitHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualInitHeaderFieldResult.getMainEntityLink());
    assertFalse(actualInitHeaderFieldResult.getReadOnly());
    assertFalse(actualInitHeaderFieldResult.getRequired());
    assertFalse(actualInitHeaderFieldResult.getResizeDisabled());
    assertFalse(actualInitHeaderFieldResult.getTranslatable());
    assertTrue(actualInitHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualInitHeaderFieldResult.getIsVisible());
    assertTrue(actualInitHeaderFieldResult.getShouldRender());
  }

  /**
   * Test {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return EntityViewPath is {@code null/null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  public void testInitHeaderField_whenBasicFieldMetadata_thenReturnEntityViewPathIsNullNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act
    Field actualInitHeaderFieldResult = formBuilderServiceImpl.initHeaderField(new BasicFieldMetadata());

    // Assert
    assertEquals("null/null", actualInitHeaderFieldResult.getEntityViewPath());
    assertNull(actualInitHeaderFieldResult.getOrder());
    assertNull(actualInitHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualInitHeaderFieldResult.getColumnWidth());
    assertNull(actualInitHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualInitHeaderFieldResult.getDisplayType());
    assertNull(actualInitHeaderFieldResult.getDisplayValue());
    assertNull(actualInitHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getFieldType());
    assertNull(actualInitHeaderFieldResult.getForeignKeyClass());
    assertNull(actualInitHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualInitHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualInitHeaderFieldResult.getFriendlyName());
    assertNull(actualInitHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getHelp());
    assertNull(actualInitHeaderFieldResult.getHint());
    assertNull(actualInitHeaderFieldResult.getIdOverride());
    assertNull(actualInitHeaderFieldResult.getName());
    assertNull(actualInitHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualInitHeaderFieldResult.getOwningEntityClass());
    assertNull(actualInitHeaderFieldResult.getRawDisplayValue());
    assertNull(actualInitHeaderFieldResult.getTooltip());
    assertNull(actualInitHeaderFieldResult.getTranslationFieldName());
    assertNull(actualInitHeaderFieldResult.getValue());
    assertFalse(actualInitHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualInitHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualInitHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualInitHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualInitHeaderFieldResult.getDisabled());
    assertFalse(actualInitHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualInitHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualInitHeaderFieldResult.getIsDerived());
    assertFalse(actualInitHeaderFieldResult.getIsDirty());
    assertFalse(actualInitHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualInitHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualInitHeaderFieldResult.getMainEntityLink());
    assertFalse(actualInitHeaderFieldResult.getReadOnly());
    assertFalse(actualInitHeaderFieldResult.getRequired());
    assertFalse(actualInitHeaderFieldResult.getResizeDisabled());
    assertFalse(actualInitHeaderFieldResult.getTranslatable());
    assertTrue(actualInitHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualInitHeaderFieldResult.getIsVisible());
    assertTrue(actualInitHeaderFieldResult.getShouldRender());
  }

  /**
   * Test {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code BROADLEAF_ENUMERATION}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  public void testIsComboField_givenBroadleafEnumeration_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getFieldType()).thenReturn(SupportedFieldType.BROADLEAF_ENUMERATION);

    // Act
    boolean actualIsComboFieldResult = formBuilderServiceImpl.isComboField(fmd);

    // Assert
    verify(fmd).getFieldType();
    assertTrue(actualIsComboFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()}
   * return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  public void testIsComboField_givenUnknown_whenBasicFieldMetadataGetFieldTypeReturnUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    boolean actualIsComboFieldResult = formBuilderServiceImpl.isComboField(fmd);

    // Assert
    verify(fmd).getFieldType();
    assertFalse(actualIsComboFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  public void testIsComboField_whenBasicFieldMetadata_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isComboField(new BasicFieldMetadata()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  public void testIsSupportedFieldTypes_thenCallsGetFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    boolean actualIsSupportedFieldTypesResult = formBuilderServiceImpl.isSupportedFieldTypes(fmd,
        SupportedFieldType.UNKNOWN);

    // Assert
    verify(fmd).getFieldType();
    assertTrue(actualIsSupportedFieldTypesResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  public void testIsSupportedFieldTypes_whenBasicFieldMetadataFieldTypeIsUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.isSupportedFieldTypes(fmd, SupportedFieldType.UNKNOWN));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  public void testIsSupportedFieldTypes_whenBasicFieldMetadata_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isSupportedFieldTypes(new BasicFieldMetadata(), SupportedFieldType.UNKNOWN));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    // Act
    boolean actualPropertyExistsInResultSetResult = formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    verify(property).getName();
    assertTrue(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Property} {@link Property#getName()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet_givenFoo_whenPropertyGetNameReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property2});
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    // Act
    boolean actualPropertyExistsInResultSetResult = formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    verify(property).getName();
    verify(property2).getName();
    assertFalse(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link DynamicResultSet#getRecords()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet_givenPropertyGetNameReturnName_thenCallsGetRecords() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property2});
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    // Act
    boolean actualPropertyExistsInResultSetResult = formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    verify(property).getName();
    verify(property2).getName();
    assertTrue(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet_whenDynamicResultSet_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = new Property();

    // Act and Assert
    assertTrue(formBuilderServiceImpl.propertyExistsInResultSet(property, new DynamicResultSet()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.propertyExistsInResultSet(null, new DynamicResultSet()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>When {@link Property}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet_whenProperty_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.propertyExistsInResultSet(property, new DynamicResultSet()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName_givenAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    String actualMapKeyFriendlyName = formBuilderServiceImpl.getMapKeyFriendlyName(property);

    // Assert
    verify(property).getMetadata();
    assertEquals("Key", actualMapKeyFriendlyName);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>Then return {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName_thenReturnFriendlyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getFriendlyName()).thenReturn("Friendly Name");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act
    String actualMapKeyFriendlyName = formBuilderServiceImpl.getMapKeyFriendlyName(property);

    // Assert
    verify(adornedTargetCollectionMetadata).getFriendlyName();
    verify(property).getMetadata();
    assertEquals("Friendly Name", actualMapKeyFriendlyName);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName_thenReturnProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setFriendlyName("Property");

    Property property = new Property();
    property.setMetadata(metadata);

    // Act and Assert
    assertEquals("Property", formBuilderServiceImpl.getMapKeyFriendlyName(property));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>When {@link Property#Property()}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName_whenProperty_thenReturnKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertEquals("Key", formBuilderServiceImpl.getMapKeyFriendlyName(new Property()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = new DynamicResultSet(new Entity[]{new Entity()}, 1);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2).getMetadata();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Given array of {@link Entity} with {@link Entity} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_givenArrayOfEntityWithEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{new Entity()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#isProminent()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_givenBasicFieldMetadataIsProminentReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.isProminent()).thenReturn(false);
    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_givenEntityFindPropertyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return
   * {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_givenPropertyGetMetadataReturnBasicFieldMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertNull(getResult2.get("alternateId"));
    assertNull(getResult2.get("id"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("*"));
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property = mock(Property.class);
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
    assertThrows(NumberFormatException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
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
   * Test
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@code options} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_whenDynamicResultSet_thenReturnOptionsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = new DynamicResultSet();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField_givenBasicFieldMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();
    Property p = mock(Property.class);
    when(p.getMetadata()).thenReturn(new BasicFieldMetadata());

    // Act
    Boolean actualIsDerivedFieldResult = formBuilderServiceImpl.isDerivedField(headerField, recordField, p);

    // Assert
    verify(p).getMetadata();
    assertFalse(actualIsDerivedFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) Derived is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField_givenBasicFieldMetadataDerivedIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDerived(true);

    Property p = new Property();
    p.setMetadata(metadata);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.isDerivedField(headerField, recordField, p));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getIsDerived()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField_thenCallsGetIsDerived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getIsDerived()).thenReturn(false);
    Property p = mock(Property.class);
    when(p.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Boolean actualIsDerivedFieldResult = formBuilderServiceImpl.isDerivedField(headerField, recordField, p);

    // Assert
    verify(basicFieldMetadata).getIsDerived();
    verify(p).getMetadata();
    assertFalse(actualIsDerivedFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>When {@link Field}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField_whenField_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = mock(Field.class);
    Field recordField = new Field();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isDerivedField(headerField, recordField, new Property()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>When {@link Property#Property()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField_whenProperty_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isDerivedField(headerField, recordField, new Property()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  public void testSetEntityFormFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
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
    EntityForm ef = new EntityForm();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties);

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata}
   * {@link BasicFieldMetadata#getVisibility()} return {@code HIDDEN_ALL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  public void testSetEntityFormFields_givenBasicFieldMetadataGetVisibilityReturnHiddenAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
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
    EntityForm ef = new EntityForm();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties);

    // Assert
    verify(basicFieldMetadata).getVisibility();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  public void testSetEntityFormFields_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
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
    EntityForm ef = new EntityForm();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getLookupType()).thenThrow(new NumberFormatException("UNKNOWN"));
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getVisibility();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ClassMetadata#setCeilingType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  public void testSetEntityFormFields_whenArrayList_thenCallsSetCeilingType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
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
    EntityForm ef = new EntityForm();

    // Act
    formBuilderServiceImpl.setEntityFormFields(cmd, ef, new ArrayList<>());

    // Assert that nothing has changed
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField_given42_whenPropertyGetValueReturn42_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField recordField = mock(CodeField.class);
    doNothing().when(recordField).setValue(Mockito.<String>any());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getValue();
    verify(recordField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>Given {@code Property}.</li>
   *   <li>Then {@link Field} (default constructor) DisplayValue is
   * {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField_givenProperty_thenFieldDisplayValueIsProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field recordField = new Field();

    Property property = new Property();
    property.setValue("Property");

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals("Property", recordField.getDisplayValue());
    assertEquals("Property", recordField.getValue());
    assertEquals("null/Property", recordField.getEntityViewPath());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@link CodeField} {@link Field#setValue(String)} does nothing.</li>
   *   <li>Then calls {@link Field#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField_whenCodeFieldSetValueDoesNothing_thenCallsSetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField recordField = mock(CodeField.class);
    doNothing().when(recordField).setValue(Mockito.<String>any());
    Property property = new Property();

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(recordField).setValue(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@link Field} (default constructor).</li>
   *   <li>Then {@link Field} (default constructor) EntityViewPath is
   * {@code null/null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField_whenField_thenFieldEntityViewPathIsNullNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field recordField = new Field();
    Property property = new Property();

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals("null/null", recordField.getEntityViewPath());
    assertNull(recordField.getDisplayValue());
    assertNull(recordField.getValue());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Fmd}.</li>
   *   <li>Then return {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer_givenFmd_thenReturnFmd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldComponentRenderer(null);
    fmd.setFieldComponentRendererTemplate("Fmd");

    // Act and Assert
    assertEquals("Fmd", formBuilderServiceImpl.getFieldComponentRenderer(fmd));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer_givenUnknown_thenReturnUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    fmd.setFieldComponentRendererTemplate(null);

    // Act and Assert
    assertEquals("UNKNOWN", formBuilderServiceImpl.getFieldComponentRenderer(fmd));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return {@code Field Component Renderer Template}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer_thenReturnFieldComponentRendererTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");

    // Act
    String actualFieldComponentRenderer = formBuilderServiceImpl.getFieldComponentRenderer(fmd);

    // Assert
    verify(fmd, atLeast(1)).getFieldComponentRendererTemplate();
    assertEquals("Field Component Renderer Template", actualFieldComponentRenderer);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer_whenBasicFieldMetadata_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Fmd}.</li>
   *   <li>Then return {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer_givenFmd_thenReturnFmd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setGridFieldComponentRenderer(null);
    fmd.setGridFieldComponentRendererTemplate("Fmd");

    // Act and Assert
    assertEquals("Fmd", formBuilderServiceImpl.getGridFieldComponentRenderer(fmd));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer_givenUnknown_thenReturnUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    fmd.setGridFieldComponentRendererTemplate(null);

    // Act and Assert
    assertEquals("UNKNOWN", formBuilderServiceImpl.getGridFieldComponentRenderer(fmd));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return {@code Grid Field Component Renderer Template}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer_thenReturnGridFieldComponentRendererTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getGridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");

    // Act
    String actualGridFieldComponentRenderer = formBuilderServiceImpl.getGridFieldComponentRenderer(fmd);

    // Assert
    verify(fmd, atLeast(1)).getGridFieldComponentRendererTemplate();
    assertEquals("Grid Field Component Renderer Template", actualGridFieldComponentRenderer);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer_whenBasicFieldMetadata_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getGridFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  public void testGetAdminSectionPath_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FormBuilderServiceImpl()).getAdminSectionPath(null));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}
   */
  @Test
  public void testGetUnprocessedNameOfMatchingTab_whenHashSet_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getUnprocessedNameOfMatchingTab(tabMetadata, new HashSet<>()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}.
   * <ul>
   *   <li>When {@link TabMetadata}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}
   */
  @Test
  public void testGetUnprocessedNameOfMatchingTab_whenTabMetadata_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    TabMetadata tabMetadata = mock(TabMetadata.class);

    // Act and Assert
    assertNull(formBuilderServiceImpl.getUnprocessedNameOfMatchingTab(tabMetadata, new HashSet<>()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#foundMatchingTab(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#foundMatchingTab(String)}
   */
  @Test
  public void testFoundMatchingTab_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FormBuilderServiceImpl()).foundMatchingTab(null));
  }

  /**
   * Test {@link FormBuilderServiceImpl#foundMatchingTab(String)}.
   * <ul>
   *   <li>When {@code Unprocessed Tab Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#foundMatchingTab(String)}
   */
  @Test
  public void testFoundMatchingTab_whenUnprocessedTabName_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FormBuilderServiceImpl()).foundMatchingTab("Unprocessed Tab Name"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findTab(String)} return
   * {@link Tab} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  public void testTabExists_givenTab_whenEntityFormFindTabReturnTab_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findTab(Mockito.<String>any())).thenReturn(new Tab());

    // Act
    boolean actualTabExistsResult = formBuilderServiceImpl.tabExists(ef, "Tab Key");

    // Assert
    verify(ef).findTab(eq("Tab Key"));
    assertTrue(actualTabExistsResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  public void testTabExists_whenEntityForm_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.tabExists(new EntityForm(), "Tab Key"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code DECIMAL}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_given42_whenDecimal_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("DECIMAL", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("42", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code Field Type}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_given42_whenFieldType_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("Field Type", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("42", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_given42_whenInteger_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("INTEGER", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("42", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.</li>
   *   <li>Then return {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_givenFalseToString_thenReturnFalseToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn(Boolean.FALSE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals(Boolean.FALSE.toString(), actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code N}.</li>
   *   <li>Then return {@code N}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_givenN_thenReturnN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("N");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("N", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_givenName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_givenTrueToString_thenReturnTrueToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn(Boolean.TRUE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals(Boolean.TRUE.toString(), actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.</li>
   *   <li>When {@code DATE}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_givenTrueToString_whenDate_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn(Boolean.TRUE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("DATE", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Y}.</li>
   *   <li>Then return {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_givenY_thenReturnY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("Y");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("Y", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code DECIMAL}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_whenDecimal_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn(Boolean.TRUE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("DECIMAL", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code Field Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_whenFieldType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("Field Type", new BasicFieldMetadata()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_whenInteger_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn(Boolean.TRUE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("INTEGER", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code RULE_SIMPLE_TIME}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_whenRuleSimpleTime_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_SIMPLE_TIME", new BasicFieldMetadata()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code RULE_SIMPLE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_whenRuleSimple_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_SIMPLE", new BasicFieldMetadata()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code RULE_WITH_QUANTITY}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData_whenRuleWithQuantity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_WITH_QUANTITY", new BasicFieldMetadata()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}
   */
  @Test
  public void testBuildMsgForDefValException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertEquals("NULL : NULL - Failed to parse Type from DefaultValue [ 42 ]",
        formBuilderServiceImpl.buildMsgForDefValException("Type", new BasicFieldMetadata(), "42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}
   */
  @Test
  public void testBuildMsgForDefValException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");

    // Act
    String actualBuildMsgForDefValExceptionResult = formBuilderServiceImpl.buildMsgForDefValException("Type", fmd,
        "42");

    // Assert
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertEquals("Target Class : Name - Failed to parse Type from DefaultValue [ 42 ]",
        actualBuildMsgForDefValExceptionResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
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

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
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
    formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>Then calls {@link EntityForm#removeField(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields_givenField_thenCallsRemoveField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
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
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.removeField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, entityForm, "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
    verify(entityForm).removeField(eq("Name"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields_givenTabMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
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

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, entityForm, "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#getAvailableToTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields_thenCallsGetAvailableToTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
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

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new RuntimeException("foo"));
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
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
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type"));
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>Then calls {@link SectionCrumb#getSectionIdentifier()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb_thenCallsGetSectionIdentifier() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn("42");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    String actualExtractSectionIdentifierFromCrumbResult = formBuilderServiceImpl
        .extractSectionIdentifierFromCrumb(sectionCrumbs);

    // Assert
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertEquals("42", actualExtractSectionIdentifierFromCrumbResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertEquals("42", formBuilderServiceImpl.extractSectionIdentifierFromCrumb(sectionCrumbs));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>Then return {@code Section Identifier}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb_thenReturnSectionIdentifier() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    assertEquals("Section Identifier", formBuilderServiceImpl.extractSectionIdentifierFromCrumb(sectionCrumbs));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractSectionIdentifierFromCrumb(new ArrayList<>()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FormBuilderServiceImpl()).extractSectionIdentifierFromCrumb(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FormBuilderServiceImpl#addAdditionalFormActions(EntityForm)}
   *   <li>{@link FormBuilderServiceImpl#getFormHiddenVisibilities()}
   *   <li>{@link FormBuilderServiceImpl#getGridHiddenVisibilities()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act
    formBuilderServiceImpl.addAdditionalFormActions(new EntityForm());
    VisibilityEnum[] actualFormHiddenVisibilities = formBuilderServiceImpl.getFormHiddenVisibilities();

    // Assert that nothing has changed
    assertSame(formBuilderServiceImpl.FORM_HIDDEN_VISIBILITIES, actualFormHiddenVisibilities);
    assertSame(formBuilderServiceImpl.GRID_HIDDEN_VISIBILITIES, formBuilderServiceImpl.getGridHiddenVisibilities());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
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
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenHashMapFooIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(stringListMap);
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then calls {@link EntityForm#removeListGrid(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenListGrid_thenCallsRemoveListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
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
    Entity entity = new Entity();
    EntityForm ef = mock(EntityForm.class);
    when(ef.removeListGrid(Mockito.<String>any())).thenReturn(new ListGrid());

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, ef);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
    verify(ef).removeListGrid(eq("Name"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenPropertyGetMetadataReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(null);
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
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
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenTabMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
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
    Entity entity = new Entity();

    EntityForm ef = new EntityForm();
    ef.addTabFromTabMetadata(new TabMetadata());

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, ef);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenThrow(new RuntimeException("foo"));
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
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm()));
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getShowIfFieldEquals();
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_givenArrayListAdd42_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add(0, "");

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", stringList);
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, entity);

    // Assert
    verify(entity).findProperty(eq("foo"));
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
    assertFalse(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_givenHashMapFooIsArrayList_whenEntity_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, new Entity());

    // Assert
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    assertFalse(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_givenHashMap_whenEntity_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, new Entity());

    // Assert
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_givenPropertyGetValueReturn42_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, entity);

    // Assert
    verify(entity).findProperty(eq("foo"));
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_givenProperty_whenEntityFindPropertyReturnProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, entity);

    // Assert
    verify(entity).findProperty(eq("foo"));
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException("foo"));
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.shouldHideField(fmd, entity));
    verify(entity).findProperty(eq("foo"));
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(fmd, new Entity()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(null, new Entity()));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
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
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code key}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues_givenPropertyGetNameReturnKey_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("key");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code priorKey}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues_givenPropertyGetNameReturnPriorKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("priorKey");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property#Property()} Name is {@code key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues_givenPropertyNameIsKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = new Property();
    property.setName("key");
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
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then calls {@link Entity#findProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues_givenProperty_thenCallsFindProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("foo"));
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
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm()));
    verify(basicFieldMetadata).getVisibility();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("Name"));
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("foo"));
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
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm()));
    verify(basicFieldMetadata).getVisibility();
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
   * Test
   * {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#isLargeEntry()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  public void testDecodeValueIfNeeded_thenCallsIsLargeEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    BasicFieldMetadata basicFM = mock(BasicFieldMetadata.class);
    when(basicFM.isLargeEntry()).thenReturn(true);

    // Act
    String actualDecodeValueIfNeededResult = formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42");

    // Assert
    verify(basicFM, atLeast(1)).isLargeEntry();
    assertEquals("42", actualDecodeValueIfNeededResult);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) LargeEntry is
   * {@code true}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  public void testDecodeValueIfNeeded_whenBasicFieldMetadataLargeEntryIsTrue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata basicFM = new BasicFieldMetadata();
    basicFM.setLargeEntry(true);

    // Act and Assert
    assertEquals("42", formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return {@link DataWrapper} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_thenReturnDataWrapper() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ObjectMapper objectMapper = new ObjectMapper();
    DataWrapper dataWrapper = new DataWrapper();

    // Act and Assert
    assertEquals(dataWrapper,
        formBuilderServiceImpl.convertJsonToDataWrapper(objectMapper.writeValueAsString(dataWrapper)));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_thenReturnNull() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(null)));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code Json}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenJson_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new FormBuilderServiceImpl()).convertJsonToDataWrapper("Json"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()} writeValueAsString
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenObjectMapperWriteValueAsString42() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString("42")));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()} writeValueAsString
   * forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenObjectMapperWriteValueAsStringFortyTwo() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(42)));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  public void testPopulateDropdownToOneFields() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
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
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);

    // Assert
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
   * Test
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return
   * {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  public void testPopulateDropdownToOneFields_givenPropertyGetMetadataReturnBasicFieldMetadata()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
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
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);

    // Assert
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
   * Test
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  public void testPopulateDropdownToOneFields_thenThrowRuntimeException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getLookupType()).thenThrow(new RuntimeException("foo"));
    Property property = mock(Property.class);
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
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd));
    verify(basicFieldMetadata).getLookupType();
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
   * Test
   * {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then calls {@link Property#getMetadata()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  public void testSetReadOnlyState_thenCallsGetMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setReadOnly();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
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
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(entityForm).setReadOnly();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  public void testSetReadOnlyState_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new RuntimeException("foo")).when(entityForm).setReadOnly();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
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
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(entityForm).setReadOnly();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code Ceiling Entity Classname}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname_givenEmptyString_thenReturnCeilingEntityClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
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
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertEquals("Ceiling Entity Classname", actualSecurityClassname);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is
   * {@link DynamicEntityFormInfo} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname_givenHashMapEmptyStringIsDynamicEntityFormInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("", new DynamicEntityFormInfo());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
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
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertEquals("Ceiling Entity Classname", actualSecurityClassname);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code Security Ceiling Class Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname_thenReturnSecurityCeilingClassName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getSecurityCeilingClassName()).thenReturn("Security Ceiling Class Name");

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("", dynamicEntityFormInfo);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
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
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getSecurityCeilingClassName();
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertEquals("Security Ceiling Class Name", actualSecurityClassname);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code Security Ceiling Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname_thenReturnSecurityCeilingType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(entityForm).getCeilingEntityClassname();
    assertEquals("Security Ceiling Type", actualSecurityClassname);
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) DynamicFormInfos is
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname_whenEntityFormDynamicFormInfosIsHashMap_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(new HashMap<>());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType(null);

    // Act and Assert
    assertNull(formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) DynamicFormInfos is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname_whenEntityFormDynamicFormInfosIsNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(null);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType(null);

    // Act and Assert
    assertNull(formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code Security Ceiling Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname_whenEntityForm_thenReturnSecurityCeilingType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Security Ceiling Type", formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    doThrow(new NumberFormatException("foo")).when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true));
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_givenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_givenHashMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, false, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setId(eq("42"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   * with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_whenFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, false);

    // Assert
    verify(entity).findProperty(eq(""));
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).setEntityType(eq("Type"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   * with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   * with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is {@link Field} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMapEmptyStringIsField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   * with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link Field} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMapFooIsField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   * with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMap_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   * with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Then calls {@link Field#setDisplayValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntity_thenCallsSetDisplayValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   * with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFieldsWithEfEntity_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    doThrow(new NumberFormatException("foo")).when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity));
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields_givenField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(ef).findField(eq("null.null"));
    verify(ef).getIdProperty();
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then calls {@link Field#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields_givenProperty_thenCallsSetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(ef).findField(eq("null.null"));
    verify(ef).getIdProperty();
    verify(codeField).setValue(isNull());
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Given {@code Sort Field}.</li>
   *   <li>Then calls {@link AdornedTargetList#getSortField()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields_givenSortField_thenCallsGetSortField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    AdornedTargetList adornedList = mock(AdornedTargetList.class);
    when(adornedList.getSortField()).thenReturn("Sort Field");
    when(adornedList.getTargetIdProperty()).thenReturn("Target Id Property");
    when(adornedList.getTargetObjectPath()).thenReturn("Target Object Path");

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, adornedList);

    // Assert
    verify(adornedList, atLeast(1)).getSortField();
    verify(adornedList).getTargetIdProperty();
    verify(adornedList).getTargetObjectPath();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).getIdProperty();
    verify(codeField, atLeast(1)).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(property).getValue();
    verify(ef).findField(eq("null.null"));
    verify(ef).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link CodeField}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields_givenCodeField_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(mock(CodeField.class));
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException("priorKey"));
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.populateMapEntityFormFields(ef, entity));
    verify(entity).findProperty(eq("key"));
    verify(property).getValue();
    verify(ef).findField(eq("priorKey"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields_givenField_whenEntityFormFindFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, new Entity());

    // Assert
    verify(ef).findField(eq("priorKey"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields_givenProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("key"));
    verify(ef).findField(eq("priorKey"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields_givenPropertyGetValueReturn42_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("key"));
    verify(property).getValue();
    verify(ef).findField(eq("priorKey"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Then calls {@link Field#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields_thenCallsSetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("key"));
    verify(ef).findField(eq("priorKey"));
    verify(codeField).setValue(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ArrayList<Property> mapFormProperties = new ArrayList<>();
    mapFormProperties.add(property);
    ArrayList<String> classNames = new ArrayList<>();

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(mapFormProperties.isEmpty());
    assertTrue(classNames.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"foo", "42"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ArrayList<Property> mapFormProperties = new ArrayList<>();
    mapFormProperties.add(property);

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertEquals(1, mapFormProperties.size());
    assertEquals(1, classNames.size());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties_given42_whenArrayListAdd42_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    ArrayList<Property> mapFormProperties = new ArrayList<>();

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("42");
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert that nothing has changed
    assertEquals(2, classNames.size());
    assertTrue(mapFormProperties.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties_givenFoo_whenArrayListAddFoo_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    ArrayList<Property> mapFormProperties = new ArrayList<>();

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert that nothing has changed
    assertEquals(1, classNames.size());
    assertTrue(mapFormProperties.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties_whenArrayList_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    ArrayList<Property> mapFormProperties = new ArrayList<>();
    ArrayList<String> classNames = new ArrayList<>();

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert that nothing has changed
    assertTrue(mapFormProperties.isEmpty());
    assertTrue(classNames.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties_whenNull_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    ArrayList<String> classNames = new ArrayList<>();

    // Act
    formBuilderServiceImpl.filterMapFormProperties(null, classNames);

    // Assert that nothing has changed
    assertTrue(classNames.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createStandardEntityForm()}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createStandardEntityForm()}
   */
  @Test
  public void testCreateStandardEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityForm actualCreateStandardEntityFormResult = (new FormBuilderServiceImpl()).createStandardEntityForm();

    // Assert
    assertEquals("", actualCreateStandardEntityFormResult.getMainEntityName());
    assertEquals("", actualCreateStandardEntityFormResult.getSectionCrumbs());
    List<EntityFormAction> actions = actualCreateStandardEntityFormResult.getActions();
    assertEquals(1, actions.size());
    EntityFormAction getResult = actions.get(0);
    assertEquals("", getResult.getConfirmEnabledText());
    assertEquals("", getResult.getIconClass());
    assertEquals("", getResult.getUrlPostfix());
    assertEquals("SAVE", getResult.getId());
    assertEquals("Save", getResult.getDisplayText());
    assertEquals("id", actualCreateStandardEntityFormResult.getIdProperty());
    assertEquals("submit", getResult.getButtonType());
    assertEquals("submit-button primary", getResult.getButtonClass());
    assertNull(actualCreateStandardEntityFormResult.getCeilingEntityClassname());
    assertNull(actualCreateStandardEntityFormResult.getEncType());
    assertNull(actualCreateStandardEntityFormResult.getEntityType());
    assertNull(actualCreateStandardEntityFormResult.getId());
    assertNull(actualCreateStandardEntityFormResult.getJsErrorMap());
    assertNull(actualCreateStandardEntityFormResult.getParentId());
    assertNull(actualCreateStandardEntityFormResult.getSectionKey());
    assertNull(actualCreateStandardEntityFormResult.getTranslationCeilingEntity());
    assertNull(actualCreateStandardEntityFormResult.getTranslationId());
    assertNull(getResult.getUrlOverride());
    assertFalse(actualCreateStandardEntityFormResult.getPreventSubmit());
    assertFalse(actualCreateStandardEntityFormResult.getReadOnly());
    assertFalse(getResult.getIsConfirmEnabled());
    assertTrue(actualCreateStandardEntityFormResult.getAllListGrids().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getSectionCrumbsImpl().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getAttributes().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getDynamicFormInfos().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getDynamicForms().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getFields().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getTabs().isEmpty());
  }
}
