package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.inventory.service.ContextualInventoryService;
import org.broadleafcommerce.core.inventory.service.InventoryUnavailableException;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DecrementInventoryRollbackHandlerDiffblueTest {
  @Mock private ContextualInventoryService contextualInventoryService;

  @InjectMocks private DecrementInventoryRollbackHandler decrementInventoryRollbackHandler;

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState() throws RollbackFailureException {
    // Arrange
    doThrow(new RuntimeException())
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, new HashMap<>());
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertThrows(
        RollbackFailureException.class,
        () ->
            decrementInventoryRollbackHandler.rollbackState(
                activity, processContext, stateConfiguration));
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState2() throws InventoryUnavailableException, RollbackFailureException {
    // Arrange
    doThrow(
            new InventoryUnavailableException(
                DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED))
        .when(contextualInventoryService)
        .decrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    doNothing()
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<Object, Object> objectObjectMap2 = new HashMap<>();
    objectObjectMap2.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, objectObjectMap2);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertThrows(
        RollbackFailureException.class,
        () ->
            decrementInventoryRollbackHandler.rollbackState(
                activity, processContext, stateConfiguration));
    verify(contextualInventoryService).decrementInventory(isA(Map.class), isA(Map.class));
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState3() throws InventoryUnavailableException, RollbackFailureException {
    // Arrange
    doThrow(new RuntimeException())
        .when(contextualInventoryService)
        .decrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    doNothing()
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<Object, Object> objectObjectMap2 = new HashMap<>();
    objectObjectMap2.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, objectObjectMap2);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertThrows(
        RollbackFailureException.class,
        () ->
            decrementInventoryRollbackHandler.rollbackState(
                activity, processContext, stateConfiguration));
    verify(contextualInventoryService).decrementInventory(isA(Map.class), isA(Map.class));
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState4() throws InventoryUnavailableException, RollbackFailureException {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .decrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    doNothing()
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<Object, Object> objectObjectMap2 = new HashMap<>();
    objectObjectMap2.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED,
        "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, objectObjectMap2);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, stateConfiguration);

    // Assert
    verify(contextualInventoryService).decrementInventory(isA(Map.class), isA(Map.class));
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@link CheckoutSeed#CheckoutSeed(Order, Map)} with order is {@code null} and
   *       userDefinedFields is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_givenCheckoutSeedWithOrderIsNullAndUserDefinedFieldsIsHashMap()
      throws InventoryUnavailableException, RollbackFailureException {
    // Arrange
    doThrow(new RuntimeException())
        .when(contextualInventoryService)
        .decrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    doNothing()
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    CheckoutSeed checkoutSeed = new CheckoutSeed(null, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<Object, Object> objectObjectMap2 = new HashMap<>();
    objectObjectMap2.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, objectObjectMap2);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertThrows(
        RollbackFailureException.class,
        () ->
            decrementInventoryRollbackHandler.rollbackState(
                activity, processContext, stateConfiguration));
    verify(contextualInventoryService).decrementInventory(isA(Map.class), isA(Map.class));
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@link ContextualInventoryService} {@link
   *       ContextualInventoryService#decrementInventory(Map, Map)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_givenContextualInventoryServiceDecrementInventoryDoesNothing()
      throws InventoryUnavailableException, RollbackFailureException {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .decrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    doNothing()
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<Object, Object> objectObjectMap2 = new HashMap<>();
    objectObjectMap2.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, objectObjectMap2);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, stateConfiguration);

    // Assert
    verify(contextualInventoryService).decrementInventory(isA(Map.class), isA(Map.class));
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@link ContextualInventoryService} {@link
   *       ContextualInventoryService#incrementInventory(Map, Map)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_givenContextualInventoryServiceIncrementInventoryDoesNothing()
      throws RollbackFailureException {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<Object, Object> objectObjectMap2 = new HashMap<>();
    objectObjectMap2.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap2);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, stateConfiguration);

    // Assert
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link ContextualInventoryService#incrementInventory(Map, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_givenHashMap_thenCallsIncrementInventory()
      throws RollbackFailureException {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .incrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, new HashMap<>());
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, stateConfiguration);

    // Assert
    verify(contextualInventoryService).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_givenHashMap_thenDoesNotThrow() throws RollbackFailureException {
    // Arrange
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, new HashMap<>());
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, new HashMap<>());
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, stateConfiguration);
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@code (Not Known)}.
   *   <li>When {@link HashMap#HashMap()} {@code (Not Known)} is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_givenNotKnown_whenHashMapNotKnownIsHashMap()
      throws InventoryUnavailableException, RollbackFailureException {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .decrementInventory(Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any());
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<Object, Object> objectObjectMap2 = new HashMap<>();
    objectObjectMap2.put("42", "42");

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_ORDER_ID, "State Configuration");
    stateConfiguration.put("(Not Known)", objectObjectMap);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, objectObjectMap2);
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, stateConfiguration);

    // Assert
    verify(contextualInventoryService).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_whenDefaultProcessContextImpl_thenDoesNotThrow()
      throws RollbackFailureException {
    // Arrange
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act and Assert
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, new HashMap<>());
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecrementInventoryRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_whenNull_thenDoesNotThrow() throws RollbackFailureException {
    // Arrange
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    // Act and Assert
    decrementInventoryRollbackHandler.rollbackState(activity, processContext, null);
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code State Configuration}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#shouldExecute(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DecrementInventoryRollbackHandler.shouldExecute(Activity, ProcessContext, Map)"
  })
  public void testShouldExecute_givenFoo_whenHashMapFooIsStateConfiguration_thenReturnTrue() {
    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler =
        new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put("foo", "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED,
        "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertTrue(
        decrementInventoryRollbackHandler.shouldExecute(
            activity, processContext, stateConfiguration));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code State Configuration}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#shouldExecute(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DecrementInventoryRollbackHandler.shouldExecute(Activity, ProcessContext, Map)"
  })
  public void testShouldExecute_givenFoo_whenHashMapFooIsStateConfiguration_thenReturnTrue2() {
    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler =
        new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put("foo", "State Configuration");
    stateConfiguration.put("foo", "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertTrue(
        decrementInventoryRollbackHandler.shouldExecute(
            activity, processContext, stateConfiguration));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@link DecrementInventoryRollbackHandler#ROLLBACK_BLC_INVENTORY_DECREMENTED}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#shouldExecute(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DecrementInventoryRollbackHandler.shouldExecute(Activity, ProcessContext, Map)"
  })
  public void testShouldExecute_givenRollback_blc_inventory_decremented() {
    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler =
        new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED,
        "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED,
        "State Configuration");
    stateConfiguration.put(
        DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertTrue(
        decrementInventoryRollbackHandler.shouldExecute(
            activity, processContext, stateConfiguration));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#shouldExecute(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DecrementInventoryRollbackHandler.shouldExecute(Activity, ProcessContext, Map)"
  })
  public void testShouldExecute_whenHashMap_thenReturnFalse() {
    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler =
        new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertFalse(
        decrementInventoryRollbackHandler.shouldExecute(activity, processContext, new HashMap<>()));
  }

  /**
   * Test {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DecrementInventoryRollbackHandler#shouldExecute(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DecrementInventoryRollbackHandler.shouldExecute(Activity, ProcessContext, Map)"
  })
  public void testShouldExecute_whenNull_thenReturnFalse() {
    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler =
        new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    // Act and Assert
    assertFalse(
        decrementInventoryRollbackHandler.shouldExecute(
            activity, new DefaultProcessContextImpl<>(), null));
  }
}
