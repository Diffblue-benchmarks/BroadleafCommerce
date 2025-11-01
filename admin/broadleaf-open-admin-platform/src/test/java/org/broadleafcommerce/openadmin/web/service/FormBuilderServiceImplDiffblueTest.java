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
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid() throws ServiceException {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid2() throws ServiceException {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid3() throws ServiceException {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  public void testBuildMainListGrid4() throws ServiceException {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  public void testGetTranslationSearchField() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  public void testConstructFieldDTOFromFieldData7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, new BasicFieldMetadata());

    // Assert
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getOrder());
    assertNull(actualCreateHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualCreateHeaderFieldResult.getColumnWidth());
    assertNull(actualCreateHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualCreateHeaderFieldResult.getDisplayType());
    assertNull(actualCreateHeaderFieldResult.getDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getHelp());
    assertNull(actualCreateHeaderFieldResult.getHint());
    assertNull(actualCreateHeaderFieldResult.getIdOverride());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getRawDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getTooltip());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getValue());
    assertFalse(actualCreateHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualCreateHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualCreateHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualCreateHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualCreateHeaderFieldResult.getDisabled());
    assertFalse(actualCreateHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualCreateHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualCreateHeaderFieldResult.getIsDerived());
    assertFalse(actualCreateHeaderFieldResult.getIsDirty());
    assertFalse(actualCreateHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualCreateHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualCreateHeaderFieldResult.getMainEntityLink());
    assertFalse(actualCreateHeaderFieldResult.getReadOnly());
    assertFalse(actualCreateHeaderFieldResult.getRequired());
    assertFalse(actualCreateHeaderFieldResult.getResizeDisabled());
    assertFalse(actualCreateHeaderFieldResult.getTranslatable());
    assertTrue(actualCreateHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualCreateHeaderFieldResult.getIsVisible());
    assertTrue(actualCreateHeaderFieldResult.getShouldRender());
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField2() {
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
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getOrder());
    assertNull(actualCreateHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualCreateHeaderFieldResult.getColumnWidth());
    assertNull(actualCreateHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualCreateHeaderFieldResult.getDisplayType());
    assertNull(actualCreateHeaderFieldResult.getDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getHelp());
    assertNull(actualCreateHeaderFieldResult.getHint());
    assertNull(actualCreateHeaderFieldResult.getIdOverride());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getRawDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getTooltip());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getValue());
    assertFalse(actualCreateHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualCreateHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualCreateHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualCreateHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualCreateHeaderFieldResult.getDisabled());
    assertFalse(actualCreateHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualCreateHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualCreateHeaderFieldResult.getIsDerived());
    assertFalse(actualCreateHeaderFieldResult.getIsDirty());
    assertFalse(actualCreateHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualCreateHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualCreateHeaderFieldResult.getMainEntityLink());
    assertFalse(actualCreateHeaderFieldResult.getReadOnly());
    assertFalse(actualCreateHeaderFieldResult.getRequired());
    assertFalse(actualCreateHeaderFieldResult.getResizeDisabled());
    assertFalse(actualCreateHeaderFieldResult.getTranslatable());
    assertTrue(actualCreateHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualCreateHeaderFieldResult.getIsVisible());
    assertTrue(actualCreateHeaderFieldResult.getShouldRender());
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField3() {
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
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getOrder());
    assertNull(actualCreateHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualCreateHeaderFieldResult.getColumnWidth());
    assertNull(actualCreateHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualCreateHeaderFieldResult.getDisplayType());
    assertNull(actualCreateHeaderFieldResult.getDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getHelp());
    assertNull(actualCreateHeaderFieldResult.getHint());
    assertNull(actualCreateHeaderFieldResult.getIdOverride());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getRawDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getTooltip());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getValue());
    assertFalse(actualCreateHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualCreateHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualCreateHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualCreateHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualCreateHeaderFieldResult.getDisabled());
    assertFalse(actualCreateHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualCreateHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualCreateHeaderFieldResult.getIsDerived());
    assertFalse(actualCreateHeaderFieldResult.getIsDirty());
    assertFalse(actualCreateHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualCreateHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualCreateHeaderFieldResult.getMainEntityLink());
    assertFalse(actualCreateHeaderFieldResult.getReadOnly());
    assertFalse(actualCreateHeaderFieldResult.getRequired());
    assertFalse(actualCreateHeaderFieldResult.getResizeDisabled());
    assertFalse(actualCreateHeaderFieldResult.getTranslatable());
    assertTrue(actualCreateHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualCreateHeaderFieldResult.getIsVisible());
    assertTrue(actualCreateHeaderFieldResult.getShouldRender());
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField4() {
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
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getOrder());
    assertNull(actualCreateHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualCreateHeaderFieldResult.getColumnWidth());
    assertNull(actualCreateHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualCreateHeaderFieldResult.getDisplayType());
    assertNull(actualCreateHeaderFieldResult.getDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getHelp());
    assertNull(actualCreateHeaderFieldResult.getHint());
    assertNull(actualCreateHeaderFieldResult.getIdOverride());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getRawDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getTooltip());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getValue());
    assertFalse(actualCreateHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualCreateHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualCreateHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualCreateHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualCreateHeaderFieldResult.getDisabled());
    assertFalse(actualCreateHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualCreateHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualCreateHeaderFieldResult.getIsDerived());
    assertFalse(actualCreateHeaderFieldResult.getIsDirty());
    assertFalse(actualCreateHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualCreateHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualCreateHeaderFieldResult.getMainEntityLink());
    assertFalse(actualCreateHeaderFieldResult.getReadOnly());
    assertFalse(actualCreateHeaderFieldResult.getRequired());
    assertFalse(actualCreateHeaderFieldResult.getResizeDisabled());
    assertFalse(actualCreateHeaderFieldResult.getTranslatable());
    assertTrue(actualCreateHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualCreateHeaderFieldResult.getIsVisible());
    assertTrue(actualCreateHeaderFieldResult.getShouldRender());
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField5() {
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
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getOrder());
    assertNull(actualCreateHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualCreateHeaderFieldResult.getColumnWidth());
    assertNull(actualCreateHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualCreateHeaderFieldResult.getDisplayType());
    assertNull(actualCreateHeaderFieldResult.getDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getHelp());
    assertNull(actualCreateHeaderFieldResult.getHint());
    assertNull(actualCreateHeaderFieldResult.getIdOverride());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualCreateHeaderFieldResult.getRawDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getTooltip());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getValue());
    assertFalse(actualCreateHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualCreateHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualCreateHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualCreateHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualCreateHeaderFieldResult.getDisabled());
    assertFalse(actualCreateHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualCreateHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualCreateHeaderFieldResult.getIsDerived());
    assertFalse(actualCreateHeaderFieldResult.getIsDirty());
    assertFalse(actualCreateHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualCreateHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualCreateHeaderFieldResult.getMainEntityLink());
    assertFalse(actualCreateHeaderFieldResult.getReadOnly());
    assertFalse(actualCreateHeaderFieldResult.getRequired());
    assertFalse(actualCreateHeaderFieldResult.getResizeDisabled());
    assertFalse(actualCreateHeaderFieldResult.getTranslatable());
    assertTrue(actualCreateHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualCreateHeaderFieldResult.getIsVisible());
    assertTrue(actualCreateHeaderFieldResult.getShouldRender());
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField6() {
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
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getOrder());
    assertNull(actualCreateHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualCreateHeaderFieldResult.getColumnWidth());
    assertNull(actualCreateHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualCreateHeaderFieldResult.getDisplayType());
    assertNull(actualCreateHeaderFieldResult.getDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getHelp());
    assertNull(actualCreateHeaderFieldResult.getHint());
    assertNull(actualCreateHeaderFieldResult.getIdOverride());
    assertNull(actualCreateHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getRawDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getTooltip());
    assertNull(actualCreateHeaderFieldResult.getValue());
    assertFalse(actualCreateHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualCreateHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualCreateHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualCreateHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualCreateHeaderFieldResult.getDisabled());
    assertFalse(actualCreateHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualCreateHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualCreateHeaderFieldResult.getIsDerived());
    assertFalse(actualCreateHeaderFieldResult.getIsDirty());
    assertFalse(actualCreateHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualCreateHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualCreateHeaderFieldResult.getMainEntityLink());
    assertFalse(actualCreateHeaderFieldResult.getReadOnly());
    assertFalse(actualCreateHeaderFieldResult.getRequired());
    assertFalse(actualCreateHeaderFieldResult.getResizeDisabled());
    assertFalse(actualCreateHeaderFieldResult.getTranslatable());
    assertTrue(actualCreateHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualCreateHeaderFieldResult.getIsVisible());
    assertTrue(actualCreateHeaderFieldResult.getShouldRender());
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  public void testCreateHeaderField7() {
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
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getOrder());
    assertNull(actualCreateHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualCreateHeaderFieldResult.getColumnWidth());
    assertNull(actualCreateHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualCreateHeaderFieldResult.getDisplayType());
    assertNull(actualCreateHeaderFieldResult.getDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualCreateHeaderFieldResult.getHelp());
    assertNull(actualCreateHeaderFieldResult.getHint());
    assertNull(actualCreateHeaderFieldResult.getIdOverride());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getRawDisplayValue());
    assertNull(actualCreateHeaderFieldResult.getTooltip());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getValue());
    assertFalse(actualCreateHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualCreateHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualCreateHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualCreateHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualCreateHeaderFieldResult.getDisabled());
    assertFalse(actualCreateHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualCreateHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualCreateHeaderFieldResult.getIsDerived());
    assertFalse(actualCreateHeaderFieldResult.getIsDirty());
    assertFalse(actualCreateHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualCreateHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualCreateHeaderFieldResult.getMainEntityLink());
    assertFalse(actualCreateHeaderFieldResult.getReadOnly());
    assertFalse(actualCreateHeaderFieldResult.getRequired());
    assertFalse(actualCreateHeaderFieldResult.getResizeDisabled());
    assertFalse(actualCreateHeaderFieldResult.getTranslatable());
    assertTrue(actualCreateHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualCreateHeaderFieldResult.getIsVisible());
    assertTrue(actualCreateHeaderFieldResult.getShouldRender());
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  public void testInitHeaderField() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  public void testInitHeaderField2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  public void testInitHeaderField3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  public void testIsComboField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isComboField(new BasicFieldMetadata()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  public void testIsComboField2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  public void testIsComboField3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  public void testIsSupportedFieldTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isSupportedFieldTypes(new BasicFieldMetadata(), SupportedFieldType.UNKNOWN));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  public void testIsSupportedFieldTypes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.isSupportedFieldTypes(fmd, SupportedFieldType.UNKNOWN));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  public void testIsSupportedFieldTypes3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = new Property();

    // Act and Assert
    assertTrue(formBuilderServiceImpl.propertyExistsInResultSet(property, new DynamicResultSet()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.propertyExistsInResultSet(null, new DynamicResultSet()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = mock(Property.class);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.propertyExistsInResultSet(property, new DynamicResultSet()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  public void testPropertyExistsInResultSet6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertEquals("Key", formBuilderServiceImpl.getMapKeyFriendlyName(new Property()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  public void testGetMapKeyFriendlyName4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap8() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap9() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap10() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap11() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isDerivedField(headerField, recordField, new Property()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = mock(Field.class);
    Field recordField = new Field();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isDerivedField(headerField, recordField, new Property()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  public void testIsDerivedField5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  public void testSetEntityFormFields2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  public void testSetEntityFormFields3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  public void testSetEntityFormFields4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  public void testSetDateToRecordField4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetFieldComponentRenderer4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getGridFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  public void testGetGridFieldComponentRenderer4() {
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
   * Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  public void testGetAdminSectionPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FormBuilderServiceImpl()).getAdminSectionPath(null));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}
   */
  @Test
  public void testGetUnprocessedNameOfMatchingTab() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getUnprocessedNameOfMatchingTab(tabMetadata, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}
   */
  @Test
  public void testGetUnprocessedNameOfMatchingTab2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    TabMetadata tabMetadata = mock(TabMetadata.class);

    // Act and Assert
    assertNull(formBuilderServiceImpl.getUnprocessedNameOfMatchingTab(tabMetadata, new HashSet<>()));
  }

  /**
   * Method under test: {@link FormBuilderServiceImpl#foundMatchingTab(String)}
   */
  @Test
  public void testFoundMatchingTab() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FormBuilderServiceImpl()).foundMatchingTab("Unprocessed Tab Name"));
    assertFalse((new FormBuilderServiceImpl()).foundMatchingTab(null));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  public void testTabExists() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.tabExists(new EntityForm(), "Tab Key"));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  public void testTabExists2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("Field Type", new BasicFieldMetadata()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_SIMPLE", new BasicFieldMetadata()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_SIMPLE_TIME", new BasicFieldMetadata()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_WITH_QUANTITY", new BasicFieldMetadata()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData8() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData9() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData10() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData11() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData12() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData13() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData14() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  public void testExtractDefaultValueFromFieldData15() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  public void testRemoveNonApplicableFields6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractSectionIdentifierFromCrumb(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FormBuilderServiceImpl()).extractSectionIdentifierFromCrumb(null));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  public void testExtractSectionIdentifierFromCrumb5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testSetVisibilityBasedOnShowIfFieldEquals8() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(fmd, new Entity()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(null, new Entity()));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  public void testShouldHideField8() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  public void testPopulateEntityFormFieldValues7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  public void testDecodeValueIfNeeded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata basicFM = new BasicFieldMetadata();
    basicFM.setLargeEntry(true);

    // Act and Assert
    assertEquals("42", formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42"));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  public void testDecodeValueIfNeeded2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper() throws JsonProcessingException {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new FormBuilderServiceImpl()).convertJsonToDataWrapper("Json"));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper3() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(42)));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper4() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString("42")));
  }

  /**
   * Method under test:
   * {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper5() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(null)));
  }

  /**
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  public void testPopulateDropdownToOneFields2() throws ServiceException {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  public void testPopulateDropdownToOneFields3() throws ServiceException {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  public void testSetReadOnlyState() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  public void testSetReadOnlyState2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  public void testGetSecurityClassname7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFields() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFields2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFields3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFields4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFields5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateEntityFormFields6() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields7() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields8() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields9() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields10() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields11() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields12() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields13() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  public void testPopulateEntityFormFields14() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  public void testPopulateAdornedEntityFormFields4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  public void testPopulateMapEntityFormFields5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties2() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties3() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties4() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties5() {
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
   * Method under test:
   * {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  public void testFilterMapFormProperties6() {
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

  /**
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
}
