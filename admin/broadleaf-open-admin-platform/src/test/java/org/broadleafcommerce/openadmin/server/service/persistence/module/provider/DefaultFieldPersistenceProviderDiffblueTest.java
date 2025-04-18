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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultFieldPersistenceProviderDiffblueTest {
  @Autowired
  private DefaultFieldPersistenceProvider defaultFieldPersistenceProvider;

  /**
   * Test {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult = defaultFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    Property property2 = populateValueRequest.getProperty();
    assertEquals("Field Value", property2.getOriginalDisplayValue());
    assertEquals("Field Value", property2.getOriginalValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertFalse(property2.getIsDirty());
  }

  /**
   * Test {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue2()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(" /");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult = defaultFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    Property property2 = populateValueRequest.getProperty();
    assertEquals(" /", property2.getOriginalDisplayValue());
    assertEquals(" /", property2.getOriginalValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertFalse(property2.getIsDirty());
  }

  /**
   * Test {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue3()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(null);
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult = defaultFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    Property property2 = populateValueRequest.getProperty();
    assertNull(property2.getOriginalDisplayValue());
    assertNull(property2.getOriginalValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertFalse(property2.getIsDirty());
  }

  /**
   * Test {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue4()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getDefaultValue()).thenReturn("42");
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult = defaultFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata).getDefaultValue();
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    Property property2 = populateValueRequest.getProperty();
    assertEquals("Field Value", property2.getOriginalDisplayValue());
    assertEquals("Field Value", property2.getOriginalValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertTrue(property2.getIsDirty());
  }

  /**
   * Test {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue5()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getDefaultValue()).thenReturn("");
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult = defaultFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata).getDefaultValue();
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    Property property2 = populateValueRequest.getProperty();
    assertEquals("Field Value", property2.getOriginalDisplayValue());
    assertEquals("Field Value", property2.getOriginalValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertFalse(property2.getIsDirty());
  }

  /**
   * Test {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property()} DisplayValue is {@code Display Val}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenPropertyDisplayValueIsDisplayVal() throws PersistenceException {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property = new Property();

    // Act
    defaultFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    assertEquals("Display Val", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
  }

  /**
   * Test {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property()} DisplayValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenPropertyDisplayValueIsNull() throws PersistenceException {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, null, null,
        persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"), new String[]{"Custom Criteria"});

    Property property = new Property();
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act
    defaultFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert that nothing has changed
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
  }
}
