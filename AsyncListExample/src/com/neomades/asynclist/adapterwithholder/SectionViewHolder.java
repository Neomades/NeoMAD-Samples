package com.neomades.asynclist.adapterwithholder;

import com.neomades.asynclist.Fonts;
import com.neomades.asynclist.Res;
import com.neomades.asynclist.model.Section;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;

public class SectionViewHolder {

	public TextLabel titleTextLabel;
	public Section model;

	public static View buildConvertView() {
		View convertView;
		convertView = View.inflateXML(Res.layout.SECTION);
		SectionViewHolder holder = new SectionViewHolder();
		convertView.setTag(holder);

		holder.titleTextLabel = (TextLabel) convertView.findView(Res.id.section_title);
		holder.titleTextLabel.setFont(Fonts.itemTitleFont);
		return convertView;
	}

	public void updateView(Section model) {
		this.model = model;
		this.titleTextLabel.setText(model.getName());
	}

}
