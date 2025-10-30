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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageFieldImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PageFieldImplDiffblueTest {
  @Autowired
  private PageFieldImpl pageFieldImpl;

  /**
   * Test {@link PageFieldImpl#getValue()}.
   * <p>
   * Method under test: {@link PageFieldImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageFieldImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new PageFieldImpl()).getValue());
  }

  /**
   * Test {@link PageFieldImpl#setValue(String)}.
   * <ul>
   *   <li>Given {@link PageFieldImpl} (default constructor) FieldKey is {@code Field Key}.</li>
   *   <li>Then {@link PageFieldImpl} (default constructor) Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageFieldImpl#setValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageFieldImpl.setValue(String)"})
  public void testSetValue_givenPageFieldImplFieldKeyIsFieldKey_thenPageFieldImplValueIsNull() {
    // Arrange
    PageFieldImpl pageFieldImpl2 = new PageFieldImpl();
    pageFieldImpl2.setFieldKey("Field Key");
    pageFieldImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageFieldImpl2.setPage(new PageImpl());

    // Act
    pageFieldImpl2.setValue(null);

    // Assert that nothing has changed
    assertNull(pageFieldImpl2.getValue());
    assertNull(pageFieldImpl2.stringValue);
  }

  /**
   * Test {@link PageFieldImpl#setValue(String)}.
   * <ul>
   *   <li>Given {@link PageFieldImpl} (default constructor).</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PageFieldImpl} (default constructor) Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageFieldImpl#setValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageFieldImpl.setValue(String)"})
  public void testSetValue_givenPageFieldImpl_when42_thenPageFieldImplValueIs42() {
    // Arrange
    PageFieldImpl pageFieldImpl2 = new PageFieldImpl();

    // Act
    pageFieldImpl2.setValue("42");

    // Assert
    assertEquals("42", pageFieldImpl2.getValue());
    assertEquals("42", pageFieldImpl2.stringValue);
  }

  /**
   * Test {@link PageFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link PageFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PageFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PageFieldImpl pageFieldImpl = new PageFieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageField> actualCreateOrRetrieveCopyInstanceResult = pageFieldImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PageFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link PageFieldImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PageFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnPageFieldImpl() throws CloneNotSupportedException {
    // Arrange
    PageFieldImpl pageFieldImpl = new PageFieldImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PageField> actualCreateOrRetrieveCopyInstanceResult = pageFieldImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.page.domain.PageFieldImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PageField clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PageFieldImpl);
    assertNull(clone.getId());
    assertNull(clone.getFieldKey());
    assertNull(clone.getValue());
    assertNull(((PageFieldImpl) clone).lobValue);
    assertNull(((PageFieldImpl) clone).stringValue);
    assertNull(clone.getPage());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageFieldImpl}
   *   <li>{@link PageFieldImpl#setFieldKey(String)}
   *   <li>{@link PageFieldImpl#setId(Long)}
   *   <li>{@link PageFieldImpl#setPage(Page)}
   *   <li>{@link PageFieldImpl#getFieldKey()}
   *   <li>{@link PageFieldImpl#getId()}
   *   <li>{@link PageFieldImpl#getPage()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageFieldImpl.<init>()", "String PageFieldImpl.getFieldKey()", "Long PageFieldImpl.getId()",
      "Page PageFieldImpl.getPage()", "void PageFieldImpl.setFieldKey(String)", "void PageFieldImpl.setId(Long)",
      "void PageFieldImpl.setPage(Page)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    PageFieldImpl actualPageFieldImpl = new PageFieldImpl();
    actualPageFieldImpl.setFieldKey("Field Key");
    actualPageFieldImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    PageImpl page = new PageImpl();
    actualPageFieldImpl.setPage(page);
    String actualFieldKey = actualPageFieldImpl.getFieldKey();
    Long actualId = actualPageFieldImpl.getId();
    Page actualPage = actualPageFieldImpl.getPage();

    // Assert
    assertEquals("Field Key", actualFieldKey);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(page, actualPage);
  }
}
