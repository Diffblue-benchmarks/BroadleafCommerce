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

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StructuredContentFieldImplDiffblueTest {
  @Autowired
  private StructuredContentFieldImpl structuredContentFieldImpl;

  /**
   * Test {@link StructuredContentFieldImpl#getValue()}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentFieldImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new StructuredContentFieldImpl()).getValue());
  }

  /**
   * Test {@link StructuredContentFieldImpl#setValue(String)}.
   * <ul>
   *   <li>Then {@link StructuredContentFieldImpl} (default constructor) Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentFieldImpl.setValue(String)"})
  public void testSetValue_thenStructuredContentFieldImplValueIs42() {
    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl2 = new StructuredContentFieldImpl();

    // Act
    structuredContentFieldImpl2.setValue("42");

    // Assert
    assertEquals("42", structuredContentFieldImpl2.getValue());
    assertEquals("42", structuredContentFieldImpl2.stringValue);
  }

  /**
   * Test {@link StructuredContentFieldImpl#setValue(String)}.
   * <ul>
   *   <li>Then {@link StructuredContentFieldImpl} (default constructor) Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentFieldImpl.setValue(String)"})
  public void testSetValue_thenStructuredContentFieldImplValueIsNull() {
    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl2 = new StructuredContentFieldImpl();
    structuredContentFieldImpl2.setFieldKey("Field Key");
    structuredContentFieldImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);

    // Act
    structuredContentFieldImpl2.setValue(null);

    // Assert that nothing has changed
    assertNull(structuredContentFieldImpl2.getValue());
    assertNull(structuredContentFieldImpl2.stringValue);
  }

  /**
   * Test {@link StructuredContentFieldImpl#clone()}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StructuredContentField StructuredContentFieldImpl.clone()"})
  public void testClone() {
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
   * Test {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse StructuredContentFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl2 = new StructuredContentFieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StructuredContentFieldImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse StructuredContentFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStructuredContentFieldImpl()
      throws CloneNotSupportedException {
    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl2 = new StructuredContentFieldImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldImpl2
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentFieldImpl}
   *   <li>{@link StructuredContentFieldImpl#setFieldKey(String)}
   *   <li>{@link StructuredContentFieldImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldImpl#getFieldKey()}
   *   <li>{@link StructuredContentFieldImpl#getId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredContentFieldImpl.<init>()", "String StructuredContentFieldImpl.getFieldKey()",
      "Long StructuredContentFieldImpl.getId()", "void StructuredContentFieldImpl.setFieldKey(String)",
      "void StructuredContentFieldImpl.setId(Long)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldImpl actualStructuredContentFieldImpl = new StructuredContentFieldImpl();
    actualStructuredContentFieldImpl.setFieldKey("Field Key");
    actualStructuredContentFieldImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    String actualFieldKey = actualStructuredContentFieldImpl.getFieldKey();

    // Assert
    assertEquals("Field Key", actualFieldKey);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID,
        actualStructuredContentFieldImpl.getId().longValue());
  }
}
