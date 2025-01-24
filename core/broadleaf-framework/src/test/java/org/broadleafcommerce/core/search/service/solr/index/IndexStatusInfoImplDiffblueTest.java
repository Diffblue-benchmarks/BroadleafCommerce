package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class IndexStatusInfoImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexStatusInfoImpl}
   *   <li>{@link IndexStatusInfoImpl#setAdditionalInfo(Map)}
   *   <li>{@link IndexStatusInfoImpl#setDeadIndexEvents(Map)}
   *   <li>{@link IndexStatusInfoImpl#setIndexErrors(Map)}
   *   <li>{@link IndexStatusInfoImpl#setLastIndexDate(Date)}
   *   <li>{@link IndexStatusInfoImpl#getAdditionalInfo()}
   *   <li>{@link IndexStatusInfoImpl#getDeadIndexEvents()}
   *   <li>{@link IndexStatusInfoImpl#getIndexErrors()}
   *   <li>{@link IndexStatusInfoImpl#getLastIndexDate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexStatusInfoImpl actualIndexStatusInfoImpl = new IndexStatusInfoImpl();
    HashMap<String, String> additionalInfo = new HashMap<>();
    actualIndexStatusInfoImpl.setAdditionalInfo(additionalInfo);
    HashMap<Long, Date> deadIndexEvents = new HashMap<>();
    actualIndexStatusInfoImpl.setDeadIndexEvents(deadIndexEvents);
    HashMap<Long, Integer> indexErrors = new HashMap<>();
    actualIndexStatusInfoImpl.setIndexErrors(indexErrors);
    Date lastIndexDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualIndexStatusInfoImpl.setLastIndexDate(lastIndexDate);
    Map<String, String> actualAdditionalInfo = actualIndexStatusInfoImpl.getAdditionalInfo();
    Map<Long, Date> actualDeadIndexEvents = actualIndexStatusInfoImpl.getDeadIndexEvents();
    Map<Long, Integer> actualIndexErrors = actualIndexStatusInfoImpl.getIndexErrors();
    Date actualLastIndexDate = actualIndexStatusInfoImpl.getLastIndexDate();

    // Assert that nothing has changed
    assertTrue(actualAdditionalInfo.isEmpty());
    assertTrue(actualDeadIndexEvents.isEmpty());
    assertTrue(actualIndexErrors.isEmpty());
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(deadIndexEvents, actualDeadIndexEvents);
    assertSame(indexErrors, actualIndexErrors);
    assertSame(lastIndexDate, actualLastIndexDate);
  }
}
