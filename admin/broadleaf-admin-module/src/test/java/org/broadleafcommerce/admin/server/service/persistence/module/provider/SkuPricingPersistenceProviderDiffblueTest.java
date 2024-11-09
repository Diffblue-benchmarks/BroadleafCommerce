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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.BaseSessionEventListener;
import org.hibernate.SessionEventListener;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class SkuPricingPersistenceProviderDiffblueTest {
  /**
   * Test {@link SkuPricingPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link SkuPricingPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(49000, (new SkuPricingPersistenceProvider()).getOrder());
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) TargetClass is
   * {@code Target Class}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_givenBasicFieldMetadataTargetClassIsTargetClass() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("Target Class");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = skuPricingPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_whenPropertyWithNameAndValueIs42_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = skuPricingPersistenceProvider.extractValue(extractValueRequest,
        new Property("Name", "42"));

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code ---}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_whenPropertyWithNameIsDashDashDashAndValueIs42() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = skuPricingPersistenceProvider.extractValue(extractValueRequest,
        new Property("---", "42"));

    // Assert
    verify(extractValueRequest).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   * <ul>
   *   <li>Then return {@code 2.30}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatValueWithObjectExtractValueRequestProperty_thenReturn230() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    BigDecimal bigDecimal = new BigDecimal("2.3");
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    doNothing().when(entityManager).addEventListeners((SessionEventListener[]) any());
    entityManager.addEventListeners(new BaseSessionEventListener());
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), entityManager);

    ArrayList<Property> props = new ArrayList<>();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatValueResult = skuPricingPersistenceProvider.formatValue((Object) bigDecimal, extractValueRequest,
        new Property());

    // Assert
    verify(entityManager).addEventListeners((SessionEventListener[]) any());
    assertEquals("2.30", actualFormatValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatValueWithObjectExtractValueRequestProperty_whenMoney_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    Money money = new Money();
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    doNothing().when(entityManager).addEventListeners((SessionEventListener[]) any());
    entityManager.addEventListeners(new BaseSessionEventListener());
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), entityManager);

    ArrayList<Property> props = new ArrayList<>();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatValueResult = skuPricingPersistenceProvider.formatValue(money, extractValueRequest,
        new Property());

    // Assert
    verify(entityManager).addEventListeners((SessionEventListener[]) any());
    assertEquals("0.00", actualFormatValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#formatValue(Object, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatValueWithObjectExtractValueRequestProperty_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    doNothing().when(entityManager).addEventListeners((SessionEventListener[]) any());
    entityManager.addEventListeners(new BaseSessionEventListener());
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), entityManager);

    ArrayList<Property> props = new ArrayList<>();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatValueResult = skuPricingPersistenceProvider.formatValue((Object) null, extractValueRequest,
        new Property());

    // Assert
    verify(entityManager).addEventListeners((SessionEventListener[]) any());
    assertNull(actualFormatValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#formatDisplayValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   * <ul>
   *   <li>Then return {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#formatDisplayValue(Object, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatDisplayValueWithObjectExtractValueRequestProperty_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    Money money = new Money();
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    doNothing().when(entityManager).addEventListeners((SessionEventListener[]) any());
    entityManager.addEventListeners(new BaseSessionEventListener());
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), entityManager);

    ArrayList<Property> props = new ArrayList<>();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatDisplayValueResult = skuPricingPersistenceProvider.formatDisplayValue(money, extractValueRequest,
        new Property());

    // Assert
    verify(entityManager).addEventListeners((SessionEventListener[]) any());
    assertEquals("£0.00", actualFormatDisplayValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#formatDisplayValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   * <ul>
   *   <li>Then return {@code £2.30}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#formatDisplayValue(Object, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatDisplayValueWithObjectExtractValueRequestProperty_thenReturn230() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    BigDecimal bigDecimal = new BigDecimal("2.3");
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    doNothing().when(entityManager).addEventListeners((SessionEventListener[]) any());
    entityManager.addEventListeners(new BaseSessionEventListener());
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), entityManager);

    ArrayList<Property> props = new ArrayList<>();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatDisplayValueResult = skuPricingPersistenceProvider.formatDisplayValue((Object) bigDecimal,
        extractValueRequest, new Property());

    // Assert
    verify(entityManager).addEventListeners((SessionEventListener[]) any());
    assertEquals("£2.30", actualFormatDisplayValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#formatDisplayValue(Object, ExtractValueRequest, Property)}
   * with {@code Object}, {@code ExtractValueRequest}, {@code Property}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#formatDisplayValue(Object, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatDisplayValueWithObjectExtractValueRequestProperty_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    SessionDelegatorBaseImpl entityManager = mock(SessionDelegatorBaseImpl.class);
    doNothing().when(entityManager).addEventListeners((SessionEventListener[]) any());
    entityManager.addEventListeners(new BaseSessionEventListener());
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), entityManager);

    ArrayList<Property> props = new ArrayList<>();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatDisplayValueResult = skuPricingPersistenceProvider.formatDisplayValue((Object) null,
        extractValueRequest, new Property());

    // Assert
    verify(entityManager).addEventListeners((SessionEventListener[]) any());
    assertNull(actualFormatDisplayValueResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) TargetClass is
   * {@code Target Class}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_givenBasicFieldMetadataTargetClassIsTargetClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("Target Class");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuPricingPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_whenPropertyWithNameAndValueIs42_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuPricingPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property("Name", "42"));

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code ---}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_whenPropertyWithNameIsDashDashDashAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuPricingPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property("---", "42"));

    // Assert
    verify(extractValueRequest).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code defaultSku}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}
   */
  @Test
  public void testIsDefaultSkuProperty_givenDefaultSku_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property = new Property();
    property.setName("defaultSku");

    // Act and Assert
    assertTrue(skuPricingPersistenceProvider.isDefaultSkuProperty(extractValueRequest, property));
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When {@link Property#Property()} Name is {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#isDefaultSkuProperty(ExtractValueRequest, Property)}
   */
  @Test
  public void testIsDefaultSkuProperty_givenName_whenPropertyNameIsName_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property = new Property();
    property.setName("Name");

    // Act and Assert
    assertFalse(skuPricingPersistenceProvider.isDefaultSkuProperty(extractValueRequest, property));
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#getLocale(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@link Locale#UK}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#getLocale(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetLocale_thenReturnUk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    Locale actualLocale = skuPricingPersistenceProvider.getLocale(extractValueRequest, new Property());

    // Assert
    assertSame(actualLocale.UK, actualLocale);
  }

  /**
   * Test
   * {@link SkuPricingPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_thenReturnDisplayNameIsBritishPound() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuPricingPersistenceProvider skuPricingPersistenceProvider = new SkuPricingPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    Currency actualCurrency = skuPricingPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }
}
