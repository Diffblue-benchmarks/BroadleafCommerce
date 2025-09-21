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

@ContextConfiguration(classes = {OfferQualifyingCriteriaXrefImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferQualifyingCriteriaXrefImplDiffblueTest {
  @Autowired private OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getId()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferQualifyingCriteriaXrefImpl.<init>()",
    "void OfferQualifyingCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferQualifyingCriteriaXrefImpl.getId()",
    "Offer OfferQualifyingCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferQualifyingCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferQualifyingCriteriaXrefImpl.setId(Long)",
    "void OfferQualifyingCriteriaXrefImpl.setOffer(Offer)",
    "void OfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferQualifyingCriteriaXrefImpl actualOfferQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    actualOfferQualifyingCriteriaXrefImpl.setId(
        CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOffer(offer);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferQualifyingCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferQualifyingCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferQualifyingCriteriaXrefImpl.getOfferItemCriteria();

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
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl(Offer,
   *       OfferItemCriteria)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setId(Long)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOffer(Offer)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#setOfferItemCriteria(OfferItemCriteria)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getId()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOffer()}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#getOfferItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferQualifyingCriteriaXrefImpl.<init>()",
    "void OfferQualifyingCriteriaXrefImpl.<init>(Offer, OfferItemCriteria)",
    "Long OfferQualifyingCriteriaXrefImpl.getId()",
    "Offer OfferQualifyingCriteriaXrefImpl.getOffer()",
    "OfferItemCriteria OfferQualifyingCriteriaXrefImpl.getOfferItemCriteria()",
    "void OfferQualifyingCriteriaXrefImpl.setId(Long)",
    "void OfferQualifyingCriteriaXrefImpl.setOffer(Offer)",
    "void OfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(OfferItemCriteria)"
  })
  public void testGettersAndSetters_whenOfferImpl() {
    // Arrange
    OfferImpl offer = new OfferImpl();

    // Act
    OfferQualifyingCriteriaXrefImpl actualOfferQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl(offer, new OfferItemCriteriaImpl());
    actualOfferQualifyingCriteriaXrefImpl.setId(
        CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    OfferImpl offer2 = new OfferImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOffer(offer2);
    OfferItemCriteriaImpl offerItemCriteria = new OfferItemCriteriaImpl();
    actualOfferQualifyingCriteriaXrefImpl.setOfferItemCriteria(offerItemCriteria);
    Long actualId = actualOfferQualifyingCriteriaXrefImpl.getId();
    Offer actualOffer = actualOfferQualifyingCriteriaXrefImpl.getOffer();
    OfferItemCriteria actualOfferItemCriteria =
        actualOfferQualifyingCriteriaXrefImpl.getOfferItemCriteria();

    // Assert
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer2, actualOffer);
    assertSame(offerItemCriteria, actualOfferItemCriteria);
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OfferQualifyingCriteriaXrefImpl.getQuantity()"})
  public void testGetQuantity_givenOfferQualifyingCriteriaXrefImpl() {
    // Arrange, Act and Assert
    assertNull(new OfferQualifyingCriteriaXrefImpl().getQuantity());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()} Id is
   *       {@link CandidateFulfillmentGroupOfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OfferQualifyingCriteriaXrefImpl.getQuantity()"})
  public void testGetQuantity_givenOfferQualifyingCriteriaXrefImplIdIsSerialVersionUID() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNull(offerQualifyingCriteriaXrefImpl.getQuantity());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#setQuantity(Integer)}.
   *
   * <ul>
   *   <li>Given {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#setQuantity(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferQualifyingCriteriaXrefImpl.setQuantity(Integer)"})
  public void testSetQuantity_givenOfferQualifyingCriteriaXrefImpl() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();

    // Act
    offerQualifyingCriteriaXrefImpl.setQuantity(1);

    // Assert
    OfferItemCriteria offerItemCriteria = offerQualifyingCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals(1, offerItemCriteria.getQuantity().intValue());
    assertEquals(1, offerQualifyingCriteriaXrefImpl.getQuantity().intValue());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#setQuantity(Integer)}.
   *
   * <ul>
   *   <li>Given {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()} Id is
   *       {@link CandidateFulfillmentGroupOfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#setQuantity(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferQualifyingCriteriaXrefImpl.setQuantity(Integer)"})
  public void testSetQuantity_givenOfferQualifyingCriteriaXrefImplIdIsSerialVersionUID() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act
    offerQualifyingCriteriaXrefImpl.setQuantity(1);

    // Assert
    OfferItemCriteria offerItemCriteria = offerQualifyingCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals(1, offerItemCriteria.getQuantity().intValue());
    assertEquals(1, offerQualifyingCriteriaXrefImpl.getQuantity().intValue());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#getMatchRule()}.
   *
   * <ul>
   *   <li>Given {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#getMatchRule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferQualifyingCriteriaXrefImpl.getMatchRule()"})
  public void testGetMatchRule_givenOfferQualifyingCriteriaXrefImpl() {
    // Arrange, Act and Assert
    assertNull(new OfferQualifyingCriteriaXrefImpl().getMatchRule());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#getMatchRule()}.
   *
   * <ul>
   *   <li>Given {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()} Id is
   *       {@link CandidateFulfillmentGroupOfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#getMatchRule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferQualifyingCriteriaXrefImpl.getMatchRule()"})
  public void testGetMatchRule_givenOfferQualifyingCriteriaXrefImplIdIsSerialVersionUID() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNull(offerQualifyingCriteriaXrefImpl.getMatchRule());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#setMatchRule(String)}.
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#setMatchRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferQualifyingCriteriaXrefImpl.setMatchRule(String)"})
  public void testSetMatchRule() {
    // Arrange
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act
    offerQualifyingCriteriaXrefImpl.setMatchRule("Match Rule");

    // Assert
    OfferItemCriteria offerItemCriteria = offerQualifyingCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals("Match Rule", offerItemCriteria.getMatchRule());
    assertEquals("Match Rule", offerQualifyingCriteriaXrefImpl.getMatchRule());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#setMatchRule(String)}.
   *
   * <ul>
   *   <li>Given {@link OfferQualifyingCriteriaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#setMatchRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferQualifyingCriteriaXrefImpl.setMatchRule(String)"})
  public void testSetMatchRule_givenOfferQualifyingCriteriaXrefImpl() {
    // Arrange and Act
    offerQualifyingCriteriaXrefImpl.setMatchRule("Match Rule");

    // Assert
    OfferItemCriteria offerItemCriteria = offerQualifyingCriteriaXrefImpl.getOfferItemCriteria();
    assertTrue(offerItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals("Match Rule", offerItemCriteria.getMatchRule());
    assertEquals("Match Rule", offerQualifyingCriteriaXrefImpl.getMatchRule());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferQualifyingCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl2 =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerQualifyingCriteriaXrefImpl, offerQualifyingCriteriaXrefImpl2);
    assertEquals(
        offerQualifyingCriteriaXrefImpl.hashCode(), offerQualifyingCriteriaXrefImpl2.hashCode());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}, and {@link
   * OfferQualifyingCriteriaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   *   <li>{@link OfferQualifyingCriteriaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertEquals(offerQualifyingCriteriaXrefImpl, offerQualifyingCriteriaXrefImpl);
    int expectedHashCodeResult = offerQualifyingCriteriaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerQualifyingCriteriaXrefImpl.hashCode());
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(2L);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl2 =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerQualifyingCriteriaXrefImpl, offerQualifyingCriteriaXrefImpl2);
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(offerQualifyingCriteriaXrefImpl, null);
  }

  /**
   * Test {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferQualifyingCriteriaXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferQualifyingCriteriaXrefImpl.equals(Object)",
    "int OfferQualifyingCriteriaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl.setOfferItemCriteria(new OfferItemCriteriaImpl());

    // Act and Assert
    assertNotEquals(
        offerQualifyingCriteriaXrefImpl, "Different type to OfferQualifyingCriteriaXrefImpl");
  }

  /**
   * Test {@link
   * OfferQualifyingCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferQualifyingCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferQualifyingCriteriaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new OfferQualifyingCriteriaXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferQualifyingCriteriaXref> actualCreateOrRetrieveCopyInstanceResult =
        offerQualifyingCriteriaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * OfferQualifyingCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferQualifyingCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferQualifyingCriteriaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();

    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl2 =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(offerQualifyingCriteriaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferQualifyingCriteriaXref> actualCreateOrRetrieveCopyInstanceResult =
        offerQualifyingCriteriaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * OfferQualifyingCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferQualifyingCriteriaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferQualifyingCriteriaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsCreateOrRetrieveCopyInstance()
      throws CloneNotSupportedException {
    // Arrange
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new OfferImpl(), true));

    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl.setOffer(offer);

    OfferQualifyingCriteriaXrefImpl offerQualifyingCriteriaXrefImpl2 =
        new OfferQualifyingCriteriaXrefImpl();
    offerQualifyingCriteriaXrefImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerQualifyingCriteriaXrefImpl2.setOffer(new OfferImpl());
    offerQualifyingCriteriaXrefImpl2.setOfferItemCriteria(new OfferItemCriteriaImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(offerQualifyingCriteriaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferQualifyingCriteriaXref> actualCreateOrRetrieveCopyInstanceResult =
        offerQualifyingCriteriaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(offer).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }
}
