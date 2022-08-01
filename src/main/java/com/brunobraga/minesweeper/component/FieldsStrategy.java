package com.brunobraga.minesweeper.component;


enum FieldsStrategy {

    //STATUS
    LOCATION() {
        @Override
        void execute(CrudActionEnumStrategy crudActionEnumStrategy) {
            ComponentProducerLocation;

        }
    },
    TIMETRAKKING() {
        @Override
        void execute(CrudActionEnumStrategy crudActionEnumStrategy) {
            //cOMPONENTENT TT - topic xxxx
        }
    },
    LOCATION_TIMETRAKKING(){
       // ComponentLocationTT()

    };

    abstract void execute(FieldsStrategy fieldsStrategy);
}