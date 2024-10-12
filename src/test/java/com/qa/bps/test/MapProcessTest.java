package com.qa.bps.test;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bps.pages.JDBC;

public class MapProcessTest extends BaseTest {

	@BeforeClass(alwaysRun = true)
	public void homePageSetup() throws InterruptedException, IOException {
		homepage = loginpage.doLogin(prop.getProperty("manager_username"), prop.getProperty("manager_password"));
	}

	@Test(groups = { "SmokeTest" }, priority = 0)
	public void UserIsAbleToNavigateToManpProcess() throws InterruptedException, IOException, SQLException {

		navigateTo.addValueToEventProp();
		navigateTo.LattestPublishedPlan();
		String productName = navigateTo.GetProductDetailsFromPlanner();
		pdtoverview.getProductDetails(productName);
		navigateTo.productOverview();
		pdtoverview.preReq();
		jdbc.toMapProcessConifgration();
		Assert.assertTrue(mp.NavigateToMapProcess());
	}

	@Test(groups = { "SmokeTest" }, priority = 1)
	public void VerifyCreateProcessmanBtnIsAvailable() throws InterruptedException {
		Assert.assertTrue(mp.CreateProcessMapBtnAvailable());
	}

	@Test(groups = { "SmokeTest" }, priority = 2)
	public void VerifyPlantNameisDisplayed() throws InterruptedException {
		Assert.assertTrue(mp.PlantNameisDisplayed());
	}

	@Test(groups = { "SmokeTest" }, priority = 3)
	public void VerifyUserIsAbleToNavigateToSite() throws InterruptedException {
		Assert.assertTrue(mp.navigateToSite());
	}

	@Test(groups = { "SmokeTest" }, priority = 4)
	public void VerifyUserIsAbleTocreateAnewNode() throws InterruptedException {
		Assert.assertTrue(mp.createAnewNode());
	}

	@Test(groups = { "SmokeTest" }, priority = 5)
	public void VerifytoasterPostNodeCreation() throws InterruptedException {
		Assert.assertTrue(mp.toasterPostNodeCreate(),
				"Toaster message is wrong post node creation.... Please check the toaster message!");
	}

	@Test(groups = { "SmokeTest" }, priority = 6)
	public void VerifyuserShouldNotcreateAduplicateNode() throws InterruptedException {
		Assert.assertTrue(mp.userShouldNotcreateAduplicateNode(), "User is Able to create a duplicate Node! ");
	}

	@Test(groups = { "SmokeTest" }, priority = 7)
	public void VerifyDuplicatetoasterdisplayed() throws InterruptedException {
		Assert.assertTrue(mp.Duplicatetoasterdisplayed(), "Node Duplication toaster not displayed! ");
	}

	@Test(groups = { "SmokeTest" }, priority = 8)
	public void VerifyuserisSoftdeleteCreatedNode() throws InterruptedException {
		Assert.assertTrue(mp.deleteCreatedNode(),
				"user is unable to delete the node / Toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 9)
	public void VerifydeleteToasterIsDisplayed() throws InterruptedException {
		Assert.assertTrue(mp.deleteToasterIsDisplayed(),
				"user is unable to delete the node / Toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 10)
	public void VerifyuserCancloneNodewithExistingName() throws InterruptedException {
		Assert.assertTrue(mp.cloneNodewithExistingName(), "user is able to clone the node with existing name");
	}

	@Test(groups = { "SmokeTest" }, priority = 11)
	public void VerifyDuplicateCloneToaster() throws InterruptedException {
		Assert.assertTrue(mp.DuplicateCloneToaster(),
				"user is able to clone the node with existing name/worng toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 12)
	public void VerifyUserSouldNotCreateNodeWithbegginingSpace() throws InterruptedException {
		Assert.assertTrue(mp.CreateNodeWithbegginingSpace(), "User can create a node with spaces in the beggining");
	}

	@Test(groups = { "SmokeTest" }, priority = 13)
	public void VerifyUserCanCreateCloneANode() throws InterruptedException {
		Assert.assertTrue(mp.cloneNode(), "User is Unable to clone a node");

	}

	@Test(groups = { "SmokeTest" }, priority = 14)
	public void VerifycloneNodeToaster() throws InterruptedException {
		Assert.assertTrue(mp.cloneNodeToaster(), "Wrong Toaster message displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 15)
	public void VerifyUserCanconfigAlterEq() throws InterruptedException {
		Assert.assertTrue(mp.configAlterEq(), "Alternate Equipment is not configured");
	}

	@Test(groups = { "SmokeTest" }, priority = 16)
	public void VerifyalternateEqToaster() throws InterruptedException {
		Assert.assertTrue(mp.alternateEqToaster(), "Wrong Toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 17)
	public void VerifyalternateEquipmentavailableinproductOvrView() throws InterruptedException, IOException {
		Assert.assertTrue(mp.alternateEquipmentavailableinproductOvrView());

	}

	@Test(groups = { "SmokeTest" }, priority = 18)
	public void VerifychangeAlternateEqinproductOvrView() throws InterruptedException {
		Assert.assertTrue(mp.changeAlternateEq());

	}

	@Test(groups = { "SmokeTest" }, priority = 19)
	public void VerifytoasterOnChangeEquipment() throws InterruptedException {
		Assert.assertTrue(mp.toasterOnChangeEquipment());

	}

	@Test(groups = { "SmokeTest" }, priority = 20)
	public void VerifystartTaskWithAlternateEquipment() throws InterruptedException {
		Assert.assertTrue(mp.startTaskWithAlternateEquipment());

	}

	@Test(groups = { "SmokeTest" }, priority = 21)
	public void VerifyUserCanDeleteAlternateEqFromTask() throws InterruptedException {
		Assert.assertTrue(mp.deleteAlternateEqFromTask());
	}

	@Test(groups = { "SmokeTest" }, priority = 22)
	public void VerifyAlternateEquipmentDelteToaster() throws InterruptedException {
		Assert.assertTrue(mp.AlternateEquipmentDelteToaster(), "Wrong Toaster displayed");

	}

	@Test(groups = { "SmokeTest" }, priority = 23)
	public void VerifyAddSkillInTaskLevel() throws InterruptedException {
		Assert.assertTrue(mp.AddSkillInTaskLevel());

	}

	@Test(groups = { "SmokeTest" }, priority = 24)
	public void verifyToasterMsgOfAddSkill() {
		Assert.assertTrue(mp.verifyToasterMsgOfAddSkillTest(), "Wrong toaster message is displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 25)
	public void verifydeleteSkillFromTask() throws InterruptedException {
		Assert.assertTrue(mp.deleteSkillFromTask(), "Skill displayed post delete ");
	}

	@Test(groups = { "SmokeTest" }, priority = 26)
	public void verifytoasteronDeleteSkill() throws InterruptedException {
		Assert.assertTrue(mp.toasteronDeleteSkill(), "Wrong toaster displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 27)
	public void verifyuserCanmoveNode() throws InterruptedException {
		Assert.assertTrue(mp.moveNode());
	}

	@Test(groups = { "SmokeTest" }, priority = 28)
	public void verifymoveNodeToaster() throws InterruptedException {
		Assert.assertTrue(mp.moveNodeToaster());
	}

	@Test(groups = { "SmokeTest" }, priority = 29)
	public void verifyDoubleClickFunctionality() throws InterruptedException {
		Assert.assertTrue(mp.verifyDoubleClickFunTest(), "double click functionality is not working ");
	}

	@Test(groups = { "SmokeTest" }, priority = 30)
	public void verifyUserCanCreateTemplateNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanCreateTemplateNodeTest(),
				"User is unable to create template / wrong toaster message is displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 31)
	public void verifyUserCanEditTemplateNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanEditTemplateNodeTest(),
				"User is unable to edit the template / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 32)
	public void verifyUserCanDeleteTemplateNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteTemplateNodeTest(),
				"User is unable to delete the template node / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 33)
	public void verifyUserCanNavigateToNodeTypeTab() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanNavigateToNodeTypeTabTest(), "User is unable to navigate to Node Type tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 34)
	public void verifyUserCanCreateNewNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanCreateNewNodeTypeTest(),
				"User is unable to create the new node / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 35)
	public void verifyUserCanEditNodeName() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanEditNodeNameTest(), "User is unable to edit the node");
	}

	@Test(groups = { "SmokeTest" }, priority = 36)
	public void verifyUserCanEditNodeDescription() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanEditNodeDescriptionTest(), "User is unable to edit the node description");
	}

	@Test(groups = { "SmokeTest" }, priority = 37)
	public void verifyUserCanChangeTheNodeIcon() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanChangeTheNodeIconTest(), "User is unable to change the node icon");
	}

	@Test(groups = { "SmokeTest" }, priority = 38)
	public void verifySelectedFeatureAndListedFeatureCount() throws InterruptedException {
		Assert.assertTrue(mp.verifySelectedFeatureAndListedFeatureCountTest(),
				"Listed feature and selected feature size is not equals");
	}

	@Test(groups = { "SmokeTest" }, priority = 39)
	public void verifyAvlOfCreatedNodeTypeInProcessBuilder() throws InterruptedException {
		Assert.assertTrue(mp.verifyAvlOfCreatedNodeTypeInProcessBuilderTest(),
				"created Node is not available in process builder ");
	}

	@Test(groups = { "SmokeTest" }, priority = 40)
	public void verifyUserCanCreateANodeOfCreatedNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanCreateANodeOfCreatedNodeTypeTest(),
				"User is unable to create the new node using new node type");
	}

	@Test(groups = { "SmokeTest" }, priority = 41)
	public void verifyUserCanEditANodeOfCreatedNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanEditANodeOfCreatedNodeTypeTest(),
				"User is unable to edit the node of new node type");
	}

	@Test(groups = { "SmokeTest" }, priority = 42)
	public void verifyUserCanDeleteANodeOfCreatedNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteANodeOfCreatedNodeTypeTest(),
				"User is unable to delete the node of new node type");
	}

	@Test(groups = { "SmokeTest" }, priority = 43)
	public void verifyUserCanRemoveAllSelectedFeature() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanRemoveAllSelectedFeatureTest(),
				"user is unable to deselect the selected feature ");
	}

	@Test(groups = { "SmokeTest" }, priority = 44)
	public void verifyListedFeatureCountAfterRemovingAllFeature() throws InterruptedException {
		Assert.assertTrue(mp.verifyListedFeatureCountAfterRemovingAllFeatureTest(),
				"Feature tabs are displaying after removing all the feature");
	}

	@Test(groups = { "SmokeTest" }, priority = 45)
	public void verifyFeatureLisInNodeOfNewNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyFeatureLisInNodeOfNewNodeTypeTest(), "Removed features are displaying in node ");
	}

	@Test(groups = { "SmokeTest" }, priority = 46)
	public void verifyUserCanAddThePropertiesFeatureInNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanAddThePropertiesFeatureInNodeTypeTest(),
				"User is unable to add the property Feature");
	}

	@Test(groups = { "SmokeTest" }, priority = 47)
	public void verifyUserCanAddThePropertyToCreatedNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanAddThePropertyToCreatedNodeTypeTest(), "User is unable to add the property");
	}

	@Test(groups = { "SmokeTest" }, priority = 48)
	public void verifyAddedPropertyAvlInCreatedNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyAddedPropertyAvlInCreatedNodeTest(), "Added node property not available in node ");
	}

	@Test(groups = { "SmokeTest" }, priority = 49)
	public void verifyUserCanEditTheAddedProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanEditTheAddedPropertyTest(), "User is unable to edit the propertyName ");
	}

	@Test(groups = { "SmokeTest" }, priority = 50)
	public void verifyUserCanDeleteTheAddedProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteTheAddedPropertyTest(), "User is unable to delete the property");
	}

	@Test(groups = { "SmokeTest" }, priority = 51)
	public void verifyTheAvlOfDeletedPropertyInNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheAvlOfDeletedPropertyInNodeTest(), "Delete property exist in created nodes");
	}

	@Test(groups = { "SmokeTest" }, priority = 52)
	public void verifyUserCanDeleteTheCreatedNodeType() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteTheCreatedNodeTypeTest(),
				"User is unable to delete the created node type / toaster message is not displayed");
	}

	@Test(groups = { "SmokeTest" }, priority = 53)
	public void verifyAvlOfDeletedNodeInNodeTypeTab() throws InterruptedException {
		Assert.assertTrue(mp.verifyAvlOfDeletedNodeInNodeTypeTabTest(),
				"Deleted node type is still exist in node type tab");
	}

	@Test(groups = { "SmokeTest" }, priority = 54)
	public void verifyAvlOfDeleteNodeTypeInProcessBuilder() throws InterruptedException {
		Assert.assertTrue(mp.verifyAvlOfDeleteNodeTypeInProcessBuilderTest(),
				"Deleted node type is available in process builder");
	}

	@Test(groups = { "SmokeTest" }, priority = 55)
	public void verifyUserIsAbleToAddNewPropertiesToTaskNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToAddNewPropertiesToTaskNodeTest(),
				"User is unable to add the new property to task node");
	}

	@Test(groups = { "SmokeTest" }, priority = 56)
	public void verifyAddedPropertyAvlInTaskNodes() throws InterruptedException {
		Assert.assertTrue(mp.verifyAddedPropertyAvlInTaskNodesTest(), "Added property is not available in task nodes ");
	}

	@Test(groups = { "SmokeTest" }, priority = 57)
	public void verifyUserCanEditTheTaskNodeProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanEditTheTaskNodePropertyTest(),
				"User is unable to edit the task node property");
	}

	@Test(groups = { "SmokeTest" }, priority = 58)
	public void editFeatureAvlInTaskNode() throws InterruptedException {
		Assert.assertTrue(mp.editFeatureAvlInTaskNodeTest(), "Updated property name is not available in task node");
	}

	@Test(groups = { "SmokeTest" }, priority = 59)
	public void verifyUserCanDeleteTheaddedFeatureFromTaskNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteTheaddedFeatureFromTaskNodeTest(),
				"User is unable to delete the created property from task node ");
	}

	@Test(groups = { "SmokeTest" }, priority = 60)
	public void verifyAvlOfDeletedTaskFeatureInTaskNodes() throws InterruptedException {
		Assert.assertTrue(mp.verifyAvlOfDeletedTaskFeatureInTaskNodesTest(),
				"Deleted feature is available inside task node after delete");
	}

	@Test(groups = { "SmokeTest" }, priority = 61)
	public void verifyAvlFeatureseAfterAddingPropertyWithComma() throws InterruptedException {
		Assert.assertTrue(mp.verifyAvlFeatureseAfterAddingPropertyWithCommaTest(),
				"Some properties are missing after adding comma in property name");
	}

	@Test(groups = { "SmokeTest" }, priority = 62)
	public void verifyUserCanDeleteTheAddedAttribute() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteTheAddedAttributeTest());
	}

	@Test(groups = { "SmokeTest" }, priority = 63)
	public void verifyUserCanAddPrimaryEquipment() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanAddPrimaryEquipmentTest(), "User is unable to configure primary equipment");
	}

	@Test(groups = { "SmokeTest" }, priority = 64)
	public void verifyUserCanAlternativeEquipment() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanAlternativeEquipmentTest(), "Alternate equipment sequence is changed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 65)
	public void verifyUserCanDeleteTheTaskNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteTheTaskNodeTest(),
				"User is unable to delete the node / wrong toaster message is displaying ");
	}

	@Test(groups = { "SmokeTest" }, priority = 66)
	public void verifyUserCanCreateDelayCodeGroup() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanCreateDelayCodeGroupTest(),
				"User is unable to create the delay code group / toaster message is not displayed ");
	}

	@Test(groups = { "SmokeTest" }, priority = 67)
	public void verifyUserIsAbleToCreateDelayCodeInDCG() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCreateDelayCodeInDCGTest(), "User is unable to create the Delay Code ");
	}

	@Test(groups = { "SmokeTest" }, priority = 68)
	public void verifyTheAvlOfDelayCodeInSelectReasonDD() throws InterruptedException, IOException {
		Assert.assertTrue(mp.verifyTheAvlOfDelayCodeInSelectReasonDDTest(),
				"Created delaya code and delay code group is not available ");
	}

	@Test(groups = { "SmokeTest" }, priority = 69)
	public void verifyUserCanDeletDelayCode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeletDelayCodeTest(),
				"User is unable to delete the delay code node / wrong toaster message is displaying :");
	}

	@Test(groups = { "SmokeTest" }, priority = 70)
	public void verifyUserCanDeleteTheDelayCodeGroup() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanDeleteTheDelayCodeGroupTest(),
				"User is unable to delete the delay code group / wrong toaster message is displaying ");
	}

	@Test(groups = { "SmokeTest" }, priority = 71)
	public void verifyTheAvlOfDelayCodeInSelectReasonDDPostDelete() throws InterruptedException, IOException {
		Assert.assertTrue(mp.verifyTheAvlOfDelayCodeInSelectReasonDDPostDeleteTest(),
				"Delay code is exist in Delay Reason Drop Down  post delete ");
	}

	@Test(groups = { "SmokeTest" }, priority = 72)
	public void refreshAndVerifyData2() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(7000);
	}

	@Test(groups = { "SmokeTest" }, priority = 73)
	public void verifyAvlOfOrderSequenceColumnInPropertyTab() throws InterruptedException {
		Assert.assertTrue(mp.verifyAvlOfOrderSequenceColumnInPropertyTabTest(),
				"Order dequence column is not available in node type");

	}

	@Test(groups = { "SmokeTest" }, priority = 74)
	public void verifyUserCanCreateNodeTypeByAddingOrderSequenceInProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanCreateNodeTypeByAddingOrderSequenceTest(),
				"User is unable to create a new node type by adding property with order sequence column");
	}

	@Test(groups = { "SmokeTest" }, priority = 75)
	public void verifyTheAvlOfPropertyaddedWithOrderSequence() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheAvlOfPropertyaddedWithOrderSequenceTest(),
				"Property with order sequence is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 76)
	public void verifyTheOrderSequenceOfProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheOrderSequenceOfPropertyTest(),
				"Configured order sequence is and displayed order sequence  is not matching ");
	}

	@Test(groups = { "SmokeTest" }, priority = 77)
	public void verifyWhetherIntegerTypePropertyAcceptingNegatiValue() throws InterruptedException {
		Assert.assertTrue(mp.verifyWhetherIntegerTypePropertyAcceptingNegatiValueTest(),
				"User is able to add negative value in integer type input box");
	}

	@Test(groups = { "SmokeTest" }, priority = 78)
	public void verifyWhetherFloatTypePropertyAcceptingNegativeValue() throws InterruptedException {
		Assert.assertTrue(mp.verifyWhetherFloatTypePropertyAcceptingNegativeValueTest(),
				"User is able to add negative value in Float type input box");
	}

	@Test(groups = { "SmokeTest" }, priority = 79)
	public void verifyUserIsAbleToCreateANodeByAddingApportstope() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCreateANodeByAddingApportstopeTest(),
				"User is unable to create a node with aportstope symoble(') in node name");
	}

	@Test(groups = { "SmokeTest" }, priority = 80)
	public void verifyUserIsAbleToCreateANodeByAddingApportstopeInDescription() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCreateANodeByAddingApportstopeInDescriptionTest(),
				"User is unable to create a node with aportstope symoble(') in node description");
	}

	@Test(groups = { "SmokeTest" }, priority = 81)
	public void verifyUserIsAbleToCreateNewNodeByAddingApportstapeSymbol() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCreateNewNodeByAddingApportstapeSymbolTest(),
				"User is unable to created a new node type by adding apportstope symbole");
	}

	@Test(groups = { "SmokeTest" }, priority = 82)
	public void verifyUserIsAbleToCreateNewNodeByAddingApportstopeSymboleInDescription() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCreateNewNodeByAddingApportstopeSymboleInDescriptionTest(),
				"User is unable to created a new node type by adding apportstope symbole in description");
	}

	@Test(groups = { "SmokeTest" }, priority = 83)
	public void verifyTheAvlOfCreatedNewNodeByAddingApportstopeSymboleInDescription() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheAvlOfCreatedNewNodeByAddingApportstopeSymboleInDescriptionTest(),
				"Description value not contained apportstope symbole (')");
	}

	@Test(groups = { "SmokeTest" }, priority = 84)
	public void verifyUserIsAbleToCloneANodeByAddingApportstopeSymbole() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCloneANodeByAddingApportstopeSymboleTest(),
				"User is unable to clone a node by adding apportstope symbole");
	}

	@Test(groups = { "SmokeTest" }, priority = 85)
	public void verifyCloneNodeToasterAfterAddingApportStopeSymbo() {
		Assert.assertTrue(mp.verifyCloneNodeToasterAfterAddingApportStopeSymboTest(),
				"Sql Exception toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 86)
	public void verifyUserIsAbleToCreateNewNodeByAddingLessThanSymbole() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCreateNewNodeByAddingLessThanSymboleTest(),
				"User is unable to created a node by adding less than (<) symbole ");
	}

	@Test(groups = { "SmokeTest" }, priority = 87)
	public void verifyTheAvlOfCreatedNodeWithLessThanSymbole() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheAvlOfCreatedNodeWithLessThanSymboleTest(),
				"Less Than Symbole node is node available");
	}

	@Test(groups = { "SmokeTest" }, priority = 88)
	public void verifyAvlOfLinkagePostNavigattingBackFromSimplifiedScreen() throws InterruptedException {
		Assert.assertTrue(mp.verifyAvlOfLinkagePostNavigattingBackFromSimplifiedScreenTest(),
				"Post switching back from simplified screen to Map process screen Node linkages are disappeared from the Screen");
	}

	@Test(groups = { "SmokeTest" }, priority = 89)
	public void verifyUserIsAbleToAddNodeLinkageWithApportstope() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToAddNodeLinkageWithApportstopeTest(),
				"User is unable to add liknages with apportstope / wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 90)
	public void verifyAddedFeatureIsAvailableOrNot() throws InterruptedException {
		Assert.assertTrue(mp.verifyAddedFeatureIsAvailableOrNotTest(),
				"Added Feature with Apportstope is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 91)
	public void verifyUserIsAbleToCreateNewProcessWithApportstope() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserIsAbleToCreateNewProcessWithApportstopeTest(),
				"User is unable to created process by adding apportstope");
	}

	@Test(groups = { "SmokeTest" }, priority = 92)
	public void verifyTheAvlOfCreatedProcess() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheAvlOfCreatedProcessTest(), "Created Process with apportstope is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 93)
	public void verifyUserCanCreateTheTaskNodeByAddingProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanCreateTheTaskNodeByAddingPropertyTest(),
				"User is unable to created task node by adding property / Wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 94)
	public void verifyTheAvailabilityOfAddedPropertyToTaskNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheAvailabilityOfAddedPropertyToTaskNodeTest(),
				"Added property value is not available in added property fieled ");
	}

	@Test(groups = { "SmokeTest" }, priority = 95)
	public void verifyUserCanRemoveTheAddedProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanRemoveTheAddedPropertyTest(), "User is unable to remove property value");
	}

	@Test(groups = { "SmokeTest" }, priority = 96)
	public void verifyTheAvailabilityOfRemovedProperty() throws InterruptedException {
		Assert.assertTrue(mp.verifyTheAvailabilityOfRemovedPropertyTest(), "Property is not removed post removing");
	}

	@Test(groups = { "SmokeTest" }, priority = 97)
	public void verifyUserCanCreateTheTaskGroupNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyUserCanCreateTheTaskGroupNodeTest(),
				"User is unable to create the task group node ");
	}

	@Test(groups = { "SmokeTest" }, priority = 98)
	public void verifyTaskNodeCreationInTaskGroup() throws InterruptedException {
		Assert.assertTrue(mp.verifyTaskNodeCreationInTaskGroupTest(),
				"User is unable to creat the task node inside task group node / Wrong toaster message is displaying");
	}

	@Test(groups = { "SmokeTest" }, priority = 99)
	public void verifyParentNodeCloneWithChildNode() throws InterruptedException {
		Assert.assertTrue(mp.verifyParentNodeCloneWithChildNodeTest(),
				"User is unable to clone parent node with child nodes");
	}

	@Test(groups = { "SmokeTest" }, priority = 100)
	public void verifyClonedNodeAvailability() throws InterruptedException {
		Assert.assertTrue(mp.verifyClonedNodeAvailabilityTest(), "Cloned Parent node is not available");
	}

	@Test(groups = { "SmokeTest" }, priority = 101)
	public void verifyChildNodeNameInClonedParent() throws InterruptedException {
		Assert.assertTrue(mp.verifyChildNodeNameInClonedParentTest(),
				"child node not have _copy prefix / child node is not available ");
	}

}
