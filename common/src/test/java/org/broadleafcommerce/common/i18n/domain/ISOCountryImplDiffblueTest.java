/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType;
import org.junit.Test;

public class ISOCountryImplDiffblueTest {
  /**
   * Test {@link ISOCountryImpl#getStatus()}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#getStatus()}
   */
  @Test
  public void testGetStatus_givenISOCountryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ISOCountryImpl()).getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor) Alpha2 is
   * {@code Alpha2}.</li>
   *   <li>Then {@link ISOCountryImpl} (default constructor)
   * {@link ISOCountryImpl#status} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  public void testSetStatus_givenISOCountryImplAlpha2IsAlpha2_thenISOCountryImplStatusIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act
    isoCountryImpl.setStatus(null);

    // Assert
    assertNull(isoCountryImpl.status);
    assertNull(isoCountryImpl.getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}.
   * <ul>
   *   <li>Then {@link ISOCountryImpl} (default constructor)
   * {@link ISOCountryImpl#status} is {@code EXCEPTIONALLY_RESERVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#setStatus(ISOCodeStatusType)}
   */
  @Test
  public void testSetStatus_thenISOCountryImplStatusIsExceptionallyReserved() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    ISOCodeStatusType status = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;

    // Act
    isoCountryImpl.setStatus(status);

    // Assert
    assertEquals("EXCEPTIONALLY_RESERVED", isoCountryImpl.status);
    ISOCodeStatusType expectedStatus = status.EXCEPTIONALLY_RESERVED;
    assertSame(expectedStatus, isoCountryImpl.getStatus());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and
   * {@link ISOCountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl2);
    int expectedHashCodeResult = isoCountryImpl.hashCode();
    assertEquals(expectedHashCodeResult, isoCountryImpl2.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}, and
   * {@link ISOCountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ISOCountryImpl#equals(Object)}
   *   <li>{@link ISOCountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertEquals(isoCountryImpl, isoCountryImpl);
    int expectedHashCodeResult = isoCountryImpl.hashCode();
    assertEquals(expectedHashCodeResult, isoCountryImpl.hashCode());
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Name");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2(null);
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha2");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3(null);
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Alpha2");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName(null);
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(1);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(null);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.INDETERMINATELY_RESERVED);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(new ISOCodeStatusType());

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ISOCodeStatusType status = mock(ISOCodeStatusType.class);
    when(status.getType()).thenReturn("Type");

    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(status);

    ISOCountryImpl isoCountryImpl2 = new ISOCountryImpl();
    isoCountryImpl2.setAlpha2("Alpha2");
    isoCountryImpl2.setAlpha3("Alpha3");
    isoCountryImpl2.setName("Name");
    isoCountryImpl2.setNumericCode(10);
    isoCountryImpl2.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, isoCountryImpl2);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, null);
  }

  /**
   * Test {@link ISOCountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setAlpha2("Alpha2");
    isoCountryImpl.setAlpha3("Alpha3");
    isoCountryImpl.setName("Name");
    isoCountryImpl.setNumericCode(10);
    isoCountryImpl.setStatus(ISOCodeStatusType.EXCEPTIONALLY_RESERVED);

    // Act and Assert
    assertNotEquals(isoCountryImpl, "Different type to ISOCountryImpl");
  }

  /**
   * Test {@link ISOCountryImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link ISOCodeStatusType} {@link ISOCodeStatusType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link ISOCodeStatusType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenISOCodeStatusTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCodeStatusType status = mock(ISOCodeStatusType.class);
    when(status.getType()).thenReturn("Type");

    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    isoCountryImpl.setStatus(status);

    // Act
    String actualMainEntityName = isoCountryImpl.getMainEntityName();

    // Assert
    verify(status).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Test {@link ISOCountryImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ISOCountryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenISOCountryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ISOCountryImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ISOCountryImpl}
   *   <li>{@link ISOCountryImpl#setAlpha2(String)}
   *   <li>{@link ISOCountryImpl#setAlpha3(String)}
   *   <li>{@link ISOCountryImpl#setName(String)}
   *   <li>{@link ISOCountryImpl#setNumericCode(Integer)}
   *   <li>{@link ISOCountryImpl#getAlpha2()}
   *   <li>{@link ISOCountryImpl#getAlpha3()}
   *   <li>{@link ISOCountryImpl#getName()}
   *   <li>{@link ISOCountryImpl#getNumericCode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ISOCountryImpl actualIsoCountryImpl = new ISOCountryImpl();
    actualIsoCountryImpl.setAlpha2("Alpha2");
    actualIsoCountryImpl.setAlpha3("Alpha3");
    actualIsoCountryImpl.setName("Name");
    actualIsoCountryImpl.setNumericCode(10);
    String actualAlpha2 = actualIsoCountryImpl.getAlpha2();
    String actualAlpha3 = actualIsoCountryImpl.getAlpha3();
    String actualName = actualIsoCountryImpl.getName();

    // Assert that nothing has changed
    assertEquals("Alpha2", actualAlpha2);
    assertEquals("Alpha3", actualAlpha3);
    assertEquals("Name", actualName);
    assertEquals(10, actualIsoCountryImpl.getNumericCode().intValue());
  }
}
