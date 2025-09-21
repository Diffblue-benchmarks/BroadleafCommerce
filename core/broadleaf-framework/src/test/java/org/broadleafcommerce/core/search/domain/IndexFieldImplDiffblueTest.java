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
import static org.junit.Assert.assertNotEquals;
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
import java.util.ArrayList;
import java.util.List;
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

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class IndexFieldImplDiffblueTest {
  @Autowired private IndexFieldImpl indexFieldImpl;

  /**
   * Test {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse IndexFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new IndexFieldImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexField> actualCreateOrRetrieveCopyInstanceResult =
        indexFieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse IndexFieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(indexFieldImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexField> actualCreateOrRetrieveCopyInstanceResult =
        indexFieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and {@link IndexFieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
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
    assertEquals(indexFieldImpl.hashCode(), indexFieldImpl2.hashCode());
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and {@link IndexFieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor) Field is {@link FieldImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexFieldImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenIndexFieldImplFieldIsFieldImpl_thenReturnNull() {
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
   *
   * <ul>
   *   <li>Then return {@code Friendly Name}.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexFieldImpl.getMainEntityName()"})
  public void testGetMainEntityName_thenReturnFriendlyName() {
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IndexFieldImpl.<init>()",
    "Field IndexFieldImpl.getField()",
    "List IndexFieldImpl.getFieldTypes()",
    "Long IndexFieldImpl.getId()",
    "Boolean IndexFieldImpl.getSearchable()",
    "void IndexFieldImpl.setField(Field)",
    "void IndexFieldImpl.setFieldTypes(List)",
    "void IndexFieldImpl.setId(Long)",
    "void IndexFieldImpl.setSearchable(Boolean)"
  })
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

    // Assert
    assertEquals(1L, actualId.longValue());
    assertTrue(actualFieldTypes.isEmpty());
    assertTrue(actualSearchable);
    assertSame(fieldTypes, actualFieldTypes);
    assertSame(field, actualField);
  }
}
