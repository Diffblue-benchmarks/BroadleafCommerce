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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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

@ContextConfiguration(classes = {OfferOfferRuleXrefImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferOfferRuleXrefImplDiffblueTest {
  @Autowired
  private OfferOfferRuleXrefImpl offerOfferRuleXrefImpl;

  /**
   * Method under test: {@link OfferOfferRuleXrefImpl#getMatchRule()}
   */
  @Test
  public void testGetMatchRule() {
    // Arrange, Act and Assert
    assertNull((new OfferOfferRuleXrefImpl()).getMatchRule());
  }

  /**
   * Method under test: {@link OfferOfferRuleXrefImpl#getMatchRule()}
   */
  @Test
  public void testGetMatchRule2() {
    // Arrange
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerOfferRuleXrefImpl.setKey("Key");
    offerOfferRuleXrefImpl.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl.setOfferRule(new OfferRuleImpl());

    // Act and Assert
    assertNull(offerOfferRuleXrefImpl.getMatchRule());
  }

  /**
   * Method under test: {@link OfferOfferRuleXrefImpl#setMatchRule(String)}
   */
  @Test
  public void testSetMatchRule() {
    // Arrange
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl();

    // Act
    offerOfferRuleXrefImpl2.setMatchRule("Match Rule");

    // Assert
    OfferRule offerRule = offerOfferRuleXrefImpl2.getOfferRule();
    assertTrue(offerRule instanceof OfferRuleImpl);
    assertEquals("Match Rule", offerOfferRuleXrefImpl2.getMatchRule());
    assertEquals("Match Rule", offerRule.getMatchRule());
  }

  /**
   * Method under test: {@link OfferOfferRuleXrefImpl#setMatchRule(String)}
   */
  @Test
  public void testSetMatchRule2() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    OfferRuleImpl offerRule = new OfferRuleImpl();
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl(offer, offerRule, "Key");

    // Act
    offerOfferRuleXrefImpl2.setMatchRule("Match Rule");

    // Assert
    OfferRule offerRule2 = offerOfferRuleXrefImpl2.getOfferRule();
    assertTrue(offerRule2 instanceof OfferRuleImpl);
    assertEquals("Match Rule", offerOfferRuleXrefImpl2.getMatchRule());
    assertEquals("Match Rule", offerRule2.getMatchRule());
    assertSame(offerRule, offerRule2);
  }

  /**
   * Method under test: {@link OfferOfferRuleXrefImpl#setMatchRule(String)}
   */
  @Test
  public void testSetMatchRule3() {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    OfferRuleImpl offerRule = new OfferRuleImpl();
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl(offer, offerRule, "Key");

    // Act
    offerOfferRuleXrefImpl2.setMatchRule("Match Rule");

    // Assert
    OfferRule offerRule2 = offerOfferRuleXrefImpl2.getOfferRule();
    assertTrue(offerRule2 instanceof OfferRuleImpl);
    assertEquals("Match Rule", offerOfferRuleXrefImpl2.getMatchRule());
    assertEquals("Match Rule", offerRule2.getMatchRule());
    assertSame(offerRule, offerRule2);
  }

  /**
   * Method under test:
   * {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferOfferRuleXref> actualCreateOrRetrieveCopyInstanceResult = offerOfferRuleXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Offer> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new OfferImpl());
    Offer offer = mock(Offer.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl(offer, null,
        "ThreadLocalManager.notify.orphans");

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerOfferRuleXrefImpl2.setKey("Key");
    offerOfferRuleXrefImpl2.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl2.setOfferRule(new OfferRuleImpl());
    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(offerOfferRuleXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Offer> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new OfferImpl());
    Offer offer = mock(Offer.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    OfferRuleImpl offerRule = mock(OfferRuleImpl.class);
    when(offerRule.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferRuleImpl(), true));
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl(offer, offerRule,
        "ThreadLocalManager.notify.orphans");

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerOfferRuleXrefImpl2.setKey("Key");
    offerOfferRuleXrefImpl2.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl2.setOfferRule(new OfferRuleImpl());
    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(offerOfferRuleXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offerRule).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Method under test:
   * {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Offer> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new OfferImpl());
    Offer offer = mock(Offer.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    OfferRuleImpl offerRule = mock(OfferRuleImpl.class);
    when(offerRule.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException("foo"));
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl(offer, offerRule,
        "ThreadLocalManager.notify.orphans");

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerOfferRuleXrefImpl2.setKey("Key");
    offerOfferRuleXrefImpl2.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl2.setOfferRule(new OfferRuleImpl());
    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(offerOfferRuleXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act and Assert
    assertThrows(CloneNotSupportedException.class, () -> offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offerRule).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Method under test:
   * {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance5() throws CloneNotSupportedException {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException("foo"));

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerOfferRuleXrefImpl.setKey("Key");
    offerOfferRuleXrefImpl.setOffer(offer);
    offerOfferRuleXrefImpl.setOfferRule(new OfferRuleImpl());

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerOfferRuleXrefImpl2.setKey("Key");
    offerOfferRuleXrefImpl2.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl2.setOfferRule(new OfferRuleImpl());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(offerOfferRuleXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(CloneNotSupportedException.class, () -> offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()}
   *   <li>{@link OfferOfferRuleXrefImpl#setId(Long)}
   *   <li>{@link OfferOfferRuleXrefImpl#setKey(String)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOfferRule(OfferRule)}
   *   <li>{@link OfferOfferRuleXrefImpl#getId()}
   *   <li>{@link OfferOfferRuleXrefImpl#getKey()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOffer()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOfferRule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferOfferRuleXrefImpl actualOfferOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    actualOfferOfferRuleXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualOfferOfferRuleXrefImpl.setKey("Key");
    OfferImpl offer = new OfferImpl();
    actualOfferOfferRuleXrefImpl.setOffer(offer);
    OfferRuleImpl offerRule = new OfferRuleImpl();
    actualOfferOfferRuleXrefImpl.setOfferRule(offerRule);
    Long actualId = actualOfferOfferRuleXrefImpl.getId();
    String actualKey = actualOfferOfferRuleXrefImpl.getKey();
    Offer actualOffer = actualOfferOfferRuleXrefImpl.getOffer();
    OfferRule actualOfferRule = actualOfferOfferRuleXrefImpl.getOfferRule();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(offerRule, actualOfferRule);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl(Offer, OfferRule, String)}
   *   <li>{@link OfferOfferRuleXrefImpl#setId(Long)}
   *   <li>{@link OfferOfferRuleXrefImpl#setKey(String)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferOfferRuleXrefImpl#setOfferRule(OfferRule)}
   *   <li>{@link OfferOfferRuleXrefImpl#getId()}
   *   <li>{@link OfferOfferRuleXrefImpl#getKey()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOffer()}
   *   <li>{@link OfferOfferRuleXrefImpl#getOfferRule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferOfferRuleXrefImpl actualOfferOfferRuleXrefImpl = new OfferOfferRuleXrefImpl(offer, new OfferRuleImpl(), "Key");
    actualOfferOfferRuleXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualOfferOfferRuleXrefImpl.setKey("Key");
    OfferImpl offer2 = new OfferImpl();
    actualOfferOfferRuleXrefImpl.setOffer(offer2);
    OfferRuleImpl offerRule = new OfferRuleImpl();
    actualOfferOfferRuleXrefImpl.setOfferRule(offerRule);
    Long actualId = actualOfferOfferRuleXrefImpl.getId();
    String actualKey = actualOfferOfferRuleXrefImpl.getKey();
    Offer actualOffer = actualOfferOfferRuleXrefImpl.getOffer();
    OfferRule actualOfferRule = actualOfferOfferRuleXrefImpl.getOfferRule();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerRule, actualOfferRule);
  }
}
