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
package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class PageTemplateFieldGroupXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageTemplateFieldGroupXrefImpl.<init>()",
    "void PageTemplateFieldGroupXrefImpl.<init>(PageTemplate, FieldGroup)",
    "FieldGroup PageTemplateFieldGroupXrefImpl.getFieldGroup()",
    "BigDecimal PageTemplateFieldGroupXrefImpl.getGroupOrder()",
    "Long PageTemplateFieldGroupXrefImpl.getId()",
    "PageTemplate PageTemplateFieldGroupXrefImpl.getPageTemplate()",
    "void PageTemplateFieldGroupXrefImpl.setFieldGroup(FieldGroup)",
    "void PageTemplateFieldGroupXrefImpl.setGroupOrder(BigDecimal)",
    "void PageTemplateFieldGroupXrefImpl.setId(Long)",
    "void PageTemplateFieldGroupXrefImpl.setPageTemplate(PageTemplate)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageTemplateFieldGroupXrefImpl actualPageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
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

    // Assert
    assertEquals(new BigDecimal("2.3"), actualGroupOrder);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(groupOrder, actualGroupOrder);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(pageTemplate, actualPageTemplate);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link PageTemplateImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageTemplateFieldGroupXrefImpl#PageTemplateFieldGroupXrefImpl(PageTemplate,
   *       FieldGroup)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageTemplateFieldGroupXrefImpl.<init>()",
    "void PageTemplateFieldGroupXrefImpl.<init>(PageTemplate, FieldGroup)",
    "FieldGroup PageTemplateFieldGroupXrefImpl.getFieldGroup()",
    "BigDecimal PageTemplateFieldGroupXrefImpl.getGroupOrder()",
    "Long PageTemplateFieldGroupXrefImpl.getId()",
    "PageTemplate PageTemplateFieldGroupXrefImpl.getPageTemplate()",
    "void PageTemplateFieldGroupXrefImpl.setFieldGroup(FieldGroup)",
    "void PageTemplateFieldGroupXrefImpl.setGroupOrder(BigDecimal)",
    "void PageTemplateFieldGroupXrefImpl.setId(Long)",
    "void PageTemplateFieldGroupXrefImpl.setPageTemplate(PageTemplate)"
  })
  public void testGettersAndSetters_whenPageTemplateImpl() {
    // Arrange
    PageTemplateImpl pageTemplate = new PageTemplateImpl();

    // Act
    PageTemplateFieldGroupXrefImpl actualPageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl(pageTemplate, new FieldGroupImpl());
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

    // Assert
    assertEquals(new BigDecimal("2.3"), actualGroupOrder);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(groupOrder, actualGroupOrder);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(pageTemplate2, actualPageTemplate);
  }

  /**
   * Test {@link
   * PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageTemplateFieldGroupXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new PageTemplateFieldGroupXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplateFieldGroupXref> actualCreateOrRetrieveCopyInstanceResult =
        pageTemplateFieldGroupXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageTemplateFieldGroupXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl2 =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl2.setFieldGroup(new FieldGroupImpl());
    pageTemplateFieldGroupXrefImpl2.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateFieldGroupXrefImpl2.setPageTemplate(new PageTemplateImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(pageTemplateFieldGroupXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplateFieldGroupXref> actualCreateOrRetrieveCopyInstanceResult =
        pageTemplateFieldGroupXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageTemplateFieldGroupXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsCreateOrRetrieveCopyInstance()
      throws CloneNotSupportedException {
    // Arrange
    PageTemplateImpl pageTemplate = mock(PageTemplateImpl.class);
    when(pageTemplate.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new PageTemplateImpl(), true));

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setPageTemplate(pageTemplate);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl2 =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl2.setFieldGroup(new FieldGroupImpl());
    pageTemplateFieldGroupXrefImpl2.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateFieldGroupXrefImpl2.setPageTemplate(new PageTemplateImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(pageTemplateFieldGroupXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplateFieldGroupXref> actualCreateOrRetrieveCopyInstanceResult =
        pageTemplateFieldGroupXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(pageTemplate).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }
}
