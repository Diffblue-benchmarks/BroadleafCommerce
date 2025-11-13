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

@ContextConfiguration(classes = {SubscriptionDTO.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionDTODiffblueTest {
  @Autowired private SubscriptionDTO<Object> subscriptionDTO;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SubscriptionDTO#SubscriptionDTO()}
   *   <li>{@link SubscriptionDTO#frequency(String)}
   *   <li>{@link SubscriptionDTO#numberOfInstallments(String)}
   *   <li>{@link SubscriptionDTO#recurringAmount(String)}
   *   <li>{@link SubscriptionDTO#startDate(String)}
   *   <li>{@link SubscriptionDTO#getAdditionalFields()}
   *   <li>{@link SubscriptionDTO#getFrequency()}
   *   <li>{@link SubscriptionDTO#getNumberOfInstallments()}
   *   <li>{@link SubscriptionDTO#getRecurringAmount()}
   *   <li>{@link SubscriptionDTO#getStartDate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SubscriptionDTO.<init>()",
    "void SubscriptionDTO.<init>(Object)",
    "SubscriptionDTO SubscriptionDTO.frequency(String)",
    "Map SubscriptionDTO.getAdditionalFields()",
    "String SubscriptionDTO.getFrequency()",
    "String SubscriptionDTO.getNumberOfInstallments()",
    "String SubscriptionDTO.getRecurringAmount()",
    "String SubscriptionDTO.getStartDate()",
    "SubscriptionDTO SubscriptionDTO.numberOfInstallments(String)",
    "SubscriptionDTO SubscriptionDTO.recurringAmount(String)",
    "SubscriptionDTO SubscriptionDTO.startDate(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SubscriptionDTO<Object> actualSubscriptionDTO = new SubscriptionDTO<>();
    SubscriptionDTO<Object> actualFrequencyResult = actualSubscriptionDTO.frequency("Frequency");
    SubscriptionDTO<Object> actualNumberOfInstallmentsResult =
        actualSubscriptionDTO.numberOfInstallments("42");
    SubscriptionDTO<Object> actualRecurringAmountResult =
        actualSubscriptionDTO.recurringAmount("10");
    SubscriptionDTO<Object> actualStartDateResult = actualSubscriptionDTO.startDate("2020-03-01");
    Map<String, Object> actualAdditionalFields = actualSubscriptionDTO.getAdditionalFields();
    String actualFrequency = actualSubscriptionDTO.getFrequency();
    String actualNumberOfInstallments = actualSubscriptionDTO.getNumberOfInstallments();
    String actualRecurringAmount = actualSubscriptionDTO.getRecurringAmount();

    // Assert
    assertEquals("10", actualRecurringAmount);
    assertEquals("2020-03-01", actualSubscriptionDTO.getStartDate());
    assertEquals("42", actualNumberOfInstallments);
    assertEquals("Frequency", actualFrequency);
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualSubscriptionDTO, actualFrequencyResult);
    assertSame(actualSubscriptionDTO, actualNumberOfInstallmentsResult);
    assertSame(actualSubscriptionDTO, actualRecurringAmountResult);
    assertSame(actualSubscriptionDTO, actualStartDateResult);
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
   *   <li>{@link SubscriptionDTO#SubscriptionDTO(Object)}
   *   <li>{@link SubscriptionDTO#frequency(String)}
   *   <li>{@link SubscriptionDTO#numberOfInstallments(String)}
   *   <li>{@link SubscriptionDTO#recurringAmount(String)}
   *   <li>{@link SubscriptionDTO#startDate(String)}
   *   <li>{@link SubscriptionDTO#getAdditionalFields()}
   *   <li>{@link SubscriptionDTO#getFrequency()}
   *   <li>{@link SubscriptionDTO#getNumberOfInstallments()}
   *   <li>{@link SubscriptionDTO#getRecurringAmount()}
   *   <li>{@link SubscriptionDTO#getStartDate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SubscriptionDTO.<init>()",
    "void SubscriptionDTO.<init>(Object)",
    "SubscriptionDTO SubscriptionDTO.frequency(String)",
    "Map SubscriptionDTO.getAdditionalFields()",
    "String SubscriptionDTO.getFrequency()",
    "String SubscriptionDTO.getNumberOfInstallments()",
    "String SubscriptionDTO.getRecurringAmount()",
    "String SubscriptionDTO.getStartDate()",
    "SubscriptionDTO SubscriptionDTO.numberOfInstallments(String)",
    "SubscriptionDTO SubscriptionDTO.recurringAmount(String)",
    "SubscriptionDTO SubscriptionDTO.startDate(String)"
  })
  public void testGettersAndSetters_whenNull_field() {
    // Arrange and Act
    SubscriptionDTO<Object> actualSubscriptionDTO = new SubscriptionDTO<>(BLCFieldUtils.NULL_FIELD);
    SubscriptionDTO<Object> actualFrequencyResult = actualSubscriptionDTO.frequency("Frequency");
    SubscriptionDTO<Object> actualNumberOfInstallmentsResult =
        actualSubscriptionDTO.numberOfInstallments("42");
    SubscriptionDTO<Object> actualRecurringAmountResult =
        actualSubscriptionDTO.recurringAmount("10");
    SubscriptionDTO<Object> actualStartDateResult = actualSubscriptionDTO.startDate("2020-03-01");
    Map<String, Object> actualAdditionalFields = actualSubscriptionDTO.getAdditionalFields();
    String actualFrequency = actualSubscriptionDTO.getFrequency();
    String actualNumberOfInstallments = actualSubscriptionDTO.getNumberOfInstallments();
    String actualRecurringAmount = actualSubscriptionDTO.getRecurringAmount();

    // Assert
    assertEquals("10", actualRecurringAmount);
    assertEquals("2020-03-01", actualSubscriptionDTO.getStartDate());
    assertEquals("42", actualNumberOfInstallments);
    assertEquals("Frequency", actualFrequency);
    assertTrue(actualAdditionalFields.isEmpty());
    assertSame(actualSubscriptionDTO, actualFrequencyResult);
    assertSame(actualSubscriptionDTO, actualNumberOfInstallmentsResult);
    assertSame(actualSubscriptionDTO, actualRecurringAmountResult);
    assertSame(actualSubscriptionDTO, actualStartDateResult);
  }

  /**
   * Test {@link SubscriptionDTO#done()}.
   *
   * <p>Method under test: {@link SubscriptionDTO#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SubscriptionDTO.done()"})
  public void testDone() {
    // Arrange
    SubscriptionDTO<Object> subscriptionDTO = new SubscriptionDTO<>();

    // Act and Assert
    assertNull(subscriptionDTO.done());
  }

  /**
   * Test {@link SubscriptionDTO#additionalFields(String, Object)}.
   *
   * <p>Method under test: {@link SubscriptionDTO#additionalFields(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SubscriptionDTO SubscriptionDTO.additionalFields(String, Object)"})
  public void testAdditionalFields() {
    // Arrange and Act
    SubscriptionDTO<Object> actualAdditionalFieldsResult =
        subscriptionDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD);

    // Assert
    assertSame(subscriptionDTO, actualAdditionalFieldsResult);
  }

  /**
   * Test {@link SubscriptionDTO#subscriptionPopulated()}.
   *
   * <ul>
   *   <li>Given {@link SubscriptionDTO#SubscriptionDTO()} additionalFields {@code Key} and {@link
   *       BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link SubscriptionDTO#subscriptionPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubscriptionDTO.subscriptionPopulated()"})
  public void testSubscriptionPopulated_givenSubscriptionDTOAdditionalFieldsKeyAndNull_field() {
    // Arrange
    SubscriptionDTO<Object> subscriptionDTO = new SubscriptionDTO<>();
    subscriptionDTO.additionalFields("Key", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertTrue(subscriptionDTO.subscriptionPopulated());
  }

  /**
   * Test {@link SubscriptionDTO#subscriptionPopulated()}.
   *
   * <ul>
   *   <li>Given {@link SubscriptionDTO#SubscriptionDTO()} frequency {@code Frequency}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SubscriptionDTO#subscriptionPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubscriptionDTO.subscriptionPopulated()"})
  public void testSubscriptionPopulated_givenSubscriptionDTOFrequencyFrequency_thenReturnTrue() {
    // Arrange
    SubscriptionDTO<Object> subscriptionDTO = new SubscriptionDTO<>();
    subscriptionDTO.frequency("Frequency");

    // Act and Assert
    assertTrue(subscriptionDTO.subscriptionPopulated());
  }

  /**
   * Test {@link SubscriptionDTO#subscriptionPopulated()}.
   *
   * <ul>
   *   <li>Given {@link SubscriptionDTO#SubscriptionDTO()} numberOfInstallments {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SubscriptionDTO#subscriptionPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubscriptionDTO.subscriptionPopulated()"})
  public void testSubscriptionPopulated_givenSubscriptionDTONumberOfInstallments42() {
    // Arrange
    SubscriptionDTO<Object> subscriptionDTO = new SubscriptionDTO<>();
    subscriptionDTO.numberOfInstallments("42");

    // Act and Assert
    assertTrue(subscriptionDTO.subscriptionPopulated());
  }

  /**
   * Test {@link SubscriptionDTO#subscriptionPopulated()}.
   *
   * <ul>
   *   <li>Given {@link SubscriptionDTO#SubscriptionDTO()} recurringAmount {@code 10}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SubscriptionDTO#subscriptionPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubscriptionDTO.subscriptionPopulated()"})
  public void testSubscriptionPopulated_givenSubscriptionDTORecurringAmount10_thenReturnTrue() {
    // Arrange
    SubscriptionDTO<Object> subscriptionDTO = new SubscriptionDTO<>();
    subscriptionDTO.recurringAmount("10");

    // Act and Assert
    assertTrue(subscriptionDTO.subscriptionPopulated());
  }

  /**
   * Test {@link SubscriptionDTO#subscriptionPopulated()}.
   *
   * <ul>
   *   <li>Given {@link SubscriptionDTO#SubscriptionDTO()} startDate {@code 2020-03-01}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SubscriptionDTO#subscriptionPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubscriptionDTO.subscriptionPopulated()"})
  public void testSubscriptionPopulated_givenSubscriptionDTOStartDate20200301_thenReturnTrue() {
    // Arrange
    SubscriptionDTO<Object> subscriptionDTO = new SubscriptionDTO<>();
    subscriptionDTO.startDate("2020-03-01");

    // Act and Assert
    assertTrue(subscriptionDTO.subscriptionPopulated());
  }

  /**
   * Test {@link SubscriptionDTO#subscriptionPopulated()}.
   *
   * <ul>
   *   <li>Given {@link SubscriptionDTO#SubscriptionDTO()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SubscriptionDTO#subscriptionPopulated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubscriptionDTO.subscriptionPopulated()"})
  public void testSubscriptionPopulated_givenSubscriptionDTO_thenReturnFalse() {
    // Arrange
    SubscriptionDTO<Object> subscriptionDTO = new SubscriptionDTO<>();

    // Act and Assert
    assertFalse(subscriptionDTO.subscriptionPopulated());
  }
}
