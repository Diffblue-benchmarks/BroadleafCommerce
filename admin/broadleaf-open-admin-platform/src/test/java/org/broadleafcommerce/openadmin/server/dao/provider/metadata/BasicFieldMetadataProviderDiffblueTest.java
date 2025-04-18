/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration;
import org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup;
import org.broadleafcommerce.common.presentation.ConfigurationItem;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.OptionFilterParam;
import org.broadleafcommerce.common.presentation.OptionFilterParamType;
import org.broadleafcommerce.common.presentation.RequiredOverride;
import org.broadleafcommerce.common.presentation.ValidationConfiguration;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.UnspecifiedBooleanType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BasicFieldMetadataProviderDiffblueTest {
  @InjectMocks
  private BasicFieldMetadataProvider basicFieldMetadataProvider;

  @Mock
  private Map map;

  /**
   * Test {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BasicFieldMetadataProvider.canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)"})
  public void testCanHandleAnnotationOverride_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(basicFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse BasicFieldMetadataProvider.overrideViaAnnotation(OverrideViaAnnotationRequest, Map)"})
  public void testOverrideViaAnnotation_whenJavaLangObject_thenReturnNotHandled() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MetadataProviderResponse BasicFieldMetadataProvider.overrideViaXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideViaXml_givenMapGetReturnHashMap_thenReturnHandled() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    MetadataProviderResponse actualOverrideViaXmlResult = basicFieldMetadataProvider
        .overrideViaXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED, actualOverrideViaXmlResult);
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MetadataProviderResponse BasicFieldMetadataProvider.overrideViaXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideViaXml_givenMapGetReturnNull_thenReturnHandled() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    MetadataProviderResponse actualOverrideViaXmlResult = basicFieldMetadataProvider
        .overrideViaXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED, actualOverrideViaXmlResult);
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return AddFriendlyName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnAddFriendlyNameIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("addFriendlyName");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return BroadleafEnumeration is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnBroadleafEnumerationIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("broadleafEnumeration");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return ColumnWidth is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnColumnWidthIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("columnWidth");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return FriendlyName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnFriendlyNameIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("friendlyName");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return Group is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnGroupIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("group");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return not HideEnumerationIfEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnNotHideEnumerationIfEmpty() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("hideEnumerationIfEmpty");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertFalse(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return SecurityLevel is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnSecurityLevelIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("securityLevel");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return Tab is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.overrideMergeMetadata(AdminPresentationMergeOverride)"})
  public void testOverrideMergeMetadata_thenReturnTabIs42() {
    // Arrange
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("tab");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride2() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenReturn(new ConfigurationItem[]{configurationItem, mock(ConfigurationItem.class)});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(configurationItem).itemName();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Given {@code IGNORED}.</li>
   *   <li>Then return RequiredOverride is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride_givenIgnored_thenReturnRequiredOverrideIsNull() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.IGNORED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(1, getResult2.size());
    assertEquals("42", getResult2.get("Item Name"));
    assertNull(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then return DefaultValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride_thenReturnDefaultValueIs42() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getDefaultValue());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getOptionValueFieldName());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getRuleIdentifier());
    assertEquals("Add Friendly Name", actualConstructBasicMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Associated Field Name", actualConstructBasicMetadataOverrideResult.getAssociatedFieldName());
    assertEquals("Broadleaf Enumeration", actualConstructBasicMetadataOverrideResult.getBroadleafEnumeration());
    assertEquals("Column Width", actualConstructBasicMetadataOverrideResult.getColumnWidth());
    assertEquals("Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertEquals("Friendly Name", actualConstructBasicMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Grid Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertEquals("Group", actualConstructBasicMetadataOverrideResult.getGroup());
    assertEquals("Help Text", actualConstructBasicMetadataOverrideResult.getHelpText());
    assertEquals("Hint", actualConstructBasicMetadataOverrideResult.getHint());
    assertEquals("Lookup Display Property", actualConstructBasicMetadataOverrideResult.getLookupDisplayProperty());
    assertEquals("Option Display Field Name", actualConstructBasicMetadataOverrideResult.getOptionDisplayFieldName());
    assertEquals("Security Level", actualConstructBasicMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructBasicMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructBasicMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructBasicMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicMetadataOverrideResult.getLazyFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getManualFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructBasicMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getManyToField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicMetadataOverrideResult.getName());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructBasicMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddType());
    assertNull(actualConstructBasicMetadataOverrideResult.getFetchType());
    assertNull(actualConstructBasicMetadataOverrideResult.getInspectType());
    assertNull(actualConstructBasicMetadataOverrideResult.getRemoveType());
    assertNull(actualConstructBasicMetadataOverrideResult.getUpdateType());
    assertNull(actualConstructBasicMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGridOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGroupOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getOrder().intValue());
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicMetadataOverrideResult.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getCustomCriteria().length);
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getOptionFilterValues().length);
    assertEquals(LookupType.STANDARD, actualConstructBasicMetadataOverrideResult.getLookupType());
    assertEquals(RuleBuilderDisplayType.NORMAL, actualConstructBasicMetadataOverrideResult.getDisplayType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION,
        actualConstructBasicMetadataOverrideResult.getExplicitFieldType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION, actualConstructBasicMetadataOverrideResult.getFieldType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicMetadataOverrideResult.getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, actualConstructBasicMetadataOverrideResult.getFieldComponentRenderer());
    assertEquals(SupportedFieldType.UNKNOWN,
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRenderer());
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualConstructBasicMetadataOverrideResult.getVisibility());
    assertTrue(showIfFieldEquals.containsKey("Field Name"));
    assertTrue(actualConstructBasicMetadataOverrideResult.getAllowNoValueEnumOption());
    assertTrue(actualConstructBasicMetadataOverrideResult.getCanLinkToExternalEntity());
    assertTrue(actualConstructBasicMetadataOverrideResult.getEnableTypeaheadLookup());
    assertTrue(actualConstructBasicMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicMetadataOverrideResult.getForcePopulateChildProperties());
    assertTrue(actualConstructBasicMetadataOverrideResult.getGroupCollapsed());
    assertTrue(actualConstructBasicMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertTrue(actualConstructBasicMetadataOverrideResult.getOptionCanEditValues());
    assertTrue(actualConstructBasicMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertTrue(actualConstructBasicMetadataOverrideResult.getTranslatable());
    assertTrue(actualConstructBasicMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicMetadataOverrideResult.isLargeEntry());
    assertTrue(actualConstructBasicMetadataOverrideResult.isProminent());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then return not RequiredOverride.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride_thenReturnNotRequiredOverride() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(null);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(1, getResult2.size());
    assertEquals("42", getResult2.get("Item Name"));
    assertFalse(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then return RequiredOverride.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride_thenReturnRequiredOverride() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(1, getResult2.size());
    assertEquals("42", getResult2.get("Item Name"));
    assertTrue(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride_thenThrowRuntimeException() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations())
        .thenReturn(new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadataOverride BasicFieldMetadataProvider.constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)"})
  public void testConstructBasicMetadataOverride_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> basicFieldMetadataProvider.constructBasicMetadataOverride(null, null, null));
  }

  /**
   * Test {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)"})
  public void testProcessValidationAnnotations() {
    // Arrange
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    HashMap<String, List<Map<String, String>>> validationConfigurations = new HashMap<>();
    override.setValidationConfigurations(validationConfigurations);
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    basicFieldMetadataProvider.processValidationAnnotations(new ValidationConfiguration[]{validationConfiguration},
        override);

    // Assert
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Map<String, List<Map<String, String>>> validationConfigurations2 = override.getValidationConfigurations();
    assertEquals(1, validationConfigurations2.size());
    List<Map<String, String>> getResult = validationConfigurations2.get("Validation Implementation");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(1, getResult2.size());
    assertEquals("42", getResult2.get("Item Name"));
    assertSame(validationConfigurations, validationConfigurations2);
  }

  /**
   * Test {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)"})
  public void testProcessValidationAnnotations_thenThrowIllegalArgumentException() {
    // Arrange
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenThrow(new IllegalArgumentException("foo"));
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider
        .processValidationAnnotations(new ValidationConfiguration[]{validationConfiguration}, override));
    verify(configurationItem).itemName();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)"})
  public void testProcessValidationAnnotations_thenThrowRuntimeException() {
    // Arrange
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems()).thenThrow(new RuntimeException("foo"));

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicFieldMetadataProvider.processValidationAnnotations(
        new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)}, override));
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
  public void testProcessShowIfFieldEqualsAnnotations() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();
    override.setShowIfFieldEquals(showIfFieldEquals);
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    basicFieldMetadataProvider
        .processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration}, override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    Map<String, List<String>> showIfFieldEquals2 = override.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals2.size());
    List<String> getResult = showIfFieldEquals2.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    assertSame(showIfFieldEquals, showIfFieldEquals2);
  }

  /**
   * Test {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadataOverride#getShowIfFieldEquals()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
  public void testProcessShowIfFieldEqualsAnnotations_thenCallsGetShowIfFieldEquals() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    doNothing().when(override).setAddFriendlyName(Mockito.<String>any());
    doNothing().when(override).setAddMethodType(Mockito.<AddMethodType>any());
    doNothing().when(override).setAddType(Mockito.<OperationType>any());
    doNothing().when(override).setAdornedTargetAddMethodType(Mockito.<AdornedTargetAddMethodType>any());
    doNothing().when(override).setAllowNoValueEnumOption(Mockito.<Boolean>any());
    doNothing().when(override).setAssociatedFieldName(Mockito.<String>any());
    doNothing().when(override).setBroadleafEnumeration(Mockito.<String>any());
    doNothing().when(override).setCanLinkToExternalEntity(Mockito.<Boolean>any());
    doNothing().when(override).setColumnWidth(Mockito.<String>any());
    doNothing().when(override).setCurrencyCodeField(Mockito.<String>any());
    doNothing().when(override).setCustomCriteria(Mockito.<String[]>any());
    doNothing().when(override).setDeleteEntityUponRemove(Mockito.<Boolean>any());
    doNothing().when(override).setDerived(Mockito.<Boolean>any());
    doNothing().when(override).setDisplayType(Mockito.<RuleBuilderDisplayType>any());
    doNothing().when(override).setEnableTypeaheadLookup(Mockito.<Boolean>any());
    doNothing().when(override).setEnumerationClass(Mockito.<String>any());
    doNothing().when(override).setEnumerationValues(Mockito.<String[][]>any());
    doNothing().when(override).setExcluded(Mockito.<Boolean>any());
    doNothing().when(override).setExplicitFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setFetchType(Mockito.<OperationType>any());
    doNothing().when(override).setFieldComponentRenderer(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setFieldComponentRendererTemplate(Mockito.<String>any());
    doNothing().when(override).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setForceFreeFormKeys(Mockito.<Boolean>any());
    doNothing().when(override).setForcePopulateChildProperties(Mockito.<Boolean>any());
    doNothing().when(override).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(override).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(override).setForeignKeyDisplayValueProperty(Mockito.<String>any());
    doNothing().when(override).setForeignKeyProperty(Mockito.<String>any());
    doNothing().when(override).setFriendlyName(Mockito.<String>any());
    doNothing().when(override).setGridFieldComponentRenderer(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setGridFieldComponentRendererTemplate(Mockito.<String>any());
    doNothing().when(override).setGridOrder(Mockito.<Integer>any());
    doNothing().when(override).setGridVisibleFields(Mockito.<String[]>any());
    doNothing().when(override).setGroup(Mockito.<String>any());
    doNothing().when(override).setGroupCollapsed(Mockito.<Boolean>any());
    doNothing().when(override).setGroupOrder(Mockito.<Integer>any());
    doNothing().when(override).setHelpText(Mockito.<String>any());
    doNothing().when(override).setHideEnumerationIfEmpty(Mockito.<Boolean>any());
    doNothing().when(override).setHint(Mockito.<String>any());
    doNothing().when(override).setIgnoreAdornedProperties(Mockito.<Boolean>any());
    doNothing().when(override).setInspectType(Mockito.<OperationType>any());
    doNothing().when(override).setJoinEntityClass(Mockito.<String>any());
    doNothing().when(override).setKeyClass(Mockito.<String>any());
    doNothing().when(override).setKeyPropertyFriendlyName(Mockito.<String>any());
    doNothing().when(override).setKeys(Mockito.<String[][]>any());
    doNothing().when(override).setLargeEntry(Mockito.<Boolean>any());
    doNothing().when(override).setLazyFetch(Mockito.<Boolean>any());
    doNothing().when(override).setLength(Mockito.<Integer>any());
    doNothing().when(override).setLookupDisplayProperty(Mockito.<String>any());
    doNothing().when(override).setLookupType(Mockito.<LookupType>any());
    doNothing().when(override).setMaintainedAdornedTargetFields(Mockito.<String[]>any());
    doNothing().when(override).setManualFetch(Mockito.<Boolean>any());
    doNothing().when(override).setManyToField(Mockito.<String>any());
    doNothing().when(override).setMapFieldValueClass(Mockito.<String>any());
    doNothing().when(override).setMapKeyOptionEntityClass(Mockito.<String>any());
    doNothing().when(override).setMapKeyOptionEntityDisplayField(Mockito.<String>any());
    doNothing().when(override).setMapKeyOptionEntityValueField(Mockito.<String>any());
    doNothing().when(override).setMapKeyValueProperty(Mockito.<String>any());
    doNothing().when(override).setMediaField(Mockito.<String>any());
    doNothing().when(override).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(override).setName(Mockito.<String>any());
    doNothing().when(override).setOptionCanEditValues(Mockito.<Boolean>any());
    doNothing().when(override).setOptionDisplayFieldName(Mockito.<String>any());
    doNothing().when(override).setOptionFilterValues(Mockito.<Serializable[][]>any());
    doNothing().when(override).setOptionListEntity(Mockito.<String>any());
    doNothing().when(override).setOptionValueFieldName(Mockito.<String>any());
    doNothing().when(override).setParentObjectIdProperty(Mockito.<String>any());
    doNothing().when(override).setParentObjectProperty(Mockito.<String>any());
    doNothing().when(override).setPrecision(Mockito.<Integer>any());
    doNothing().when(override).setProminent(Mockito.<Boolean>any());
    doNothing().when(override).setReadOnly(Mockito.<Boolean>any());
    doNothing().when(override).setRemoveType(Mockito.<OperationType>any());
    doNothing().when(override).setRequired(Mockito.<Boolean>any());
    doNothing().when(override).setRequiredOverride(Mockito.<Boolean>any());
    doNothing().when(override).setRuleIdentifier(Mockito.<String>any());
    doNothing().when(override).setScale(Mockito.<Integer>any());
    doNothing().when(override).setSearchable(Mockito.<Boolean>any());
    doNothing().when(override).setSecondaryType(Mockito.<SupportedFieldType>any());
    doNothing().when(override).setSecurityLevel(Mockito.<String>any());
    doNothing().when(override).setSelectizeVisibleField(Mockito.<String>any());
    doNothing().when(override).setShowIfFieldEquals(Mockito.<Map<String, List<String>>>any());
    doNothing().when(override).setShowIfProperty(Mockito.<String>any());
    doNothing().when(override).setSimpleValue(Mockito.<UnspecifiedBooleanType>any());
    doNothing().when(override).setSortAscending(Mockito.<Boolean>any());
    doNothing().when(override).setSortProperty(Mockito.<String>any());
    doNothing().when(override).setTab(Mockito.<String>any());
    doNothing().when(override).setTabOrder(Mockito.<Integer>any());
    doNothing().when(override).setTargetObjectIdProperty(Mockito.<String>any());
    doNothing().when(override).setTargetObjectProperty(Mockito.<String>any());
    doNothing().when(override).setToOneLookupCreatedViaAnnotation(Mockito.<Boolean>any());
    doNothing().when(override).setToOneParentProperty(Mockito.<String>any());
    doNothing().when(override).setToOneTargetProperty(Mockito.<String>any());
    doNothing().when(override).setTooltip(Mockito.<String>any());
    doNothing().when(override).setTranslatable(Mockito.<Boolean>any());
    doNothing().when(override).setUnique(Mockito.<Boolean>any());
    doNothing().when(override).setUpdateType(Mockito.<OperationType>any());
    doNothing().when(override).setUseServerSideInspectionCache(Mockito.<Boolean>any());
    doNothing().when(override).setValidationConfigurations(Mockito.<Map<String, List<Map<String, String>>>>any());
    doNothing().when(override).setValueClass(Mockito.<String>any());
    doNothing().when(override).setValuePropertyFriendlyName(Mockito.<String>any());
    doNothing().when(override).setVisibility(Mockito.<VisibilityEnum>any());
    doNothing().when(override).setOrder(Mockito.<Integer>any());
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
    verify(override).setAddFriendlyName(eq("Add Friendly Name"));
    verify(override).setAddMethodType(eq(AddMethodType.PERSIST));
    verify(override).setAddType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setAdornedTargetAddMethodType(eq(AdornedTargetAddMethodType.LOOKUP));
    verify(override).setAllowNoValueEnumOption(eq(true));
    verify(override).setAssociatedFieldName(eq("Associated Field Name"));
    verify(override).setBroadleafEnumeration(eq("Broadleaf Enumeration"));
    verify(override).setCanLinkToExternalEntity(eq(true));
    verify(override).setColumnWidth(eq("Column Width"));
    verify(override).setCurrencyCodeField(eq("GBP"));
    verify(override).setCustomCriteria(isA(String[].class));
    verify(override).setDeleteEntityUponRemove(eq(true));
    verify(override).setDerived(eq(true));
    verify(override).setDisplayType(eq(RuleBuilderDisplayType.NORMAL));
    verify(override).setEnableTypeaheadLookup(eq(true));
    verify(override).setEnumerationClass(eq("Enumeration Class"));
    verify(override).setEnumerationValues(isA(String[][].class));
    verify(override).setExcluded(eq(true));
    verify(override).setExplicitFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(override).setFetchType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setFieldComponentRenderer(eq(SupportedFieldType.UNKNOWN));
    verify(override).setFieldComponentRendererTemplate(eq("Field Component Renderer Template"));
    verify(override).setFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(override).setForceFreeFormKeys(eq(true));
    verify(override).setForcePopulateChildProperties(eq(true));
    verify(override).setForeignKeyClass(eq("Foreign Key Class"));
    verify(override).setForeignKeyCollection(eq(true));
    verify(override).setForeignKeyDisplayValueProperty(eq("42"));
    verify(override).setForeignKeyProperty(eq("Foreign Key Property"));
    verify(override).setFriendlyName(eq("Friendly Name"));
    verify(override).setGridFieldComponentRenderer(eq(SupportedFieldType.UNKNOWN));
    verify(override).setGridFieldComponentRendererTemplate(eq("Grid Field Component Renderer Template"));
    verify(override).setGridOrder(eq(1));
    verify(override).setGridVisibleFields(isA(String[].class));
    verify(override).setGroup(eq("Group"));
    verify(override).setGroupCollapsed(eq(true));
    verify(override).setGroupOrder(eq(1));
    verify(override).setHelpText(eq("Help Text"));
    verify(override).setHideEnumerationIfEmpty(eq(true));
    verify(override).setHint(eq("Hint"));
    verify(override).setIgnoreAdornedProperties(eq(true));
    verify(override).setInspectType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setJoinEntityClass(eq("Join Entity Class"));
    verify(override).setKeyClass(eq("Key Class"));
    verify(override).setKeyPropertyFriendlyName(eq("Key Property Friendly Name"));
    verify(override).setKeys(isA(String[][].class));
    verify(override).setLargeEntry(eq(true));
    verify(override).setLazyFetch(eq(true));
    verify(override).setLength(eq(3));
    verify(override).setLookupDisplayProperty(eq("Lookup Display Property"));
    verify(override).setLookupType(eq(LookupType.STANDARD));
    verify(override).setMaintainedAdornedTargetFields(isA(String[].class));
    verify(override).setManualFetch(eq(true));
    verify(override).setManyToField(eq("Many To Field"));
    verify(override).setMapFieldValueClass(eq("42"));
    verify(override).setMapKeyOptionEntityClass(eq("Map Key Option Entity Class"));
    verify(override).setMapKeyOptionEntityDisplayField(eq("Map Key Option Entity Display Field"));
    verify(override).setMapKeyOptionEntityValueField(eq("42"));
    verify(override).setMapKeyValueProperty(eq("42"));
    verify(override).setMediaField(eq("Media Field"));
    verify(override).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(override).setName(eq("Name"));
    verify(override).setOptionCanEditValues(eq(true));
    verify(override).setOptionDisplayFieldName(eq("Option Display Field Name"));
    verify(override).setOptionFilterValues(isA(Serializable[][].class));
    verify(override).setOptionListEntity(eq("Option List Entity"));
    verify(override).setOptionValueFieldName(eq("42"));
    verify(override).setParentObjectIdProperty(eq("Parent Object Id Property"));
    verify(override).setParentObjectProperty(eq("Parent Object Property"));
    verify(override).setPrecision(eq(1));
    verify(override).setProminent(eq(true));
    verify(override).setReadOnly(eq(true));
    verify(override).setRemoveType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setRequired(eq(true));
    verify(override).setRequiredOverride(eq(true));
    verify(override).setRuleIdentifier(eq("42"));
    verify(override).setScale(eq(1));
    verify(override).setSearchable(eq(true));
    verify(override).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    verify(override).setSecurityLevel(eq("Security Level"));
    verify(override).setSelectizeVisibleField(eq("Selectize Visible Field"));
    verify(override).setShowIfFieldEquals(isA(Map.class));
    verify(override).setShowIfProperty(eq("Show If Property"));
    verify(override).setSimpleValue(eq(UnspecifiedBooleanType.TRUE));
    verify(override).setSortAscending(eq(true));
    verify(override).setSortProperty(eq("Sort Property"));
    verify(override).setTab(eq("Tab"));
    verify(override).setTabOrder(eq(1));
    verify(override).setTargetObjectIdProperty(eq("Target Object Id Property"));
    verify(override).setTargetObjectProperty(eq("Target Object Property"));
    verify(override).setToOneLookupCreatedViaAnnotation(eq(true));
    verify(override).setToOneParentProperty(eq("To One Parent Property"));
    verify(override).setToOneTargetProperty(eq("To One Target Property"));
    verify(override).setTranslatable(eq(true));
    verify(override).setUnique(eq(true));
    verify(override).setUpdateType(eq(OperationType.NONDESTRUCTIVEREMOVE));
    verify(override).setUseServerSideInspectionCache(eq(true));
    verify(override).setValidationConfigurations(isA(Map.class));
    verify(override).setValueClass(eq("42"));
    verify(override).setValuePropertyFriendlyName(eq("42"));
    verify(override).setVisibility(eq(VisibilityEnum.HIDDEN_ALL));
    verify(override).setOrder(eq(1));
  }

  /**
   * Test {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)"})
  public void testProcessShowIfFieldEqualsAnnotations_thenThrowIllegalArgumentException() {
    // Arrange
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)"})
  public void testBuildBasicMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride basicFieldMetadata = mock(FieldMetadataOverride.class);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getExcluded()).thenReturn(true);
    when(basicFieldMetadata.getForcePopulateChildProperties()).thenReturn(true);
    when(basicFieldMetadata.getGroupCollapsed()).thenReturn(true);
    when(basicFieldMetadata.getHideEnumerationIfEmpty()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getToOneLookupCreatedViaAnnotation()).thenReturn(true);
    when(basicFieldMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAddFriendlyName()).thenReturn("Add Friendly Name");
    when(basicFieldMetadata.getBroadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getCurrencyCodeField()).thenReturn("GBP");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getLookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(basicFieldMetadata.getOptionDisplayFieldName()).thenReturn(null);
    when(basicFieldMetadata.getOptionListEntity()).thenReturn("Option List Entity");
    when(basicFieldMetadata.getOptionValueFieldName()).thenReturn("42");
    when(basicFieldMetadata.getSecurityLevel()).thenReturn("Security Level");
    when(basicFieldMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(basicFieldMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getDisplayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(basicFieldMetadata.getExplicitFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getGridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.buildBasicMetadata(parentClass,
        targetClass, attributes, field, basicFieldMetadata, mock(DynamicEntityDao.class)));
    verify(basicFieldMetadata, atLeast(1)).getAddFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getBroadleafEnumeration();
    verify(basicFieldMetadata, atLeast(1)).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getCurrencyCodeField();
    verify(basicFieldMetadata, atLeast(1)).getCustomCriteria();
    verify(basicFieldMetadata, atLeast(1)).getDisplayType();
    verify(basicFieldMetadata, atLeast(1)).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getExcluded();
    verify(basicFieldMetadata, atLeast(1)).getExplicitFieldType();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForcePopulateChildProperties();
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getGridOrder();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata, atLeast(1)).getGroupCollapsed();
    verify(basicFieldMetadata, atLeast(1)).getGroupOrder();
    verify(basicFieldMetadata, atLeast(1)).getHelpText();
    verify(basicFieldMetadata, atLeast(1)).getHideEnumerationIfEmpty();
    verify(basicFieldMetadata, atLeast(1)).getHint();
    verify(basicFieldMetadata, atLeast(1)).getLookupDisplayProperty();
    verify(basicFieldMetadata).getOptionDisplayFieldName();
    verify(basicFieldMetadata, atLeast(1)).getOptionListEntity();
    verify(basicFieldMetadata, atLeast(1)).getOptionValueFieldName();
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(basicFieldMetadata, atLeast(1)).getSecurityLevel();
    verify(basicFieldMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(basicFieldMetadata, atLeast(1)).getShowIfProperty();
    verify(basicFieldMetadata, atLeast(1)).getTab();
    verify(basicFieldMetadata, atLeast(1)).getTabOrder();
    verify(basicFieldMetadata, atLeast(1)).getToOneLookupCreatedViaAnnotation();
    verify(basicFieldMetadata, atLeast(1)).getTooltip();
    verify(basicFieldMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isLargeEntry();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void BasicFieldMetadataProvider.buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)"})
  public void testBuildBasicMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride basicFieldMetadata = mock(FieldMetadataOverride.class);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getExcluded()).thenReturn(true);
    when(basicFieldMetadata.getForcePopulateChildProperties()).thenReturn(true);
    when(basicFieldMetadata.getGroupCollapsed()).thenReturn(true);
    when(basicFieldMetadata.getHideEnumerationIfEmpty()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getToOneLookupCreatedViaAnnotation()).thenReturn(true);
    when(basicFieldMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAddFriendlyName()).thenReturn("Add Friendly Name");
    when(basicFieldMetadata.getBroadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getCurrencyCodeField()).thenReturn("GBP");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getLookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(basicFieldMetadata.getOptionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(basicFieldMetadata.getOptionListEntity()).thenReturn("Option List Entity");
    when(basicFieldMetadata.getOptionValueFieldName()).thenReturn(null);
    when(basicFieldMetadata.getSecurityLevel()).thenReturn("Security Level");
    when(basicFieldMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(basicFieldMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getDisplayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(basicFieldMetadata.getExplicitFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getGridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.buildBasicMetadata(parentClass,
        targetClass, attributes, field, basicFieldMetadata, mock(DynamicEntityDao.class)));
    verify(basicFieldMetadata, atLeast(1)).getAddFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getBroadleafEnumeration();
    verify(basicFieldMetadata, atLeast(1)).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getCurrencyCodeField();
    verify(basicFieldMetadata, atLeast(1)).getCustomCriteria();
    verify(basicFieldMetadata, atLeast(1)).getDisplayType();
    verify(basicFieldMetadata, atLeast(1)).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getExcluded();
    verify(basicFieldMetadata, atLeast(1)).getExplicitFieldType();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForcePopulateChildProperties();
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getGridOrder();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata, atLeast(1)).getGroupCollapsed();
    verify(basicFieldMetadata, atLeast(1)).getGroupOrder();
    verify(basicFieldMetadata, atLeast(1)).getHelpText();
    verify(basicFieldMetadata, atLeast(1)).getHideEnumerationIfEmpty();
    verify(basicFieldMetadata, atLeast(1)).getHint();
    verify(basicFieldMetadata, atLeast(1)).getLookupDisplayProperty();
    verify(basicFieldMetadata, atLeast(1)).getOptionDisplayFieldName();
    verify(basicFieldMetadata, atLeast(1)).getOptionListEntity();
    verify(basicFieldMetadata).getOptionValueFieldName();
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(basicFieldMetadata, atLeast(1)).getSecurityLevel();
    verify(basicFieldMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(basicFieldMetadata, atLeast(1)).getShowIfProperty();
    verify(basicFieldMetadata, atLeast(1)).getTab();
    verify(basicFieldMetadata, atLeast(1)).getTabOrder();
    verify(basicFieldMetadata, atLeast(1)).getToOneLookupCreatedViaAnnotation();
    verify(basicFieldMetadata, atLeast(1)).getTooltip();
    verify(basicFieldMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isLargeEntry();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test {@link BasicFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BasicFieldMetadataProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new BasicFieldMetadataProvider()).getOrder());
  }
}
