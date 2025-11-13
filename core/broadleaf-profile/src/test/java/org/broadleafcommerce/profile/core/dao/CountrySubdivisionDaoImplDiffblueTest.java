package org.broadleafcommerce.profile.core.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionCategoryImpl;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CountrySubdivisionDaoImplDiffblueTest {
  @InjectMocks private CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link CountrySubdivisionDaoImpl#findSubdivisionByAbbreviation(String)}.
   *
   * <ul>
   *   <li>Given {@link CountrySubdivisionDaoImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CountrySubdivisionDaoImpl#findSubdivisionByAbbreviation(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CountrySubdivision CountrySubdivisionDaoImpl.findSubdivisionByAbbreviation(String)"
  })
  public void testFindSubdivisionByAbbreviation_givenCountrySubdivisionDaoImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CountrySubdivisionDaoImpl().findSubdivisionByAbbreviation(null));
  }

  /**
   * Test {@link CountrySubdivisionDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then return {@link CountrySubdivisionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CountrySubdivisionDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CountrySubdivision CountrySubdivisionDaoImpl.create()"})
  public void testCreate_thenReturnCountrySubdivisionImpl() {
    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    countrySubdivisionImpl.setAbbreviation("Abbreviation");
    countrySubdivisionImpl.setAlternateAbbreviation("Alternate Abbreviation");
    countrySubdivisionImpl.setCategory(new CountrySubdivisionCategoryImpl());
    countrySubdivisionImpl.setCountry(new CountryImpl());
    countrySubdivisionImpl.setName("Name");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(countrySubdivisionImpl);

    // Act
    CountrySubdivision actualCreateResult = countrySubdivisionDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.CountrySubdivision");
    assertSame(countrySubdivisionImpl, actualCreateResult);
  }

  /**
   * Test {@link CountrySubdivisionDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link CountrySubdivisionDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CountrySubdivision CountrySubdivisionDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> countrySubdivisionDaoImpl.create());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.CountrySubdivision");
  }
}
