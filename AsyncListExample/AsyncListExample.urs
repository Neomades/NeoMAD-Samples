<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>AsyncListApplication</mainclassname>
		<applicationname>AsyncListExample</applicationname>
		<description>AsyncListExample application example.</description>
		<packagename>com.neomades.asynclist</packagename>

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
		<layout name="ITEM" path="res/layout/item.xml" />
		<layout name="SECTION" path="res/layout/section.xml" />
		<layout name="ASYNC_LIST_SCREEN" path="res/layout/async_list_screen.xml" />

		<image name="ITEM_NO_PICTURE" path="res/image/item_no_picture.png" />
	</resourcelot>

</urs>
