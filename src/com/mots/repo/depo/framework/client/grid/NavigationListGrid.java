package com.mots.repo.depo.framework.client.grid;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

public class NavigationListGrid extends AbstractListGrid{
	
	public NavigationListGrid(DataSource navigationDS) {
        setShowHeader(false);
        setLeaveScrollbarGap(false);
        setAnimateFolders(true);
        setCanAcceptDroppedRecords(true);
        setSelectionType(SelectionStyle.SINGLE);
        setDataSource(navigationDS);
    }
}
