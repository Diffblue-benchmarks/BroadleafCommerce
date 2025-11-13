package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShippingOfferServiceImplDiffblueTest {
  @Mock private OfferService offerService;

  @InjectMocks private ShippingOfferServiceImpl shippingOfferServiceImpl;

  /**
   * Test {@link ShippingOfferServiceImpl#reviewOffers(Order)}.
   *
   * <p>Method under test: {@link ShippingOfferServiceImpl#reviewOffers(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShippingOfferServiceImpl.reviewOffers(Order)"})
  public void testReviewOffers() throws PricingException {
    // Arrange
    when(offerService.buildOfferListForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());
    when(offerService.applyAndSaveFulfillmentGroupOffersToOrder(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(new NullOrderImpl());

    // Act
    shippingOfferServiceImpl.reviewOffers(new NullOrderImpl());

    // Assert
    verify(offerService)
        .applyAndSaveFulfillmentGroupOffersToOrder(isA(List.class), isA(Order.class));
    verify(offerService).buildOfferListForOrder(isA(Order.class));
  }

  /**
   * Test {@link ShippingOfferServiceImpl#reviewOffers(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link ShippingOfferServiceImpl#reviewOffers(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShippingOfferServiceImpl.reviewOffers(Order)"})
  public void testReviewOffers_thenThrowPricingException() throws PricingException {
    // Arrange
    when(offerService.buildOfferListForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());
    when(offerService.applyAndSaveFulfillmentGroupOffersToOrder(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenThrow(new PricingException("An error occurred"));

    // Act and Assert
    assertThrows(
        PricingException.class, () -> shippingOfferServiceImpl.reviewOffers(new NullOrderImpl()));
    verify(offerService)
        .applyAndSaveFulfillmentGroupOffersToOrder(isA(List.class), isA(Order.class));
    verify(offerService).buildOfferListForOrder(isA(Order.class));
  }
}
