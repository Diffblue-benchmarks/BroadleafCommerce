/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.mockito.Mockito;

public class IndexFieldTypeImplDiffblueTest {
  /**
   * Test {@link IndexFieldTypeImpl#getFieldType()}.
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#getFieldType()}
   */
  @Test
  public void testGetFieldType_givenIndexFieldTypeImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new IndexFieldTypeImpl()).getFieldType());
  }

  /**
   * Test {@link IndexFieldTypeImpl#setFieldType(FieldType)}.
   * <ul>
   *   <li>When {@link FieldType#BOOLEAN}.</li>
   *   <li>Then {@link IndexFieldTypeImpl} (default constructor)
   * {@link IndexFieldTypeImpl#fieldType} is {@code b}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#setFieldType(FieldType)}
   */
  @Test
  public void testSetFieldType_whenBoolean_thenIndexFieldTypeImplFieldTypeIsB() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    FieldType fieldType = FieldType.BOOLEAN;

    // Act
    indexFieldTypeImpl.setFieldType(fieldType);

    // Assert
    assertEquals("b", indexFieldTypeImpl.fieldType);
    FieldType expectedFieldType = fieldType.BOOLEAN;
    assertSame(expectedFieldType, indexFieldTypeImpl.getFieldType());
  }

  /**
   * Test
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult = indexFieldTypeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link IndexFieldTypeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnIndexFieldTypeImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult = indexFieldTypeImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    IndexFieldType clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof IndexFieldTypeImpl);
    assertNull(clone.getId());
    assertNull(((IndexFieldTypeImpl) clone).fieldType);
    assertNull(clone.getIndexField());
    assertNull(clone.getFieldType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexFieldTypeImpl}
   *   <li>{@link IndexFieldTypeImpl#setId(Long)}
   *   <li>{@link IndexFieldTypeImpl#setIndexField(IndexField)}
   *   <li>{@link IndexFieldTypeImpl#getId()}
   *   <li>{@link IndexFieldTypeImpl#getIndexField()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexFieldTypeImpl actualIndexFieldTypeImpl = new IndexFieldTypeImpl();
    actualIndexFieldTypeImpl.setId(1L);
    IndexFieldImpl indexField = new IndexFieldImpl();
    actualIndexFieldTypeImpl.setIndexField(indexField);
    Long actualId = actualIndexFieldTypeImpl.getId();
    IndexField actualIndexField = actualIndexFieldTypeImpl.getIndexField();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(indexField, actualIndexField);
  }
}
