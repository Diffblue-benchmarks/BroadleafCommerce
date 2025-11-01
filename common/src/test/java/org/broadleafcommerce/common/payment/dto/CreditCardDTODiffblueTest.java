/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CreditCardDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CreditCardDTODiffblueTest {
  @Autowired
  private CreditCardDTO<Object> creditCardDTO;

  /**
   * Method under test: {@link CreditCardDTO#done()}
   */
  @Test
  public void testDone() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();

    // Act and Assert
    assertNull(creditCardDTO.done());
  }

  /**
   * Method under test: {@link CreditCardDTO#additionalFields(String, Object)}
   */
  @Test
  public void testAdditionalFields() {
    // Arrange, Act and Assert
    assertSame(creditCardDTO, creditCardDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();

    // Act and Assert
    assertFalse(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated2() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated3() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardHolderName("Credit Card Holder Name");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated4() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardType("Credit Card Type");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated5() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardNum("Credit Card Num");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated6() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardLastFour("Credit Card Last Four");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated7() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardExpDate("2020-03-01");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated8() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardExpMonth("Credit Card Exp Month");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated9() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardExpYear("Credit Card Exp Year");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  public void testCreditCardPopulated10() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardCvv("Credit Card Cvv");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardDTO#CreditCardDTO()}
   *   <li>{@link CreditCardDTO#creditCardCvv(String)}
   *   <li>{@link CreditCardDTO#creditCardExpDate(String)}
   *   <li>{@link CreditCardDTO#creditCardExpMonth(String)}
   *   <li>{@link CreditCardDTO#creditCardExpYear(String)}
   *   <li>{@link CreditCardDTO#creditCardHolderName(String)}
   *   <li>{@link CreditCardDTO#creditCardLastFour(String)}
   *   <li>{@link CreditCardDTO#creditCardNum(String)}
   *   <li>{@link CreditCardDTO#creditCardType(String)}
   *   <li>{@link CreditCardDTO#getAdditionalFields()}
   *   <li>{@link CreditCardDTO#getCreditCardCvv()}
   *   <li>{@link CreditCardDTO#getCreditCardExpDate()}
   *   <li>{@link CreditCardDTO#getCreditCardExpMonth()}
   *   <li>{@link CreditCardDTO#getCreditCardExpYear()}
   *   <li>{@link CreditCardDTO#getCreditCardHolderName()}
   *   <li>{@link CreditCardDTO#getCreditCardLastFour()}
   *   <li>{@link CreditCardDTO#getCreditCardNum()}
   *   <li>{@link CreditCardDTO#getCreditCardType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CreditCardDTO<Object> actualCreditCardDTO = new CreditCardDTO<>();
    CreditCardDTO<Object> actualCreditCardCvvResult = actualCreditCardDTO.creditCardCvv("Credit Card Cvv");
    CreditCardDTO<Object> actualCreditCardExpDateResult = actualCreditCardDTO.creditCardExpDate("2020-03-01");
    CreditCardDTO<Object> actualCreditCardExpMonthResult = actualCreditCardDTO
        .creditCardExpMonth("Credit Card Exp Month");
    CreditCardDTO<Object> actualCreditCardExpYearResult = actualCreditCardDTO.creditCardExpYear("Credit Card Exp Year");
    CreditCardDTO<Object> actualCreditCardHolderNameResult = actualCreditCardDTO
        .creditCardHolderName("Credit Card Holder Name");
    CreditCardDTO<Object> actualCreditCardLastFourResult = actualCreditCardDTO
        .creditCardLastFour("Credit Card Last Four");
    CreditCardDTO<Object> actualCreditCardNumResult = actualCreditCardDTO.creditCardNum("Credit Card Num");
    CreditCardDTO<Object> actualCreditCardTypeResult = actualCreditCardDTO.creditCardType("Credit Card Type");
    Map<String, Object> actualAdditionalFields = actualCreditCardDTO.getAdditionalFields();
    String actualCreditCardCvv = actualCreditCardDTO.getCreditCardCvv();
    String actualCreditCardExpDate = actualCreditCardDTO.getCreditCardExpDate();
    String actualCreditCardExpMonth = actualCreditCardDTO.getCreditCardExpMonth();
    String actualCreditCardExpYear = actualCreditCardDTO.getCreditCardExpYear();
    String actualCreditCardHolderName = actualCreditCardDTO.getCreditCardHolderName();
    String actualCreditCardLastFour = actualCreditCardDTO.getCreditCardLastFour();
    String actualCreditCardNum = actualCreditCardDTO.getCreditCardNum();

    // Assert
    assertEquals("2020-03-01", actualCreditCardExpDate);
    assertEquals("Credit Card Cvv", actualCreditCardCvv);
    assertEquals("Credit Card Exp Month", actualCreditCardExpMonth);
    assertEquals("Credit Card Exp Year", actualCreditCardExpYear);
    assertEquals("Credit Card Holder Name", actualCreditCardHolderName);
    assertEquals("Credit Card Last Four", actualCreditCardLastFour);
    assertEquals("Credit Card Num", actualCreditCardNum);
    assertEquals("Credit Card Type", actualCreditCardDTO.getCreditCardType());
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualCreditCardDTO, actualCreditCardCvvResult);
    assertSame(actualCreditCardDTO, actualCreditCardExpDateResult);
    assertSame(actualCreditCardDTO, actualCreditCardExpMonthResult);
    assertSame(actualCreditCardDTO, actualCreditCardExpYearResult);
    assertSame(actualCreditCardDTO, actualCreditCardHolderNameResult);
    assertSame(actualCreditCardDTO, actualCreditCardLastFourResult);
    assertSame(actualCreditCardDTO, actualCreditCardNumResult);
    assertSame(actualCreditCardDTO, actualCreditCardTypeResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardDTO#CreditCardDTO(Object)}
   *   <li>{@link CreditCardDTO#creditCardCvv(String)}
   *   <li>{@link CreditCardDTO#creditCardExpDate(String)}
   *   <li>{@link CreditCardDTO#creditCardExpMonth(String)}
   *   <li>{@link CreditCardDTO#creditCardExpYear(String)}
   *   <li>{@link CreditCardDTO#creditCardHolderName(String)}
   *   <li>{@link CreditCardDTO#creditCardLastFour(String)}
   *   <li>{@link CreditCardDTO#creditCardNum(String)}
   *   <li>{@link CreditCardDTO#creditCardType(String)}
   *   <li>{@link CreditCardDTO#getAdditionalFields()}
   *   <li>{@link CreditCardDTO#getCreditCardCvv()}
   *   <li>{@link CreditCardDTO#getCreditCardExpDate()}
   *   <li>{@link CreditCardDTO#getCreditCardExpMonth()}
   *   <li>{@link CreditCardDTO#getCreditCardExpYear()}
   *   <li>{@link CreditCardDTO#getCreditCardHolderName()}
   *   <li>{@link CreditCardDTO#getCreditCardLastFour()}
   *   <li>{@link CreditCardDTO#getCreditCardNum()}
   *   <li>{@link CreditCardDTO#getCreditCardType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    CreditCardDTO<Object> actualCreditCardDTO = new CreditCardDTO<>(BLCFieldUtils.NULL_FIELD);
    CreditCardDTO<Object> actualCreditCardCvvResult = actualCreditCardDTO.creditCardCvv("Credit Card Cvv");
    CreditCardDTO<Object> actualCreditCardExpDateResult = actualCreditCardDTO.creditCardExpDate("2020-03-01");
    CreditCardDTO<Object> actualCreditCardExpMonthResult = actualCreditCardDTO
        .creditCardExpMonth("Credit Card Exp Month");
    CreditCardDTO<Object> actualCreditCardExpYearResult = actualCreditCardDTO.creditCardExpYear("Credit Card Exp Year");
    CreditCardDTO<Object> actualCreditCardHolderNameResult = actualCreditCardDTO
        .creditCardHolderName("Credit Card Holder Name");
    CreditCardDTO<Object> actualCreditCardLastFourResult = actualCreditCardDTO
        .creditCardLastFour("Credit Card Last Four");
    CreditCardDTO<Object> actualCreditCardNumResult = actualCreditCardDTO.creditCardNum("Credit Card Num");
    CreditCardDTO<Object> actualCreditCardTypeResult = actualCreditCardDTO.creditCardType("Credit Card Type");
    Map<String, Object> actualAdditionalFields = actualCreditCardDTO.getAdditionalFields();
    String actualCreditCardCvv = actualCreditCardDTO.getCreditCardCvv();
    String actualCreditCardExpDate = actualCreditCardDTO.getCreditCardExpDate();
    String actualCreditCardExpMonth = actualCreditCardDTO.getCreditCardExpMonth();
    String actualCreditCardExpYear = actualCreditCardDTO.getCreditCardExpYear();
    String actualCreditCardHolderName = actualCreditCardDTO.getCreditCardHolderName();
    String actualCreditCardLastFour = actualCreditCardDTO.getCreditCardLastFour();
    String actualCreditCardNum = actualCreditCardDTO.getCreditCardNum();

    // Assert
    assertEquals("2020-03-01", actualCreditCardExpDate);
    assertEquals("Credit Card Cvv", actualCreditCardCvv);
    assertEquals("Credit Card Exp Month", actualCreditCardExpMonth);
    assertEquals("Credit Card Exp Year", actualCreditCardExpYear);
    assertEquals("Credit Card Holder Name", actualCreditCardHolderName);
    assertEquals("Credit Card Last Four", actualCreditCardLastFour);
    assertEquals("Credit Card Num", actualCreditCardNum);
    assertEquals("Credit Card Type", actualCreditCardDTO.getCreditCardType());
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualCreditCardDTO, actualCreditCardCvvResult);
    assertSame(actualCreditCardDTO, actualCreditCardExpDateResult);
    assertSame(actualCreditCardDTO, actualCreditCardExpMonthResult);
    assertSame(actualCreditCardDTO, actualCreditCardExpYearResult);
    assertSame(actualCreditCardDTO, actualCreditCardHolderNameResult);
    assertSame(actualCreditCardDTO, actualCreditCardLastFourResult);
    assertSame(actualCreditCardDTO, actualCreditCardNumResult);
    assertSame(actualCreditCardDTO, actualCreditCardTypeResult);
  }
}
