package org.broadleafcommerce.openadmin.dto.override;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.UnspecifiedBooleanType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldMetadataOverrideDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldMetadataOverride#setAddFriendlyName(String)}
   *   <li>{@link FieldMetadataOverride#setAddMethodType(AddMethodType)}
   *   <li>{@link FieldMetadataOverride#setAddType(OperationType)}
   *   <li>{@link FieldMetadataOverride#setAdornedTargetAddMethodType(AdornedTargetAddMethodType)}
   *   <li>{@link FieldMetadataOverride#setAllowNoValueEnumOption(Boolean)}
   *   <li>{@link FieldMetadataOverride#setAssociatedFieldName(String)}
   *   <li>{@link FieldMetadataOverride#setBroadleafEnumeration(String)}
   *   <li>{@link FieldMetadataOverride#setCanLinkToExternalEntity(Boolean)}
   *   <li>{@link FieldMetadataOverride#setColumnWidth(String)}
   *   <li>{@link FieldMetadataOverride#setCurrencyCodeField(String)}
   *   <li>{@link FieldMetadataOverride#setCustomCriteria(String[])}
   *   <li>{@link FieldMetadataOverride#setDeleteEntityUponRemove(Boolean)}
   *   <li>{@link FieldMetadataOverride#setDerived(Boolean)}
   *   <li>{@link FieldMetadataOverride#setDisplayType(RuleBuilderDisplayType)}
   *   <li>{@link FieldMetadataOverride#setEnableTypeaheadLookup(Boolean)}
   *   <li>{@link FieldMetadataOverride#setEnumerationClass(String)}
   *   <li>{@link FieldMetadataOverride#setEnumerationValues(String[][])}
   *   <li>{@link FieldMetadataOverride#setExcluded(Boolean)}
   *   <li>{@link FieldMetadataOverride#setExplicitFieldType(SupportedFieldType)}
   *   <li>{@link FieldMetadataOverride#setFetchType(OperationType)}
   *   <li>{@link FieldMetadataOverride#setFieldComponentRenderer(SupportedFieldType)}
   *   <li>{@link FieldMetadataOverride#setFieldComponentRendererTemplate(String)}
   *   <li>{@link FieldMetadataOverride#setFieldType(SupportedFieldType)}
   *   <li>{@link FieldMetadataOverride#setForceFreeFormKeys(Boolean)}
   *   <li>{@link FieldMetadataOverride#setForcePopulateChildProperties(Boolean)}
   *   <li>{@link FieldMetadataOverride#setForeignKeyClass(String)}
   *   <li>{@link FieldMetadataOverride#setForeignKeyCollection(Boolean)}
   *   <li>{@link FieldMetadataOverride#setForeignKeyDisplayValueProperty(String)}
   *   <li>{@link FieldMetadataOverride#setForeignKeyProperty(String)}
   *   <li>{@link FieldMetadataOverride#setFriendlyName(String)}
   *   <li>{@link FieldMetadataOverride#setGridFieldComponentRenderer(SupportedFieldType)}
   *   <li>{@link FieldMetadataOverride#setGridFieldComponentRendererTemplate(String)}
   *   <li>{@link FieldMetadataOverride#setGridOrder(Integer)}
   *   <li>{@link FieldMetadataOverride#setGridVisibleFields(String[])}
   *   <li>{@link FieldMetadataOverride#setGroup(String)}
   *   <li>{@link FieldMetadataOverride#setGroupCollapsed(Boolean)}
   *   <li>{@link FieldMetadataOverride#setGroupOrder(Integer)}
   *   <li>{@link FieldMetadataOverride#setHelpText(String)}
   *   <li>{@link FieldMetadataOverride#setHideEnumerationIfEmpty(Boolean)}
   *   <li>{@link FieldMetadataOverride#setHint(String)}
   *   <li>{@link FieldMetadataOverride#setIgnoreAdornedProperties(Boolean)}
   *   <li>{@link FieldMetadataOverride#setInspectType(OperationType)}
   *   <li>{@link FieldMetadataOverride#setJoinEntityClass(String)}
   *   <li>{@link FieldMetadataOverride#setKeyClass(String)}
   *   <li>{@link FieldMetadataOverride#setKeyPropertyFriendlyName(String)}
   *   <li>{@link FieldMetadataOverride#setKeys(String[][])}
   *   <li>{@link FieldMetadataOverride#setLargeEntry(Boolean)}
   *   <li>{@link FieldMetadataOverride#setLazyFetch(Boolean)}
   *   <li>{@link FieldMetadataOverride#setLength(Integer)}
   *   <li>{@link FieldMetadataOverride#setLookupDisplayProperty(String)}
   *   <li>{@link FieldMetadataOverride#setLookupType(LookupType)}
   *   <li>{@link FieldMetadataOverride#setMaintainedAdornedTargetFields(String[])}
   *   <li>{@link FieldMetadataOverride#setManualFetch(Boolean)}
   *   <li>{@link FieldMetadataOverride#setManyToField(String)}
   *   <li>{@link FieldMetadataOverride#setMapFieldValueClass(String)}
   *   <li>{@link FieldMetadataOverride#setMapKeyOptionEntityClass(String)}
   *   <li>{@link FieldMetadataOverride#setMapKeyOptionEntityDisplayField(String)}
   *   <li>{@link FieldMetadataOverride#setMapKeyOptionEntityValueField(String)}
   *   <li>{@link FieldMetadataOverride#setMapKeyValueProperty(String)}
   *   <li>{@link FieldMetadataOverride#setMediaField(String)}
   *   <li>{@link FieldMetadataOverride#setMergedPropertyType(MergedPropertyType)}
   *   <li>{@link FieldMetadataOverride#setName(String)}
   *   <li>{@link FieldMetadataOverride#setOptionCanEditValues(Boolean)}
   *   <li>{@link FieldMetadataOverride#setOptionDisplayFieldName(String)}
   *   <li>{@link FieldMetadataOverride#setOptionFilterValues(Serializable[][])}
   *   <li>{@link FieldMetadataOverride#setOptionListEntity(String)}
   *   <li>{@link FieldMetadataOverride#setOptionValueFieldName(String)}
   *   <li>{@link FieldMetadataOverride#setParentObjectIdProperty(String)}
   *   <li>{@link FieldMetadataOverride#setParentObjectProperty(String)}
   *   <li>{@link FieldMetadataOverride#setPrecision(Integer)}
   *   <li>{@link FieldMetadataOverride#setProminent(Boolean)}
   *   <li>{@link FieldMetadataOverride#setReadOnly(Boolean)}
   *   <li>{@link FieldMetadataOverride#setRemoveType(OperationType)}
   *   <li>{@link FieldMetadataOverride#setRequired(Boolean)}
   *   <li>{@link FieldMetadataOverride#setRequiredOverride(Boolean)}
   *   <li>{@link FieldMetadataOverride#setRuleIdentifier(String)}
   *   <li>{@link FieldMetadataOverride#setScale(Integer)}
   *   <li>{@link FieldMetadataOverride#setSearchable(Boolean)}
   *   <li>{@link FieldMetadataOverride#setSecondaryType(SupportedFieldType)}
   *   <li>{@link FieldMetadataOverride#setSecurityLevel(String)}
   *   <li>{@link FieldMetadataOverride#setSelectizeVisibleField(String)}
   *   <li>{@link FieldMetadataOverride#setShowIfFieldEquals(Map)}
   *   <li>{@link FieldMetadataOverride#setShowIfProperty(String)}
   *   <li>{@link FieldMetadataOverride#setSimpleValue(UnspecifiedBooleanType)}
   *   <li>{@link FieldMetadataOverride#setSortAscending(Boolean)}
   *   <li>{@link FieldMetadataOverride#setSortProperty(String)}
   *   <li>{@link FieldMetadataOverride#setTab(String)}
   *   <li>{@link FieldMetadataOverride#setTabOrder(Integer)}
   *   <li>{@link FieldMetadataOverride#setTargetObjectIdProperty(String)}
   *   <li>{@link FieldMetadataOverride#setTargetObjectProperty(String)}
   *   <li>{@link FieldMetadataOverride#setToOneLookupCreatedViaAnnotation(Boolean)}
   *   <li>{@link FieldMetadataOverride#setToOneParentProperty(String)}
   *   <li>{@link FieldMetadataOverride#setToOneTargetProperty(String)}
   *   <li>{@link FieldMetadataOverride#setTooltip(String)}
   *   <li>{@link FieldMetadataOverride#setTranslatable(Boolean)}
   *   <li>{@link FieldMetadataOverride#setUnique(Boolean)}
   *   <li>{@link FieldMetadataOverride#setUpdateType(OperationType)}
   *   <li>{@link FieldMetadataOverride#setUseServerSideInspectionCache(Boolean)}
   *   <li>{@link FieldMetadataOverride#setValidationConfigurations(Map)}
   *   <li>{@link FieldMetadataOverride#setValueClass(String)}
   *   <li>{@link FieldMetadataOverride#setValuePropertyFriendlyName(String)}
   *   <li>{@link FieldMetadataOverride#setVisibility(VisibilityEnum)}
   *   <li>{@link FieldMetadataOverride#getAddFriendlyName()}
   *   <li>{@link FieldMetadataOverride#getAddMethodType()}
   *   <li>{@link FieldMetadataOverride#getAddType()}
   *   <li>{@link FieldMetadataOverride#getAdornedTargetAddMethodType()}
   *   <li>{@link FieldMetadataOverride#getAllowNoValueEnumOption()}
   *   <li>{@link FieldMetadataOverride#getAssociatedFieldName()}
   *   <li>{@link FieldMetadataOverride#getBroadleafEnumeration()}
   *   <li>{@link FieldMetadataOverride#getCanLinkToExternalEntity()}
   *   <li>{@link FieldMetadataOverride#getColumnWidth()}
   *   <li>{@link FieldMetadataOverride#getCurrencyCodeField()}
   *   <li>{@link FieldMetadataOverride#getCustomCriteria()}
   *   <li>{@link FieldMetadataOverride#getDefaultValue()}
   *   <li>{@link FieldMetadataOverride#getDisplayType()}
   *   <li>{@link FieldMetadataOverride#getEnableTypeaheadLookup()}
   *   <li>{@link FieldMetadataOverride#getEnumerationClass()}
   *   <li>{@link FieldMetadataOverride#getEnumerationValues()}
   *   <li>{@link FieldMetadataOverride#getExcluded()}
   *   <li>{@link FieldMetadataOverride#getExplicitFieldType()}
   *   <li>{@link FieldMetadataOverride#getFetchType()}
   *   <li>{@link FieldMetadataOverride#getFieldComponentRenderer()}
   *   <li>{@link FieldMetadataOverride#getFieldComponentRendererTemplate()}
   *   <li>{@link FieldMetadataOverride#getFieldType()}
   *   <li>{@link FieldMetadataOverride#getForceFreeFormKeys()}
   *   <li>{@link FieldMetadataOverride#getForcePopulateChildProperties()}
   *   <li>{@link FieldMetadataOverride#getForeignKeyClass()}
   *   <li>{@link FieldMetadataOverride#getForeignKeyCollection()}
   *   <li>{@link FieldMetadataOverride#getForeignKeyDisplayValueProperty()}
   *   <li>{@link FieldMetadataOverride#getForeignKeyProperty()}
   *   <li>{@link FieldMetadataOverride#getFriendlyName()}
   *   <li>{@link FieldMetadataOverride#getGridFieldComponentRenderer()}
   *   <li>{@link FieldMetadataOverride#getGridFieldComponentRendererTemplate()}
   *   <li>{@link FieldMetadataOverride#getGridOrder()}
   *   <li>{@link FieldMetadataOverride#getGridVisibleFields()}
   *   <li>{@link FieldMetadataOverride#getGroup()}
   *   <li>{@link FieldMetadataOverride#getGroupCollapsed()}
   *   <li>{@link FieldMetadataOverride#getGroupOrder()}
   *   <li>{@link FieldMetadataOverride#getHelpText()}
   *   <li>{@link FieldMetadataOverride#getHideEnumerationIfEmpty()}
   *   <li>{@link FieldMetadataOverride#getHint()}
   *   <li>{@link FieldMetadataOverride#getInspectType()}
   *   <li>{@link FieldMetadataOverride#getIsDerived()}
   *   <li>{@link FieldMetadataOverride#getJoinEntityClass()}
   *   <li>{@link FieldMetadataOverride#getKeyClass()}
   *   <li>{@link FieldMetadataOverride#getKeyPropertyFriendlyName()}
   *   <li>{@link FieldMetadataOverride#getKeys()}
   *   <li>{@link FieldMetadataOverride#getLazyFetch()}
   *   <li>{@link FieldMetadataOverride#getLength()}
   *   <li>{@link FieldMetadataOverride#getLookupDisplayProperty()}
   *   <li>{@link FieldMetadataOverride#getLookupType()}
   *   <li>{@link FieldMetadataOverride#getMaintainedAdornedTargetFields()}
   *   <li>{@link FieldMetadataOverride#getManualFetch()}
   *   <li>{@link FieldMetadataOverride#getManyToField()}
   *   <li>{@link FieldMetadataOverride#getMapFieldValueClass()}
   *   <li>{@link FieldMetadataOverride#getMapKeyOptionEntityClass()}
   *   <li>{@link FieldMetadataOverride#getMapKeyOptionEntityDisplayField()}
   *   <li>{@link FieldMetadataOverride#getMapKeyOptionEntityValueField()}
   *   <li>{@link FieldMetadataOverride#getMapKeyValueProperty()}
   *   <li>{@link FieldMetadataOverride#getMediaField()}
   *   <li>{@link FieldMetadataOverride#getMergedPropertyType()}
   *   <li>{@link FieldMetadataOverride#getName()}
   *   <li>{@link FieldMetadataOverride#getOptionCanEditValues()}
   *   <li>{@link FieldMetadataOverride#getOptionDisplayFieldName()}
   *   <li>{@link FieldMetadataOverride#getOptionFilterValues()}
   *   <li>{@link FieldMetadataOverride#getOptionListEntity()}
   *   <li>{@link FieldMetadataOverride#getOptionValueFieldName()}
   *   <li>{@link FieldMetadataOverride#getParentObjectIdProperty()}
   *   <li>{@link FieldMetadataOverride#getParentObjectProperty()}
   *   <li>{@link FieldMetadataOverride#getPrecision()}
   *   <li>{@link FieldMetadataOverride#getReadOnly()}
   *   <li>{@link FieldMetadataOverride#getRemoveType()}
   *   <li>{@link FieldMetadataOverride#getRequired()}
   *   <li>{@link FieldMetadataOverride#getRequiredOverride()}
   *   <li>{@link FieldMetadataOverride#getRuleIdentifier()}
   *   <li>{@link FieldMetadataOverride#getScale()}
   *   <li>{@link FieldMetadataOverride#getSearchable()}
   *   <li>{@link FieldMetadataOverride#getSecondaryType()}
   *   <li>{@link FieldMetadataOverride#getSecurityLevel()}
   *   <li>{@link FieldMetadataOverride#getSelectizeVisibleField()}
   *   <li>{@link FieldMetadataOverride#getShowIfFieldEquals()}
   *   <li>{@link FieldMetadataOverride#getShowIfProperty()}
   *   <li>{@link FieldMetadataOverride#getSimpleValue()}
   *   <li>{@link FieldMetadataOverride#getSortProperty()}
   *   <li>{@link FieldMetadataOverride#getTab()}
   *   <li>{@link FieldMetadataOverride#getTabOrder()}
   *   <li>{@link FieldMetadataOverride#getTargetObjectIdProperty()}
   *   <li>{@link FieldMetadataOverride#getTargetObjectProperty()}
   *   <li>{@link FieldMetadataOverride#getToOneLookupCreatedViaAnnotation()}
   *   <li>{@link FieldMetadataOverride#getToOneParentProperty()}
   *   <li>{@link FieldMetadataOverride#getToOneTargetProperty()}
   *   <li>{@link FieldMetadataOverride#getTooltip()}
   *   <li>{@link FieldMetadataOverride#getTranslatable()}
   *   <li>{@link FieldMetadataOverride#getUnique()}
   *   <li>{@link FieldMetadataOverride#getUpdateType()}
   *   <li>{@link FieldMetadataOverride#getUseServerSideInspectionCache()}
   *   <li>{@link FieldMetadataOverride#getValidationConfigurations()}
   *   <li>{@link FieldMetadataOverride#getValueClass()}
   *   <li>{@link FieldMetadataOverride#getValuePropertyFriendlyName()}
   *   <li>{@link FieldMetadataOverride#getVisibility()}
   *   <li>{@link FieldMetadataOverride#isDeleteEntityUponRemove()}
   *   <li>{@link FieldMetadataOverride#isIgnoreAdornedProperties()}
   *   <li>{@link FieldMetadataOverride#isLargeEntry()}
   *   <li>{@link FieldMetadataOverride#isProminent()}
   *   <li>{@link FieldMetadataOverride#isSortAscending()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FieldMetadataOverride.getAddFriendlyName()",
    "AddMethodType FieldMetadataOverride.getAddMethodType()",
    "OperationType FieldMetadataOverride.getAddType()",
    "AdornedTargetAddMethodType FieldMetadataOverride.getAdornedTargetAddMethodType()",
    "Boolean FieldMetadataOverride.getAllowNoValueEnumOption()",
    "String FieldMetadataOverride.getAssociatedFieldName()",
    "String FieldMetadataOverride.getBroadleafEnumeration()",
    "Boolean FieldMetadataOverride.getCanLinkToExternalEntity()",
    "String FieldMetadataOverride.getColumnWidth()",
    "String FieldMetadataOverride.getCurrencyCodeField()",
    "String[] FieldMetadataOverride.getCustomCriteria()",
    "String FieldMetadataOverride.getDefaultValue()",
    "RuleBuilderDisplayType FieldMetadataOverride.getDisplayType()",
    "Boolean FieldMetadataOverride.getEnableTypeaheadLookup()",
    "String FieldMetadataOverride.getEnumerationClass()",
    "String[][] FieldMetadataOverride.getEnumerationValues()",
    "Boolean FieldMetadataOverride.getExcluded()",
    "SupportedFieldType FieldMetadataOverride.getExplicitFieldType()",
    "OperationType FieldMetadataOverride.getFetchType()",
    "SupportedFieldType FieldMetadataOverride.getFieldComponentRenderer()",
    "String FieldMetadataOverride.getFieldComponentRendererTemplate()",
    "SupportedFieldType FieldMetadataOverride.getFieldType()",
    "Boolean FieldMetadataOverride.getForceFreeFormKeys()",
    "Boolean FieldMetadataOverride.getForcePopulateChildProperties()",
    "String FieldMetadataOverride.getForeignKeyClass()",
    "Boolean FieldMetadataOverride.getForeignKeyCollection()",
    "String FieldMetadataOverride.getForeignKeyDisplayValueProperty()",
    "String FieldMetadataOverride.getForeignKeyProperty()",
    "String FieldMetadataOverride.getFriendlyName()",
    "SupportedFieldType FieldMetadataOverride.getGridFieldComponentRenderer()",
    "String FieldMetadataOverride.getGridFieldComponentRendererTemplate()",
    "Integer FieldMetadataOverride.getGridOrder()",
    "String[] FieldMetadataOverride.getGridVisibleFields()",
    "String FieldMetadataOverride.getGroup()",
    "Boolean FieldMetadataOverride.getGroupCollapsed()",
    "Integer FieldMetadataOverride.getGroupOrder()",
    "String FieldMetadataOverride.getHelpText()",
    "Boolean FieldMetadataOverride.getHideEnumerationIfEmpty()",
    "String FieldMetadataOverride.getHint()",
    "OperationType FieldMetadataOverride.getInspectType()",
    "Boolean FieldMetadataOverride.getIsDerived()",
    "String FieldMetadataOverride.getJoinEntityClass()",
    "String FieldMetadataOverride.getKeyClass()",
    "String FieldMetadataOverride.getKeyPropertyFriendlyName()",
    "String[][] FieldMetadataOverride.getKeys()",
    "Boolean FieldMetadataOverride.getLazyFetch()",
    "Integer FieldMetadataOverride.getLength()",
    "String FieldMetadataOverride.getLookupDisplayProperty()",
    "LookupType FieldMetadataOverride.getLookupType()",
    "String[] FieldMetadataOverride.getMaintainedAdornedTargetFields()",
    "Boolean FieldMetadataOverride.getManualFetch()",
    "String FieldMetadataOverride.getManyToField()",
    "String FieldMetadataOverride.getMapFieldValueClass()",
    "String FieldMetadataOverride.getMapKeyOptionEntityClass()",
    "String FieldMetadataOverride.getMapKeyOptionEntityDisplayField()",
    "String FieldMetadataOverride.getMapKeyOptionEntityValueField()",
    "String FieldMetadataOverride.getMapKeyValueProperty()",
    "String FieldMetadataOverride.getMediaField()",
    "MergedPropertyType FieldMetadataOverride.getMergedPropertyType()",
    "String FieldMetadataOverride.getName()",
    "Boolean FieldMetadataOverride.getOptionCanEditValues()",
    "String FieldMetadataOverride.getOptionDisplayFieldName()",
    "Serializable[][] FieldMetadataOverride.getOptionFilterValues()",
    "String FieldMetadataOverride.getOptionListEntity()",
    "String FieldMetadataOverride.getOptionValueFieldName()",
    "String FieldMetadataOverride.getParentObjectIdProperty()",
    "String FieldMetadataOverride.getParentObjectProperty()",
    "Integer FieldMetadataOverride.getPrecision()",
    "Boolean FieldMetadataOverride.getReadOnly()",
    "OperationType FieldMetadataOverride.getRemoveType()",
    "Boolean FieldMetadataOverride.getRequired()",
    "Boolean FieldMetadataOverride.getRequiredOverride()",
    "String FieldMetadataOverride.getRuleIdentifier()",
    "Integer FieldMetadataOverride.getScale()",
    "Boolean FieldMetadataOverride.getSearchable()",
    "SupportedFieldType FieldMetadataOverride.getSecondaryType()",
    "String FieldMetadataOverride.getSecurityLevel()",
    "String FieldMetadataOverride.getSelectizeVisibleField()",
    "Map FieldMetadataOverride.getShowIfFieldEquals()",
    "String FieldMetadataOverride.getShowIfProperty()",
    "UnspecifiedBooleanType FieldMetadataOverride.getSimpleValue()",
    "String FieldMetadataOverride.getSortProperty()",
    "String FieldMetadataOverride.getTab()",
    "Integer FieldMetadataOverride.getTabOrder()",
    "String FieldMetadataOverride.getTargetObjectIdProperty()",
    "String FieldMetadataOverride.getTargetObjectProperty()",
    "Boolean FieldMetadataOverride.getToOneLookupCreatedViaAnnotation()",
    "String FieldMetadataOverride.getToOneParentProperty()",
    "String FieldMetadataOverride.getToOneTargetProperty()",
    "String FieldMetadataOverride.getTooltip()",
    "Boolean FieldMetadataOverride.getTranslatable()",
    "Boolean FieldMetadataOverride.getUnique()",
    "OperationType FieldMetadataOverride.getUpdateType()",
    "Boolean FieldMetadataOverride.getUseServerSideInspectionCache()",
    "Map FieldMetadataOverride.getValidationConfigurations()",
    "String FieldMetadataOverride.getValueClass()",
    "String FieldMetadataOverride.getValuePropertyFriendlyName()",
    "VisibilityEnum FieldMetadataOverride.getVisibility()",
    "Boolean FieldMetadataOverride.isDeleteEntityUponRemove()",
    "Boolean FieldMetadataOverride.isIgnoreAdornedProperties()",
    "Boolean FieldMetadataOverride.isLargeEntry()",
    "Boolean FieldMetadataOverride.isProminent()",
    "Boolean FieldMetadataOverride.isSortAscending()",
    "void FieldMetadataOverride.setAddFriendlyName(String)",
    "void FieldMetadataOverride.setAddMethodType(AddMethodType)",
    "void FieldMetadataOverride.setAddType(OperationType)",
    "void FieldMetadataOverride.setAdornedTargetAddMethodType(AdornedTargetAddMethodType)",
    "void FieldMetadataOverride.setAllowNoValueEnumOption(Boolean)",
    "void FieldMetadataOverride.setAssociatedFieldName(String)",
    "void FieldMetadataOverride.setBroadleafEnumeration(String)",
    "void FieldMetadataOverride.setCanLinkToExternalEntity(Boolean)",
    "void FieldMetadataOverride.setColumnWidth(String)",
    "void FieldMetadataOverride.setCurrencyCodeField(String)",
    "void FieldMetadataOverride.setCustomCriteria(String[])",
    "void FieldMetadataOverride.setDeleteEntityUponRemove(Boolean)",
    "void FieldMetadataOverride.setDerived(Boolean)",
    "void FieldMetadataOverride.setDisplayType(RuleBuilderDisplayType)",
    "void FieldMetadataOverride.setEnableTypeaheadLookup(Boolean)",
    "void FieldMetadataOverride.setEnumerationClass(String)",
    "void FieldMetadataOverride.setEnumerationValues(String[][])",
    "void FieldMetadataOverride.setExcluded(Boolean)",
    "void FieldMetadataOverride.setExplicitFieldType(SupportedFieldType)",
    "void FieldMetadataOverride.setFetchType(OperationType)",
    "void FieldMetadataOverride.setFieldComponentRenderer(SupportedFieldType)",
    "void FieldMetadataOverride.setFieldComponentRendererTemplate(String)",
    "void FieldMetadataOverride.setFieldType(SupportedFieldType)",
    "void FieldMetadataOverride.setForceFreeFormKeys(Boolean)",
    "void FieldMetadataOverride.setForcePopulateChildProperties(Boolean)",
    "void FieldMetadataOverride.setForeignKeyClass(String)",
    "void FieldMetadataOverride.setForeignKeyCollection(Boolean)",
    "void FieldMetadataOverride.setForeignKeyDisplayValueProperty(String)",
    "void FieldMetadataOverride.setForeignKeyProperty(String)",
    "void FieldMetadataOverride.setFriendlyName(String)",
    "void FieldMetadataOverride.setGridFieldComponentRenderer(SupportedFieldType)",
    "void FieldMetadataOverride.setGridFieldComponentRendererTemplate(String)",
    "void FieldMetadataOverride.setGridOrder(Integer)",
    "void FieldMetadataOverride.setGridVisibleFields(String[])",
    "void FieldMetadataOverride.setGroup(String)",
    "void FieldMetadataOverride.setGroupCollapsed(Boolean)",
    "void FieldMetadataOverride.setGroupOrder(Integer)",
    "void FieldMetadataOverride.setHelpText(String)",
    "void FieldMetadataOverride.setHideEnumerationIfEmpty(Boolean)",
    "void FieldMetadataOverride.setHint(String)",
    "void FieldMetadataOverride.setIgnoreAdornedProperties(Boolean)",
    "void FieldMetadataOverride.setInspectType(OperationType)",
    "void FieldMetadataOverride.setJoinEntityClass(String)",
    "void FieldMetadataOverride.setKeyClass(String)",
    "void FieldMetadataOverride.setKeyPropertyFriendlyName(String)",
    "void FieldMetadataOverride.setKeys(String[][])",
    "void FieldMetadataOverride.setLargeEntry(Boolean)",
    "void FieldMetadataOverride.setLazyFetch(Boolean)",
    "void FieldMetadataOverride.setLength(Integer)",
    "void FieldMetadataOverride.setLookupDisplayProperty(String)",
    "void FieldMetadataOverride.setLookupType(LookupType)",
    "void FieldMetadataOverride.setMaintainedAdornedTargetFields(String[])",
    "void FieldMetadataOverride.setManualFetch(Boolean)",
    "void FieldMetadataOverride.setManyToField(String)",
    "void FieldMetadataOverride.setMapFieldValueClass(String)",
    "void FieldMetadataOverride.setMapKeyOptionEntityClass(String)",
    "void FieldMetadataOverride.setMapKeyOptionEntityDisplayField(String)",
    "void FieldMetadataOverride.setMapKeyOptionEntityValueField(String)",
    "void FieldMetadataOverride.setMapKeyValueProperty(String)",
    "void FieldMetadataOverride.setMediaField(String)",
    "void FieldMetadataOverride.setMergedPropertyType(MergedPropertyType)",
    "void FieldMetadataOverride.setName(String)",
    "void FieldMetadataOverride.setOptionCanEditValues(Boolean)",
    "void FieldMetadataOverride.setOptionDisplayFieldName(String)",
    "void FieldMetadataOverride.setOptionFilterValues(Serializable[][])",
    "void FieldMetadataOverride.setOptionListEntity(String)",
    "void FieldMetadataOverride.setOptionValueFieldName(String)",
    "void FieldMetadataOverride.setParentObjectIdProperty(String)",
    "void FieldMetadataOverride.setParentObjectProperty(String)",
    "void FieldMetadataOverride.setPrecision(Integer)",
    "void FieldMetadataOverride.setProminent(Boolean)",
    "void FieldMetadataOverride.setReadOnly(Boolean)",
    "void FieldMetadataOverride.setRemoveType(OperationType)",
    "void FieldMetadataOverride.setRequired(Boolean)",
    "void FieldMetadataOverride.setRequiredOverride(Boolean)",
    "void FieldMetadataOverride.setRuleIdentifier(String)",
    "void FieldMetadataOverride.setScale(Integer)",
    "void FieldMetadataOverride.setSearchable(Boolean)",
    "void FieldMetadataOverride.setSecondaryType(SupportedFieldType)",
    "void FieldMetadataOverride.setSecurityLevel(String)",
    "void FieldMetadataOverride.setSelectizeVisibleField(String)",
    "void FieldMetadataOverride.setShowIfFieldEquals(Map)",
    "void FieldMetadataOverride.setShowIfProperty(String)",
    "void FieldMetadataOverride.setSimpleValue(UnspecifiedBooleanType)",
    "void FieldMetadataOverride.setSortAscending(Boolean)",
    "void FieldMetadataOverride.setSortProperty(String)",
    "void FieldMetadataOverride.setTab(String)",
    "void FieldMetadataOverride.setTabOrder(Integer)",
    "void FieldMetadataOverride.setTargetObjectIdProperty(String)",
    "void FieldMetadataOverride.setTargetObjectProperty(String)",
    "void FieldMetadataOverride.setToOneLookupCreatedViaAnnotation(Boolean)",
    "void FieldMetadataOverride.setToOneParentProperty(String)",
    "void FieldMetadataOverride.setToOneTargetProperty(String)",
    "void FieldMetadataOverride.setTooltip(String)",
    "void FieldMetadataOverride.setTranslatable(Boolean)",
    "void FieldMetadataOverride.setUnique(Boolean)",
    "void FieldMetadataOverride.setUpdateType(OperationType)",
    "void FieldMetadataOverride.setUseServerSideInspectionCache(Boolean)",
    "void FieldMetadataOverride.setValidationConfigurations(Map)",
    "void FieldMetadataOverride.setValueClass(String)",
    "void FieldMetadataOverride.setValuePropertyFriendlyName(String)",
    "void FieldMetadataOverride.setVisibility(VisibilityEnum)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FieldMetadataOverride fieldMetadataOverride = new FieldMetadataOverride();

    // Act
    fieldMetadataOverride.setAddFriendlyName("Add Friendly Name");
    fieldMetadataOverride.setAddMethodType(AddMethodType.PERSIST);
    fieldMetadataOverride.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    fieldMetadataOverride.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    fieldMetadataOverride.setAllowNoValueEnumOption(true);
    fieldMetadataOverride.setAssociatedFieldName("Associated Field Name");
    fieldMetadataOverride.setBroadleafEnumeration("Broadleaf Enumeration");
    fieldMetadataOverride.setCanLinkToExternalEntity(true);
    fieldMetadataOverride.setColumnWidth("Column Width");
    fieldMetadataOverride.setCurrencyCodeField("GBP");
    String[] customCriteria = new String[] {"Custom Criteria"};
    fieldMetadataOverride.setCustomCriteria(customCriteria);
    fieldMetadataOverride.setDeleteEntityUponRemove(true);
    fieldMetadataOverride.setDerived(true);
    fieldMetadataOverride.setDisplayType(RuleBuilderDisplayType.NORMAL);
    fieldMetadataOverride.setEnableTypeaheadLookup(true);
    fieldMetadataOverride.setEnumerationClass("Enumeration Class");
    String[][] enumerationValues = new String[][] {new String[] {"42"}};
    fieldMetadataOverride.setEnumerationValues(enumerationValues);
    fieldMetadataOverride.setExcluded(true);
    fieldMetadataOverride.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    fieldMetadataOverride.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    fieldMetadataOverride.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    fieldMetadataOverride.setFieldComponentRendererTemplate("Field Component Renderer Template");
    fieldMetadataOverride.setFieldType(SupportedFieldType.UNKNOWN);
    fieldMetadataOverride.setForceFreeFormKeys(true);
    fieldMetadataOverride.setForcePopulateChildProperties(true);
    fieldMetadataOverride.setForeignKeyClass("Foreign Key Class");
    fieldMetadataOverride.setForeignKeyCollection(true);
    fieldMetadataOverride.setForeignKeyDisplayValueProperty("42");
    fieldMetadataOverride.setForeignKeyProperty("Foreign Key Property");
    fieldMetadataOverride.setFriendlyName("Friendly Name");
    fieldMetadataOverride.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    fieldMetadataOverride.setGridFieldComponentRendererTemplate(
        "Grid Field Component Renderer Template");
    fieldMetadataOverride.setGridOrder(1);
    String[] gridVisibleFields = new String[] {"Grid Visible Fields"};
    fieldMetadataOverride.setGridVisibleFields(gridVisibleFields);
    fieldMetadataOverride.setGroup("Group");
    fieldMetadataOverride.setGroupCollapsed(true);
    fieldMetadataOverride.setGroupOrder(1);
    fieldMetadataOverride.setHelpText("Help Text");
    fieldMetadataOverride.setHideEnumerationIfEmpty(true);
    fieldMetadataOverride.setHint("Hint");
    fieldMetadataOverride.setIgnoreAdornedProperties(true);
    fieldMetadataOverride.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    fieldMetadataOverride.setJoinEntityClass("Join Entity Class");
    fieldMetadataOverride.setKeyClass("Key Class");
    fieldMetadataOverride.setKeyPropertyFriendlyName("Key Property Friendly Name");
    String[][] keys = new String[][] {new String[] {"Keys"}};
    fieldMetadataOverride.setKeys(keys);
    fieldMetadataOverride.setLargeEntry(true);
    fieldMetadataOverride.setLazyFetch(true);
    fieldMetadataOverride.setLength(3);
    fieldMetadataOverride.setLookupDisplayProperty("Lookup Display Property");
    fieldMetadataOverride.setLookupType(LookupType.STANDARD);
    String[] maintainedAdornedTargetFields = new String[] {"Maintained Adorned Target Fields"};
    fieldMetadataOverride.setMaintainedAdornedTargetFields(maintainedAdornedTargetFields);
    fieldMetadataOverride.setManualFetch(true);
    fieldMetadataOverride.setManyToField("Many To Field");
    fieldMetadataOverride.setMapFieldValueClass("42");
    fieldMetadataOverride.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    fieldMetadataOverride.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    fieldMetadataOverride.setMapKeyOptionEntityValueField("42");
    fieldMetadataOverride.setMapKeyValueProperty("42");
    fieldMetadataOverride.setMediaField("Media Field");
    fieldMetadataOverride.setMergedPropertyType(MergedPropertyType.PRIMARY);
    fieldMetadataOverride.setName("Name");
    fieldMetadataOverride.setOptionCanEditValues(true);
    fieldMetadataOverride.setOptionDisplayFieldName("Option Display Field Name");
    Serializable[][] optionFilterValues =
        new Serializable[][] {new Serializable[] {new SimpleDateFormat("yyyy/mm/dd")}};
    fieldMetadataOverride.setOptionFilterValues(optionFilterValues);
    fieldMetadataOverride.setOptionListEntity("Option List Entity");
    fieldMetadataOverride.setOptionValueFieldName("42");
    fieldMetadataOverride.setParentObjectIdProperty("Parent Object Id Property");
    fieldMetadataOverride.setParentObjectProperty("Parent Object Property");
    fieldMetadataOverride.setPrecision(1);
    fieldMetadataOverride.setProminent(true);
    fieldMetadataOverride.setReadOnly(true);
    fieldMetadataOverride.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    fieldMetadataOverride.setRequired(true);
    fieldMetadataOverride.setRequiredOverride(true);
    fieldMetadataOverride.setRuleIdentifier("42");
    fieldMetadataOverride.setScale(1);
    fieldMetadataOverride.setSearchable(true);
    fieldMetadataOverride.setSecondaryType(SupportedFieldType.UNKNOWN);
    fieldMetadataOverride.setSecurityLevel("Security Level");
    fieldMetadataOverride.setSelectizeVisibleField("Selectize Visible Field");
    HashMap<String, List<String>> showIfFieldEquals = new HashMap<>();
    fieldMetadataOverride.setShowIfFieldEquals(showIfFieldEquals);
    fieldMetadataOverride.setShowIfProperty("Show If Property");
    fieldMetadataOverride.setSimpleValue(UnspecifiedBooleanType.TRUE);
    fieldMetadataOverride.setSortAscending(true);
    fieldMetadataOverride.setSortProperty("Sort Property");
    fieldMetadataOverride.setTab("Tab");
    fieldMetadataOverride.setTabOrder(1);
    fieldMetadataOverride.setTargetObjectIdProperty("Target Object Id Property");
    fieldMetadataOverride.setTargetObjectProperty("Target Object Property");
    fieldMetadataOverride.setToOneLookupCreatedViaAnnotation(true);
    fieldMetadataOverride.setToOneParentProperty("To One Parent Property");
    fieldMetadataOverride.setToOneTargetProperty("To One Target Property");
    fieldMetadataOverride.setTooltip("127.0.0.1");
    fieldMetadataOverride.setTranslatable(true);
    fieldMetadataOverride.setUnique(true);
    fieldMetadataOverride.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    fieldMetadataOverride.setUseServerSideInspectionCache(true);
    HashMap<String, List<Map<String, String>>> validationConfigurations = new HashMap<>();
    fieldMetadataOverride.setValidationConfigurations(validationConfigurations);
    fieldMetadataOverride.setValueClass("42");
    fieldMetadataOverride.setValuePropertyFriendlyName("42");
    fieldMetadataOverride.setVisibility(VisibilityEnum.HIDDEN_ALL);
    String actualAddFriendlyName = fieldMetadataOverride.getAddFriendlyName();
    AddMethodType actualAddMethodType = fieldMetadataOverride.getAddMethodType();
    OperationType actualAddType = fieldMetadataOverride.getAddType();
    AdornedTargetAddMethodType actualAdornedTargetAddMethodType =
        fieldMetadataOverride.getAdornedTargetAddMethodType();
    Boolean actualAllowNoValueEnumOption = fieldMetadataOverride.getAllowNoValueEnumOption();
    String actualAssociatedFieldName = fieldMetadataOverride.getAssociatedFieldName();
    String actualBroadleafEnumeration = fieldMetadataOverride.getBroadleafEnumeration();
    Boolean actualCanLinkToExternalEntity = fieldMetadataOverride.getCanLinkToExternalEntity();
    String actualColumnWidth = fieldMetadataOverride.getColumnWidth();
    String actualCurrencyCodeField = fieldMetadataOverride.getCurrencyCodeField();
    String[] actualCustomCriteria = fieldMetadataOverride.getCustomCriteria();
    String actualDefaultValue = fieldMetadataOverride.getDefaultValue();
    RuleBuilderDisplayType actualDisplayType = fieldMetadataOverride.getDisplayType();
    Boolean actualEnableTypeaheadLookup = fieldMetadataOverride.getEnableTypeaheadLookup();
    String actualEnumerationClass = fieldMetadataOverride.getEnumerationClass();
    String[][] actualEnumerationValues = fieldMetadataOverride.getEnumerationValues();
    Boolean actualExcluded = fieldMetadataOverride.getExcluded();
    SupportedFieldType actualExplicitFieldType = fieldMetadataOverride.getExplicitFieldType();
    OperationType actualFetchType = fieldMetadataOverride.getFetchType();
    SupportedFieldType actualFieldComponentRenderer =
        fieldMetadataOverride.getFieldComponentRenderer();
    String actualFieldComponentRendererTemplate =
        fieldMetadataOverride.getFieldComponentRendererTemplate();
    SupportedFieldType actualFieldType = fieldMetadataOverride.getFieldType();
    Boolean actualForceFreeFormKeys = fieldMetadataOverride.getForceFreeFormKeys();
    Boolean actualForcePopulateChildProperties =
        fieldMetadataOverride.getForcePopulateChildProperties();
    String actualForeignKeyClass = fieldMetadataOverride.getForeignKeyClass();
    Boolean actualForeignKeyCollection = fieldMetadataOverride.getForeignKeyCollection();
    String actualForeignKeyDisplayValueProperty =
        fieldMetadataOverride.getForeignKeyDisplayValueProperty();
    String actualForeignKeyProperty = fieldMetadataOverride.getForeignKeyProperty();
    String actualFriendlyName = fieldMetadataOverride.getFriendlyName();
    SupportedFieldType actualGridFieldComponentRenderer =
        fieldMetadataOverride.getGridFieldComponentRenderer();
    String actualGridFieldComponentRendererTemplate =
        fieldMetadataOverride.getGridFieldComponentRendererTemplate();
    Integer actualGridOrder = fieldMetadataOverride.getGridOrder();
    String[] actualGridVisibleFields = fieldMetadataOverride.getGridVisibleFields();
    String actualGroup = fieldMetadataOverride.getGroup();
    Boolean actualGroupCollapsed = fieldMetadataOverride.getGroupCollapsed();
    Integer actualGroupOrder = fieldMetadataOverride.getGroupOrder();
    String actualHelpText = fieldMetadataOverride.getHelpText();
    Boolean actualHideEnumerationIfEmpty = fieldMetadataOverride.getHideEnumerationIfEmpty();
    String actualHint = fieldMetadataOverride.getHint();
    OperationType actualInspectType = fieldMetadataOverride.getInspectType();
    Boolean actualIsDerived = fieldMetadataOverride.getIsDerived();
    String actualJoinEntityClass = fieldMetadataOverride.getJoinEntityClass();
    String actualKeyClass = fieldMetadataOverride.getKeyClass();
    String actualKeyPropertyFriendlyName = fieldMetadataOverride.getKeyPropertyFriendlyName();
    String[][] actualKeys = fieldMetadataOverride.getKeys();
    Boolean actualLazyFetch = fieldMetadataOverride.getLazyFetch();
    Integer actualLength = fieldMetadataOverride.getLength();
    String actualLookupDisplayProperty = fieldMetadataOverride.getLookupDisplayProperty();
    LookupType actualLookupType = fieldMetadataOverride.getLookupType();
    String[] actualMaintainedAdornedTargetFields =
        fieldMetadataOverride.getMaintainedAdornedTargetFields();
    Boolean actualManualFetch = fieldMetadataOverride.getManualFetch();
    String actualManyToField = fieldMetadataOverride.getManyToField();
    String actualMapFieldValueClass = fieldMetadataOverride.getMapFieldValueClass();
    String actualMapKeyOptionEntityClass = fieldMetadataOverride.getMapKeyOptionEntityClass();
    String actualMapKeyOptionEntityDisplayField =
        fieldMetadataOverride.getMapKeyOptionEntityDisplayField();
    String actualMapKeyOptionEntityValueField =
        fieldMetadataOverride.getMapKeyOptionEntityValueField();
    String actualMapKeyValueProperty = fieldMetadataOverride.getMapKeyValueProperty();
    String actualMediaField = fieldMetadataOverride.getMediaField();
    MergedPropertyType actualMergedPropertyType = fieldMetadataOverride.getMergedPropertyType();
    String actualName = fieldMetadataOverride.getName();
    Boolean actualOptionCanEditValues = fieldMetadataOverride.getOptionCanEditValues();
    String actualOptionDisplayFieldName = fieldMetadataOverride.getOptionDisplayFieldName();
    Serializable[][] actualOptionFilterValues = fieldMetadataOverride.getOptionFilterValues();
    String actualOptionListEntity = fieldMetadataOverride.getOptionListEntity();
    String actualOptionValueFieldName = fieldMetadataOverride.getOptionValueFieldName();
    String actualParentObjectIdProperty = fieldMetadataOverride.getParentObjectIdProperty();
    String actualParentObjectProperty = fieldMetadataOverride.getParentObjectProperty();
    Integer actualPrecision = fieldMetadataOverride.getPrecision();
    Boolean actualReadOnly = fieldMetadataOverride.getReadOnly();
    OperationType actualRemoveType = fieldMetadataOverride.getRemoveType();
    Boolean actualRequired = fieldMetadataOverride.getRequired();
    Boolean actualRequiredOverride = fieldMetadataOverride.getRequiredOverride();
    String actualRuleIdentifier = fieldMetadataOverride.getRuleIdentifier();
    Integer actualScale = fieldMetadataOverride.getScale();
    Boolean actualSearchable = fieldMetadataOverride.getSearchable();
    SupportedFieldType actualSecondaryType = fieldMetadataOverride.getSecondaryType();
    String actualSecurityLevel = fieldMetadataOverride.getSecurityLevel();
    String actualSelectizeVisibleField = fieldMetadataOverride.getSelectizeVisibleField();
    Map<String, List<String>> actualShowIfFieldEquals =
        fieldMetadataOverride.getShowIfFieldEquals();
    String actualShowIfProperty = fieldMetadataOverride.getShowIfProperty();
    UnspecifiedBooleanType actualSimpleValue = fieldMetadataOverride.getSimpleValue();
    String actualSortProperty = fieldMetadataOverride.getSortProperty();
    String actualTab = fieldMetadataOverride.getTab();
    Integer actualTabOrder = fieldMetadataOverride.getTabOrder();
    String actualTargetObjectIdProperty = fieldMetadataOverride.getTargetObjectIdProperty();
    String actualTargetObjectProperty = fieldMetadataOverride.getTargetObjectProperty();
    Boolean actualToOneLookupCreatedViaAnnotation =
        fieldMetadataOverride.getToOneLookupCreatedViaAnnotation();
    String actualToOneParentProperty = fieldMetadataOverride.getToOneParentProperty();
    String actualToOneTargetProperty = fieldMetadataOverride.getToOneTargetProperty();
    fieldMetadataOverride.getTooltip();
    Boolean actualTranslatable = fieldMetadataOverride.getTranslatable();
    Boolean actualUnique = fieldMetadataOverride.getUnique();
    OperationType actualUpdateType = fieldMetadataOverride.getUpdateType();
    Boolean actualUseServerSideInspectionCache =
        fieldMetadataOverride.getUseServerSideInspectionCache();
    Map<String, List<Map<String, String>>> actualValidationConfigurations =
        fieldMetadataOverride.getValidationConfigurations();
    String actualValueClass = fieldMetadataOverride.getValueClass();
    String actualValuePropertyFriendlyName = fieldMetadataOverride.getValuePropertyFriendlyName();
    VisibilityEnum actualVisibility = fieldMetadataOverride.getVisibility();
    Boolean actualIsDeleteEntityUponRemoveResult = fieldMetadataOverride.isDeleteEntityUponRemove();
    Boolean actualIsIgnoreAdornedPropertiesResult =
        fieldMetadataOverride.isIgnoreAdornedProperties();
    Boolean actualIsLargeEntryResult = fieldMetadataOverride.isLargeEntry();
    Boolean actualIsProminentResult = fieldMetadataOverride.isProminent();
    Boolean actualIsSortAscendingResult = fieldMetadataOverride.isSortAscending();

    // Assert
    assertEquals("42", actualForeignKeyDisplayValueProperty);
    assertEquals("42", actualMapFieldValueClass);
    assertEquals("42", actualMapKeyOptionEntityValueField);
    assertEquals("42", actualMapKeyValueProperty);
    assertEquals("42", actualOptionValueFieldName);
    assertEquals("42", actualRuleIdentifier);
    assertEquals("42", actualValueClass);
    assertEquals("42", actualValuePropertyFriendlyName);
    assertEquals("Add Friendly Name", actualAddFriendlyName);
    assertEquals("Associated Field Name", actualAssociatedFieldName);
    assertEquals("Broadleaf Enumeration", actualBroadleafEnumeration);
    assertEquals("Column Width", actualColumnWidth);
    assertEquals("Enumeration Class", actualEnumerationClass);
    assertEquals("Field Component Renderer Template", actualFieldComponentRendererTemplate);
    assertEquals("Foreign Key Class", actualForeignKeyClass);
    assertEquals("Foreign Key Property", actualForeignKeyProperty);
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("GBP", actualCurrencyCodeField);
    assertEquals(
        "Grid Field Component Renderer Template", actualGridFieldComponentRendererTemplate);
    assertEquals("Group", actualGroup);
    assertEquals("Help Text", actualHelpText);
    assertEquals("Hint", actualHint);
    assertEquals("Join Entity Class", actualJoinEntityClass);
    assertEquals("Key Class", actualKeyClass);
    assertEquals("Key Property Friendly Name", actualKeyPropertyFriendlyName);
    assertEquals("Lookup Display Property", actualLookupDisplayProperty);
    assertEquals("Many To Field", actualManyToField);
    assertEquals("Map Key Option Entity Class", actualMapKeyOptionEntityClass);
    assertEquals("Map Key Option Entity Display Field", actualMapKeyOptionEntityDisplayField);
    assertEquals("Media Field", actualMediaField);
    assertEquals("Name", actualName);
    assertEquals("Option Display Field Name", actualOptionDisplayFieldName);
    assertEquals("Option List Entity", actualOptionListEntity);
    assertEquals("Parent Object Id Property", actualParentObjectIdProperty);
    assertEquals("Parent Object Property", actualParentObjectProperty);
    assertEquals("Security Level", actualSecurityLevel);
    assertEquals("Selectize Visible Field", actualSelectizeVisibleField);
    assertEquals("Show If Property", actualShowIfProperty);
    assertEquals("Sort Property", actualSortProperty);
    assertEquals("Tab", actualTab);
    assertEquals("Target Object Id Property", actualTargetObjectIdProperty);
    assertEquals("Target Object Property", actualTargetObjectProperty);
    assertEquals("To One Parent Property", actualToOneParentProperty);
    assertEquals("To One Target Property", actualToOneTargetProperty);
    assertNull(actualDefaultValue);
    assertEquals(1, actualGridOrder.intValue());
    assertEquals(1, actualGroupOrder.intValue());
    assertEquals(1, actualPrecision.intValue());
    assertEquals(1, actualScale.intValue());
    assertEquals(1, actualTabOrder.intValue());
    assertEquals(1, actualEnumerationValues.length);
    assertEquals(1, actualKeys.length);
    assertEquals(3, actualLength.intValue());
    assertEquals(AddMethodType.PERSIST, actualAddMethodType);
    assertEquals(AdornedTargetAddMethodType.LOOKUP, actualAdornedTargetAddMethodType);
    assertEquals(LookupType.STANDARD, actualLookupType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualAddType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualFetchType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualInspectType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualRemoveType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualUpdateType);
    assertEquals(RuleBuilderDisplayType.NORMAL, actualDisplayType);
    assertEquals(SupportedFieldType.UNKNOWN, actualExplicitFieldType);
    assertEquals(SupportedFieldType.UNKNOWN, actualFieldComponentRenderer);
    assertEquals(SupportedFieldType.UNKNOWN, actualFieldType);
    assertEquals(SupportedFieldType.UNKNOWN, actualGridFieldComponentRenderer);
    assertEquals(SupportedFieldType.UNKNOWN, actualSecondaryType);
    assertEquals(UnspecifiedBooleanType.TRUE, actualSimpleValue);
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualVisibility);
    assertEquals(MergedPropertyType.PRIMARY, actualMergedPropertyType);
    assertTrue(actualShowIfFieldEquals.isEmpty());
    assertTrue(actualValidationConfigurations.isEmpty());
    assertTrue(actualAllowNoValueEnumOption);
    assertTrue(actualCanLinkToExternalEntity);
    assertTrue(actualEnableTypeaheadLookup);
    assertTrue(actualExcluded);
    assertTrue(actualForceFreeFormKeys);
    assertTrue(actualForcePopulateChildProperties);
    assertTrue(actualForeignKeyCollection);
    assertTrue(actualGroupCollapsed);
    assertTrue(actualHideEnumerationIfEmpty);
    assertTrue(actualIsDerived);
    assertTrue(actualLazyFetch);
    assertTrue(actualManualFetch);
    assertTrue(actualOptionCanEditValues);
    assertTrue(actualReadOnly);
    assertTrue(actualRequired);
    assertTrue(actualRequiredOverride);
    assertTrue(actualSearchable);
    assertTrue(actualToOneLookupCreatedViaAnnotation);
    assertTrue(actualTranslatable);
    assertTrue(actualUnique);
    assertTrue(actualUseServerSideInspectionCache);
    assertTrue(actualIsDeleteEntityUponRemoveResult);
    assertTrue(actualIsIgnoreAdornedPropertiesResult);
    assertTrue(actualIsLargeEntryResult);
    assertTrue(actualIsProminentResult);
    assertTrue(actualIsSortAscendingResult);
    assertSame(showIfFieldEquals, actualShowIfFieldEquals);
    assertSame(validationConfigurations, actualValidationConfigurations);
    assertSame(customCriteria, actualCustomCriteria);
    assertSame(gridVisibleFields, actualGridVisibleFields);
    assertSame(maintainedAdornedTargetFields, actualMaintainedAdornedTargetFields);
    assertSame(optionFilterValues, actualOptionFilterValues);
    assertSame(enumerationValues, actualEnumerationValues);
    assertSame(keys, actualKeys);
    assertArrayEquals(new String[] {"42"}, actualEnumerationValues[0]);
    assertArrayEquals(new String[] {"Custom Criteria"}, actualCustomCriteria);
    assertArrayEquals(new String[] {"Grid Visible Fields"}, actualGridVisibleFields);
    assertArrayEquals(new String[] {"Keys"}, actualKeys[0]);
    assertArrayEquals(
        new String[] {"Maintained Adorned Target Fields"}, actualMaintainedAdornedTargetFields);
  }

  /**
   * Test new {@link FieldMetadataOverride} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FieldMetadataOverride}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldMetadataOverride.<init>()"})
  public void testNewFieldMetadataOverride() {
    // Arrange and Act
    FieldMetadataOverride actualFieldMetadataOverride = new FieldMetadataOverride();

    // Assert
    assertNull(actualFieldMetadataOverride.getOptionFilterValues());
    assertNull(actualFieldMetadataOverride.getAllowNoValueEnumOption());
    assertNull(actualFieldMetadataOverride.getCanLinkToExternalEntity());
    assertNull(actualFieldMetadataOverride.getEnableTypeaheadLookup());
    assertNull(actualFieldMetadataOverride.getExcluded());
    assertNull(actualFieldMetadataOverride.getForceFreeFormKeys());
    assertNull(actualFieldMetadataOverride.getForcePopulateChildProperties());
    assertNull(actualFieldMetadataOverride.getForeignKeyCollection());
    assertNull(actualFieldMetadataOverride.getGroupCollapsed());
    assertNull(actualFieldMetadataOverride.getHideEnumerationIfEmpty());
    assertNull(actualFieldMetadataOverride.getIsDerived());
    assertNull(actualFieldMetadataOverride.getLazyFetch());
    assertNull(actualFieldMetadataOverride.getManualFetch());
    assertNull(actualFieldMetadataOverride.getOptionCanEditValues());
    assertNull(actualFieldMetadataOverride.getReadOnly());
    assertNull(actualFieldMetadataOverride.getRequired());
    assertNull(actualFieldMetadataOverride.getRequiredOverride());
    assertNull(actualFieldMetadataOverride.getSearchable());
    assertNull(actualFieldMetadataOverride.getToOneLookupCreatedViaAnnotation());
    assertNull(actualFieldMetadataOverride.getTranslatable());
    assertNull(actualFieldMetadataOverride.getUnique());
    assertNull(actualFieldMetadataOverride.getUseServerSideInspectionCache());
    assertNull(actualFieldMetadataOverride.isDeleteEntityUponRemove());
    assertNull(actualFieldMetadataOverride.isIgnoreAdornedProperties());
    assertNull(actualFieldMetadataOverride.isLargeEntry());
    assertNull(actualFieldMetadataOverride.isProminent());
    assertNull(actualFieldMetadataOverride.isSortAscending());
    assertNull(actualFieldMetadataOverride.getGridOrder());
    assertNull(actualFieldMetadataOverride.getGroupOrder());
    assertNull(actualFieldMetadataOverride.getLength());
    assertNull(actualFieldMetadataOverride.getPrecision());
    assertNull(actualFieldMetadataOverride.getScale());
    assertNull(actualFieldMetadataOverride.getTabOrder());
    assertNull(actualFieldMetadataOverride.getOrder());
    assertNull(actualFieldMetadataOverride.getAddFriendlyName());
    assertNull(actualFieldMetadataOverride.getAssociatedFieldName());
    assertNull(actualFieldMetadataOverride.getBroadleafEnumeration());
    assertNull(actualFieldMetadataOverride.getColumnWidth());
    assertNull(actualFieldMetadataOverride.getCurrencyCodeField());
    assertNull(actualFieldMetadataOverride.getDefaultValue());
    assertNull(actualFieldMetadataOverride.getEnumerationClass());
    assertNull(actualFieldMetadataOverride.getFieldComponentRendererTemplate());
    assertNull(actualFieldMetadataOverride.getForeignKeyClass());
    assertNull(actualFieldMetadataOverride.getForeignKeyDisplayValueProperty());
    assertNull(actualFieldMetadataOverride.getForeignKeyProperty());
    assertNull(actualFieldMetadataOverride.getFriendlyName());
    assertNull(actualFieldMetadataOverride.getGridFieldComponentRendererTemplate());
    assertNull(actualFieldMetadataOverride.getGroup());
    assertNull(actualFieldMetadataOverride.getHelpText());
    assertNull(actualFieldMetadataOverride.getHint());
    assertNull(actualFieldMetadataOverride.getJoinEntityClass());
    assertNull(actualFieldMetadataOverride.getKeyClass());
    assertNull(actualFieldMetadataOverride.getKeyPropertyFriendlyName());
    assertNull(actualFieldMetadataOverride.getLookupDisplayProperty());
    assertNull(actualFieldMetadataOverride.getManyToField());
    assertNull(actualFieldMetadataOverride.getMapFieldValueClass());
    assertNull(actualFieldMetadataOverride.getMapKeyOptionEntityClass());
    assertNull(actualFieldMetadataOverride.getMapKeyOptionEntityDisplayField());
    assertNull(actualFieldMetadataOverride.getMapKeyOptionEntityValueField());
    assertNull(actualFieldMetadataOverride.getMapKeyValueProperty());
    assertNull(actualFieldMetadataOverride.getMediaField());
    assertNull(actualFieldMetadataOverride.getName());
    assertNull(actualFieldMetadataOverride.getOptionDisplayFieldName());
    assertNull(actualFieldMetadataOverride.getOptionListEntity());
    assertNull(actualFieldMetadataOverride.getOptionValueFieldName());
    assertNull(actualFieldMetadataOverride.getParentObjectIdProperty());
    assertNull(actualFieldMetadataOverride.getParentObjectProperty());
    assertNull(actualFieldMetadataOverride.getRuleIdentifier());
    assertNull(actualFieldMetadataOverride.getSecurityLevel());
    assertNull(actualFieldMetadataOverride.getSelectizeVisibleField());
    assertNull(actualFieldMetadataOverride.getShowIfProperty());
    assertNull(actualFieldMetadataOverride.getSortProperty());
    assertNull(actualFieldMetadataOverride.getTab());
    assertNull(actualFieldMetadataOverride.getTargetObjectIdProperty());
    assertNull(actualFieldMetadataOverride.getTargetObjectProperty());
    assertNull(actualFieldMetadataOverride.getToOneParentProperty());
    assertNull(actualFieldMetadataOverride.getToOneTargetProperty());
    assertNull(actualFieldMetadataOverride.getTooltip());
    assertNull(actualFieldMetadataOverride.getValueClass());
    assertNull(actualFieldMetadataOverride.getValuePropertyFriendlyName());
    assertNull(actualFieldMetadataOverride.getCustomCriteria());
    assertNull(actualFieldMetadataOverride.getGridVisibleFields());
    assertNull(actualFieldMetadataOverride.getMaintainedAdornedTargetFields());
    assertNull(actualFieldMetadataOverride.getEnumerationValues());
    assertNull(actualFieldMetadataOverride.getKeys());
    assertNull(actualFieldMetadataOverride.getShowIfFieldEquals());
    assertNull(actualFieldMetadataOverride.getValidationConfigurations());
    assertNull(actualFieldMetadataOverride.getAddMethodType());
    assertNull(actualFieldMetadataOverride.getAdornedTargetAddMethodType());
    assertNull(actualFieldMetadataOverride.getLookupType());
    assertNull(actualFieldMetadataOverride.getAddType());
    assertNull(actualFieldMetadataOverride.getFetchType());
    assertNull(actualFieldMetadataOverride.getInspectType());
    assertNull(actualFieldMetadataOverride.getRemoveType());
    assertNull(actualFieldMetadataOverride.getUpdateType());
    assertNull(actualFieldMetadataOverride.getDisplayType());
    assertNull(actualFieldMetadataOverride.getExplicitFieldType());
    assertNull(actualFieldMetadataOverride.getFieldComponentRenderer());
    assertNull(actualFieldMetadataOverride.getFieldType());
    assertNull(actualFieldMetadataOverride.getGridFieldComponentRenderer());
    assertNull(actualFieldMetadataOverride.getSimpleValue());
    assertNull(actualFieldMetadataOverride.getVisibility());
    assertNull(actualFieldMetadataOverride.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualFieldMetadataOverride.getSecondaryType());
  }
}
