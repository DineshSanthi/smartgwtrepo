package com.mots.repo.depo.framework.client.grid;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionStyle;

public class ResultsListGrid extends AbstractListGrid{
	
	public ResultsListGrid(DataSource resultsDS) {
        setShowHeader(false);
        setLeaveScrollbarGap(false);
        setAnimateFolders(true);
        setCanAcceptDroppedRecords(true);
        setSelectionType(SelectionStyle.SINGLE);
        setDataSource(resultsDS);
    }
}
