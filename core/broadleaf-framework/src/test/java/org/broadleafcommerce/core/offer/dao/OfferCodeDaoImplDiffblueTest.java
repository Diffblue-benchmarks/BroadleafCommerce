package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferCodeDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @Mock private OfferCodeDaoExtensionManager offerCodeDaoExtensionManager;

  @InjectMocks private OfferCodeDaoImpl offerCodeDaoImpl;

  /**
   * Test {@link OfferCodeDaoImpl#create()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) EmailAddress is {@code 42 Main St}.
   *   <li>Then return {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferCodeDaoImpl.create()"})
  public void testCreate_givenOfferCodeImplEmailAddressIs42MainSt_thenReturnOfferCodeImpl() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(offerCodeImpl);

    // Act
    OfferCode actualCreateResult = offerCodeDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.OfferCode");
    assertSame(offerCodeImpl, actualCreateResult);
  }

  /**
   * Test {@link OfferCodeDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferCodeDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> offerCodeDaoImpl.create());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.OfferCode");
  }

  /**
   * Test {@link OfferCodeDaoImpl#readOfferCodeByCode(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeDaoImpl#readOfferCodeByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferCodeDaoImpl.readOfferCodeByCode(String)"})
  public void testReadOfferCodeByCode_thenThrowNoResultException() {
    // Arrange
    when(offerCodeDaoExtensionManager.getProxy()).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> offerCodeDaoImpl.readOfferCodeByCode("Code"));
    verify(offerCodeDaoExtensionManager).getProxy();
  }

  /**
   * Test {@link OfferCodeDaoImpl#readAllOfferCodesByCode(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeDaoImpl#readAllOfferCodesByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List OfferCodeDaoImpl.readAllOfferCodesByCode(String)"})
  public void testReadAllOfferCodesByCode_thenThrowNoResultException() {
    // Arrange
    when(offerCodeDaoExtensionManager.getProxy()).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> offerCodeDaoImpl.readAllOfferCodesByCode("Code"));
    verify(offerCodeDaoExtensionManager).getProxy();
  }

  /**
   * Test {@link OfferCodeDaoImpl#readOfferCodesQuery(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeDaoImpl#readOfferCodesQuery(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Query OfferCodeDaoImpl.readOfferCodesQuery(String)"})
  public void testReadOfferCodesQuery_thenReturnNull() {
    // Arrange
    DefaultOfferCodeDaoExtensionHandler defaultOfferCodeDaoExtensionHandler =
        mock(DefaultOfferCodeDaoExtensionHandler.class);
    when(defaultOfferCodeDaoExtensionHandler.createReadOfferCodeByCodeQuery(
            Mockito.<EntityManager>any(),
            Mockito.<ExtensionResultHolder<Query>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(offerCodeDaoExtensionManager.getProxy()).thenReturn(defaultOfferCodeDaoExtensionHandler);

    // Act
    Query actualReadOfferCodesQueryResult = offerCodeDaoImpl.readOfferCodesQuery("Code");

    // Assert
    verify(offerCodeDaoExtensionManager).getProxy();
    verify(defaultOfferCodeDaoExtensionHandler)
        .createReadOfferCodeByCodeQuery(
            isNull(), isA(ExtensionResultHolder.class), eq("Code"), eq(true), eq("query.Offer"));
    assertNull(actualReadOfferCodesQueryResult);
  }

  /**
   * Test {@link OfferCodeDaoImpl#readOfferCodesQuery(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeDaoImpl#readOfferCodesQuery(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Query OfferCodeDaoImpl.readOfferCodesQuery(String)"})
  public void testReadOfferCodesQuery_thenThrowNoResultException() {
    // Arrange
    when(offerCodeDaoExtensionManager.getProxy()).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> offerCodeDaoImpl.readOfferCodesQuery("Code"));
    verify(offerCodeDaoExtensionManager).getProxy();
  }
}
