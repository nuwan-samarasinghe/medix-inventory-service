package com.im.inventorysystem.repository;

import com.im.inventorysystem.repository.model.GoodReceivingNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodReceivingNoteRepository extends JpaRepository<GoodReceivingNote,Integer> {
}
