package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.weave.LegacyOfferUses;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LegacyOfferUsesImplDiffblueTest {
  /**
   * Test {@link LegacyOfferUsesImpl#getMaxUses()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOfferUsesImpl#getMaxUses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegacyOfferUsesImpl.getMaxUses()"})
  public void testGetMaxUses_thenReturnZero() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertEquals(0, legacyOfferUsesImpl.getMaxUses());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#setMaxUses(int)}.
   *
   * <ul>
   *   <li>Then {@link LegacyOfferUsesImpl} (default constructor) Offer {@link OfferImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOfferUsesImpl#setMaxUses(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyOfferUsesImpl.setMaxUses(int)"})
  public void testSetMaxUses_thenLegacyOfferUsesImplOfferOfferImpl() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act
    legacyOfferUsesImpl.setMaxUses(3);

    // Assert
    Offer offer = legacyOfferUsesImpl.getOffer();
    assertTrue(offer instanceof OfferImpl);
    assertEquals(3, ((OfferImpl) offer).maxUsesPerOrder.intValue());
    assertEquals(3, legacyOfferUsesImpl.getMaxUses());
    assertEquals(3, offer.getMaxUsesPerOrder());
    assertFalse(offer.isUnlimitedUsePerOrder());
    assertTrue(offer.isLimitedUsePerOrder());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}, and {@link LegacyOfferUsesImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LegacyOfferUsesImpl#equals(Object)}
   *   <li>{@link LegacyOfferUsesImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOfferUsesImpl.equals(Object)",
    "int LegacyOfferUsesImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    LegacyOfferUsesImpl legacyOfferUsesImpl2 = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl2.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl2.setOffer(new OfferImpl());
    legacyOfferUsesImpl2.setUses(1);

    // Act and Assert
    assertEquals(legacyOfferUsesImpl, legacyOfferUsesImpl2);
    assertEquals(legacyOfferUsesImpl.hashCode(), legacyOfferUsesImpl2.hashCode());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}, and {@link LegacyOfferUsesImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LegacyOfferUsesImpl#equals(Object)}
   *   <li>{@link LegacyOfferUsesImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOfferUsesImpl.equals(Object)",
    "int LegacyOfferUsesImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertEquals(legacyOfferUsesImpl, legacyOfferUsesImpl);
    int expectedHashCodeResult = legacyOfferUsesImpl.hashCode();
    assertEquals(expectedHashCodeResult, legacyOfferUsesImpl.hashCode());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOfferUsesImpl.equals(Object)",
    "int LegacyOfferUsesImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(offer);
    legacyOfferUsesImpl.setUses(1);

    LegacyOfferUsesImpl legacyOfferUsesImpl2 = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl2.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl2.setOffer(new OfferImpl());
    legacyOfferUsesImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, legacyOfferUsesImpl2);
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOfferUsesImpl.equals(Object)",
    "int LegacyOfferUsesImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(0);

    LegacyOfferUsesImpl legacyOfferUsesImpl2 = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl2.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl2.setOffer(new OfferImpl());
    legacyOfferUsesImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, legacyOfferUsesImpl2);
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOfferUsesImpl.equals(Object)",
    "int LegacyOfferUsesImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, null);
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LegacyOfferUsesImpl.equals(Object)",
    "int LegacyOfferUsesImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, "Different type to LegacyOfferUsesImpl");
  }

  /**
   * Test {@link LegacyOfferUsesImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then Clone return {@link LegacyOfferUsesImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyOfferUsesImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse LegacyOfferUsesImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnLegacyOfferUsesImpl()
      throws CloneNotSupportedException {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    // Act
    CreateResponse<LegacyOfferUses> actualCreateOrRetrieveCopyInstanceResult =
        legacyOfferUsesImpl.createOrRetrieveCopyInstance(context);

    // Assert
    LegacyOfferUses clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof LegacyOfferUsesImpl);
    assertNull(((LegacyOfferUsesImpl) clone).getOffer());
    assertEquals(0, clone.getUses());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(((LegacyOfferUsesImpl) clone).getApplyDiscountToMarkedItems());
    assertFalse(clone.isApplyDiscountToMarkedItems());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LegacyOfferUsesImpl}
   *   <li>{@link LegacyOfferUsesImpl#setApplyDiscountToMarkedItems(boolean)}
   *   <li>{@link LegacyOfferUsesImpl#setOffer(Offer)}
   *   <li>{@link LegacyOfferUsesImpl#setUses(int)}
   *   <li>{@link LegacyOfferUsesImpl#getApplyDiscountToMarkedItems()}
   *   <li>{@link LegacyOfferUsesImpl#getOffer()}
   *   <li>{@link LegacyOfferUsesImpl#getUses()}
   *   <li>{@link LegacyOfferUsesImpl#isApplyDiscountToMarkedItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyOfferUsesImpl.<init>()",
    "boolean LegacyOfferUsesImpl.getApplyDiscountToMarkedItems()",
    "Offer LegacyOfferUsesImpl.getOffer()",
    "int LegacyOfferUsesImpl.getUses()",
    "boolean LegacyOfferUsesImpl.isApplyDiscountToMarkedItems()",
    "void LegacyOfferUsesImpl.setApplyDiscountToMarkedItems(boolean)",
    "void LegacyOfferUsesImpl.setOffer(Offer)",
    "void LegacyOfferUsesImpl.setUses(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    LegacyOfferUsesImpl actualLegacyOfferUsesImpl = new LegacyOfferUsesImpl();
    actualLegacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    OfferImpl offer = new OfferImpl();
    actualLegacyOfferUsesImpl.setOffer(offer);
    actualLegacyOfferUsesImpl.setUses(1);
    boolean actualApplyDiscountToMarkedItems =
        actualLegacyOfferUsesImpl.getApplyDiscountToMarkedItems();
    Offer actualOffer = actualLegacyOfferUsesImpl.getOffer();
    int actualUses = actualLegacyOfferUsesImpl.getUses();

    // Assert
    assertEquals(1, actualUses);
    assertTrue(actualApplyDiscountToMarkedItems);
    assertTrue(actualLegacyOfferUsesImpl.isApplyDiscountToMarkedItems());
    assertSame(offer, actualOffer);
  }
}
