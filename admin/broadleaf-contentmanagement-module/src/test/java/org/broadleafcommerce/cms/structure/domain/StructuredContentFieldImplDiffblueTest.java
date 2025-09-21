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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentFieldImplDiffblueTest {
  @Autowired private StructuredContentFieldImpl structuredContentFieldImpl;

  /**
   * Test {@link StructuredContentFieldImpl#getValue()}.
   *
   * <p>Method under test: {@link StructuredContentFieldImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentFieldImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull(structuredContentFieldImpl.getValue());
  }

  /**
   * Test {@link StructuredContentFieldImpl#setValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link StructuredContentFieldImpl} Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentFieldImpl.setValue(String)"})
  public void testSetValue_when42_thenStructuredContentFieldImplValueIs42() {
    // Arrange and Act
    structuredContentFieldImpl.setValue("42");

    // Assert
    assertEquals("42", structuredContentFieldImpl.getValue());
    assertEquals("42", structuredContentFieldImpl.stringValue);
  }

  /**
   * Test {@link StructuredContentFieldImpl#setValue(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link StructuredContentFieldImpl} Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentFieldImpl.setValue(String)"})
  public void testSetValue_whenNull_thenStructuredContentFieldImplValueIsNull() {
    // Arrange and Act
    structuredContentFieldImpl.setValue(null);

    // Assert that nothing has changed
    assertNull(structuredContentFieldImpl.getValue());
    assertNull(structuredContentFieldImpl.stringValue);
  }

  /**
   * Test {@link StructuredContentFieldImpl#clone()}.
   *
   * <p>Method under test: {@link StructuredContentFieldImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StructuredContentField StructuredContentFieldImpl.clone()"})
  public void testClone() {
    // Arrange and Act
    StructuredContentField actualCloneResult = structuredContentFieldImpl.clone();

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
   *
   * <p>Method under test: {@link
   * StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new StructuredContentFieldImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentFieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(structuredContentFieldImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentFieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentFieldImpl}
   *   <li>{@link StructuredContentFieldImpl#setFieldKey(String)}
   *   <li>{@link StructuredContentFieldImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldImpl#getFieldKey()}
   *   <li>{@link StructuredContentFieldImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentFieldImpl.<init>()",
    "String StructuredContentFieldImpl.getFieldKey()",
    "Long StructuredContentFieldImpl.getId()",
    "void StructuredContentFieldImpl.setFieldKey(String)",
    "void StructuredContentFieldImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldImpl actualStructuredContentFieldImpl = new StructuredContentFieldImpl();
    actualStructuredContentFieldImpl.setFieldKey("Field Key");
    actualStructuredContentFieldImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    String actualFieldKey = actualStructuredContentFieldImpl.getFieldKey();

    // Assert
    assertEquals("Field Key", actualFieldKey);
    assertEquals(
        StructuredContentItemCriteriaImpl.serialVersionUID,
        actualStructuredContentFieldImpl.getId().longValue());
  }
}
