/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

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
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class IndexFieldTypeImplDiffblueTest {
  @Autowired private IndexFieldTypeImpl indexFieldTypeImpl;

  /**
   * Test {@link IndexFieldTypeImpl#getFieldType()}.
   *
   * <p>Method under test: {@link IndexFieldTypeImpl#getFieldType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldType IndexFieldTypeImpl.getFieldType()"})
  public void testGetFieldType() {
    // Arrange, Act and Assert
    assertNull(indexFieldTypeImpl.getFieldType());
  }

  /**
   * Test {@link IndexFieldTypeImpl#setFieldType(FieldType)}.
   *
   * <ul>
   *   <li>When {@link FieldType#BOOLEAN}.
   *   <li>Then {@link IndexFieldTypeImpl} {@link IndexFieldTypeImpl#fieldType} is {@code b}.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldTypeImpl#setFieldType(FieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexFieldTypeImpl.setFieldType(FieldType)"})
  public void testSetFieldType_whenBoolean_thenIndexFieldTypeImplFieldTypeIsB() {
    // Arrange and Act
    indexFieldTypeImpl.setFieldType(FieldType.BOOLEAN);

    // Assert
    assertEquals("b", indexFieldTypeImpl.fieldType);
    assertSame(FieldType.BOOLEAN, indexFieldTypeImpl.getFieldType());
  }

  /**
   * Test {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse IndexFieldTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new IndexFieldTypeImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult =
        indexFieldTypeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse IndexFieldTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(indexFieldTypeImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult =
        indexFieldTypeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse IndexFieldTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    indexFieldTypeImpl.setFieldType(FieldType.BOOLEAN);

    IndexFieldTypeImpl indexFieldTypeImpl2 = new IndexFieldTypeImpl();
    indexFieldTypeImpl2.setFieldType(FieldType.BOOLEAN);
    indexFieldTypeImpl2.setId(1L);
    indexFieldTypeImpl2.setIndexField(new IndexFieldImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(indexFieldTypeImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult =
        indexFieldTypeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse IndexFieldTypeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsCreateOrRetrieveCopyInstance()
      throws CloneNotSupportedException {
    // Arrange
    IndexFieldImpl indexField = mock(IndexFieldImpl.class);
    when(indexField.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new IndexFieldImpl(), true));

    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    indexFieldTypeImpl.setIndexField(indexField);

    IndexFieldTypeImpl indexFieldTypeImpl2 = new IndexFieldTypeImpl();
    indexFieldTypeImpl2.setFieldType(FieldType.BOOLEAN);
    indexFieldTypeImpl2.setId(1L);
    indexFieldTypeImpl2.setIndexField(new IndexFieldImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(indexFieldTypeImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult =
        indexFieldTypeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(indexField).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexFieldTypeImpl}
   *   <li>{@link IndexFieldTypeImpl#setId(Long)}
   *   <li>{@link IndexFieldTypeImpl#setIndexField(IndexField)}
   *   <li>{@link IndexFieldTypeImpl#getId()}
   *   <li>{@link IndexFieldTypeImpl#getIndexField()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IndexFieldTypeImpl.<init>()",
    "Long IndexFieldTypeImpl.getId()",
    "IndexField IndexFieldTypeImpl.getIndexField()",
    "void IndexFieldTypeImpl.setId(Long)",
    "void IndexFieldTypeImpl.setIndexField(IndexField)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexFieldTypeImpl actualIndexFieldTypeImpl = new IndexFieldTypeImpl();
    actualIndexFieldTypeImpl.setId(1L);
    IndexFieldImpl indexField = new IndexFieldImpl();
    actualIndexFieldTypeImpl.setIndexField(indexField);
    Long actualId = actualIndexFieldTypeImpl.getId();
    IndexField actualIndexField = actualIndexFieldTypeImpl.getIndexField();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(indexField, actualIndexField);
  }
}
