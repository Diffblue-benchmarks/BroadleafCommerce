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
import static org.junit.Assert.assertSame;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferRuleImplDiffblueTest {
  @Autowired private OfferRuleImpl offerRuleImpl;

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    assertEquals(offerRuleImpl.hashCode(), offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    assertNotEquals(offerRuleImpl.hashCode(), offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(null);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    assertNotEquals(offerRuleImpl.hashCode(), offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and {@link OfferRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl);
    int expectedHashCodeResult = offerRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerRuleImpl.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(2L);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, offerRuleImpl2);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule("42");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, offerRuleImpl2);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, null);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferRuleImpl.equals(Object)", "int OfferRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, "Different type to OfferRuleImpl");
  }

  /**
   * Test {@link OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferRuleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new OfferRuleImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferRule> actualCreateOrRetrieveCopyInstanceResult =
        offerRuleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferRuleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(offerRuleImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferRule> actualCreateOrRetrieveCopyInstanceResult =
        offerRuleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferRuleImpl}
   *   <li>{@link OfferRuleImpl#setId(Long)}
   *   <li>{@link OfferRuleImpl#setMatchRule(String)}
   *   <li>{@link OfferRuleImpl#getId()}
   *   <li>{@link OfferRuleImpl#getMatchRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferRuleImpl.<init>()",
    "Long OfferRuleImpl.getId()",
    "String OfferRuleImpl.getMatchRule()",
    "void OfferRuleImpl.setId(Long)",
    "void OfferRuleImpl.setMatchRule(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferRuleImpl actualOfferRuleImpl = new OfferRuleImpl();
    actualOfferRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualOfferRuleImpl.setMatchRule("Match Rule");
    Long actualId = actualOfferRuleImpl.getId();

    // Assert
    assertEquals("Match Rule", actualOfferRuleImpl.getMatchRule());
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
  }
}
