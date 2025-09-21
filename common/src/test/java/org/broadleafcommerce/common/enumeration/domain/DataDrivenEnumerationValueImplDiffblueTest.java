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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
public class DataDrivenEnumerationValueImplDiffblueTest {
  @Autowired private DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl;

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} Hidden is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DataDrivenEnumerationValueImpl.getHidden()"})
  public void testGetHidden_givenDataDrivenEnumerationValueImplHiddenIsNull_thenReturnFalse() {
    // Arrange
    dataDrivenEnumerationValueImpl.setHidden(null);

    // Act and Assert
    assertFalse(dataDrivenEnumerationValueImpl.getHidden());
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} Hidden is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DataDrivenEnumerationValueImpl.getHidden()"})
  public void testGetHidden_givenDataDrivenEnumerationValueImplHiddenIsTrue_thenReturnTrue() {
    // Arrange
    dataDrivenEnumerationValueImpl.setHidden(true);

    // Act and Assert
    assertTrue(dataDrivenEnumerationValueImpl.getHidden());
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   *
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean DataDrivenEnumerationValueImpl.getHidden()"})
  public void testGetHidden_givenDataDrivenEnumerationValueImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(dataDrivenEnumerationValueImpl.getHidden());
  }

  /**
   * Test {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse DataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new DataDrivenEnumerationValueImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DataDrivenEnumerationValue> actualCreateOrRetrieveCopyInstanceResult =
        dataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse DataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(dataDrivenEnumerationValueImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DataDrivenEnumerationValue> actualCreateOrRetrieveCopyInstanceResult =
        dataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse DataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    DataDrivenEnumerationImpl type = mock(DataDrivenEnumerationImpl.class);
    when(type.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new DataDrivenEnumerationImpl(), true));

    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl =
        new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl.setType(type);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new DataDrivenEnumerationValueImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    dataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(type).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse DataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    DataDrivenEnumerationImpl type = mock(DataDrivenEnumerationImpl.class);
    when(type.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl =
        new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl.setType(type);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new DataDrivenEnumerationValueImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> dataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(type).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DataDrivenEnumerationValueImpl}
   *   <li>{@link DataDrivenEnumerationValueImpl#setDisplay(String)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setHidden(Boolean)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setId(Long)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setKey(String)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setType(DataDrivenEnumeration)}
   *   <li>{@link DataDrivenEnumerationValueImpl#getDisplay()}
   *   <li>{@link DataDrivenEnumerationValueImpl#getId()}
   *   <li>{@link DataDrivenEnumerationValueImpl#getKey()}
   *   <li>{@link DataDrivenEnumerationValueImpl#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDrivenEnumerationValueImpl.<init>()",
    "String DataDrivenEnumerationValueImpl.getDisplay()",
    "Long DataDrivenEnumerationValueImpl.getId()",
    "String DataDrivenEnumerationValueImpl.getKey()",
    "DataDrivenEnumeration DataDrivenEnumerationValueImpl.getType()",
    "void DataDrivenEnumerationValueImpl.setDisplay(String)",
    "void DataDrivenEnumerationValueImpl.setHidden(Boolean)",
    "void DataDrivenEnumerationValueImpl.setId(Long)",
    "void DataDrivenEnumerationValueImpl.setKey(String)",
    "void DataDrivenEnumerationValueImpl.setType(DataDrivenEnumeration)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DataDrivenEnumerationValueImpl actualDataDrivenEnumerationValueImpl =
        new DataDrivenEnumerationValueImpl();
    actualDataDrivenEnumerationValueImpl.setDisplay("Display");
    actualDataDrivenEnumerationValueImpl.setHidden(true);
    actualDataDrivenEnumerationValueImpl.setId(1L);
    actualDataDrivenEnumerationValueImpl.setKey("Key");
    DataDrivenEnumerationImpl type = new DataDrivenEnumerationImpl();
    actualDataDrivenEnumerationValueImpl.setType(type);
    String actualDisplay = actualDataDrivenEnumerationValueImpl.getDisplay();
    Long actualId = actualDataDrivenEnumerationValueImpl.getId();
    String actualKey = actualDataDrivenEnumerationValueImpl.getKey();
    DataDrivenEnumeration actualType = actualDataDrivenEnumerationValueImpl.getType();

    // Assert
    assertEquals("Display", actualDisplay);
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(type, actualType);
  }
}
