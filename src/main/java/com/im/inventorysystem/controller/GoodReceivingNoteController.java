package com.im.inventorysystem.controller;

import com.im.inventorysystem.dto.GRNDto;
import com.im.inventorysystem.dto.GRNDtos;
import com.im.inventorysystem.service.GoodReceivingNoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class GoodReceivingNoteController {
    private final GoodReceivingNoteService goodReceivingNoteService;

    public GoodReceivingNoteController(GoodReceivingNoteService goodReceivingNoteService) {
        this.goodReceivingNoteService = goodReceivingNoteService;
    }

    @PostMapping("/grn")
    public ResponseEntity<?> add(@RequestBody GRNDto grnDto) {
        return ResponseEntity.ok(goodReceivingNoteService.saveGoodReceivingNote(grnDto));
    }

    @GetMapping("/grns")
    public ResponseEntity<GRNDtos> getAllGoodReceivingNotes() {
        return ResponseEntity.ok(goodReceivingNoteService.getAllGoodReceivingNotes());
    }
}
