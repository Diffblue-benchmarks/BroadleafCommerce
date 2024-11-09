/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class DataDrivenEnumerationValueImplDiffblueTest {
  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} (default constructor) Hidden
   * is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  public void testGetHidden_givenDataDrivenEnumerationValueImplHiddenIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl = new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl.setDisplay("Display");
    dataDrivenEnumerationValueImpl.setId(1L);
    dataDrivenEnumerationValueImpl.setKey("Key");
    dataDrivenEnumerationValueImpl.setType(new DataDrivenEnumerationImpl());
    dataDrivenEnumerationValueImpl.setHidden(true);

    // Act and Assert
    assertTrue(dataDrivenEnumerationValueImpl.getHidden());
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} (default constructor) Type
   * is {@link DataDrivenEnumerationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  public void testGetHidden_givenDataDrivenEnumerationValueImplTypeIsDataDrivenEnumerationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl = new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl.setDisplay("Display");
    dataDrivenEnumerationValueImpl.setId(1L);
    dataDrivenEnumerationValueImpl.setKey("Key");
    dataDrivenEnumerationValueImpl.setType(new DataDrivenEnumerationImpl());
    dataDrivenEnumerationValueImpl.setHidden(null);

    // Act and Assert
    assertFalse(dataDrivenEnumerationValueImpl.getHidden());
  }

  /**
   * Test {@link DataDrivenEnumerationValueImpl#getHidden()}.
   * <ul>
   *   <li>Given {@link DataDrivenEnumerationValueImpl} (default constructor) Type
   * is {@link DataDrivenEnumerationImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDrivenEnumerationValueImpl#getHidden()}
   */
  @Test
  public void testGetHidden_givenDataDrivenEnumerationValueImplTypeIsDataDrivenEnumerationImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl = new DataDrivenEnumerationValueImpl();
    dataDrivenEnumerationValueImpl.setDisplay("Display");
    dataDrivenEnumerationValueImpl.setId(1L);
    dataDrivenEnumerationValueImpl.setKey("Key");
    dataDrivenEnumerationValueImpl.setType(mock(DataDrivenEnumerationImpl.class));
    dataDrivenEnumerationValueImpl.setHidden(null);

    // Act and Assert
    assertFalse(dataDrivenEnumerationValueImpl.getHidden());
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
  public void testGetHidden_givenDataDrivenEnumerationValueImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DataDrivenEnumerationValueImpl()).getHidden());
  }

  /**
   * Test
   * {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl = new DataDrivenEnumerationValueImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DataDrivenEnumerationValue> actualCreateOrRetrieveCopyInstanceResult = dataDrivenEnumerationValueImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link DataDrivenEnumerationValueImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDrivenEnumerationValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnDataDrivenEnumerationValueImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl = new DataDrivenEnumerationValueImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<DataDrivenEnumerationValue> actualCreateOrRetrieveCopyInstanceResult = dataDrivenEnumerationValueImpl
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
   *   <li>default or parameterless constructor of
   * {@link DataDrivenEnumerationValueImpl}
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

    // Assert that nothing has changed
    assertEquals("Display", actualDisplay);
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(type, actualType);
  }
}
