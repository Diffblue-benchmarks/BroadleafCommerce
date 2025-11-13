package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilities;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.dao.OrderItemDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderOfferProcessorImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderOfferProcessorImpl#setOfferDao(OfferDao)}
   *   <li>{@link OrderOfferProcessorImpl#setOfferServiceUtilities(OfferServiceUtilities)}
   *   <li>{@link OrderOfferProcessorImpl#setOrderItemDao(OrderItemDao)}
   *   <li>{@link OrderOfferProcessorImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OrderOfferProcessorImpl#getOfferServiceUtilities()}
   *   <li>{@link OrderOfferProcessorImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OfferServiceUtilities OrderOfferProcessorImpl.getOfferServiceUtilities()",
    "PromotableItemFactory OrderOfferProcessorImpl.getPromotableItemFactory()",
    "void OrderOfferProcessorImpl.setOfferDao(OfferDao)",
    "void OrderOfferProcessorImpl.setOfferServiceUtilities(OfferServiceUtilities)",
    "void OrderOfferProcessorImpl.setOrderItemDao(OrderItemDao)",
    "void OrderOfferProcessorImpl.setPromotableItemFactory(PromotableItemFactory)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl =
        new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl.setOfferDao(new OfferDaoImpl());
    OfferServiceUtilitiesImpl offerServiceUtilities =
        new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(offerServiceUtilities);
    orderOfferProcessorImpl.setOrderItemDao(new OrderItemDaoImpl());
    PromotableItemFactoryImpl promotableItemFactory =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setPromotableItemFactory(promotableItemFactory);
    OfferServiceUtilities actualOfferServiceUtilities =
        orderOfferProcessorImpl.getOfferServiceUtilities();
    PromotableItemFactory actualPromotableItemFactory =
        orderOfferProcessorImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(offerServiceUtilities, actualOfferServiceUtilities);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
