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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MoneyFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MoneyFieldPersistenceProviderDiffblueTest {
  @Autowired
  private MoneyFieldPersistenceProvider moneyFieldPersistenceProvider;

  /**
   * Test {@link MoneyFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link MoneyFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MoneyFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MONEY, (new MoneyFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MoneyFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_thenReturnFalse() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

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
   * Test {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}.
   * <p>
   * Method under test: {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale MoneyFieldPersistenceProvider.getLocale(ExtractValueRequest, Property)"})
  public void testGetLocale() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata,
        broadleafRequestContext, "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    Locale actualLocale = moneyFieldPersistenceProvider.getLocale(extractValueRequest, new Property());

    // Assert
    Object requestedValue = extractValueRequest.getRequestedValue();
    assertTrue(requestedValue instanceof BroadleafRequestContext);
    Locale locale = actualLocale.ENGLISH;
    assertSame(locale, ((BroadleafRequestContext) requestedValue).getJavaLocale());
    assertSame(locale, actualLocale);
  }

  /**
   * Test {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@link Locale#ENGLISH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale MoneyFieldPersistenceProvider.getLocale(ExtractValueRequest, Property)"})
  public void testGetLocale_thenReturnEnglish() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    Locale actualLocale = moneyFieldPersistenceProvider.getLocale(extractValueRequest, new Property());

    // Assert
    assertSame(actualLocale.ENGLISH, actualLocale);
  }
}
