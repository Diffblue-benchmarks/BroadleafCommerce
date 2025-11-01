/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class SkuFieldsPersistenceProviderDiffblueTest {
  /**
   * Method under test: {@link SkuFieldsPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(49001, (new SkuFieldsPersistenceProvider()).getOrder());
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("Target Class");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");
    when(extractValueRequest.getRecordHelper()).thenReturn(new AdornedTargetListPersistenceModule());
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest).getRequestedValue();
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Requested Value", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType(
        "org.broadleafcommerce.core.catalog.domain.SkuImpl", "org.broadleafcommerce.core.catalog.domain.SkuImpl"));
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getDisplayValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getRawValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getUnHtmlEncodedValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getValue());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType());
    when(extractValueRequest.getRecordHelper()).thenReturn(new AdornedTargetListPersistenceModule());
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue5() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(
        adornedTargetListPersistenceModule.getStringValueFromGetter(Mockito.<Serializable>any(), Mockito.<String>any()))
        .thenReturn("42");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType());
    when(extractValueRequest.getRecordHelper()).thenReturn(adornedTargetListPersistenceModule);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(adornedTargetListPersistenceModule).getStringValueFromGetter(isA(Serializable.class), eq("Name"));
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
    assertTrue(((BasicFieldMetadata) metadata).getIsDerived());
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        new Property("---", "42"));

    // Assert
    verify(extractValueRequest).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue7() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(
        adornedTargetListPersistenceModule.getStringValueFromGetter(Mockito.<Serializable>any(), Mockito.<String>any()))
        .thenReturn("42");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType());
    when(extractValueRequest.getRecordHelper()).thenReturn(adornedTargetListPersistenceModule);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    doNothing().when(property).setDisplayValue(Mockito.<String>any());
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getName()).thenReturn("Name");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(property).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(property).setDisplayValue(eq("42"));
    verify(property).setValue(isNull());
    verify(adornedTargetListPersistenceModule).getStringValueFromGetter(isA(Serializable.class), eq("Name"));
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("Target Class");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuFieldsPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuFieldsPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property("Name", "42"));

    // Assert
    verify(extractValueRequest).getMetadata();
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuFieldsPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property("---", "42"));

    // Assert
    verify(extractValueRequest).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }
}
