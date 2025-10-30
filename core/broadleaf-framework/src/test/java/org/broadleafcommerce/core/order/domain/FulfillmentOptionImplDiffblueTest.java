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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.core.order.fulfillment.domain.BandedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentOptionImplDiffblueTest {
  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}, and {@link FulfillmentOptionImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentOptionImpl#equals(Object)}
   *   <li>{@link FulfillmentOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentOptionImpl.equals(Object)", "int FulfillmentOptionImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    FulfillmentOptionImpl fulfillmentOptionImpl2 = new FulfillmentOptionImpl();
    fulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl2.setLongDescription("Long Description");
    fulfillmentOptionImpl2.setName("Name");
    fulfillmentOptionImpl2.setTaxCode("Tax Code");
    fulfillmentOptionImpl2.setTaxable(true);
    fulfillmentOptionImpl2.setUseFlatRates(true);

    // Act and Assert
    assertEquals(fulfillmentOptionImpl, fulfillmentOptionImpl2);
    int expectedHashCodeResult = fulfillmentOptionImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentOptionImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}, and {@link FulfillmentOptionImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentOptionImpl#equals(Object)}
   *   <li>{@link FulfillmentOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentOptionImpl.equals(Object)", "int FulfillmentOptionImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertEquals(fulfillmentOptionImpl, fulfillmentOptionImpl);
    int expectedHashCodeResult = fulfillmentOptionImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentOptionImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentOptionImpl.equals(Object)", "int FulfillmentOptionImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    bandedPriceFulfillmentOptionImpl.setBands(new ArrayList<>());
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bandedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedPriceFulfillmentOptionImpl.setName("Name");
    bandedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bandedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedPriceFulfillmentOptionImpl.setName("Name");
    bandedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(bandedPriceFulfillmentOptionImpl, fulfillmentOptionImpl);
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentOptionImpl.equals(Object)", "int FulfillmentOptionImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fulfillmentOptionImpl, null);
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentOptionImpl.equals(Object)", "int FulfillmentOptionImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fulfillmentOptionImpl, "Different type to FulfillmentOptionImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentOptionImpl}
   *   <li>{@link FulfillmentOptionImpl#setId(Long)}
   *   <li>{@link FulfillmentOptionImpl#setLongDescription(String)}
   *   <li>{@link FulfillmentOptionImpl#setName(String)}
   *   <li>{@link FulfillmentOptionImpl#setTaxCode(String)}
   *   <li>{@link FulfillmentOptionImpl#setTaxable(Boolean)}
   *   <li>{@link FulfillmentOptionImpl#setUseFlatRates(Boolean)}
   *   <li>{@link FulfillmentOptionImpl#getId()}
   *   <li>{@link FulfillmentOptionImpl#getTaxCode()}
   *   <li>{@link FulfillmentOptionImpl#getTaxable()}
   *   <li>{@link FulfillmentOptionImpl#getUseFlatRates()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentOptionImpl.<init>()", "Long FulfillmentOptionImpl.getId()",
      "String FulfillmentOptionImpl.getTaxCode()", "Boolean FulfillmentOptionImpl.getTaxable()",
      "Boolean FulfillmentOptionImpl.getUseFlatRates()", "void FulfillmentOptionImpl.setId(Long)",
      "void FulfillmentOptionImpl.setLongDescription(String)", "void FulfillmentOptionImpl.setName(String)",
      "void FulfillmentOptionImpl.setTaxCode(String)", "void FulfillmentOptionImpl.setTaxable(Boolean)",
      "void FulfillmentOptionImpl.setUseFlatRates(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentOptionImpl actualFulfillmentOptionImpl = new FulfillmentOptionImpl();
    actualFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualFulfillmentOptionImpl.setLongDescription("Long Description");
    actualFulfillmentOptionImpl.setName("Name");
    actualFulfillmentOptionImpl.setTaxCode("Tax Code");
    actualFulfillmentOptionImpl.setTaxable(true);
    actualFulfillmentOptionImpl.setUseFlatRates(true);
    Long actualId = actualFulfillmentOptionImpl.getId();
    String actualTaxCode = actualFulfillmentOptionImpl.getTaxCode();
    Boolean actualTaxable = actualFulfillmentOptionImpl.getTaxable();

    // Assert
    assertEquals("Tax Code", actualTaxCode);
    assertTrue(actualTaxable);
    assertTrue(actualFulfillmentOptionImpl.getUseFlatRates());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
  }
}
