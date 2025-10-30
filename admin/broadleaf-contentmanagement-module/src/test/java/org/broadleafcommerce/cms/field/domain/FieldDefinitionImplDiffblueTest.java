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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
public class FieldDefinitionImplDiffblueTest {
  @Autowired
  private FieldDefinitionImpl fieldDefinitionImpl;

  /**
   * Test {@link FieldDefinitionImpl#getName()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) AllowMultiples is {@code true}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldDefinitionImpl.getName()"})
  public void testGetName_givenFieldDefinitionImplAllowMultiplesIsTrue_thenReturnFoo() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setAllowMultiples(true);
    fieldDefinitionImpl2.setColumnWidth("Column Width");
    fieldDefinitionImpl2.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl2.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl2.setFieldOrder(1);
    fieldDefinitionImpl2.setFieldType("Field Type");
    fieldDefinitionImpl2.setFriendlyName("Friendly Name");
    fieldDefinitionImpl2.setHelpText("Help Text");
    fieldDefinitionImpl2.setHiddenFlag(true);
    fieldDefinitionImpl2.setHint("Hint");
    fieldDefinitionImpl2.setId(1L);
    fieldDefinitionImpl2.setMaxLength(3);
    fieldDefinitionImpl2.setRequiredFlag(true);
    fieldDefinitionImpl2.setSecurityLevel("Security Level");
    fieldDefinitionImpl2.setTextAreaFlag(true);
    fieldDefinitionImpl2.setTooltip("127.0.0.1");
    fieldDefinitionImpl2.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl2.setValidationRegEx(".*");
    fieldDefinitionImpl2.setName("foo");

    // Act and Assert
    assertEquals("foo", fieldDefinitionImpl2.getName());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldDefinitionImpl.getName()"})
  public void testGetName_givenFieldDefinitionImpl_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new FieldDefinitionImpl()).getName());
  }

  /**
   * Test {@link FieldDefinitionImpl#getFieldType()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldType is {@code UNKNOWN}.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getFieldType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SupportedFieldType FieldDefinitionImpl.getFieldType()"})
  public void testGetFieldType_givenFieldDefinitionImplFieldTypeIsUnknown_thenReturnUnknown() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertEquals(SupportedFieldType.UNKNOWN, fieldDefinitionImpl2.getFieldType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SupportedFieldType FieldDefinitionImpl.getFieldType()"})
  public void testGetFieldType_givenFieldDefinitionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FieldDefinitionImpl()).getFieldType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldDefinitionImpl.getAdditionalForeignKeyClass()"})
  public void testGetAdditionalForeignKeyClass_givenFieldDefinitionImpl() {
    // Arrange, Act and Assert
    assertNull((new FieldDefinitionImpl()).getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldType is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getAdditionalForeignKeyClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldDefinitionImpl.getAdditionalForeignKeyClass()"})
  public void testGetAdditionalForeignKeyClass_givenFieldDefinitionImplFieldTypeIsUnknown() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNull(fieldDefinitionImpl2.getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldDefinitionImpl.setAdditionalForeignKeyClass(String)"})
  public void testSetAdditionalForeignKeyClass() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setFieldType(SupportedFieldType.ADDITIONAL_FOREIGN_KEY);

    // Act
    fieldDefinitionImpl2.setAdditionalForeignKeyClass("Class Name");

    // Assert
    assertEquals("ADDITIONAL_FOREIGN_KEY|Class Name", fieldDefinitionImpl2.getFieldTypeVal());
    assertEquals("Class Name", fieldDefinitionImpl2.getAdditionalForeignKeyClass());
  }

  /**
   * Test {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldDefinitionImpl.setAdditionalForeignKeyClass(String)"})
  public void testSetAdditionalForeignKeyClass_givenFieldDefinitionImpl() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new FieldDefinitionImpl()).setAdditionalForeignKeyClass("Class Name"));
  }

  /**
   * Test {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) FieldType is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setAdditionalForeignKeyClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldDefinitionImpl.setAdditionalForeignKeyClass(String)"})
  public void testSetAdditionalForeignKeyClass_givenFieldDefinitionImplFieldTypeIsUnknown() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> fieldDefinitionImpl2.setAdditionalForeignKeyClass("Class Name"));
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)} with {@code SupportedFieldType}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldDefinitionImpl.setFieldType(SupportedFieldType)"})
  public void testSetFieldTypeWithSupportedFieldType() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();

    // Act
    fieldDefinitionImpl2.setFieldType(SupportedFieldType.UNKNOWN);

    // Assert
    assertEquals("UNKNOWN", fieldDefinitionImpl2.getFieldTypeVal());
    assertEquals(SupportedFieldType.UNKNOWN, fieldDefinitionImpl2.getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)} with {@code SupportedFieldType}.
   * <ul>
   *   <li>Then {@link FieldDefinitionImpl} (default constructor) FieldTypeVal is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setFieldType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldDefinitionImpl.setFieldType(SupportedFieldType)"})
  public void testSetFieldTypeWithSupportedFieldType_thenFieldDefinitionImplFieldTypeValIsNull() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setAllowMultiples(true);
    fieldDefinitionImpl2.setColumnWidth("Column Width");
    fieldDefinitionImpl2.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl2.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl2.setFieldOrder(1);
    fieldDefinitionImpl2.setFieldType("Field Type");
    fieldDefinitionImpl2.setFriendlyName("Friendly Name");
    fieldDefinitionImpl2.setHelpText("Help Text");
    fieldDefinitionImpl2.setHiddenFlag(true);
    fieldDefinitionImpl2.setHint("Hint");
    fieldDefinitionImpl2.setId(1L);
    fieldDefinitionImpl2.setMaxLength(3);
    fieldDefinitionImpl2.setName("Name");
    fieldDefinitionImpl2.setRequiredFlag(true);
    fieldDefinitionImpl2.setSecurityLevel("Security Level");
    fieldDefinitionImpl2.setTextAreaFlag(true);
    fieldDefinitionImpl2.setTooltip("127.0.0.1");
    fieldDefinitionImpl2.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl2.setValidationRegEx(".*");

    // Act
    fieldDefinitionImpl2.setFieldType((SupportedFieldType) null);

    // Assert
    assertNull(fieldDefinitionImpl2.getFieldTypeVal());
    assertNull(fieldDefinitionImpl2.getFieldType());
  }

  /**
   * Test {@link FieldDefinitionImpl#getHiddenFlag()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) HiddenFlag is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getHiddenFlag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldDefinitionImpl.getHiddenFlag()"})
  public void testGetHiddenFlag_givenFieldDefinitionImplHiddenFlagIsNull_thenReturnFalse() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setAllowMultiples(true);
    fieldDefinitionImpl2.setColumnWidth("Column Width");
    fieldDefinitionImpl2.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl2.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl2.setFieldOrder(1);
    fieldDefinitionImpl2.setFieldType("Field Type");
    fieldDefinitionImpl2.setFriendlyName("Friendly Name");
    fieldDefinitionImpl2.setHelpText("Help Text");
    fieldDefinitionImpl2.setHint("Hint");
    fieldDefinitionImpl2.setId(1L);
    fieldDefinitionImpl2.setMaxLength(3);
    fieldDefinitionImpl2.setName("Name");
    fieldDefinitionImpl2.setRequiredFlag(true);
    fieldDefinitionImpl2.setSecurityLevel("Security Level");
    fieldDefinitionImpl2.setTextAreaFlag(true);
    fieldDefinitionImpl2.setTooltip("127.0.0.1");
    fieldDefinitionImpl2.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl2.setValidationRegEx(".*");
    fieldDefinitionImpl2.setHiddenFlag(null);

    // Act and Assert
    assertFalse(fieldDefinitionImpl2.getHiddenFlag());
  }

  /**
   * Test {@link FieldDefinitionImpl#getHiddenFlag()}.
   * <ul>
   *   <li>Given {@link FieldDefinitionImpl} (default constructor) HiddenFlag is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getHiddenFlag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldDefinitionImpl.getHiddenFlag()"})
  public void testGetHiddenFlag_givenFieldDefinitionImplHiddenFlagIsTrue_thenReturnTrue() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    fieldDefinitionImpl2.setAllowMultiples(true);
    fieldDefinitionImpl2.setColumnWidth("Column Width");
    fieldDefinitionImpl2.setDataDrivenEnumeration(new DataDrivenEnumerationImpl());
    fieldDefinitionImpl2.setFieldGroup(new FieldGroupImpl());
    fieldDefinitionImpl2.setFieldOrder(1);
    fieldDefinitionImpl2.setFieldType("Field Type");
    fieldDefinitionImpl2.setFriendlyName("Friendly Name");
    fieldDefinitionImpl2.setHelpText("Help Text");
    fieldDefinitionImpl2.setHint("Hint");
    fieldDefinitionImpl2.setId(1L);
    fieldDefinitionImpl2.setMaxLength(3);
    fieldDefinitionImpl2.setName("Name");
    fieldDefinitionImpl2.setRequiredFlag(true);
    fieldDefinitionImpl2.setSecurityLevel("Security Level");
    fieldDefinitionImpl2.setTextAreaFlag(true);
    fieldDefinitionImpl2.setTooltip("127.0.0.1");
    fieldDefinitionImpl2.setValidationErrorMesageKey("An error occurred");
    fieldDefinitionImpl2.setValidationRegEx(".*");
    fieldDefinitionImpl2.setHiddenFlag(true);

    // Act and Assert
    assertTrue(fieldDefinitionImpl2.getHiddenFlag());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldDefinitionImpl.getHiddenFlag()"})
  public void testGetHiddenFlag_givenFieldDefinitionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldDefinitionImpl()).getHiddenFlag());
  }

  /**
   * Test {@link FieldDefinitionImpl#getFieldOrder()}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#getFieldOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FieldDefinitionImpl.getFieldOrder()"})
  public void testGetFieldOrder() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldDefinitionImpl()).getFieldOrder());
  }

  /**
   * Test {@link FieldDefinitionImpl#setFieldOrder(int)}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#setFieldOrder(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldDefinitionImpl.setFieldOrder(int)"})
  public void testSetFieldOrder() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();

    // Act
    fieldDefinitionImpl2.setFieldOrder(1);

    // Assert
    assertEquals(1, fieldDefinitionImpl2.fieldOrder.intValue());
    assertEquals(1, fieldDefinitionImpl2.getFieldOrder());
  }

  /**
   * Test {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse FieldDefinitionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FieldDefinition> actualCreateOrRetrieveCopyInstanceResult = fieldDefinitionImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link FieldDefinitionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldDefinitionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse FieldDefinitionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnFieldDefinitionImpl() throws CloneNotSupportedException {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl2 = new FieldDefinitionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FieldDefinition> actualCreateOrRetrieveCopyInstanceResult = fieldDefinitionImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.field.domain.FieldDefinitionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    assertTrue(actualCreateOrRetrieveCopyInstanceResult.getClone() instanceof FieldDefinitionImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldDefinitionImpl}
   *   <li>{@link FieldDefinitionImpl#setAllowMultiples(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setColumnWidth(String)}
   *   <li>{@link FieldDefinitionImpl#setDataDrivenEnumeration(DataDrivenEnumeration)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldDefinitionImpl.<init>()", "Boolean FieldDefinitionImpl.getAllowMultiples()",
      "String FieldDefinitionImpl.getColumnWidth()",
      "DataDrivenEnumeration FieldDefinitionImpl.getDataDrivenEnumeration()",
      "FieldGroup FieldDefinitionImpl.getFieldGroup()", "String FieldDefinitionImpl.getFieldTypeVal()",
      "String FieldDefinitionImpl.getFriendlyName()", "String FieldDefinitionImpl.getHelpText()",
      "String FieldDefinitionImpl.getHint()", "Long FieldDefinitionImpl.getId()",
      "Integer FieldDefinitionImpl.getMaxLength()", "Boolean FieldDefinitionImpl.getRequiredFlag()",
      "String FieldDefinitionImpl.getSecurityLevel()", "Boolean FieldDefinitionImpl.getTextAreaFlag()",
      "String FieldDefinitionImpl.getTooltip()", "String FieldDefinitionImpl.getValidationErrorMesageKey()",
      "String FieldDefinitionImpl.getValidationRegEx()", "void FieldDefinitionImpl.setAllowMultiples(Boolean)",
      "void FieldDefinitionImpl.setColumnWidth(String)",
      "void FieldDefinitionImpl.setDataDrivenEnumeration(DataDrivenEnumeration)",
      "void FieldDefinitionImpl.setFieldGroup(FieldGroup)", "void FieldDefinitionImpl.setFieldType(String)",
      "void FieldDefinitionImpl.setFriendlyName(String)", "void FieldDefinitionImpl.setHelpText(String)",
      "void FieldDefinitionImpl.setHiddenFlag(Boolean)", "void FieldDefinitionImpl.setHint(String)",
      "void FieldDefinitionImpl.setId(Long)", "void FieldDefinitionImpl.setMaxLength(Integer)",
      "void FieldDefinitionImpl.setName(String)", "void FieldDefinitionImpl.setRequiredFlag(Boolean)",
      "void FieldDefinitionImpl.setSecurityLevel(String)", "void FieldDefinitionImpl.setTextAreaFlag(Boolean)",
      "void FieldDefinitionImpl.setTooltip(String)", "void FieldDefinitionImpl.setValidationErrorMesageKey(String)",
      "void FieldDefinitionImpl.setValidationRegEx(String)"})
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

    // Assert
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
