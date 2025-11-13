package org.broadleafcommerce.common.payment.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CreditCardDTO.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CreditCardDTODiffblueTest {
  @Autowired private CreditCardDTO<Object> creditCardDTO;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreditCardDTO.<init>()",
    "void CreditCardDTO.<init>(Object)",
    "CreditCardDTO CreditCardDTO.creditCardCvv(String)",
    "CreditCardDTO CreditCardDTO.creditCardExpDate(String)",
    "CreditCardDTO CreditCardDTO.creditCardExpMonth(String)",
    "CreditCardDTO CreditCardDTO.creditCardExpYear(String)",
    "CreditCardDTO CreditCardDTO.creditCardHolderName(String)",
    "CreditCardDTO CreditCardDTO.creditCardLastFour(String)",
    "CreditCardDTO CreditCardDTO.creditCardNum(String)",
    "CreditCardDTO CreditCardDTO.creditCardType(String)",
    "Map CreditCardDTO.getAdditionalFields()",
    "String CreditCardDTO.getCreditCardCvv()",
    "String CreditCardDTO.getCreditCardExpDate()",
    "String CreditCardDTO.getCreditCardExpMonth()",
    "String CreditCardDTO.getCreditCardExpYear()",
    "String CreditCardDTO.getCreditCardHolderName()",
    "String CreditCardDTO.getCreditCardLastFour()",
    "String CreditCardDTO.getCreditCardNum()",
    "String CreditCardDTO.getCreditCardType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CreditCardDTO<Object> actualCreditCardDTO = new CreditCardDTO<>();
    CreditCardDTO<Object> actualCreditCardCvvResult =
        actualCreditCardDTO.creditCardCvv("Credit Card Cvv");
    CreditCardDTO<Object> actualCreditCardExpDateResult =
        actualCreditCardDTO.creditCardExpDate("2020-03-01");
    CreditCardDTO<Object> actualCreditCardExpMonthResult =
        actualCreditCardDTO.creditCardExpMonth("Credit Card Exp Month");
    CreditCardDTO<Object> actualCreditCardExpYearResult =
        actualCreditCardDTO.creditCardExpYear("Credit Card Exp Year");
    CreditCardDTO<Object> actualCreditCardHolderNameResult =
        actualCreditCardDTO.creditCardHolderName("Credit Card Holder Name");
    CreditCardDTO<Object> actualCreditCardLastFourResult =
        actualCreditCardDTO.creditCardLastFour("Credit Card Last Four");
    CreditCardDTO<Object> actualCreditCardNumResult =
        actualCreditCardDTO.creditCardNum("Credit Card Num");
    CreditCardDTO<Object> actualCreditCardTypeResult =
        actualCreditCardDTO.creditCardType("Credit Card Type");
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreditCardDTO.<init>()",
    "void CreditCardDTO.<init>(Object)",
    "CreditCardDTO CreditCardDTO.creditCardCvv(String)",
    "CreditCardDTO CreditCardDTO.creditCardExpDate(String)",
    "CreditCardDTO CreditCardDTO.creditCardExpMonth(String)",
    "CreditCardDTO CreditCardDTO.creditCardExpYear(String)",
    "CreditCardDTO CreditCardDTO.creditCardHolderName(String)",
    "CreditCardDTO CreditCardDTO.creditCardLastFour(String)",
    "CreditCardDTO CreditCardDTO.creditCardNum(String)",
    "CreditCardDTO CreditCardDTO.creditCardType(String)",
    "Map CreditCardDTO.getAdditionalFields()",
    "String CreditCardDTO.getCreditCardCvv()",
    "String CreditCardDTO.getCreditCardExpDate()",
    "String CreditCardDTO.getCreditCardExpMonth()",
    "String CreditCardDTO.getCreditCardExpYear()",
    "String CreditCardDTO.getCreditCardHolderName()",
    "String CreditCardDTO.getCreditCardLastFour()",
    "String CreditCardDTO.getCreditCardNum()",
    "String CreditCardDTO.getCreditCardType()"
  })
  public void testGettersAndSetters_whenNull_field() {
    // Arrange and Act
    CreditCardDTO<Object> actualCreditCardDTO = new CreditCardDTO<>(BLCFieldUtils.NULL_FIELD);
    CreditCardDTO<Object> actualCreditCardCvvResult =
        actualCreditCardDTO.creditCardCvv("Credit Card Cvv");
    CreditCardDTO<Object> actualCreditCardExpDateResult =
        actualCreditCardDTO.creditCardExpDate("2020-03-01");
    CreditCardDTO<Object> actualCreditCardExpMonthResult =
        actualCreditCardDTO.creditCardExpMonth("Credit Card Exp Month");
    CreditCardDTO<Object> actualCreditCardExpYearResult =
        actualCreditCardDTO.creditCardExpYear("Credit Card Exp Year");
    CreditCardDTO<Object> actualCreditCardHolderNameResult =
        actualCreditCardDTO.creditCardHolderName("Credit Card Holder Name");
    CreditCardDTO<Object> actualCreditCardLastFourResult =
        actualCreditCardDTO.creditCardLastFour("Credit Card Last Four");
    CreditCardDTO<Object> actualCreditCardNumResult =
        actualCreditCardDTO.creditCardNum("Credit Card Num");
    CreditCardDTO<Object> actualCreditCardTypeResult =
        actualCreditCardDTO.creditCardType("Credit Card Type");
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
   * Test {@link CreditCardDTO#done()}.
   *
   * <p>Method under test: {@link CreditCardDTO#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CreditCardDTO.done()"})
  public void testDone() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();

    // Act and Assert
    assertNull(creditCardDTO.done());
  }

  /**
   * Test {@link CreditCardDTO#additionalFields(String, Object)}.
   *
   * <p>Method under test: {@link CreditCardDTO#additionalFields(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardDTO CreditCardDTO.additionalFields(String, Object)"})
  public void testAdditionalFields() {
    // Arrange and Act
    CreditCardDTO<Object> actualAdditionalFieldsResult =
        creditCardDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD);

    // Assert
    assertSame(creditCardDTO, actualAdditionalFieldsResult);
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardHolderName("Credit Card Holder Name");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} additionalFields {@code Key} and {@link
   *       BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOAdditionalFieldsKeyAndNull_field() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} creditCardCvv {@code Credit Card Cvv}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOCreditCardCvvCreditCardCvv() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardCvv("Credit Card Cvv");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} creditCardExpDate {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOCreditCardExpDate20200301() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardExpDate("2020-03-01");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} creditCardExpMonth {@code Credit Card Exp
   *       Month}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOCreditCardExpMonthCreditCardExpMonth() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardExpMonth("Credit Card Exp Month");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} creditCardExpYear {@code Credit Card Exp
   *       Year}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOCreditCardExpYearCreditCardExpYear() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardExpYear("Credit Card Exp Year");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} creditCardLastFour {@code Credit Card Last
   *       Four}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOCreditCardLastFourCreditCardLastFour() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardLastFour("Credit Card Last Four");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} creditCardNum {@code Credit Card Num}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOCreditCardNumCreditCardNum() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardNum("Credit Card Num");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()} creditCardType {@code Credit Card Type}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTOCreditCardTypeCreditCardType() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();
    creditCardDTO.creditCardType("Credit Card Type");

    // Act and Assert
    assertTrue(creditCardDTO.creditCardPopulated());
  }

  /**
   * Test {@link CreditCardDTO#creditCardPopulated()}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardDTO#creditCardPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardDTO.creditCardPopulated()"})
  public void testCreditCardPopulated_givenCreditCardDTO_thenReturnFalse() {
    // Arrange
    CreditCardDTO<Object> creditCardDTO = new CreditCardDTO<>();

    // Act and Assert
    assertFalse(creditCardDTO.creditCardPopulated());
  }
}
