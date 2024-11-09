/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.email.service.info;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ServerInfoDiffblueTest {
  /**
   * Test {@link ServerInfo#getSecureHost()}.
   * <ul>
   *   <li>Given {@link ServerInfo} (default constructor) SecurePort is
   * {@code 8080}.</li>
   *   <li>Then return {@code null:8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerInfo#getSecureHost()}
   */
  @Test
  public void testGetSecureHost_givenServerInfoSecurePortIs8080_thenReturnNull8080() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ServerInfo serverInfo = new ServerInfo();
    serverInfo.setSecurePort(8080);

    // Act and Assert
    assertEquals("null:8080", serverInfo.getSecureHost());
  }

  /**
   * Test {@link ServerInfo#getSecureHost()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerInfo#getSecureHost()}
   */
  @Test
  public void testGetSecureHost_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ServerInfo serverInfo = new ServerInfo();
    serverInfo.setSecurePort(443);

    // Act and Assert
    assertEquals("null", serverInfo.getSecureHost());
  }

  /**
   * Test {@link ServerInfo#getHost()}.
   * <ul>
   *   <li>Given {@link ServerInfo} (default constructor) ServerPort is
   * {@code 8080}.</li>
   *   <li>Then return {@code null:8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerInfo#getHost()}
   */
  @Test
  public void testGetHost_givenServerInfoServerPortIs8080_thenReturnNull8080() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ServerInfo serverInfo = new ServerInfo();
    serverInfo.setServerPort(8080);

    // Act and Assert
    assertEquals("null:8080", serverInfo.getHost());
  }

  /**
   * Test {@link ServerInfo#getHost()}.
   * <ul>
   *   <li>Given {@link ServerInfo} (default constructor) ServerPort is eighty.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerInfo#getHost()}
   */
  @Test
  public void testGetHost_givenServerInfoServerPortIsEighty_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ServerInfo serverInfo = new ServerInfo();
    serverInfo.setServerPort(80);

    // Act and Assert
    assertEquals("null", serverInfo.getHost());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ServerInfo}
   *   <li>{@link ServerInfo#setAppName(String)}
   *   <li>{@link ServerInfo#setSecurePort(Integer)}
   *   <li>{@link ServerInfo#setServerName(String)}
   *   <li>{@link ServerInfo#setServerPort(Integer)}
   *   <li>{@link ServerInfo#getAppName()}
   *   <li>{@link ServerInfo#getSecurePort()}
   *   <li>{@link ServerInfo#getServerName()}
   *   <li>{@link ServerInfo#getServerPort()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ServerInfo actualServerInfo = new ServerInfo();
    actualServerInfo.setAppName("App Name");
    actualServerInfo.setSecurePort(8080);
    actualServerInfo.setServerName("Server Name");
    actualServerInfo.setServerPort(8080);
    String actualAppName = actualServerInfo.getAppName();
    Integer actualSecurePort = actualServerInfo.getSecurePort();
    String actualServerName = actualServerInfo.getServerName();
    Integer actualServerPort = actualServerInfo.getServerPort();

    // Assert that nothing has changed
    assertEquals("App Name", actualAppName);
    assertEquals("Server Name", actualServerName);
    assertEquals(8080, actualSecurePort.intValue());
    assertEquals(8080, actualServerPort.intValue());
  }
}
