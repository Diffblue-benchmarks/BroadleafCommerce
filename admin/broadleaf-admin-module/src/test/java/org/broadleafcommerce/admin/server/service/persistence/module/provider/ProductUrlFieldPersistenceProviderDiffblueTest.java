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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.admin.server.service.persistence.module.provider.extension.ProductUrlFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductUrlFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductUrlFieldPersistenceProviderDiffblueTest {
  @Autowired private ProductUrlFieldPersistenceProvider productUrlFieldPersistenceProvider;

  @MockBean(name = "blProductUrlFieldPersistenceProviderExtensionManager")
  private ProductUrlFieldPersistenceProviderExtensionManager
      productUrlFieldPersistenceProviderExtensionManager;

  /**
   * Test {@link ProductUrlFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@code url}.
   *   <li>When {@link Property#Property()} Name is {@code url}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductUrlFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse ProductUrlFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenUrl_whenPropertyNameIsUrl_thenReturnNotHandled() {
    // Arrange
    Property property = new Property();
    property.setName("url");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult =
        productUrlFieldPersistenceProvider.populateValue(
            request, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link ProductUrlFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductUrlFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse ProductUrlFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_thenReturnNotHandled() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult =
        productUrlFieldPersistenceProvider.populateValue(
            request, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }
}
