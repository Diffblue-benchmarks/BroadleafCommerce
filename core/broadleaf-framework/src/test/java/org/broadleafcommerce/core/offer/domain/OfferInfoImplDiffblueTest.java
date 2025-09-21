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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
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

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferInfoImplDiffblueTest {
  @Autowired private OfferInfoImpl offerInfoImpl;

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    assertEquals(offerInfoImpl.hashCode(), offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(null);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    assertEquals(offerInfoImpl.hashCode(), offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(null);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    assertEquals(offerInfoImpl.hashCode(), offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and {@link OfferInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl);
    int expectedHashCodeResult = offerInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerInfoImpl.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(2L);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, offerInfoImpl2);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> fieldValues = new HashMap<>();
    fieldValues.put("foo", "foo");

    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(fieldValues);
    offerInfoImpl.setId(null);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, offerInfoImpl2);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, null);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferInfoImpl.equals(Object)", "int OfferInfoImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, "Different type to OfferInfoImpl");
  }

  /**
   * Test {@link OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferInfoImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new OfferInfoImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferInfo> actualCreateOrRetrieveCopyInstanceResult =
        offerInfoImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferInfoImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(offerInfoImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferInfo> actualCreateOrRetrieveCopyInstanceResult =
        offerInfoImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then Clone return {@link OfferInfoImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferInfoImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOfferInfoImpl()
      throws CloneNotSupportedException {
    // Arrange
    HashMap<String, String> fieldValues = new HashMap<>();
    fieldValues.put("foo", "foo");

    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(fieldValues);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    HashMap<String, String> fieldValues2 = new HashMap<>();
    offerInfoImpl2.setFieldValues(fieldValues2);
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(offerInfoImpl2, false));

    // Act
    CreateResponse<OfferInfo> actualCreateOrRetrieveCopyInstanceResult =
        offerInfoImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    OfferInfo clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OfferInfoImpl);
    Map<String, String> fieldValues3 = clone.getFieldValues();
    assertEquals(1, fieldValues3.size());
    assertEquals("foo", fieldValues3.get("foo"));
    assertSame(fieldValues2, fieldValues3);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferInfoImpl}
   *   <li>{@link OfferInfoImpl#setFieldValues(Map)}
   *   <li>{@link OfferInfoImpl#setId(Long)}
   *   <li>{@link OfferInfoImpl#getFieldValues()}
   *   <li>{@link OfferInfoImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OfferInfoImpl.<init>()",
    "Map OfferInfoImpl.getFieldValues()",
    "Long OfferInfoImpl.getId()",
    "void OfferInfoImpl.setFieldValues(Map)",
    "void OfferInfoImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferInfoImpl actualOfferInfoImpl = new OfferInfoImpl();
    HashMap<String, String> fieldValues = new HashMap<>();
    actualOfferInfoImpl.setFieldValues(fieldValues);
    actualOfferInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    Map<String, String> actualFieldValues = actualOfferInfoImpl.getFieldValues();
    Long actualId = actualOfferInfoImpl.getId();

    // Assert
    assertTrue(actualFieldValues.isEmpty());
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldValues, actualFieldValues);
  }
}
