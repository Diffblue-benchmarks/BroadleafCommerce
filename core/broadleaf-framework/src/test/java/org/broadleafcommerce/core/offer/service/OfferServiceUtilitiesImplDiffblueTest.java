package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferServiceUtilitiesImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferServiceUtilitiesImpl#setGenericEntityService(GenericEntityService)}
   *   <li>{@link OfferServiceUtilitiesImpl#setOfferDao(OfferDao)}
   *   <li>{@link OfferServiceUtilitiesImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceUtilitiesImpl#getGenericEntityService()}
   *   <li>{@link OfferServiceUtilitiesImpl#getOfferDao()}
   *   <li>{@link OfferServiceUtilitiesImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericEntityService OfferServiceUtilitiesImpl.getGenericEntityService()",
    "OfferDao OfferServiceUtilitiesImpl.getOfferDao()",
    "PromotableItemFactory OfferServiceUtilitiesImpl.getPromotableItemFactory()",
    "void OfferServiceUtilitiesImpl.setGenericEntityService(GenericEntityService)",
    "void OfferServiceUtilitiesImpl.setOfferDao(OfferDao)",
    "void OfferServiceUtilitiesImpl.setPromotableItemFactory(PromotableItemFactory)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl =
        new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl());
    GenericEntityServiceImpl entityService = new GenericEntityServiceImpl();

    // Act
    offerServiceUtilitiesImpl.setGenericEntityService(entityService);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceUtilitiesImpl.setOfferDao(offerDao);
    PromotableItemFactoryImpl promotableItemFactory =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceUtilitiesImpl.setPromotableItemFactory(promotableItemFactory);
    GenericEntityService actualGenericEntityService =
        offerServiceUtilitiesImpl.getGenericEntityService();
    OfferDao actualOfferDao = offerServiceUtilitiesImpl.getOfferDao();
    PromotableItemFactory actualPromotableItemFactory =
        offerServiceUtilitiesImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualGenericEntityService instanceof GenericEntityServiceImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(entityService, actualGenericEntityService);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
