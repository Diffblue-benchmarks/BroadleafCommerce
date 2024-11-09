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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentImplDiffblueTest {
  /**
   * Test {@link StructuredContentImpl#getStructuredContentFields()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) Locale is
   * {@link LocaleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getStructuredContentFields()}
   */
  @Test
  public void testGetStructuredContentFields_givenStructuredContentImplLocaleIsLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setLocale(mock(LocaleImpl.class));

    // Act and Assert
    assertTrue(structuredContentImpl.getStructuredContentFields().isEmpty());
  }

  /**
   * Test {@link StructuredContentImpl#getStructuredContentFields()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getStructuredContentFields()}
   */
  @Test
  public void testGetStructuredContentFields_givenStructuredContentImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StructuredContentImpl()).getStructuredContentFields().isEmpty());
  }

  /**
   * Test {@link StructuredContentImpl#getStructuredContentFields()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getStructuredContentFields()}
   */
  @Test
  public void testGetStructuredContentFields_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, StructuredContentFieldXref> structuredContentFields = new HashMap<>();
    structuredContentFields.put("foo", new StructuredContentFieldXrefImpl());

    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setStructuredContentFieldXrefs(structuredContentFields);

    // Act
    Map<String, StructuredContentField> actualStructuredContentFields = structuredContentImpl
        .getStructuredContentFields();

    // Assert
    assertEquals(1, actualStructuredContentFields.size());
    assertNull(actualStructuredContentFields.get("foo"));
  }

  /**
   * Test {@link StructuredContentImpl#setStructuredContentFields(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentImpl#setStructuredContentFields(Map)}
   */
  @Test
  public void testSetStructuredContentFields_whenHashMap_thenHashMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    HashMap<String, StructuredContentField> structuredContentFields = new HashMap<>();

    // Act
    structuredContentImpl.setStructuredContentFields(structuredContentFields);

    // Assert
    assertTrue(structuredContentFields.isEmpty());
    assertTrue(structuredContentImpl.getFieldValues().isEmpty());
    assertTrue(structuredContentImpl.getStructuredContentFieldXrefs().isEmpty());
    assertTrue(structuredContentImpl.getStructuredContentFields().isEmpty());
    assertTrue(structuredContentImpl.legacyStructuredContentFields.isEmpty());
  }

  /**
   * Test {@link StructuredContentImpl#getFieldValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getFieldValue(String)}
   */
  @Test
  public void testGetFieldValue_givenStructuredContentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentImpl()).getFieldValue("Field Name"));
  }

  /**
   * Test {@link StructuredContentImpl#getFieldValue(String)}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) Locale is
   * {@link LocaleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getFieldValue(String)}
   */
  @Test
  public void testGetFieldValue_givenStructuredContentImplLocaleIsLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setLocale(mock(LocaleImpl.class));

    // Act and Assert
    assertNull(structuredContentImpl.getFieldValue("Field Name"));
  }

  /**
   * Test {@link StructuredContentImpl#getFieldValues()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) Locale is
   * {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getFieldValues()}
   */
  @Test
  public void testGetFieldValues_givenStructuredContentImplLocaleIsLocaleImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentImpl.setLocale(new LocaleImpl());
    structuredContentImpl.setOfflineFlag(true);
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());
    structuredContentImpl.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setFieldValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentImpl.getFieldValues().isEmpty());
  }

  /**
   * Test {@link StructuredContentImpl#getFieldValues()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) Locale is
   * {@link LocaleImpl}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getFieldValues()}
   */
  @Test
  public void testGetFieldValues_givenStructuredContentImplLocaleIsLocaleImpl_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentImpl.setLocale(mock(LocaleImpl.class));
    structuredContentImpl.setOfflineFlag(true);
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());
    structuredContentImpl.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setFieldValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentImpl.getFieldValues().isEmpty());
  }

  /**
   * Test {@link StructuredContentImpl#getFieldValues()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getFieldValues()}
   */
  @Test
  public void testGetFieldValues_givenStructuredContentImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StructuredContentImpl()).getFieldValues().isEmpty());
  }

  /**
   * Test {@link StructuredContentImpl#getFieldValues()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getFieldValues()}
   */
  @Test
  public void testGetFieldValues_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, StructuredContentFieldXref> structuredContentFields = new HashMap<>();
    StructuredContentImpl sc = new StructuredContentImpl();
    structuredContentFields.put("foo", new StructuredContentFieldXrefImpl(sc, new StructuredContentFieldImpl(), "Key"));

    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setStructuredContentFieldXrefs(structuredContentFields);

    // Act
    Map<String, String> actualFieldValues = structuredContentImpl.getFieldValues();

    // Assert
    assertEquals(1, actualFieldValues.size());
    assertNull(actualFieldValues.get("foo"));
    assertSame(structuredContentImpl.fieldValuesMap, actualFieldValues);
  }

  /**
   * Test {@link StructuredContentImpl#getOfflineFlag()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) Locale is
   * {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getOfflineFlag()}
   */
  @Test
  public void testGetOfflineFlag_givenStructuredContentImplLocaleIsLocaleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setFieldValues(new HashMap<>());
    structuredContentImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentImpl.setLocale(new LocaleImpl());
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());
    structuredContentImpl.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setOfflineFlag(null);

    // Act and Assert
    assertFalse(structuredContentImpl.getOfflineFlag());
  }

  /**
   * Test {@link StructuredContentImpl#getOfflineFlag()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) Locale is
   * {@link LocaleImpl}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getOfflineFlag()}
   */
  @Test
  public void testGetOfflineFlag_givenStructuredContentImplLocaleIsLocaleImpl_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setFieldValues(new HashMap<>());
    structuredContentImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentImpl.setLocale(mock(LocaleImpl.class));
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());
    structuredContentImpl.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setOfflineFlag(null);

    // Act and Assert
    assertFalse(structuredContentImpl.getOfflineFlag());
  }

  /**
   * Test {@link StructuredContentImpl#getOfflineFlag()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) OfflineFlag is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getOfflineFlag()}
   */
  @Test
  public void testGetOfflineFlag_givenStructuredContentImplOfflineFlagIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setFieldValues(new HashMap<>());
    structuredContentImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentImpl.setLocale(new LocaleImpl());
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());
    structuredContentImpl.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setOfflineFlag(true);

    // Act and Assert
    assertTrue(structuredContentImpl.getOfflineFlag());
  }

  /**
   * Test {@link StructuredContentImpl#getOfflineFlag()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getOfflineFlag()}
   */
  @Test
  public void testGetOfflineFlag_givenStructuredContentImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentImpl()).getOfflineFlag());
  }

  /**
   * Test {@link StructuredContentImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenStructuredContentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentImpl()).getMainEntityName());
  }

  /**
   * Test {@link StructuredContentImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link StructuredContentImpl} (default constructor) Locale is
   * {@link LocaleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenStructuredContentImplLocaleIsLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setLocale(mock(LocaleImpl.class));

    // Act and Assert
    assertNull(structuredContentImpl.getMainEntityName());
  }

  /**
   * Test
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContent> actualCreateOrRetrieveCopyInstanceResult = structuredContentImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentTypeImpl structuredContentType = mock(StructuredContentTypeImpl.class);
    when(structuredContentType.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new StructuredContentTypeImpl(), true));

    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setStructuredContentType(structuredContentType);

    StructuredContentImpl structuredContentImpl2 = new StructuredContentImpl();
    structuredContentImpl2.setContentName("Not all who wander are lost");
    structuredContentImpl2.setFieldValues(new HashMap<>());
    structuredContentImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentImpl2.setLocale(new LocaleImpl());
    structuredContentImpl2.setOfflineFlag(true);
    structuredContentImpl2.setPriority(1);
    structuredContentImpl2.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl2.setStructuredContentFieldXrefs(new HashMap<>());
    structuredContentImpl2.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl2.setStructuredContentType(new StructuredContentTypeImpl());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(structuredContentImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    structuredContentImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(structuredContentType).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
  }

  /**
   * Test
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StructuredContentImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStructuredContentImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContent> actualCreateOrRetrieveCopyInstanceResult = structuredContentImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContent clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentImpl);
    assertNull(clone.getPriority());
    assertNull(clone.getId());
    assertNull(clone.getContentName());
    assertNull(((StructuredContentImpl) clone).getMainEntityName());
    assertNull(clone.getStructuredContentType());
    assertNull(clone.getLocale());
    assertFalse(clone.getOfflineFlag());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(((StructuredContentImpl) clone).offlineFlag);
    assertTrue(clone.getFieldValues().isEmpty());
    assertTrue(clone.getStructuredContentFieldXrefs().isEmpty());
    assertTrue(clone.getStructuredContentFields().isEmpty());
    assertTrue(clone.getStructuredContentMatchRules().isEmpty());
    assertTrue(((StructuredContentImpl) clone).legacyStructuredContentFields.isEmpty());
    assertTrue(clone.getQualifyingItemCriteria().isEmpty());
  }

  /**
   * Test
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentTypeImpl structuredContentType = mock(StructuredContentTypeImpl.class);
    when(structuredContentType.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException(StructuredContentImpl.SC_DONT_DUPLICATE_SC_TYPE_HINT));

    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setStructuredContentType(structuredContentType);

    StructuredContentImpl structuredContentImpl2 = new StructuredContentImpl();
    structuredContentImpl2.setContentName("Not all who wander are lost");
    structuredContentImpl2.setFieldValues(new HashMap<>());
    structuredContentImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentImpl2.setLocale(new LocaleImpl());
    structuredContentImpl2.setOfflineFlag(true);
    structuredContentImpl2.setPriority(1);
    structuredContentImpl2.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl2.setStructuredContentFieldXrefs(new HashMap<>());
    structuredContentImpl2.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl2.setStructuredContentType(new StructuredContentTypeImpl());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(structuredContentImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(CloneNotSupportedException.class, () -> structuredContentImpl.createOrRetrieveCopyInstance(context));
    verify(structuredContentType).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentImpl}
   *   <li>{@link StructuredContentImpl#setContentName(String)}
   *   <li>{@link StructuredContentImpl#setFieldValues(Map)}
   *   <li>{@link StructuredContentImpl#setId(Long)}
   *   <li>{@link StructuredContentImpl#setLocale(Locale)}
   *   <li>{@link StructuredContentImpl#setOfflineFlag(Boolean)}
   *   <li>{@link StructuredContentImpl#setPriority(Integer)}
   *   <li>{@link StructuredContentImpl#setQualifyingItemCriteria(Set)}
   *   <li>{@link StructuredContentImpl#setStructuredContentFieldXrefs(Map)}
   *   <li>{@link StructuredContentImpl#setStructuredContentMatchRules(Map)}
   *   <li>
   * {@link StructuredContentImpl#setStructuredContentType(StructuredContentType)}
   *   <li>{@link StructuredContentImpl#getContentName()}
   *   <li>{@link StructuredContentImpl#getId()}
   *   <li>{@link StructuredContentImpl#getLocale()}
   *   <li>{@link StructuredContentImpl#getPriority()}
   *   <li>{@link StructuredContentImpl#getQualifyingItemCriteria()}
   *   <li>{@link StructuredContentImpl#getStructuredContentFieldXrefs()}
   *   <li>{@link StructuredContentImpl#getStructuredContentMatchRules()}
   *   <li>{@link StructuredContentImpl#getStructuredContentType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentImpl actualStructuredContentImpl = new StructuredContentImpl();
    actualStructuredContentImpl.setContentName("Not all who wander are lost");
    actualStructuredContentImpl.setFieldValues(new HashMap<>());
    actualStructuredContentImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    actualStructuredContentImpl.setLocale(locale);
    actualStructuredContentImpl.setOfflineFlag(true);
    actualStructuredContentImpl.setPriority(1);
    HashSet<StructuredContentItemCriteria> qualifyingItemCriteria = new HashSet<>();
    actualStructuredContentImpl.setQualifyingItemCriteria(qualifyingItemCriteria);
    HashMap<String, StructuredContentFieldXref> structuredContentFields = new HashMap<>();
    actualStructuredContentImpl.setStructuredContentFieldXrefs(structuredContentFields);
    HashMap<String, StructuredContentRule> structuredContentMatchRules = new HashMap<>();
    actualStructuredContentImpl.setStructuredContentMatchRules(structuredContentMatchRules);
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    actualStructuredContentImpl.setStructuredContentType(structuredContentType);
    String actualContentName = actualStructuredContentImpl.getContentName();
    Long actualId = actualStructuredContentImpl.getId();
    Locale actualLocale = actualStructuredContentImpl.getLocale();
    Integer actualPriority = actualStructuredContentImpl.getPriority();
    Set<StructuredContentItemCriteria> actualQualifyingItemCriteria = actualStructuredContentImpl
        .getQualifyingItemCriteria();
    Map<String, StructuredContentFieldXref> actualStructuredContentFieldXrefs = actualStructuredContentImpl
        .getStructuredContentFieldXrefs();
    Map<String, StructuredContentRule> actualStructuredContentMatchRules = actualStructuredContentImpl
        .getStructuredContentMatchRules();
    StructuredContentType actualStructuredContentType = actualStructuredContentImpl.getStructuredContentType();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualContentName);
    assertEquals(1, actualPriority.intValue());
    assertTrue(actualStructuredContentFieldXrefs.isEmpty());
    assertTrue(actualStructuredContentMatchRules.isEmpty());
    assertTrue(actualStructuredContentImpl.fieldValuesMap.isEmpty());
    assertTrue(actualStructuredContentImpl.legacyStructuredContentFields.isEmpty());
    assertTrue(actualQualifyingItemCriteria.isEmpty());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(structuredContentFields, actualStructuredContentFieldXrefs);
    assertSame(structuredContentMatchRules, actualStructuredContentMatchRules);
    assertSame(qualifyingItemCriteria, actualQualifyingItemCriteria);
    assertSame(structuredContentType, actualStructuredContentType);
    assertSame(locale, actualLocale);
  }
}
