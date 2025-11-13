package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductOptionDaoImplDiffblueTest {
  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductOptionDaoImpl.filterCandidateSkusForArchivedStatus(List)"})
  public void testFilterCandidateSkusForArchivedStatus_givenSkuImpl_thenReturnSizeIsOne() {
    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();

    ArrayList<Sku> candidateSkus = new ArrayList<>();
    candidateSkus.add(new SkuImpl());

    // Act
    List<Long> actualFilterCandidateSkusForArchivedStatusResult =
        productOptionDaoImpl.filterCandidateSkusForArchivedStatus(candidateSkus);

    // Assert
    assertEquals(1, actualFilterCandidateSkusForArchivedStatusResult.size());
    assertNull(actualFilterCandidateSkusForArchivedStatusResult.get(0));
  }

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductOptionDaoImpl.filterCandidateSkusForArchivedStatus(List)"})
  public void testFilterCandidateSkusForArchivedStatus_whenArrayList_thenReturnEmpty() {
    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();

    // Act and Assert
    assertTrue(
        productOptionDaoImpl.filterCandidateSkusForArchivedStatus(new ArrayList<>()).isEmpty());
  }
}
