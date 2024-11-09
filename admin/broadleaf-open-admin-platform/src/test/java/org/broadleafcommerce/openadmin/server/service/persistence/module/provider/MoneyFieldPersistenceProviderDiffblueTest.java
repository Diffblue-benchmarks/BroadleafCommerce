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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.junit.Test;
import org.mockito.Mockito;

public class MoneyFieldPersistenceProviderDiffblueTest {
  /**
   * Test {@link MoneyFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link MoneyFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MONEY, (new MoneyFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(moneyFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@link Locale#UK}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetLocale_thenReturnUk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    Locale actualLocale = moneyFieldPersistenceProvider.getLocale(extractValueRequest, new Property());

    // Assert
    assertSame(actualLocale.UK, actualLocale);
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency2() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), eq("GBP"));
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) CurrencyCodeField
   * is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenBasicFieldMetadataCurrencyCodeFieldIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link FieldManager}
   * {@link FieldManager#getFieldValue(Object, String)} return
   * {@code Field Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenFieldManagerGetFieldValueReturnFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), eq("GBP"));
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link FieldManager}
   * {@link FieldManager#getFieldValue(Object, String)} return two.</li>
   *   <li>Then calls {@link FieldManager#getFieldValue(Object, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenFieldManagerGetFieldValueReturnTwo_thenCallsGetFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(2);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), eq("GBP"));
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ExtractValueRequest}
   * {@link ExtractValueRequest#getFieldManager()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenNull_whenExtractValueRequestGetFieldManagerReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(null);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }
}
