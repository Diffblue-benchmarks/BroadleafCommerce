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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
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
  @Autowired private SkuFieldsPersistenceProvider skuFieldsPersistenceProvider;

  /**
   * Test {@link SkuFieldsPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link SkuFieldsPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SkuFieldsPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(49001, skuFieldsPersistenceProvider.getOrder());
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <p>Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property("Target Class", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(metadata).getTargetClass();
    assertEquals("Requested Value", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <p>Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue2() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.Sku");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property("Target Class", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(metadata, atLeast(1)).getTargetClass();
    assertEquals("Requested Value", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <p>Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue3() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BreadcrumbDTOType breadcrumbDTOType =
        new BreadcrumbDTOType(
            "org.broadleafcommerce.core.catalog.domain.SkuImpl",
            "org.broadleafcommerce.core.catalog.domain.SkuImpl");
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            breadcrumbDTOType,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property("Target Class", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(metadata).getTargetClass();
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getDisplayValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getRawValue());
    assertEquals(
        "org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getUnHtmlEncodedValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getValue());
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code Target Class}.
   *   <li>Then {@link Property#Property()} RawValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenTargetClass_thenPropertyRawValueIsNull() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("Target Class");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property();

    // Act
    MetadataProviderResponse actualExtractValueResult =
        skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(metadata, atLeast(1)).getTargetClass();
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with name is {@code ---} and value is
   *       {@code 42} RawValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenPropertyWithNameIsDashDashDashAndValueIs42RawValueIs42() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property("---", "42");

    // Act
    MetadataProviderResponse actualExtractValueResult =
        skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(metadata).getTargetClass();
    assertEquals("42", property.getRawValue());
    assertEquals("42", property.getUnHtmlEncodedValue());
    assertEquals("42", property.getValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with name is {@code Target Class} and
   *       value is {@code 42} DisplayValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuFieldsPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenPropertyWithNameIsTargetClassAndValueIs42DisplayValueIsNull() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BreadcrumbDTOType breadcrumbDTOType = new BreadcrumbDTOType();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            breadcrumbDTOType,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property("Target Class", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(metadata).getTargetClass();
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code Target Class}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuFieldsPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_givenTargetClass() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("Target Class");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    boolean actualCanHandleExtractionResult =
        skuFieldsPersistenceProvider.canHandleExtraction(extractValueRequest, new Property());

    // Assert
    verify(metadata, atLeast(1)).getTargetClass();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuFieldsPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenReturnFalse() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    boolean actualCanHandleExtractionResult =
        skuFieldsPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property("---", "42"));

    // Assert
    verify(metadata).getTargetClass();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuFieldsPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    boolean actualCanHandleExtractionResult =
        skuFieldsPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property("Target Class", "42"));

    // Assert
    verify(metadata).getTargetClass();
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuFieldsPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenReturnTrue2() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getTargetClass()).thenReturn("org.broadleafcommerce.core.catalog.domain.Sku");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    boolean actualCanHandleExtractionResult =
        skuFieldsPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property("Target Class", "42"));

    // Assert
    verify(metadata, atLeast(1)).getTargetClass();
    assertTrue(actualCanHandleExtractionResult);
  }
}
