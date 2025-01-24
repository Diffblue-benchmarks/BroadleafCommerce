package org.broadleafcommerce.core.store.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ZipCodeImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ZipCodeImpl}
   *   <li>{@link ZipCodeImpl#setId(String)}
   *   <li>{@link ZipCodeImpl#setZipCity(String)}
   *   <li>{@link ZipCodeImpl#setZipLatitude(double)}
   *   <li>{@link ZipCodeImpl#setZipLongitude(double)}
   *   <li>{@link ZipCodeImpl#setZipState(String)}
   *   <li>{@link ZipCodeImpl#setZipcode(Integer)}
   *   <li>{@link ZipCodeImpl#getId()}
   *   <li>{@link ZipCodeImpl#getZipCity()}
   *   <li>{@link ZipCodeImpl#getZipLatitude()}
   *   <li>{@link ZipCodeImpl#getZipLongitude()}
   *   <li>{@link ZipCodeImpl#getZipState()}
   *   <li>{@link ZipCodeImpl#getZipcode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ZipCodeImpl actualZipCodeImpl = new ZipCodeImpl();
    actualZipCodeImpl.setId("42");
    actualZipCodeImpl.setZipCity("21654");
    actualZipCodeImpl.setZipLatitude(10.0d);
    actualZipCodeImpl.setZipLongitude(10.0d);
    actualZipCodeImpl.setZipState("21654");
    actualZipCodeImpl.setZipcode(1);
    String actualId = actualZipCodeImpl.getId();
    String actualZipCity = actualZipCodeImpl.getZipCity();
    double actualZipLatitude = actualZipCodeImpl.getZipLatitude();
    double actualZipLongitude = actualZipCodeImpl.getZipLongitude();
    String actualZipState = actualZipCodeImpl.getZipState();

    // Assert that nothing has changed
    assertEquals("21654", actualZipCity);
    assertEquals("21654", actualZipState);
    assertEquals("42", actualId);
    assertEquals(1, actualZipCodeImpl.getZipcode().intValue());
    assertEquals(10.0d, actualZipLatitude, 0.0);
    assertEquals(10.0d, actualZipLongitude, 0.0);
  }
}
