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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DataDrivenEnumerationImplDiffblueTest {
  @Autowired
  private DataDrivenEnumerationImpl dataDrivenEnumerationImpl;

  /**
   * Test {@link DataDrivenEnumerationImpl#getModifiable()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl} (default constructor) Modifiable is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#getModifiable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DataDrivenEnumerationImpl.getModifiable()"})
  public void testGetModifiable_givenDataDrivenEnumerationImplModifiableIsNull_thenReturnFalse() {
    // Arrange
    DataDrivenEnumerationImpl dataDrivenEnumerationImpl2 = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl2.setEnumValues(new ArrayList<>());
    dataDrivenEnumerationImpl2.setId(1L);
    dataDrivenEnumerationImpl2.setKey("Key");
    dataDrivenEnumerationImpl2.setOrderItems(new ArrayList<>());
    dataDrivenEnumerationImpl2.setModifiable(null);

    // Act and Assert
    assertFalse(dataDrivenEnumerationImpl2.getModifiable());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getModifiable()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl} (default constructor) Modifiable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#getModifiable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DataDrivenEnumerationImpl.getModifiable()"})
  public void testGetModifiable_givenDataDrivenEnumerationImplModifiableIsTrue_thenReturnTrue() {
    // Arrange
    DataDrivenEnumerationImpl dataDrivenEnumerationImpl2 = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl2.setEnumValues(new ArrayList<>());
    dataDrivenEnumerationImpl2.setId(1L);
    dataDrivenEnumerationImpl2.setKey("Key");
    dataDrivenEnumerationImpl2.setOrderItems(new ArrayList<>());
    dataDrivenEnumerationImpl2.setModifiable(true);

    // Act and Assert
    assertTrue(dataDrivenEnumerationImpl2.getModifiable());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getModifiable()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#getModifiable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DataDrivenEnumerationImpl.getModifiable()"})
  public void testGetModifiable_givenDataDrivenEnumerationImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DataDrivenEnumerationImpl()).getModifiable());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_givenDataDrivenEnumerationImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new DataDrivenEnumerationImpl()).getEnumValues().isEmpty());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   * <ul>
   *   <li>Then calls {@link DataDrivenEnumerationValue#getHidden()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_thenCallsGetHidden() {
    // Arrange
    DataDrivenEnumerationValue dataDrivenEnumerationValue = mock(DataDrivenEnumerationValue.class);
    when(dataDrivenEnumerationValue.getHidden()).thenReturn(true);

    ArrayList<DataDrivenEnumerationValue> enumValues = new ArrayList<>();
    enumValues.add(dataDrivenEnumerationValue);

    DataDrivenEnumerationImpl dataDrivenEnumerationImpl2 = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl2.setEnumValues(enumValues);

    // Act
    List<DataDrivenEnumerationValue> actualEnumValues = dataDrivenEnumerationImpl2.getEnumValues();

    // Assert
    verify(dataDrivenEnumerationValue).getHidden();
    assertTrue(actualEnumValues.isEmpty());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_thenReturnArrayList() {
    // Arrange
    ArrayList<DataDrivenEnumerationValue> enumValues = new ArrayList<>();
    enumValues.add(new DataDrivenEnumerationValueImpl());

    DataDrivenEnumerationImpl dataDrivenEnumerationImpl2 = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl2.setEnumValues(enumValues);

    // Act and Assert
    assertEquals(enumValues, dataDrivenEnumerationImpl2.getEnumValues());
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#getEnumValues()}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#getEnumValues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DataDrivenEnumerationImpl.getEnumValues()"})
  public void testGetEnumValues_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<DataDrivenEnumerationValue> enumValues = new ArrayList<>();
    enumValues.add(new DataDrivenEnumerationValueImpl());
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl = new DataDrivenEnumerationValueImpl();
    enumValues.add(dataDrivenEnumerationValueImpl);

    DataDrivenEnumerationImpl dataDrivenEnumerationImpl2 = new DataDrivenEnumerationImpl();
    dataDrivenEnumerationImpl2.setEnumValues(enumValues);

    // Act
    List<DataDrivenEnumerationValue> actualEnumValues = dataDrivenEnumerationImpl2.getEnumValues();

    // Assert
    assertEquals(2, actualEnumValues.size());
    assertSame(dataDrivenEnumerationValueImpl, actualEnumValues.get(1));
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse DataDrivenEnumerationImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    DataDrivenEnumerationImpl dataDrivenEnumerationImpl2 = new DataDrivenEnumerationImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DataDrivenEnumeration> actualCreateOrRetrieveCopyInstanceResult = dataDrivenEnumerationImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link DataDrivenEnumerationImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse DataDrivenEnumerationImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnDataDrivenEnumerationImpl()
      throws CloneNotSupportedException {
    // Arrange
    DataDrivenEnumerationImpl dataDrivenEnumerationImpl2 = new DataDrivenEnumerationImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<DataDrivenEnumeration> actualCreateOrRetrieveCopyInstanceResult = dataDrivenEnumerationImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    DataDrivenEnumeration clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof DataDrivenEnumerationImpl);
    assertNull(clone.getId());
    assertNull(clone.getKey());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(clone.getModifiable());
    assertFalse(((DataDrivenEnumerationImpl) clone).modifiable);
    assertTrue(clone.getEnumValues().isEmpty());
    assertTrue(clone.getOrderItems().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataDrivenEnumerationImpl.<init>()", "Long DataDrivenEnumerationImpl.getId()",
      "String DataDrivenEnumerationImpl.getKey()", "List DataDrivenEnumerationImpl.getOrderItems()",
      "void DataDrivenEnumerationImpl.setEnumValues(List)", "void DataDrivenEnumerationImpl.setId(Long)",
      "void DataDrivenEnumerationImpl.setKey(String)", "void DataDrivenEnumerationImpl.setModifiable(Boolean)",
      "void DataDrivenEnumerationImpl.setOrderItems(List)"})
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
    List<DataDrivenEnumerationValue> actualOrderItems = actualDataDrivenEnumerationImpl.getOrderItems();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualOrderItems.isEmpty());
    assertSame(orderItems, actualOrderItems);
  }
}
