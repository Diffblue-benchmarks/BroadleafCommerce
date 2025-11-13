package org.broadleafcommerce.core.store.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.store.dao.ZipCodeDao;
import org.broadleafcommerce.core.store.domain.ZipCode;
import org.broadleafcommerce.core.store.domain.ZipCodeImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ZipCodeServiceImplDiffblueTest {
  @Mock private ZipCodeDao zipCodeDao;

  @InjectMocks private ZipCodeServiceImpl zipCodeServiceImpl;

  /**
   * Test {@link ZipCodeServiceImpl#findZipCodeByZipCode(Integer)}.
   *
   * <p>Method under test: {@link ZipCodeServiceImpl#findZipCodeByZipCode(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ZipCode ZipCodeServiceImpl.findZipCodeByZipCode(Integer)"})
  public void testFindZipCodeByZipCode() {
    // Arrange
    ZipCodeImpl zipCodeImpl = new ZipCodeImpl();
    when(zipCodeDao.findZipCodeByZipCode(Mockito.<Integer>any())).thenReturn(zipCodeImpl);

    // Act
    ZipCode actualFindZipCodeByZipCodeResult = zipCodeServiceImpl.findZipCodeByZipCode(1);

    // Assert
    verify(zipCodeDao).findZipCodeByZipCode(1);
    assertSame(zipCodeImpl, actualFindZipCodeByZipCodeResult);
  }
}
