package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.util.StreamCapableTransactionalOperation;
import org.broadleafcommerce.common.util.StreamingTransactionCapableUtil;
import org.broadleafcommerce.core.offer.dao.CustomerOfferDao;
import org.broadleafcommerce.core.offer.dao.CustomerOfferDaoImpl;
import org.broadleafcommerce.core.offer.dao.OfferCodeDao;
import org.broadleafcommerce.core.offer.dao.OfferCodeDaoImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.CustomerOffer;
import org.broadleafcommerce.core.offer.domain.CustomerOfferImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessor;
import org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl;
import org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessor;
import org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl;
import org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessor;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.OrderServiceImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class OfferServiceImplDiffblueTest {
  @Mock private CustomerOfferDao customerOfferDao;

  @Mock private EntityDuplicator entityDuplicator;

  @Mock private OfferAuditService offerAuditService;

  @Mock private OfferCodeDao offerCodeDao;

  @Mock private OfferDao offerDao;

  @Mock private OfferServiceExtensionManager offerServiceExtensionManager;

  @InjectMocks private OfferServiceImpl offerServiceImpl;

  @Mock private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link OfferServiceImpl#findAllOffers()}.
   *
   * <ul>
   *   <li>Given {@link OfferDaoImpl} {@link OfferDaoImpl#readAllOffers()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findAllOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.findAllOffers()"})
  public void testFindAllOffers_givenOfferDaoImplReadAllOffersReturnArrayList_thenReturnEmpty() {
    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    when(offerDao.readAllOffers()).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    List<Offer> actualFindAllOffersResult = offerServiceImpl.findAllOffers();

    // Assert
    verify(offerDao).readAllOffers();
    assertTrue(actualFindAllOffersResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findAllOffers()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findAllOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.findAllOffers()"})
  public void testFindAllOffers_thenThrowRuntimeException() {
    // Arrange
    when(offerDao.readAllOffers()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findAllOffers());
    verify(offerDao).readAllOffers();
  }

  /**
   * Test {@link OfferServiceImpl#save(Offer)}.
   *
   * <ul>
   *   <li>Given {@link OfferDaoImpl} {@link OfferDaoImpl#save(Offer)} return {@link OfferImpl}
   *       (default constructor).
   *   <li>Then return {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#save(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.save(Offer)"})
  public void testSave_givenOfferDaoImplSaveReturnOfferImpl_thenReturnOfferImpl() {
    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    OfferImpl offerImpl = new OfferImpl();
    when(offerDao.save(Mockito.<Offer>any())).thenReturn(offerImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    Offer actualSaveResult = offerServiceImpl.save(new OfferImpl());

    // Assert
    verify(offerDao).save(isA(Offer.class));
    assertSame(offerImpl, actualSaveResult);
  }

  /**
   * Test {@link OfferServiceImpl#save(Offer)}.
   *
   * <ul>
   *   <li>Given {@link OfferDao} {@link OfferDao#save(Offer)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#save(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.save(Offer)"})
  public void testSave_givenOfferDaoSaveThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    when(offerDao.save(Mockito.<Offer>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.save(new OfferImpl()));
    verify(offerDao).save(isA(Offer.class));
  }

  /**
   * Test {@link OfferServiceImpl#saveOfferCode(OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeDao} {@link OfferCodeDao#save(OfferCode)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link OfferCodeDao#save(OfferCode)}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#saveOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferServiceImpl.saveOfferCode(OfferCode)"})
  public void testSaveOfferCode_givenOfferCodeDaoSaveThrowRuntimeException_thenCallsSave() {
    // Arrange
    when(offerCodeDao.save(Mockito.<OfferCode>any())).thenThrow(new RuntimeException());
    when(offerDao.save(Mockito.<Offer>any())).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.saveOfferCode(new OfferCodeImpl()));
    verify(offerCodeDao).save(isA(OfferCode.class));
    verify(offerDao).save((Offer) isNull());
  }

  /**
   * Test {@link OfferServiceImpl#saveOfferCode(OfferCode)}.
   *
   * <ul>
   *   <li>Given {@link OfferDao} {@link OfferDao#save(Offer)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#saveOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferServiceImpl.saveOfferCode(OfferCode)"})
  public void testSaveOfferCode_givenOfferDaoSaveThrowRuntimeException() {
    // Arrange
    when(offerDao.save(Mockito.<Offer>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.saveOfferCode(new OfferCodeImpl()));
    verify(offerDao).save((Offer) isNull());
  }

  /**
   * Test {@link OfferServiceImpl#saveOfferCode(OfferCode)}.
   *
   * <ul>
   *   <li>Then {@link OfferCodeImpl} (default constructor) Offer {@link OfferImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#saveOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferServiceImpl.saveOfferCode(OfferCode)"})
  public void testSaveOfferCode_thenOfferCodeImplOfferOfferImpl() {
    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    OfferImpl offerImpl = new OfferImpl();
    when(offerDao.save(Mockito.<Offer>any())).thenReturn(offerImpl);

    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.save(Mockito.<OfferCode>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);
    offerServiceImpl.setOfferDao(offerDao);
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    OfferCode actualSaveOfferCodeResult = offerServiceImpl.saveOfferCode(offerCode);

    // Assert
    verify(offerCodeDao).save(isA(OfferCode.class));
    verify(offerDao).save((Offer) isNull());
    Offer offer = offerCode.getOffer();
    assertTrue(offer instanceof OfferImpl);
    assertSame(offerCodeImpl, actualSaveOfferCodeResult);
    assertSame(offerImpl, offer);
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferByCode(String)}.
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.lookupOfferByCode(String)"})
  public void testLookupOfferByCode() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(new OfferCodeImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Offer actualLookupOfferByCodeResult = offerServiceImpl.lookupOfferByCode("Code");

    // Assert
    verify(offerCodeDao).readOfferCodeByCode("Code");
    assertNull(actualLookupOfferByCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferByCode(String)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeDaoImpl} {@link OfferCodeDaoImpl#readOfferCodeByCode(String)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.lookupOfferByCode(String)"})
  public void testLookupOfferByCode_givenOfferCodeDaoImplReadOfferCodeByCodeReturnNull() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(null);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Offer actualLookupOfferByCodeResult = offerServiceImpl.lookupOfferByCode("Code");

    // Assert
    verify(offerCodeDao).readOfferCodeByCode("Code");
    assertNull(actualLookupOfferByCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferByCode(String)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferCodeImpl#getOffer()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.lookupOfferByCode(String)"})
  public void testLookupOfferByCode_thenCallsGetOffer() {
    // Arrange
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getOffer()).thenThrow(new RuntimeException());

    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupOfferByCode("Code"));
    verify(offerCodeDao).readOfferCodeByCode("Code");
    verify(offerCodeImpl).getOffer();
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferByCode(String)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferCodeDao#readOfferCodeByCode(String)}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.lookupOfferByCode(String)"})
  public void testLookupOfferByCode_thenCallsReadOfferCodeByCode() {
    // Arrange
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupOfferByCode("Code"));
    verify(offerCodeDao).readOfferCodeByCode("Code");
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferCodeByCode(String)}.
   *
   * <ul>
   *   <li>Then return {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferCodeByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferServiceImpl.lookupOfferCodeByCode(String)"})
  public void testLookupOfferCodeByCode_thenReturnOfferCodeImpl() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    OfferCode actualLookupOfferCodeByCodeResult = offerServiceImpl.lookupOfferCodeByCode("Code");

    // Assert
    verify(offerCodeDao).readOfferCodeByCode("Code");
    assertSame(offerCodeImpl, actualLookupOfferCodeByCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferCodeByCode(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferCodeByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferServiceImpl.lookupOfferCodeByCode(String)"})
  public void testLookupOfferCodeByCode_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupOfferCodeByCode("Code"));
    verify(offerCodeDao).readOfferCodeByCode("Code");
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAllOffersByCode(String)"})
  public void testLookupAllOffersByCode_givenArrayListAddNull_thenReturnEmpty() {
    // Arrange
    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(null);

    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(offerCodeList);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<Offer> actualLookupAllOffersByCodeResult = offerServiceImpl.lookupAllOffersByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode("Code");
    assertTrue(actualLookupAllOffersByCodeResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAllOffersByCode(String)"})
  public void testLookupAllOffersByCode_givenArrayListAddOfferCodeImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(new OfferCodeImpl());

    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(offerCodeList);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<Offer> actualLookupAllOffersByCodeResult = offerServiceImpl.lookupAllOffersByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode("Code");
    assertEquals(1, actualLookupAllOffersByCodeResult.size());
    assertNull(actualLookupAllOffersByCodeResult.get(0));
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferCodeImpl#getOffer()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAllOffersByCode(String)"})
  public void testLookupAllOffersByCode_thenCallsGetOffer() {
    // Arrange
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getOffer()).thenThrow(new RuntimeException());

    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(offerCodeImpl);

    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(offerCodeList);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupAllOffersByCode("Code"));
    verify(offerCodeDao).readAllOfferCodesByCode("Code");
    verify(offerCodeImpl).getOffer();
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferCodeDao#readAllOfferCodesByCode(String)}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAllOffersByCode(String)"})
  public void testLookupAllOffersByCode_thenCallsReadAllOfferCodesByCode() {
    // Arrange
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupAllOffersByCode("Code"));
    verify(offerCodeDao).readAllOfferCodesByCode("Code");
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAllOffersByCode(String)"})
  public void testLookupAllOffersByCode_thenReturnEmpty() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<Offer> actualLookupAllOffersByCodeResult = offerServiceImpl.lookupAllOffersByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode("Code");
    assertTrue(actualLookupAllOffersByCodeResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOfferCodesByCode(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAllOfferCodesByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAllOfferCodesByCode(String)"})
  public void testLookupAllOfferCodesByCode_thenReturnEmpty() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<OfferCode> actualLookupAllOfferCodesByCodeResult =
        offerServiceImpl.lookupAllOfferCodesByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode("Code");
    assertTrue(actualLookupAllOfferCodesByCodeResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOfferCodesByCode(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAllOfferCodesByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAllOfferCodesByCode(String)"})
  public void testLookupAllOfferCodesByCode_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupAllOfferCodesByCode("Code"));
    verify(offerCodeDao).readAllOfferCodesByCode("Code");
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder() {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(new NullOrderImpl()));
    verify(customerOfferDao).readCustomerOffersByCustomer(isNull());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder2() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(new NullOrderImpl()));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isNull());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder3() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenThrow(new RuntimeException());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(order));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder4() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenThrow(new RuntimeException());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(new ArrayList<>());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(order));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   *   <li>Then first return {@link OfferImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_givenArrayListAddOfferImpl_thenFirstReturnOfferImpl()
      throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Offer> offerList = new ArrayList<>();
    OfferImpl offerImpl = new OfferImpl();
    offerList.add(offerImpl);
    offerList.add(new OfferImpl());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(offerList);
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(1, actualBuildOfferListForOrderResult.size());
    Offer getResult = actualBuildOfferListForOrderResult.get(0);
    assertTrue(getResult instanceof OfferImpl);
    assertSame(offerImpl, getResult);
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_givenArrayListAddOfferImpl_thenReturnArrayList()
      throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Offer> offerList = new ArrayList<>();
    offerList.add(new OfferImpl());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(offerList);
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(offerList, actualBuildOfferListForOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_thenReturnEmpty() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(new ArrayList<>());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertTrue(actualBuildOfferListForOrderResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   *
   * <ul>
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_thenReturnFirstIsNull() throws Throwable {
    // Arrange
    ArrayList<CustomerOffer> customerOfferList = new ArrayList<>();
    customerOfferList.add(new CustomerOfferImpl());
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(customerOfferList);
    when(offerServiceExtensionManager.applyAdditionalFilters(
            Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(new ArrayList<>());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(1, actualBuildOfferListForOrderResult.size());
    assertNull(actualBuildOfferListForOrderResult.get(0));
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Customer)"})
  public void testBuildOfferCodeListForCustomerWithCustomer() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(
            Mockito.<Customer>any(), Mockito.<List<OfferCode>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    List<OfferCode> actualBuildOfferCodeListForCustomerResult =
        offerServiceImpl.buildOfferCodeListForCustomer(new CustomerImpl());

    // Assert
    verify(offerServiceExtensionManager)
        .buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertTrue(actualBuildOfferCodeListForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Customer)"})
  public void testBuildOfferCodeListForCustomerWithCustomer_givenOfferServiceImpl() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.buildOfferCodeListForCustomer(new CustomerImpl()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Customer)"})
  public void testBuildOfferCodeListForCustomerWithCustomer_thenThrowRuntimeException() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(
            Mockito.<Customer>any(), Mockito.<List<OfferCode>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.buildOfferCodeListForCustomer(new CustomerImpl()));
    verify(offerServiceExtensionManager)
        .buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Order)"})
  public void testBuildOfferCodeListForCustomerWithOrder_givenOfferServiceImpl_thenReturnEmpty() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.buildOfferCodeListForCustomer(new NullOrderImpl()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Order)"})
  public void testBuildOfferCodeListForCustomerWithOrder_thenReturnEmpty() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(
            Mockito.<Customer>any(), Mockito.<List<OfferCode>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    List<OfferCode> actualBuildOfferCodeListForCustomerResult =
        offerServiceImpl.buildOfferCodeListForCustomer(new NullOrderImpl());

    // Assert
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isNull(), isA(List.class));
    assertTrue(actualBuildOfferCodeListForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Order)"})
  public void testBuildOfferCodeListForCustomerWithOrder_thenThrowRuntimeException() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(
            Mockito.<Customer>any(), Mockito.<List<OfferCode>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.buildOfferCodeListForCustomer(new NullOrderImpl()));
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isNull(), isA(List.class));
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferCustomerByCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferCustomerByCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupOfferCustomerByCustomer(Customer)"})
  public void testLookupOfferCustomerByCustomer_thenReturnEmpty() {
    // Arrange
    CustomerOfferDaoImpl customerOfferDao = mock(CustomerOfferDaoImpl.class);
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setCustomerOfferDao(customerOfferDao);

    // Act
    List<CustomerOffer> actualLookupOfferCustomerByCustomerResult =
        offerServiceImpl.lookupOfferCustomerByCustomer(new CustomerImpl());

    // Assert
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    assertTrue(actualLookupOfferCustomerByCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferCustomerByCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupOfferCustomerByCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupOfferCustomerByCustomer(Customer)"})
  public void testLookupOfferCustomerByCustomer_thenThrowRuntimeException() {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.lookupOfferCustomerByCustomer(new CustomerImpl()));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
  }

  /**
   * Test {@link OfferServiceImpl#lookupAutomaticDeliveryOffers()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAutomaticDeliveryOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAutomaticDeliveryOffers()"})
  public void testLookupAutomaticDeliveryOffers_thenReturnEmpty() {
    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    List<Offer> actualLookupAutomaticDeliveryOffersResult =
        offerServiceImpl.lookupAutomaticDeliveryOffers();

    // Assert
    verify(offerDao).readOffersByAutomaticDeliveryType();
    assertTrue(actualLookupAutomaticDeliveryOffersResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupAutomaticDeliveryOffers()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#lookupAutomaticDeliveryOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.lookupAutomaticDeliveryOffers()"})
  public void testLookupAutomaticDeliveryOffers_thenThrowRuntimeException() {
    // Arrange
    when(offerDao.readOffersByAutomaticDeliveryType()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupAutomaticDeliveryOffers());
    verify(offerDao).readOffersByAutomaticDeliveryType();
  }

  /**
   * Test {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} {@link OfferCodeImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.removeOutOfDateOfferCodes(List)"})
  public void testRemoveOutOfDateOfferCodes_givenOfferCodeImplIsActiveReturnFalse() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.isActive()).thenReturn(false);

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(offerCodeImpl);

    // Act
    List<OfferCode> actualRemoveOutOfDateOfferCodesResult =
        offerServiceImpl.removeOutOfDateOfferCodes(offerCodes);

    // Assert
    verify(offerCodeImpl).isActive();
    assertTrue(offerCodes.isEmpty());
    assertTrue(actualRemoveOutOfDateOfferCodesResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.removeOutOfDateOfferCodes(List)"})
  public void testRemoveOutOfDateOfferCodes_thenArrayListSizeIsOne() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.isActive()).thenReturn(true);

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(offerCodeImpl);

    // Act
    List<OfferCode> actualRemoveOutOfDateOfferCodesResult =
        offerServiceImpl.removeOutOfDateOfferCodes(offerCodes);

    // Assert
    verify(offerCodeImpl).isActive();
    assertEquals(1, offerCodes.size());
    assertSame(offerCodes, actualRemoveOutOfDateOfferCodesResult);
  }

  /**
   * Test {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.removeOutOfDateOfferCodes(List)"})
  public void testRemoveOutOfDateOfferCodes_whenArrayList_thenArrayListEmpty() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    ArrayList<OfferCode> offerCodes = new ArrayList<>();

    // Act
    List<OfferCode> actualRemoveOutOfDateOfferCodesResult =
        offerServiceImpl.removeOutOfDateOfferCodes(offerCodes);

    // Assert
    assertTrue(offerCodes.isEmpty());
    assertTrue(actualRemoveOutOfDateOfferCodesResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#refreshOfferCodesIfApplicable(Order)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#refreshOfferCodesIfApplicable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.refreshOfferCodesIfApplicable(Order)"})
  public void testRefreshOfferCodesIfApplicable_thenReturnNull() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    List<OfferCode> actualRefreshOfferCodesIfApplicableResult =
        offerServiceImpl.refreshOfferCodesIfApplicable(new NullOrderImpl());

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertNull(actualRefreshOfferCodesIfApplicableResult);
  }

  /**
   * Test {@link OfferServiceImpl#refreshOfferCodesIfApplicable(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#refreshOfferCodesIfApplicable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.refreshOfferCodesIfApplicable(Order)"})
  public void testRefreshOfferCodesIfApplicable_thenThrowRuntimeException() throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.refreshOfferCodesIfApplicable(new NullOrderImpl()));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyAdjustments(Order, boolean)"})
  public void testVerifyAdjustments() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) OrderItemPriceDetails is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyAdjustments(Order, boolean)"})
  public void testVerifyAdjustments_givenBundleOrderItemImplOrderItemPriceDetailsIsNull() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(null);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceImpl} (default constructor).
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyAdjustments(Order, boolean)"})
  public void testVerifyAdjustments_givenOfferServiceImpl_whenNullOrderImpl_thenReturnFalse() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(new NullOrderImpl(), true));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor) OrderItemAdjustments is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyAdjustments(Order, boolean)"})
  public void testVerifyAdjustments_givenOrderItemPriceDetailImplOrderItemAdjustmentsIsNull() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(null);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyAdjustments(Order, boolean)"})
  public void testVerifyAdjustments_thenCallsGetOffer() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.getOffer()).thenReturn(new OfferImpl());

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act
    boolean actualVerifyAdjustmentsResult = offerServiceImpl.verifyAdjustments(order, false);

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl, atLeast(1)).getOffer();
    assertFalse(actualVerifyAdjustmentsResult);
  }

  /**
   * Test {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferServiceImpl.applyFulfillmentGroupOffersToOrder(List, Order)"})
  public void testApplyFulfillmentGroupOffersToOrder_thenCallsGetType() throws PricingException {
    // Arrange
    OrderService orderService = mock(OrderService.class);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    offerServiceImpl.applyFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List, Order)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order OfferServiceImpl.applyAndSaveFulfillmentGroupOffersToOrder(List, Order)"
  })
  public void testApplyAndSaveFulfillmentGroupOffersToOrder_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    OrderService orderService = mock(OrderService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    Order actualApplyAndSaveFulfillmentGroupOffersToOrderResult =
        offerServiceImpl.applyAndSaveFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(nullOrderImpl, actualApplyAndSaveFulfillmentGroupOffersToOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)} with {@code
   * customer}, {@code code}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, OfferCode)"
  })
  public void testVerifyMaxCustomerUsageThresholdWithCustomerCode() {
    // Arrange
    when(offerAuditService.countOfferCodeUses(Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();

    OfferCodeImpl code = new OfferCodeImpl();
    code.setMaxUses(3);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, code));
    verify(offerAuditService).countOfferCodeUses(isNull());
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)} with {@code
   * customer}, {@code code}.
   *
   * <ul>
   *   <li>Then calls {@link OfferImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, OfferCode)"
  })
  public void testVerifyMaxCustomerUsageThresholdWithCustomerCode_thenCallsGetId() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenThrow(new RuntimeException());
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);

    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(offerImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, code));
    verify(code).getOffer();
    verify(code).isLimitedUse();
    verify(offerImpl).getId();
    verify(offerImpl).isLimitedUsePerCustomer();
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)} with {@code
   * customer}, {@code code}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, OfferCode)"
  })
  public void testVerifyMaxCustomerUsageThresholdWithCustomerCode_thenReturnFalse() {
    // Arrange
    when(offerAuditService.countOfferCodeUses(Mockito.<Long>any())).thenReturn(3L);
    CustomerImpl customer = new CustomerImpl();

    OfferCodeImpl code = new OfferCodeImpl();
    code.setMaxUses(3);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, code);

    // Assert
    verify(offerAuditService).countOfferCodeUses(isNull());
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)} with {@code
   * customer}, {@code code}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, OfferCode)"
  })
  public void testVerifyMaxCustomerUsageThresholdWithCustomerCode_thenReturnTrue() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(new OfferImpl());

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, code);

    // Assert
    verify(code).getOffer();
    verify(code).isLimitedUse();
    assertTrue(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)} with {@code
   * customer}, {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithCustomerOffer() {
    // Arrange
    when(offerAuditService.countUsesByCustomer(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(0L);
    CustomerImpl customer = new CustomerImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByCustomer(isNull(), eq(1L));
    assertTrue(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)} with {@code
   * customer}, {@code offer}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithCustomerOffer_thenReturnFalse() {
    // Arrange
    when(offerAuditService.countUsesByCustomer(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);
    CustomerImpl customer = new CustomerImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByCustomer(isNull(), eq(1L));
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)} with {@code
   * customer}, {@code offer}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithCustomerOffer_thenThrowRuntimeException() {
    // Arrange
    when(offerAuditService.countUsesByCustomer(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    CustomerImpl customer = new CustomerImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, offer));
    verify(offer).getId();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByCustomer(isNull(), eq(1L));
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)} with {@code
   * customer}, {@code offer}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Customer, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithCustomerOffer_whenOfferImpl() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, new OfferImpl()));
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)} with {@code
   * order}, {@code code}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, OfferCode)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getMaxUsesStrategyType()).thenThrow(new RuntimeException());
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);

    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(offerImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code));
    verify(code).getOffer();
    verify(code).isLimitedUse();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).isLimitedUsePerCustomer();
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)} with {@code
   * order}, {@code code}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, OfferCode)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode2() {
    // Arrange
    when(offerAuditService.countOfferCodeUses(Mockito.<Order>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    NullOrderImpl order = new NullOrderImpl();

    OfferCodeImpl code = new OfferCodeImpl();
    code.setMaxUses(3);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code));
    verify(offerAuditService).countOfferCodeUses(isA(Order.class), isNull());
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)} with {@code
   * order}, {@code code}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, OfferCode)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode_givenOfferImpl_thenReturnTrue() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(new OfferImpl());

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code);

    // Assert
    verify(code).getOffer();
    verify(code).isLimitedUse();
    assertTrue(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)} with {@code
   * order}, {@code code}.
   *
   * <ul>
   *   <li>Then calls {@link OfferImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, OfferCode)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode_thenCallsGetId() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenThrow(new RuntimeException());
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.ACCOUNT);
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);

    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(offerImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code));
    verify(code).getOffer();
    verify(code).isLimitedUse();
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).isLimitedUsePerCustomer();
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)} with {@code
   * order}, {@code code}.
   *
   * <ul>
   *   <li>Then calls {@link OfferCode#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, OfferCode)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode_thenCallsGetId2() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    OfferCode code = mock(OfferCode.class);
    when(code.getId()).thenThrow(new RuntimeException());
    when(code.isLimitedUse()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code));
    verify(code).getId();
    verify(code).isLimitedUse();
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)} with {@code
   * order}, {@code code}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order,
   * OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, OfferCode)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode_thenReturnFalse() {
    // Arrange
    when(offerAuditService.countOfferCodeUses(Mockito.<Order>any(), Mockito.<Long>any()))
        .thenReturn(3L);
    NullOrderImpl order = new NullOrderImpl();

    OfferCodeImpl code = new OfferCodeImpl();
    code.setMaxUses(3);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code);

    // Assert
    verify(offerAuditService).countOfferCodeUses(isA(Order.class), isNull());
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer() {
    // Arrange
    when(offerAuditService.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    NullOrderImpl order = new NullOrderImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.ACCOUNT);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer));
    verify(offer).getId();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer2() {
    // Arrange
    when(offerAuditService.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);
    NullOrderImpl order = new NullOrderImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(new CustomerMaxUsesStrategyType());
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer3() {
    // Arrange
    when(offerAuditService.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);
    NullOrderImpl order = new NullOrderImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(mock(CustomerMaxUsesStrategyType.class));
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer4() {
    // Arrange
    when(offerAuditService.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(0L);
    NullOrderImpl order = new NullOrderImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.ACCOUNT);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    assertTrue(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer5() {
    // Arrange
    when(offerAuditService.countUsesByCustomer(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    Order order = mock(Order.class);
    when(order.getCustomer()).thenReturn(new CustomerImpl());

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.CUSTOMER);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByCustomer(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(order).getCustomer();
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer6() {
    // Arrange
    when(offerAuditService.countUsesByCustomer(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException());

    Order order = mock(Order.class);
    when(order.getCustomer()).thenReturn(new CustomerImpl());

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.CUSTOMER);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer));
    verify(offer).getId();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByCustomer(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(order).getCustomer();
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer7() {
    // Arrange
    when(offerAuditService.countUsesByCustomer(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    Order order = mock(Order.class);
    when(order.getCustomer()).thenReturn(new CustomerImpl());

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(null);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByCustomer(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(order).getCustomer();
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer_thenReturnFalse() {
    // Arrange
    when(offerAuditService.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);
    NullOrderImpl order = new NullOrderImpl();

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getId()).thenReturn(1L);
    when(offer.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offer.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offer.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.ACCOUNT);
    when(offer.isLimitedUsePerCustomer()).thenReturn(true);

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult =
        offerServiceImpl.verifyMaxCustomerUsageThreshold(order, offer);

    // Assert
    verify(offer).getId();
    verify(offer).getMaxUsesPerCustomer();
    verify(offer).getMaxUsesStrategyType();
    verify(offer).getMinimumDaysPerUsage();
    verify(offer).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    assertFalse(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)} with {@code order},
   * {@code offer}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferServiceImpl.verifyMaxCustomerUsageThreshold(Order, Offer)"})
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer_whenOfferImpl_thenReturnTrue() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.verifyMaxCustomerUsageThreshold(order, new OfferImpl()));
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) OrderItemPriceDetails is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferServiceImpl.getUniqueOffersFromOrder(Order)"})
  public void testGetUniqueOffersFromOrder_givenBundleOrderItemImplOrderItemPriceDetailsIsNull() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(null);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link OrderImpl} (default constructor) FulfillmentGroups is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferServiceImpl.getUniqueOffersFromOrder(Order)"})
  public void testGetUniqueOffersFromOrder_givenNull_whenOrderImplFulfillmentGroupsIsNull() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    order.setFulfillmentGroups(null);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferServiceImpl.getUniqueOffersFromOrder(Order)"})
  public void testGetUniqueOffersFromOrder_givenOfferServiceImpl_thenReturnEmpty() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferServiceImpl.getUniqueOffersFromOrder(Order)"})
  public void testGetUniqueOffersFromOrder_thenReturnSizeIsOne() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertEquals(1, offerServiceImpl.getUniqueOffersFromOrder(order).size());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code
   * appliedOffers}.
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers() {
    // Arrange
    when(offerServiceExtensionManager.getProxy())
        .thenReturn(new AbstractOfferServiceExtensionHandler());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes =
        offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code
   * appliedOffers}.
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new OfferServiceExtensionManager());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes =
        offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code
   * appliedOffers}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_givenOfferImpl() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    ArrayList<OfferCode> codes = new ArrayList<>();

    HashSet<Offer> appliedOffers = new HashSet<>();
    appliedOffers.add(new OfferImpl());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(codes, appliedOffers).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code
   * appliedOffers}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_givenOfferServiceImpl() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    ArrayList<OfferCode> codes = new ArrayList<>();

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code
   * appliedOffers}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_thenThrowRuntimeException() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>()));
    verify(offerServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    orderItemPriceDetailList.add(orderItemPriceDetailImpl);

    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(orderItemPriceDetailList);
    when(orderItem.getOrderItemAdjustments()).thenReturn(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItem);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes =
        offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(orderItem).getOrderItemAdjustments();
    verify(orderItem, atLeast(1)).getOrderItemPriceDetails();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new OfferServiceExtensionManager());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes =
        offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddFulfillmentGroupImpl() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Given {@link OfferServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_givenOfferServiceImpl_thenReturnEmpty() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItem#getOrderItemAdjustments()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenCallsGetOrderItemAdjustments() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    orderItemPriceDetailList.add(orderItemPriceDetailImpl);

    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(orderItemPriceDetailList);
    when(orderItem.getOrderItemAdjustments()).thenReturn(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItem);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes =
        offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(orderItem).getOrderItemAdjustments();
    verify(orderItem, atLeast(1)).getOrderItemPriceDetails();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Then calls {@link OfferServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenCallsGetProxy() {
    // Arrange
    when(offerServiceExtensionManager.getProxy())
        .thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes =
        offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenReturnSizeIsOne() {
    // Arrange
    when(offerServiceExtensionManager.getProxy())
        .thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetailList = new ArrayList<>();
    orderItemPriceDetailList.add(orderItemPriceDetailImpl);

    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(orderItemPriceDetailList);
    when(orderItem.getOrderItemAdjustments()).thenReturn(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItem);

    OrderImpl order = new OrderImpl();
    OfferCodeImpl offerCode = new OfferCodeImpl();
    order.addAddedOfferCode(offerCode);
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes =
        offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    verify(orderItem).getOrderItemAdjustments();
    verify(orderItem, atLeast(1)).getOrderItemPriceDetails();
    assertEquals(1, actualOffersRetrievedFromCodes.size());
    assertSame(offerCode, actualOffersRetrievedFromCodes.get(null));
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenThrowRuntimeException() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.getOffersRetrievedFromCodes(order));
    verify(offerServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_thenReturnFalse() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(true);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertFalse(actualDeleteOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_thenReturnTrue() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(false);
    doNothing().when(offerCodeDao).delete(Mockito.<OfferCode>any());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).delete(isA(OfferCode.class));
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertTrue(actualDeleteOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> offerServiceImpl.deleteOfferCode(new OfferCodeImpl()));
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
  }

  /**
   * Test {@link OfferServiceImpl#duplicate(Long)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link
   *       OfferAdjustmentType#FUTURE_CREDIT}.
   *   <li>Then return {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#duplicate(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.duplicate(Long)"})
  public void testDuplicate_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnOfferImpl() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offerImpl.setMaxUsesPerOrder(3);
    offerImpl.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offerImpl.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offerImpl.setName("Name");
    offerImpl.setOfferCodes(new ArrayList<>());
    offerImpl.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferMatchRulesXref(new HashMap<>());
    offerImpl.setOfferPriceData(new ArrayList<>());
    offerImpl.setOrderMinSubTotal(new Money());
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setQualifyingItemSubTotal(new Money());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    when(entityDuplicator.copy(eq(OfferImpl.class), Mockito.<Long>any())).thenReturn(offerImpl);

    // Act
    Offer actualDuplicateResult = offerServiceImpl.duplicate(1L);

    // Assert
    verify(entityDuplicator).copy(isA(Class.class), eq(1L));
    assertSame(offerImpl, actualDuplicateResult);
  }

  /**
   * Test {@link OfferServiceImpl#duplicate(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#duplicate(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.duplicate(Long)"})
  public void testDuplicate_thenThrowRuntimeException() {
    // Arrange
    when(entityDuplicator.copy(eq(OfferImpl.class), Mockito.<Long>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.duplicate(1L));
    verify(entityDuplicator).copy(isA(Class.class), eq(1L));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferServiceImpl#setCustomerOfferDao(CustomerOfferDao)}
   *   <li>{@link
   *       OfferServiceImpl#setFulfillmentGroupOfferProcessor(FulfillmentGroupOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setItemOfferProcessor(ItemOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOfferCodeDao(OfferCodeDao)}
   *   <li>{@link OfferServiceImpl#setOfferDao(OfferDao)}
   *   <li>{@link OfferServiceImpl#setOrderOfferProcessor(OrderOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOrderService(OrderService)}
   *   <li>{@link OfferServiceImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceImpl#getCustomerOfferDao()}
   *   <li>{@link OfferServiceImpl#getFulfillmentGroupOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getItemOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOfferCodeDao()}
   *   <li>{@link OfferServiceImpl#getOfferDao()}
   *   <li>{@link OfferServiceImpl#getOrderOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOrderService()}
   *   <li>{@link OfferServiceImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerOfferDao OfferServiceImpl.getCustomerOfferDao()",
    "FulfillmentGroupOfferProcessor OfferServiceImpl.getFulfillmentGroupOfferProcessor()",
    "ItemOfferProcessor OfferServiceImpl.getItemOfferProcessor()",
    "OfferCodeDao OfferServiceImpl.getOfferCodeDao()",
    "OfferDao OfferServiceImpl.getOfferDao()",
    "OrderOfferProcessor OfferServiceImpl.getOrderOfferProcessor()",
    "OrderService OfferServiceImpl.getOrderService()",
    "PromotableItemFactory OfferServiceImpl.getPromotableItemFactory()",
    "void OfferServiceImpl.setCustomerOfferDao(CustomerOfferDao)",
    "void OfferServiceImpl.setFulfillmentGroupOfferProcessor(FulfillmentGroupOfferProcessor)",
    "void OfferServiceImpl.setItemOfferProcessor(ItemOfferProcessor)",
    "void OfferServiceImpl.setOfferCodeDao(OfferCodeDao)",
    "void OfferServiceImpl.setOfferDao(OfferDao)",
    "void OfferServiceImpl.setOrderOfferProcessor(OrderOfferProcessor)",
    "void OfferServiceImpl.setOrderService(OrderService)",
    "void OfferServiceImpl.setPromotableItemFactory(PromotableItemFactory)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerOfferDaoImpl customerOfferDao = new CustomerOfferDaoImpl();

    // Act
    offerServiceImpl.setCustomerOfferDao(customerOfferDao);
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessor =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setFulfillmentGroupOfferProcessor(fulfillmentGroupOfferProcessor);
    ItemOfferProcessorImpl itemOfferProcessor =
        new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setItemOfferProcessor(itemOfferProcessor);
    OfferCodeDaoImpl offerCodeDao = new OfferCodeDaoImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceImpl.setOfferDao(offerDao);
    FulfillmentGroupOfferProcessorImpl orderOfferProcessor =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    OrderServiceImpl orderService = new OrderServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    PromotableItemFactoryImpl promotableItemFactory =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setPromotableItemFactory(promotableItemFactory);
    CustomerOfferDao actualCustomerOfferDao = offerServiceImpl.getCustomerOfferDao();
    FulfillmentGroupOfferProcessor actualFulfillmentGroupOfferProcessor =
        offerServiceImpl.getFulfillmentGroupOfferProcessor();
    ItemOfferProcessor actualItemOfferProcessor = offerServiceImpl.getItemOfferProcessor();
    OfferCodeDao actualOfferCodeDao = offerServiceImpl.getOfferCodeDao();
    OfferDao actualOfferDao = offerServiceImpl.getOfferDao();
    OrderOfferProcessor actualOrderOfferProcessor = offerServiceImpl.getOrderOfferProcessor();
    OrderService actualOrderService = offerServiceImpl.getOrderService();
    PromotableItemFactory actualPromotableItemFactory = offerServiceImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualCustomerOfferDao instanceof CustomerOfferDaoImpl);
    assertTrue(actualOfferCodeDao instanceof OfferCodeDaoImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(customerOfferDao, actualCustomerOfferDao);
    assertSame(offerCodeDao, actualOfferCodeDao);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
    assertSame(fulfillmentGroupOfferProcessor, actualFulfillmentGroupOfferProcessor);
    assertSame(orderOfferProcessor, actualOrderOfferProcessor);
    assertSame(itemOfferProcessor, actualItemOfferProcessor);
    assertSame(orderService, actualOrderService);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodeById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferCodeById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferServiceImpl.findOfferCodeById(Long)"})
  public void testFindOfferCodeById_thenReturnOfferCodeImpl() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.readOfferCodeById(Mockito.<Long>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    OfferCode actualFindOfferCodeByIdResult = offerServiceImpl.findOfferCodeById(1L);

    // Assert
    verify(offerCodeDao).readOfferCodeById(1L);
    assertSame(offerCodeImpl, actualFindOfferCodeByIdResult);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodeById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferCodeById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferCode OfferServiceImpl.findOfferCodeById(Long)"})
  public void testFindOfferCodeById_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.readOfferCodeById(Mockito.<Long>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferCodeById(1L));
    verify(offerCodeDao).readOfferCodeById(1L);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeDao} {@link OfferCodeDao#readOfferCodesByIds(Collection)} return
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_givenOfferCodeDaoReadOfferCodesByIdsReturnArrayList() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(ids);

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_givenZero_whenArrayListAddZero_thenReturnEmpty() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(ids);

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link OfferCodeDaoImpl#readOfferCodesByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_thenCallsReadOfferCodesByIds() {
    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult =
        offerServiceImpl.findOfferCodesByIds(new ArrayList<>());

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> offerServiceImpl.findOfferCodesByIds(new ArrayList<>()));
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
  }

  /**
   * Test {@link OfferServiceImpl#findOfferById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.findOfferById(Long)"})
  public void testFindOfferById_thenReturnOfferImpl() {
    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    OfferImpl offerImpl = new OfferImpl();
    when(offerDao.readOfferById(Mockito.<Long>any())).thenReturn(offerImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    Offer actualFindOfferByIdResult = offerServiceImpl.findOfferById(1L);

    // Assert
    verify(offerDao).readOfferById(1L);
    assertSame(offerImpl, actualFindOfferByIdResult);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OfferServiceImpl#findOfferById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferServiceImpl.findOfferById(Long)"})
  public void testFindOfferById_thenThrowRuntimeException() {
    // Arrange
    when(offerDao.readOfferById(Mockito.<Long>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferById(1L));
    verify(offerDao).readOfferById(1L);
  }
}
