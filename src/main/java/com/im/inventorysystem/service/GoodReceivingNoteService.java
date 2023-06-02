package com.im.inventorysystem.service;

import com.im.inventorysystem.dto.GRNDto;
import com.im.inventorysystem.dto.GRNDtos;
import com.im.inventorysystem.repository.model.GoodReceivingNote;

import java.util.List;

public interface GoodReceivingNoteService {
    //save the goods received
    public GRNDto saveGoodReceivingNote(GRNDto grnDto);

    //get the list of goods received
    public GRNDtos getAllGoodReceivingNotes();
}
