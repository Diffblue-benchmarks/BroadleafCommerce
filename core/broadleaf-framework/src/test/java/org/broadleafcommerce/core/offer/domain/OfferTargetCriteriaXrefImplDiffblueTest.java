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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferTargetCriteriaXrefImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferTargetCriteriaXrefImplDiffblueTest {
  @Autowired
  private OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl;

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#getQuantity()}
   */
  @Test
  public void testGetQuantity() {
    // Arrange, Act and Assert
    assertNull((new OfferTargetCriteriaXrefImpl()).getQuantity());
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#getQuantity()}
   */
  @Test
  public void testGetQuantity2() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNull(offerTargetCriteriaXrefImpl.getQuantity());
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#setQuantity(Integer)}
   */
  @Test
  public void testSetQuantity() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();

    // Act
    offerTargetCriteriaXrefImpl.setQuantity(1);

    // Assert
    OfferItemCriteria offerItemCriteria = offerTargetCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals(1, offerItemCriteria.getQuantity().intValue());
    assertEquals(1, offerTargetCriteriaXrefImpl.getQuantity().intValue());
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#setQuantity(Integer)}
   */
  @Test
  public void testSetQuantity2() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);

    // Act
    offerTargetCriteriaXrefImpl.setQuantity(1);

    // Assert
    OfferItemCriteria offerItemCriteria2 = offerTargetCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria2 instanceof OfferItemCriteriaImpl);
    assertEquals(1, offerItemCriteria2.getQuantity().intValue());
    assertEquals(1, offerTargetCriteriaXrefImpl.getQuantity().intValue());
    assertSame(offerItemCriteria, offerItemCriteria2);
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#getMatchRule()}
   */
  @Test
  public void testGetMatchRule() {
    // Arrange, Act and Assert
    assertNull((new OfferTargetCriteriaXrefImpl()).getMatchRule());
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#getMatchRule()}
   */
  @Test
  public void testGetMatchRule2() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNull(offerTargetCriteriaXrefImpl.getMatchRule());
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#setMatchRule(String)}
   */
  @Test
  public void testSetMatchRule() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();

    // Act
    offerTargetCriteriaXrefImpl2.setMatchRule("Match Rule");

    // Assert
    OfferItemCriteria offerItemCriteria = offerTargetCriteriaXrefImpl2.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals("Match Rule", offerItemCriteria.getMatchRule());
    assertEquals("Match Rule", offerTargetCriteriaXrefImpl2.getMatchRule());
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#setMatchRule(String)}
   */
  @Test
  public void testSetMatchRule2() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl(offer,
        offerItemCriteria);

    // Act
    offerTargetCriteriaXrefImpl2.setMatchRule("Match Rule");

    // Assert
    OfferItemCriteria offerItemCriteria2 = offerTargetCriteriaXrefImpl2.getOfferItemCriteria();
    assertTrue(offerItemCriteria2 instanceof OfferItemCriteriaImpl);
    assertEquals("Match Rule", offerItemCriteria2.getMatchRule());
    assertEquals("Match Rule", offerTargetCriteriaXrefImpl2.getMatchRule());
    assertSame(offerItemCriteria, offerItemCriteria2);
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#setMatchRule(String)}
   */
  @Test
  public void testSetMatchRule3() {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl(offer,
        offerItemCriteria);

    // Act
    offerTargetCriteriaXrefImpl2.setMatchRule("Match Rule");

    // Assert
    OfferItemCriteria offerItemCriteria2 = offerTargetCriteriaXrefImpl2.getOfferItemCriteria();
    assertTrue(offerItemCriteria2 instanceof OfferItemCriteriaImpl);
    assertEquals("Match Rule", offerItemCriteria2.getMatchRule());
    assertEquals("Match Rule", offerTargetCriteriaXrefImpl2.getMatchRule());
    assertSame(offerItemCriteria, offerItemCriteria2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerTargetCriteriaXrefImpl, offerTargetCriteriaXrefImpl2);
    int expectedHashCodeResult = offerTargetCriteriaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerTargetCriteriaXrefImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerTargetCriteriaXrefImpl, offerTargetCriteriaXrefImpl);
    int expectedHashCodeResult = offerTargetCriteriaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerTargetCriteriaXrefImpl.hashCode());
  }

  /**
   * Method under test:
   * {@link OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferTargetCriteriaXref> actualCreateOrRetrieveCopyInstanceResult = offerTargetCriteriaXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Offer> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new OfferImpl());
    Offer offer = mock(Offer.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl(offer, null);

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());
    CreateResponse<Object> createResponse2 = new CreateResponse<>(offerTargetCriteriaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    CreateResponse<OfferTargetCriteriaXref> actualCreateOrRetrieveCopyInstanceResult = offerTargetCriteriaXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse2, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Offer> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new OfferImpl());
    Offer offer = mock(Offer.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    OfferItemCriteriaImpl offerItemCriteria = mock(OfferItemCriteriaImpl.class);
    when(offerItemCriteria.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferItemCriteriaImpl(), true));
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl(offer, offerItemCriteria);

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());
    CreateResponse<Object> createResponse2 = new CreateResponse<>(offerTargetCriteriaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    CreateResponse<OfferTargetCriteriaXref> actualCreateOrRetrieveCopyInstanceResult = offerTargetCriteriaXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offerItemCriteria).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse2, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(2L);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerTargetCriteriaXrefImpl, offerTargetCriteriaXrefImpl2);
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(mock(OfferImpl.class));
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerTargetCriteriaXrefImpl, offerTargetCriteriaXrefImpl2);
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerTargetCriteriaXrefImpl, null);
  }

  /**
   * Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerTargetCriteriaXrefImpl, "Different type to OfferTargetCriteriaXrefImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOffer(Offer)}
   *   <li>
   * {@link OfferTargetCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getId()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferTargetCriteriaXrefImpl actualOfferTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    actualOfferTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    actualOfferTargetCriteriaXrefImpl.setOffer(offer);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferTargetCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferTargetCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferTargetCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria = actualOfferTargetCriteriaXrefImpl.getOfferItemCriteria();

    // Assert that nothing has changed
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl(Offer, OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOffer(Offer)}
   *   <li>
   * {@link OfferTargetCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getId()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferTargetCriteriaXrefImpl actualOfferTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl(offer,
        new OfferItemCriteriaImpl());
    actualOfferTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer2 = new OfferImpl();
    actualOfferTargetCriteriaXrefImpl.setOffer(offer2);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferTargetCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferTargetCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferTargetCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria = actualOfferTargetCriteriaXrefImpl.getOfferItemCriteria();

    // Assert that nothing has changed
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
  }
}
