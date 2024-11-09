/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class OfferCodeCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.text}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenJavaText_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler = new OfferCodeCustomPersistenceHandler();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.text");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerCodeCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler = new OfferCodeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(offerCodeCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.text}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenJavaText_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler = new OfferCodeCustomPersistenceHandler();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.text");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerCodeCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler = new OfferCodeCustomPersistenceHandler();

    // Act and Assert
    assertFalse(offerCodeCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of
   * {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler = new OfferCodeCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> offerCodeCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler = new OfferCodeCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> offerCodeCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.offer.domain.OfferCode"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity, OfferCode)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity, OfferCode)}
   */
  @Test
  public void testValidateOfferCode_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler = new OfferCodeCustomPersistenceHandler();
    Entity entity = new Entity();
    OfferCode offerCode = mock(OfferCode.class);
    when(offerCode.getOfferCode()).thenThrow(new RuntimeException("foo"));
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerCodeCustomPersistenceHandler.validateOfferCode(entity, offerCode));
    verify(offerCode).getOffer();
    verify(offerCode).getOfferCode();
  }

  /**
   * Test
   * {@link OfferCodeCustomPersistenceHandler#checkIfOfferHasAdditionStatusNew(Long)}.
   * <p>
   * Method under test:
   * {@link OfferCodeCustomPersistenceHandler#checkIfOfferHasAdditionStatusNew(Long)}
   */
  @Test
  public void testCheckIfOfferHasAdditionStatusNew() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferCodeCustomPersistenceHandler()).checkIfOfferHasAdditionStatusNew(1L).isEmpty());
  }
}
