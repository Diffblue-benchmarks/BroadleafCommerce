/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.rating.dao;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.rating.domain.RatingDetail;
import org.broadleafcommerce.core.rating.domain.RatingDetailImpl;
import org.broadleafcommerce.core.rating.domain.RatingSummary;
import org.broadleafcommerce.core.rating.domain.RatingSummaryImpl;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RatingSummaryDaoImplDiffblueTest {
  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private RatingSummaryDaoImpl ratingSummaryDaoImpl;

  /**
   * Test {@link RatingSummaryDaoImpl#createSummary(String, RatingType)} with {@code String}, {@code RatingType}.
   * <ul>
   *   <li>Then return {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createSummary(String, RatingType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingSummary RatingSummaryDaoImpl.createSummary(String, RatingType)"})
  public void testCreateSummaryWithStringRatingType_thenReturnRatingSummaryImpl() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<RatingSummary>>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    RatingSummary actualCreateSummaryResult = ratingSummaryDaoImpl.createSummary("42", RatingType.PRODUCT);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.RatingSummary"),
        isA(Class.class));
    assertSame(ratingSummaryImpl, actualCreateSummaryResult);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createSummary()}.
   * <ul>
   *   <li>Then return {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createSummary()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingSummary RatingSummaryDaoImpl.createSummary()"})
  public void testCreateSummary_thenReturnRatingSummaryImpl() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<RatingSummary>>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    RatingSummary actualCreateSummaryResult = ratingSummaryDaoImpl.createSummary();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.RatingSummary"),
        isA(Class.class));
    assertSame(ratingSummaryImpl, actualCreateSummaryResult);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createSummary()}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createSummary()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingSummary RatingSummaryDaoImpl.createSummary()"})
  public void testCreateSummary_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<RatingSummary>>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> ratingSummaryDaoImpl.createSummary());
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.RatingSummary"),
        isA(Class.class));
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createDetail(RatingSummary, Double, Date, Customer)} with {@code RatingSummary}, {@code Double}, {@code Date}, {@code Customer}.
   * <ul>
   *   <li>Then return {@link RatingDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createDetail(RatingSummary, Double, Date, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingDetail RatingSummaryDaoImpl.createDetail(RatingSummary, Double, Date, Customer)"})
  public void testCreateDetailWithRatingSummaryDoubleDateCustomer_thenReturnRatingDetailImpl() {
    // Arrange
    RatingDetailImpl ratingDetailImpl = new RatingDetailImpl();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<RatingDetail>>any()))
        .thenReturn(ratingDetailImpl);
    RatingSummaryImpl ratingSummary = new RatingSummaryImpl();
    Date submittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    RatingDetail actualCreateDetailResult = ratingSummaryDaoImpl.createDetail(ratingSummary, 10.0d, submittedDate,
        new CustomerImpl());

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.RatingDetail"),
        isA(Class.class));
    assertSame(ratingDetailImpl, actualCreateDetailResult);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createDetail(RatingSummary, Double, Date, Customer)} with {@code RatingSummary}, {@code Double}, {@code Date}, {@code Customer}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createDetail(RatingSummary, Double, Date, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingDetail RatingSummaryDaoImpl.createDetail(RatingSummary, Double, Date, Customer)"})
  public void testCreateDetailWithRatingSummaryDoubleDateCustomer_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<RatingDetail>>any()))
        .thenThrow(new NoResultException("An error occurred"));
    RatingSummaryImpl ratingSummary = new RatingSummaryImpl();
    Date submittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(NoResultException.class,
        () -> ratingSummaryDaoImpl.createDetail(ratingSummary, 10.0d, submittedDate, new CustomerImpl()));
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.RatingDetail"),
        isA(Class.class));
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createDetail()}.
   * <ul>
   *   <li>Then return {@link RatingDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createDetail()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingDetail RatingSummaryDaoImpl.createDetail()"})
  public void testCreateDetail_thenReturnRatingDetailImpl() {
    // Arrange
    RatingDetailImpl ratingDetailImpl = new RatingDetailImpl();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<RatingDetail>>any()))
        .thenReturn(ratingDetailImpl);

    // Act
    RatingDetail actualCreateDetailResult = ratingSummaryDaoImpl.createDetail();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.RatingDetail"),
        isA(Class.class));
    assertSame(ratingDetailImpl, actualCreateDetailResult);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createDetail()}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createDetail()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingDetail RatingSummaryDaoImpl.createDetail()"})
  public void testCreateDetail_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<RatingDetail>>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> ratingSummaryDaoImpl.createDetail());
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.RatingDetail"),
        isA(Class.class));
  }
}
