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
package org.broadleafcommerce.cms.field.domain;

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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FieldDefinitionImplDiffblueTest {
  /**
   * Test {@link FieldDefinitionImpl#getName()}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setAllowMultiples(true);
    fieldDefinitionImpl.setColumnWidth("Column Width");
    fieldDefinitionImpl.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl.setFieldOrder(1);
    fieldDefinitionImpl.setFieldType("Field Type");
    fieldDefinitionImpl.setFriendlyName("Friendly Name");
    fieldDefinitionImpl.setHelpText("Help Text");
    fieldDefinitionImpl.setHiddenFlag(true);
    fieldDefinitionImpl.setHint("Hint");
    fieldDefinitionImpl.setId(1L);
    fieldDefinitionImpl.setMaxLength(3);
    fieldDefinitionImpl.setRequiredFlag(true);
    fieldDefinitionImpl.setSecurityLevel("Security Level");
    fieldDefinitionImpl.setTextAreaFlag(true);
    fieldDefinitionImpl.setTooltip("127.0.0.1");
    fieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl.setValidationRegEx(".*");
    fieldDefinitionImpl.setName("foo");

    // Act and Assert
    assertEquals("foo", fieldDefinitionImpl.getName());
  }

  /**
   * Test {@link FieldDefinitionImpl#getName()}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getName()}
   */
  @Test
  public void testGetName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setAllowMultiples(true);
    fieldDefinitionImpl.setColumnWidth("Column Width");
    fieldDefinitionImpl.setDataDrivenEnumeration(mock(DataDrivenEnumerationImpl.class));
    fieldDefinitionImpl.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl.setFieldOrder(1);
    fieldDefinitionImpl.setFieldType("Field Type");
    fieldDefinitionImpl.setFriendlyName("Friendly Name");
    fieldDefinitionImpl.setHelpText("Help Text");
    fieldDefinitionImpl.setHiddenFlag(true);
    fieldDefinitionImpl.setHint("Hint");
    fieldDefinitionImpl.setId(1L);
    fieldDefinitionImpl.setMaxLength(3);
    fieldDefinitionImpl.setRequiredFlag(true);
    fieldDefinitionImpl.setSecurityLevel("Security Level");
    fieldDefinitionImpl.setTextAreaFlag(true);
    fieldDefinitionImpl.setTooltip("127.0.0.1");
    fieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl.setValidationRegEx(".*");
    fieldDefinitionImpl.setName("foo");

    // Act and Assert
    assertEquals("foo", fieldDefinitionImpl.getName());
  }

  /**
   * Test {@link FieldDefinitionImpl#getName()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getName()}
   */
  @Test
  public void testGetName_givenFieldDefinitionImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new FieldDefinitionImpl()).getName());
  }

  /**
   * Test {@link FieldDefinitionImpl#getFieldType()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldGroup is
   * {@link FieldGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getFieldType()}
   */
  @Test
  public void testGetFieldType_givenFieldDefinitionImplFieldGroupIsFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldGroup(mock(FieldGroupImpl.class));

    // Act and Assert
    assertNull(fieldDefinitionImpl.getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#getFieldType()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldType is
   * {@code UNKNOWN}.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getFieldType()}
   */
  @Test
  public void testGetFieldType_givenFieldDefinitionImplFieldTypeIsUnknown_thenReturnUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertEquals(SupportedFieldType.UNKNOWN, fieldDefinitionImpl.getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#getFieldType()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getFieldType()}
   */
  @Test
  public void testGetFieldType_givenFieldDefinitionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldDefinitionImpl()).getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}
   */
  @Test
  public void testGetAdditionalForeignKeyClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldGroup(mock(FieldGroupImpl.class));

    // Act and Assert
    assertNull(fieldDefinitionImpl.getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}
   */
  @Test
  public void testGetAdditionalForeignKeyClass_givenFieldDefinitionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldDefinitionImpl()).getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldType is
   * {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}
   */
  @Test
  public void testGetAdditionalForeignKeyClass_givenFieldDefinitionImplFieldTypeIsUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNull(fieldDefinitionImpl.getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}.
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}
   */
  @Test
  public void testSetAdditionalForeignKeyClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldType(SupportedFieldType.ADDITIONAL_FOREIGN_KEY);

    // Act
    fieldDefinitionImpl.setAdditionalForeignKeyClass("Class Name");

    // Assert
    assertEquals("ADDITIONAL_FOREIGN_KEY|Class Name", fieldDefinitionImpl.getFieldTypeVal());
    assertEquals("Class Name", fieldDefinitionImpl.getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}.
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}
   */
  @Test
  public void testSetAdditionalForeignKeyClass2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldType("ADDITIONAL_FOREIGN_KEY");
    fieldDefinitionImpl.setFieldGroup(mock(FieldGroupImpl.class));

    // Act
    fieldDefinitionImpl.setAdditionalForeignKeyClass("Class Name");

    // Assert
    assertEquals("ADDITIONAL_FOREIGN_KEY|Class Name", fieldDefinitionImpl.getFieldTypeVal());
    assertEquals("Class Name", fieldDefinitionImpl.getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}
   */
  @Test
  public void testSetAdditionalForeignKeyClass_givenFieldDefinitionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new FieldDefinitionImpl()).setAdditionalForeignKeyClass("Class Name"));
  }

  /**
   * Test {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldType is
   * {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}
   */
  @Test
  public void testSetAdditionalForeignKeyClass_givenFieldDefinitionImplFieldTypeIsUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fieldDefinitionImpl.setAdditionalForeignKeyClass("Class Name"));
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)} with
   * {@code SupportedFieldType}.
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)}
   */
  @Test
  public void testSetFieldTypeWithSupportedFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();

    // Act
    fieldDefinitionImpl.setFieldType(SupportedFieldType.UNKNOWN);

    // Assert
    assertEquals("UNKNOWN", fieldDefinitionImpl.getFieldTypeVal());
    assertEquals(SupportedFieldType.UNKNOWN, fieldDefinitionImpl.getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)} with
   * {@code SupportedFieldType}.
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)}
   */
  @Test
  public void testSetFieldTypeWithSupportedFieldType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setAllowMultiples(true);
    fieldDefinitionImpl.setColumnWidth("Column Width");
    fieldDefinitionImpl.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl.setFieldOrder(1);
    fieldDefinitionImpl.setFieldType("Field Type");
    fieldDefinitionImpl.setFriendlyName("Friendly Name");
    fieldDefinitionImpl.setHelpText("Help Text");
    fieldDefinitionImpl.setHiddenFlag(true);
    fieldDefinitionImpl.setHint("Hint");
    fieldDefinitionImpl.setId(1L);
    fieldDefinitionImpl.setMaxLength(3);
    fieldDefinitionImpl.setName("Name");
    fieldDefinitionImpl.setRequiredFlag(true);
    fieldDefinitionImpl.setSecurityLevel("Security Level");
    fieldDefinitionImpl.setTextAreaFlag(true);
    fieldDefinitionImpl.setTooltip("127.0.0.1");
    fieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl.setValidationRegEx(".*");

    // Act
    fieldDefinitionImpl.setFieldType((SupportedFieldType) null);

    // Assert
    assertNull(fieldDefinitionImpl.getFieldTypeVal());
    assertNull(fieldDefinitionImpl.getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)} with
   * {@code SupportedFieldType}.
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)}
   */
  @Test
  public void testSetFieldTypeWithSupportedFieldType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setAllowMultiples(true);
    fieldDefinitionImpl.setColumnWidth("Column Width");
    fieldDefinitionImpl.setDataDrivenEnumeration(mock(DataDrivenEnumerationImpl.class));
    fieldDefinitionImpl.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl.setFieldOrder(1);
    fieldDefinitionImpl.setFieldType("Field Type");
    fieldDefinitionImpl.setFriendlyName("Friendly Name");
    fieldDefinitionImpl.setHelpText("Help Text");
    fieldDefinitionImpl.setHiddenFlag(true);
    fieldDefinitionImpl.setHint("Hint");
    fieldDefinitionImpl.setId(1L);
    fieldDefinitionImpl.setMaxLength(3);
    fieldDefinitionImpl.setName("Name");
    fieldDefinitionImpl.setRequiredFlag(true);
    fieldDefinitionImpl.setSecurityLevel("Security Level");
    fieldDefinitionImpl.setTextAreaFlag(true);
    fieldDefinitionImpl.setTooltip("127.0.0.1");
    fieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl.setValidationRegEx(".*");

    // Act
    fieldDefinitionImpl.setFieldType((SupportedFieldType) null);

    // Assert
    assertNull(fieldDefinitionImpl.getFieldTypeVal());
    assertNull(fieldDefinitionImpl.getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#getHiddenFlag()}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getHiddenFlag()}
   */
  @Test
  public void testGetHiddenFlag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setAllowMultiples(true);
    fieldDefinitionImpl.setColumnWidth("Column Width");
    fieldDefinitionImpl.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl.setFieldOrder(1);
    fieldDefinitionImpl.setFieldType("Field Type");
    fieldDefinitionImpl.setFriendlyName("Friendly Name");
    fieldDefinitionImpl.setHelpText("Help Text");
    fieldDefinitionImpl.setHint("Hint");
    fieldDefinitionImpl.setId(1L);
    fieldDefinitionImpl.setMaxLength(3);
    fieldDefinitionImpl.setName("Name");
    fieldDefinitionImpl.setRequiredFlag(true);
    fieldDefinitionImpl.setSecurityLevel("Security Level");
    fieldDefinitionImpl.setTextAreaFlag(true);
    fieldDefinitionImpl.setTooltip("127.0.0.1");
    fieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl.setValidationRegEx(".*");
    fieldDefinitionImpl.setHiddenFlag(null);

    // Act and Assert
    assertFalse(fieldDefinitionImpl.getHiddenFlag());
  }

  /**
   * Test {@link FieldDefinitionImpl#getHiddenFlag()}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getHiddenFlag()}
   */
  @Test
  public void testGetHiddenFlag2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setAllowMultiples(true);
    fieldDefinitionImpl.setColumnWidth("Column Width");
    fieldDefinitionImpl.setDataDrivenEnumeration(mock(DataDrivenEnumerationImpl.class));
    fieldDefinitionImpl.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl.setFieldOrder(1);
    fieldDefinitionImpl.setFieldType("Field Type");
    fieldDefinitionImpl.setFriendlyName("Friendly Name");
    fieldDefinitionImpl.setHelpText("Help Text");
    fieldDefinitionImpl.setHint("Hint");
    fieldDefinitionImpl.setId(1L);
    fieldDefinitionImpl.setMaxLength(3);
    fieldDefinitionImpl.setName("Name");
    fieldDefinitionImpl.setRequiredFlag(true);
    fieldDefinitionImpl.setSecurityLevel("Security Level");
    fieldDefinitionImpl.setTextAreaFlag(true);
    fieldDefinitionImpl.setTooltip("127.0.0.1");
    fieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl.setValidationRegEx(".*");
    fieldDefinitionImpl.setHiddenFlag(null);

    // Act and Assert
    assertFalse(fieldDefinitionImpl.getHiddenFlag());
  }

  /**
   * Test {@link FieldDefinitionImpl#getHiddenFlag()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) HiddenFlag is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getHiddenFlag()}
   */
  @Test
  public void testGetHiddenFlag_givenFieldDefinitionImplHiddenFlagIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setAllowMultiples(true);
    fieldDefinitionImpl.setColumnWidth("Column Width");
    fieldDefinitionImpl.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl.setFieldOrder(1);
    fieldDefinitionImpl.setFieldType("Field Type");
    fieldDefinitionImpl.setFriendlyName("Friendly Name");
    fieldDefinitionImpl.setHelpText("Help Text");
    fieldDefinitionImpl.setHint("Hint");
    fieldDefinitionImpl.setId(1L);
    fieldDefinitionImpl.setMaxLength(3);
    fieldDefinitionImpl.setName("Name");
    fieldDefinitionImpl.setRequiredFlag(true);
    fieldDefinitionImpl.setSecurityLevel("Security Level");
    fieldDefinitionImpl.setTextAreaFlag(true);
    fieldDefinitionImpl.setTooltip("127.0.0.1");
    fieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl.setValidationRegEx(".*");
    fieldDefinitionImpl.setHiddenFlag(true);

    // Act and Assert
    assertTrue(fieldDefinitionImpl.getHiddenFlag());
  }

  /**
   * Test {@link FieldDefinitionImpl#getHiddenFlag()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getHiddenFlag()}
   */
  @Test
  public void testGetHiddenFlag_givenFieldDefinitionImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FieldDefinitionImpl()).getHiddenFlag());
  }

  /**
   * Test {@link FieldDefinitionImpl#getFieldOrder()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getFieldOrder()}
   */
  @Test
  public void testGetFieldOrder_givenFieldDefinitionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new FieldDefinitionImpl()).getFieldOrder());
  }

  /**
   * Test {@link FieldDefinitionImpl#getFieldOrder()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldGroup is
   * {@link FieldGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getFieldOrder()}
   */
  @Test
  public void testGetFieldOrder_givenFieldDefinitionImplFieldGroupIsFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldGroup(mock(FieldGroupImpl.class));

    // Act and Assert
    assertEquals(0, fieldDefinitionImpl.getFieldOrder());
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldOrder(int)}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setFieldOrder(int)}
   */
  @Test
  public void testSetFieldOrder_givenFieldDefinitionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();

    // Act
    fieldDefinitionImpl.setFieldOrder(1);

    // Assert
    assertEquals(1, fieldDefinitionImpl.fieldOrder.intValue());
    assertEquals(1, fieldDefinitionImpl.getFieldOrder());
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldOrder(int)}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldGroup is
   * {@link FieldGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setFieldOrder(int)}
   */
  @Test
  public void testSetFieldOrder_givenFieldDefinitionImplFieldGroupIsFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setFieldGroup(mock(FieldGroupImpl.class));

    // Act
    fieldDefinitionImpl.setFieldOrder(1);

    // Assert
    assertEquals(1, fieldDefinitionImpl.fieldOrder.intValue());
    assertEquals(1, fieldDefinitionImpl.getFieldOrder());
  }

  /**
   * Test
   * {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FieldDefinition> actualCreateOrRetrieveCopyInstanceResult = fieldDefinitionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link FieldDefinitionImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnFieldDefinitionImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FieldDefinition> actualCreateOrRetrieveCopyInstanceResult = fieldDefinitionImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.field.domain.FieldDefinitionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    FieldDefinition clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof FieldDefinitionImpl);
    assertEquals("", clone.getName());
    assertNull(clone.getMaxLength());
    assertNull(clone.getId());
    assertNull(clone.getAdditionalForeignKeyClass());
    assertNull(clone.getColumnWidth());
    assertNull(clone.getFieldTypeVal());
    assertNull(clone.getFriendlyName());
    assertNull(clone.getHelpText());
    assertNull(clone.getHint());
    assertNull(clone.getSecurityLevel());
    assertNull(clone.getTooltip());
    assertNull(clone.getValidationErrorMesageKey());
    assertNull(clone.getValidationRegEx());
    assertNull(((FieldDefinitionImpl) clone).name);
    assertNull(clone.getFieldGroup());
    assertNull(clone.getDataDrivenEnumeration());
    assertNull(clone.getFieldType());
    assertEquals(0, ((FieldDefinitionImpl) clone).fieldOrder.intValue());
    assertEquals(0, clone.getFieldOrder());
    assertFalse(clone.getAllowMultiples());
    assertFalse(clone.getHiddenFlag());
    assertFalse(clone.getRequiredFlag());
    assertFalse(clone.getTextAreaFlag());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(((FieldDefinitionImpl) clone).hiddenFlag);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldDefinitionImpl}
   *   <li>{@link FieldDefinitionImpl#setAllowMultiples(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setColumnWidth(String)}
   *   <li>
   * {@link FieldDefinitionImpl#setDataDrivenEnumeration(DataDrivenEnumeration)}
   *   <li>{@link FieldDefinitionImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link FieldDefinitionImpl#setFieldType(String)}
   *   <li>{@link FieldDefinitionImpl#setFriendlyName(String)}
   *   <li>{@link FieldDefinitionImpl#setHelpText(String)}
   *   <li>{@link FieldDefinitionImpl#setHiddenFlag(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setHint(String)}
   *   <li>{@link FieldDefinitionImpl#setId(Long)}
   *   <li>{@link FieldDefinitionImpl#setMaxLength(Integer)}
   *   <li>{@link FieldDefinitionImpl#setName(String)}
   *   <li>{@link FieldDefinitionImpl#setRequiredFlag(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setSecurityLevel(String)}
   *   <li>{@link FieldDefinitionImpl#setTextAreaFlag(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setTooltip(String)}
   *   <li>{@link FieldDefinitionImpl#setValidationErrorMesageKey(String)}
   *   <li>{@link FieldDefinitionImpl#setValidationRegEx(String)}
   *   <li>{@link FieldDefinitionImpl#getAllowMultiples()}
   *   <li>{@link FieldDefinitionImpl#getColumnWidth()}
   *   <li>{@link FieldDefinitionImpl#getDataDrivenEnumeration()}
   *   <li>{@link FieldDefinitionImpl#getFieldGroup()}
   *   <li>{@link FieldDefinitionImpl#getFieldTypeVal()}
   *   <li>{@link FieldDefinitionImpl#getFriendlyName()}
   *   <li>{@link FieldDefinitionImpl#getHelpText()}
   *   <li>{@link FieldDefinitionImpl#getHint()}
   *   <li>{@link FieldDefinitionImpl#getId()}
   *   <li>{@link FieldDefinitionImpl#getMaxLength()}
   *   <li>{@link FieldDefinitionImpl#getRequiredFlag()}
   *   <li>{@link FieldDefinitionImpl#getSecurityLevel()}
   *   <li>{@link FieldDefinitionImpl#getTextAreaFlag()}
   *   <li>{@link FieldDefinitionImpl#getTooltip()}
   *   <li>{@link FieldDefinitionImpl#getValidationErrorMesageKey()}
   *   <li>{@link FieldDefinitionImpl#getValidationRegEx()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldDefinitionImpl actualFieldDefinitionImpl = new FieldDefinitionImpl();
    actualFieldDefinitionImpl.setAllowMultiples(true);
    actualFieldDefinitionImpl.setColumnWidth("Column Width");
    DataDrivenEnumerationImpl dataDrivenEnumeration = new DataDrivenEnumerationImpl();
    actualFieldDefinitionImpl.setDataDrivenEnumeration(dataDrivenEnumeration);
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualFieldDefinitionImpl.setFieldGroup(fieldGroup);
    actualFieldDefinitionImpl.setFieldType("Field Type");
    actualFieldDefinitionImpl.setFriendlyName("Friendly Name");
    actualFieldDefinitionImpl.setHelpText("Help Text");
    actualFieldDefinitionImpl.setHiddenFlag(true);
    actualFieldDefinitionImpl.setHint("Hint");
    actualFieldDefinitionImpl.setId(1L);
    actualFieldDefinitionImpl.setMaxLength(3);
    actualFieldDefinitionImpl.setName("Name");
    actualFieldDefinitionImpl.setRequiredFlag(true);
    actualFieldDefinitionImpl.setSecurityLevel("Security Level");
    actualFieldDefinitionImpl.setTextAreaFlag(true);
    actualFieldDefinitionImpl.setTooltip("127.0.0.1");
    actualFieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    actualFieldDefinitionImpl.setValidationRegEx(".*");
    Boolean actualAllowMultiples = actualFieldDefinitionImpl.getAllowMultiples();
    String actualColumnWidth = actualFieldDefinitionImpl.getColumnWidth();
    DataDrivenEnumeration actualDataDrivenEnumeration = actualFieldDefinitionImpl.getDataDrivenEnumeration();
    FieldGroup actualFieldGroup = actualFieldDefinitionImpl.getFieldGroup();
    String actualFieldTypeVal = actualFieldDefinitionImpl.getFieldTypeVal();
    String actualFriendlyName = actualFieldDefinitionImpl.getFriendlyName();
    String actualHelpText = actualFieldDefinitionImpl.getHelpText();
    String actualHint = actualFieldDefinitionImpl.getHint();
    Long actualId = actualFieldDefinitionImpl.getId();
    Integer actualMaxLength = actualFieldDefinitionImpl.getMaxLength();
    Boolean actualRequiredFlag = actualFieldDefinitionImpl.getRequiredFlag();
    String actualSecurityLevel = actualFieldDefinitionImpl.getSecurityLevel();
    Boolean actualTextAreaFlag = actualFieldDefinitionImpl.getTextAreaFlag();
    actualFieldDefinitionImpl.getTooltip();
    String actualValidationErrorMesageKey = actualFieldDefinitionImpl.getValidationErrorMesageKey();

    // Assert that nothing has changed
    assertEquals(".*", actualFieldDefinitionImpl.getValidationRegEx());
    assertEquals("An error occurred", actualValidationErrorMesageKey);
    assertEquals("Column Width", actualColumnWidth);
    assertEquals("Field Type", actualFieldTypeVal);
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Help Text", actualHelpText);
    assertEquals("Hint", actualHint);
    assertEquals("Security Level", actualSecurityLevel);
    assertEquals(0, actualFieldDefinitionImpl.fieldOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(3, actualMaxLength.intValue());
    assertTrue(actualAllowMultiples);
    assertTrue(actualRequiredFlag);
    assertTrue(actualTextAreaFlag);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(dataDrivenEnumeration, actualDataDrivenEnumeration);
  }
}
