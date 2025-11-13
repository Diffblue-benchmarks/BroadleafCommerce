package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TaxDetailImplDiffblueTest {
  @Autowired private TaxDetailImpl taxDetailImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaxDetailImpl#TaxDetailImpl()}
   *   <li>{@link TaxDetailImpl#setCountry(String)}
   *   <li>{@link TaxDetailImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link TaxDetailImpl#setId(Long)}
   *   <li>{@link TaxDetailImpl#setJurisdictionName(String)}
   *   <li>{@link TaxDetailImpl#setModuleConfiguration(ModuleConfiguration)}
   *   <li>{@link TaxDetailImpl#setRate(BigDecimal)}
   *   <li>{@link TaxDetailImpl#setRegion(String)}
   *   <li>{@link TaxDetailImpl#setTaxName(String)}
   *   <li>{@link TaxDetailImpl#getCountry()}
   *   <li>{@link TaxDetailImpl#getCurrency()}
   *   <li>{@link TaxDetailImpl#getId()}
   *   <li>{@link TaxDetailImpl#getJurisdictionName()}
   *   <li>{@link TaxDetailImpl#getModuleConfiguration()}
   *   <li>{@link TaxDetailImpl#getRate()}
   *   <li>{@link TaxDetailImpl#getRegion()}
   *   <li>{@link TaxDetailImpl#getTaxName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxDetailImpl.<init>()",
    "String TaxDetailImpl.getCountry()",
    "BroadleafCurrency TaxDetailImpl.getCurrency()",
    "Long TaxDetailImpl.getId()",
    "String TaxDetailImpl.getJurisdictionName()",
    "ModuleConfiguration TaxDetailImpl.getModuleConfiguration()",
    "BigDecimal TaxDetailImpl.getRate()",
    "String TaxDetailImpl.getRegion()",
    "String TaxDetailImpl.getTaxName()",
    "void TaxDetailImpl.setCountry(String)",
    "void TaxDetailImpl.setCurrency(BroadleafCurrency)",
    "void TaxDetailImpl.setId(Long)",
    "void TaxDetailImpl.setJurisdictionName(String)",
    "void TaxDetailImpl.setModuleConfiguration(ModuleConfiguration)",
    "void TaxDetailImpl.setRate(BigDecimal)",
    "void TaxDetailImpl.setRegion(String)",
    "void TaxDetailImpl.setTaxName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TaxDetailImpl actualTaxDetailImpl = new TaxDetailImpl();
    actualTaxDetailImpl.setCountry("GB");
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    actualTaxDetailImpl.setCurrency(currency);
    actualTaxDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualTaxDetailImpl.setJurisdictionName("Jurisdiction");
    SiteMapConfigurationImpl config = new SiteMapConfigurationImpl();
    actualTaxDetailImpl.setModuleConfiguration(config);
    BigDecimal rate = new BigDecimal("2.3");
    actualTaxDetailImpl.setRate(rate);
    actualTaxDetailImpl.setRegion("us-east-2");
    actualTaxDetailImpl.setTaxName("Tax Name");
    String actualCountry = actualTaxDetailImpl.getCountry();
    BroadleafCurrency actualCurrency = actualTaxDetailImpl.getCurrency();
    Long actualId = actualTaxDetailImpl.getId();
    String actualJurisdictionName = actualTaxDetailImpl.getJurisdictionName();
    ModuleConfiguration actualModuleConfiguration = actualTaxDetailImpl.getModuleConfiguration();
    BigDecimal actualRate = actualTaxDetailImpl.getRate();
    String actualRegion = actualTaxDetailImpl.getRegion();

    // Assert
    assertEquals("GB", actualCountry);
    assertEquals("Jurisdiction", actualJurisdictionName);
    assertEquals("Tax Name", actualTaxDetailImpl.getTaxName());
    assertEquals("us-east-2", actualRegion);
    assertEquals(new BigDecimal("2.3"), actualRate);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(rate, actualRate);
    assertSame(currency, actualCurrency);
    assertSame(config, actualModuleConfiguration);
  }

  /**
   * Test {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@link TaxDetailImpl#amount} is {@link BigDecimal#BigDecimal(String)} with
   *       {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.<init>(TaxType, Money, BigDecimal)"})
  public void testNewTaxDetailImpl_givenBigDecimalWith23_thenReturnAmountIsBigDecimalWith23() {
    // Arrange
    TaxType type = mock(TaxType.class);
    when(type.getType()).thenReturn("Type");

    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    TaxDetailImpl actualTaxDetailImpl = new TaxDetailImpl(type, amount, new BigDecimal("2.3"));

    // Assert
    verify(amount).getAmount();
    verify(type).getType();
    assertEquals(new BigDecimal("2.3"), actualTaxDetailImpl.amount);
    Money amount2 = actualTaxDetailImpl.getAmount();
    assertEquals(new BigDecimal("2.30"), amount2.getAmount());
    Money actualAbsResult = amount2.abs();
    assertEquals(amount2, actualAbsResult);
    assertEquals(Money.ZERO, amount2.zero());
  }

  /**
   * Test {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then return Amount abs abs Amount is {@link TaxDetailImpl#amount}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.<init>(TaxType, Money, BigDecimal)"})
  public void testNewTaxDetailImpl_givenType_thenReturnAmountAbsAbsAmountIsAmount() {
    // Arrange
    TaxType type = mock(TaxType.class);
    when(type.getType()).thenReturn("Type");
    Money amount = new Money();

    // Act
    TaxDetailImpl actualTaxDetailImpl = new TaxDetailImpl(type, amount, new BigDecimal("2.3"));

    // Assert
    verify(type).getType();
    BigDecimal bigDecimal = actualTaxDetailImpl.amount;
    Money amount2 = actualTaxDetailImpl.getAmount();
    Money absResult = amount2.abs();
    assertSame(bigDecimal, absResult.abs().getAmount());
    Money zeroResult = amount2.zero();
    assertSame(bigDecimal, zeroResult.abs().getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult.zero().getAmount());
    assertSame(bigDecimal, zeroResult.zero().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, amount2.getAmount());
  }

  /**
   * Test {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link TaxType#CITY}.
   *   <li>Then return {@link TaxDetailImpl#type} is {@code CITY}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.<init>(TaxType, Money, BigDecimal)"})
  public void testNewTaxDetailImpl_whenCity_thenReturnTypeIsCity() {
    // Arrange
    Money amount = new Money();

    // Act
    TaxDetailImpl actualTaxDetailImpl =
        new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3"));

    // Assert
    assertEquals("CITY", actualTaxDetailImpl.type);
    BigDecimal bigDecimal = actualTaxDetailImpl.amount;
    Money amount2 = actualTaxDetailImpl.getAmount();
    assertSame(bigDecimal, amount2.abs().getAmount());
    assertSame(bigDecimal, amount2.zero().getAmount());
    assertSame(bigDecimal, amount2.getAmount());
    assertSame(TaxType.CITY, actualTaxDetailImpl.getType());
  }
}
