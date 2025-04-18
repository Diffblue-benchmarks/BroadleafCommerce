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
package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.offer.domain.OfferAudit;
import org.broadleafcommerce.core.offer.domain.OfferAuditImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferAuditDaoImplDiffblueTest {
  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private OfferAuditDaoImpl offerAuditDaoImpl;

  /**
   * Test {@link OfferAuditDaoImpl#create()}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferAudit OfferAuditDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    offerAuditImpl.setAccountId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(offerAuditImpl);

    // Act
    OfferAudit actualCreateResult = offerAuditDaoImpl.create();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.offer.domain.OfferAudit"));
    assertSame(offerAuditImpl, actualCreateResult);
  }

  /**
   * Test {@link OfferAuditDaoImpl#getOrderId(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#getOrderId(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OfferAuditDaoImpl.getOrderId(Order)"})
  public void testGetOrderId_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerAuditDaoImpl.getOrderId(new NullOrderImpl()));
  }

  /**
   * Test {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)} with {@code order}, {@code offerCodeId}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OfferAuditDaoImpl.countOfferCodeUses(Order, Long)"})
  public void testCountOfferCodeUsesWithOrderOfferCodeId() {
    // Arrange, Act and Assert
    assertNull(offerAuditDaoImpl.countOfferCodeUses(new NullOrderImpl(), 1L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAuditDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link OfferAuditDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OfferAuditDaoImpl.getCurrentDateResolution()",
      "void OfferAuditDaoImpl.setCurrentDateResolution(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, offerAuditDaoImpl.getCurrentDateResolution().longValue());
  }
}
