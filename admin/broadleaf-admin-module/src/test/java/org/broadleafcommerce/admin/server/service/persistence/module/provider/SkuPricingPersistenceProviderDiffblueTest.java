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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
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

@ContextConfiguration(classes = {SkuPricingPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuPricingPersistenceProviderDiffblueTest {
  @Autowired private SkuPricingPersistenceProvider skuPricingPersistenceProvider;

  /**
   * Test {@link SkuPricingPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SkuPricingPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(49000, new SkuPricingPersistenceProvider().getOrder());
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code Target Class}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuPricingPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenTargetClass() throws PersistenceException {
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
    MetadataProviderResponse actualExtractValueResult =
        skuPricingPersistenceProvider.extractValue(extractValueRequest, new Property());

    // Assert
    verify(metadata, atLeast(1)).getTargetClass();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuPricingPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenUnknown_thenCallsGetFieldType() throws PersistenceException {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
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
    MetadataProviderResponse actualExtractValueResult =
        skuPricingPersistenceProvider.extractValue(
            extractValueRequest, new Property("Target Class", "42"));

    // Assert
    verify(metadata).getFieldType();
    verify(metadata).getTargetClass();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then throw {@link PersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuPricingPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenThrowPersistenceException() throws PersistenceException {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenThrow(new PersistenceException("An error occurred"));
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

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            skuPricingPersistenceProvider.extractValue(
                extractValueRequest, new Property("Target Class", "42")));
    verify(metadata).getFieldType();
    verify(metadata).getTargetClass();
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code ---} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse SkuPricingPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_whenPropertyWithNameIsDashDashDashAndValueIs42()
      throws PersistenceException {
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
    MetadataProviderResponse actualExtractValueResult =
        skuPricingPersistenceProvider.extractValue(extractValueRequest, new Property("---", "42"));

    // Assert
    verify(metadata).getTargetClass();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   *
   * <ul>
   *   <li>Then return {@code 2.30}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#formatValue(Object,
   * ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SkuPricingPersistenceProvider.formatValue(Object, ExtractValueRequest, Property)"
  })
  public void testFormatValueWithObjectExtractValueRequestProperty_thenReturn230() {
    // Arrange
    BigDecimal bigDecimal = new BigDecimal("2.3");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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

    // Act and Assert
    assertEquals(
        "2.30",
        skuPricingPersistenceProvider.formatValue(
            (Object) bigDecimal, extractValueRequest, new Property()));
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then return {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#formatValue(Object,
   * ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SkuPricingPersistenceProvider.formatValue(Object, ExtractValueRequest, Property)"
  })
  public void testFormatValueWithObjectExtractValueRequestProperty_whenMoney_thenReturn000() {
    // Arrange
    Money money = new Money();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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

    // Act and Assert
    assertEquals(
        "0.00",
        skuPricingPersistenceProvider.formatValue(money, extractValueRequest, new Property()));
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#formatValue(Object,
   * ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SkuPricingPersistenceProvider.formatValue(Object, ExtractValueRequest, Property)"
  })
  public void testFormatValueWithObjectExtractValueRequestProperty_whenNull_thenReturnNull() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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

    // Act and Assert
    assertNull(
        skuPricingPersistenceProvider.formatValue(
            (Object) null, extractValueRequest, new Property()));
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#formatDisplayValue(Object, ExtractValueRequest,
   * Property)} with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#formatDisplayValue(Object,
   * ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SkuPricingPersistenceProvider.formatDisplayValue(Object, ExtractValueRequest, Property)"
  })
  public void testFormatDisplayValueWithObjectExtractValueRequestProperty_thenReturnNull() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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

    // Act and Assert
    assertNull(
        skuPricingPersistenceProvider.formatDisplayValue(
            (Object) null, extractValueRequest, new Property()));
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code Target Class}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuPricingPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
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
        skuPricingPersistenceProvider.canHandleExtraction(extractValueRequest, new Property());

    // Assert
    verify(metadata, atLeast(1)).getTargetClass();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuPricingPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_givenUnknown_thenCallsGetFieldType() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
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
        skuPricingPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property("Target Class", "42"));

    // Assert
    verify(metadata).getFieldType();
    verify(metadata).getTargetClass();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then throw {@link PersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuPricingPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenThrowPersistenceException() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenThrow(new PersistenceException("An error occurred"));
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

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            skuPricingPersistenceProvider.canHandleExtraction(
                extractValueRequest, new Property("Target Class", "42")));
    verify(metadata).getFieldType();
    verify(metadata).getTargetClass();
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code ---} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuPricingPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_whenPropertyWithNameIsDashDashDashAndValueIs42() {
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
        skuPricingPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property("---", "42"));

    // Assert
    verify(metadata).getTargetClass();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuPricingPersistenceProvider.isDefaultSkuProperty(ExtractValueRequest, Property)"
  })
  public void testIsDefaultSkuProperty_givenName_whenPropertyGetNameReturnName_thenReturnFalse() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    // Act
    boolean actualIsDefaultSkuPropertyResult =
        skuPricingPersistenceProvider.isDefaultSkuProperty(extractValueRequest, property);

    // Assert
    verify(property).getName();
    assertFalse(actualIsDefaultSkuPropertyResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuPricingPersistenceProvider.isDefaultSkuProperty(ExtractValueRequest, Property)"
  })
  public void testIsDefaultSkuProperty_thenReturnTrue() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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
    boolean actualIsDefaultSkuPropertyResult =
        skuPricingPersistenceProvider.isDefaultSkuProperty(
            extractValueRequest, new Property("defaultSku", "42"));

    // Assert
    assertTrue(actualIsDefaultSkuPropertyResult);
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#getLocale(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@link Locale#ENGLISH}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#getLocale(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Locale SkuPricingPersistenceProvider.getLocale(ExtractValueRequest, Property)"
  })
  public void testGetLocale_thenReturnEnglish() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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

    // Act and Assert
    assertSame(
        Locale.ENGLISH,
        skuPricingPersistenceProvider.getLocale(extractValueRequest, new Property()));
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#getCurrency(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Currency SkuPricingPersistenceProvider.getCurrency(ExtractValueRequest, Property)"
  })
  public void testGetCurrency_thenReturnDisplayNameIsBritishPound() {
    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider =
        new SkuPricingPersistenceProvider();

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCurrency(currency);

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(skuImpl);

    // Act
    Currency actualCurrency =
        skuPricingPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(currency).getCurrencyCode();
    verify(extractValueRequest, atLeast(1)).getEntity();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test {@link SkuPricingPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then throw {@link PersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link SkuPricingPersistenceProvider#getCurrency(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Currency SkuPricingPersistenceProvider.getCurrency(ExtractValueRequest, Property)"
  })
  public void testGetCurrency_thenThrowPersistenceException() {
    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider =
        new SkuPricingPersistenceProvider();

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenThrow(new PersistenceException("An error occurred"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCurrency(currency);

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(skuImpl);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () -> skuPricingPersistenceProvider.getCurrency(extractValueRequest, new Property()));
    verify(currency).getCurrencyCode();
    verify(extractValueRequest, atLeast(1)).getEntity();
  }
}
