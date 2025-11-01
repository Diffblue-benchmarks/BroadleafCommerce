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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;

public class DefaultFieldPersistenceProviderDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
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
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertSame(property, populateValueRequest.getProperty());
  }

  /**
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue2()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
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
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertSame(property, populateValueRequest.getProperty());
  }

  /**
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue3()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
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
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertSame(property, populateValueRequest.getProperty());
  }

  /**
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue4()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
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
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertSame(property, populateValueRequest.getProperty());
  }

  /**
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue5()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
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
    assertEquals(MetadataProviderResponse.HANDLED, actualPopulateValueResult);
    assertSame(property, populateValueRequest.getProperty());
  }

  /**
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property = new Property();

    // Act
    MetadataProviderResponse actualExtractValueResult = defaultFieldPersistenceProvider
        .extractValue(extractValueRequest, property);

    // Assert
    assertEquals("Display Val", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue2() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn(null);
    Property property = new Property();

    // Act
    MetadataProviderResponse actualExtractValueResult = defaultFieldPersistenceProvider
        .extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getRequestedValue();
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }
}
