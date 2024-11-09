/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class TranslationImplDiffblueTest {
  /**
   * Test {@link TranslationImpl#getEntityType()}.
   * <ul>
   *   <li>Given {@link TranslationImpl} (default constructor) EntityType is
   * {@link TranslatedEntity#CATALOG}.</li>
   *   <li>Then return {@link TranslatedEntity#CATALOG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_givenTranslationImplEntityTypeIsCatalog_thenReturnCatalog() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityType(TranslatedEntity.CATALOG);

    // Act
    TranslatedEntity actualEntityType = translationImpl.getEntityType();

    // Assert
    assertSame(actualEntityType.CATALOG, actualEntityType);
  }

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   * <ul>
   *   <li>Given {@link TranslationImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_givenTranslationImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TranslationImpl()).getEntityType());
  }

  /**
   * Test {@link TranslationImpl#getEntityType()}.
   * <ul>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_thenReturnFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getFriendlyType()).thenReturn("Friendly Type");

    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityType(entityType);

    // Act
    TranslatedEntity actualEntityType = translationImpl.getEntityType();

    // Assert
    verify(entityType).getFriendlyType();
    assertEquals("Friendly Type", actualEntityType.getFriendlyType());
    assertEquals("Type", actualEntityType.getType());
  }

  /**
   * Test {@link TranslationImpl#setEntityType(TranslatedEntity)}.
   * <ul>
   *   <li>Then {@link TranslationImpl} (default constructor) EntityType
   * FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#setEntityType(TranslatedEntity)}
   */
  @Test
  public void testSetEntityType_thenTranslationImplEntityTypeFriendlyTypeIsFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getFriendlyType()).thenReturn("Friendly Type");

    // Act
    translationImpl.setEntityType(entityType);

    // Assert
    verify(entityType).getFriendlyType();
    TranslatedEntity entityType2 = translationImpl.getEntityType();
    assertEquals("Friendly Type", entityType2.getFriendlyType());
    assertEquals("Friendly Type", translationImpl.entityType);
    assertEquals("Type", entityType2.getType());
  }

  /**
   * Test {@link TranslationImpl#setEntityType(TranslatedEntity)}.
   * <ul>
   *   <li>When {@link TranslatedEntity#CATALOG}.</li>
   *   <li>Then {@link TranslationImpl} (default constructor)
   * {@link TranslationImpl#entityType} is {@code Catalog}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationImpl#setEntityType(TranslatedEntity)}
   */
  @Test
  public void testSetEntityType_whenCatalog_thenTranslationImplEntityTypeIsCatalog() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    TranslatedEntity entityType = TranslatedEntity.CATALOG;

    // Act
    translationImpl.setEntityType(entityType);

    // Assert
    assertEquals("Catalog", translationImpl.entityType);
    TranslatedEntity expectedEntityType = entityType.CATALOG;
    assertSame(expectedEntityType, translationImpl.getEntityType());
  }

  /**
   * Test
   * {@link TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link TranslationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Translation> actualCreateOrRetrieveCopyInstanceResult = translationImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("42", actualEntityId);
    assertEquals("42", actualTranslationImpl.getTranslatedValue());
    assertEquals("Field Name", actualFieldName);
    assertEquals("en", actualLocaleCode);
    assertEquals(1L, actualId.longValue());
  }
}
