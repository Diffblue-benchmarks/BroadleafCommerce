/*-
 * #%L
 * BroadleafCommerce CMS Module
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

public class StructuredContentTypeImplDiffblueTest {
  /**
   * Test {@link StructuredContentTypeImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link StructuredContentTypeImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    structuredContentTypeImpl.setStructuredContentFieldTemplate(mock(StructuredContentFieldTemplateImpl.class));

    // Act and Assert
    assertNull(structuredContentTypeImpl.getMainEntityName());
  }

  /**
   * Test {@link StructuredContentTypeImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link StructuredContentTypeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentTypeImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenStructuredContentTypeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentTypeImpl()).getMainEntityName());
  }

  /**
   * Test
   * {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentType> actualCreateOrRetrieveCopyInstanceResult = structuredContentTypeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StructuredContentTypeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStructuredContentTypeImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentType> actualCreateOrRetrieveCopyInstanceResult = structuredContentTypeImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentType clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentTypeImpl);
    assertNull(clone.getId());
    assertNull(clone.getDescription());
    assertNull(clone.getName());
    assertNull(((StructuredContentTypeImpl) clone).getMainEntityName());
    assertNull(clone.getStructuredContentFieldTemplate());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentTypeImpl}
   *   <li>{@link StructuredContentTypeImpl#setDescription(String)}
   *   <li>{@link StructuredContentTypeImpl#setId(Long)}
   *   <li>{@link StructuredContentTypeImpl#setName(String)}
   *   <li>
   * {@link StructuredContentTypeImpl#setStructuredContentFieldTemplate(StructuredContentFieldTemplate)}
   *   <li>{@link StructuredContentTypeImpl#getDescription()}
   *   <li>{@link StructuredContentTypeImpl#getId()}
   *   <li>{@link StructuredContentTypeImpl#getName()}
   *   <li>{@link StructuredContentTypeImpl#getStructuredContentFieldTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentTypeImpl actualStructuredContentTypeImpl = new StructuredContentTypeImpl();
    actualStructuredContentTypeImpl.setDescription("The characteristics of someone or something");
    actualStructuredContentTypeImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentTypeImpl.setName("Name");
    StructuredContentFieldTemplateImpl scft = new StructuredContentFieldTemplateImpl();
    actualStructuredContentTypeImpl.setStructuredContentFieldTemplate(scft);
    String actualDescription = actualStructuredContentTypeImpl.getDescription();
    Long actualId = actualStructuredContentTypeImpl.getId();
    String actualName = actualStructuredContentTypeImpl.getName();
    StructuredContentFieldTemplate actualStructuredContentFieldTemplate = actualStructuredContentTypeImpl
        .getStructuredContentFieldTemplate();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(scft, actualStructuredContentFieldTemplate);
  }
}
