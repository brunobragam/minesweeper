package com.brunobraga.minesweeper.component;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.List;

@Getter
public class DispatchMessageLocationDto {

    String EventType;
    Integer DbVersion;
    Integer FieldXloc;
    Integer FieldYloc;
    Integer FieldZloc;
    Integer FieldSignid;
    Integer FieldRadius;
    Integer FieldPit;
    Integer FieldRegion;
    Integer FieldDumpqueue;
    Integer FieldShoptype;

    Integer status;
    Integer reason;




    public DispatchMessageLocationDto(String eventType, Integer dbVersion, Integer fieldXloc, Integer fieldYloc, Integer fieldZloc, Integer fieldSignid, Integer fieldRadius, Integer fieldPit, Integer fieldRegion, Integer fieldDumpqueue, Integer fieldShoptype) {
        EventType = eventType;
        DbVersion = dbVersion;
        FieldXloc = fieldXloc;
        FieldYloc = fieldYloc;
        FieldZloc = fieldZloc;
        FieldSignid = fieldSignid;
        FieldRadius = fieldRadius;
        FieldPit = fieldPit;
        FieldRegion = fieldRegion;
        FieldDumpqueue = fieldDumpqueue;
        FieldShoptype = fieldShoptype;
    }

    public String getFields(){

        // foreach nos campos da classe
        //retornar uma concatenacao
        set selectdomain;
        EnumMap<FieldsStrategy, List<String>> = "LOCATION, <FieldZloc,FieldDumpqueue> ";
        return "reason"+"_"+"status";
    }

}
enum ContextDomain{

    LOCATION,
    TIMETRAKKING,
    DUMPING;
}
