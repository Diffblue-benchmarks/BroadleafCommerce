/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentFieldImplDiffblueTest {
  /**
   * Method under test: {@link StructuredContentFieldImpl#getValue()}
   */
  @Test
  public void testGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentFieldImpl()).getValue());
  }

  /**
   * Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  public void testSetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();

    // Act
    structuredContentFieldImpl.setValue("42");

    // Assert
    assertEquals("42", structuredContentFieldImpl.getValue());
    assertEquals("42", structuredContentFieldImpl.stringValue);
  }

  /**
   * Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  public void testSetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();
    structuredContentFieldImpl.setFieldKey("Field Key");
    structuredContentFieldImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);

    // Act
    structuredContentFieldImpl.setValue(null);

    // Assert
    assertNull(structuredContentFieldImpl.getValue());
    assertNull(structuredContentFieldImpl.stringValue);
  }

  /**
   * Method under test: {@link StructuredContentFieldImpl#clone()}
   */
  @Test
  public void testClone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StructuredContentField actualCloneResult = (new StructuredContentFieldImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof StructuredContentFieldImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getFieldKey());
    assertNull(actualCloneResult.getValue());
    assertNull(((StructuredContentFieldImpl) actualCloneResult).lobValue);
    assertNull(((StructuredContentFieldImpl) actualCloneResult).stringValue);
  }

  /**
   * Method under test:
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentFieldImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentField clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentFieldImpl);
    assertNull(clone.getId());
    assertNull(clone.getFieldKey());
    assertNull(clone.getValue());
    assertNull(((StructuredContentFieldImpl) clone).lobValue);
    assertNull(((StructuredContentFieldImpl) clone).stringValue);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Method under test:
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StructuredContentFieldImpl}
   *   <li>{@link StructuredContentFieldImpl#setFieldKey(String)}
   *   <li>{@link StructuredContentFieldImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldImpl#getFieldKey()}
   *   <li>{@link StructuredContentFieldImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldImpl actualStructuredContentFieldImpl = new StructuredContentFieldImpl();
    actualStructuredContentFieldImpl.setFieldKey("Field Key");
    actualStructuredContentFieldImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    String actualFieldKey = actualStructuredContentFieldImpl.getFieldKey();

    // Assert that nothing has changed
    assertEquals("Field Key", actualFieldKey);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID,
        actualStructuredContentFieldImpl.getId().longValue());
  }
}
