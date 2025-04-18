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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SkuFieldsPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuFieldsPersistenceProviderDiffblueTest {
  @Autowired
  private SkuFieldsPersistenceProvider skuFieldsPersistenceProvider;

  /**
   * Test {@link SkuFieldsPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SkuFieldsPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(49001, skuFieldsPersistenceProvider.getOrder());
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue() {
    // Arrange
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
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property()} RawValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenPropertyRawValueIsNull() {
    // Arrange
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
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and value is {@code 42} DisplayValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenPropertyWithNameAndValueIs42DisplayValueIsNull() {
    // Arrange
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
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and value is {@code 42} DisplayValue is {@code Requested Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenPropertyWithNameAndValueIs42DisplayValueIsRequestedValue() {
    // Arrange
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
   * Test {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuFieldsPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_thenReturnFalse() {
    // Arrange
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
   * Test {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuFieldsPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_whenPropertyWithNameAndValueIs42_thenReturnTrue() {
    // Arrange
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
}
