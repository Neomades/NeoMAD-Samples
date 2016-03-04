<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>LocationExample</mainclassname>
		<applicationname>LocationExample</applicationname>
		<description>LocationExample application example.</description>
		<packagename>com.neomades.locationexample</packagename>

		<!-- Icon images are organized in platform directories in the res folder.
			See the Constants class for the declaration of the ICON_PATH constant. -->
		<icon path="@icon/icon">
			<windowsphone tilebackgroundpath="res/icon-windowsphone/icon-173.png" />
		</icon>

		<vendor>Neomades</vendor>
		<version>1.0.0</version>
		<srcpath>src</srcpath>
		<outputpath>out</outputpath>
	</parameters>

	<permissions>
		<permission name="LOCATION" />
		<permission name="LOCATION_PROXIMITY" />
		<permission name="LOCAL_NOTIFICATION" />
	</permissions>
	
	<location requestWhenInUseDescription="LocationExample will use your position to demonstrate the capabilities of the NeoMAD Location API."/>

	<strings path="res/strings.csv" />

	<resourcelot>
		<layout name="MAIN_SCREEN" path="/res/layout/main_screen.xml" />
		<layout name="CRITERIA_DETAILS_SCREEN" path="/res/layout/criteria_details_screen.xml" />
		<layout name="LOCATION_SCREEN" path="/res/layout/location_screen.xml" />
		<layout name="PROXIMITY_REGION_LIST_SCREEN" path="/res/layout/proximity_region_list_screen.xml" />
		<layout name="PROXIMITY_REGION_DETAILS_SCREEN" path="/res/layout/proximity_region_details_screen.xml" />
		<layout name="PROXIMITY_SCREEN" path="/res/layout/proximity_screen.xml" />
		<layout name="NOT_SUPPORTED_LAYOUT" path="/res/layout/not_supported_layout.xml" />
	</resourcelot>
</urs>
