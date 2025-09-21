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

@ContextConfiguration(classes = {OfferTargetCriteriaXrefImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferTargetCriteriaXrefImplDiffblueTest {
  @Autowired private OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getId()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferTargetCriteriaXrefImpl.<init>()",
    "void OfferTargetCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferTargetCriteriaXrefImpl.getId()",
    "Offer OfferTargetCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferTargetCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferTargetCriteriaXrefImpl.setId(Long)",
    "void OfferTargetCriteriaXrefImpl.setOffer(Offer)",
    "void OfferTargetCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferTargetCriteriaXrefImpl actualOfferTargetCriteriaXrefImpl =
        new OfferTargetCriteriaXrefImpl();
    actualOfferTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    actualOfferTargetCriteriaXrefImpl.setOffer(offer);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferTargetCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferTargetCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferTargetCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferTargetCriteriaXrefImpl.getOfferItemCriteria();

    // Assert
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
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
   *   <li>{@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl(Offer, OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getId()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferTargetCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferTargetCriteriaXrefImpl.<init>()",
    "void OfferTargetCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferTargetCriteriaXrefImpl.getId()",
    "Offer OfferTargetCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferTargetCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferTargetCriteriaXrefImpl.setId(Long)",
    "void OfferTargetCriteriaXrefImpl.setOffer(Offer)",
    "void OfferTargetCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters_whenOfferImpl() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferTargetCriteriaXrefImpl actualOfferTargetCriteriaXrefImpl =
        new OfferTargetCriteriaXrefImpl(offer, new OfferItemCriteriaImpl());
    actualOfferTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer2 = new OfferImpl();
    actualOfferTargetCriteriaXrefImpl.setOffer(offer2);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferTargetCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferTargetCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferTargetCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferTargetCriteriaXrefImpl.getOfferItemCriteria();

    // Assert
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OfferTargetCriteriaXrefImpl.getQuantity()"})
  public void testGetQuantity_givenOfferTargetCriteriaXrefImpl() {
    // Arrange, Act and Assert
    assertNull(new OfferTargetCriteriaXrefImpl().getQuantity());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()} Id is {@link
   *       CandidateFulfillmentGroupOfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OfferTargetCriteriaXrefImpl.getQuantity()"})
  public void testGetQuantity_givenOfferTargetCriteriaXrefImplIdIsSerialVersionUID() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNull(offerTargetCriteriaXrefImpl.getQuantity());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#setQuantity(Integer)}.
   *
   * <ul>
   *   <li>Given {@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#setQuantity(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferTargetCriteriaXrefImpl.setQuantity(Integer)"})
  public void testSetQuantity_givenOfferTargetCriteriaXrefImpl() {
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
   * Test {@link OfferTargetCriteriaXrefImpl#setQuantity(Integer)}.
   *
   * <ul>
   *   <li>Given {@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()} Id is {@link
   *       CandidateFulfillmentGroupOfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#setQuantity(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferTargetCriteriaXrefImpl.setQuantity(Integer)"})
  public void testSetQuantity_givenOfferTargetCriteriaXrefImplIdIsSerialVersionUID() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act
    offerTargetCriteriaXrefImpl.setQuantity(1);

    // Assert
    OfferItemCriteria offerItemCriteria = offerTargetCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals(1, offerItemCriteria.getQuantity().intValue());
    assertEquals(1, offerTargetCriteriaXrefImpl.getQuantity().intValue());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#getMatchRule()}.
   *
   * <ul>
   *   <li>Given {@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#getMatchRule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferTargetCriteriaXrefImpl.getMatchRule()"})
  public void testGetMatchRule_givenOfferTargetCriteriaXrefImpl() {
    // Arrange, Act and Assert
    assertNull(new OfferTargetCriteriaXrefImpl().getMatchRule());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#getMatchRule()}.
   *
   * <ul>
   *   <li>Given {@link OfferTargetCriteriaXrefImpl#OfferTargetCriteriaXrefImpl()} Id is {@link
   *       CandidateFulfillmentGroupOfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#getMatchRule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferTargetCriteriaXrefImpl.getMatchRule()"})
  public void testGetMatchRule_givenOfferTargetCriteriaXrefImplIdIsSerialVersionUID() {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNull(offerTargetCriteriaXrefImpl.getMatchRule());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#setMatchRule(String)}.
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#setMatchRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferTargetCriteriaXrefImpl.setMatchRule(String)"})
  public void testSetMatchRule() {
    // Arrange
    offerTargetCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act
    offerTargetCriteriaXrefImpl.setMatchRule("Match Rule");

    // Assert
    OfferItemCriteria offerItemCriteria = offerTargetCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals("Match Rule", offerItemCriteria.getMatchRule());
    assertEquals("Match Rule", offerTargetCriteriaXrefImpl.getMatchRule());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#setMatchRule(String)}.
   *
   * <ul>
   *   <li>Given {@link OfferTargetCriteriaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#setMatchRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferTargetCriteriaXrefImpl.setMatchRule(String)"})
  public void testSetMatchRule_givenOfferTargetCriteriaXrefImpl() {
    // Arrange and Act
    offerTargetCriteriaXrefImpl.setMatchRule("Match Rule");

    // Assert
    OfferItemCriteria offerItemCriteria = offerTargetCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals("Match Rule", offerItemCriteria.getMatchRule());
    assertEquals("Match Rule", offerTargetCriteriaXrefImpl.getMatchRule());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferTargetCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
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
    assertEquals(offerTargetCriteriaXrefImpl.hashCode(), offerTargetCriteriaXrefImpl2.hashCode());
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferTargetCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferTargetCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferTargetCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
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
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
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
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
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
   * Test {@link OfferTargetCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferTargetCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferTargetCriteriaXrefImpl.equals(Object)",
    "int OfferTargetCriteriaXrefImpl.hashCode()"
  })
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
   * Test {@link OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferTargetCriteriaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new OfferTargetCriteriaXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferTargetCriteriaXref> actualCreateOrRetrieveCopyInstanceResult =
        offerTargetCriteriaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferTargetCriteriaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(offerTargetCriteriaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferTargetCriteriaXref> actualCreateOrRetrieveCopyInstanceResult =
        offerTargetCriteriaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferTargetCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferTargetCriteriaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsCreateOrRetrieveCopyInstance()
      throws CloneNotSupportedException {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferImpl(), true));

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl.setOffer(offer);

    OfferTargetCriteriaXrefImpl offerTargetCriteriaXrefImpl2 = new OfferTargetCriteriaXrefImpl();
    offerTargetCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerTargetCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerTargetCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(offerTargetCriteriaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferTargetCriteriaXref> actualCreateOrRetrieveCopyInstanceResult =
        offerTargetCriteriaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }
}
