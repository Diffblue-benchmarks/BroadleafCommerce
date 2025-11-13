package org.broadleafcommerce.common.id.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.OptimisticLockException;
import org.broadleafcommerce.common.id.dao.IdGenerationDao;
import org.broadleafcommerce.common.id.domain.IdGeneration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdGenerationServiceImplDiffblueTest {
  @Mock private IdGenerationDao idGenerationDao;

  @InjectMocks private IdGenerationServiceImpl idGenerationServiceImpl;

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String)} with {@code idType}.
   *
   * <p>Method under test: {@link IdGenerationServiceImpl#findNextId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String)"})
  public void testFindNextIdWithIdType() throws Exception {
    // Arrange
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any()))
        .thenThrow(new OptimisticLockException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> idGenerationServiceImpl.findNextId("Id Type"));
    verify(idGenerationDao, atLeast(1)).findNextId(eq("Id Type"), isNull());
  }

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String, Long)} with {@code idType}, {@code
   * batchSize}.
   *
   * <p>Method under test: {@link IdGenerationServiceImpl#findNextId(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String, Long)"})
  public void testFindNextIdWithIdTypeBatchSize() throws Exception {
    // Arrange
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any()))
        .thenThrow(new OptimisticLockException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> idGenerationServiceImpl.findNextId("Id Type", 3L));
    verify(idGenerationDao, atLeast(1)).findNextId("Id Type", 3L);
  }

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String, Long)} with {@code idType}, {@code
   * batchSize}.
   *
   * <ul>
   *   <li>Given {@link IdGenerationDao} {@link IdGenerationDao#findNextId(String, Long)} throw
   *       {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link IdGenerationServiceImpl#findNextId(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String, Long)"})
  public void testFindNextIdWithIdTypeBatchSize_givenIdGenerationDaoFindNextIdThrowException()
      throws Exception {
    // Arrange
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any()))
        .thenThrow(new Exception());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> idGenerationServiceImpl.findNextId("Id Type", 3L));
    verify(idGenerationDao).findNextId("Id Type", 3L);
  }

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String, Long)} with {@code idType}, {@code
   * batchSize}.
   *
   * <ul>
   *   <li>Then throw {@link OptimisticLockException}.
   * </ul>
   *
   * <p>Method under test: {@link IdGenerationServiceImpl#findNextId(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String, Long)"})
  public void testFindNextIdWithIdTypeBatchSize_thenThrowOptimisticLockException()
      throws Exception {
    // Arrange
    IdGeneration idGeneration = mock(IdGeneration.class);
    when(idGeneration.getBatchStart()).thenThrow(new OptimisticLockException());
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(idGeneration);

    // Act and Assert
    assertThrows(
        OptimisticLockException.class, () -> idGenerationServiceImpl.findNextId("Id Type", 3L));
    verify(idGenerationDao).findNextId("Id Type", 3L);
    verify(idGeneration).getBatchStart();
  }

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String)} with {@code idType}.
   *
   * <ul>
   *   <li>Given {@link IdGenerationDao} {@link IdGenerationDao#findNextId(String, Long)} throw
   *       {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link IdGenerationServiceImpl#findNextId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String)"})
  public void testFindNextIdWithIdType_givenIdGenerationDaoFindNextIdThrowException()
      throws Exception {
    // Arrange
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any()))
        .thenThrow(new Exception());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> idGenerationServiceImpl.findNextId("Id Type"));
    verify(idGenerationDao).findNextId(eq("Id Type"), isNull());
  }

  /**
   * Test {@link IdGenerationServiceImpl#findNextId(String)} with {@code idType}.
   *
   * <ul>
   *   <li>Then throw {@link OptimisticLockException}.
   * </ul>
   *
   * <p>Method under test: {@link IdGenerationServiceImpl#findNextId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long IdGenerationServiceImpl.findNextId(String)"})
  public void testFindNextIdWithIdType_thenThrowOptimisticLockException() throws Exception {
    // Arrange
    IdGeneration idGeneration = mock(IdGeneration.class);
    when(idGeneration.getBatchStart()).thenThrow(new OptimisticLockException());
    when(idGenerationDao.findNextId(Mockito.<String>any(), Mockito.<Long>any()))
        .thenReturn(idGeneration);

    // Act and Assert
    assertThrows(
        OptimisticLockException.class, () -> idGenerationServiceImpl.findNextId("Id Type"));
    verify(idGenerationDao).findNextId(eq("Id Type"), isNull());
    verify(idGeneration).getBatchStart();
  }
}
