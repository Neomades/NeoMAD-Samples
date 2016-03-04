<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>IconsExample</mainclassname>
		<applicationname>IconsExample</applicationname>
		<packagename>com.neomades.iconsexample</packagename>
		<description>Icons application example.</description>

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
</urs>
