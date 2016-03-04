<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>TabScreenExample</mainclassname>
		<applicationname>TabScreenExample</applicationname>
		<description>TabScreenExample application example.</description>
		<packagename>com.neomades.tabscreenexample</packagename>

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

	<strings path="res/strings.csv" />

	<resourcelot>
		<layout name="TAB_SUB_SCREEN" path="res/layout/tab_sub_screen.xml" />
		<layout name="SCREEN_WITH_BUTTON" path="res/layout/screen_with_button.xml" />
		<layout name="NOT_SUPPORTED_LAYOUT" path="res/layout/not_supported_layout.xml" />
	</resourcelot>
</urs>
