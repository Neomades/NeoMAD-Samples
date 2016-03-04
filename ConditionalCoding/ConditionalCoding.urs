<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>ConditionalCoding</mainclassname>
		<applicationname>ConditionalCoding</applicationname>
		<description>Conditional Coding application example.</description>
		<packagename>com.neomades.conditionalcoding</packagename>

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
		<image name="IMAGE_SUN" path="res/${RESOLUTION}/sun.png" />
		<image name="IMAGE_MOON" condition="SAY_GOODBYE" path="res/${RESOLUTION}/moon.png" />
	</resourcelot>
</urs>
