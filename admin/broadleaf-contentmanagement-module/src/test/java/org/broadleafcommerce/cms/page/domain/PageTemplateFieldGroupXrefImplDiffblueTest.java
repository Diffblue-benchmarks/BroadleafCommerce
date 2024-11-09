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
package org.broadleafcommerce.cms.page.domain;

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
import java.math.BigDecimal;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class PageTemplateFieldGroupXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageTemplateFieldGroupXrefImpl#PageTemplateFieldGroupXrefImpl()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setGroupOrder(BigDecimal)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setId(Long)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setPageTemplate(PageTemplate)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getFieldGroup()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getGroupOrder()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getId()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getPageTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageTemplateFieldGroupXrefImpl actualPageTemplateFieldGroupXrefImpl = new PageTemplateFieldGroupXrefImpl();
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualPageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);
    BigDecimal groupOrder = new BigDecimal("2.3");
    actualPageTemplateFieldGroupXrefImpl.setGroupOrder(groupOrder);
    actualPageTemplateFieldGroupXrefImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    actualPageTemplateFieldGroupXrefImpl.setPageTemplate(pageTemplate);
    FieldGroup actualFieldGroup = actualPageTemplateFieldGroupXrefImpl.getFieldGroup();
    BigDecimal actualGroupOrder = actualPageTemplateFieldGroupXrefImpl.getGroupOrder();
    Long actualId = actualPageTemplateFieldGroupXrefImpl.getId();
    PageTemplate actualPageTemplate = actualPageTemplateFieldGroupXrefImpl.getPageTemplate();

    // Assert that nothing has changed
    assertEquals(new BigDecimal("2.3"), actualGroupOrder);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(groupOrder, actualGroupOrder);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(pageTemplate, actualPageTemplate);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PageTemplateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PageTemplateFieldGroupXrefImpl#PageTemplateFieldGroupXrefImpl(PageTemplate, FieldGroup)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setGroupOrder(BigDecimal)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setId(Long)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setPageTemplate(PageTemplate)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getFieldGroup()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getGroupOrder()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getId()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getPageTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenPageTemplateImpl() {
    // Arrange
    PageTemplateImpl pageTemplate = new PageTemplateImpl();

    // Act
    PageTemplateFieldGroupXrefImpl actualPageTemplateFieldGroupXrefImpl = new PageTemplateFieldGroupXrefImpl(
        pageTemplate, new FieldGroupImpl());
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualPageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);
    BigDecimal groupOrder = new BigDecimal("2.3");
    actualPageTemplateFieldGroupXrefImpl.setGroupOrder(groupOrder);
    actualPageTemplateFieldGroupXrefImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    PageTemplateImpl pageTemplate2 = new PageTemplateImpl();
    actualPageTemplateFieldGroupXrefImpl.setPageTemplate(pageTemplate2);
    FieldGroup actualFieldGroup = actualPageTemplateFieldGroupXrefImpl.getFieldGroup();
    BigDecimal actualGroupOrder = actualPageTemplateFieldGroupXrefImpl.getGroupOrder();
    Long actualId = actualPageTemplateFieldGroupXrefImpl.getId();
    PageTemplate actualPageTemplate = actualPageTemplateFieldGroupXrefImpl.getPageTemplate();

    // Assert that nothing has changed
    assertEquals(new BigDecimal("2.3"), actualGroupOrder);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(groupOrder, actualGroupOrder);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(pageTemplate2, actualPageTemplate);
  }

  /**
   * Test
   * {@link PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl = new PageTemplateFieldGroupXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplateFieldGroupXref> actualCreateOrRetrieveCopyInstanceResult = pageTemplateFieldGroupXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link PageTemplateFieldGroupXrefImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnPageTemplateFieldGroupXrefImpl()
      throws CloneNotSupportedException {
    // Arrange
    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl = new PageTemplateFieldGroupXrefImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PageTemplateFieldGroupXref> actualCreateOrRetrieveCopyInstanceResult = pageTemplateFieldGroupXrefImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXrefImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PageTemplateFieldGroupXref clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PageTemplateFieldGroupXrefImpl);
    assertNull(clone.getId());
    assertNull(clone.getGroupOrder());
    assertNull(clone.getFieldGroup());
    assertNull(clone.getPageTemplate());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }
}
