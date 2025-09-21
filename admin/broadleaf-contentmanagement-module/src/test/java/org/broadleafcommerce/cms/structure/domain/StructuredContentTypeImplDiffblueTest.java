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
import static org.junit.Assert.assertThrows;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentTypeImplDiffblueTest {
  @Autowired private StructuredContentTypeImpl structuredContentTypeImpl;

  /**
   * Test {@link StructuredContentTypeImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link StructuredContentTypeImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentTypeImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(structuredContentTypeImpl.getMainEntityName());
  }

  /**
   * Test {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new StructuredContentTypeImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentType> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentTypeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(structuredContentTypeImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentType> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentTypeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    StructuredContentFieldTemplateImpl scft = mock(StructuredContentFieldTemplateImpl.class);
    when(scft.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new StructuredContentFieldTemplateImpl(), true));

    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    structuredContentTypeImpl.setStructuredContentFieldTemplate(scft);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new StructuredContentTypeImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    structuredContentTypeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(scft).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    StructuredContentFieldTemplateImpl scft = mock(StructuredContentFieldTemplateImpl.class);
    when(scft.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    structuredContentTypeImpl.setStructuredContentFieldTemplate(scft);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new StructuredContentTypeImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> structuredContentTypeImpl.createOrRetrieveCopyInstance(context));
    verify(scft).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentTypeImpl}
   *   <li>{@link StructuredContentTypeImpl#setDescription(String)}
   *   <li>{@link StructuredContentTypeImpl#setId(Long)}
   *   <li>{@link StructuredContentTypeImpl#setName(String)}
   *   <li>{@link
   *       StructuredContentTypeImpl#setStructuredContentFieldTemplate(StructuredContentFieldTemplate)}
   *   <li>{@link StructuredContentTypeImpl#getDescription()}
   *   <li>{@link StructuredContentTypeImpl#getId()}
   *   <li>{@link StructuredContentTypeImpl#getName()}
   *   <li>{@link StructuredContentTypeImpl#getStructuredContentFieldTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentTypeImpl.<init>()",
    "String StructuredContentTypeImpl.getDescription()",
    "Long StructuredContentTypeImpl.getId()",
    "String StructuredContentTypeImpl.getName()",
    "StructuredContentFieldTemplate StructuredContentTypeImpl.getStructuredContentFieldTemplate()",
    "void StructuredContentTypeImpl.setDescription(String)",
    "void StructuredContentTypeImpl.setId(Long)",
    "void StructuredContentTypeImpl.setName(String)",
    "void StructuredContentTypeImpl.setStructuredContentFieldTemplate(StructuredContentFieldTemplate)"
  })
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
    StructuredContentFieldTemplate actualStructuredContentFieldTemplate =
        actualStructuredContentTypeImpl.getStructuredContentFieldTemplate();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(scft, actualStructuredContentFieldTemplate);
  }
}
