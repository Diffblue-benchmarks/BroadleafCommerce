/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class IndexFieldImplDiffblueTest {
  /**
   * Test
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexField> actualCreateOrRetrieveCopyInstanceResult = indexFieldImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link IndexFieldImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnIndexFieldImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<IndexField> actualCreateOrRetrieveCopyInstanceResult = indexFieldImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.search.domain.IndexFieldImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    IndexField clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof IndexFieldImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(indexFieldImpl, clone);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and
   * {@link IndexFieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(null);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(null);
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertEquals(indexFieldImpl, indexFieldImpl2);
    int expectedHashCodeResult = indexFieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, indexFieldImpl2.hashCode());
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and
   * {@link IndexFieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertEquals(indexFieldImpl, indexFieldImpl);
    int expectedHashCodeResult = indexFieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, indexFieldImpl.hashCode());
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(null);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(new FieldImpl());
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, indexFieldImpl2);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(mock(FieldImpl.class));
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(new FieldImpl());
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, indexFieldImpl2);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, null);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, "Different type to IndexFieldImpl");
  }

  /**
   * Test {@link IndexFieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor) Field is
   * {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenIndexFieldImplFieldIsFieldImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNull(indexFieldImpl.getMainEntityName());
  }

  /**
   * Test {@link IndexFieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then return {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_thenReturnFriendlyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Field field = mock(Field.class);
    when(field.getFriendlyName()).thenReturn("Friendly Name");

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(field);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act
    String actualMainEntityName = indexFieldImpl.getMainEntityName();

    // Assert
    verify(field).getFriendlyName();
    assertEquals("Friendly Name", actualMainEntityName);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexFieldImpl}
   *   <li>{@link IndexFieldImpl#setField(Field)}
   *   <li>{@link IndexFieldImpl#setFieldTypes(List)}
   *   <li>{@link IndexFieldImpl#setId(Long)}
   *   <li>{@link IndexFieldImpl#setSearchable(Boolean)}
   *   <li>{@link IndexFieldImpl#getField()}
   *   <li>{@link IndexFieldImpl#getFieldTypes()}
   *   <li>{@link IndexFieldImpl#getId()}
   *   <li>{@link IndexFieldImpl#getSearchable()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexFieldImpl actualIndexFieldImpl = new IndexFieldImpl();
    FieldImpl field = new FieldImpl();
    actualIndexFieldImpl.setField(field);
    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    actualIndexFieldImpl.setFieldTypes(fieldTypes);
    actualIndexFieldImpl.setId(1L);
    actualIndexFieldImpl.setSearchable(true);
    Field actualField = actualIndexFieldImpl.getField();
    List<IndexFieldType> actualFieldTypes = actualIndexFieldImpl.getFieldTypes();
    Long actualId = actualIndexFieldImpl.getId();
    Boolean actualSearchable = actualIndexFieldImpl.getSearchable();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertTrue(actualFieldTypes.isEmpty());
    assertTrue(actualSearchable);
    assertSame(fieldTypes, actualFieldTypes);
    assertSame(field, actualField);
  }
}
