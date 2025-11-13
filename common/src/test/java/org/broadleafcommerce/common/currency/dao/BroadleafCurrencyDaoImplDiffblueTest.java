package org.broadleafcommerce.common.currency.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafCurrencyDaoImplDiffblueTest {
  @InjectMocks private BroadleafCurrencyDaoImpl broadleafCurrencyDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link BroadleafCurrencyDaoImpl#create()}.
   *
   * <p>Method under test: {@link BroadleafCurrencyDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafCurrency BroadleafCurrencyDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(entityConfiguration.createEntityInstance(
            Mockito.<String>any(), eq(BroadleafCurrency.class)))
        .thenReturn(broadleafCurrencyImpl);

    // Act
    BroadleafCurrency actualCreateResult = broadleafCurrencyDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.currency.domain.BroadleafCurrency"), isA(Class.class));
    assertSame(broadleafCurrencyImpl, actualCreateResult);
  }
}
