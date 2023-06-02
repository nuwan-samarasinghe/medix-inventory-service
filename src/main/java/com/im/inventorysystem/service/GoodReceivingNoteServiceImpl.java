package com.im.inventorysystem.service;

import com.im.inventorysystem.dto.GRNDtos;
import com.im.inventorysystem.dto.GRNItemDto;
import com.im.inventorysystem.dto.GRNDto;
import com.im.inventorysystem.repository.model.GoodReceivingNote;
import com.im.inventorysystem.repository.GoodReceivingNoteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodReceivingNoteServiceImpl implements GoodReceivingNoteService {
    //inject repository in to the service class
    @Autowired
    private GoodReceivingNoteRepository goodReceivingNoteRepository;

    @Override
    public GRNDtos getAllGoodReceivingNotes() {
        Map<String, List<GoodReceivingNote>> listMap = new HashMap<>();
        goodReceivingNoteRepository.findAll().forEach(goodReceivingNote -> {
            if (Objects.isNull(listMap.get(goodReceivingNote.getPoNo()))) {
                List<GoodReceivingNote> notes = new ArrayList<>();
                notes.add(goodReceivingNote);
                listMap.put(goodReceivingNote.getPoNo(), notes);
            } else {
                listMap.get(goodReceivingNote.getPoNo()).add(goodReceivingNote);
            }
        });
        GRNDtos grnDtos = new GRNDtos();
        grnDtos.setGrns(new ArrayList<>());
        listMap.forEach((integer, goodReceivingNotes) -> grnDtos.getGrns().add(convertModelToDto(goodReceivingNotes)));
        return grnDtos;
    }

    @Override
    public GRNDto saveGoodReceivingNote(GRNDto grnDto) {
        List<GoodReceivingNote> notes = new ArrayList<>();
        convertDtoToModel(grnDto, notes);
        List<GoodReceivingNote> savedGoodReceivingNotes = goodReceivingNoteRepository.saveAll(notes);
        return convertModelToDto(savedGoodReceivingNotes);
    }

    private static GRNDto convertModelToDto(List<GoodReceivingNote> savedGoodReceivingNotes) {
        GRNDto grn = new GRNDto();
        grn.setItemRequests(new ArrayList<>());
        savedGoodReceivingNotes.forEach(goodReceivingNote -> {
            GRNItemDto grnItemDto = new GRNItemDto();
            ModelMapper mapper = new ModelMapper();
            mapper.addMappings(new PropertyMap<GoodReceivingNote, GRNItemDto>() {
                @Override
                protected void configure() {
                }
            });
            mapper.map(goodReceivingNote, grnItemDto);
            grn.getItemRequests().add(grnItemDto);
            grn.setPoNo(goodReceivingNote.getPoNo());
            grn.setSupplierName(goodReceivingNote.getSupplierName());
            grn.setGrcnId(goodReceivingNote.getGrcnId().toString());
        });
        return grn;
    }

    private static void convertDtoToModel(GRNDto grnDto, List<GoodReceivingNote> notes) {
        grnDto.getItemRequests().forEach(grnItemDto -> {
            GoodReceivingNote goodReceivingNote = new GoodReceivingNote();
            ModelMapper mapper = new ModelMapper();
            mapper.addMappings(new PropertyMap<GRNItemDto, GoodReceivingNote>() {
                @Override
                protected void configure() {
                }
            });
            mapper.map(grnItemDto, goodReceivingNote);
            notes.add(goodReceivingNote);
            goodReceivingNote.setSupplierName(grnDto.getSupplierName());
            goodReceivingNote.setPoNo(grnDto.getPoNo());
        });
    }
}

