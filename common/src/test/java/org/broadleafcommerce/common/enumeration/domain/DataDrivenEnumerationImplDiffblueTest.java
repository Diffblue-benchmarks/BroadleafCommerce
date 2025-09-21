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
package org.broadleafcommerce.common.enumeration.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class DataDrivenEnumerationImplDiffblueTest {
  @Autowired private DataDrivenEnumerationImpl dataDrivenEnumerationImpl;

  /**
   * Test {@link DataDrivenEnumerationImpl#getModifiable()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl} Modifiable is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationImpl#getModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DataDrivenEnumerationImpl.getModifiable()"})
  public void testGetModifiable_givenDataDrivenEnumerationImplModifiableIsNull_thenReturnFalse() {
    // Arrange
    dataDrivenEnumerationImpl.setModifiable(null);

    // Act and Assert
    assertFalse(dataDrivenEnumerationImpl.getModifiable());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getModifiable()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl} Modifiable is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationImpl#getModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DataDrivenEnumerationImpl.getModifiable()"})
  public void testGetModifiable_givenDataDrivenEnumerationImplModifiableIsTrue_thenReturnTrue() {
    // Arrange
    dataDrivenEnumerationImpl.setModifiable(true);

    // Act and Assert
    assertTrue(dataDrivenEnumerationImpl.getModifiable());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getModifiable()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationImpl#getModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DataDrivenEnumerationImpl.getModifiable()"})
  public void testGetModifiable_givenDataDrivenEnumerationImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(dataDrivenEnumerationImpl.getModifiable());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_givenDataDrivenEnumerationImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(dataDrivenEnumerationImpl.getEnumValues().isEmpty());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} (default constructor) Hidden is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_givenDataDrivenEnumerationValueImplHiddenIsTrue() {
    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl =
        new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl.setHidden(true);

    ArrayList<DataDrivenEnumerationValue> enumValues = new ArrayList<>();
    enumValues.add(dataDrivenEnumerationValueImpl);

    DataDrivenEnumerationImpl dataDrivenEnumerationImpl = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl.setEnumValues(enumValues);

    // Act and Assert
    assertTrue(dataDrivenEnumerationImpl.getEnumValues().isEmpty());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_thenReturnArrayList() {
    // Arrange
    ArrayList<DataDrivenEnumerationValue> enumValues = new ArrayList<>();
    enumValues.add(new DataDrivenEnumerationValueImpl());

    DataDrivenEnumerationImpl dataDrivenEnumerationImpl = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl.setEnumValues(enumValues);

    // Act and Assert
    assertEquals(enumValues, dataDrivenEnumerationImpl.getEnumValues());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<DataDrivenEnumerationValue> enumValues = new ArrayList<>();
    enumValues.add(new DataDrivenEnumerationValueImpl());
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl =
        new DataDrivenEnumerationValueImpl();
    enumValues.add(dataDrivenEnumerationValueImpl);

    DataDrivenEnumerationImpl dataDrivenEnumerationImpl = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl.setEnumValues(enumValues);

    // Act
    List<DataDrivenEnumerationValue> actualEnumValues = dataDrivenEnumerationImpl.getEnumValues();

    // Assert
    assertEquals(2, actualEnumValues.size());
    assertSame(dataDrivenEnumerationValueImpl, actualEnumValues.get(1));
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse DataDrivenEnumerationImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new DataDrivenEnumerationImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DataDrivenEnumeration> actualCreateOrRetrieveCopyInstanceResult =
        dataDrivenEnumerationImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse DataDrivenEnumerationImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(dataDrivenEnumerationImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DataDrivenEnumeration> actualCreateOrRetrieveCopyInstanceResult =
        dataDrivenEnumerationImpl.createOrRetrieveCopyInstance(context);

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
   *   <li>default or parameterless constructor of {@link DataDrivenEnumerationImpl}
   *   <li>{@link DataDrivenEnumerationImpl#setEnumValues(List)}
   *   <li>{@link DataDrivenEnumerationImpl#setId(Long)}
   *   <li>{@link DataDrivenEnumerationImpl#setKey(String)}
   *   <li>{@link DataDrivenEnumerationImpl#setModifiable(Boolean)}
   *   <li>{@link DataDrivenEnumerationImpl#setOrderItems(List)}
   *   <li>{@link DataDrivenEnumerationImpl#getId()}
   *   <li>{@link DataDrivenEnumerationImpl#getKey()}
   *   <li>{@link DataDrivenEnumerationImpl#getOrderItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDrivenEnumerationImpl.<init>()",
    "Long DataDrivenEnumerationImpl.getId()",
    "String DataDrivenEnumerationImpl.getKey()",
    "List DataDrivenEnumerationImpl.getOrderItems()",
    "void DataDrivenEnumerationImpl.setEnumValues(List)",
    "void DataDrivenEnumerationImpl.setId(Long)",
    "void DataDrivenEnumerationImpl.setKey(String)",
    "void DataDrivenEnumerationImpl.setModifiable(Boolean)",
    "void DataDrivenEnumerationImpl.setOrderItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DataDrivenEnumerationImpl actualDataDrivenEnumerationImpl = new DataDrivenEnumerationImpl();
    actualDataDrivenEnumerationImpl.setEnumValues(new ArrayList<>());
    actualDataDrivenEnumerationImpl.setId(1L);
    actualDataDrivenEnumerationImpl.setKey("Key");
    actualDataDrivenEnumerationImpl.setModifiable(true);
    ArrayList<DataDrivenEnumerationValue> orderItems = new ArrayList<>();
    actualDataDrivenEnumerationImpl.setOrderItems(orderItems);
    Long actualId = actualDataDrivenEnumerationImpl.getId();
    String actualKey = actualDataDrivenEnumerationImpl.getKey();
    List<DataDrivenEnumerationValue> actualOrderItems =
        actualDataDrivenEnumerationImpl.getOrderItems();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualOrderItems.isEmpty());
    assertSame(orderItems, actualOrderItems);
  }
}
