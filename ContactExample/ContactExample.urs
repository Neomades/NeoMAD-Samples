<?xml version="1.0"?>

<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>ContactExample</mainclassname>
		<applicationname>ContactExample</applicationname>
		<packagename>com.neomades.contactexample</packagename>

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
		<permission name="READ_CONTACTS" />
		<permission name="WRITE_CONTACTS" />
	</permissions>

	<!-- layouts -->
	<resourcelot>
		<layout name="CONTACT_MANAGER_SCREEN" path="res/layouts/contact_manager_screen.xml" />
		<layout name="NOT_SUPPORTED_LAYOUT" path="res/layouts/not_supported_layout.xml" />

		<layout name="PICK_CONTACT_SCREEN" path="res/layouts/pick_contact_screen.xml" />
		<layout name="ADD_CONTACT_SCREEN" path="res/layouts/add_contact_screen.xml" />
		<layout name="SHOW_CONTACT_SCREEN" path="res/layouts/show_contact_screen.xml" />
		<layout name="EDIT_CONTACT_SCREEN" path="res/layouts/edit_contact_screen.xml" />
		<layout name="SAVE_CONTACT_SCREEN" path="res/layouts/save_contact_screen.xml" />
		<layout name="GET_ALL_CONTACTS_SCREEN" path="res/layouts/get_all_contacts_screen.xml" />
		<layout name="LIST_ITEM_VIEW" path="res/layouts/list_item_view.xml" />
		<layout name="CONTACT_DETAILS_SCREEN" path="res/layouts/contact_details_screen.xml" />
		<layout name="DELETE_CONTACT_SCREEN" path="res/layouts/delete_contact_screen.xml" />
		<layout name="CONTACT_EDITOR_SCREEN" path="res/layouts/contact_editor_screen.xml" />
		<layout name="CONTACTS_LIST_SCREEN" path="res/layouts/contacts_list_screen.xml" />
	</resourcelot>

	<strings path="res/strings.csv" />
</urs>
