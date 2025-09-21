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

@ContextConfiguration(classes = {OfferOfferRuleXrefImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferOfferRuleXrefImplDiffblueTest {
  @Autowired private OfferOfferRuleXrefImpl offerOfferRuleXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferOfferRuleXrefImpl.<init>()",
    "void OfferOfferRuleXrefImpl.<init>(Offer, OfferRule, String)",
    "Long OfferOfferRuleXrefImpl.getId()",
    "String OfferOfferRuleXrefImpl.getKey()",
    "Offer OfferOfferRuleXrefImpl.getOffer()",
    "OfferRule OfferOfferRuleXrefImpl.getOfferRule()",
    "void OfferOfferRuleXrefImpl.setId(Long)",
    "void OfferOfferRuleXrefImpl.setKey(String)",
    "void OfferOfferRuleXrefImpl.setOffer(Offer)",
    "void OfferOfferRuleXrefImpl.setOfferRule(OfferRule)"
  })
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

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(offerRule, actualOfferRule);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl(Offer, OfferRule, String)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferOfferRuleXrefImpl.<init>()",
    "void OfferOfferRuleXrefImpl.<init>(Offer, OfferRule, String)",
    "Long OfferOfferRuleXrefImpl.getId()",
    "String OfferOfferRuleXrefImpl.getKey()",
    "Offer OfferOfferRuleXrefImpl.getOffer()",
    "OfferRule OfferOfferRuleXrefImpl.getOfferRule()",
    "void OfferOfferRuleXrefImpl.setId(Long)",
    "void OfferOfferRuleXrefImpl.setKey(String)",
    "void OfferOfferRuleXrefImpl.setOffer(Offer)",
    "void OfferOfferRuleXrefImpl.setOfferRule(OfferRule)"
  })
  public void testGettersAndSetters_whenOfferImpl() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferOfferRuleXrefImpl actualOfferOfferRuleXrefImpl =
        new OfferOfferRuleXrefImpl(offer, new OfferRuleImpl(), "Key");
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

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerRule, actualOfferRule);
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#getMatchRule()}.
   *
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferOfferRuleXrefImpl#getMatchRule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferOfferRuleXrefImpl.getMatchRule()"})
  public void testGetMatchRule_givenOfferOfferRuleXrefImpl() {
    // Arrange, Act and Assert
    assertNull(new OfferOfferRuleXrefImpl().getMatchRule());
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#getMatchRule()}.
   *
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()} Id is {@link
   *       CandidateFulfillmentGroupOfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferOfferRuleXrefImpl#getMatchRule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferOfferRuleXrefImpl.getMatchRule()"})
  public void testGetMatchRule_givenOfferOfferRuleXrefImplIdIsSerialVersionUID() {
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
   * Test {@link OfferOfferRuleXrefImpl#setMatchRule(String)}.
   *
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OfferOfferRuleXrefImpl#setMatchRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferOfferRuleXrefImpl.setMatchRule(String)"})
  public void testSetMatchRule_givenOfferOfferRuleXrefImpl() {
    // Arrange and Act
    offerOfferRuleXrefImpl.setMatchRule("Match Rule");

    // Assert
    OfferRule offerRule = offerOfferRuleXrefImpl.getOfferRule();
    assertTrue(offerRule instanceof OfferRuleImpl);
    assertEquals("Match Rule", offerOfferRuleXrefImpl.getMatchRule());
    assertEquals("Match Rule", offerRule.getMatchRule());
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#setMatchRule(String)}.
   *
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl} OfferRule is {@link OfferRuleImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferOfferRuleXrefImpl#setMatchRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferOfferRuleXrefImpl.setMatchRule(String)"})
  public void testSetMatchRule_givenOfferOfferRuleXrefImplOfferRuleIsOfferRuleImpl() {
    // Arrange
    offerOfferRuleXrefImpl.setOfferRule(new OfferRuleImpl());

    // Act
    offerOfferRuleXrefImpl.setMatchRule("Match Rule");

    // Assert
    OfferRule offerRule = offerOfferRuleXrefImpl.getOfferRule();
    assertTrue(offerRule instanceof OfferRuleImpl);
    assertEquals("Match Rule", offerOfferRuleXrefImpl.getMatchRule());
    assertEquals("Match Rule", offerRule.getMatchRule());
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferOfferRuleXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new OfferOfferRuleXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferOfferRuleXref> actualCreateOrRetrieveCopyInstanceResult =
        offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferOfferRuleXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl2 = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerOfferRuleXrefImpl2.setKey("Key");
    offerOfferRuleXrefImpl2.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl2.setOfferRule(new OfferRuleImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(offerOfferRuleXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferOfferRuleXref> actualCreateOrRetrieveCopyInstanceResult =
        offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferOfferRuleXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setOffer(offer);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OfferOfferRuleXrefImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferOfferRuleXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferImpl(), true));

    OfferRuleImpl offerRule = mock(OfferRuleImpl.class);
    when(offerRule.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferRuleImpl(), true));

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setOfferRule(offerRule);
    offerOfferRuleXrefImpl.setOffer(offer);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OfferOfferRuleXrefImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(offerRule).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferOfferRuleXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance5() throws CloneNotSupportedException {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferImpl(), true));

    OfferRuleImpl offerRule = mock(OfferRuleImpl.class);
    when(offerRule.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setOfferRule(offerRule);
    offerOfferRuleXrefImpl.setOffer(offer);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OfferOfferRuleXrefImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(offerRule).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferOfferRuleXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferOfferRuleXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone()
      throws CloneNotSupportedException {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferImpl(), true));

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setOffer(offer);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new OfferOfferRuleXrefImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    offerOfferRuleXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }
}
