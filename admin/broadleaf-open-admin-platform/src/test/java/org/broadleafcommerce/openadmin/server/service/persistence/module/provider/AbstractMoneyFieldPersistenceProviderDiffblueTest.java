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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mvel2.util.InternalNumber;

public class AbstractMoneyFieldPersistenceProviderDiffblueTest {
  /**
   * Test
   * {@link AbstractMoneyFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMoneyFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() throws PersistenceException {
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
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        moneyFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link AbstractMoneyFieldPersistenceProvider#formatValue(BigDecimal, ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then return {@code Mock for Int.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMoneyFieldPersistenceProvider#formatValue(BigDecimal, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatValue_givenTen_thenReturnMockForInt00() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();
    InternalNumber value = mock(InternalNumber.class);
    when(value.signum()).thenReturn(10);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatValueResult = moneyFieldPersistenceProvider.formatValue(value, extractValueRequest,
        new Property());

    // Assert
    verify(value).signum();
    assertEquals("Mock for Int.00", actualFormatValueResult);
  }

  /**
   * Test
   * {@link AbstractMoneyFieldPersistenceProvider#formatDisplayValue(BigDecimal, ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then return {@code £Moc,k f,or ,Int.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMoneyFieldPersistenceProvider#formatDisplayValue(BigDecimal, ExtractValueRequest, Property)}
   */
  @Test
  public void testFormatDisplayValue_givenTen_thenReturnMocKFOrInt00() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();
    InternalNumber value = mock(InternalNumber.class);
    when(value.signum()).thenReturn(10);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    String actualFormatDisplayValueResult = moneyFieldPersistenceProvider.formatDisplayValue(value, extractValueRequest,
        new Property());

    // Assert
    verify(value).signum();
    assertEquals("£Moc,k f,or ,Int.00", actualFormatDisplayValueResult);
  }
}
