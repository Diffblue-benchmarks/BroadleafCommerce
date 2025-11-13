package org.broadleafcommerce.openadmin.weave;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.openadmin.audit.AdminAuditable;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WeaveAdminAuditableDiffblueTest {
  /**
   * Test {@link WeaveAdminAuditable#getCreatedBy()}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#getCreatedBy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long WeaveAdminAuditable.getCreatedBy()"})
  public void testGetCreatedBy() {
    // Arrange, Act and Assert
    assertNull(new WeaveAdminAuditable().getCreatedBy());
  }

  /**
   * Test {@link WeaveAdminAuditable#getDateCreated()}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#getDateCreated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date WeaveAdminAuditable.getDateCreated()"})
  public void testGetDateCreated() {
    // Arrange, Act and Assert
    assertNull(new WeaveAdminAuditable().getDateCreated());
  }

  /**
   * Test {@link WeaveAdminAuditable#getDateUpdated()}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#getDateUpdated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date WeaveAdminAuditable.getDateUpdated()"})
  public void testGetDateUpdated() {
    // Arrange, Act and Assert
    assertNull(new WeaveAdminAuditable().getDateUpdated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setDateCreated(Date)}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#setDateCreated(Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveAdminAuditable.setDateCreated(Date)"})
  public void testSetDateCreated() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();
    Date dateCreated =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    weaveAdminAuditable.setDateCreated(dateCreated);

    // Assert
    assertSame(dateCreated, weaveAdminAuditable.auditable.getDateCreated());
    assertSame(dateCreated, weaveAdminAuditable.getDateCreated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setDateUpdated(Date)}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#setDateUpdated(Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveAdminAuditable.setDateUpdated(Date)"})
  public void testSetDateUpdated() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();
    Date dateUpdated =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    weaveAdminAuditable.setDateUpdated(dateUpdated);

    // Assert
    assertSame(dateUpdated, weaveAdminAuditable.auditable.getDateUpdated());
    assertSame(dateUpdated, weaveAdminAuditable.getDateUpdated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setCreatedBy(Long)}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#setCreatedBy(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveAdminAuditable.setCreatedBy(Long)"})
  public void testSetCreatedBy() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();

    // Act
    weaveAdminAuditable.setCreatedBy(1L);

    // Assert
    assertEquals(1L, weaveAdminAuditable.auditable.getCreatedBy().longValue());
    assertEquals(1L, weaveAdminAuditable.getCreatedBy().longValue());
  }

  /**
   * Test {@link WeaveAdminAuditable#getUpdatedBy()}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#getUpdatedBy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long WeaveAdminAuditable.getUpdatedBy()"})
  public void testGetUpdatedBy() {
    // Arrange, Act and Assert
    assertNull(new WeaveAdminAuditable().getUpdatedBy());
  }

  /**
   * Test {@link WeaveAdminAuditable#setUpdatedBy(Long)}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#setUpdatedBy(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveAdminAuditable.setUpdatedBy(Long)"})
  public void testSetUpdatedBy() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();

    // Act
    weaveAdminAuditable.setUpdatedBy(1L);

    // Assert
    assertEquals(1L, weaveAdminAuditable.auditable.getUpdatedBy().longValue());
    assertEquals(1L, weaveAdminAuditable.getUpdatedBy().longValue());
  }

  /**
   * Test {@link WeaveAdminAuditable#getEmbeddableAdminAuditable(boolean)}.
   *
   * <p>Method under test: {@link WeaveAdminAuditable#getEmbeddableAdminAuditable(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminAuditable WeaveAdminAuditable.getEmbeddableAdminAuditable(boolean)"})
  public void testGetEmbeddableAdminAuditable() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();

    // Act
    AdminAuditable actualEmbeddableAdminAuditable =
        weaveAdminAuditable.getEmbeddableAdminAuditable(true);

    // Assert
    assertSame(weaveAdminAuditable.auditable, actualEmbeddableAdminAuditable);
  }

  /**
   * Test new {@link WeaveAdminAuditable} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link WeaveAdminAuditable}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveAdminAuditable.<init>()"})
  public void testNewWeaveAdminAuditable() {
    // Arrange and Act
    WeaveAdminAuditable actualWeaveAdminAuditable = new WeaveAdminAuditable();

    // Assert
    AdminAuditable adminAuditable = actualWeaveAdminAuditable.auditable;
    assertNull(adminAuditable.getCreatedBy());
    assertNull(adminAuditable.getUpdatedBy());
    assertNull(actualWeaveAdminAuditable.getCreatedBy());
    assertNull(actualWeaveAdminAuditable.getUpdatedBy());
    assertNull(adminAuditable.getDateCreated());
    assertNull(adminAuditable.getDateUpdated());
    assertNull(actualWeaveAdminAuditable.getDateCreated());
    assertNull(actualWeaveAdminAuditable.getDateUpdated());
  }
}
