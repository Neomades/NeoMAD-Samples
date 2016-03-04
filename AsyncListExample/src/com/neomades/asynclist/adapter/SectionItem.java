package com.neomades.asynclist.adapter;

import com.neomades.asynclist.Fonts;
import com.neomades.asynclist.Res;
import com.neomades.asynclist.adapter.base.ListViewItem;
import com.neomades.asynclist.model.Section;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;

public class SectionItem implements ListViewItem {

	private View view;

	private TextLabel titleTextLabel;

	public SectionItem() {
		view = View.inflateXML(Res.layout.SECTION);
		titleTextLabel = (TextLabel) view.findView(Res.id.section_title);
		titleTextLabel.setFont(Fonts.itemTitleFont);
	}

	public void update(Object p) {
		this.titleTextLabel.setText(((Section) p).getName());
	}

	public View getView() {
		return view;
	}

}
