<?xml version="1.0"?>

<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>AnimationApplication</mainclassname>
		<applicationname>Animation Example</applicationname>
		<packagename>com.neomades.animationexample</packagename>

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

	<resourcelot>
		<layout name="ANIMATION_LAYOUT" path="res/layout/animation_layout.xml"/>
		<layout name="NOT_SUPPORTED_LAYOUT" path="res/layout/not_supported_layout.xml"/>

		<image name="BUG" path="res/images/bug.png"/>
		<image name="PLATE_CHEESE" path="res/images/plate_cheese.png"/>
		<image name="DOOR_TOP" path="res/images/door_top.png"/>
		<image name="DOOR_BOTTOM" path="res/images/door_bottom.png"/>
		<image name="FABRIC_TOP" path="res/images/fabric_top.png"/>
		<image name="FABRIC_BOTTOM" path="res/images/fabric_bottom.png"/>
	</resourcelot>

	<strings path="res/strings.csv" />
</urs>
