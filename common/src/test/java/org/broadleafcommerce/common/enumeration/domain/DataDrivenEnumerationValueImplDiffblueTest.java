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
public class DataDrivenEnumerationValueImplDiffblueTest {
  @Autowired
  private DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl;

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} (default constructor) Hidden is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DataDrivenEnumerationValueImpl.getHidden()"})
  public void testGetHidden_givenDataDrivenEnumerationValueImplHiddenIsNull_thenReturnFalse() {
    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl2 = new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl2.setDisplay("Display");
    dataDrivenEnumerationValueImpl2.setId(1L);
    dataDrivenEnumerationValueImpl2.setKey("Key");
    dataDrivenEnumerationValueImpl2.setType(new DataDrivenEnumerationImpl());
    dataDrivenEnumerationValueImpl2.setHidden(null);

    // Act and Assert
    assertFalse(dataDrivenEnumerationValueImpl2.getHidden());
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} (default constructor) Hidden is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DataDrivenEnumerationValueImpl.getHidden()"})
  public void testGetHidden_givenDataDrivenEnumerationValueImplHiddenIsTrue_thenReturnTrue() {
    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl2 = new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl2.setDisplay("Display");
    dataDrivenEnumerationValueImpl2.setId(1L);
    dataDrivenEnumerationValueImpl2.setKey("Key");
    dataDrivenEnumerationValueImpl2.setType(new DataDrivenEnumerationImpl());
    dataDrivenEnumerationValueImpl2.setHidden(true);

    // Act and Assert
    assertTrue(dataDrivenEnumerationValueImpl2.getHidden());
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean DataDrivenEnumerationValueImpl.getHidden()"})
  public void testGetHidden_givenDataDrivenEnumerationValueImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DataDrivenEnumerationValueImpl()).getHidden());
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse DataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl2 = new DataDrivenEnumerationValueImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DataDrivenEnumerationValue> actualCreateOrRetrieveCopyInstanceResult = dataDrivenEnumerationValueImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link DataDrivenEnumerationValueImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse DataDrivenEnumerationValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnDataDrivenEnumerationValueImpl()
      throws CloneNotSupportedException {
    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl2 = new DataDrivenEnumerationValueImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<DataDrivenEnumerationValue> actualCreateOrRetrieveCopyInstanceResult = dataDrivenEnumerationValueImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    DataDrivenEnumerationValue clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof DataDrivenEnumerationValueImpl);
    assertNull(clone.getId());
    assertNull(clone.getDisplay());
    assertNull(clone.getKey());
    assertNull(clone.getType());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(clone.getHidden());
    assertFalse(((DataDrivenEnumerationValueImpl) clone).hidden);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataDrivenEnumerationValueImpl.<init>()",
      "String DataDrivenEnumerationValueImpl.getDisplay()", "Long DataDrivenEnumerationValueImpl.getId()",
      "String DataDrivenEnumerationValueImpl.getKey()",
      "DataDrivenEnumeration DataDrivenEnumerationValueImpl.getType()",
      "void DataDrivenEnumerationValueImpl.setDisplay(String)",
      "void DataDrivenEnumerationValueImpl.setHidden(Boolean)", "void DataDrivenEnumerationValueImpl.setId(Long)",
      "void DataDrivenEnumerationValueImpl.setKey(String)",
      "void DataDrivenEnumerationValueImpl.setType(DataDrivenEnumeration)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DataDrivenEnumerationValueImpl actualDataDrivenEnumerationValueImpl = new DataDrivenEnumerationValueImpl();
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
