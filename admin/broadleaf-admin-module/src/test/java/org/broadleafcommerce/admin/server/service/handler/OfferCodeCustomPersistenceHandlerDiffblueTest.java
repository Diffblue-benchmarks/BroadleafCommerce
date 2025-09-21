/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.offer.dao.OfferCodeDao;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferCodeCustomPersistenceHandlerDiffblueTest {
  @InjectMocks private OfferCodeCustomPersistenceHandler offerCodeCustomPersistenceHandler;

  @Mock private OfferCodeDao offerCodeDao;

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean OfferCodeCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_thenThrowRuntimeException() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerCodeCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCodeCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean OfferCodeCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCodeCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean OfferCodeCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenThrowRuntimeException() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerCodeCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferCodeCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean OfferCodeCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCodeCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCodeCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[] {"Unable to execute persistence activity"});
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            offerCodeCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCodeCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[] {"Unable to execute persistence activity"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            offerCodeCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.offer.domain.OfferCode"), isNull());
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity, OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeDao} {@link OfferCodeDao#readOfferCodeByCode(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCodeCustomPersistenceHandler.validateOfferCode(Entity, OfferCode)"
  })
  public void testValidateOfferCode_givenOfferCodeDaoReadOfferCodeByCodeThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenThrow(new RuntimeException());
    Entity entity = new Entity();

    OfferCode offerCode = mock(OfferCode.class);
    when(offerCode.getOfferCode()).thenReturn("Offer Code");
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerCodeCustomPersistenceHandler.validateOfferCode(entity, offerCode));
    verify(offerCodeDao).readOfferCodeByCode("Offer Code");
    verify(offerCode).getOffer();
    verify(offerCode).getOfferCode();
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity, OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCodeCustomPersistenceHandler.validateOfferCode(Entity, OfferCode)"
  })
  public void testValidateOfferCode_givenRuntimeException() {
    // Arrange
    Entity entity = new Entity();

    OfferCode offerCode = mock(OfferCode.class);
    when(offerCode.getOfferCode()).thenThrow(new RuntimeException());
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerCodeCustomPersistenceHandler.validateOfferCode(entity, offerCode));
    verify(offerCode).getOffer();
    verify(offerCode).getOfferCode();
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity, OfferCode)}.
   *
   * <ul>
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCodeCustomPersistenceHandler.validateOfferCode(Entity, OfferCode)"
  })
  public void testValidateOfferCode_thenReturnEntity() {
    // Arrange
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(new OfferCodeImpl());
    Entity entity = new Entity();

    OfferCode offerCode = mock(OfferCode.class);
    when(offerCode.getOfferCode()).thenReturn("Offer Code");
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act
    Entity actualValidateOfferCodeResult =
        offerCodeCustomPersistenceHandler.validateOfferCode(entity, offerCode);

    // Assert
    verify(offerCodeDao).readOfferCodeByCode("Offer Code");
    verify(offerCode).getOffer();
    verify(offerCode).getOfferCode();
    assertSame(entity, actualValidateOfferCodeResult);
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity, OfferCode)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeCustomPersistenceHandler#validateOfferCode(Entity,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity OfferCodeCustomPersistenceHandler.validateOfferCode(Entity, OfferCode)"
  })
  public void testValidateOfferCode_thenReturnNull() {
    // Arrange
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(null);
    Entity entity = new Entity();

    OfferCode offerCode = mock(OfferCode.class);
    when(offerCode.getOfferCode()).thenReturn("Offer Code");
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act
    Entity actualValidateOfferCodeResult =
        offerCodeCustomPersistenceHandler.validateOfferCode(entity, offerCode);

    // Assert
    verify(offerCodeDao).readOfferCodeByCode("Offer Code");
    verify(offerCode).getOffer();
    verify(offerCode).getOfferCode();
    assertNull(actualValidateOfferCodeResult);
  }

  /**
   * Test {@link OfferCodeCustomPersistenceHandler#checkIfOfferHasAdditionStatusNew(Long)}.
   *
   * <p>Method under test: {@link
   * OfferCodeCustomPersistenceHandler#checkIfOfferHasAdditionStatusNew(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OfferCodeCustomPersistenceHandler.checkIfOfferHasAdditionStatusNew(Long)"
  })
  public void testCheckIfOfferHasAdditionStatusNew() {
    // Arrange and Act
    List<Offer> actualCheckIfOfferHasAdditionStatusNewResult =
        offerCodeCustomPersistenceHandler.checkIfOfferHasAdditionStatusNew(1L);

    // Assert
    assertTrue(actualCheckIfOfferHasAdditionStatusNewResult.isEmpty());
  }
}
