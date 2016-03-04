<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>SlideMenuExample</mainclassname>
		<applicationname>SlideMenu</applicationname>
		<vendor>Neomades</vendor>
		<description>SlideMenu application example.</description>
		<packagename>com.neomades.slidemenuexample</packagename>

		<!-- Icon images are organized in platform directories in the res folder.
			See the Constants class for the declaration of the ICON_PATH constant. -->
		<icon path="@icon/icon">
			<windowsphone tilebackgroundpath="res/icon-windowsphone/icon-173.png" />
		</icon>

		<version>1.0.0</version>
		<srcpath>src</srcpath>
		<outputpath>out</outputpath>
	</parameters>

	<strings path="res/strings.csv" />
	
	<resourcelot>
		<layout name="MAIN_SCREEN" path="res/layout/main_screen.xml" />
		<layout name="SLIDING_ITEM" path="res/layout/sliding_item.xml" />
		<layout name="NOT_SUPPORTED_LAYOUT" path="res/layout/not_supported_layout.xml" />
		
		<image name="ic_home" path="res/image/ic_home.png" />
		<image name="ic_people" path="res/image/ic_people.png" />
		<image name="ic_photos" path="res/image/ic_photos.png" />
		<image name="ic_about" path="res/image/ic_about.png" />
	</resourcelot>
</urs>
