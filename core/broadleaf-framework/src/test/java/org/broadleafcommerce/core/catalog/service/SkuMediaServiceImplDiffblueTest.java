package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.dao.SkuMediaDao;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXrefImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuMediaServiceImplDiffblueTest {
  @Mock private SkuMediaDao skuMediaDao;

  @InjectMocks private SkuMediaServiceImpl skuMediaServiceImpl;

  /**
   * Test {@link SkuMediaServiceImpl#save(SkuMediaXref)}.
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#save(SkuMediaXref)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SkuMediaXref SkuMediaServiceImpl.save(SkuMediaXref)"})
  public void testSave() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    when(skuMediaDao.save(Mockito.<SkuMediaXref>any())).thenReturn(skuMediaXrefImpl);

    // Act
    SkuMediaXref actualSaveResult = skuMediaServiceImpl.save(new SkuMediaXrefImpl());

    // Assert
    verify(skuMediaDao).save(isA(SkuMediaXref.class));
    assertSame(skuMediaXrefImpl, actualSaveResult);
  }

  /**
   * Test {@link SkuMediaServiceImpl#sort(List)}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaServiceImpl} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#sort(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuMediaServiceImpl.sort(List)"})
  public void testSort_givenSkuMediaServiceImpl_thenReturnArrayList() {
    // Arrange
    SkuMediaServiceImpl skuMediaServiceImpl = new SkuMediaServiceImpl();

    ArrayList<SkuMediaXref> skuMediaXrefs = new ArrayList<>();
    skuMediaXrefs.add(new SkuMediaXrefImpl());

    // Act
    List<SkuMediaXref> actualSortResult = skuMediaServiceImpl.sort(skuMediaXrefs);

    // Assert
    assertSame(skuMediaXrefs, actualSortResult);
  }

  /**
   * Test {@link SkuMediaServiceImpl#sort(List)}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaServiceImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#sort(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuMediaServiceImpl.sort(List)"})
  public void testSort_givenSkuMediaServiceImpl_whenArrayList_thenReturnEmpty() {
    // Arrange
    SkuMediaServiceImpl skuMediaServiceImpl = new SkuMediaServiceImpl();

    // Act and Assert
    assertTrue(skuMediaServiceImpl.sort(new ArrayList<>()).isEmpty());
  }
}
