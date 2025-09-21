/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationImplDiffblueTest {
  @Autowired private TranslationImpl translationImpl;

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   *
   * <ul>
   *   <li>Given {@link TranslationImpl} (default constructor) EntityId is {@code 42}.
   *   <li>Then return {@link TranslatedEntity#CATALOG}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslatedEntity TranslationImpl.getEntityType()"})
  public void testGetEntityType_givenTranslationImplEntityIdIs42_thenReturnCatalog() {
    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityId("42");
    translationImpl.setEntityType(TranslatedEntity.CATALOG);
    translationImpl.setFieldName("Field Name");
    translationImpl.setId(1L);
    translationImpl.setLocaleCode("en");
    translationImpl.setTranslatedValue("42");

    // Act and Assert
    assertSame(TranslatedEntity.CATALOG, translationImpl.getEntityType());
  }

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   *
   * <ul>
   *   <li>Given {@link TranslationImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslatedEntity TranslationImpl.getEntityType()"})
  public void testGetEntityType_givenTranslationImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(translationImpl.getEntityType());
  }

  /**
   * Test {@link TranslationImpl#setEntityType(TranslatedEntity)}.
   *
   * <ul>
   *   <li>When {@link TranslatedEntity#CATALOG}.
   *   <li>Then {@link TranslationImpl} {@link TranslationImpl#entityType} is {@code Catalog}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationImpl#setEntityType(TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TranslationImpl.setEntityType(TranslatedEntity)"})
  public void testSetEntityType_whenCatalog_thenTranslationImplEntityTypeIsCatalog() {
    // Arrange and Act
    translationImpl.setEntityType(TranslatedEntity.CATALOG);

    // Assert
    assertEquals("Catalog", translationImpl.entityType);
    assertSame(TranslatedEntity.CATALOG, translationImpl.getEntityType());
  }

  /**
   * Test {@link TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse TranslationImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new TranslationImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Translation> actualCreateOrRetrieveCopyInstanceResult =
        translationImpl.createOrRetrieveCopyInstance(context);

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
   *   <li>default or parameterless constructor of {@link TranslationImpl}
   *   <li>{@link TranslationImpl#setEntityId(String)}
   *   <li>{@link TranslationImpl#setFieldName(String)}
   *   <li>{@link TranslationImpl#setId(Long)}
   *   <li>{@link TranslationImpl#setLocaleCode(String)}
   *   <li>{@link TranslationImpl#setTranslatedValue(String)}
   *   <li>{@link TranslationImpl#getEntityId()}
   *   <li>{@link TranslationImpl#getFieldName()}
   *   <li>{@link TranslationImpl#getId()}
   *   <li>{@link TranslationImpl#getLocaleCode()}
   *   <li>{@link TranslationImpl#getTranslatedValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TranslationImpl.<init>()",
    "String TranslationImpl.getEntityId()",
    "String TranslationImpl.getFieldName()",
    "Long TranslationImpl.getId()",
    "String TranslationImpl.getLocaleCode()",
    "String TranslationImpl.getTranslatedValue()",
    "void TranslationImpl.setEntityId(String)",
    "void TranslationImpl.setFieldName(String)",
    "void TranslationImpl.setId(Long)",
    "void TranslationImpl.setLocaleCode(String)",
    "void TranslationImpl.setTranslatedValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TranslationImpl actualTranslationImpl = new TranslationImpl();
    actualTranslationImpl.setEntityId("42");
    actualTranslationImpl.setFieldName("Field Name");
    actualTranslationImpl.setId(1L);
    actualTranslationImpl.setLocaleCode("en");
    actualTranslationImpl.setTranslatedValue("42");
    String actualEntityId = actualTranslationImpl.getEntityId();
    String actualFieldName = actualTranslationImpl.getFieldName();
    Long actualId = actualTranslationImpl.getId();
    String actualLocaleCode = actualTranslationImpl.getLocaleCode();

    // Assert
    assertEquals("42", actualEntityId);
    assertEquals("42", actualTranslationImpl.getTranslatedValue());
    assertEquals("Field Name", actualFieldName);
    assertEquals("en", actualLocaleCode);
    assertEquals(1L, actualId.longValue());
  }
}
