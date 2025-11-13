package org.broadleafcommerce.common.currency.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDao;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafCurrencyServiceImplDiffblueTest {
  @Mock private BroadleafCurrencyDao broadleafCurrencyDao;

  @InjectMocks private BroadleafCurrencyServiceImpl broadleafCurrencyServiceImpl;

  /**
   * Test {@link BroadleafCurrencyServiceImpl#findDefaultBroadleafCurrency()}.
   *
   * <p>Method under test: {@link BroadleafCurrencyServiceImpl#findDefaultBroadleafCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafCurrency BroadleafCurrencyServiceImpl.findDefaultBroadleafCurrency()"
  })
  public void testFindDefaultBroadleafCurrency() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(broadleafCurrencyDao.findDefaultBroadleafCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    BroadleafCurrency actualFindDefaultBroadleafCurrencyResult =
        broadleafCurrencyServiceImpl.findDefaultBroadleafCurrency();

    // Assert
    verify(broadleafCurrencyDao).findDefaultBroadleafCurrency();
    assertSame(broadleafCurrencyImpl, actualFindDefaultBroadleafCurrencyResult);
  }

  /**
   * Test {@link BroadleafCurrencyServiceImpl#findCurrencyByCode(String)}.
   *
   * <p>Method under test: {@link BroadleafCurrencyServiceImpl#findCurrencyByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency BroadleafCurrencyServiceImpl.findCurrencyByCode(String)"})
  public void testFindCurrencyByCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(broadleafCurrencyDao.findCurrencyByCode(Mockito.<String>any()))
        .thenReturn(broadleafCurrencyImpl);

    // Act
    BroadleafCurrency actualFindCurrencyByCodeResult =
        broadleafCurrencyServiceImpl.findCurrencyByCode("GBP");

    // Assert
    verify(broadleafCurrencyDao).findCurrencyByCode("GBP");
    assertSame(broadleafCurrencyImpl, actualFindCurrencyByCodeResult);
  }

  /**
   * Test {@link BroadleafCurrencyServiceImpl#getAllCurrencies()}.
   *
   * <p>Method under test: {@link BroadleafCurrencyServiceImpl#getAllCurrencies()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BroadleafCurrencyServiceImpl.getAllCurrencies()"})
  public void testGetAllCurrencies() {
    // Arrange
    when(broadleafCurrencyDao.getAllCurrencies()).thenReturn(new ArrayList<>());

    // Act
    List<BroadleafCurrency> actualAllCurrencies = broadleafCurrencyServiceImpl.getAllCurrencies();

    // Assert
    verify(broadleafCurrencyDao).getAllCurrencies();
    assertTrue(actualAllCurrencies.isEmpty());
  }

  /**
   * Test {@link BroadleafCurrencyServiceImpl#save(BroadleafCurrency)}.
   *
   * <p>Method under test: {@link BroadleafCurrencyServiceImpl#save(BroadleafCurrency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency BroadleafCurrencyServiceImpl.save(BroadleafCurrency)"})
  public void testSave() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(broadleafCurrencyDao.save(Mockito.<BroadleafCurrency>any()))
        .thenReturn(broadleafCurrencyImpl);

    // Act
    BroadleafCurrency actualSaveResult =
        broadleafCurrencyServiceImpl.save(new BroadleafCurrencyImpl());

    // Assert
    verify(broadleafCurrencyDao).save(isA(BroadleafCurrency.class));
    assertSame(broadleafCurrencyImpl, actualSaveResult);
  }

  /**
   * Test {@link BroadleafCurrencyServiceImpl#create()}.
   *
   * <p>Method under test: {@link BroadleafCurrencyServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency BroadleafCurrencyServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(broadleafCurrencyDao.create()).thenReturn(broadleafCurrencyImpl);

    // Act
    BroadleafCurrency actualCreateResult = broadleafCurrencyServiceImpl.create();

    // Assert
    verify(broadleafCurrencyDao).create();
    assertSame(broadleafCurrencyImpl, actualCreateResult);
  }
}
