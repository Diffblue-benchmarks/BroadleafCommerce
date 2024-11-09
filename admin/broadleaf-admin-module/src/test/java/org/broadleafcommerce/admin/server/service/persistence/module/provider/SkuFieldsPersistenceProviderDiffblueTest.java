/*-
 * #%L
 * BroadleafCommerce Admin Module
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
   * Test {@link SkuFieldsPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(49001, (new SkuFieldsPersistenceProvider()).getOrder());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() {
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
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getDisplayValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getRawValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getUnHtmlEncodedValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getValue());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_givenAdornedTargetCollectionMetadata_thenReturnHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property()} RawValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyRawValueIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("Target Class");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property();

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42} DisplayValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameAndValueIs42DisplayValueIsNull() {
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
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42} DisplayValue is {@code Requested Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameAndValueIs42DisplayValueIsRequestedValue() {
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
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest).getRequestedValue();
    assertEquals("Requested Value", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42} Metadata {@link BasicFieldMetadata}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameAndValueIs42MetadataBasicFieldMetadata()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

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
    assertTrue(((BasicFieldMetadata) metadata).getIsDerived());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with name is {@code ---}
   * and value is {@code 42} RawValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameIsDashDashDashAndValueIs42RawValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("---", "42");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(extractValueRequest).getMetadata();
    assertEquals("42", property.getRawValue());
    assertEquals("42", property.getUnHtmlEncodedValue());
    assertEquals("42", property.getValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) TargetClass is
   * {@code Target Class}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_givenBasicFieldMetadataTargetClassIsTargetClass() {
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
   * Test
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_whenPropertyWithNameAndValueIs42_thenReturnTrue() {
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
   * Test
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code ---}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_whenPropertyWithNameIsDashDashDashAndValueIs42() {
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
